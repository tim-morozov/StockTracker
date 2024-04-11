package com.StockTracker.StockTracker.Repository;

import com.StockTracker.StockTracker.Models.MarketSchedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface MarketScheduleRepository extends CrudRepository<MarketSchedule, Serializable> {

    List<MarketSchedule> findAll();


}
