package com.hopla.demo.service.impl;


import com.hopla.demo.model.leanXcale.Transactions;
import com.hopla.demo.repository.leanXcale.TransactionsRepository;
import com.hopla.demo.service.TransactionsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TransactionsServiceImpl implements TransactionsService {

    TransactionsRepository repository;

    public TransactionsServiceImpl(TransactionsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Map<String, List<Transactions>> findAllById(Set<String> id) {
        Map<String,List<Transactions>> transactions= repository.findByCreditCardIn(id).stream().collect(Collectors.groupingBy(Transactions::getCreditCard));
        return transactions;
    }
}
