package org.group.mall.service;

import lombok.extern.slf4j.Slf4j;
import org.group.mall.constant.ErrorCode;
import org.group.mall.constant.PaymentMethod;
import org.group.mall.constant.PaymentStatus;
import org.group.mall.model.payment.*;
import org.group.mall.utils.CreditCardUtil;
import org.group.mall.utils.SnowflakeUtil;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class PaymentService {
    public CreditPayResp creditPay(CreditPayReq request){
        return CreditPayResp.success(String.valueOf(SnowflakeUtil.nextId()),
                request.getOrderId(), request.getAmount());
    }
    public ChargeResp charge(ChargeReq request){

        String cardNum=request.getCreditCard().getCredit_card_number();
        String cvv=Integer.toString(request.getCreditCard().getCredit_card_cvv());

        if (!CreditCardUtil.isValidCardNumber(cardNum,cvv)){
            log.info("{}支付失败，信用卡信息为{}",request.getOrderId(),request.getCreditCard());
            return ChargeResp.failure(ErrorCode.CREDITCARD_INFO_FAIL.getCode(),
                    ErrorCode.CREDITCARD_INFO_FAIL.getMessage(), request.getOrderId(),
                    request.getAmount());
        }

        CreditPayReq req=new CreditPayReq(request.getOrderId(),request.getAmount(),
                "CNY",request.getCreditCard());
        CreditPayResp creditPayResp = creditPay(req);

        if (!Objects.equals(creditPayResp.getPaymentStatus(), PaymentStatus.SUCCESS.getCode())){
            log.info("{}支付失败，信用卡信息为{}",request.getOrderId(),request.getCreditCard());
            return ChargeResp.failure(Integer.parseInt(creditPayResp.getErrorCode()),
                    creditPayResp.getErrorMessage(),creditPayResp.getOrderId(),
                    creditPayResp.getAmount());
        }

        log.info("{}支付成功，信用卡信息为{}",request.getOrderId(),request.getCreditCard());
        return ChargeResp.success(creditPayResp.getTransactionId(),
                creditPayResp.getOrderId(),creditPayResp.getAmount(),
                PaymentMethod.CREDIT_CARD.getCode());
    }
}
