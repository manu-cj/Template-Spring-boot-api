package com.manu.template.mapper;

import com.manu.template.dto.PaymentDTO;
import com.manu.template.model.Payment;

public class PaymentMapper {
    public static Payment toEntity(PaymentDTO dto) {
        Payment entity = new Payment();
        entity.setId(dto.getId());
        entity.setAmount(dto.getAmount());
        entity.setCurrency(dto.getCurrency());
        entity.setDate(dto.getDate());
        entity.setMethod(dto.getMethod());
        entity.setStatus(dto.getStatus());
        return entity;
    }

    public static PaymentDTO toDto(Payment entity) {
        PaymentDTO dto = new PaymentDTO();
        dto.setId(entity.getId());
        dto.setAmount(entity.getAmount());
        dto.setCurrency(entity.getCurrency());
        dto.setDate(entity.getDate());
        dto.setMethod(entity.getMethod());
        dto.setStatus(entity.getStatus());
        return dto;
    }
}