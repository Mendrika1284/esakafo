/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DetailCommande;
import service.ServiceDetailCommande;
/**
 *
 * @author Jupiter
 */
public class ExportPDF extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ExportPDF</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ExportPDF at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
       response.setContentType("application/pdf");
  
        response.setHeader(
            "Content-disposition",
            "inline; filename='facture"+dtf.format(now)+".pdf'");
  
        try {
            int idCommande = Integer.parseInt(request.getParameter("idCommande"));
            ServiceDetailCommande dls = new ServiceDetailCommande();
            DetailCommande[] dt =  dls.findOneDetailCommandeDAO(idCommande);
            
           Document document = new Document();
  
            PdfWriter.getInstance(
                document, response.getOutputStream());
  
            document.open();
            int total = 0;
            document.add(new Paragraph("Facturation"));
            document.add(new Paragraph(""));
            for(int i = 0; i < dt.length; i++){
                int PrixPlat =dt[i].getPrix()* dt[i].getQuantite();
                total += PrixPlat;
                document.add(new Paragraph(dt[i].getNomPlat()+"  "+dt[i].getPrix()+" Ar "+"......x"+dt[i].getQuantite()));
            }  
            document.add(new Paragraph("Montant total: "+total+" Ar"));
            document.add(new Paragraph(""));
            document.add(new Paragraph("Merci de votre visite!"));
            document.close();
        }
        catch (DocumentException de) {
            throw new IOException(de.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(ExportPDF.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
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
