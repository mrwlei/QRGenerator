package cn.cobala.alibaba.zhima.request;

import java.util.Map;

import cn.cobala.alibaba.zhima.openplatform.ZhimaRequest;
import cn.cobala.alibaba.zhima.openplatform.internal.util.ZhimaHashMap;
import cn.cobala.alibaba.zhima.response.ZhimaCustomerCertifyInitialResponse;

/**
 * ALIPAY API: zhima.customer.certify.initial request
 * 
 * @author auto create
 * @since 1.0, 2016-06-17 16:19:31
 */
public class ZhimaCustomerCertifyInitialRequest implements ZhimaRequest<ZhimaCustomerCertifyInitialResponse> {

	private ZhimaHashMap udfParams; // add user-defined text parameters
	private String apiVersion="1.0";

	/** 
	* 业务扩展参数入参，传递方式例如{"xx":"xxxxx"};
针对KBA的认证方式需要关注，biz_params中需要传入入参：
{"verifyScene":"向芝麻申请获得的scene值"}
	 */
	private String bizParams;

	/** 
	* 与芝麻信用签订的合约外标，即使合约改签或续签该值不会发生变化。请联系技术支持
	 */
	private String contractFlag;

	/** 
	* 不同身份类型的参数列表，json字符串的key-value格式：
如：
当identity_type= "BY_CERTNO_AND_NAME";时
identity_param={"certNo":"xxx","name":"张三","certType":"IDENTITY_CARD","mobileNo":"13901234567"};
或者
当identity_type= "BY_MOBILE_NO";时
identity_param={"mobileNo":"13901234567"};
或者
当identify_type="BY_CERT_IMAGE"
identity_param={"frontCertImage":"oioiweroeworewoiho2323","backCertImage":"dsrrwerewew"}
	 */
	private String identityParam;

	/** 
	* 身份标识类型（后续可以扩展）：
BY_CERTNO_AND_NAME:按照身份证+姓名（手机号可选）进行身份识别
BY_MOBILE_NO:按照手机号进行身份识别
BY_CERT_IMAGE: 根据证件图片识别
	 */
	private String identityType;

	/** 
	* 商户页面回调地址，芝麻认证完成后通过此url地址回传给商户认证的结果；
SDK模式接入的场景为非必填项，其他渠道类型的必填项；
	 */
	private String pageUrl;

	/** 
	* 当前使用的产品码
	 */
	private String productCode;

	/** 
	* 商户App的回调地址，通过商户App发起人脸核身的芝麻认证时必传；其他场景为非必填项；
	 */
	private String schemaUrl;

	/** 
	* 请求来源类型，为比填项， 例如h5, pc , app, sdk,window；
1.h5 ：商户H5端接入芝麻应用的场景；
2.pc：商户pc端接入芝麻认证的场景；
3.app：商户app应用接入芝麻认证的场景；
4.sdk：商户调用芝麻的sdk进行芝麻认证的场景:
5.window：服务窗进行芝麻认证的场景；
	 */
	private String sourceType;

	/** 
	* 芝麻认证过程中的冗余字段，在认证申请时传入，在结果页面回调中原样透传给商户端。支持json格式。
【建议使用方式】用于商户端唯一标记发起认证的用户信息，在接收到芝麻信用认证结果回调后确定用户
	 */
	private String state;

	/** 
	* 商户传入的业务流水号。此字段由商户生成，需确保唯一性，用于定位每一次请求，后续按此流水进行对帐。生成规则: 固定30位数字串，前17位为精确到毫秒的时间yyyyMMddhhmmssSSS，后13位为自增数字。
	 */
	private String transactionId;

	public void setBizParams(String bizParams) {
		this.bizParams = bizParams;
	}
	public String getBizParams() {
		return this.bizParams;
	}

	public void setContractFlag(String contractFlag) {
		this.contractFlag = contractFlag;
	}
	public String getContractFlag() {
		return this.contractFlag;
	}

	public void setIdentityParam(String identityParam) {
		this.identityParam = identityParam;
	}
	public String getIdentityParam() {
		return this.identityParam;
	}

	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	}
	public String getIdentityType() {
		return this.identityType;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}
	public String getPageUrl() {
		return this.pageUrl;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductCode() {
		return this.productCode;
	}

	public void setSchemaUrl(String schemaUrl) {
		this.schemaUrl = schemaUrl;
	}
	public String getSchemaUrl() {
		return this.schemaUrl;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}
	public String getSourceType() {
		return this.sourceType;
	}

	public void setState(String state) {
		this.state = state;
	}
	public String getState() {
		return this.state;
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
		return "zhima.customer.certify.initial";
	}

	public Map<String, String> getTextParams() {		
		ZhimaHashMap txtParams = new ZhimaHashMap();
		txtParams.put("biz_params", this.bizParams);
		txtParams.put("contract_flag", this.contractFlag);
		txtParams.put("identity_param", this.identityParam);
		txtParams.put("identity_type", this.identityType);
		txtParams.put("page_url", this.pageUrl);
		txtParams.put("product_code", this.productCode);
		txtParams.put("schema_url", this.schemaUrl);
		txtParams.put("source_type", this.sourceType);
		txtParams.put("state", this.state);
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

	public Class<ZhimaCustomerCertifyInitialResponse> getResponseClass() {
		return ZhimaCustomerCertifyInitialResponse.class;
	}
}
