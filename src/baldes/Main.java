/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baldes;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Convidado
 */
public final class Main {

    static Arvore target;
    static int Capacidade1, Capacidade2, Quantidade1, Quantidade2, Opcao;
    /**
     * @param args the command line arguments
     * 0,0
     * 4,1
     */
    
    public static void main(String[] args) {
        
        Capacidade1 = 3;
        Capacidade2 = 4;
        
        Scanner ler = new Scanner(System.in);
                    
        do {
            System.out.println("Informe a quantidade que deseja obter no balde A:");
            Quantidade1 = ler.nextInt();                
        } while(!entradaValida());
        do {
            System.out.println("Informe a quantidade que deseja obter no balde B:");
            Quantidade2 = ler.nextInt();
        } while(!entradaValida());
            
        
        System.out.println("Informe o metodo que deseja utili3zar: \n 1 - Busca em Largura\n 2 - Busca em Profundidade\n 3 - A*");
        Opcao = ler.nextInt();
        

        Balde A,B;
        A = new Balde(Capacidade1,0);
        B = new Balde(Capacidade2,0);
        
        target = new Arvore(null, new Balde(Capacidade1,Quantidade1), new Balde(Capacidade2,Quantidade2));        
        Arvore raiz = new Arvore(null, A, B);
        switch(Opcao){
            case 1: 
                BuscaEmLargura buscaEmLargura = new BuscaEmLargura();
                buscaEmLargura.buscar(raiz);
                break;
            case 2: 
                
                BuscaEmProfundidade buscaEmProfundidade = new BuscaEmProfundidade();                
                buscaEmProfundidade.buscar(raiz);
                break;
            case 3: 
                AEstrela aEstrela = new AEstrela(raiz);                
                aEstrela.buscar();
                break;
            default: System.out.println("Opcao invalida");
        }       
        
    }
    
    static boolean entradaValida(){
        if (Quantidade1 > Capacidade1 || Quantidade2 > Capacidade2) {
            System.out.println("A quantidade informada excede a capacidade do balde");
            return false;
        }
        if ( Quantidade1 < 0 || Quantidade2 < 0) {
            System.out.println("A quantidade não pode ser um valor negativo");
            return false;
        }
        return true;
    }

    public static int encontrou(Arvore t){
        if (t.A.getQuantidade() == target.A.getQuantidade() && t.B.getQuantidade() == target.B.getQuantidade()) {
            return 1;
        }
        return 0;
    }
    
}