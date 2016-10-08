package cn.cobala.alibaba.zhima.response;

import cn.cobala.alibaba.zhima.openplatform.ZhimaResponse;
import cn.cobala.alibaba.zhima.openplatform.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.auth.info.authquery response.
 * 
 * @author auto create
 * @since 1.0, 2016-09-21 13:17:18
 */
public class ZhimaAuthInfoAuthqueryResponse extends ZhimaResponse {

	private static final long serialVersionUID = 5698669275727214957L;

	/** 
	 * 用户是否对该应用授权
	 */
	@ApiField("authorized")
	private Boolean authorized;

	/** 
	 * 
	 */
	@ApiField("open_id")
	private String openId;

	public void setAuthorized(Boolean authorized) {
		this.authorized = authorized;
	}
	public Boolean getAuthorized( ) {
		return this.authorized;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getOpenId( ) {
		return this.openId;
	}

}
