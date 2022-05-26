/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.Facture;
import model.Type;

/**
 *
 * @author Jupiter
 */
public class ServiceFacture {
    public Type[] getAllTypeDAO()throws Exception{
        Type t = new Type();
        Type[] ty = t.findAllTypePayement();
        return ty;
    }
    
    public Facture[] getFactureCheckByDate(String date1, String date2)throws Exception{
        Facture fa = new Facture();
        Facture[] f = fa.findFactureCheckByDate(date1, date2);
        return f;
    }
    
    public Facture[] getFactureEspeceByDate(String date1, String date2)throws Exception{
        Facture fa = new Facture();
        Facture[] f = fa.findFactureEspeceByDate(date1, date2);
        return f;
    }
}
