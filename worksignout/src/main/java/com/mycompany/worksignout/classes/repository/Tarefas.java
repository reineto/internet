/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.worksignout.classes.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author root
 */
@Data
@Entity
@Table(name = "works")
public class Tarefas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "work_id")
    public int id;
    
    @Column(name = "name")
    @NotNull
    @NotEmpty(message = "Por favor insira o nome da tarefa")
    public String name;
    
    @Column(name = "dataini")
    @NotNull
    @DateTimeFormat
    @NotEmpty(message = "Por favor insira a data de inicio")
    public String dataini;
    
    @Column(name = "datafinal")
    @NotNull
    @DateTimeFormat
    @NotEmpty(message = "Por favor insira a data final")
    public String datafinal;
    
    @Column(name = "ctarefa")
    public String ctarefa;
    
    @Column(name = "etarefa")
    public String etarefa;
    
    private String comments;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setDataini(String dataini) {
        this.dataini = dataini;
    }
    public String getDataini(){
        return dataini;
    }
    public void setDatafinal(String datafinal) {
        this.datafinal = datafinal;
    }
    public String getDataFinal(){
        return datafinal;
    }
    public void setCtarefa(String ctarefa){
        this.ctarefa = ctarefa;
    }
    public String getCtarefa(){
        return ctarefa;
    }
    public void setEtarefa(String etarefa){
        this.etarefa = etarefa;
    }
    public String getEtarefa(){
        return etarefa;
    }
    public void setComments(String comments){
        this.comments = comments;
    }
    public String getComments(){
        return comments;
    }
    
}
