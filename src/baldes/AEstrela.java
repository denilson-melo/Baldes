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
public class AEstrela {
    
    Arvore raiz;
    Caminhos caminhos;
    
    public AEstrela(Arvore raiz){
        this.raiz = raiz;
    }
    
    public void buscar() {
        caminhos = new Caminhos();
        caminhos.adiciona(raiz);
            do {
                Arvore caminho = caminhos.menor();                
                caminhos.remove(caminho);
                
                // Se encontrou o nó desejado
                if (Main.encontrou(caminho) == 1) {
                    System.out.println("");
                    System.out.println("ENCONTRADO :");
                    caminho.visita();
                    caminho.mostraCaminho();
                    return;
                }
                
                caminho.geraFilhos();
                caminho.removeCiclo();
                
                heuristica(caminho);
                // Aplica-se a heurística para que a quantidade de caminhos
                // seja reduzida. Isto aumenta a eficiência do algoritmo.
                // Isto é feito comparando-se cada dois caminhos que
                // terminam em um mesmo nó, e retendo-se apenas o menor deles. 
                                
            } while(!caminhos.vazio());
       
    }
        
    public void heuristica(Arvore caminho){        
        for(int i = 0; i < caminho.filhos.size(); i++){
            Arvore filho = caminho.filhos.get(i);
            

            if (!caminhos.possuiCaminhoComDestino(filho)) {
                caminhos.adiciona(filho);
            } else {
                Arvore caminhoJaVisitado = caminhos.get(filho);

                if (caminhos.comprimentoDoCaminho(filho) < 
                   caminhos.comprimentoDoCaminho(caminhoJaVisitado))
                {
                    System.out.println("Usou a heurística...");
                    caminhos.remove(caminhoJaVisitado);
                    caminhos.adiciona(filho);
                }
            }
        }        
    }
    
}
