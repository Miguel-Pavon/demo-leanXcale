package com.hopla.demo.resolver;

import com.hopla.demo.model.input.AccountsInput;
import com.hopla.demo.model.mongo.Accounts;
import com.hopla.demo.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
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


    @MutationMapping
    public Accounts addAccount (@Argument AccountsInput input){
        Accounts accounts = Accounts.builder()
                .dni(input.getDni())
                .name(input.getName())
                .last_name(input.getLast_name())
                .type(input.getType())
                .balance(input.getBalance()).build();
        return accountsService.save(accounts);


    }
}
