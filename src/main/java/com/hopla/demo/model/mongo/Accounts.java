package com.hopla.demo.model.mongo;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document("accounts")
public class Accounts {

    public Accounts(String user, String account_name, double saldo) {
        this.user = user;
        this.account_name = account_name;
        this.saldo = saldo;
    }

    @Id
    public String id;

    public String user;

    public String account_name;

    public double saldo;
}
