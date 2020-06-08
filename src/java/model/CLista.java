/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Pedro HIPs
 */
public class CLista {

    /**
     *
     */
    public static ArrayList<CProduto> CLProduto;
    
    public static void inicializar(){
        if(CLProduto==null){
            CLProduto= new ArrayList<>();
        }
    }
    
    public static void limpar(){
        if(CLProduto!=null){
            CLProduto.clear();
        }
    }
    
    public static void Remover(int cod){
        if(CLProduto!=null){
            CLProduto.remove(cod);
        }
    }
}
