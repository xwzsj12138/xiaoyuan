//package com.wm.project.project.controller;
////
////
////
////import com.loran.lobster.api.comment.HttpRequest;
////import com.loran.lobster.api.comment.UniqueOrderGenerate;
////import com.loran.lobster.api.comment.wxpay.WXPayUtil;
////import com.loran.lobster.api.entity.Address;
////import com.loran.lobster.api.service.AddressService;
////import com.loran.lobster.api.service.OrderGoodsService;
////import com.loran.lobster.api.service.OrderService;
////import com.loran.lobster.api.service.UserinfoService;
////import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.InputStream;
//import java.math.BigDecimal;
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//@RequestMapping("pay")
//public class WXPayController {
//
////    @Autowired
////    private AddressService addressService;
////    @Autowired
////    private OrderGoodsService orderGoodsService;
////    @Autowired
////    private OrderService orderService;
////    @Autowired
////    private UserinfoService userinfoService;
//    @Value("${vendor.wx.pay.mch_id}")
//    private String mch_id;
//    @Value("${vendor.wx.pay.key}")
//    private String MerchantKey;
//    @Value("${vendor.wx.config.app_id}")
//    private String app_id;
//    /**
//     * @Description 微信浏览器内微信支付/公众号支付(JSAPI)
//     * @param request
//     * @return Map
//     */
//    @GetMapping(value="/ordersPay")
//    public Map orders(HttpServletRequest request, String openid,Integer addressid) {
//        Map<String, String> result = new HashMap<>();
//        try {
//            //拼接统一下单地址参数
//            Map<String, String> paraMap = new HashMap<String, String>();
//            //获取请求ip地址
//            String ip = request.getHeader("x-forwarded-for");
//            if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
//                ip = request.getHeader("Proxy-Client-IP");
//            }
//            if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
//                ip = request.getHeader("WL-Proxy-Client-IP");
//            }
//            if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
//                ip = request.getRemoteAddr();
//            }
//            if(ip.indexOf(",")!=-1){
//                String[] ips = ip.split(",");
//                ip = ips[0].trim();
//            }
//            Address address = addressService.findAddress(addressid).get(0);
//            String ShippingAddress = address.getAddressReceiving()+address.getAddressHouseNumber();
//            paraMap.put("appid", app_id);
//            paraMap.put("body", "订单结算");
//            paraMap.put("attach",ShippingAddress );
//            paraMap.put("mch_id", "1532416151");
//            paraMap.put("nonce_str", WXPayUtil.generateNonceStr());
//            paraMap.put("openid", openid);
//            paraMap.put("out_trade_no", UniqueOrderGenerate.getOrderIdByTime());//订单号
//            paraMap.put("spbill_create_ip", ip);
//            paraMap.put("total_fee","1");
//            paraMap.put("trade_type", "JSAPI");
//            paraMap.put("notify_url","http://codingqicf.natapp1.cc/pay/payCallback");// 此路径是微信服务器调用支付结果通知路径随意写
//            String sign = WXPayUtil.generateSignature(paraMap, MerchantKey);
//            paraMap.put("sign", sign);
//            String xml = WXPayUtil.mapToXml(paraMap);//将所有参数(map)转xml格式
//            // 统一下单 https://api.mch.weixin.qq.com/pay/unifiedorder
//            String unifiedorder_url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
//            String xmlStr = HttpRequest.sendPost(unifiedorder_url, xml);//发送post请求"统一下单接口"返回预支付id:prepay_id


            // ******************************************
            //
            //  前端调起微信支付必要参数
            //
            // ******************************************
//            String prepay_id = "";//预支付id
//            if (xmlStr.indexOf("SUCCESS") != -1) {
//                Map<String, String> map = WXPayUtil.xmlToMap(xmlStr);
//                prepay_id = (String) map.get("prepay_id");
//            }
//            String packages = "prepay_id=" + prepay_id;
//            Map<String, String> wxPayMap = new HashMap<String, String>();
//            wxPayMap.put("appId", app_id);
//            wxPayMap.put("timeStamp", String.valueOf(WXPayUtil.getCurrentTimestamp()));
//            wxPayMap.put("nonceStr", WXPayUtil.generateNonceStr());
//            wxPayMap.put("package", packages);
//            wxPayMap.put("signType", "MD5");
//            String paySign = WXPayUtil.generateSignature(wxPayMap,MerchantKey);
            // ******************************************
            //
            //  返回给前端调起微信支付的必要参数
            //
            // ******************************************
//            result.put("prepay_id", prepay_id);
//            result.put("sign", paySign);
//            result.putAll(wxPayMap);
//            return result;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }


//    /**
//     * 回调方法，必须是无参数方法
//     * @param request  接收支付参数
//     * @param response  告诉微信结果
//     * @return
//     */
//    @PostMapping(value = "/payCallback")
//    public String callBack(HttpServletRequest request, HttpServletResponse response){
//        //System.out.println("微信支付成功,微信发送的callback信息,请注意修改订单信息");
//        InputStream is = null;
//        String xmlBack="";
//        try {
//            is = request.getInputStream();//获取请求的流信息(这里是微信发的xml格式所有只能使用流来读)
//            String xml = WXPayUtil.InputStream2String(is, "UTF-8");
//            Map<String, String> notifyMap = WXPayUtil.xmlToMap(xml);//将微信发的xml转map
//            System.out.println(notifyMap);
//            if(notifyMap.get("return_code").equals("SUCCESS")){
//                if(notifyMap.get("result_code").equals("SUCCESS")){
//                    String out_trade_no = notifyMap.get("out_trade_no");//订单号
//                    if (out_trade_no == null) {
//                        System.err.println("微信支付回调失败订单号: {}"+notifyMap);
//                        xmlBack = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>" + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
//                        return xmlBack;
//                    }
//                    /*以下是自己的业务处理------仅做参考
//                     *    添加 商品订单表数据。清空购物车。 添加订单信息
//                     */
//
//
//
//
//
//                    xmlBack = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>" + "<return_msg><![CDATA[SUCCESS]]></return_msg>" + "</xml> ";
//                    return xmlBack;
//                }else{
//                    xmlBack = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>" + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
//                    return xmlBack;
//                }
//            }
//
//
//            //告诉微信服务器收到信息了，不要在调用回调action了========这里很重要回复微信服务器信息用流发送一个xml即可
//            response.getWriter().write("<xml><return_code><![CDATA[SUCCESS]]></return_code></xml>");
//            is.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.err.println("微信支付回调通知失败");
//            String result = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>" + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
//            return result;
//        }
//        return null;
//    }
//
//}
//

