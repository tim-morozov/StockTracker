package com.StockTracker.StockTracker.Repository;

import com.StockTracker.StockTracker.Models.Holiday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface HolidayRepository extends CrudRepository<Holiday, Serializable> {

    List<Holiday> findAll();
}
