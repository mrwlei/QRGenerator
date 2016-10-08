package cn.cobala.alibaba.zhima.response;

import cn.cobala.alibaba.zhima.openplatform.ZhimaResponse;
import cn.cobala.alibaba.zhima.openplatform.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.customer.certify.initial response.
 * 
 * @author auto create
 * @since 1.0, 2016-06-17 16:19:31
 */
public class ZhimaCustomerCertifyInitialResponse extends ZhimaResponse {

	private static final long serialVersionUID = 6415169346584851584L;

	/** 
	 * 芝麻认证每一次请求返回的令牌，发起页面认证请求和认证请求结果查询接口都需要使用到该返回值作为入参
	 */
	@ApiField("token")
	private String token;

	public void setToken(String token) {
		this.token = token;
	}
	public String getToken( ) {
		return this.token;
	}

}
