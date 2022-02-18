package com.hopla.demo.web;

import com.hopla.demo.model.Loans;
import com.hopla.demo.service.LoansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.sql.SQLException;
import java.util.List;

@Controller
public class LoansController {

    @Autowired
    LoansService loansService;

    @QueryMapping
    public List<Loans> fechLoans() throws SQLException {
        return loansService.findAll();
    }

    @QueryMapping
    public Loans fechLoansById(@Argument  String id){
        return loansService.findById(id);
    }


}
