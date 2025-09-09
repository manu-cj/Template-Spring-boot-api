package com.manu.template.controller;

import com.manu.template.dto.PaymentDTO;
import com.manu.template.mapper.PaymentMapper;
import com.manu.template.model.Payment;
import com.manu.template.repository.PaymentRepository;
import com.manu.template.service.PaymentXmlService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private PaymentXmlService paymentXmlService;

    @PostMapping(value = "/xml", consumes = "application/xml")
    public PaymentDTO createPaymentFromXml(@RequestBody String xml) throws Exception {
        PaymentDTO paymentDTO = paymentXmlService.fromXml(xml);
        Payment entity = PaymentMapper.toEntity(paymentDTO);
        entity = paymentRepository.save(entity);
        return PaymentMapper.toDto(entity);
    }

    @GetMapping(value = "/{id}/xml", produces = "application/xml")
    public String getPaymentXml(@PathVariable UUID id) throws Exception {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Payment not found"));

        PaymentDTO paymentDTO = PaymentMapper.toDto(payment);

        return paymentXmlService.toXml(paymentDTO);
    }

}
