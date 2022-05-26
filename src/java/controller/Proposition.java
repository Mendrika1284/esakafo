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

/**
 *
 * @author Jupiter
 */
public class Proposition extends HttpServlet {
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
        try{ 
            double prixDeRevient = Double.parseDouble(request.getParameter("prixDeRevient").trim());
            double proposition = 0;
            request.setAttribute("erreur","");
            request.setAttribute("prixDeRevient", prixDeRevient);
            request.setAttribute("proposition", proposition);
            RequestDispatcher view = request.getRequestDispatcher("detail.jsp");
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
         try{
            double prixDeRevient = Double.parseDouble(request.getParameter("prixDeRevient").trim());
            double proposition = 0;
            if(!"".equals(request.getParameter("intervalle1")) && !"".equals(request.getParameter("intervalle2")) && !"".equals(request.getParameter("entre")) && !"".equals(request.getParameter("inferieur")) && !"".equals(request.getParameter("superieur"))) {
                   int intervalle1 = Integer.parseInt(request.getParameter("intervalle1").trim());
                   int intervalle2 = Integer.parseInt(request.getParameter("intervalle2").trim());        
                if(prixDeRevient < intervalle1){
                proposition = prixDeRevient + (Integer.parseInt(request.getParameter("inferieur").trim()) * prixDeRevient) / 100;
                }else if(prixDeRevient > intervalle1 && prixDeRevient < intervalle2){
                proposition = prixDeRevient + (Integer.parseInt(request.getParameter("entre").trim()) * prixDeRevient) / 100;
                }else{
                proposition = prixDeRevient + (Integer.parseInt(request.getParameter("superieur").trim()) * prixDeRevient) / 100;
                }
            request.setAttribute("erreur","");
            request.setAttribute("prixDeRevient", prixDeRevient);
            request.setAttribute("proposition", proposition);
            RequestDispatcher view = request.getRequestDispatcher("detail.jsp");
            view.forward(request, response);
            }else{   
            request.setAttribute("erreur", "FENOY NY BANGA");
            request.setAttribute("prixDeRevient", prixDeRevient);
            request.setAttribute("proposition", proposition);
            RequestDispatcher view = request.getRequestDispatcher("detail.jsp");
            view.forward(request, response);
        }    
        }catch(Exception e){
            e.printStackTrace();
        }
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
