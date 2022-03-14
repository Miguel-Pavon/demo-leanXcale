package com.hopla.demo.service;


import com.hopla.demo.model.mongo.Accounts;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface AccountsService {

    public List<Accounts> findByAll();

    public  Accounts findById(String id);

    public Accounts save (Accounts accounts);

    public Map<String, List<Accounts>> findAllById(Set<String> dni);
}
