package com.hopla.demo.repository.leanXcale;

import com.hopla.demo.model.leanXcale.CreditCars;
import com.hopla.demo.model.leanXcale.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions,String> {

    List<Transactions> findByCreditCardIn(Set<String> owner);
}
