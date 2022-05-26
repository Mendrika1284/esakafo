/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.Stock;

/**
 *
 * @author Jupiter
 */
public class ServiceStock {
    public Stock[] findAllStockDAO() throws Exception{
        Stock cat = new Stock();
        Stock[] cate = cat.findAllStock();
        return cate;
    }
    public void insertStockDAO(int idIngredient, int quantite)throws Exception{
        Stock cat = new Stock();
        cat.insertIntoStock(idIngredient, quantite);
    }
}
