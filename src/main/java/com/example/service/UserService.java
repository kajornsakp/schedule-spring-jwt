package com.example.service;

import com.example.model.Account;
import com.example.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kajornsak on 4/23/2017 AD.
 */
//@Service
//public class UserService {
//
//    private AccountRepository accountRepository;
//
//    @Autowired
//    public UserService(AccountRepository accountRepository) {
//        this.accountRepository = accountRepository;
//    }
//
//    public Account save(Account account){
//        return this.accountRepository.insert(account);
//    }
//
//    public List<Account> findAll(){
//        return this.accountRepository.findAll();
//    }
//
//    public Account findAccountByUsername(String username){
//        return this.accountRepository.findByUsername(username);
//    }
//
//    public Boolean authenticate(String username,String password){
//        Account account = findAccountByUsername(username);
//        System.out.println(account);
//        if (account != null){
//            return account.getPassword().equals(password);
//        }
//        return false;
//    }
//
//
//}
