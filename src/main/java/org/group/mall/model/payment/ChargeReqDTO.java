package org.group.mall.model.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChargeReqDTO {
    private BigDecimal amount;         // 交易金额
    private String currency;           // 货币类型（CNY, USD等）
    private String orderId;            // 订单 ID
    private Long userId;               // 用户 ID
    private CreditCardInfo creditCard; // 信用卡信息
    private String description;        // 交易描述
    private String clientIp;           // 用户 IP 地址
    private LocalTime timestamp;            // 交易时间戳（毫秒级）
    private String paymentChannel;     // 支付渠道（VISA, PayPal, Apple Pay等）
}