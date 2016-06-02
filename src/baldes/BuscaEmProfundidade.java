/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baldes;

/**
 *
 * @author Denilson
 */
public class BuscaEmProfundidade {
    
    boolean encontrou = false;
    
    public boolean buscar(Arvore no){ 
        
        // Se encontrou o nó desejado
        if (Main.encontrou(no) == 1) {            
            System.out.println("");
            System.out.println("ENCONTRADO");
            no.visita();            
            no.mostraCaminho();
            encontrou = true;
            return encontrou;
        }    

        no.geraFilhos();
        no.removeCiclo();

        // Continua a busca em profundidade
        for (int i = 0; i < no.filhos.size(); i++) {
            encontrou = buscar(no.filhos.get(i));
            if (encontrou)
                break;
        }
        
        return encontrou;        
    }
}
