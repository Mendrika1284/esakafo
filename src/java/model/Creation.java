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
public class Creation {
    int id;
    int idComposition;
    int idIngredient;
    int fatrany;
    
    //composition
    String nomComposition;
    
    //ingredient
    String nomIngredient;
    int prix;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdComposition() {
        return idComposition;
    }

    public void setIdComposition(int idComposition) {
        this.idComposition = idComposition;
    }

    public int getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(int idIngredient) {
        this.idIngredient = idIngredient;
    }

    public int getFatrany() {
        return fatrany;
    }

    public void setFatrany(int fatrany) {
        this.fatrany = fatrany;
    }

    public String getNomComposition() {
        return nomComposition;
    }

    public void setNomComposition(String nomComposition) {
        this.nomComposition = nomComposition;
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

    public Creation() {
    }

    public Creation(int id, int idComposition, int idIngredient, int fatrany, String nomComposition, String nomIngredient, int prix) {
        this.id = id;
        this.idComposition = idComposition;
        this.idIngredient = idIngredient;
        this.fatrany = fatrany;
        this.nomComposition = nomComposition;
        this.nomIngredient = nomIngredient;
        this.prix = prix;
    }

    public Creation(int id, int idComposition, int idIngredient, int fatrany) {
        this.id = id;
        this.idComposition = idComposition;
        this.idIngredient = idIngredient;
        this.fatrany = fatrany;
    }
    
    public void insertIntoCreation(int idComposition, int idIngredient, int fatrany )throws Exception{
        String req="INSERT INTO Creation(idComposition, idIngredient, fatrany) VALUES ("+idComposition+","+idIngredient+","+fatrany+")";
        System.out.println(req);
        Connexion con = new Connexion();
        Connection c = con.getCon();
        Statement s = c.createStatement();
        s.executeUpdate(req);   
        c.commit();
    }
    
public Creation[] findAllCreation()throws Exception{
Vector<Creation> v = new Vector();
        
        Connexion oracle = new Connexion();
        Connection con = oracle.getCon();
        java.sql.Statement stm = con.createStatement();
        String req = "SELECT * FROM Creation JOIN Composition ON Creation.idComposition = Composition.id JOIN Ingredient on Creation.idIngredient = Ingredient.id";
        ResultSet res = stm.executeQuery(req);
        while(res.next()){
              Creation a = new Creation(res.getInt("id"),res.getInt("idComposition"),res.getInt("idIngredient"),res.getInt("fatrany"),res.getString("nomComposition"),res.getString("nomIngredient"),res.getInt("prix"));
              v.add(a);
        }
        Creation[] ct = new Creation[0];
        Creation[] cat = (Creation[]) v.toArray(ct);
        stm.close();
        con.close();
        res.close();
         return cat;    
    }
}
