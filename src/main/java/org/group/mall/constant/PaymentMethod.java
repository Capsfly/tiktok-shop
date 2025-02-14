package org.group.mall.constant;

import lombok.Getter;

@Getter
public enum PaymentMethod {
    ALIPAY("ALIPAY", "支付宝"),
    WECHAT_PAY("WECHAT_PAY", "微信支付"),
    CREDIT_CARD("CREDIT_CARD", "信用卡支付"),
    PAYPAL("PAYPAL", "PayPal 支付");

    private final String code;
    private final String description;

    PaymentMethod(String code, String description) {
        this.code = code;
        this.description = description;
    }


    // 根据 code 获取对应的支付方式
    public static PaymentMethod fromCode(String code) {
        for (PaymentMethod method : PaymentMethod.values()) {
            if (method.getCode().equalsIgnoreCase(code)) {
                return method;
            }
        }
        throw new IllegalArgumentException("未知支付方式: " + code);
    }
}

