package org.group.mall.constant;

import lombok.Getter;

@Getter
public enum ChargeStatus {
    SUCCESS(1001,"付款成功"),
    FAILED(2001,"付款失败"),
    PENDING(3001,"PENDING");

    private final int code;
    private final String message;


    ChargeStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
