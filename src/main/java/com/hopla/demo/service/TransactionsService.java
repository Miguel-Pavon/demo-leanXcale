package com.hopla.demo.service;



import com.hopla.demo.model.leanXcale.Transactions;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface TransactionsService {

    public Map<String, List<Transactions>> findAllById(Set<String> id);
}
