package com.StockTracker.StockTracker.Repository;

import com.StockTracker.StockTracker.Models.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

@Repository
public interface StockRepository extends CrudRepository<Stock, Event.ID> {
    List<Stock> findAll();
}
