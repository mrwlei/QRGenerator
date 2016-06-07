package cn.cobala.http.util.responsehandler.chian;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import cn.cobala.http.util.responsehandler.service.ResponseHandler;
import cn.cobala.http.util.responsehandler.service.impl.StringResponseHandler;


public class ResponseHandlerChain {

	private List<ResponseHandler> handlers;

	private ResponseHandlerChain() {
		handlers = new LinkedList<ResponseHandler>();
	}

	public ResponseHandlerChain register(ResponseHandler handler) {
		handlers.add(handler);
		return this;
	}

	public ResponseHandlerChain remove(ResponseHandler handler) {
		handlers.remove(handler);
		return this;
	}

	public ResponseHandlerChain remove(int i) {
		if (i > 0 && i < handlers.size()) {
			handlers.remove(i);
		}
		return this;
	}

	public ResponseHandlerChain replace(ResponseHandler oldHandler, ResponseHandler newHandler) {
		if (handlers.contains(oldHandler)) {
			int i = handlers.indexOf(oldHandler);
			remove(i);
			handlers.add(i, newHandler);
		}
		return this;
	}

	public Object handle(HttpResponse response) {

		Object result = null;
		try {
			result = EntityUtils.toByteArray(response.getEntity());
			Charset charset = null;
			for (ResponseHandler handler : handlers) {
				if (handler.accept(result)) {
					if (handler instanceof StringResponseHandler) {
						charset = charset == null ? getCharset(response) : charset;
						result = ((StringResponseHandler) handler).handle(result, charset);
					} else {
						result = handler.handle(result);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static ResponseHandlerChain create() {
		return new ResponseHandlerChain();
	}

	private Charset getCharset(HttpResponse response) {
		Charset charset = Consts.UTF_8;
		try {
			Header[] headers = response.getHeaders("Content-Type");
			for (Header header : headers) {
				String value = header.getValue().toUpperCase();
				if (value.toUpperCase().contains("UTF-8")) {
					break;
				}
				if (value.toUpperCase().contains("ISO-8859-1")) {
					charset = Consts.ISO_8859_1;
				}
			}
		} catch (Exception e) {
			return Consts.UTF_8;
		}
		return charset;
	}

}
