package com.hopla.demo.web;

import com.hopla.demo.model.Clients;
import com.hopla.demo.pagination.GraphPage;
import com.hopla.demo.pagination.GraphPageInfo;
import com.hopla.demo.pagination.PaginationUtil;
import com.hopla.demo.service.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import javax.annotation.Nullable;
import java.util.List;

@Controller
public class ClientsController {

    @Autowired
    ClientsService clientsService;

    PaginationUtil paginationUtil;




    @QueryMapping
    public GraphPage<Clients> clientpage(@Argument @Nullable String id , @Argument @Nullable Integer perPage){
        Integer pageSize =paginationUtil.sanetizePageSize(perPage,100);
        Page<Clients> clientsPage =clientsService.findPage(pageSize);
        List<Clients>clients = clientsPage.getContent();
        String firstCursor = clients.isEmpty() ? null : clients.get(0).getDni();
        String lastCursor = clients.isEmpty() ? null : clients.get(clients.size()-1).getDni();
        GraphPageInfo graphPageInfo = new GraphPageInfo(firstCursor,lastCursor,id!=null,clientsPage.hasNext()) ;
        return new GraphPage<>(clients,graphPageInfo);
    }
}
