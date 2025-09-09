package com.manu.template.controller;

import com.manu.template.dto.PaymentDTO;
import com.manu.template.mapper.PaymentMapper;
import com.manu.template.model.Method;
import com.manu.template.model.Payment;
import com.manu.template.model.Status;
import com.manu.template.repository.PaymentRepository;
import com.manu.template.service.PaymentXmlService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private PaymentXmlService paymentXmlService;


    @PostMapping(value = "/xml", consumes = "application/xml")
    public ResponseEntity<Map<String, Object>> createPaymentFromXml(@Valid @RequestBody String xml) throws Exception {
        PaymentDTO paymentDTO = paymentXmlService.fromXml(xml);
        if (paymentDTO.getMethod() != Method.PAYPAL
                && paymentDTO.getMethod() != Method.APPLE_PAY
                && paymentDTO.getMethod() != Method.GOOGLE_PAY
                && paymentDTO.getMethod() != Method.CARTE_BANCAIRE)
        {
            return ResponseEntity.badRequest().body(Map.of("error", "Payment method " + paymentDTO.getMethod() +" is unavailable"));
        }
        if (paymentDTO.getStatus() != Status.PENDING
                && paymentDTO.getStatus() != Status.REJECTED
                && paymentDTO.getStatus() != Status.APPROVED) {
            return ResponseEntity.badRequest().body(Map.of("error", "Payment status " + paymentDTO.getStatus() + " is unavailable"));
        }
        Payment entity = PaymentMapper.toEntity(paymentDTO);
        entity = paymentRepository.save(entity);
        Map<String, Object> response = Map.of(
                "payment", PaymentMapper.toDto(entity)
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{id}/xml", produces = "application/xml")
    public String getPaymentXml(@PathVariable UUID id) throws Exception {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Payment not found"));

        PaymentDTO paymentDTO = PaymentMapper.toDto(payment);

        return paymentXmlService.toXml(paymentDTO);
    }

}
