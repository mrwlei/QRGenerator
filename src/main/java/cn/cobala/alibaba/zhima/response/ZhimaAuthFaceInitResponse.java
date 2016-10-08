package cn.cobala.alibaba.zhima.response;

import cn.cobala.alibaba.zhima.openplatform.ZhimaResponse;
import cn.cobala.alibaba.zhima.openplatform.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.auth.face.init response.
 * 
 * @author auto create
 * @since 1.0, 2016-04-22 10:59:34
 */
public class ZhimaAuthFaceInitResponse extends ZhimaResponse {

	private static final long serialVersionUID = 7358913688829199397L;

	/** 
	 * 请求返回的加密串
	 */
	@ApiField("auth_msg")
	private String authMsg;

	public void setAuthMsg(String authMsg) {
		this.authMsg = authMsg;
	}
	public String getAuthMsg( ) {
		return this.authMsg;
	}

}
