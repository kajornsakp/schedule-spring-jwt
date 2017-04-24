package com.example.Controller;

import com.example.model.Account;
import com.example.model.AccountDTO;
import com.example.model.JwtUser;
import com.example.repository.AccountRepository;
import com.example.service.JwtService;
import com.example.service.UserAuthService;
import com.oracle.tools.packager.Log;
import com.oracle.webservices.internal.api.message.ContentType;
import com.sun.deploy.net.HttpResponse;
import com.sun.xml.internal.xsom.impl.Ref;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by kajornsak on 4/23/2017 AD.
 */

@RestController
public class AccountController {

    @Autowired
    private UserAuthService userService;

    @Autowired
    private JwtService jwtService;

    public AccountController(UserAuthService service) {
        this.userService = service;
    }

    @RequestMapping(path = "/api/users", method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
    List<Account> listUser(){
        System.out.println("list account");
        return userService.findAll();
    }

    @RequestMapping(path = "/auth/register", method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<?> createAccount(@RequestBody Account newAccount){
        System.out.println("create account");
        Account registeredUser = userService.register(newAccount);
        if(registeredUser != null){
            return ResponseEntity.ok(registeredUser);
        }
        return new ResponseEntity<Object>(null, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(path = "/auth/login",method = RequestMethod.POST,consumes = "application/json",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> auth(@RequestBody AccountDTO auth){
        String username = auth.getUsername();
        String password = auth.getPassword();
        Boolean correctCredentials = userService.authenticate(username,password);
        System.out.println(username + " " + password);
        if (correctCredentials){
            System.out.println(username+ " " + password);
            JwtUser jwtUser = new JwtUser(username,password);
            System.out.println(jwtService.getToken(jwtUser));
            return ResponseEntity.ok(jwtService.getToken(jwtUser));
        }
        return new ResponseEntity<Object>(null, HttpStatus.UNAUTHORIZED);
    }


}
