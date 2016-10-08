package cn.cobala.alibaba.zhima.response;

import java.util.List;

import cn.cobala.alibaba.zhima.domain.IvsDetail;
import cn.cobala.alibaba.zhima.openplatform.ZhimaResponse;
import cn.cobala.alibaba.zhima.openplatform.internal.mapping.ApiField;
import cn.cobala.alibaba.zhima.openplatform.internal.mapping.ApiListField;

/**
 * ALIPAY API: zhima.credit.ivs.detail.get response.
 * 
 * @author auto create
 * @since 1.0, 2016-07-29 18:46:29
 */
public class ZhimaCreditIvsDetailGetResponse extends ZhimaResponse {

	private static final long serialVersionUID = 3878792777855529576L;

	/** 
	 * 芝麻信用对于每一次请求返回的业务号。后续可以通过此业务号进行对账
	 */
	@ApiField("biz_no")
	private String bizNo;

	/** 
	 * 对各项输入参数校验结果的风险因素code与风险描述说明，以list形式返回
	 */
	@ApiListField("ivs_detail")
	@ApiField("ivs_detail")
	private List<IvsDetail> ivsDetail;

	/** 
	 * ivs评分。取值区间为[0,100]。分数越高，表示可信程度越高。0表示无对应数据。
	 */
	@ApiField("ivs_score")
	private Long ivsScore;

	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}
	public String getBizNo( ) {
		return this.bizNo;
	}

	public void setIvsDetail(List<IvsDetail> ivsDetail) {
		this.ivsDetail = ivsDetail;
	}
	public List<IvsDetail> getIvsDetail( ) {
		return this.ivsDetail;
	}

	public void setIvsScore(Long ivsScore) {
		this.ivsScore = ivsScore;
	}
	public Long getIvsScore( ) {
		return this.ivsScore;
	}

}
