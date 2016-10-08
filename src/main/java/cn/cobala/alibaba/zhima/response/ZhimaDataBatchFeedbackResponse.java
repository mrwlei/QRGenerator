package cn.cobala.alibaba.zhima.response;

import cn.cobala.alibaba.zhima.openplatform.ZhimaResponse;
import cn.cobala.alibaba.zhima.openplatform.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.data.batch.feedback response.
 * 
 * @author auto create
 * @since 1.0, 2016-08-01 16:12:33
 */
public class ZhimaDataBatchFeedbackResponse extends ZhimaResponse {

	private static final long serialVersionUID = 6278741793752384591L;

	/** 
	 * 
	 */
	@ApiField("biz_success")
	private String bizSuccess;

	public void setBizSuccess(String bizSuccess) {
		this.bizSuccess = bizSuccess;
	}
	public String getBizSuccess( ) {
		return this.bizSuccess;
	}

}
