package com.StockTracker.StockTracker.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface UserRepository<User, Id extends Serializable> extends CrudRepository<User, Serializable> {

    User findById(short id);


}
