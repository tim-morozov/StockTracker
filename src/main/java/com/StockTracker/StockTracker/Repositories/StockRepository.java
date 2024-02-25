package com.StockTracker.StockTracker.Repositories;

import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface StockRepository<Stock, Id extends Serializable> extends CrudRepository<Stock, Serializable> {
        Stock GetStockById(int Id);
}
