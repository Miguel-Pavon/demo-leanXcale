package com.hopla.demo.resolver.model;

import com.hopla.demo.model.leanXcale.Clients;
import com.hopla.demo.model.leanXcale.CreditCars;
import com.hopla.demo.service.CreditCardsService;
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
public class ClientCreditCards {

    @Autowired
    CreditCardsService creditCardsService;

    @BatchMapping
    public Mono<Map<Clients,List<CreditCars>>> creditCards(List<Clients>clients){
        Set<String> ids = clients.stream().map((Clients client)->client.getDni()).collect(Collectors.toSet());
        Map<String,List<CreditCars>>creditCars = creditCardsService.findAllById(ids);
        return Mono.just(clients.stream().collect(Collectors.toMap(Function.identity(),(Clients client)->creditCars.get(client.getDni()))));
    }
}
