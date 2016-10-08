package cn.cobala.alibaba.zhima.response;

import java.util.List;

import cn.cobala.alibaba.zhima.domain.ZmWatchListDetail;
import cn.cobala.alibaba.zhima.openplatform.ZhimaResponse;
import cn.cobala.alibaba.zhima.openplatform.internal.mapping.ApiField;
import cn.cobala.alibaba.zhima.openplatform.internal.mapping.ApiListField;

/**
 * ALIPAY API: zhima.credit.watchlist.get response.
 * 
 * @author auto create
 * @since 1.0, 2016-07-12 11:19:23
 */
public class ZhimaCreditWatchlistGetResponse extends ZhimaResponse {

	private static final long serialVersionUID = 7323421485878226855L;

	/** 
	 * 芝麻信用对于每一次请求返回的业务号。后续可以通过此业务号进行对账
	 */
	@ApiField("biz_no")
	private String bizNo;

	/** 
	 * 行业关注名单列表
	 */
	@ApiListField("details")
	@ApiField("zm_watch_list_detail")
	private List<ZmWatchListDetail> details;

	/** 
	 * true=命中 在关注名单中
false=未命中
	 */
	@ApiField("is_matched")
	private Boolean isMatched;

	/** 
	 * MATCH1000：未命中
MATCH1001：命中
	 */
	@ApiField("result_code")
	private String resultCode;

	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}
	public String getBizNo( ) {
		return this.bizNo;
	}

	public void setDetails(List<ZmWatchListDetail> details) {
		this.details = details;
	}
	public List<ZmWatchListDetail> getDetails( ) {
		return this.details;
	}

	public void setIsMatched(Boolean isMatched) {
		this.isMatched = isMatched;
	}
	public Boolean getIsMatched( ) {
		return this.isMatched;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultCode( ) {
		return this.resultCode;
	}

}
