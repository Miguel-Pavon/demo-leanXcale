package com.hopla.demo.model;


import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="LOANS",schema = "app")
@Data
@Entity
public class Loans {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name="LOAN_AMNT" )
    private String loan_amnt;

    @Column(name="TERM")
    private String term;

    @Column(name="INT_RATE")
    private String int_rate;

    @Column(name="INSTALLMENT")
    private String installment;

    @Column(name="GRADE")
    private String grade;

    @Column(name="EMP_LENGTH")
    private String emp_length;

    @Column(name="HOME_OWNERSHIP")
    private String home_ownership;

    @Column(name="ANNUAL_INC")
    private String annual_inc;

    @Column(name="VERIFICATION_STATUS ")
    private String verification_status;

    @Column(name="ISSUE_D ")
    private String issue_d;

    @Column(name="LOAN_STATUS  ")
    private String loan_status;
}
