package cn.cobala.alibaba.zhima.response;

import cn.cobala.alibaba.zhima.openplatform.ZhimaResponse;
import cn.cobala.alibaba.zhima.openplatform.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.credit.identity.verify response.
 * 
 * @author auto create
 * @since 1.0, 2016-07-08 10:08:42
 */
public class ZhimaCreditIdentityVerifyResponse extends ZhimaResponse {

	private static final long serialVersionUID = 7599548571382696459L;

	/** 
	 * 芝麻信用对于每一次请求返回的业务号。后续可以通过此业务号进行对账
	 */
	@ApiField("biz_no")
	private String bizNo;

	/** 
	 * 验证证件号与姓名是否匹配
	 */
	@ApiField("verify_result")
	private Boolean verifyResult;

	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}
	public String getBizNo( ) {
		return this.bizNo;
	}

	public void setVerifyResult(Boolean verifyResult) {
		this.verifyResult = verifyResult;
	}
	public Boolean getVerifyResult( ) {
		return this.verifyResult;
	}

}
