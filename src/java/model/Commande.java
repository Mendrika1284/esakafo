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
public class Commande {
    int id;
    int idServeur;
    String dateCommande;
    int numeroTable;
    String etat;
    int somme;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdServeur() {
        return idServeur;
    }

    public void setIdServeur(int idServeur) {
        this.idServeur = idServeur;
    }

    public String getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(String dateCommande) {
        this.dateCommande = dateCommande;
    }

    public int getNumeroTable() {
        return numeroTable;
    }

    public void setNumeroTable(int numeroTable) {
        this.numeroTable = numeroTable;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getSomme() {
        return somme;
    }

    public void setSomme(int somme) {
        this.somme = somme;
    }

    public Commande(int id, int idServeur, String dateCommande, int numeroTable, String etat, int somme) {
        this.id = id;
        this.idServeur = idServeur;
        this.dateCommande = dateCommande;
        this.numeroTable = numeroTable;
        this.etat = etat;
        this.somme = somme;
    }

    

    
    
    public Commande() {
    }


    public Commande[] findLastCommande()throws Exception{
    Vector<Commande> v = new Vector();
        
        Connexion oracle = new Connexion();
        Connection con = oracle.getCon();
        java.sql.Statement stm = con.createStatement();
        String req = "SELECT * FROM Commande ORDER BY id DESC LIMIT 1 ";
        ResultSet res = stm.executeQuery(req);
        while(res.next()){
              Commande a = new Commande(res.getInt("id"), res.getInt("idServeur"),res.getString("dateCommande"), res.getInt("numerotable"),  res.getString("etat"),  res.getInt("somme"));
              v.add(a);
        }
        Commande[] ct = new Commande[0];
        Commande[] cat = (Commande[]) v.toArray(ct);
        stm.close();
        con.close();
        res.close();
         return cat;    
}
    
    
    public void insertIntoCommande(int idServeur, String dateCommande, int numeroTable, int somme)throws Exception{
        String req="INSERT INTO Commande(idServeur, dateCommande, numeroTable, etat, somme) VALUES ("+idServeur+",'"+dateCommande+"', "+numeroTable+",'false',"+somme+")";
        System.out.println(req);
        Connexion con = new Connexion();
        Connection c = con.getCon();
        Statement s = c.createStatement();
        s.executeUpdate(req);   
        c.commit();
    }
}
