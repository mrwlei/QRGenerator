package cn.cobala.alibaba.zhima.response;

import cn.cobala.alibaba.zhima.openplatform.ZhimaResponse;
import cn.cobala.alibaba.zhima.openplatform.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.credit.card.permit response.
 * 
 * @author auto create
 * @since 1.0, 2016-07-12 10:48:28
 */
public class ZhimaCreditCardPermitResponse extends ZhimaResponse {

	private static final long serialVersionUID = 4692283635794891427L;

	/** 
	 * 芝麻信用对于每一次请求返回的业务号。后续可以通过此业务号进行对账
	 */
	@ApiField("biz_no")
	private String bizNo;

	/** 
	 * 是否准入
	 */
	@ApiField("is_passed")
	private Boolean isPassed;

	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}
	public String getBizNo( ) {
		return this.bizNo;
	}

	public void setIsPassed(Boolean isPassed) {
		this.isPassed = isPassed;
	}
	public Boolean getIsPassed( ) {
		return this.isPassed;
	}

}
