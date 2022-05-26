/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.Assemblage;

/**
 *
 * @author Jupiter
 */
public class ServiceAssemblage {
    public Assemblage[] findAllAssemblageDAO() throws Exception{
        Assemblage cat = new Assemblage();
        Assemblage[] cate = cat.findAllAssemblage();
        return cate;
    }
    
    public void insertAssemblageDAO(int idPlat,int idComposition, int quantite)throws Exception{
        Assemblage cat = new Assemblage();
        cat.insertIntoAssemblage(idPlat, idComposition, quantite);
    }
}
