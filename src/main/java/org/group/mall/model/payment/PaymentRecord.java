package org.group.mall.model.payment;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "payment_record")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 记录ID

    private String orderId;  // 订单ID
    private Double amount;   // 付款金额
    private String status;   // 支付状态 (SUCCESS / FAILED)
    private String paymentMethod; // 支付方式 (CREDIT_CARD)
    private String errorCode; // 失败时的错误码
    private String errorMessage; // 失败时的错误信息
    private String transactionId; // 交易ID (成功时)
    private LocalDateTime createdAt; // 创建时间
}
