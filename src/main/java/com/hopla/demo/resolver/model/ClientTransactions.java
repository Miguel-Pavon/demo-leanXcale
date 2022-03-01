package com.hopla.demo.resolver.model;


import com.hopla.demo.model.leanXcale.Clients;
import com.hopla.demo.model.leanXcale.CreditCars;
import com.hopla.demo.model.leanXcale.Transactions;
import com.hopla.demo.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@SchemaMapping(typeName = "CreditCards")
@Controller
public class ClientTransactions {

    @Autowired
    TransactionsService transactionsService;

    @BatchMapping
    public Mono<Map<CreditCars, List<Transactions>>> transactions(List<CreditCars>creditCarsList){
        Set<String> ids = creditCarsList.stream().map((CreditCars creditCars)->creditCars.getNumber()).collect(Collectors.toSet());
        Map<String,List<Transactions>>creditCars = transactionsService.findAllById(ids);
        return Mono.just(creditCarsList.stream().collect(Collectors.toMap(Function.identity(),(CreditCars creditCars1)->creditCars.get(creditCars1.getNumber()))));
    }
}
