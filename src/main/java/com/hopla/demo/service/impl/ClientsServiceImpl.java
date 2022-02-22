package com.hopla.demo.service.impl;

import com.hopla.demo.model.leanXcale.Clients;
import com.hopla.demo.repository.leanXcale.ClientsRepository;
import com.hopla.demo.service.ClientsService;
import graphql.GraphQLException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientsServiceImpl implements ClientsService {

    ClientsRepository repository;

    public ClientsServiceImpl(ClientsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Clients findById(String id) {
        Optional<Clients> clients = repository.findById(id);
        if(!clients.isPresent()){
           throw new GraphQLException("No results found");
        }
        return clients.get();
    }

    @Override
    public Page<Clients> findPage(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page,size));
    }

}
