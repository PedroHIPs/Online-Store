/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author aluno
 */
public class CVenda {
    
    private int codigo;
    private double total;
    private Timestamp data;
    private int codigocli;
    
    public int getCodigo() {
        return codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public void setCodigo(String codigo) throws Exception {
        this.codigo = Integer.parseInt(codigo);
        /*polimorfico*/
    }
    
    public int getCodigocli() {
        return codigocli;
    }
    
    public void setCodigocli(int codigocli) {
        this.codigocli = codigocli;
    }
    
    public void setCodigocli(String codigocli) throws Exception {
        this.codigocli = Integer.parseInt(codigocli);
        /*polimorfico*/
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @return the data
     */
    public Timestamp getData() {
        return data;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }
    
    public void setTotal(String total) throws Exception {
        this.total = Double.parseDouble(total);
        /*polimorfico*/
    }

    /**
     * @param data the data to set
     */
    public void setData(Timestamp data) {
        this.data = data;
    }
    
    public void setData(String data) throws Exception {
        this.data = Timestamp.valueOf(data);
    }
}
