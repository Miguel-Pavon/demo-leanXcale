package com.hopla.demo.model;


import lombok.Data;

@Data
public class Loans {

    private String id;
    private String loan_amnt;
    private String term;
    private String int_rate;
    private String installment;
    private String grade;
    private String emp_length;
    private String home_ownership;
    private String annual_inc;
    private String verification_status;
    private String issue_d;
    private String loan_status;
}
