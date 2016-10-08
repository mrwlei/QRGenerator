package cn.cobala.alibaba.zhima.response;

import cn.cobala.alibaba.zhima.openplatform.ZhimaResponse;
import cn.cobala.alibaba.zhima.openplatform.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.auth.engine.multiauth response.
 * 
 * @author auto create
 * @since 1.0, 2016-06-24 14:37:49
 */
public class ZhimaAuthEngineMultiauthResponse extends ZhimaResponse {

	private static final long serialVersionUID = 1621894349687332832L;

	/** 
	 * 用户在商端的身份标识
	 */
	@ApiField("open_id")
	private String openId;

	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getOpenId( ) {
		return this.openId;
	}

}
