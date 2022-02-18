package com.hopla.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;


@ConfigurationProperties(prefix="connection")
@Data
public class DataBaseConfig {

        private String driverClassName;
        private String url;
        private String username;
        private String password;

}
