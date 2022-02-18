package com.hopla.demo.repository;

import com.hopla.demo.model.Loans;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoansRepository {

    private JdbcTemplate jdbcTemplate;


    public LoansRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Loans> findAll() {
        return jdbcTemplate.query("SELECT * FROM LOANS limit 10", new BeanPropertyRowMapper<>(Loans.class));
    }

    public Loans findById(String id){
        String sql = "SELECT * FROM LOANS WHERE ID=?";
        RowMapper<Loans> rowMapper =
                new BeanPropertyRowMapper<>(Loans.class);
        Loans loans = jdbcTemplate.queryForObject(sql , rowMapper, id);
        return loans ;
    }
}
