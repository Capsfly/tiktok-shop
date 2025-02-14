package org.group.mall.model.payment;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ChargeReq {
    private BigDecimal amount;
    private CreditCardInfo creditCard;
    private String orderId;
    private Long userId;
}