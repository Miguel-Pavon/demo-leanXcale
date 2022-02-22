package com.hopla.demo.repository.leanXcale;

import com.hopla.demo.model.leanXcale.Clients;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepository extends JpaRepository<Clients,String> {

    Page<Clients>findByDni(String dni, Pageable pageable);
}
