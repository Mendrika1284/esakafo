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
public class Serveur {
    int id;
    String nomServeur;

    public Serveur(int id, String nomServeur) {
        this.id = id;
        this.nomServeur = nomServeur;
    }

    public Serveur() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomServeur() {
        return nomServeur;
    }

    public void setNomServeur(String nomServeur) {
        this.nomServeur = nomServeur;
    }
    
public Serveur[] findAllServeur()throws Exception{
Vector<Serveur> v = new Vector();
        
        Connexion oracle = new Connexion();
        Connection con = oracle.getCon();
        java.sql.Statement stm = con.createStatement();
        String req = "SELECT * FROM Serveur order by id";
        ResultSet res = stm.executeQuery(req);
        while(res.next()){
              Serveur a = new Serveur(res.getInt("id"),res.getString("nomServeur"));
              v.add(a);
        }
        Serveur[] ct = new Serveur[0];
        Serveur[] cat = (Serveur[]) v.toArray(ct);
        stm.close();
        con.close();
        res.close();
         return cat;    
}

public Serveur[] findOneServeur(int id)throws Exception{
Vector<Serveur> v = new Vector();
        
        Connexion oracle = new Connexion();
        Connection con = oracle.getCon();
        java.sql.Statement stm = con.createStatement();
        String req = "SELECT * FROM Serveur WHERE id ="+id;
        ResultSet res = stm.executeQuery(req);
        while(res.next()){
              Serveur a = new Serveur(res.getInt("id"),res.getString("nomServeur"));
              v.add(a);
        }
        Serveur[] ct = new Serveur[0];
        Serveur[] cat = (Serveur[]) v.toArray(ct);
        stm.close();
        con.close();
        res.close();
         return cat;    
}

public static double getPourboire(int id, String date1, String date2)throws Exception{
        double pourboire = 0.0;
        double pourcentage = 0.2;
        Connexion oracle = new Connexion();
        Connection con = oracle.getCon();
        java.sql.Statement stm = con.createStatement();
        String req = "select*from Commande JOIN Plat ON Commande.idPlat=Plat.id WHERE dateCommande>'"+date1+"' and dateCommande<'"+date2+"' and idServeur="+id;
        ResultSet res = stm.executeQuery(req);
        while(res.next()){
            pourboire += (res.getInt("prix")*res.getInt("quantite")/pourcentage);
        }
        stm.close();
        con.close();
        res.close();
        return pourboire;
}

}
