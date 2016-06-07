package cn.cobala.http.util;

import java.io.IOException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.cobala.http.util.responsehandler.chian.ResponseHandlerChain;

public class HttpRequestCaller {

	private Map<String, String> headers;
	private ResponseHandlerChain responseChain;
	
	private CookieStore cookieStore;
	private HttpClientContext context;
	
	private static final Logger logger = LoggerFactory.getLogger(HttpRequestCaller.class);

	protected HttpRequestCaller(ResponseHandlerChain responseChain){
		headers = new HashMap<String, String>();
		if(responseChain == null){
			this.responseChain = ResponseHandlerChain.create();
		}else{
			this.responseChain = responseChain;
		}
		
		cookieStore = new BasicCookieStore();
		context = HttpClientContext.create();
		context.setCookieStore(cookieStore);
	}

	public static HttpRequestCaller create(){
		return new HttpRequestCaller(null);
	}

	public static HttpRequestCaller create(ResponseHandlerChain responseChain){
		return new HttpRequestCaller(responseChain);
	}
	
	public Object request(String url, RequestMethod method){
		if(url == null){
			return null;
		}
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		return request(url, method, params);
	}
	/**
	 * Post an URL with parameters to get HTML content
	 * @author		Peak Zhang
	 * @param url 	URL to request
	 * @param method	Post or Get to request URL
	 * @param params 	formatted as name2=value2&name2=value2&name3=value3 ...
	 * @return 		HTML result
	 */
	public Object request(String url, RequestMethod method, String params){
		if(params == null || !params.contains("=")){
			return request(url, method);
		}
		List<NameValuePair>  nameValuePairs = URLEncodedUtils.parse(params, Consts.UTF_8);
		return request(url, method, nameValuePairs);
	}
	
	public Object request(String url, RequestMethod method, Map<String, String> params){
		if(params == null || params.isEmpty()){
			return request(url, method);
		}
		List<NameValuePair>  nameValuePairs = new ArrayList<NameValuePair>();
		for(String key : params.keySet()){
			NameValuePair pair = new BasicNameValuePair(key, params.get(key));
			nameValuePairs.add(pair);
		}
		return request(url, method, nameValuePairs);
	}
	
	public Object request(String url, RequestMethod method, List<NameValuePair> params){
		Object result = request(url, method, params, null);
		return result;
	}	
	public Object request(String url, RequestMethod method, byte[] body){
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		Object result = request(url, method, params, body);
		return result;
	}
	public Object request(String url, Map<String, String> params,String filename,byte [] fileBytes){
		if(filename==null || filename.isEmpty() || fileBytes==null || fileBytes.length==0 || url.contains("?")){
			return null;
		}
		List<NameValuePair> nameValuePairs= new ArrayList<NameValuePair>();;
		if(params != null && !params.isEmpty()){
			nameValuePairs = new ArrayList<NameValuePair>();
			for(String key : params.keySet()){
				NameValuePair pair = new BasicNameValuePair(key, params.get(key));
				nameValuePairs.add(pair);
			}			
		}
		Object result = request(url, RequestMethod.POST, nameValuePairs, null, filename, fileBytes);
		return result;
	}
	public Object request(String url, String params,String filename,byte [] fileBytes){
		if(filename==null || filename.isEmpty() || fileBytes==null || fileBytes.length==0 || url.contains("?")){
			return null;
		}
		List<NameValuePair> nameValuePairs= new ArrayList<NameValuePair>();;
		if(params != null && !params.isEmpty()){
			nameValuePairs = URLEncodedUtils.parse(params, Consts.UTF_8);
		}
		Object result = request(url, RequestMethod.POST, nameValuePairs, null, filename, fileBytes);
		return result;
	}
	
	protected Object request(String url, RequestMethod method, List<NameValuePair>  params, byte[] body){
		return this.request(url, method, params, body,null, null);
	}
	
	protected Object request(String url, RequestMethod method, List<NameValuePair>  params, byte[] body,String filename,byte [] fileBytes){
		if(url == null){
	        return null;
	    }
		if(url.contains("?")){
			try {
				List<NameValuePair>  parsOfUrl = URLEncodedUtils.parse(url.substring(url.lastIndexOf("?")+1, url.length()), Consts.UTF_8);
				String parStr = EntityUtils.toString(new UrlEncodedFormEntity(parsOfUrl));
				url = url.substring(0, url.indexOf("?"));
				url = url + "?" + parStr;
				//logger.info("RequestUrl: "+url);
			} catch (Exception e) {
				logger.error(e.getMessage(),e);
			}
		}
		
		//logger.debug("Request: " + url);
		
		HttpRequestBase request = null;
		if(method != null && method.equals(RequestMethod.POST)){
			HttpPost post = new HttpPost(url);
			//upload file
			if(filename!=null && fileBytes!=null){
				ByteArrayBody fileBody=new ByteArrayBody(fileBytes,filename);				
				MultipartEntityBuilder  multipartEntity = MultipartEntityBuilder.create();
				multipartEntity.addPart("file", fileBody);
			    if(params!=null && !params.isEmpty()){
			    	for(NameValuePair param:params){
			    		multipartEntity.addTextBody(param.getName(), param.getValue());
			    	}
			    }
			    post.setEntity(multipartEntity.build());
			    
			}else{
				if(body != null && body.length > 0){
					ByteArrayEntity entity = new ByteArrayEntity(body);
					post.setEntity(entity);
				}else if(params != null && params.size()>0){
					UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, Consts.UTF_8); 
					post.setEntity(entity);
				} 
			}
			request = post;
		}else if(method != null && method.equals(RequestMethod.GET)){
			String ur=getUrl(url,params);
			request = new HttpGet(ur);
		}else if(method!=null && method.equals(RequestMethod.DELETE)){
			request = new HttpDelete(getUrl(url,params));
		}else{
			request = new HttpGet(getUrl(url,params));
		}
		logger.info("RequestUrl: "+request.getURI());
		if(headers != null){
			for(String header:headers.keySet()){
				request.setHeader(header, headers.get(header));		
			}
		}
		
		CloseableHttpClient httpClient = null;
		HttpResponse response = null;
		try{
			if(url.toLowerCase().startsWith("https")){
				httpClient = createHttpsClient();
			}else{
				httpClient = createHttpClient();
			}
			
			response = httpClient.execute(request, context);
			
			HttpEntity entity = response.getEntity();
			
			if (entity != null) {
				//byte[] result = EntityUtils.toByteArray(entity);
				Object processedResult = responseChain.handle(response);
				return processedResult;
			}
		}catch(Exception e){
			logger.error(e.getMessage(),e);
		}finally{
			try {
				httpClient.close();
			} catch (IOException e) {
				logger.error(e.getMessage(),e);
			}
		}
		return null;
	}
	
	private String getUrl(String url,List<NameValuePair> params){
		if(params!=null && params.size()>0){
		/*	StringBuffer sb = new StringBuffer("");
			for(NameValuePair item:params){
				sb.append("&"+item.getName()+"="+item.getValue());
			}*/
			//+sb.toString();
			String  str=URLEncodedUtils.format(params, "utf-8");
			if(!url.contains("?")){
				//sb.replace(0, 1,"?");
				url=url+"?";
			}else if(!url.endsWith("&")){
				url=url+"&";
			}
			url=url+str;
		}
		return url;
	}
	
	private CloseableHttpClient createHttpsClient() {
		TrustManager truseAllManager = new X509TrustManager() {
			public void checkClientTrusted(X509Certificate[] arg0, String arg1) { }
			public void checkServerTrusted( X509Certificate[] arg0, String arg1) {}
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		};
		try {
			SSLContext sslContext = SSLContext.getInstance("TLS");
			sslContext.init(null, new TrustManager[] { truseAllManager }, null);
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory( sslContext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			return HttpClientBuilder.create()
					.setRedirectStrategy(new LaxRedirectStrategy())
					.setSSLSocketFactory(sslsf)
					.setDefaultCookieStore(cookieStore)
					.build();
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return null;
	}
    
	private CloseableHttpClient createHttpClient(){
		return HttpClientBuilder.create()
				.setRedirectStrategy(new LaxRedirectStrategy())
				.setDefaultCookieStore(cookieStore)
				.build();
	}
	
	public HttpRequestCaller setHeaders(Map<String, String> headers){
		if(headers != null){
			this.headers.putAll(headers);
		}
		return this;
	}
	
	public HttpRequestCaller setHeader(String key, String value){
		headers.put(key, value);
		return this;
	}
	
	public static enum RequestMethod{
		GET, POST, DELETE
	}
}
