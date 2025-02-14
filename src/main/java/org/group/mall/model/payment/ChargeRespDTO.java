package org.group.mall.model.payment;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ChargeRespDTO {
    private String transactionId; // 交易 ID
    private String status;        // 交易状态 (SUCCESS, FAILED, PENDING)
    private Integer errorCode;    // 错误代码（可为空）
    private String errorMessage;  // 错误信息（可为空）
    private LocalDateTime timestamp; // 交易时间
    private String orderId;       // 订单 ID
    private BigDecimal amount;    // 支付金额
    private String paymentMethod; // 支付方式 (CREDIT_CARD, PAYPAL, APPLE_PAY)

    /**
     * 从 ChargeResp 转换为 ChargeRespDTO
     */
    public static ChargeRespDTO from(ChargeResp chargeResp) {
        ChargeRespDTO dto = new ChargeRespDTO();
        dto.transactionId = chargeResp.getTransactionId();
        dto.status = chargeResp.getStatus();
        dto.errorCode = chargeResp.getErrorCode();
        dto.errorMessage = chargeResp.getErrorMessage();
        dto.timestamp = chargeResp.getTimestamp();
        dto.orderId = chargeResp.getOrderId();
        dto.amount = chargeResp.getAmount();
        dto.paymentMethod = chargeResp.getPaymentMethod();
        return dto;
    }
}