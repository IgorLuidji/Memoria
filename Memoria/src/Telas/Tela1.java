
package Telas;

import Resposta.Matriz;
import Resposta.Mistura;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Tela1 extends Tela{
    private int Erros;
    public Tela1(int quant, Matriz mat1, Matriz mat2, int fase,int erros) {
        super(quant, mat1, mat2, fase);
        Erros =erros;
        Botoes1[0][0].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Alterar1(0,0,Botoes1[0][0],painel,fase);
            }
        });
        
        Botoes1[0][1].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Alterar1(0,1,Botoes1[0][1],painel,fase);
            }
        });
        
        Botoes1[0][2].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Alterar1(0,2,Botoes1[0][2],painel,fase);
            }
        });
        
        Botoes1[1][0].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Alterar1(1,0,Botoes1[1][0],painel,fase);
            }
        });
        
        Botoes1[1][1].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Alterar1(1,1,Botoes1[1][1],painel,fase);
            }
        });
        
        Botoes1[1][2].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Alterar1(1,2,Botoes1[1][2],painel,fase);
            }
        });
        
        Botoes1[2][0].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Alterar1(2,0,Botoes1[2][0],painel,fase);
            }
        });
        
        Botoes1[2][1].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Alterar1(2,1,Botoes1[2][1],painel,fase);
            }
        });
        
        Botoes1[2][2].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Alterar1(2,2,Botoes1[2][2],painel,fase);
            }
        });
        
        Botoes2[0][0].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Alterar2(0,0,Botoes2[0][0],painel,fase);
            }
        });
        
        Botoes2[0][1].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Alterar2(0,1,Botoes2[0][1],painel,fase);
            }
        });
        
        Botoes2[0][2].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Alterar2(0,2,Botoes2[0][2],painel,fase);
            }
        });
        
        Botoes2[1][0].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Alterar2(1,0,Botoes2[1][0],painel,fase);
            }
        });
        
        Botoes2[1][1].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Alterar2(1,1,Botoes2[1][1],painel,fase);
            }
        });
        
        Botoes2[1][2].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Alterar2(1,2,Botoes2[1][2],painel,fase);
            }
        });
        
        Botoes2[2][0].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Alterar2(2,0,Botoes2[2][0],painel,fase);
            }
        });
        
        Botoes2[2][1].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Alterar2(2,1,Botoes2[2][1],painel,fase);
            }
        });
        
        Botoes2[2][2].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Alterar2(2,2,Botoes2[2][2],painel,fase);
                
            }
        });
        
        this.setBounds(30, 30, 1017, 590);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        new ApagaImg().start();
    }
    
    public void Alterar1(int posI,int posJ, JButton botao, Tela.Panel painel,int fase){
        //Dois botoes estão selecionados
        if(matriz1.isSelect() && matriz2.isSelect()){
            //Dois botoes tem o mesmo valor
            if(valor1.getValor() == valor2.getValor() ){
                    painel.remove(valor1.getBotao());
                    painel.remove(valor2.getBotao());
                    
                    matriz1.setSelect(false);
                    matriz2.setSelect(false);
                    
                    matriz1.setResto(matriz1.getResto()-1);
                    matriz2.setResto(matriz2.getResto()-1);
                }
                else{ 
                    valor1.getBotao().setIcon(null);
                    valor2.getBotao().setIcon(null);
                    matriz1.setSelect(false);
                    matriz2.setSelect(false);
                    Erros++;
                }
            if(matriz1.getResto()==0 && matriz2.getResto()==0){
                if(fase<4){
                    Mistura mist1 = new Mistura(9);
                    Mistura mist2 = new Mistura(9);
      
                    Matriz matr1 = new Matriz(3);
                    Matriz matr2 = new Matriz(3);
                    matr1.setMatriz(mist1.MatrizMistura(matr1.getMatriz(), 3, 3));
                    matr2.setMatriz(mist2.MatrizMistura(matr2.getMatriz(), 3, 3));
                    
                    Tela1 tela = new Tela1(3,matr1,matr2,fase+1,Erros);//AQUI!!!!
                    this.dispose();
                }
                else{
                    play("Yeah");
                    JOptionPane.showMessageDialog(null, "Parabéns, Você Ganhou!!!\n Você errou:"+Erros);
                    String nome = JOptionPane.showInputDialog("Digite seu nome:");
                    
                    NovoJogo njovo = new NovoJogo();
                    
                    Ranking rank = new Ranking(nome,Erros);
                    //Vitoria vitoria = new Vitoria();
                    
                    this.dispose();
                }
            }
        }
        else{
            if(matriz1.isSelect()){
                 play("1");
            }
            else{
                valor1.setValor(matriz1.ValorPos(posI, posJ));
                valor1.setPosI(posI);
                valor1.setPosJ(posJ);
                valor1.setBotao(botao);
                matriz1.setSelect(true);
                ImageIcon img;
                img = new ImageIcon(System.getProperty("user.dir")+("\\src\\Telas\\")+("Imagens\\"+fase+"\\"+ramdon+"\\Resposta\\"+matriz1.ValorPos(posI, posJ) + ".png"));
                valor1.getBotao().setIcon(img);          
            }  
            
            
            if(matriz1.isSelect() && matriz2.isSelect()){
                if(valor1.getValor() == valor2.getValor() ){
                    play("Acerto");
                }
                else{ 
                    play("Erro");
                }
            }
            
        }
        painel.revalidate();
        painel.repaint();
    }
    
    public void Alterar2(int posI,int posJ, JButton botao, Tela.Panel painel,int fase){
        if(matriz1.isSelect() && matriz2.isSelect()){
            if(valor1.getValor() == valor2.getValor() ){
                    painel.remove(valor1.getBotao());
                    painel.remove(valor2.getBotao());
                    
                    matriz1.setSelect(false);
                    matriz2.setSelect(false);
                    
                    matriz1.setResto(matriz1.getResto()-1);
                    matriz2.setResto(matriz2.getResto()-1);
                }
                else{ 
                    valor1.getBotao().setIcon(null);
                    valor2.getBotao().setIcon(null);
                    matriz1.setSelect(false);
                    matriz2.setSelect(false);
                    Erros++;
                }
            if(matriz1.getResto()==0 && matriz2.getResto()==0){
                if(fase<4){
                    Mistura mist1 = new Mistura(9);
                    Mistura mist2 = new Mistura(9);
      
                    Matriz matr1 = new Matriz(3);
                    Matriz matr2 = new Matriz(3);
                    matr1.setMatriz(mist1.MatrizMistura(matr1.getMatriz(), 3, 3));
                    matr2.setMatriz(mist2.MatrizMistura(matr2.getMatriz(), 3, 3));
                   
                    Tela1 tela = new Tela1(3,matr1,matr2,fase+1,Erros);//AQUI!!!!
                    this.dispose();
                }
                else{
                    play("Yeah");
                    JOptionPane.showMessageDialog(null, "Parabéns, Você Ganhou!!!\n Você errou:"+Erros);
                    String nome = JOptionPane.showInputDialog("Digite seu nome:");
                    
                    NovoJogo njovo = new NovoJogo();
                    
                    Ranking rank = new Ranking(nome,Erros);
                    //Vitoria vitoria = new Vitoria();
                    
                    this.dispose();
                }
            }
        }
        else{
            if(matriz2.isSelect()){
                 play("1");
            }
            else{
                valor2.setValor(matriz2.ValorPos(posI, posJ));
                valor2.setPosI(posI);
                valor2.setPosJ(posJ);
                valor2.setBotao(botao);
                matriz2.setSelect(true);
                ImageIcon img2;
                
                img2 = new ImageIcon(System.getProperty("user.dir")+("\\src\\Telas\\")+("Imagens\\"+fase+"\\"+ramdon+"\\Pergunta\\"+matriz2.ValorPos(posI, posJ) + ".png"));
                valor2.getBotao().setIcon(img2);
                valor2.getBotao().validate();
                valor2.getBotao().revalidate();
                valor2.getBotao().repaint();
            }
            
            if(matriz1.isSelect() && matriz2.isSelect()){
                if(valor1.getValor() == valor2.getValor() ){
                    play("Acerto");
                }
                else{ 
                    play("Erro");
                }
            }
        }
        
        //this.dispose();
        painel.revalidate();
        painel.repaint();
    }
    
    
    public void play(String nome){
        
        URL url = Tela1.class.getResource(nome+".wav");
        
        AudioClip audio = Applet.newAudioClip(url);
        audio.play();
    }
    
}
