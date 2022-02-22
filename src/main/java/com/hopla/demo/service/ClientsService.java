package com.hopla.demo.service;

import com.hopla.demo.model.leanXcale.Clients;
import org.springframework.data.domain.Page;

public interface ClientsService {

    public Clients findById(String id);

    public Page<Clients>findPage(Integer size,Integer page);


}
