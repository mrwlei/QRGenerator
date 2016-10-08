package cn.cobala.alibaba.zhima.response;

import java.util.List;

import cn.cobala.alibaba.zhima.domain.EpElement;
import cn.cobala.alibaba.zhima.openplatform.ZhimaResponse;
import cn.cobala.alibaba.zhima.openplatform.internal.mapping.ApiField;
import cn.cobala.alibaba.zhima.openplatform.internal.mapping.ApiListField;

/**
 * ALIPAY API: zhima.credit.pe.lawsuit.detail.get response.
 * 
 * @author auto create
 * @since 1.0, 2016-05-25 21:25:48
 */
public class ZhimaCreditPeLawsuitDetailGetResponse extends ZhimaResponse {

	private static final long serialVersionUID = 2746866328256667315L;

	/** 
	 * 芝麻信用对于每一次请求返回的业务号。后续可以通过此业务号进行对账
	 */
	@ApiField("biz_no")
	private String bizNo;

	/** 
	 * 个人涉诉信息元素
	 */
	@ApiListField("lawsuit_detail")
	@ApiField("ep_element")
	private List<EpElement> lawsuitDetail;

	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}
	public String getBizNo( ) {
		return this.bizNo;
	}

	public void setLawsuitDetail(List<EpElement> lawsuitDetail) {
		this.lawsuitDetail = lawsuitDetail;
	}
	public List<EpElement> getLawsuitDetail( ) {
		return this.lawsuitDetail;
	}

}
