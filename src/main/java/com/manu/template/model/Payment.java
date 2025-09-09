package com.manu.template.model;

import com.manu.template.dto.LocalDateAdapter;
import com.manu.template.dto.UUIDAdapter;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@XmlRootElement(name = "payment")
public class Payment {
    @Id
    @GeneratedValue
    private UUID id;
    private double amount;
    private String currency;
    private LocalDate date;
    private String method;
    private String status;

    // Constructeur vide obligatoire pour JAXB
    public Payment() {}

    public Payment(UUID id, double amount, String currency, LocalDate date, String method, String status) {
        this.id = id;
        this.amount = amount;
        this.currency = currency;
        this.date = date;
        this.method = method;
        this.status = status;
    }

    @XmlElement
    @XmlJavaTypeAdapter(UUIDAdapter.class)
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    @XmlElement
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    @XmlElement
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    @XmlElement
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    @XmlElement
    public String getMethod() { return method; }
    public void setMethod(String method) { this.method = method; }

    @XmlElement
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}