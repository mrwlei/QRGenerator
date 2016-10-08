package cn.cobala.alibaba.zhima.response;

import cn.cobala.alibaba.zhima.openplatform.ZhimaResponse;
import cn.cobala.alibaba.zhima.openplatform.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.data.feedbackurl.query response.
 * 
 * @author auto create
 * @since 1.0, 2016-09-08 08:34:08
 */
public class ZhimaDataFeedbackurlQueryResponse extends ZhimaResponse {

	private static final long serialVersionUID = 1572389225898395727L;

	/** 
	 * 数据反馈模板
	 */
	@ApiField("feedback_url")
	private String feedbackUrl;

	public void setFeedbackUrl(String feedbackUrl) {
		this.feedbackUrl = feedbackUrl;
	}
	public String getFeedbackUrl( ) {
		return this.feedbackUrl;
	}

}
