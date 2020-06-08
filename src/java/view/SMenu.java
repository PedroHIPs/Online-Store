/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controler.CRUDDepartamento;
import controler.CRUDProduto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aluno
 */
public class SMenu extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        ResultSet tabela;
        CRUDDepartamento objCRUD;
        int dep = 1;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            objCRUD = new CRUDDepartamento();
            tabela = objCRUD.listar();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<link rel='stylesheet' type='text/css' href='CSS/meuCSS.css'>");
            out.println("<head>");
            out.println("<title>Servlet SMenu</title>");            
            out.println("</head>");
            out.println("<body>");
            if(tabela!= null){
                while (tabela.next()){
                    out.println("<a class='Amenu' href='SProdutos?dep=" + tabela.getInt(1) +"' target='ifProdutos'>" + tabela.getString(2) + "</a>");
                    out.println(" | ");
                }
            }
            out.println(" <a class='Amenu' href='SCarrinho' target='ifProdutos' > Carrinho: </a> <a class='carrinho' href='SCarrinho' target='ifProdutos'> <img src='IMGS/carrinho.png' width='30' height='30' alt='carrinho'/> </a>");
            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception ex){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SMenu</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Erro at servlet SMenu: " + ex.getMessage() + "</h1>");
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
        processRequest(request, response);
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
