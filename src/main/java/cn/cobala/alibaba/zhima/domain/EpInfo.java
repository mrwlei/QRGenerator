package cn.cobala.alibaba.zhima.domain;

import java.util.List;

import cn.cobala.alibaba.zhima.openplatform.ZhimaObject;
import cn.cobala.alibaba.zhima.openplatform.internal.mapping.ApiField;
import cn.cobala.alibaba.zhima.openplatform.internal.mapping.ApiListField;

/**
 * 企业征信基本信息
 *
 * @author auto create
 * @since 1.0, 2016-02-04 14:49:18
 */
public class EpInfo extends ZhimaObject {

	private static final long serialVersionUID = 4259625714867434533L;

	/** 
	 * 企业征信基本信息
	 */
	@ApiListField("ep_element_list")
	@ApiField("ep_element")
	private List<EpElement> epElementList;

	public void setEpElementList(List<EpElement> epElementList) {
		this.epElementList = epElementList;
	}
	public List<EpElement> getEpElementList( ) {
		return this.epElementList;
	}

}
