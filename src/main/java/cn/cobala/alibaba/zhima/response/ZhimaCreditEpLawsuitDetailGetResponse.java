package cn.cobala.alibaba.zhima.response;

import cn.cobala.alibaba.zhima.domain.EpInfo;
import cn.cobala.alibaba.zhima.openplatform.ZhimaResponse;
import cn.cobala.alibaba.zhima.openplatform.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.credit.ep.lawsuit.detail.get response.
 * 
 * @author auto create
 * @since 1.0, 2016-05-06 11:44:57
 */
public class ZhimaCreditEpLawsuitDetailGetResponse extends ZhimaResponse {

	private static final long serialVersionUID = 1882174277722619322L;

	/** 
	 * 芝麻信用对于每一次请求返回的业务号。后续可以通过此业务号进行对账。
	 */
	@ApiField("biz_no")
	private String bizNo;

	/** 
	 * 企业涉诉详情
	 */
	@ApiField("lawsuit_detail")
	private EpInfo lawsuitDetail;

	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}
	public String getBizNo( ) {
		return this.bizNo;
	}

	public void setLawsuitDetail(EpInfo lawsuitDetail) {
		this.lawsuitDetail = lawsuitDetail;
	}
	public EpInfo getLawsuitDetail( ) {
		return this.lawsuitDetail;
	}

}
