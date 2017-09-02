
package Resposta;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;


public class Mistura {
   
    private ArrayList respostas = new ArrayList();
    public Mistura(int quant){
        for (int i = 0; i < quant; i++) {
             respostas.add(i);
        }
         Collections.shuffle(respostas);
    }  
    
    public int[][] MatrizMistura(int[][] mat,int v, int h){
        int x =0;
        for(int i=0;i<v;i++){
            for(int j=0;j<h;j++){
                mat[i][j]=( (int) respostas.get(x));
                x++;
            }
        }
        
        return mat;
    }
}