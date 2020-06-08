/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.sql.ResultSet;
import model.Banco;
import model.CCliente;

/**
 *
 * @author aluno
 */
public class CRUDCliente {
    
    public static String returningcod = "naologado";
    
    public void gravar(CCliente obj) throws Exception{
        Banco bb;
        try{
            bb = new Banco();
            bb.comando = Banco.conexao.prepareStatement("Insert into cliente(nome, login, senha) values(?, ?, ?)");
            bb.comando.setString(1,obj.getNome());
            bb.comando.setString(2,obj.getLogin());
            bb.comando.setString(3,obj.getSenha());
            bb.comando.executeUpdate();
            bb.conexao.close();
        }
        catch(Exception ex){
            throw new Exception("Erro ao gravar Cliente: " + ex.getMessage());
        }
    }
    
    public int Alterar(CCliente obj) throws Exception{
        Banco bb;
        int QTDE = 0;
        try{
            bb = new Banco();
            bb.comando = Banco.conexao.prepareStatement("update gente set nome = ? ,login = ?, senha = ? where codigo = ?");
            bb.comando.setString(1,obj.getNome());
            bb.comando.setString(2,obj.getLogin());
            bb.comando.setString(3,obj.getSenha());
            bb.comando.setInt(4,obj.getCodigo());
            QTDE = bb.comando.executeUpdate();
            Banco.conexao.close();
            return(QTDE);
        }
        catch(Exception ex){
            throw new Exception("Erro ao alterar Cliente: " + ex.getMessage());
        }
    }
    
    public CCliente login(String login, String senha) throws Exception
    {
        Banco bb;
        CCliente obj = null;
        try
        {
            bb = new Banco();
            bb.comando = Banco.conexao.prepareStatement("Select codigo, nome, login, senha from cliente where login=? and senha=?");
            bb.comando.setString(1, login);
            bb.comando.setString(2, senha);
            bb.tabela = bb.comando.executeQuery();
            if (bb.tabela.next())
            {
                obj = new CCliente();
                obj.setCodigo(bb.tabela.getInt(1));
                returningcod = String.valueOf(bb.tabela.getInt(1));
                obj.setNome(bb.tabela.getString(2));
                obj.setLogin(bb.tabela.getString(3));
                obj.setSenha(bb.tabela.getString(4));
            }
            Banco.conexao.close();
            return(obj);
        }
        catch (Exception ex)
        {
            throw new Exception ("Erro ao logar: " + ex.getMessage());
        }   
    }
}
