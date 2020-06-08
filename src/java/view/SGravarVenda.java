/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controler.CRUDCliente;
import controler.CRUDItem;
import controler.CRUDVenda;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CCliente;
import model.CItem;
import model.CLista;
import model.CProduto;
import model.CVenda;

/**
 *
 * @author aluno
 */
public class SGravarVenda extends HttpServlet {

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
        String senha;
        HttpSession sessao;
        ArrayList<CProduto> lista;
        request.setCharacterEncoding("UTF-8");
        ResultSet tabela;
        CLista objCL = null;
        CVenda obj;
        CRUDVenda objCRUD;
        String codVenda = "";
        String codCliente = "naologado";
        String total;
        CCliente objC;
        CRUDCliente objCRUDC;
        CItem objI;
        CRUDItem objCRUDI;

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            objCRUDC = new CRUDCliente();
            codCliente = (objCRUDC.returningcod);
            if(codCliente.equalsIgnoreCase("naologado")){
                out.println("<h1> Usuario não logado </h1>");
                response.sendRedirect("TelaCL.html");
            }
            sessao = request.getSession(true);
            sessao.getAttribute("Cliente");
            lista = (ArrayList<CProduto>) sessao.getAttribute("lista");
            objCL.inicializar();
            obj = new CVenda();
            objCRUD = new CRUDVenda();
            total = request.getParameter("txtTotal");
            obj.setTotal(total);
            obj.setCodigocli(codCliente);

            tabela = objCRUD.gravar(obj);

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SCadastrar</title>");
            out.println("</head>");
            out.println("<body>");
            if (tabela != null) {
                while (tabela.next()) {
                    out.println("<h1>Venda gravada com sucesso. Código da venda: " + tabela.getString(1) +"</h1>");
                    codVenda = tabela.getString(1);
                    for (int i = 0; i < CLista.CLProduto.size(); i++) {
                    out.println("<h1>" + CLista.CLProduto.get(i).getDescr() + " </h1>");
                    objI = new CItem();
                    objCRUDI = new CRUDItem();
                    objI.setQtde(request.getParameter("txtQTDE"));
                    objI.setPrecounit(CLista.CLProduto.get(i).getPreco());
                    objI.setCodproduto(CLista.CLProduto.get(i).getCodigo());
                    objI.setCodvenda(codVenda);
                    objCRUDI.gravar(objI);
                    out.println("<h1>Item gravado com sucesso</h1> </br> _______+++_______ </br>");
                    }
                }
                lista.clear();
                objCL.limpar();
            }
            out.println("</body>");
            out.println("</html>");
        } catch (Exception ex) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SGravarVenda</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Erro Servlet SGravarVenda at " + ex.getMessage() + "</h1>");
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
