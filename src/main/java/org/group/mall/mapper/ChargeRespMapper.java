package org.group.mall.mapper;

import org.group.mall.model.payment.ChargeResp;
import org.group.mall.model.payment.ChargeRespDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.group.mall.model.payment.ChargeReq;
import org.group.mall.model.payment.ChargeReqDTO;

@Mapper(componentModel = "spring")
public interface ChargeRespMapper {

    ChargeRespDTO toDTO(ChargeResp chargeResp);
    ChargeResp toEntity(ChargeRespDTO chargeReqDTO);
}