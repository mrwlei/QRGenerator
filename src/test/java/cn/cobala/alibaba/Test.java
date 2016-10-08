package cn.cobala.alibaba;

import java.util.UUID;

import cn.cobala.alibaba.zhima.openplatform.DefaultZhimaClient;
import cn.cobala.alibaba.zhima.openplatform.ZhimaApiException;
import cn.cobala.alibaba.zhima.request.ZhimaCreditIvsDetailGetRequest;
import cn.cobala.alibaba.zhima.response.ZhimaCreditIvsDetailGetResponse;

public class Test {
	
	
    //芝麻开放平台地址
    private static String gatewayUrl     = "https://zmopenapi.zmxy.com.cn/openapi.do";
    //商户应用 Id
    private static String appId          = "1000216";
    //商户 RSA 私钥
    private static String privateKey     = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJlkRQQFkpiNRULEizLtrzK5eb29905QuA1VRrktcVZxlPwTmi7SXYyivBlotlq6+CthMCFfctQswhfElL0YvVH6SMTiAzkWMHkbtbJJCppsjWTI9STd4K3tb6xzEJ3bXx9V1qJPf5hZvqWrrTZbtWCsYh6UdZSd7aXCq+TX/TkxAgMBAAECgYBhAX58CqIpA753eSCm9pXDuHR7QHXz+yxKklGFrm1sw6v6ttLdJYCv/gKC9yvLuU5U8MOld12BPUUKDvIZnFmtUaSgFWrHyAGba4HThJ9cN5lXDuHGGcMrjy+JdsvxY8TdnTy0rxYuWRZS2StjrMgwLpmTaNMnB9qmIXX22mtR2QJBAMuzOQC4NVxky/58PdmJsOOhaXFkyU9neaa4nQtQMMMhFYfV68H3CtOLkaA9TDi7kKVaNRmu6EF1bEuwMJaLID8CQQDAxmGU6A5k7m4RWFgrDD3HfqAPrJdskVv9g6dQMoVuxsg7akLgbpCRU2hY+mdTPdMZPckGUR52rFf6IGd6DEqPAkBUoRVhsyaYSFhoVn3rz0TqjbkdH15z2u2z0qeMd7iKmUg0sy/L2jNpSGcsR8tPFr41tJCzJvPfnkVr/LtzEEJJAkAqkyW2B1I2hFoWxpYiW7/BMXwUOh/vQGM6qDrpgV7qykgqpxtCCekvz2X6UMNFJSBcMMMW/A9oUkPT4Bg6YkCNAkEAtbnsr4CJO8SfxvoA56Oydllx3sDGf7Bz+VNVDSaUbljiDOjKmcE+3wI5A******";
    //芝麻 RSA 公钥
    private static String zhimaPublicKey = "****GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCSt7IL5JqcYEXAAaPj5YvDOSpU0qUATr8537nT65EtAXTJVLXuTjh0nBP+dTLNYJZLksDqXR45R3PPIVHtarYW6VRx1Uf7E4hd4Q5bIuexWbMzpCVuFYgybLq42nxkUCh9fX55VxuK/uLeoJ8SaHrsrG2tYVC3KOk0fPiy4/noKwIDAQAB";
	
    
    
	public static void main(String[] args) {
		
		testZhimaCreditIvsDetailGet();
	}
	
	
	
	public static void testZhimaCreditIvsDetailGet() {
        ZhimaCreditIvsDetailGetRequest req = new ZhimaCreditIvsDetailGetRequest();
        req.setChannel("apppc");
        req.setPlatform("zmop");
        
           req.setProductCode("w1010100000000000103");// 必要参数        
           req.setTransactionId(UUID.randomUUID().toString());// 必要参数        
           
           req.setCertNo("1306271992xxxx0636");
           req.setName("王雷");
           
           
           
           
//           req.setCertNo("640202199007164686");//        
//           req.setCertType("100");//        
//           req.setName("牛德华");//        
//           req.setMobile("15843991158");//        
//           req.setEmail("jnlxhy@alitest.com");//        
//           req.setBankCard("20110602436748024138");//        
//           req.setAddress("杭州市西湖区天目山路266号");//        
//           req.setIp("101.247.161.1");//        
//           req.setMac("44-45-53-54-00-00");//        
//           req.setWifimac("00-00-00-00-00-00-00-E0");//        
//           req.setImei("868331011992179");//        
//           req.setImsi("460030091733165");//        
           
         DefaultZhimaClient client = new DefaultZhimaClient(gatewayUrl, appId, privateKey,zhimaPublicKey);
         
        try {
            ZhimaCreditIvsDetailGetResponse response = client.execute(req);
            
            System.out.println(response.isSuccess());
            System.out.println(response.getErrorCode());
            System.out.println(response.getErrorMessage());
            
            System.out.println(response);
            
            
        } catch (ZhimaApiException e) {
            e.printStackTrace();
        }
    }
}
