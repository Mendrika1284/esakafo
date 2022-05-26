/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.Composition;

/**
 *
 * @author Jupiter
 */
public class ServiceComposition {
    public Composition[] findAllCompositionDAO()throws Exception{
        Composition i = new Composition();
        Composition[] ing = i.findAllComposition();
        return ing;
    }
    public void insertCompositionDAO(String nom)throws Exception{
        Composition cat = new Composition();
        cat.insertIntoComposition(nom);
    }
}
