package com.StockTracker.StockTracker.Models;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;

@Entity

public class StatusType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long StatusId;

    @NotBlank
    private String Status;
}
