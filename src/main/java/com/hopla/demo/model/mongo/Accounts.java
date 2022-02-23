package com.hopla.demo.model.mongo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document("accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Accounts {

    @Id
    private String id;

    private String dni;

    private String name;

    private String last_name;

    private String type;

    private float balance;
}
