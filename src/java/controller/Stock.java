/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
public class Stock extends HttpServlet {
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
 try{
            String date1 = request.getParameter("date1");
            String date2 = request.getParameter("date2");
            ServicePlat sp = new ServicePlat();
            Plat[] plat = sp.findPlat2DateDAO("2022-03-27", "2022-04-05");
            ServiceIngredient si = new ServiceIngredient();
            Ingredient[] ingredient = si.findAllIngredientDAO();
            
            for(int i = 0; i < plat.length; i++){
                si.findIngredientByIdPlatDAO(plat[i].getIdPlat(),ingredient);
            }
            for(int i = 0; i < ingredient.length; i++){
                ingredient[i].setPrix(ingredient[i].getPrix()*ingredient[i].getQuantiteIngredient());
                ingredient[i].setQuantiteIngredient(ingredient[i].getQuantiteIngredient()+i);
            }
            int somme = Ingredient.somme(ingredient);
            request.setAttribute("listeIngredient", ingredient);
            request.setAttribute("somme", somme);
//            System.out.println(ingredient[0].getNomIngredient()+"ufygeifefuzeufizefuefzifhzeiufhzieufhziuefhznsdvhenskldnvehvnlsdn");
            RequestDispatcher view = request.getRequestDispatcher("stock.jsp");
            view.forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
        }        
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
