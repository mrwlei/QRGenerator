package cn.cobala.weixin;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import cn.cobala.weixin.util.WxUtilEx;

/**
 * 代码示例
 * @author wang-lei
 */
public class PayTest {
	
	
	@Test // 模拟统一下单示例
	public void testUnifyOrder() throws Exception {
		String appid = "";                    //公众号ID     微信分配的公众账号ID
		String mch_id = "";                    //商户号              微信支付分配的商户号 
		String device_info = "";                               //设备号              微信支付分配的终端设备号，商户自定义 
		String nonce_str = "randomUUID()";              //随机字符串       随机字符串，不长于32位          
		String body = "";                 //商品描述            商品或支付单简要描述
		String detail = "";             //商品详情           商品名称明细列表
		String attach = "";                                    //附加数据            附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据 
		String out_trade_no = "";      //商户订单号        商户系统内部的订单号,32个字符内、可包含字母, 其他说明见商户订单号
		String fee_type = "CNY";                               //货币类型            符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
		String total_fee = "";   //总金额                订单总金额，只能为整数，详见支付金额
		String spbill_create_ip = "";      //终端IP        APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP
		String time_start = WxUtilEx.getCurrentTime();          //交易起始时间     订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010
		String time_expire = "";                               //交易结束时间     订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010
		String goods_tag = "";                                 //商品标记             商品标记，代金券或立减优惠功能的参数，说明详见代金券或立减优惠
		String notify_url = "";  //通知地址             接收微信支付异步通知回调地址
		String trade_type = "APP";                             //交易类型             取值如下：JSAPI，NATIVE，APP
		String product_id = "";                                //商品id        trade_type=NATIVE，此参数必传。此id为二维码中包含的商品ID，商户自行定义
		String openid = "";                                    //用户标识             trade_type=JSAPI，此参数必传，用户在商户appid下的唯一标识。下单前需要调用【网页授权获取用户信息】接口获取到用户的Openid
		String key = "";  //微信appkey
		
		
		//=========================
		//生成预支付单
		//=========================

		//设置预支付单 请求参数
		SortedMap<String, String> post_map = new TreeMap<String, String>();
		post_map.put("appid", appid);
		post_map.put("mch_id", mch_id);
		post_map.put("device_info", device_info);
		post_map.put("nonce_str", nonce_str);
		post_map.put("body", body);
		post_map.put("detail", detail);
		post_map.put("attach", attach);
		post_map.put("out_trade_no", out_trade_no);
		post_map.put("fee_type", fee_type);
		post_map.put("total_fee", total_fee);
		post_map.put("spbill_create_ip", spbill_create_ip);
		post_map.put("time_start", time_start);
		post_map.put("time_expire", time_expire);
		post_map.put("goods_tag", goods_tag);
		post_map.put("notify_url", notify_url);
		post_map.put("trade_type", trade_type);
		post_map.put("product_id", product_id);
		post_map.put("openid", openid);
		
		
		//签名
		WxUtilEx.signMapWithMd5(post_map, key);
				
		//发送请求，获取预支付信息
		Map<String, String> return_map = WxUtilEx.postUnifiedOrder(post_map);
		
		
		//-----------------统一支付返回结果----------------
		if ("SUCCESS".equals(return_map.get("return_code"))) {
			//TODO
			
		}
				
		if ("SUCCESS".equals(return_map.get("return_code")) && "SUCCESS".equals(return_map.get("result_code"))) {
			//TODO
			
		}
		
		if (!WxUtilEx.checkMapSign(return_map, key)) {
			throw new Exception("错误：签名不相同");
		}
		//---------------统一支付返回结果结束-----------------
		
		
		//------------------------扫码支付-------------------------------
		//如果是扫码支付，则只关注code_url即可
		String coed_url = return_map.get("code_url"); //微信二维码URL
		//TODO 
		//return code url
		//------------------------扫码支付结束-------------------------------
		
		//------------------------APP端支付返回的数据-------------------------------
		//如果是APP端，返回给APP数据
		SortedMap<String, String> app_call_pack = new TreeMap<String, String>();
		
		//获取预支付ID ， 此预支付ID为APP端调用
		String prepayid = return_map.get("prepay_id");
		if (StringUtils.isNotBlank(prepayid)) { 
			//设置支付参数
			app_call_pack.put("appid", appid); //公众号id    微信分配的公众账号ID
			app_call_pack.put("partnerid", mch_id); //商户号            微信支付分配的商户号
			app_call_pack.put("prepayid", prepayid); //预支付交易会话id    微信返回的支付交易会话ID
			app_call_pack.put("package", "Sign=WXPay"); //扩展字段              暂填写固定值Sign=WXPay
			app_call_pack.put("noncestr", "randomUUID()"); //随机字符串, 不长于32位
			app_call_pack.put("timestamp", WxUtilEx.getTimeStamp()); //时间戳
			
			//签名
			WxUtilEx.signMapWithMd5(app_call_pack, key);
			
			//返回数据给APP端
			//TODO 
			// reutrn app_call_pack
		}
		//------------------------APP端支付返回的数据结束-------------------------------
	}
	
	@Test //接收微信通知示例
	public void testReceiveWeixinNotify() {
		
		//需要微信分配的信息
//		String key = "";    //微信appkey
//		String appid = "";  //公众号ID     微信分配的公众账号ID
//		String mch_id = ""; //商户号              微信支付分配的商户号 
		
		
		//1.获取微信通知请求
//		Map<String,String> result = WxUtilEx.requestStream2Map(request);
		
		//2.进行对返回的数据签名
//		if(!WxUtilEx.checkMapSign(result, key)) {
//			throw new Exception("接收微信异步通知返回的数据签名不正确：" + result.toString());
//		}
		
		//3.校验返回数据是否为SUCCESS
//		if("SUCCESS".equals(result.get("return_code")) && "SUCCESS".equals(result.get("result_code"))){
//			//TODO 各种业务处理后,更新订单状态
//				
//				
//				
//		}else {
//			throw new Exception("接收微信异步通知返回的数据异常：" + result.toString());
//		}
		
		//4.返回成功的信息
//		Map toWeixin = new HashMap();
//		toWeixin.put("return_code", "SUCCESS");
//		toWeixin.put("return_msg", "OK");
//		
//		return WxUtilEx.map2XmlString(toWeixin);
		
	}
	
}
