package cn.cobala.http.util.responsehandler.service.impl;

import cn.cobala.http.util.responsehandler.service.ResponseHandler;

/**
 * 返回结果转换成json
 * Title:JsonResponseHandler
 * @Description:
 * @Create_by:翟春龙
 * @Create_date:2015年11月30日
 * @Last_Edit_By:
 * @Edit_Description:
 * @version:analysis.provider 1.0
 */
public class JsonResponseHandler implements ResponseHandler {

	public Object handle(Object responseObj) {
		
		return responseObj;
	}

	public boolean accept(Object responseObj) {
		if(responseObj instanceof String){
			return true;
		}
		return false;
	}
}
