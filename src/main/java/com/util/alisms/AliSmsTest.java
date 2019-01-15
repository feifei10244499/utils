package com.util.alisms;

import com.aliyuncs.exceptions.ClientException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author feife
 */
public class AliSmsTest {

    /**
     * TEST
     * @param args
     */
    public static void main(String[] args) throws ClientException {
        String phone = "15190411111";
        //String phone = "15190411111,15190411112
        String code = "654321";
        //调用模板
        SmsData data = new SmsData(SmsTemplate.SellerAgressRefund);
        //放入数据
        Map<String, String> map = new HashMap<String, String>(16);
        map.put("orderId", code);
        map.put("goodsName", code);

        data.setMsgData(map);
        data.setPhoneNumbers(phone);
        //发短信
        SmsCode smscode = SmsManager.sendSms(data);
        if(smscode != null && SmsCode.OK .equals(smscode.getCode())) {
            System.out.println("成功");
        }else{
            //查看返回错误信息
            String innerMsg = smscode.getInnerMsg();
            String outMsg = smscode.getOutMsg();
            System.out.println(outMsg);
            System.out.println(innerMsg);
        }
    }

}
