package com.hopla.demo.model.leanXcale;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Table(name="CREDIT_CARDS",schema = "app")
@Data
@Entity
public class CreditCars {

    @Id
    @Column(name = "NUMBER")
    private String number;

    @Column(name = "OWNER")
    private String owner;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "CCV")
    private String ccv;

    @Column(name = "EXPIRATION_DATE")
    private LocalDate expiration;
}
