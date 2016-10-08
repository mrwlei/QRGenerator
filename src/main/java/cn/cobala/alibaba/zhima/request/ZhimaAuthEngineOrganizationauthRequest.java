package cn.cobala.alibaba.zhima.request;

import java.util.Map;

import cn.cobala.alibaba.zhima.openplatform.ZhimaRequest;
import cn.cobala.alibaba.zhima.openplatform.internal.util.ZhimaHashMap;
import cn.cobala.alibaba.zhima.response.ZhimaAuthEngineOrganizationauthResponse;

/**
 * ALIPAY API: zhima.auth.engine.organizationauth request
 * 
 * @author auto create
 * @since 1.0, 2016-07-19 10:05:49
 */
public class ZhimaAuthEngineOrganizationauthRequest implements ZhimaRequest<ZhimaAuthEngineOrganizationauthResponse> {

	private ZhimaHashMap udfParams; // add user-defined text parameters
	private String apiVersion="1.0";

	/** 
	* 
	 */
	private String identityParam;

	public void setIdentityParam(String identityParam) {
		this.identityParam = identityParam;
	}
	public String getIdentityParam() {
		return this.identityParam;
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
		return "zhima.auth.engine.organizationauth";
	}

	public Map<String, String> getTextParams() {		
		ZhimaHashMap txtParams = new ZhimaHashMap();
		txtParams.put("identity_param", this.identityParam);
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

	public Class<ZhimaAuthEngineOrganizationauthResponse> getResponseClass() {
		return ZhimaAuthEngineOrganizationauthResponse.class;
	}
}
