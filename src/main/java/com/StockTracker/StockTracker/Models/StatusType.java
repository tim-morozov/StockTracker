package com.StockTracker.StockTracker.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import javax.validation.constraints.NotBlank;

@Entity
public class StatusType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long StatusId;

    @NotBlank
    private String Status;
}
