/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.Serveur;

/**
 *
 * @author Jupiter
 */
public class ServiceServeur {
    public Serveur[] findAllServeurDAO()throws Exception{
        Serveur s = new Serveur();
        Serveur[] se = s.findAllServeur();
        return se;
    }
    
    public Serveur[] findOneServeurDAO(int id)throws Exception{
        Serveur s = new Serveur();
        Serveur[] se = s.findOneServeur(id);
        return se;
    }
    
    public static double getPourboireDAO(int id, String date1, String date2)throws Exception{
        double pourboire = Serveur.getPourboire(id, date1, date2);
        return pourboire;
    }
    
    
}
