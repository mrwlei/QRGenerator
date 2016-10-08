package cn.cobala.alibaba.zhima.response;

import cn.cobala.alibaba.zhima.openplatform.ZhimaResponse;
import cn.cobala.alibaba.zhima.openplatform.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.auth.engine.organizationauth response.
 * 
 * @author auto create
 * @since 1.0, 2016-07-19 10:05:49
 */
public class ZhimaAuthEngineOrganizationauthResponse extends ZhimaResponse {

	private static final long serialVersionUID = 8145225685784524966L;

	/** 
	 * 27位openId，用于标识芝麻会员在
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
