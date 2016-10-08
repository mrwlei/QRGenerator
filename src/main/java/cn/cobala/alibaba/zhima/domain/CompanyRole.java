package cn.cobala.alibaba.zhima.domain;

import java.util.List;

import cn.cobala.alibaba.zhima.openplatform.ZhimaObject;
import cn.cobala.alibaba.zhima.openplatform.internal.mapping.ApiField;
import cn.cobala.alibaba.zhima.openplatform.internal.mapping.ApiListField;

/**
 * 企业个人工商信息
 *
 * @author auto create
 * @since 1.0, 2016-02-04 17:15:05
 */
public class CompanyRole extends ZhimaObject {

	private static final long serialVersionUID = 5668286517534855524L;

	/** 
	 * 担任企业法人的企业信息
	 */
	@ApiListField("ry_pos_fr_list")
	@ApiField("ep_info")
	private List<EpInfo> ryPosFrList;

	/** 
	 * 担任股东的企业信息
	 */
	@ApiListField("ry_pos_sha_list")
	@ApiField("ep_info")
	private List<EpInfo> ryPosShaList;

	/** 
	 * 担任主要管理人员的企业信息
	 */
	@ApiListField("share_holder_list")
	@ApiField("ep_info")
	private List<EpInfo> shareHolderList;

	public void setRyPosFrList(List<EpInfo> ryPosFrList) {
		this.ryPosFrList = ryPosFrList;
	}
	public List<EpInfo> getRyPosFrList( ) {
		return this.ryPosFrList;
	}

	public void setRyPosShaList(List<EpInfo> ryPosShaList) {
		this.ryPosShaList = ryPosShaList;
	}
	public List<EpInfo> getRyPosShaList( ) {
		return this.ryPosShaList;
	}

	public void setShareHolderList(List<EpInfo> shareHolderList) {
		this.shareHolderList = shareHolderList;
	}
	public List<EpInfo> getShareHolderList( ) {
		return this.shareHolderList;
	}

}
