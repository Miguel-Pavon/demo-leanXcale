package com.hopla.demo.service.impl;

import com.hopla.demo.config.DataSourceConfiguration;
import com.hopla.demo.model.Loans;
import com.hopla.demo.repository.LoansRepository;
import com.hopla.demo.service.LoansService;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoansServiceimpl implements LoansService {

    LoansRepository loansRepository;

    public LoansServiceimpl(LoansRepository loansRepository) {
        this.loansRepository = loansRepository;
    }

    @Override
    public List<Loans> findAll(){
        return loansRepository.findAll();
    }

    @Override
    public Loans findById(String id) {
        return loansRepository.findById(id);
    }
}
