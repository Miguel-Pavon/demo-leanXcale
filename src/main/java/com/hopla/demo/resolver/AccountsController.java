package com.hopla.demo.resolver;

import com.hopla.demo.model.mongo.Accounts;
import com.hopla.demo.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AccountsController {


    @Autowired
    AccountsService accountsService;

    @QueryMapping
    public List<Accounts> fetchAccount (){
       return accountsService.findByAll();
    }

}
