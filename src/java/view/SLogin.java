/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controler.CRUDCliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CCliente;

/**
 *
 * @author aluno
 */
public class SLogin extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        CCliente obj;
        CRUDCliente objCRUD;
        String login;
        String senha;
        HttpSession sessao;
        
        try {
            objCRUD = new CRUDCliente();
            login = request.getParameter("txtLogin");
            senha = request.getParameter("txtPass");
            obj = objCRUD.login(login, senha);
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<link rel='stylesheet' type='text/css' href='CSS/meuCSS.css'>");
            out.println("<head>");
            out.println("<title>Servlet SLogin</title>");            
            out.println("</head>");
            out.println("<body>");
            if (obj==null)
                out.println ("<h1 class='Login' > Erro ao Logar, usuario ou senha provavelmente incorretos.</h1>");
            else
            {
                sessao = request.getSession(true);
                sessao.setAttribute("cliente", obj);
                /*sessao.setAttribute("cod", objCRUD.returningcod);*/
                out.println ("<h1 class='ola'> Olá, " + login + "</h1>");
            }
            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception ex){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SLogin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 class='Login' >Erro Servlet SLogin at " + ex.getMessage() + "</h1>");
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
