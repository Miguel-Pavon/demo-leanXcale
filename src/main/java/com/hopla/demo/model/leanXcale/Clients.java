package com.hopla.demo.model.leanXcale;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
@Table(name="CLIENTS",schema = "app")
@Data
@Entity
public class Clients {

    @Id
    @Column(name = "DNI")
    private String dni;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LAST_NAME")
    private String last_name;


    @Column(name = "GENDER")
    private String gender;

    @Column(name = "BIRTH_DATE")
    private LocalDate birtdDate;

    @Column(name = "PHONE")
    private String phone;

}
