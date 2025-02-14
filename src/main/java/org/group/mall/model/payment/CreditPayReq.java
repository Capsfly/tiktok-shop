package org.group.mall.model.payment;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditPayReq {

    @NotBlank(message = "订单 ID 不能为空")
    private String orderId; // 订单 ID

    @NotNull(message = "支付金额不能为空")
    @DecimalMin(value = "0.01", message = "支付金额必须大于 0")
    private BigDecimal amount; // 支付金额

    @NotBlank(message = "币种不能为空")
    private String currency; // 货币（USD, CNY）

    @NotNull(message = "信用卡信息不能为空")
    private CreditCardInfo creditCard; // 信用卡信息


}
