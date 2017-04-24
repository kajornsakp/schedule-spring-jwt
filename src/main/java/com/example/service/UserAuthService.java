package com.example.service;

import com.example.model.Account;
import com.example.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kajornsak on 4/23/2017 AD.
 */
@Service
public class UserAuthService implements UserDetailsService {

    private AccountRepository repository;
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public UserAuthService(AccountRepository repository) {
        super();
        this.repository = repository;
    }
    public List<Account> findAll(){
        return this.repository.findAll();
    }


    public Account register(Account account){
        account.setPassword(encodeUserPassword(account.getPassword()));
        if(this.repository.findByUsername(account.getUsername()) == null){
            this.repository.save(account);
            return account;
        }
        return null;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Account account = repository.findByUsername(s);
        if (account == null){
            throw new UsernameNotFoundException("No username : "+ s);
        }
        List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
        String password = account.getPassword();
        return new User(s,password,auth);
    }

    public String encodeUserPassword(String password){
        return passwordEncoder.encode(password);
    }

    public Account findAccountByUsername(String username){
        return this.repository.findByUsername(username);
    }

    public Boolean authenticate(String username,String password){
        Account account = findAccountByUsername(username);
        System.out.println(account);
        if (account != null){
            System.out.println(account.getPassword().equals(password));
            System.out.println(account.getPassword());
            System.out.println(encodeUserPassword(password));
            return passwordEncoder.matches(password,account.getPassword());
        }
        return false;
    }

}
