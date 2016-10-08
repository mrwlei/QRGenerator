package cn.cobala.alibaba.zhima.request;

import java.util.Map;

import cn.cobala.alibaba.zhima.openplatform.ZhimaRequest;
import cn.cobala.alibaba.zhima.openplatform.internal.util.ZhimaHashMap;
import cn.cobala.alibaba.zhima.response.ZhimaCreditContactGetResponse;

/**
 * ALIPAY API: zhima.credit.contact.get request
 * 
 * @author auto create
 * @since 1.0, 2016-07-12 11:05:38
 */
public class ZhimaCreditContactGetRequest implements ZhimaRequest<ZhimaCreditContactGetResponse> {

	private ZhimaHashMap udfParams; // add user-defined text parameters
	private String apiVersion="1.0";

	/** 
	* 用户的地址（可选，但必须和电话一起传入）。
可以传入多组地址，每组地址之间以“|"分隔。
地址格式见示例值，需要用加号来连接地址各个字段。
	 */
	private String address;

	/** 
	* 是否逾期。T表示逾期，F表示非逾期
	 */
	private String isOverdue;

	/** 
	* 用户电话号码（可选，但必须和地址信息一起传入）。
可以传入多个手机号，每个手机号之间以“|"分隔。
	 */
	private String mobile;

	/** 
	* 芝麻会员在商户端的身份标识。
	 */
	private String openId;

	/** 
	* 逾期天数。请输入数字。
	 */
	private String overdueDays;

	/** 
	* 产品码
	 */
	private String productCode;

	/** 
	* 商户传入的业务流水号。此字段由商户生成，需确保唯一性，用于定位每一次请求，后续按此流水进行对帐。生成规则: 固定30位数字串，前17位为精确到毫秒的时间yyyyMMddhhmmssSSS，后13位为自增数字。
	 */
	private String transactionId;

	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return this.address;
	}

	public void setIsOverdue(String isOverdue) {
		this.isOverdue = isOverdue;
	}
	public String getIsOverdue() {
		return this.isOverdue;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getMobile() {
		return this.mobile;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getOpenId() {
		return this.openId;
	}

	public void setOverdueDays(String overdueDays) {
		this.overdueDays = overdueDays;
	}
	public String getOverdueDays() {
		return this.overdueDays;
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
		return "zhima.credit.contact.get";
	}

	public Map<String, String> getTextParams() {		
		ZhimaHashMap txtParams = new ZhimaHashMap();
		txtParams.put("address", this.address);
		txtParams.put("is_overdue", this.isOverdue);
		txtParams.put("mobile", this.mobile);
		txtParams.put("open_id", this.openId);
		txtParams.put("overdue_days", this.overdueDays);
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

	public Class<ZhimaCreditContactGetResponse> getResponseClass() {
		return ZhimaCreditContactGetResponse.class;
	}
}
