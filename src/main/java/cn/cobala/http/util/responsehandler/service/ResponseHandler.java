package cn.cobala.http.util.responsehandler.service;

/**
 * 管道
 * Title:ResponseHandler
 * @Description:
 * @Create_by:翟春龙
 * @Create_date:2015年11月30日
 * @Last_Edit_By:
 * @Edit_Description:
 * @version:analysis.provider 1.0
 */
public interface ResponseHandler {
	
	public Object handle(Object responseObj);

	public boolean accept(Object responseObj);
}
