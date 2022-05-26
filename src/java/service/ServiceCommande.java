/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.Commande;

/**
 *
 * @author Jupiter
 */
public class ServiceCommande {
    public void insertIntoCommandeDAO(int idServeur, String dateCommande, int numeroTable, int somme )throws Exception{
        Commande commande = new Commande();
        commande.insertIntoCommande(idServeur,dateCommande, numeroTable, somme);
    }
    
    public Commande[] findLastCommandeDAO()throws Exception{
        Commande commande = new Commande();
        Commande[] lCommande = commande.findLastCommande();
        return lCommande;
    }
}
