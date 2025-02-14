package org.group.mall.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.group.mall.model.payment.ChargeReq;
import org.group.mall.model.payment.ChargeReqDTO;

@Mapper(componentModel = "spring")
public interface ChargeReqMapper {
    ChargeReqDTO toDTO(ChargeReq chargeReq);
    ChargeReq toEntity(ChargeReqDTO chargeReqDTO);
}