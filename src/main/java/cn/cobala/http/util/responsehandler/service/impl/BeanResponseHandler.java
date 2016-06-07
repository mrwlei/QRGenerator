package cn.cobala.http.util.responsehandler.service.impl;

import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.cobala.http.util.responsehandler.service.ResponseHandler;
import cn.cobala.http.util.responsehandler.util.JsonUtil;


public class BeanResponseHandler implements ResponseHandler{

	private Logger logger=LoggerFactory.getLogger(BeanResponseHandler.class);
	
	private Class<?> clazz;
	private TypeReference<?> type;
	
	private JsonToken startToken;

	/**
	 * Used for POJO
	 * @param Class<?>
	 */
	public BeanResponseHandler(Class<?> c){
		clazz = c;
	}

	/**
	 * Used for List<Class>, Map<String, Class> types
	 * e.g. List<User>, Map<String, User>, you can just create new TypeReference<Map<String,User>>() { } or new TypeReference<List<User>>() { }
	 * @param TypeReference<?>
	 */
	public BeanResponseHandler(TypeReference<?> c){
		type = c;
	}
	
	public BeanResponseHandler(){
		clazz = null;
	}
	
	public Object handle(Object responseObj) {
		if(clazz == null && type == null){
			if(startToken == JsonToken.START_ARRAY){
				clazz = List.class;
			}else{
				clazz = Map.class;
			}
		}
		try {
			if(clazz != null){
				return JsonUtil.jsonToBean((String)responseObj, clazz);
			}else{
				return JsonUtil.jsonToBean((String)responseObj, type);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return null;
	}

	public boolean accept(Object responseObj) {
		if(responseObj instanceof String){
			try {
				JsonFactory f = new JsonFactory();
				JsonParser jp = f.createJsonParser((String)responseObj);
				startToken = jp.nextToken();
				if(startToken == JsonToken.START_ARRAY || startToken == JsonToken.START_OBJECT){
					return true;
				}
			} catch (Exception e) {
				logger.error(e.getMessage(),e);
			}
		}
		return false;
	}

}
