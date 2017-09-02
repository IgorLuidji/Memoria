package Telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Ranking extends JFrame {
    private ImageIcon img;
    
    private Panel painel;
    private JLabel [] posicoes = new JLabel[5];
    private JLabel [] Nomes = new JLabel[5];
    
    public Ranking(){
        super("Ranking");
        img = new ImageIcon(System.getProperty("user.dir")+("\\src\\Telas")+("\\Imagens\\Ranking.png"));
        painel = new Panel();
        
        this.add(painel);
        painel.setLayout(null);
        
        int[] ranking = lerarquivo();
        String [] nomes = lernomes();
        
        
        for(int i=0; i<5; i++){
            posicoes[i] = new JLabel();
            painel.add(posicoes[i]);
            posicoes[i].setBounds(300, 235+(i*55), 50, 50);
            if(ranking[i]==-1){
                posicoes[i].setText("#");
            }
            else{
               posicoes[i].setText("" +ranking[i]); 
            }
            
            posicoes[i].setFont(new Font("MV boli", Font.PLAIN, 30));
        }
        
        for(int i=0; i<5; i++){
            Nomes[i] = new JLabel();
            painel.add(Nomes[i]);
            Nomes[i].setBounds(100, 235+(i*55), 150, 50);
            
            Nomes[i].setText("" +nomes[i]); 
            
            
            Nomes[i].setFont(new Font("MV boli", Font.PLAIN, 30));
        }
        
        this.setBounds(100, 100, 390, 530);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        
    }
    
    public Ranking(String nome, int erros){
        super("Ranking");
        img = new ImageIcon(System.getProperty("user.dir")+("\\src\\Telas")+("\\Imagens\\Ranking.png"));
        painel = new Panel();
        
        this.add(painel);
        painel.setLayout(null);
        
        int[] ranking = lerarquivo();
        String [] nomes = lernomes();
        
        for(int i= 0; i<5;i++){
            if(erros<=ranking[i] || (ranking[i]==-1)){
                for(int j = 4;j>i;j--){
                    ranking[j] = ranking[j-1];
                    nomes[j]= nomes[j-1];
                }
                ranking[i]=erros;
                nomes[i] = nome;
                break;
            }
        }
        
        EscreverArq(ranking,nomes);
        
        for(int i=0; i<5; i++){
            posicoes[i] = new JLabel();
            painel.add(posicoes[i]);
            posicoes[i].setBounds(300, 235+(i*55), 50, 50);
            if(ranking[i]==-1){
                posicoes[i].setText("#");
            }
            else{
               posicoes[i].setText("" +ranking[i]); 
            }
            
            posicoes[i].setFont(new Font("MV boli", Font.PLAIN, 30));
        }
        
        for(int i=0; i<5; i++){
            Nomes[i] = new JLabel();
            painel.add(Nomes[i]);
            Nomes[i].setBounds(100, 235+(i*55), 150, 50);
            
            Nomes[i].setText("" +nomes[i]); 
            
            
            Nomes[i].setFont(new Font("MV boli", Font.PLAIN, 30));
        }
        
        this.setBounds(100, 200, 390, 530);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        
    }
    
    public class Panel extends JPanel{
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img.getImage(), 0, 0, this);
        }
    }
    
    public int[] lerarquivo(){
        int [] vetorRanking = new int[5];
        
        try {
            //System.out.println(""+System.getProperty("user.dir")+("\\src\\Ranking\\")+("Resultados.txt"));
            FileReader file = new FileReader(System.getProperty("user.dir")+("\\src\\Ranking\\")+("Resultados.txt"));
            BufferedReader buf = new BufferedReader(file);

            for(int i=0; i<5;i++){
                String linha = buf.readLine();
                vetorRanking[i] = Integer.parseInt(linha);
                //System.out.println(""+vetorRanking[i]);
            }
            file.close();
        } catch (Exception ex) {
            System.out.println("Deu ruim");
        }
        return vetorRanking;
    }
    
    public String[] lernomes(){
        String [] nomes = new String[5];
        
        try {
            //System.out.println(""+System.getProperty("user.dir")+("\\src\\Ranking\\")+("Nomes.txt"));
            FileReader file = new FileReader(System.getProperty("user.dir")+("\\src\\Ranking\\")+("Nomes.txt"));
            BufferedReader buf = new BufferedReader(file);

            for(int i=0; i<5;i++){
                 nomes [i] = buf.readLine();
                //System.out.println(""+nomes[i]);
            }
            file.close();
        } catch (Exception ex) {
            System.out.println("Deu ruim");
        }
        
        return nomes;
    }

    public void EscreverArq(int[] ranking,String[] nomes){
        try {
            
            FileWriter Ranking = new FileWriter(System.getProperty("user.dir")+("\\src\\Ranking\\")+("Resultados.txt"));
            PrintWriter gravarRanking = new PrintWriter(Ranking);
            FileWriter Nomes = new FileWriter(System.getProperty("user.dir")+("\\src\\Ranking\\")+("Nomes.txt"));
            PrintWriter gravarNomes= new PrintWriter(Nomes);
            for(int i=0; i<5;i++){
                if(i<4){
                    gravarRanking.printf(""+ranking[i]+"%n");
                    gravarNomes.printf(""+nomes[i]+"%n");
                }
                else{
                    gravarRanking.printf(""+ranking[i]);
                    gravarNomes.printf(""+nomes[i]);
                }
                
            }
            Ranking.close();
            Nomes.close();
        } catch (Exception ex) {
            System.out.println("Deu ruim na escrita");
        }
        
    }
}
