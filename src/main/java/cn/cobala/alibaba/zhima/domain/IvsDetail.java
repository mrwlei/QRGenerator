package cn.cobala.alibaba.zhima.domain;

import cn.cobala.alibaba.zhima.openplatform.ZhimaObject;
import cn.cobala.alibaba.zhima.openplatform.internal.mapping.ApiField;

/**
 * ivs的细节信息
 *
 * @author auto create
 * @since 1.0, 2015-12-28 20:50:06
 */
public class IvsDetail extends ZhimaObject {

	private static final long serialVersionUID = 8314774824159812711L;

	/** 
	 * 风险因素code
	 */
	@ApiField("code")
	private String code;

	/** 
	 * 风险描述说明
	 */
	@ApiField("description")
	private String description;

	public void setCode(String code) {
		this.code = code;
	}
	public String getCode( ) {
		return this.code;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription( ) {
		return this.description;
	}

}
