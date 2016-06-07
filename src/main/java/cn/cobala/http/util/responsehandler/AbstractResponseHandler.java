package cn.cobala.http.util.responsehandler;

import cn.cobala.http.util.responsehandler.service.ResponseHandler;

/**
 * 处理返回结果
 * Title:AbstractResponseHandler
 * @Description:
 * @Create_by:翟春龙
 * @Create_date:2015年11月30日
 * @Last_Edit_By:
 * @Edit_Description:
 * @version:analysis.provider 1.0
 */
public abstract class AbstractResponseHandler implements ResponseHandler {
	
	protected ResponseHandler nextHandler;
	
	public AbstractResponseHandler(){
		nextHandler = null;
	}
	
	public AbstractResponseHandler(ResponseHandler handler){
		this.nextHandler = handler;
	}
	
}
