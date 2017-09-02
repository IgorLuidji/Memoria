package Telas;

import Resposta.Matriz;
import Resposta.Mistura;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class NovoJogo extends JFrame{
    ImageIcon img;
    private Panel painel;
    JButton BotaoNovoJogo,BotaoVS,BotaoContraTempo,BotaoCreditos,BotaoRanking,BotaoRankingTemp;
    
    public NovoJogo(){
        super("Jogo da Memoria");
        img = new ImageIcon(System.getProperty("user.dir")+("\\src\\Telas")+("\\Imagens\\Capa.png"));
        painel = new Panel();
        
        this.add(painel);
        painel.setLayout(null);
        
        BotaoNovoJogo = new JButton("Novo Jogo");
        painel.add(BotaoNovoJogo);
        BotaoNovoJogo.setBounds(150,300,100,30);
        
        BotaoVS = new JButton("Jogo VS");
        painel.add(BotaoVS);
        BotaoVS.setBounds(300,300,100,30);
        
        BotaoContraTempo = new JButton("Por Tempo");
        painel.add(BotaoContraTempo);
        BotaoContraTempo.setBounds(450,300,100,30);
        
        BotaoCreditos = new JButton("Creditos");
        painel.add(BotaoCreditos);
        BotaoCreditos.setBounds(300,350,100,30);
        
        BotaoRanking = new JButton("Ranking");
        painel.add(BotaoRanking);
        BotaoRanking.setBounds(150,350,100,30);
        
        BotaoRankingTemp = new JButton("Ranking");
        painel.add(BotaoRankingTemp);
        BotaoRankingTemp.setBounds(450,350,100,30);
        
        BotaoNovoJogo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                novoJogo(0);
            }
        });
        
        BotaoVS.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                novoJogo(1);
            }
        });
        
        BotaoContraTempo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                novoJogo(2);
            }
        });
        
        BotaoCreditos.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Vitoria vitoria = new Vitoria();
            }
        });
        
        BotaoRanking.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Ranking rank = new Ranking();
            }
        });
        BotaoRankingTemp.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Ranking1 rank = new Ranking1();
            }
        });
        
        
        this.setBounds(100, 100, 710, 540);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
    }
    
    private void novoJogo(int i){
      Mistura mist1 = new Mistura(9);
      Mistura mist2 = new Mistura(9);
      
      Matriz mat1 = new Matriz(3);
      Matriz mat2 = new Matriz(3);
      mat1.setMatriz(mist1.MatrizMistura(mat1.getMatriz(), 3, 3));
      mat2.setMatriz(mist2.MatrizMistura(mat2.getMatriz(), 3, 3));
      
     Random rand = new Random();
      if(i==0){ 
          JOptionPane.showMessageDialog(null, "Vai começar o jogo da Memoria Educativo\nExistem cinco fases com temas diferentes\nComplete as cinco para ganhar!");
          Tela1 tela = new Tela1(3,mat1,mat2,0,0);
      }
      
      if(i==1){
          JOptionPane.showMessageDialog(null, "Modo Versus:\n Dois jogadores Disputam quem irá ganhar mais fases\n O Cor preta representa o jogador da vez\n"
                  + " Quem fizer mais pontos em uma fase ganha a fase\n Aquele que ganhar mais fases é o vencedor"); 
          Tela2 tela = new Tela2(3,mat1,mat2,0,0,0,rand.nextInt(2));
      }
      if(i==2){
          
          Tela3 tela = new Tela3(3,mat1,mat2,0,0);
      }
      
      this.dispose();
    }
    
    public class Panel extends JPanel{
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img.getImage(), 0, 0, this);
        }
    }

}