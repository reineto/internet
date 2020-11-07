package com.mycompany.worksignout;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.activation.DataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author root
 */
@SpringBootApplication
public class run {
    
    public static void main(String[] args){
        SpringApplication.run(run.class, args);
    }
    
}
