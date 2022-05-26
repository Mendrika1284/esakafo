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
import model.Facture;
import model.Type;
import service.ServiceFacture;
import service.ServiceServeur;

/**
 *
 * @author asus
 */
public class VoirPaiement extends HttpServlet {


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
        String date1 = request.getParameter("date1");
        String date2 = request.getParameter("date2");
    if(request.getParameter("date1")!=""){
                if(request.getParameter("date2")==""){
//                double pourboire = ServiceServeur.getPourboireDAO(idServeur, date1, "now()"); 
//                request.setAttribute("serveur", s);
//            request.setAttribute("pourboire",pourboire);
            ServiceFacture sf = new ServiceFacture();
            Type[] type = sf.getAllTypeDAO();
            Facture[] listeFactureCheck = sf.getFactureCheckByDate(date1, "now()");
            Facture[] listeFactureEspece = sf.getFactureEspeceByDate(date1,"now()");
            request.setAttribute("check", listeFactureCheck);
            request.setAttribute("espece", listeFactureEspece);
            RequestDispatcher view = request.getRequestDispatcher("/ListePayement.jsp");
            view.forward(request, response);
                 
                 }
                else{
                     String[] tab1=date1.split("-");
                      String[] tab2=date2.split("-");
                     if(Integer.parseInt(tab2[0].trim())<Integer.parseInt(tab1[0].trim())){
                         
                      String message="la date fin ne doit pas etre inferieur a la date debut";
                    request.setAttribute("erreur", message);
                RequestDispatcher v = request.getRequestDispatcher("/ListePayement.jsp");
                v.forward(request, response);
               }
                     else if(Integer.parseInt(tab2[0].trim())==Integer.parseInt((tab1[0].trim()))){
                        if(Integer.parseInt(tab2[1].trim())<Integer.parseInt(tab1[1].trim())){
                            String message="la date fin ne doit pas etre inferieur a la date debut";
                    request.setAttribute("erreur", message);
                RequestDispatcher v = request.getRequestDispatcher("/ListePayement.jsp");
                v.forward(request, response);
                        }
                         if(Integer.parseInt(tab2[1].trim())==Integer.parseInt(tab1[1].trim())){
                            if(Integer.parseInt(tab2[2].trim())<Integer.parseInt(tab1[2].trim())){
                                String message="la date fin ne doit pas etre inferieur a la date debut";
                    request.setAttribute("erreur", message);
                RequestDispatcher v = request.getRequestDispatcher("/ListePayement.jsp");
                v.forward(request, response); 
                            }
                        }
                     }
                     ServiceFacture sf = new ServiceFacture();
            Type[] type = sf.getAllTypeDAO();
            Facture[] listeFactureCheck = sf.getFactureCheckByDate(date1, date2);
            Facture[] listeFactureEspece = sf.getFactureEspeceByDate(date1, date2);
            request.setAttribute("check", listeFactureCheck);
            request.setAttribute("espece", listeFactureEspece);
//                    double pourboire = ServiceServeur.getPourboireDAO(idServeur, date1,date2); 
//                     request.setAttribute("serveur", s);
//            request.setAttribute("pourboire",pourboire);
            RequestDispatcher view = request.getRequestDispatcher("/ListePayement.jsp");
            view.forward(request, response);
                   
                }
            
            }
          
            else{
                String message="Vous devez saisir la date debut";
                request.setAttribute("erreur", message);
                RequestDispatcher view = request.getRequestDispatcher("/ListePayement.jsp");
                view.forward(request, response);
            }
           
            
           
            
            
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
