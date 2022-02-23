package com.hopla.demo.service.impl;

import com.hopla.demo.model.mongo.Accounts;
import com.hopla.demo.repository.mongo.AccountsRepository;
import com.hopla.demo.service.AccountsService;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
