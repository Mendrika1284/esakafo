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
public class Plat {
    int idPlat;
    String nomPlat;
    int prix;
    int idCategorie;
    
    double prixDeRevient;
    
    public int getIdPlat() {
        return idPlat;
    }

    public void setIdPlat(int idPlat) {
        this.idPlat = idPlat;
    }

    public String getNomPlat() {
        return nomPlat;
    }

    public void setNomPlat(String nomPlat) {
        this.nomPlat = nomPlat;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }



    public Plat(int idPlat, String nomPlat, int prix, int idCategorie, double prixDeRevient) {
        this.idPlat = idPlat;
        this.nomPlat = nomPlat;
        this.prix = prix;
        this.idCategorie = idCategorie;
        this.prixDeRevient = prixDeRevient;
    }



    public Plat(int idPlat, String nomPlat, int prix, int idCategorie) {
        this.idPlat = idPlat;
        this.nomPlat = nomPlat;
        this.prix = prix;
        this.idCategorie = idCategorie;
    }

    public void insertIntoPlat( String nomPlat, int prix, int idCategorie )throws Exception{
        String req="INSERT INTO Plat(nom, prix, idCategorie) VALUES ('"+nomPlat+"',"+prix+","+idCategorie+")";
        System.out.println(req);
        Connexion con = new Connexion();
        Connection c = con.getCon();
        Statement s = c.createStatement();
        s.executeUpdate(req);   
        c.commit();
    }

    public Plat() {
    }
    
    public Plat[] findAllPlat()throws Exception{
        Vector<Plat> v = new Vector();
        
        Connexion oracle = new Connexion();
        Connection con = oracle.getCon();
        java.sql.Statement stm = con.createStatement();
        String req = "SELECT * FROM Plat";
        ResultSet res = stm.executeQuery(req);
        while(res.next()){
              Plat a = new Plat(res.getInt("id"),res.getString("nom"),res.getInt("prix"), res.getInt("idCategorie"));
              v.add(a);
        }
        Plat[] ct = new Plat[0];
        Plat[] cat = (Plat[]) v.toArray(ct);
        stm.close();
        con.close();
        res.close();
         return cat;    
}
    
 
    public Plat[] findPlat2Date(String date1, String date2)throws Exception{
        Vector<Plat> v = new Vector();
        
        Connexion oracle = new Connexion();
        Connection con = oracle.getCon();
        java.sql.Statement stm = con.createStatement();
        String req = "select*from DetailCommande JOIN Commande ON Commande.id=DetailCommande.idCommande JOIN Plat ON DetailCommande.idPlat=Plat.id WHERE dateCommande>='"+date1+"' and dateCommande<='"+date2+"'";
        ResultSet res = stm.executeQuery(req);
        while(res.next()){
              Plat a = new Plat(res.getInt("id"),res.getString("nom"),res.getInt("prix"), res.getInt("idCategorie"));
              v.add(a);
        }
        Plat[] ct = new Plat[0];
        Plat[] cat = (Plat[]) v.toArray(ct);
        stm.close();
        con.close();
        res.close();
         return cat;    
}
    
    
public Plat[] findPlatByCategorie(int idCategorie)throws Exception{
Vector<Plat> v = new Vector();
        
        Connexion oracle = new Connexion();
        Connection con = oracle.getCon();
        java.sql.Statement stm = con.createStatement();
        String req = "SELECT * FROM Plat WHERE idCategorie="+idCategorie+"";
        ResultSet res = stm.executeQuery(req);
        while(res.next()){
              Plat a = new Plat(res.getInt("id"),res.getString("nom"),res.getInt("prix"), res.getInt("idCategorie"));
              v.add(a);
        }
        Plat[] ct = new Plat[0];
        Plat[] cat = (Plat[]) v.toArray(ct);
        stm.close();
        con.close();
        res.close();
         return cat;    
}

public void setPrixDeRevient()throws Exception{
    int charge = 0;
        Connexion oracle = new Connexion();
        Connection con = oracle.getCon();
        java.sql.Statement stm = con.createStatement();
        String req = "select*from Charge a WHERE a.idPlat="+this.idPlat+"; ";
        ResultSet res = stm.executeQuery(req);
        while(res.next()){
             int prixIngredient = res.getInt("prix");
             int quantiteIngredient = res.getInt("quantite");
             
             charge += prixIngredient * quantiteIngredient;
              
        }
        
        this.prixDeRevient = this.prix - charge;
        
        stm.close();
        con.close();
        res.close();  
}

    public double getPrixDeRevient() {
        return prixDeRevient;
    }




}
