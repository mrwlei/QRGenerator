package cn.cobala.alibaba.zhima.request;

import java.util.Map;

import cn.cobala.alibaba.zhima.openplatform.ZhimaRequest;
import cn.cobala.alibaba.zhima.openplatform.internal.util.ZhimaHashMap;
import cn.cobala.alibaba.zhima.response.ZhimaCreditScoreGetResponse;

/**
 * ALIPAY API: zhima.credit.score.get request
 * 
 * @author auto create
 * @since 1.0, 2016-09-21 16:08:54
 */
public class ZhimaCreditScoreGetRequest implements ZhimaRequest<ZhimaCreditScoreGetResponse> {

	private ZhimaHashMap udfParams; // add user-defined text parameters
	private String apiVersion="1.0";

	/** 
	* 芝麻会员在商户端的身份标识。
	 */
	private String openId;

	/** 
	* 产品码
	 */
	private String productCode;

	/** 
	* 商户传入的业务流水号。此字段由商户生成，需确保唯一性，用于定位每一次请求，后续按此流水进行对帐。生成规则: 固定30位数字串，前17位为精确到毫秒的时间yyyyMMddhhmmssSSS，后13位为自增数字。
	 */
	private String transactionId;

	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getOpenId() {
		return this.openId;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductCode() {
		return this.productCode;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getTransactionId() {
		return this.transactionId;
	}
	private String channel;
	private String platform;	
	private String scene;
	private String extParams;

	public String getApiVersion() {
		return this.apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public void setChannel(String channel){
		this.channel=channel;
	}

    public String getChannel(){
    	return this.channel;
    }

	public void setPlatform(String platform){
		this.platform=platform;
	}

    public String getPlatform(){
    	return this.platform;
    }
    
    public void setScene(String scene){
		this.scene=scene;
	}

    public String getScene(){
    	return this.scene;
    }
    
    public void setExtParams(String extParams){
		this.extParams=extParams;
	}

    public String getExtParams(){
    	return this.extParams;
    }
    
	public String getApiMethodName() {
		return "zhima.credit.score.get";
	}

	public Map<String, String> getTextParams() {		
		ZhimaHashMap txtParams = new ZhimaHashMap();
		txtParams.put("open_id", this.openId);
		txtParams.put("product_code", this.productCode);
		txtParams.put("transaction_id", this.transactionId);
		if(udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public void putOtherTextParam(String key, String value) {
		if(this.udfParams == null) {
			this.udfParams = new ZhimaHashMap();
		}
		this.udfParams.put(key, value);
	}

	public Class<ZhimaCreditScoreGetResponse> getResponseClass() {
		return ZhimaCreditScoreGetResponse.class;
	}
}
