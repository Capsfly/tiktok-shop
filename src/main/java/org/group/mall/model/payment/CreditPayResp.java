package org.group.mall.model.payment;


import lombok.Data;
import org.group.mall.constant.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CreditPayResp {
    private String transactionId;  // 交易 ID（由支付系统生成）
    private String orderId;        // 订单 ID
    private BigDecimal amount;     // 支付金额
    private String paymentStatus;
    private String errorCode;
    private String errorMessage;   // 具体错误信息
    private LocalDateTime timestamp; // 交易时间

    public static CreditPayResp success(String transactionId, String orderId, BigDecimal amount) {
        CreditPayResp resp = new CreditPayResp();
        resp.transactionId = transactionId;
        resp.orderId = orderId;
        resp.amount = amount;
        resp.paymentStatus = "SUCCESS";
        resp.timestamp = LocalDateTime.now();
        return resp;
    }

    public static CreditPayResp failure(String errorCode, String errorMessage, String orderId, BigDecimal amount) {
        CreditPayResp resp = new CreditPayResp();
        resp.orderId = orderId;
        resp.amount = amount;
        resp.paymentStatus = "FAIL";
        resp.errorCode = errorCode;
        resp.errorMessage = errorMessage;
        resp.timestamp = LocalDateTime.now();
        return resp;
    }
}
