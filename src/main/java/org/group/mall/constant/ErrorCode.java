package org.group.mall.constant;

import lombok.Getter;

@Getter
public enum ErrorCode {
    INVALID_INPUT(1001, "输入参数无效"),
    PAYMENT_FAILED(2001, "支付失败"),
    INSUFFICIENT_FUNDS(2002, "余额不足"),
    CREDITCARD_INFO_FAIL(2003,"银行卡信息校验失败"),
    UNAUTHORIZED(3001, "未授权访问"),
    SYSTEM_ERROR(5000, "系统内部错误");

    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }


    public static String getMessageByCode(int code) {
        for (ErrorCode error : ErrorCode.values()) {
            if (error.getCode() == code) {
                return error.getMessage();
            }
        }
        return "未知错误";
    }
}