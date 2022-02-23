package com.hopla.demo.service;


import com.hopla.demo.model.mongo.Accounts;

import java.util.List;

public interface AccountsService {

    public List<Accounts> findByAll();

    public  Accounts findById(String id);

    public Accounts save (Accounts accounts);
}
