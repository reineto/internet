/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.worksignout.classes.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    

	public Connection getConnection() {

        var url = "jdbc:h2:mem:testdb";

		try (var con = DriverManager.getConnection(url,"sa","");
                        var stm = con.createStatement();
                        var rs = stm.executeQuery("SELECT 1+1")){

                        if(rs.next()){
                        
                            System.out.println(rs.getInt(1));

                        }
	     
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

