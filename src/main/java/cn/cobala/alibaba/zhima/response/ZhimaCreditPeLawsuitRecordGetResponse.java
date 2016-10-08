package cn.cobala.alibaba.zhima.response;

import cn.cobala.alibaba.zhima.domain.LawsuitPersonRecord;
import cn.cobala.alibaba.zhima.openplatform.ZhimaResponse;
import cn.cobala.alibaba.zhima.openplatform.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.credit.pe.lawsuit.record.get response.
 * 
 * @author auto create
 * @since 1.0, 2016-04-08 11:54:39
 */
public class ZhimaCreditPeLawsuitRecordGetResponse extends ZhimaResponse {

	private static final long serialVersionUID = 6525445963527894737L;

	/** 
	 * 芝麻信用对于每一次请求返回的业务号。后续可以通过此业务号进行对账
	 */
	@ApiField("biz_no")
	private String bizNo;

	/** 
	 * 个人涉诉记录
	 */
	@ApiField("lawsuit_person_record")
	private LawsuitPersonRecord lawsuitPersonRecord;

	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}
	public String getBizNo( ) {
		return this.bizNo;
	}

	public void setLawsuitPersonRecord(LawsuitPersonRecord lawsuitPersonRecord) {
		this.lawsuitPersonRecord = lawsuitPersonRecord;
	}
	public LawsuitPersonRecord getLawsuitPersonRecord( ) {
		return this.lawsuitPersonRecord;
	}

}
