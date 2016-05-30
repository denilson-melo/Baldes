/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baldes;

/**
 *
 * @author Convidado
 */
public class Balde {
    int capacidade;
    int quantidade;
    
    public Balde(int capacidade, int quantidadeInicial){
        this.capacidade = capacidade;
        this.quantidade = quantidadeInicial;
    }
    
    public Balde(Balde b){
        this.capacidade = b.getCapacidade();
        this.quantidade = b.getQuantidade();
    }
    
    // Enche o balde por completo
    public int enche(){
        quantidade = capacidade;
        return quantidade;
    }
    
    // Esvazia o balde
    public int esvazia(){
        quantidade = 0;
        return quantidade;
    }
    
    // Transfere o conteudo deste balde para o referenciado
    public int transfere(Balde b){
        quantidade = b.enchePorTransferencia(quantidade);
        return quantidade;
    }
    
    // Enche o balde a patir da transferencia e retorna quanto "sobrou"
    private int enchePorTransferencia(int amount){
        quantidade += amount;
        int remaining = quantidade - capacidade;
        if (remaining > 0) {
            quantidade = capacidade;
            return remaining;
        }
        return 0;
    }
    
    public int getQuantidade(){
        return quantidade;
    }
    
    public int getCapacidade(){
        return capacidade;
    }
}
