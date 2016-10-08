package cn.cobala.alibaba.zhima.response;

import cn.cobala.alibaba.zhima.openplatform.ZhimaResponse;
import cn.cobala.alibaba.zhima.openplatform.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.auth.engine.protocol response.
 * 
 * @author auto create
 * @since 1.0, 2016-09-08 11:48:17
 */
public class ZhimaAuthEngineProtocolResponse extends ZhimaResponse {

	private static final long serialVersionUID = 5594275359424952626L;

	/** 
	 * 27位openId，用于标识芝麻会员在商户端的身份标识
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
