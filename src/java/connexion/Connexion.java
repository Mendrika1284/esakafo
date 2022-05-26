/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion;

import java.sql.DriverManager;

/**
 *
 * @author Jupiter
 */
public class Connexion {
    java.sql.Connection con;
    
    public Connexion(){
    try{
        Class.forName("org.postgresql.Driver");
        con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restaurant","postgres", "123");
        con.setAutoCommit(false);
    }catch(Exception e){
        e.printStackTrace();
    }
}
    public java.sql.Connection getCon()throws Exception{
        System.err.println("mety");
        return con;
    }            
}
