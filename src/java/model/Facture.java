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
public class Facture {
    int id;
    int idType;
    int idCommande;
    int montant;
    String dateFacture;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public String getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(String dateFacture) {
        this.dateFacture = dateFacture;
    }

    public Facture(int id, int idType, int idCommande, int montant, String dateFacture) {
        this.id = id;
        this.idType = idType;
        this.idCommande = idCommande;
        this.montant = montant;
        this.dateFacture = dateFacture;
    }

    public Facture() {
    }
    
    public Facture[] findFactureCheckByDate(String date1, String date2)throws Exception{
        Vector<Facture> v = new Vector();
        
        Connexion oracle = new Connexion();
        Connection con = oracle.getCon();
        java.sql.Statement stm = con.createStatement();
        String req = "select*from Facture JOIN Commande ON Commande.id=Facture.idCommande JOIN Type ON Facture.idType=Type.id WHERE Facture.dateFacture>='"+date1+"' and Facture.dateFacture<='"+date2+"' and Type.id = 2";
        ResultSet res = stm.executeQuery(req);
        while(res.next()){
              Facture a = new Facture(res.getInt("id"),res.getInt("idType"),res.getInt("idCommande"),res.getInt("montant"),res.getString("dateFacture"));
              v.add(a);
        }
        Facture[] ct = new Facture[0];
        Facture[] cat = (Facture[]) v.toArray(ct);
        stm.close();
        con.close();
        res.close();
         return cat;    
}
    
   public Facture[] findFactureEspeceByDate(String date1, String date2)throws Exception{
        Vector<Facture> v = new Vector();
        
        Connexion oracle = new Connexion();
        Connection con = oracle.getCon();
        java.sql.Statement stm = con.createStatement();
        String req = "select*from Facture JOIN Commande ON Commande.id=Facture.idCommande JOIN Type ON Facture.idType=Type.id WHERE Facture.dateFacture>='"+date1+"' and Facture.dateFacture<='"+date2+"' and Type.id = 1";
        ResultSet res = stm.executeQuery(req);
        while(res.next()){
              Facture a = new Facture(res.getInt("id"),res.getInt("idType"),res.getInt("idCommande"),res.getInt("montant"),res.getString("dateFacture"));
              v.add(a);
        }
        Facture[] ct = new Facture[0];
        Facture[] cat = (Facture[]) v.toArray(ct);
        stm.close();
        con.close();
        res.close();
         return cat;    
}
}
