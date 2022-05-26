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
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Jupiter
 */
public class Ingredient {
    int id;
    String nomIngredient;
    int prix;
    
    //Alias
    
    int quantiteIngredient = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getQuantiteIngredient() {
        return quantiteIngredient;
    }

    public void setQuantiteIngredient(int quantiteIngredient) {
        this.quantiteIngredient = quantiteIngredient;
    }

    public Ingredient(int id, String nomIngredient, int prix, int quantiteIngredient) {
        this.id = id;
        this.nomIngredient = nomIngredient;
        this.prix = prix;
        this.quantiteIngredient = quantiteIngredient;
    }

    public Ingredient(int id, String nomIngredient, int prix) {
        this.id = id;
        this.nomIngredient = nomIngredient;
        this.prix = prix;
    }

    public Ingredient(String nomIngredient) {
        this.nomIngredient = nomIngredient;
    }



    public Ingredient() {
    }
    
    public void insertIntoIngredient( String nomIngredient, int prix )throws Exception{
        String req="INSERT INTO Ingredient(nomIngredient, prix) VALUES ('"+nomIngredient+"',"+prix+")";
        System.out.println(req);
        Connexion con = new Connexion();
        Connection c = con.getCon();
        Statement s = c.createStatement();
        s.executeUpdate(req);   
        c.commit();
    }
    
    
public Ingredient[] findAllIngredient()throws Exception{
Vector<Ingredient> v = new Vector();
        
        Connexion oracle = new Connexion();
        Connection con = oracle.getCon();
        java.sql.Statement stm = con.createStatement();
        String req = "SELECT * FROM Ingredient order by nomIngredient";
        ResultSet res = stm.executeQuery(req);
        while(res.next()){

              Ingredient a = new Ingredient(res.getInt("id"),res.getString("nomIngredient"),res.getInt("prix"), 0);

              v.add(a);
        }
        Ingredient[] ct = new Ingredient[0];
        Ingredient[] cat = (Ingredient[]) v.toArray(ct);
        stm.close();
        con.close();
        res.close();
         return cat;    
    }

public Ingredient[] voirIngredientPlat(int idPlat)throws Exception{
        Vector<Ingredient> v = new Vector();

                Connexion oracle = new Connexion();
                Connection con = oracle.getCon();
                java.sql.Statement stm = con.createStatement();
                String req = "SELECT Ingredient.nomIngredient as nomIngredient \n" +
        "FROM Ingredient JOIN Creation ON Creation.idIngredient = Ingredient.id\n" +
        "JOIN Composition ON Creation.idComposition = Composition.id \n" +
        "JOIN Assemblage ON Creation.id = Assemblage.idCreation\n" +
        "JOIN Plat ON Assemblage.idPlat = Plat.id WHERE Plat.id="+idPlat;
                ResultSet res = stm.executeQuery(req);
        while(res.next()){

              Ingredient a = new Ingredient(res.getString("nomIngredient"));

              v.add(a);
        }
        Ingredient[] ct = new Ingredient[0];
        Ingredient[] cat = (Ingredient[]) v.toArray(ct);
        stm.close();
        con.close();
        res.close();
         return cat;    
    }

    public void findIngredientByIdPlat(int idPlat, Ingredient[] listeIngredient)throws Exception{
        Connexion oracle = new Connexion();
        Connection con = oracle.getCon();
        java.sql.Statement stm = con.createStatement();
        String req = "select Plat.id as idPlat,Assemblage.idPlat as tsyilaina,Creation.idIngredient as Ingredient,creation.fatrany as quantiteIngredient,Assemblage.quantite as quantiteAssemblage\n" +
", Ingredient.nomIngredient as nom from Plat JOIN Assemblage ON Assemblage.idPlat=Plat.id  JOIN Creation ON Creation.id=Assemblage.idCreation JOIN Ingredient ON Creation.idIngredient = Ingredient.id\n" +
"WHERE Plat.id="+idPlat;
        ResultSet res = stm.executeQuery(req);
        while(res.next()){
            
                int quantiteAssemblage = res.getInt("quantiteAssemblage") * res.getInt("quantiteIngredient");
                listeIngredient[res.getInt("Ingredient")-1].quantiteIngredient += quantiteAssemblage;
        }
        stm.close();
        con.close();
        res.close(); 
    }

    public static int somme(Ingredient[] listeIngredient)throws Exception{
        int valiny = 0;
        for(int i = 0; i < listeIngredient.length; i++){
            valiny+= listeIngredient[i].getPrix();
        }
        return valiny;
    }
    
        /*public Ingredient[] findIngredientByIdPlat(int idPlat)throws Exception{
Vector<Ingredient> v = new Vector();
        
        Connexion oracle = new Connexion();
        Connection con = oracle.getCon();
        java.sql.Statement stm = con.createStatement();
        String req = "select Plat.id as idPlat,Assemblage.idPlat as tsyilaina,Creation.idIngredient as Ingredient,creation.fatrany as quantiteIngredient,Assemblage.quantite as quantiteAssemblage\n" +
", Ingredient.nomIngredient as nom from Plat JOIN Assemblage ON Assemblage.idPlat=Plat.id  JOIN Creation ON Creation.id=Assemblage.idCreation JOIN Ingredient ON Creation.idIngredient = Ingredient.id\n" +
"WHERE Plat.id="+idPlat;
        ResultSet res = stm.executeQuery(req);
        Ingredient[] listeIngredient = this.findAllIngredient();
        while(res.next()){
             int quantiteAssemblage = res.getInt("quantiteAssemblage") * res.getInt("quantiteIngredient");
              Ingredient a = new Ingredient(res.getInt("idPlat"),res.getString("nom"),0,quantiteAssemblage);
              v.add(a);
        }
        Ingredient[] ct = new Ingredient[0];
        Ingredient[] cat = (Ingredient[]) v.toArray(ct);
        stm.close();
        con.close();
        res.close();
         return cat;    
    }*/
    
    
}
