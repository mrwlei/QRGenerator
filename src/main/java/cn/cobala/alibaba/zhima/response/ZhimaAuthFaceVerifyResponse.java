package cn.cobala.alibaba.zhima.response;

import cn.cobala.alibaba.zhima.openplatform.ZhimaResponse;
import cn.cobala.alibaba.zhima.openplatform.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.auth.face.verify response.
 * 
 * @author auto create
 * @since 1.0, 2016-09-18 10:15:19
 */
public class ZhimaAuthFaceVerifyResponse extends ZhimaResponse {

	private static final long serialVersionUID = 6627553795783182843L;

	/** 
	 * 业务执行结果是否成功
	 */
	@ApiField("biz_success")
	private Boolean bizSuccess;

	/** 
	 * 一次请求的标识token
	 */
	@ApiField("token")
	private String token;

	public void setBizSuccess(Boolean bizSuccess) {
		this.bizSuccess = bizSuccess;
	}
	public Boolean getBizSuccess( ) {
		return this.bizSuccess;
	}

	public void setToken(String token) {
		this.token = token;
	}
	public String getToken( ) {
		return this.token;
	}

}
