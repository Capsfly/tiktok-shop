package org.group.mall.model.payment;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ChargeResp {
    private String transactionId; // 交易 ID
    private String status;        // 交易状态 (SUCCESS, FAILED, PENDING)
    private int errorCode;
    private String errorMessage;
    private LocalDateTime timestamp; // 交易时间
    private String orderId;       // 订单 ID
    private BigDecimal amount;    // 支付金额
    private String paymentMethod; // 支付方式 (CREDIT_CARD, PAYPAL, APPLE_PAY)


    public static ChargeResp success(String transactionId, String orderId, BigDecimal amount, String paymentMethod) {
        ChargeResp resp = new ChargeResp();
        resp.transactionId = transactionId;
        resp.status = "SUCCESS";
        resp.timestamp = LocalDateTime.now();
        resp.orderId = orderId;
        resp.amount = amount;
        resp.paymentMethod = paymentMethod;
        return resp;
    }

    public static ChargeResp failure(int errorCode, String errorMessage, String orderId,
                                     BigDecimal amount) {
        ChargeResp resp = new ChargeResp();
        resp.status = "FAILED";
        resp.errorCode = errorCode;
        resp.errorMessage = errorMessage;
        resp.timestamp = LocalDateTime.now();
        resp.orderId = orderId;
        resp.amount = amount;
        return resp;
    }
}