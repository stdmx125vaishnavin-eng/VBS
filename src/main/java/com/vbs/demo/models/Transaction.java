package com.vbs.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "amount", nullable = false)
    private double amount;

    // 🔑 DB: current_balance → Java: currentBalance → JSON: currentBalance
    @Column(name = "current_balance", nullable = false)
    private double currBalance;

    @Column(name = "description", nullable = false)
    private String description;

    // 🔑 DB: user_id → Java: userId → JSON: userId
    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "date", nullable = false, updatable = false)
    private LocalDateTime date;

    @PrePersist
    protected void onCreate() {
        this.date = LocalDateTime.now();
    }
}
