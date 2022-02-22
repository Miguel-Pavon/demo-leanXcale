package com.hopla.demo.repository.mongo;

import com.hopla.demo.model.mongo.Accounts;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends MongoRepository<Accounts, String> {
}
