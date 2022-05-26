/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connexion.Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author Jupiter
 */
public class Type {
    int id;
    String nom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Type(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Type() {
    }
    
    public Type[] findAllTypePayement()throws Exception{
Vector<Type> v = new Vector();
        
        Connexion oracle = new Connexion();
        Connection con = oracle.getCon();
        java.sql.Statement stm = con.createStatement();
        String req = "SELECT * FROM Type";
        ResultSet res = stm.executeQuery(req);
        while(res.next()){
              Type a = new Type(res.getInt("id"),res.getString("nom"));
              v.add(a);
        }
        Type[] ct = new Type[0];
        Type[] cat = (Type[]) v.toArray(ct);
        stm.close();
        con.close();
        res.close();
         return cat;    
}
}
