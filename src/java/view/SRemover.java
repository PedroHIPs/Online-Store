/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CLista;
import model.CProduto;

/**
 *
 * @author Pedro HIPs
 */
public class SRemover extends HttpServlet {

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
        CLista objCL;
        String codVenda = "";
        boolean CCheio = false;
        HttpSession sessao;
        ArrayList<CProduto> lista = null;
        CProduto obj;
        int cod = 0;
        int coluna = 0;
        String s = "";
        double total = 0;
        double aux = 0;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            sessao = request.getSession(true);
            objCL = new CLista();
            lista = (ArrayList<CProduto>) sessao.getAttribute("lista");
            if (lista == null) {
                objCL.inicializar();
                lista = new ArrayList<>();
            }
            cod = Integer.parseInt(request.getParameter("txtCod"));
            obj = new CProduto();
            lista.remove(cod);    
            objCL.Remover(cod);
            sessao.setAttribute("lista", lista);
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<link rel='stylesheet' type='text/css' href='CSS/meuCSS.css'>");
            out.println("<head>");
            out.println("<title>Servlet SComprar</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Removido com sucesso</h1>");
            if (lista != null) {
                CCheio = true;
                int i;
                for (i = 0; i < lista.size(); i++) {
                    obj = lista.get(i);
                    aux = (obj.getQtde() * obj.getPreco());
                    total += aux;
                    out.println("<table border='2' align='center'> <tbody> <tr>");
                    request.getSession().setAttribute("testeTotal", "total");

                    out.println("<td>");//início da coluna
                    s = "<p align='center' <form action='SControlador' method='post' >"
                            + "<h1> " + obj.getDescr() + "</h1>"
                            + "<h1> Preço: R$" + obj.getPreco() + "</h1>"
                            + "<h1> Qtde: " + obj.getQtde() + "</h1>"
                            + "<h1> Total: R$" + (obj.getQtde() * obj.getPreco()) + "</h1>"
                            + "</form></p>";
                    out.println(s);
                    out.println("<form action='SControlador' method='post' >");
                    out.println("<input type='hidden' name='txtCod' value='" + i + "' />");
                    out.println("<div class='BotaoCompra' align='right'> <input class='BotaoCompra' type='submit' name='b1' value='Remover' /> </div>");
                    out.println("</form>");
                    out.println("</td>");//fim da coluna

                    coluna++;
                    if (coluna == 3)//define quantos produtos por linhas
                    {
                        out.println("</tr><tr>");
                        coluna = 0;
                    }
                    out.println("</tr></tbody></table>");
                    out.println("<form action='SControlador' method='post' >");
                }
                out.println("<h1> Total da compra: R$" + total + "</h1>");
                out.println("<input type='hidden' name='txtTotal' value='" + total + "' />");
                out.println("</br> <div class='BotaoCompra' align='right'> <input class='BotaoCompra' type='submit' name='b1' value='Finalizar' /> </div>");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");
            } 
            else 
            {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet SComprar</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Erro ao abrir carrinho: Carrinho provavelmente vazio</h1>");
                out.println("</body>");
                out.println("</html>");
            }
        } catch (Exception ex) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SComprar</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Erro Servlet SComprar at " + ex.getMessage() + "</h1>");
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
