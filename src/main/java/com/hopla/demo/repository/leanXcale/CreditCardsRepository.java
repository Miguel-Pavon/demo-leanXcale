package com.hopla.demo.repository.leanXcale;

import com.hopla.demo.model.leanXcale.CreditCars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CreditCardsRepository extends JpaRepository<CreditCars,String> {

    List<CreditCars> findByOwnerIn(Set<String> owner);
}
