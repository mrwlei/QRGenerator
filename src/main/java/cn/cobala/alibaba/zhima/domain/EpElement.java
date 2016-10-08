package cn.cobala.alibaba.zhima.domain;

import cn.cobala.alibaba.zhima.openplatform.ZhimaObject;
import cn.cobala.alibaba.zhima.openplatform.internal.mapping.ApiField;

/**
 * 企业征信基本单元
 *
 * @author auto create
 * @since 1.0, 2016-02-04 14:57:03
 */
public class EpElement extends ZhimaObject {

	private static final long serialVersionUID = 1836329342282297158L;

	/** 
	 * key键值
	 */
	@ApiField("key")
	private String key;

	/** 
	 * value键值
	 */
	@ApiField("value")
	private String value;

	public void setKey(String key) {
		this.key = key;
	}
	public String getKey( ) {
		return this.key;
	}

	public void setValue(String value) {
		this.value = value;
	}
	public String getValue( ) {
		return this.value;
	}

}
