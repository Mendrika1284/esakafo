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
public class Assemblage {
    int id;
    int idPlat;
    int idCreation;
    int quantite;
    
    //plat
    String nomPlat;
    int prixPlat;
    int idCategorie;
    
    //categorie
    String nomCategorie;
    
    //composition
    String nomComposition;
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPlat() {
        return idPlat;
    }

    public void setIdPlat(int idPlat) {
        this.idPlat = idPlat;
    }

    public int getidCreation() {
        return idCreation;
    }

    public void setidCreation(int idCreation) {
        this.idCreation = idCreation;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getNomPlat() {
        return nomPlat;
    }

    public void setNomPlat(String nomPlat) {
        this.nomPlat = nomPlat;
    }

    public int getPrixPlat() {
        return prixPlat;
    }

    public void setPrixPlat(int prixPlat) {
        this.prixPlat = prixPlat;
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

    public String getNomComposition() {
        return nomComposition;
    }

    public void setNomComposition(String nomComposition) {
        this.nomComposition = nomComposition;
    }

    public Assemblage(int id, int idPlat, int idCreation, int quantite, String nomPlat, int prixPlat, int idCategorie, String nomCategorie, String nomComposition) {
        this.id = id;
        this.idPlat = idPlat;
        this.idCreation = idCreation;
        this.quantite = quantite;
        this.nomPlat = nomPlat;
        this.prixPlat = prixPlat;
        this.idCategorie = idCategorie;
        this.nomCategorie = nomCategorie;
        this.nomComposition = nomComposition;
    }

    public Assemblage() {
    }

    public void insertIntoAssemblage(int idPlat, int idCreation, int quantite )throws Exception{
        String req="INSERT INTO Assemblage(idPlat, idCreation, quantite) VALUES ("+idPlat+","+idCreation+","+quantite+")";
        System.out.println(req);
        Connexion con = new Connexion();
        Connection c = con.getCon();
        Statement s = c.createStatement();
        s.executeUpdate(req);   
        c.commit();
    }
    

    
    public Assemblage[] findAllAssemblage()throws Exception{
        Vector<Assemblage> v = new Vector();
        
        Connexion oracle = new Connexion();
        Connection con = oracle.getCon();
        java.sql.Statement stm = con.createStatement();
        String req = "SELECT * FROM Assemblage JOIN Plat ON Assemblage.idPlat = Plat.id JOIN Composition ON Assemblage.idCreation = Composition.id JOIN Categorie ON Plat.idCategorie = Categorie.id";
        ResultSet res = stm.executeQuery(req);
        while(res.next()){
              Assemblage a = new Assemblage(res.getInt("id"),res.getInt("idPlat"), res.getInt("idCreation"), res.getInt("quantite"), res.getString("nom"), res.getInt("prix"), res.getInt("idCategorie"), res.getString("nom"), res.getString("nom"));
              v.add(a);
        }
        Assemblage[] ct = new Assemblage[0];
        Assemblage[] cat = (Assemblage[]) v.toArray(ct);
        stm.close();
        con.close();
        res.close();
         return cat;    
}
    
    
}
