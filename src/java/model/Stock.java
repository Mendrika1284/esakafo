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
public class Stock {
    int id;
    int idIngredient;
    int quantite;
    
    //ingredient
    String nomIngredient;
    int prix;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(int idIngredient) {
        this.idIngredient = idIngredient;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getNomIngredient() {
        return nomIngredient;
    }

    public void setNomIngredient(String nomIngredient) {
        this.nomIngredient = nomIngredient;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public Stock(int id, int idIngredient, int quantite, String nomIngredient, int prix) {
        this.id = id;
        this.idIngredient = idIngredient;
        this.quantite = quantite;
        this.nomIngredient = nomIngredient;
        this.prix = prix;
    }

    public Stock() {
    }
    
    public void insertIntoStock(int idIngredient, int quantite )throws Exception{
        String req="INSERT INTO Stock(idIngredient, quantite) VALUES ("+idIngredient+","+quantite+")";
        System.out.println(req);
        Connexion con = new Connexion();
        Connection c = con.getCon();
        Statement s = c.createStatement();
        s.executeUpdate(req);   
        c.commit();
    }

    
    
    public Stock[] findAllStock()throws Exception{
        Vector<Stock> v = new Vector();
        
        Connexion oracle = new Connexion();
        Connection con = oracle.getCon();
        java.sql.Statement stm = con.createStatement();
        String req = "SELECT * FROM Stock JOIN Ingredient ON Stock.idIngredient = Ingredient.id";
        ResultSet res = stm.executeQuery(req);
        while(res.next()){
              Stock a = new Stock(res.getInt("id"),res.getInt("idIngredient"),res.getInt("quantite"),res.getString("nomIngredient"),res.getInt("prix"));
              v.add(a);
        }
        Stock[] ct = new Stock[0];
        Stock[] cat = (Stock[]) v.toArray(ct);
        stm.close();
        con.close();
        res.close();
         return cat;    
}
    
}
