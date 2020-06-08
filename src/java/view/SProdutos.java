/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

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
public class SProdutos extends HttpServlet {

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
        CRUDProduto objCRUD;
        int coluna=0;
        String s ="";
        String dep = request.getParameter("dep");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            objCRUD = new CRUDProduto();
            tabela = objCRUD.listar(Integer.parseInt(dep));
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/meuCSS.css\">");
            out.println("<head>");
            out.println("<title>Servlet SProdutos</title>");            
            out.println("</head>");
            out.println("<body>");
            if(tabela!= null)
            {
                out.println("<table border='1' align='center'> <tbody> <tr>");
                while (tabela.next())
                {
                    out.println("<td>");
                    s = "<p align='center' > <form action='SComprar' method='post' >" +
                            "<input type='text' hidden name='txtCodigo' " + 
                            "value= '" + tabela.getInt(1) + "' />" +
                            "<input type='text' hidden name='txtDescr' " + 
                            "value= '" + tabela.getString(2) + "' />" +
                            "<input type='text' hidden name='txtP' " + 
                            "value= '" + tabela.getDouble(3) + "' />" +
                            " <div class='zoom' align='center'> <img src='IMGS/" +tabela.getString(5)+"' " +
                            "width='150' height='150' /> </div> </br>" +
                            "<h1 class='TextoProduto' > "+tabela.getString(2) + "</h1>" +
                            "<h1 class='Preco' > Preço: R$" +tabela.getDouble(3)+"</h1>"+
                            "Quantidade: <input class='BotaoCompra' type='text' name='txtQTDE' value='1'/> </br>" +
                            "<div class='BotaoCompra' align='center'> <input class='BotaoCompra' type='submit' name='b1' value='Comprar' /> </div>" +
                            "</form></p>";
                    
                    out.println(s);
                    out.println("</td>");/*finaliza a coluna*/
                    
                    coluna++;
                    if (coluna==3)/*produtos por linhas*/
                    {
                        out.println("</tr><tr>");
                        coluna=0;
                    }
                }
                out.println("</tr></tbody></table>");
            }
            else {
                out.println("<h1>Não há produtos neste departamento.</h1>");
            }
            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception ex){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SCadastrar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Erro Servlet SProdutos at " + ex.getMessage() + "</h1>");
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
