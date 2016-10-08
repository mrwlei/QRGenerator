package cn.cobala.alibaba.zhima.domain;

import cn.cobala.alibaba.zhima.openplatform.ZhimaObject;
import cn.cobala.alibaba.zhima.openplatform.internal.mapping.ApiField;

/**
 * 用户芝麻分对象，包含芝麻分，用户id，resultCode（无芝麻分时，无分的原因）。
 *
 * @author auto create
 * @since 1.0, 2016-07-21 15:03:46
 */
public class UserScore extends ZhimaObject {

	private static final long serialVersionUID = 5636279587153461848L;

	/** 
	 * 不输出芝麻分的原因
	 */
	@ApiField("result_code")
	private String resultCode;

	/** 
	 * 支付宝的userid
	 */
	@ApiField("user_id")
	private String userId;

	/** 
	 * 用户芝麻分
	 */
	@ApiField("zm_score")
	private String zmScore;

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultCode( ) {
		return this.resultCode;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserId( ) {
		return this.userId;
	}

	public void setZmScore(String zmScore) {
		this.zmScore = zmScore;
	}
	public String getZmScore( ) {
		return this.zmScore;
	}

}
