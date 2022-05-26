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
public class Categorie {
    int idCategorie;
    String nomCategorie;

    public Categorie(int idCategorie, String nomCategorie) {
        this.idCategorie = idCategorie;
        this.nomCategorie = nomCategorie;
    }

    public Categorie() {
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }
    
    public void insertIntoCategorie(String nom )throws Exception{
        String req="INSERT INTO Categorie(nom) VALUES ('"+nom+"')";
        System.out.println(req);
        Connexion con = new Connexion();
        Connection c = con.getCon();
        Statement s = c.createStatement();
        s.executeUpdate(req);   
        c.commit();
    }
    
public Categorie[] findAllCategorie()throws Exception{
Vector<Categorie> v = new Vector();
        
        Connexion oracle = new Connexion();
        Connection con = oracle.getCon();
        java.sql.Statement stm = con.createStatement();
        String req = "SELECT * FROM Categorie order by nom";
        ResultSet res = stm.executeQuery(req);
        while(res.next()){
              Categorie a = new Categorie(res.getInt("id"),res.getString("nom"));
              v.add(a);
        }
        Categorie[] ct = new Categorie[0];
        Categorie[] cat = (Categorie[]) v.toArray(ct);
        stm.close();
        con.close();
        res.close();
         return cat;    
}

public Categorie[] findOneCategorie(String nomCat)throws Exception{
Vector<Categorie> v = new Vector();
        
        Connexion oracle = new Connexion();
        Connection con = oracle.getCon();
        java.sql.Statement stm = con.createStatement();
        String req = "SELECT * FROM Categorie WHERE upper(nom) like upper('%"+nomCat+"%')";
        ResultSet res = stm.executeQuery(req);
        while(res.next()){
              Categorie a = new Categorie(res.getInt("id"),res.getString("nom"));
              v.add(a);
        }
        Categorie[] ct = new Categorie[0];
        Categorie[] cat = (Categorie[]) v.toArray(ct);
        stm.close();
        con.close();
        res.close();
         return cat;    
}
}
