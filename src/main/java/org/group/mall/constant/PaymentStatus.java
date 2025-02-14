package org.group.mall.constant;


public enum PaymentStatus {
    SUCCESS("0000", "支付成功"),
    FAILED("1000", "支付失败"),
    PENDING("2000", "支付处理中");

    private final String code;
    private final String message;

    PaymentStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
