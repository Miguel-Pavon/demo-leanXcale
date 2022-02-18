package com.hopla.demo.service;

import com.hopla.demo.model.Loans;

import java.util.List;

public interface LoansService {

    public List<Loans> findAll();
    public Loans findById(String id);
}
