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
public final class Fila {
    
	private static ArrayList<Arvore> items = new ArrayList<Arvore>();

	public static void push(Arvore t){
            items.add(t);
	}
        
        public static Arvore pop(){
            return items.remove(0);
        }
        
        public static int vazia(){
            if (items.size() > 0) {
                return 0;
            }
            return 1;
        }
}
