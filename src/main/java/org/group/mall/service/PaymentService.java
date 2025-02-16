package org.group.mall.service;

import lombok.extern.slf4j.Slf4j;
import org.group.mall.constant.ErrorCode;
import org.group.mall.constant.PaymentMethod;
import org.group.mall.constant.PaymentStatus;
import org.group.mall.model.payment.*;
import org.group.mall.repository.payment.PaymentRecordRepository;
import org.group.mall.utils.CreditCardUtil;
import org.group.mall.utils.SnowflakeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
@Slf4j
public class PaymentService {
    private final PaymentRecordRepository paymentRecordRepository;

    @Autowired
    public PaymentService(PaymentRecordRepository paymentRecordRepository) {
        this.paymentRecordRepository = paymentRecordRepository;
    }

    public CreditPayResp creditPay(CreditPayReq request){
        return CreditPayResp.success(String.valueOf(SnowflakeUtil.nextId()),
                request.getOrderId(), request.getAmount());
    }

    @Transactional
    public ChargeResp charge(ChargeReq request){
        String cardNum=request.getCreditCard().getCredit_card_number();
        String cvv=Integer.toString(request.getCreditCard().getCredit_card_cvv());

        if (!CreditCardUtil.isValidCardNumber(cardNum,cvv)){
            log.info("付款失败，信用卡信息为{}",request.getCreditCard());
            ChargeResp resp = ChargeResp.failure(ErrorCode.CREDITCARD_INFO_FAIL.getCode(),
                    ErrorCode.CREDITCARD_INFO_FAIL.getMessage(), request.getOrderId(),
                    request.getAmount());
            savePaymentRecord(resp);
            return resp;
        }

        CreditPayReq req=new CreditPayReq(request.getOrderId(),request.getAmount(),
                "CNY",request.getCreditCard());
        CreditPayResp creditPayResp = creditPay(req);

        if (!Objects.equals(creditPayResp.getPaymentStatus(), "SUCCESS")){
            log.info("付款失败，信用卡信息为{}",request.getCreditCard());
            ChargeResp resp = ChargeResp.failure(Integer.parseInt(creditPayResp.getErrorCode()),
                    creditPayResp.getErrorMessage(), creditPayResp.getOrderId(),
                    creditPayResp.getAmount());
            savePaymentRecord(resp);
            return resp;
        }

        log.info("付款成功，信用卡信息为{}",request.getCreditCard());
        ChargeResp resp = ChargeResp.success(creditPayResp.getTransactionId(),
                creditPayResp.getOrderId(), creditPayResp.getAmount(),
                PaymentMethod.CREDIT_CARD.getCode());
        savePaymentRecord(resp);
        return resp;
    }

    private void savePaymentRecord(ChargeResp resp){
        PaymentRecord paymentRecord=PaymentRecord.builder().orderId(resp.getOrderId())
                .amount(resp.getAmount().doubleValue()).status(resp.getStatus()).paymentMethod(resp.getPaymentMethod())
                .errorCode(String.valueOf(resp.getErrorCode())).errorMessage(resp.getErrorMessage()).transactionId(resp.getTransactionId()).createdAt(LocalDateTime.now()).build();
        paymentRecordRepository.save(paymentRecord);
    }
}
