package cn.cobala.alibaba;

import cn.cobala.alibaba.zhima.openplatform.DefaultZhimaClient;
import cn.cobala.alibaba.zhima.openplatform.ZhimaApiException;
import cn.cobala.alibaba.zhima.request.ZhimaCreditIvsDetailGetRequest;
import cn.cobala.alibaba.zhima.response.ZhimaCreditIvsDetailGetResponse;

public class Test {
	
	
    //芝麻开放平台地址
    private static String gatewayUrl     = "https://zmopenapi.zmxy.com.cn/openapi.do";
    //商户应用 Id
    private static String appId          = "***";
    //商户 RSA 私钥
    private static String privateKey     = "***";
    //芝麻 RSA 公钥
    private static String zhimaPublicKey = "***";
	
	
	public static void main(String[] args) {
		
		testZhimaCreditIvsDetailGet();
	}
	
	public static void testZhimaCreditIvsDetailGet() {
        ZhimaCreditIvsDetailGetRequest req = new ZhimaCreditIvsDetailGetRequest();
        req.setChannel("apppc");
        req.setPlatform("zmop");
        
           req.setProductCode("w1010100000000000103");// 必要参数        
           req.setTransactionId("20151127233347987676212309253");// 必要参数        
           req.setCertNo("640202199007164686");//        
           req.setCertType("100");//        
           req.setName("牛德华");//        
           req.setMobile("15843991158");//        
           req.setEmail("jnlxhy@alitest.com");//        
           req.setBankCard("20110602436748024138");//        
           req.setAddress("杭州市西湖区天目山路266号");//        
           req.setIp("101.247.161.1");//        
           req.setMac("44-45-53-54-00-00");//        
           req.setWifimac("00-00-00-00-00-00-00-E0");//        
           req.setImei("868331011992179");//        
           req.setImsi("460030091733165");//        
           
         DefaultZhimaClient client = new DefaultZhimaClient(gatewayUrl, appId, privateKey,zhimaPublicKey);
         
        try {
            ZhimaCreditIvsDetailGetResponse response = client.execute(req);
            
            System.out.println(response.isSuccess());
            System.out.println(response.getErrorCode());
            System.out.println(response.getErrorMessage());
        } catch (ZhimaApiException e) {
            e.printStackTrace();
        }
    }
}
