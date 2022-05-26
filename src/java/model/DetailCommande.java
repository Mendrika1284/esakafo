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
public class DetailCommande {
    int id;
    int idPlat;
    int quantite;
    int idCommande;
    
    //Plat
    String nomPlat;
    int prix;
  

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

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
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

    public DetailCommande(int id, int idPlat, int quantite, int idCommande, String nomPlat, int prix) {
        this.id = id;
        this.idPlat = idPlat;
        this.quantite = quantite;
        this.idCommande = idCommande;
        this.nomPlat = nomPlat;
        this.prix = prix;
    }

 

    public DetailCommande() {
    }
    
    public void insertIntoDetailCommande(int idPlat, int quantite, int idCommande)throws Exception{
        String req="INSERT INTO DetailCommande(idPlat, quantite, idCommande) VALUES ("+idPlat+","+quantite+","+idCommande+")";
        System.out.println(req);
        Connexion con = new Connexion();
        Connection c = con.getCon();
        Statement s = c.createStatement();
        s.executeUpdate(req);   
        c.commit();
    }
    
    public DetailCommande[] findOneDetailCommande(int idCommande)throws Exception{
        Vector<DetailCommande> v = new Vector();
        
        Connexion oracle = new Connexion();
        Connection con = oracle.getCon();
        java.sql.Statement stm = con.createStatement();
        String req = "SELECT * FROM DetailCommande JOIN Plat on DetailCommande.idPlat = Plat.id WHERE idCommande = "+idCommande;
        ResultSet res = stm.executeQuery(req);
        while(res.next()){
              DetailCommande a = new DetailCommande(res.getInt("id"),res.getInt("idPlat"),res.getInt("quantite"),res.getInt("idCommande"), res.getString("nom"),res.getInt("prix"));
              v.add(a);
        }
        DetailCommande[] ct = new DetailCommande[0];
        DetailCommande[] cat = (DetailCommande[]) v.toArray(ct);
        stm.close();
        con.close();
        res.close();
         return cat;    
}
       public void ModifierDetailCommande(int quantite ,int id ) throws Exception
	{
		String sql="UPDATE detailCommande SET  quantite="+quantite+" WHERE id ="+id+"";
		System.out.println(sql);
                Connexion con = new Connexion();
                Connection c = con.getCon();
		Statement s = c.createStatement();
                s.executeUpdate(sql);
                c.commit();
	}
             public void DeleteDetailCommande(int id) throws Exception
	{
		String sql="DELETE FROM DetailCommande WHERE id ='"+id+"'";
		Connexion con = new Connexion();
                Connection c = con.getCon();
		Statement s = c.createStatement();
                s.executeUpdate(sql);
                c.commit();
	}
}
