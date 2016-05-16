package cn.cobala.weixin.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import cn.cobala.weixin.client.TenpayHttpClient;


public class WxUtilEx {

	public static final String CHARSET = "UTF-8";
	
	private static final String POST_URL_UNIFIEDORDER = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	private static final String POST_URL_ORDERQUERY = "https://api.mch.weixin.qq.com/pay/orderquery";
	
	private static final String POST_URL_REFUND = "https://api.mch.weixin.qq.com/secapi/pay/refund";
	
	/**
	 * 统一下单
	 * @throws Exception
	 */
	public static Map postUnifiedOrder(Map map) throws Exception {
		return postXmlData(POST_URL_UNIFIEDORDER, map);
	}
	
	/**
	 * 订单查询
	 * @throws Exception
	 */
	public static Map postOrderQuery(Map map) throws Exception {
		return postXmlData(POST_URL_ORDERQUERY, map);
	}
	
	/**
	 * 退款
	 * @throws Exception
	 */
	public static Map postOrderRefund(Map map) throws Exception {
		return postXmlData(POST_URL_REFUND,map);
	}
	
	public static void formatMapObject(Map map) {
		Set es = map.entrySet();
		Iterator it = es.iterator();
		List<String> remove_key_list = new ArrayList<String>();

		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();

			if (null == v || v.length() < 1) {
				remove_key_list.add(k);
			}
		}
		
		for(String key : remove_key_list){
			map.remove(key);
		}
	}
	
	public static Map xmlString2Map(String xml) throws Exception {
		Map map = new HashMap();

		if (null == xml || xml.trim().length() < 1) {
			return map;
		}

		ByteArrayInputStream bais = new ByteArrayInputStream(xml.getBytes(CHARSET));
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(bais);
		Element root = doc.getRootElement();
		List list = root.getChildren();
		Iterator it = list.iterator();

		Element e = null;
		String k = null;
		String v = null;

		while (it.hasNext()) {
			e = (Element) it.next();
			k = e.getName();
			v = e.getTextNormalize();

			map.put(k, v);
		}

		return map;
	}

	public static String map2QueryString(Map map) {

		StringBuffer sb = new StringBuffer();

		SortedMap<String, String> temp_map = new TreeMap<String, String>(map);
		temp_map.remove("key");
		temp_map.remove("sign");

		Set es = temp_map.entrySet();
		Iterator it = es.iterator();

		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();

			if (null == v || v.length() < 1) {
				continue;
			}

			if (sb.length() > 0) {
				sb.append("&");
			}

			sb.append(k);
			sb.append("=");
			sb.append(v);
		}

		return sb.toString();
	}

	public static Map requestStream2Map(HttpServletRequest request) throws Exception {
		String str = requestStream2String(request);
		return xmlString2Map(str);
	}

	private static String requestStream2String(HttpServletRequest request) throws Exception {

		InputStream is = request.getInputStream();
		String charset = request.getCharacterEncoding();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, charset));

		StringBuffer sb = new StringBuffer();
		String line = br.readLine();
		while (line != null) {
			sb.append(line);
			sb.append("\r\n");

			line = br.readLine();
		}

		br.close();
		is.close();

		return sb.toString();
	}

	public static String map2XmlString(Map map) throws Exception {

		Element root = new Element("xml");
		Document document = new Document(root);

		Set es = map.entrySet();
		Iterator it = es.iterator();
		Map.Entry entry = null;
		String k = null;
		String v = null;
		Element elements = null;

		while (it.hasNext()) {
			entry = (Map.Entry) it.next();

			k = (String) entry.getKey();
			v = (String) entry.getValue();

			elements = new Element(k);
			elements.setText(v);

			root.addContent(elements);
		}

		Format format = Format.getPrettyFormat();
		format.setEncoding(CHARSET);//解决中文乱码问题
		XMLOutputter xmlout = new XMLOutputter(format);
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		xmlout.output(document, bo);

		return bo.toString(CHARSET);
	}

	public static String makeSignWithMd5(String data, String key) {
		data = data + "&key=" + key;
		String sign = MD5Util.MD5Encode(data, CHARSET).toUpperCase();

		System.out.println("\n>>>>>>>>>> raw String \n" + data);
		
		return sign;
	}

	public static String makeSignWithMd5(Map map, String key) {

		String data = map2QueryString(map);
		String sign = makeSignWithMd5(data, key);

		return sign;
	}

	public static void signMapWithMd5(Map map, String key) {

		formatMapObject(map);
		String sign = makeSignWithMd5(map, key);

		map.remove("key");//防止key被存储
		map.put("sign", sign);
	}

	public static boolean compareSign(String signA, String signB) {
		if (signA != null && signB != null && signA.equals(signB)) {
			return true;
		}
		return false;
	}

	public static boolean checkMapSign(Map map, String key) {

		String old_sign = (String) map.get("sign");
		String new_sign = makeSignWithMd5(map, key);

		return compareSign(new_sign, old_sign);
	}

	public static Map postXmlData(String url, Map map) throws Exception {

		Map<String, String> return_map = new HashMap();
		
		TenpayHttpClient thc = new TenpayHttpClient();
		Field field = TenpayHttpClient.class.getDeclaredField("charset");
		field.setAccessible(true);
		field.set(thc, CHARSET);
		String post_data = map2XmlString(map);
		
		System.out.println("\n>>>>>> post_data \n" + post_data);

		if (thc.callHttpPost(url, post_data)) {
			String return_data = thc.getResContent();
			
			System.out.println("\n>>>>>> return_data \n" + return_data);
			
			return_map = xmlString2Map(return_data);
		} else {
			throw new Exception("postXmlData error!!! " + url);
		}

		return return_map;
	}

	public static String getCurrentTime() {
		return TenpayUtil.getCurrTime();
	}

	public static String getTimeStamp() {
		return String.valueOf(TenpayUtil.getUnixTime(new Date()));
	}

}