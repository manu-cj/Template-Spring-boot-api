package com.manu.template.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.UUID;

@XmlRootElement(name = "payment")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentDTO {
    @XmlJavaTypeAdapter(UUIDAdapter.class)
    private UUID id;
    private double amount;
    private String currency;
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate date;
    private String method;
    private String status;

    public PaymentDTO() {}

    // Getters et setters pour chaque champ
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getMethod() { return method; }
    public void setMethod(String method) { this.method = method; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}