/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.worksignout.classes.repository;


import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author root
 */
public interface RepositoryUser extends CrudRepository<User, Integer>{
    
    User findByName(String name);
    
}
