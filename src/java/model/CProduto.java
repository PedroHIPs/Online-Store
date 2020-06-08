/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class CProduto {
    
    private int codigo;
    private int coddep;
    private int qtde;
    private String descr;
    private double preco;
    private String imagem;


    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @return the coddep
     */
    public int getCoddep() {
        return coddep;
    }

    /**
     * @return the qtde
     */
    public int getQtde() {
        return qtde;
    }

    /**
     * @return the descr
     */
    public String getDescr() {
        return descr;
    }

    /**
     * @return the preco
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @return the imagem
     */
    public String getImagem() {
        return imagem;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public void setCodigo(String codigo) throws Exception {
        this.codigo = Integer.parseInt(codigo);
        /*polimorfico*/
    }

    /**
     * @param coddep the coddep to set
     */
    public void setCoddep(int coddep) {
        this.coddep = coddep;
    }
    
    public void setCodigodep(String codigodep) throws Exception {
        this.coddep = Integer.parseInt(codigodep);
        /*polimorfico*/
    }

    /**
     * @param qtde the qtde to set
     */
    public void setQtde(int qtde) {
        this.qtde = qtde;
    }
    
     public void setQtde(String qtde) throws Exception {
        this.qtde = Integer.parseInt(qtde);
        /*polimorfico*/
    }

    /**
     * @param descr the descr to set
     */
    public void setDescr(String descr) {
        this.descr = descr;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public void setPreco(String preco) throws Exception {
        this.preco = Double.parseDouble(preco);
        /*polimorfico*/
    }

    /**
     * @param imagem the imagem to set
     */
    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
