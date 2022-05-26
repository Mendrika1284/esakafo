/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.Creation;

/**
 *
 * @author Jupiter
 */
public class ServiceCreation {
    public Creation[] findAllIngredientDAO()throws Exception{
        Creation i = new Creation();
        Creation[] ing = i.findAllCreation();
        return ing;
    }
    public void insertCreationDAO(int idComposition,int idIngredient, int fatrany)throws Exception{
        Creation cat = new Creation();
        cat.insertIntoCreation(idComposition, idIngredient, fatrany);
    }
}
