package com.hopla.demo.service;

import com.hopla.demo.model.Clients;
import com.hopla.demo.model.Loans;
import org.checkerframework.checker.units.qual.C;
import org.springframework.data.domain.Page;

public interface ClientsService {

    public Clients findById(String id);

    public Page<Clients>findPage(Integer size,Integer page);


}
