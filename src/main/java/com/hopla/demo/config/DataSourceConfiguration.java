package com.hopla.demo.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class DataSourceConfiguration {

   @Bean
   public DataSource dataSource(DataBaseConfig dataBaseConfig){
       HikariConfig config = new HikariConfig();
       config.setJdbcUrl(dataBaseConfig.getUrl());
       config.setUsername(dataBaseConfig.getUsername());
       config.setPassword(dataBaseConfig.getPassword());
       HikariDataSource hikariDataSource = new HikariDataSource(config);
       return hikariDataSource;
   }
}
