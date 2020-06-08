/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author aluno
 */
public class CItem {
    
    private int qtde;
    private double precounit;
    private int codproduto;
    private int codvenda;

    /**
     * @return the qtde
     */
    public int getQtde() {
        return qtde;
    }

    /**
     * @return the precounit
     */
    public double getPrecounit() {
        return precounit;
    }

    /**
     * @return the codproduto
     */
    public int getCodproduto() {
        return codproduto;
    }

    /**
     * @return the codvenda
     */
    public int getCodvenda() {
        return codvenda;
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
     * @param precounit the precounit to set
     */
    public void setPrecounit(double precounit) {
        this.precounit = precounit;
    }
    
    public void setPrecounit(String precounit) throws Exception {
        this.precounit = Double.parseDouble(precounit);
        /*polimorfico*/
    }

    /**
     * @param codproduto the codproduto to set
     */
    public void setCodproduto(int codproduto) {
        this.codproduto = codproduto;
    }
    
    public void setCodproduto(String codp) throws Exception {
        this.codproduto = Integer.parseInt(codp);
        /*polimorfico*/
    }

    /**
     * @param codvenda the codvenda to set
     */
    public void setCodvenda(int codvenda) {
        this.codvenda = codvenda;
    }
    
    public void setCodvenda(String cvenda) throws Exception {
        this.codvenda = Integer.parseInt(cvenda);
        /*polimorfico*/
    }
     
}
