package com.example.repository;

import com.example.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kajornsak on 4/23/2017 AD.
 */
@Repository
public interface AccountRepository extends MongoRepository<Account,String> {
    Account findByUsername(String username);
    List<Account> findAll();
}

