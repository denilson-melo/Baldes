/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baldes;

import java.util.ArrayList;

/**
 *
 * @author Denilson
 */
public class Caminhos {
    
    private ArrayList<Arvore> items = new ArrayList<Arvore>(); 

    public boolean vazio(){
        if (items.size() == 0) {
            return true;
        }
        return false;
    }
    
    public Arvore get(Arvore destino){        
        for(int i = 0; i < items.size(); i++){
            if(iguais(destino, items.get(i))){
                return items.get(i);
            }
        }
        
        return null;
    }
    
    public void adiciona(Arvore item) {
        items.add(item);
    }
    
    public void remove(Arvore item) {        
        items.remove(item);
    }
    
    public Arvore menor(){   
        Arvore menorCaminho = items.get(0);
        for(int i = 1; i < items.size(); i++){
            if(comprimentoDoCaminho(items.get(i)) < comprimentoDoCaminho(menorCaminho)){
                menorCaminho = items.get(i);
            }
        }        
        return menorCaminho;
    }
    
    public int comprimentoDoCaminho(Arvore caminho){
        int comprimento = 0;
        Arvore ponteiro = caminho.pai;
        
        while(ponteiro != null){
            comprimento++;
            ponteiro = ponteiro.pai;
        }
         
        return comprimento;
    }
    
    public boolean possuiCaminhoComDestino(Arvore destino){
        for(int i = 0; i < items.size(); i++){
            if(iguais(destino, items.get(i))){
                return true;
            }
        }
        return false;
    }
    
     private boolean iguais(Arvore a, Arvore b){	
        if(a.A.getQuantidade() == b.A.getQuantidade() && 
           a.B.getQuantidade() == b.B.getQuantidade())
            return true;
        return false;
    }
    
}
