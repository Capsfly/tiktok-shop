package org.group.mall.model.payment;

import lombok.Data;

@Data
public class CreditCardInfo {
    private String credit_card_number;
    private int credit_card_cvv ;
    private int credit_card_expiration_year;
    private int credit_card_expiration_month;
}
