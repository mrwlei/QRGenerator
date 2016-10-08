package cn.cobala.alibaba.zhima.response;

import java.util.List;

import cn.cobala.alibaba.zhima.domain.UserScore;
import cn.cobala.alibaba.zhima.openplatform.ZhimaResponse;
import cn.cobala.alibaba.zhima.openplatform.internal.mapping.ApiField;
import cn.cobala.alibaba.zhima.openplatform.internal.mapping.ApiListField;

/**
 * ALIPAY API: zhima.credit.score.batch.get response.
 * 
 * @author auto create
 * @since 1.0, 2016-08-18 10:12:52
 */
public class ZhimaCreditScoreBatchGetResponse extends ZhimaResponse {

	private static final long serialVersionUID = 7542515977635579992L;

	/** 
	 * 用户芝麻分列表。用户芝麻分对象包含用户id（String类型）,芝麻分（String类型）,resultCode（String类型，该用户不输出芝麻分的原因）

resultCode的枚举值：
ZHIMA_USER_NOT_EXIST  芝麻用户不存在（指的是没开通或者身份释放的用户）
EMPTY_RESULT 无芝麻分
AUTHENTICATE_FAIL （鉴权失败，用户未授权给商户 或 取消了授权）
ZHIMA_ROLE_PAUSED（芝麻角色暂时不可用，如用户关闭了芝麻信用）
	 */
	@ApiListField("user_score_list")
	@ApiField("user_score")
	private List<UserScore> userScoreList;

	public void setUserScoreList(List<UserScore> userScoreList) {
		this.userScoreList = userScoreList;
	}
	public List<UserScore> getUserScoreList( ) {
		return this.userScoreList;
	}

}
