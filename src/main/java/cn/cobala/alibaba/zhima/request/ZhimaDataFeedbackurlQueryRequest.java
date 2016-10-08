package cn.cobala.alibaba.zhima.request;

import java.util.Map;

import cn.cobala.alibaba.zhima.openplatform.ZhimaRequest;
import cn.cobala.alibaba.zhima.openplatform.internal.util.ZhimaHashMap;
import cn.cobala.alibaba.zhima.response.ZhimaDataFeedbackurlQueryResponse;

/**
 * ALIPAY API: zhima.data.feedbackurl.query request
 * 
 * @author auto create
 * @since 1.0, 2016-09-08 08:34:08
 */
public class ZhimaDataFeedbackurlQueryRequest implements ZhimaRequest<ZhimaDataFeedbackurlQueryResponse> {

	private ZhimaHashMap udfParams; // add user-defined text parameters
	private String apiVersion="1.0";

	/** 
	* 
	 */
	private String merchantId;

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	public String getMerchantId() {
		return this.merchantId;
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
		return "zhima.data.feedbackurl.query";
	}

	public Map<String, String> getTextParams() {		
		ZhimaHashMap txtParams = new ZhimaHashMap();
		txtParams.put("merchant_id", this.merchantId);
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

	public Class<ZhimaDataFeedbackurlQueryResponse> getResponseClass() {
		return ZhimaDataFeedbackurlQueryResponse.class;
	}
}
