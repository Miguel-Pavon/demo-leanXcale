package com.hopla.demo.service.impl;

import com.hopla.demo.model.Clients;
import com.hopla.demo.model.Loans;
import com.hopla.demo.repository.ClientsRepository;
import com.hopla.demo.service.ClientsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ClientsServiceImpl implements ClientsService {

    ClientsRepository repository;

    public ClientsServiceImpl(ClientsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Clients findById(String id) {
        return repository.findById(id).get();
    }

    @Override
    public Page<Clients> findPage(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page,size));
    }

}
