package cn.cobala.alibaba.zhima.response;

import cn.cobala.alibaba.zhima.domain.CompanyRole;
import cn.cobala.alibaba.zhima.openplatform.ZhimaResponse;
import cn.cobala.alibaba.zhima.openplatform.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.credit.ep.role.get response.
 * 
 * @author auto create
 * @since 1.0, 2016-05-06 11:44:38
 */
public class ZhimaCreditEpRoleGetResponse extends ZhimaResponse {

	private static final long serialVersionUID = 8338917358775689836L;

	/** 
	 * 芝麻信用对于每一次请求返回的业务号。后续可以通过此业务号进行对账。
	 */
	@ApiField("biz_no")
	private String bizNo;

	/** 
	 * 企业个人工商信息
	 */
	@ApiField("company_role")
	private CompanyRole companyRole;

	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}
	public String getBizNo( ) {
		return this.bizNo;
	}

	public void setCompanyRole(CompanyRole companyRole) {
		this.companyRole = companyRole;
	}
	public CompanyRole getCompanyRole( ) {
		return this.companyRole;
	}

}
