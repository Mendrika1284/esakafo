/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connexion.Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author Jupiter
 */
public class Composition {
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

    public Composition(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Composition() {
    }
 
    public void insertIntoComposition(String nom )throws Exception{
        String req="INSERT INTO Composition(nom) VALUES ('"+nom+"')";
        System.out.println(req);
        Connexion con = new Connexion();
        Connection c = con.getCon();
        Statement s = c.createStatement();
        s.executeUpdate(req);   
        c.commit();
    }
        
    public Composition[] findAllComposition()throws Exception{
        Vector<Composition> v = new Vector();
        
        Connexion oracle = new Connexion();
        Connection con = oracle.getCon();
        java.sql.Statement stm = con.createStatement();
        String req = "SELECT * FROM Composition order by nom";
        ResultSet res = stm.executeQuery(req);
        while(res.next()){
              Composition a = new Composition(res.getInt("id"),res.getString("nom"));
              v.add(a);
        }
        Composition[] ct = new Composition[0];
        Composition[] cat = (Composition[]) v.toArray(ct);
        stm.close();
        con.close();
        res.close();
         return cat;    
    }
}
