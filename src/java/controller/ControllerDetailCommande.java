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
import model.Commande;
import model.Plat;
import service.ServiceCommande;
import service.ServiceDetailCommande;
import service.ServicePlat;

/**
 *
 * @author Jupiter
 */
public class ControllerDetailCommande extends HttpServlet {
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
            int idPlat = Integer.parseInt(request.getParameter("idPlat"));
            int quantite = Integer.parseInt(request.getParameter("quantite"));
            int idCommande = Integer.parseInt(request.getParameter("idCommande"));
            
            ServiceDetailCommande sdc = new ServiceDetailCommande();
            sdc.insertIntoDetailCommandeDAO(idPlat, quantite, idCommande);
            
            ServicePlat sp = new ServicePlat();
            Plat[] p = sp.findAllPlatDAO();
            ServiceCommande sc = new ServiceCommande();
            Commande[] commande = sc.findLastCommandeDAO();
            
            request.setAttribute("listePlat", p);
            request.setAttribute("lastCommande",commande);
            
            RequestDispatcher view = request.getRequestDispatcher("detailCommande.jsp");
            view.forward(request, response);
            
        }catch(Exception e){
        
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
