package com.hopla.demo.service;


import com.hopla.demo.model.leanXcale.CreditCars;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface CreditCardsService {

    public Map<String,List<CreditCars>> findAllById(Set<String> id);
}
