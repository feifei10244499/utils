package com.util.alisms;

/**
 * @author feife
 */

public enum SmsTemplate {
    /**
     *注册
     */
	RegisterAndFindPwd("SMS_86705123", "注册", false, new String[] {"code"}),
    /**
     *商家同意退款
     */
	SellerAgressRefund("SMS_86540106", "商家同意退款", false, new String[] {"goodsName", "orderId"});

	/**
	 * 模块名称
	 */
	private String templateName;
	/**
	 * 描述
	 */
	private String describe;
	/**
	 * 是否多发
	 */
	private Boolean isGroupSend;
	private String[] parameterKey;
	
	private SmsTemplate(String templateName, String describe, Boolean isGroupSend, String[] parameterKey) {
		this.templateName = templateName;
		this.describe = describe;
		this.isGroupSend = isGroupSend;
		this.parameterKey = parameterKey;
	}

	public String getTemplateName() {
		return templateName;
	}

	public String getDescribe() {
		return describe;
	}

	public Boolean getIsGroupSend() {
		return isGroupSend;
	}

	public String[] getParameterKey() {
		return parameterKey;
	}
}
