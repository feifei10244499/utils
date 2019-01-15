package com.util.alisms;


import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * 短信数据
 * @author feifei
 */
public class SmsData {
	
	private SmsTemplate msgTemplate;
	private Map<String, String> data;
	
	/**
	 * 多个手机号用逗号隔开
	 */
	private String phoneNumbers;
	
	public SmsData(SmsTemplate msgTemplate) {
		this.msgTemplate= msgTemplate;
		data = new HashMap<String,String>();
	}
	
	public SmsData(SmsTemplate msgTemplate, Map<String, String> data, String phoneNumbers) {
		this.msgTemplate= msgTemplate;
		this.data = data;
		this.phoneNumbers = phoneNumbers;
	}

	public String[] getMsgKey() {
		return msgTemplate.getParameterKey();
	}
	
	public Boolean setMsgData(Map<String, String> map) {
		Boolean result = true;
		if(map.size()>1){
			JSONObject json = JSONObject.fromObject(map);
			data = json;
		}else {
			String[] key = msgTemplate.getParameterKey();
			if (key != null) {
				for (int i = 0; i < key.length; i++) {
					System.out.println(getData());
					String value = map.get(key[i]);
					System.out.println(value);
					if (value != null && !value.equals("")) {
						data.put(key[i], value);
					} else {
						result = false;
						break;
					}

				}
			}
			System.out.println(getData());
			// 如果为false，则清除数据
			if (!result) {
				data.clear();
			}
		}
		return result;
	}


	public String getPhoneNumbers() {
		return phoneNumbers;
	}


	public void setPhoneNumbers(String phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	
	public String getTemplateName() {
		return msgTemplate.getTemplateName();
	}


	public String getData() {
		String result = "{";
		for (String key : data.keySet()) {
			 result += "\"" + key + "\":\"" + data.get(key) + "\""+",";
		}
		result += "}";
		return result;
	}
	
}
