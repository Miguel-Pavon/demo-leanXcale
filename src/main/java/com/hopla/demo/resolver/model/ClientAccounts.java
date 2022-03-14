package com.hopla.demo.resolver.model;

import com.hopla.demo.model.leanXcale.Clients;
import com.hopla.demo.model.mongo.Accounts;
import com.hopla.demo.service.AccountsService;
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

@SchemaMapping(typeName = "Clients")
@Controller
public class ClientAccounts {


    @Autowired
    AccountsService accountsService;

    @BatchMapping
    public Mono<Map<Clients, List<Accounts>>> account(List<Clients>clients){
        Set<String> dni = clients.stream().map((Clients client)->client.getDni()).collect(Collectors.toSet());
        Map<String,List<Accounts>>accounts = accountsService.findAllById(dni);
        return Mono.just(clients.stream().collect(Collectors.toMap(Function.identity(),(Clients client)->accounts.get(client.getDni()))));
    }
}
