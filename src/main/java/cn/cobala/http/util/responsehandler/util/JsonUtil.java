package cn.cobala.http.util.responsehandler.util;

import java.io.IOException;
import java.io.StringWriter;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class JsonUtil {
	
	public static String beanToJson(Object obj) {
		StringWriter writer = null;
		JsonGenerator gen = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			writer = new StringWriter();
			gen = new JsonFactory().createJsonGenerator(writer);
			mapper.writeValue(gen, obj);
			String json = writer.toString();
			return json;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (gen != null) {
				try {
					gen.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public static Object jsonToBean(String json, Class<?> cls) {
		ObjectMapper mapper = new ObjectMapper();
		Object vo;
		try {
			vo = mapper.readValue(json, cls);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return vo;
	}
	
	/**
	 * 
	 * json to bean
	 * jsonToBean("{}", new TypeReference<Map<String,User>>(){});
	 */
	public static Object jsonToBean(String json, TypeReference<?> type) {
		ObjectMapper mapper = new ObjectMapper();
		Object vo;
		try {
			vo = mapper.readValue(json, type);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return vo;
	}
}
