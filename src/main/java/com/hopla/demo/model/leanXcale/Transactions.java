package com.hopla.demo.model.leanXcale;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;


@Table(name="TRANSACTIONS",schema = "app")
@Data
@Entity
public class Transactions {

    @Id
    @Column(name = "ID")
    private long id;

    @Column(name = "CREDIT_CARD")
    private String creditCard;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "QUANTITY")
    private long quantity;

    @Column(name = "EXECUTION_DATE")
    private Timestamp execution_date;
}
