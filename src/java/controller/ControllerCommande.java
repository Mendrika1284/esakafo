/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Commande;
import model.Plat;
import service.ServiceCommande;
import service.ServicePlat;

/**
 *
 * @author Jupiter
 */
public class ControllerCommande extends HttpServlet {

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
            int idServeur = Integer.parseInt(request.getParameter("idServeur"));
            int table = Integer.parseInt(request.getParameter("table"));
            Date d = new Date();
            String date = d.toString();
            ServiceCommande sc = new ServiceCommande();
            sc.insertIntoCommandeDAO(idServeur, date, table, 0);
            
            ServicePlat sp = new ServicePlat();
            Plat[] p = sp.findAllPlatDAO();
            
            Commande[] commande = sc.findLastCommandeDAO();
            
            HttpSession session = request.getSession();
            session.setAttribute("lastCommandeId", commande);
            request.setAttribute("listePlat", p);
            request.setAttribute("lastCommande",commande);
            
            RequestDispatcher view = request.getRequestDispatcher("detailCommande.jsp");
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
