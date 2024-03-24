package com.StockTracker.StockTracker.Repository;

import com.StockTracker.StockTracker.Models.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface UserRepository extends CrudRepository<User, Serializable> {

    User findById(long id);

    @Query("select u from users u where u.EmailAddress = :emailaddress")
    User findUserByEmailAddress(@Param("emailaddress") String EmailAddress);

    @Query(value="select * from users u where u.user_name = ?1")
    User findUserByUserName(String userName);

}
