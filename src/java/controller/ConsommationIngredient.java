/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Ingredient;
import model.Plat;
import service.ServiceIngredient;
import service.ServicePlat;

/**
 *
 * @author Jupiter
 */
public class ConsommationIngredient extends HttpServlet {
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            request.setAttribute("listeIngredient", null);
            
            RequestDispatcher view = request.getRequestDispatcher("consommationIngredient.jsp");
            view.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            
            String date1 = request.getParameter("date1");
            String date2 = request.getParameter("date2");
            
            if(request.getParameter("date1")!=""){
                if(request.getParameter("date2").equals("")){
                            ServicePlat sp = new ServicePlat();
            Plat[] plat = sp.findPlat2DateDAO(date1,"now()");
            ServiceIngredient si = new ServiceIngredient();
            Ingredient[] ingredient = si.findAllIngredientDAO();
            
            for(int i = 0; i < plat.length; i++){
                si.findIngredientByIdPlatDAO(plat[i].getIdPlat(),ingredient);
            }
            for(int i = 0; i < ingredient.length; i++){
                ingredient[i].setPrix(ingredient[i].getPrix()*ingredient[i].getQuantiteIngredient());
            }
            int somme = Ingredient.somme(ingredient);
            request.setAttribute("listeIngredient", ingredient);
            request.setAttribute("somme", somme);

           
            RequestDispatcher view = request.getRequestDispatcher("consommationIngredient.jsp");
            view.forward(request, response);
                 
                 }
                else{
                     String[] tab1=date1.split("-");
                      String[] tab2=date2.split("-");
                     if(Integer.parseInt(tab2[0].trim())<Integer.parseInt(tab1[0].trim())){
                         
                      String message="la date fin ne doit pas etre inferieur a la date debut";
                    request.setAttribute("erreur", message);
                RequestDispatcher v = request.getRequestDispatcher("/consommationIngredient.jsp");
                v.forward(request, response);
               }
                     else if(Integer.parseInt(tab2[0].trim())==Integer.parseInt((tab1[0].trim()))){
                        if(Integer.parseInt(tab2[1].trim())<Integer.parseInt(tab1[1].trim())){
                            String message="la date fin ne doit pas etre inferieur a la date debut";
                    request.setAttribute("erreur", message);
                RequestDispatcher v = request.getRequestDispatcher("/consommationIngredient.jsp");
                v.forward(request, response);
                        }
                         if(Integer.parseInt(tab2[1].trim())==Integer.parseInt(tab1[1].trim())){
                            if(Integer.parseInt(tab2[2].trim())<Integer.parseInt(tab1[2].trim())){
                                String message="la date fin ne doit pas etre inferieur a la date debut";
                    request.setAttribute("erreur", message);
                RequestDispatcher v = request.getRequestDispatcher("/consommationIngredient.jsp");
                v.forward(request, response); 
                            }
                        }
                     }
                     ServicePlat sp = new ServicePlat();
            Plat[] plat = sp.findPlat2DateDAO(date1, date2);
            ServiceIngredient si = new ServiceIngredient();
            Ingredient[] ingredient = si.findAllIngredientDAO();
            
            for(int i = 0; i < plat.length; i++){
                si.findIngredientByIdPlatDAO(plat[i].getIdPlat(),ingredient);
            }
            for(int i = 0; i < ingredient.length; i++){
                ingredient[i].setPrix(ingredient[i].getPrix()*ingredient[i].getQuantiteIngredient());
            }
            int somme = Ingredient.somme(ingredient);
            request.setAttribute("listeIngredient", ingredient);
            request.setAttribute("somme", somme);
            RequestDispatcher view = request.getRequestDispatcher("consommationIngredient.jsp");
            view.forward(request, response);
                   
                }
            
            }
          
            else{
                String message="Vous devez saisir la date debut";
                request.setAttribute("erreur", message);
                RequestDispatcher view = request.getRequestDispatcher("/consommationIngredient.jsp");
                view.forward(request, response);
            }
           
            
           
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
//        try{
//            String date1 = request.getParameter("date1");
//            String date2 = request.getParameter("date2");
//            ServicePlat sp = new ServicePlat();
//            Plat[] plat = sp.findPlat2DateDAO(date1, date2);
//            ServiceIngredient si = new ServiceIngredient();
//            Ingredient[] ingredient = si.findAllIngredientDAO();
//            
//            for(int i = 0; i < plat.length; i++){
//                si.findIngredientByIdPlatDAO(plat[i].getIdPlat(),ingredient);
//            }
//            for(int i = 0; i < ingredient.length; i++){
//                ingredient[i].setPrix(ingredient[i].getPrix()*ingredient[i].getQuantiteIngredient());
//            }
//            int somme = Ingredient.somme(ingredient);
//            request.setAttribute("listeIngredient", ingredient);
//            request.setAttribute("somme", somme);
//
//            RequestDispatcher view = request.getRequestDispatcher("consommationIngredient.jsp");
//            view.forward(request, response);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
          
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
