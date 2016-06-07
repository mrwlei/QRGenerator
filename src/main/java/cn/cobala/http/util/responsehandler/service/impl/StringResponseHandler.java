package cn.cobala.http.util.responsehandler.service.impl;

import java.nio.charset.Charset;

import org.apache.http.Consts;

import cn.cobala.http.util.responsehandler.service.ResponseHandler;

public class StringResponseHandler implements ResponseHandler {

	public Object handle(Object responseObj) {
		byte[] bObj = (byte[]) responseObj;
		return new String(bObj, Consts.UTF_8);
	}

	public boolean accept(Object responseObj) {
		if (responseObj instanceof byte[]) {
			return true;
		}
		return false;
	}

	public Object handle(Object responseObj, Charset charset) {
		byte[] bObj = (byte[]) responseObj;
		return new String(bObj, charset);
	}
}
