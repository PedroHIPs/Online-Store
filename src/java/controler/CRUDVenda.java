/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.sql.ResultSet;
import model.Banco;
import model.CVenda;

/**
 *
 * @author aluno
 */
public class CRUDVenda {

    public ResultSet gravar(CVenda obj) throws Exception {
        Banco bb;
        try {
            bb = new Banco();
            bb.comando = Banco.conexao.prepareStatement("Insert into venda(total, codcli) values(?, ?) returning codigo");
            bb.comando.setDouble(1, obj.getTotal());
            bb.comando.setInt(2, obj.getCodigocli());
            bb.tabela = bb.comando.executeQuery();
            Banco.conexao.close();
            return(bb.tabela);
        } catch (Exception ex) {
            throw new Exception("Erro ao gravar Venda: " + ex.getMessage());
        }
    }
}
