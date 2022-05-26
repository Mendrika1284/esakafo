/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.DetailCommande;

/**
 *
 * @author Jupiter
 */
public class ServiceDetailCommande {
    public void insertIntoDetailCommandeDAO(int idPlat, int quantite, int idCommande)throws Exception{
        DetailCommande dc = new DetailCommande();
        dc.insertIntoDetailCommande(idPlat, quantite, idCommande);
    }
    
    public DetailCommande[] findOneDetailCommandeDAO(int idCommande) throws Exception{
        DetailCommande dc = new DetailCommande();
        DetailCommande[] d = dc.findOneDetailCommande(idCommande);
        return d;
    }
     public void ModifierDetailCommandeDAO(int quantite,int idCommande ) throws Exception{
            DetailCommande commandeDetail = new DetailCommande();
            commandeDetail.ModifierDetailCommande(quantite, idCommande);
    }
      public void DeleteDetailCommandeDAO(int id)throws Exception {
           DetailCommande  c =new DetailCommande();
           c.DeleteDetailCommande(id);
    }
}
