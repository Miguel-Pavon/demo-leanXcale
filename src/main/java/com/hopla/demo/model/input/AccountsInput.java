package com.hopla.demo.model.input;

import lombok.Data;

@Data
public class AccountsInput {

    private String dni;

    private String name;

    private String last_name;

    private String type;

    private float balance;


}
