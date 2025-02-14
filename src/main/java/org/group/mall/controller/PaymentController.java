package org.group.mall.controller;

import lombok.extern.slf4j.Slf4j;
import org.group.mall.mapper.ChargeReqMapper;
import org.group.mall.mapper.ChargeRespMapper;
import org.group.mall.model.payment.ChargeReq;
import org.group.mall.model.payment.ChargeReqDTO;
import org.group.mall.model.payment.ChargeResp;
import org.group.mall.model.payment.ChargeRespDTO;
import org.group.mall.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/payment")
public class PaymentController {
    private final PaymentService paymentService;
    private final ChargeReqMapper chargeReqMapper;
    private final ChargeRespMapper chargeRespMapper;

    @Autowired
    public PaymentController(PaymentService paymentService, ChargeReqMapper chargeReqMapper, ChargeRespMapper chargeRespMapper) {
        this.paymentService = paymentService;
        this.chargeReqMapper = chargeReqMapper;
        this.chargeRespMapper = chargeRespMapper;
    }

    @PostMapping("/charge")
    public ResponseEntity<ChargeRespDTO> charge(@RequestBody ChargeReqDTO req){
        log.info("收到付款请求:{}",req);
        ChargeReq chargeReq= chargeReqMapper.toEntity(req);
        ChargeResp chargeresp=paymentService.charge(chargeReq);
        ChargeRespDTO chargeRespDTO=chargeRespMapper.toDTO(chargeresp);
        return new ResponseEntity<>(chargeRespDTO,HttpStatus.OK);
    }
}
