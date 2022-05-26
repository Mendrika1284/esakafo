/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import model.Categorie;

/**
 *
 * @author Jupiter
 */
public class ServiceCategorie {
    
    public Categorie[] findAllCategorieDAO() throws Exception{
        Categorie cat = new Categorie();
        Categorie[] cate = cat.findAllCategorie();
        return cate;
    }
    
    public Categorie[] findOneCategorieDAO(String n) throws Exception{
        Categorie cat = new Categorie();
        Categorie[] cate = cat.findOneCategorie(n);
        return cate;
    }
    
    public void insertCategorieDAO(String nom)throws Exception{
        Categorie cat = new Categorie();
        cat.insertIntoCategorie(nom);
    }
}
