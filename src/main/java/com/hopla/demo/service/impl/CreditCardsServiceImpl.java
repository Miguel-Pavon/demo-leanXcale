package com.hopla.demo.service.impl;

import com.hopla.demo.model.leanXcale.CreditCars;
import com.hopla.demo.repository.leanXcale.CreditCardsRepository;
import com.hopla.demo.service.CreditCardsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CreditCardsServiceImpl implements CreditCardsService {

    CreditCardsRepository repository;

    public CreditCardsServiceImpl(CreditCardsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Map<String,List<CreditCars>> findAllById(Set<String> id) {
        Map<String,List<CreditCars>>creditCars= repository.findByOwnerIn(id).stream().collect(Collectors.groupingBy(CreditCars::getOwner));
        return creditCars;
    }
}
