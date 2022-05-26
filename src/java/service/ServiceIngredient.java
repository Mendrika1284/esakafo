/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.Ingredient;

/**
 *
 * @author Jupiter
 */
public class ServiceIngredient {
    public Ingredient[] findAllIngredientDAO()throws Exception{
        Ingredient i = new Ingredient();
        Ingredient[] ing = i.findAllIngredient();
        return ing;
    }
    public void insertIngredientDAO(String nomIngredient,int prix)throws Exception{
        Ingredient cat = new Ingredient();
        cat.insertIntoIngredient(nomIngredient, prix);
    }
    
    public void findIngredientByIdPlatDAO(int idPlat, Ingredient[] l)throws Exception{
        Ingredient i = new Ingredient();
        i.findIngredientByIdPlat(idPlat,l);
    }
    
    public Ingredient[] voirIngredientPlatDAO(int idPlat)throws Exception{
        Ingredient ing = new Ingredient();
        Ingredient[] ingr = ing.voirIngredientPlat(idPlat);
        return ingr;
    }
    
}
