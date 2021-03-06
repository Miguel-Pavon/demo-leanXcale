package com.hopla.demo.resolver;

import com.hopla.demo.model.leanXcale.Clients;
import com.hopla.demo.pagination.GraphPage;
import com.hopla.demo.pagination.GraphPageInfo;
import com.hopla.demo.service.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ClientsController {

    @Autowired
    ClientsService clientsService;


    @QueryMapping
    public Clients fetchClientById(@Argument  String id){
        return clientsService.findById(id);
    }

    @QueryMapping
    public GraphPage<Clients> clientPage(@Argument Integer page, @Argument Integer perPage){
        Page<Clients> clientsPage =clientsService.findPage(page,perPage);
        List<Clients>clients = clientsPage.getContent();
        GraphPageInfo graphPageInfo = new GraphPageInfo(clientsPage.getNumber(),clientsPage.getTotalElements(),clientsPage.getTotalPages(),clientsPage.hasPrevious(),clientsPage.hasNext()) ;
        return new GraphPage<>(clients,graphPageInfo);
    }


}
