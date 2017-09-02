
package Resposta;

import java.util.Collections;

public class Matriz {
    private int Matriz[][];
    private int resto;
    private boolean select;
    
    public int getResto() {
        return resto;
    }

    public void setResto(int resto) {
        this.resto = resto;
    }
    
    public int[][] getMatriz() {
        return Matriz;
    }

    public void setMatriz(int[][] Matriz) {
        this.Matriz = Matriz;
    }
    
    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }
    
    public Matriz(int tam){
        select = false;
        resto = tam*tam;
        Matriz= new int[tam][tam];
        for(int i=0;i<tam;i++){
            for(int j=0;j<tam;j++){
                Matriz[i][j] = -1;
            }
        }
    }
    
    public void SetValor(int posI,int posJ, int valor){
        Matriz[posI][posJ]=valor;
    }
    
    public int ValorPos(int posI, int posJ){
        return Matriz[posI][posJ];
    }
    
}
