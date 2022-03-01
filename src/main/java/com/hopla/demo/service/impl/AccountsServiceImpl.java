package com.hopla.demo.service.impl;

import com.hopla.demo.model.leanXcale.Transactions;
import com.hopla.demo.model.mongo.Accounts;
import com.hopla.demo.repository.mongo.AccountsRepository;
import com.hopla.demo.service.AccountsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AccountsServiceImpl implements AccountsService {

    AccountsRepository repository;

    public AccountsServiceImpl(AccountsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Accounts> findByAll() {
        return repository.findAll();
    }

    @Override
    public Accounts findById(String id) {
        return repository.findById(id).get();
    }

    @Override
    public Accounts save(Accounts accounts) {
        return repository.save(accounts);
    }

    @Override
    public Map<String, List<Accounts>> findAllById(Set<String> dni) {
        Map<String,List<Accounts>> transactions= repository.findByDniIn(dni).stream().collect(Collectors.groupingBy(Accounts::getDni));
        return transactions;
    }
}
