package cn.cobala.http;

import org.junit.Test;

import cn.cobala.http.util.HttpRequestCaller;
import cn.cobala.http.util.responsehandler.chian.ResponseHandlerChain;
import cn.cobala.http.util.responsehandler.service.impl.StringResponseHandler;

public class HttpClientTest {
	
	@Test
	public void test() {
		
		ResponseHandlerChain rhc = ResponseHandlerChain.create().register(new StringResponseHandler());
		
		
		System.out.println((String)HttpRequestCaller.create(rhc).request("http://www.baidu.com", HttpRequestCaller.RequestMethod.GET));
		
		
	}
}
