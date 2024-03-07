package com.StockTracker.StockTracker.Repository;

import com.StockTracker.StockTracker.Models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface UserRepository extends CrudRepository<User, Serializable> {

    User findById(short id);

}
