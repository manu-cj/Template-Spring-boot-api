package com.manu.template.dto;

import com.manu.template.model.Method;
import com.manu.template.model.Status;
import jakarta.validation.constraints.NotNull;
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
    private Method method;
    @NotNull
    private Status status = Status.PENDING;

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

    public Method getMethod() { return method; }
    public void setMethod(Method method) { this.method = method; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
}