/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author aluno
 */
public class Banco {
    
    public static Connection conexao;
    public PreparedStatement comando;
    public ResultSet tabela;

    public Banco() throws Exception {
        try {
            Class.forName("org.postgresql.Driver");
            if ((conexao == null) || (conexao.isClosed())) {
                conexao = DriverManager.getConnection("jdbc:" + "postgresql://127.0.0.1:5432/LPB", "postgres", "ifsp");
            }
        } catch (Exception ex) {
            throw new Exception("Erro de conexâo: " + ex.getMessage());
        }
    }
}
