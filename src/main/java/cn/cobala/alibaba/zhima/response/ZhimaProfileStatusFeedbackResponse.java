package cn.cobala.alibaba.zhima.response;

import cn.cobala.alibaba.zhima.openplatform.ZhimaResponse;
import cn.cobala.alibaba.zhima.openplatform.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.profile.status.feedback response.
 * 
 * @author auto create
 * @since 1.0, 2016-03-31 14:36:04
 */
public class ZhimaProfileStatusFeedbackResponse extends ZhimaResponse {

	private static final long serialVersionUID = 2629573153785215272L;

	/** 
	 * 业务处理结果
	 */
	@ApiField("biz_success")
	private Boolean bizSuccess;

	public void setBizSuccess(Boolean bizSuccess) {
		this.bizSuccess = bizSuccess;
	}
	public Boolean getBizSuccess( ) {
		return this.bizSuccess;
	}

}
