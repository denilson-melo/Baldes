/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baldes;

import java.util.ArrayList;

/**
 *
 * @author Convidado
 */
public final class Main {

    static Arvore target;
  
    /**
     * @param args the command line arguments
     * 0,0
     * 4,1
     */
    public static void main(String[] args) {
        // TODO code application logic here               
        Balde A,B;
        A = new Balde(3,0);
        B = new Balde(4,0);
        
        target = new Arvore(null, new Balde(3,3), new Balde(4,3));        
        Arvore tree = new Arvore(null, A, B);        
        tree.buscaEmLargura();
    }

    public static int encontrou(Arvore t){
        if (t.A.getQuantidade() == target.A.getQuantidade() && t.B.getQuantidade() == target.B.getQuantidade()) {
            return 1;
        }
        return 0;
    }
    
}