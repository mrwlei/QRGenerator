package cn.cobala.alibaba.zhima.domain;

import cn.cobala.alibaba.zhima.openplatform.ZhimaObject;
import cn.cobala.alibaba.zhima.openplatform.internal.mapping.ApiField;

/**
 * 芝麻数据服务变量结果
 *
 * @author auto create
 * @since 1.0, 2016-02-01 10:08:34
 */
public class DasVariable extends ZhimaObject {

	private static final long serialVersionUID = 4582929593241572556L;

	/** 
	 * 芝麻变量服务返回的变量名
	 */
	@ApiField("key")
	private String key;

	/** 
	 * 芝麻变量服务返回的变量值
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
