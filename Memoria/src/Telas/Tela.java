package Telas;

import Resposta.Matriz;
import Resposta.Mistura;
import Resposta.Valor;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class Tela extends JFrame {
    ImageIcon fundo;
    
    
    Matriz matriz1;
    Matriz matriz2;
    
    Valor valor1 = new Valor();
    Valor valor2 = new Valor();
    
    Panel painel;
    JLabel label;
    JButton BotaoAjuda;
    JButton[][] Botoes1;
    JButton[][] Botoes2;
    int ramdon;
    int flag=0;
    
    public Tela(int quant,Matriz mat1,Matriz mat2,int fase){
        super("Jogo Memoria");
        
        //Nao MEXE
        Random rand = new Random();
        
        ramdon = rand.nextInt(3);
        
        String caminho = TelaPrincipal.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        fundo = new ImageIcon(System.getProperty("user.dir")+("\\src\\Telas")+("\\Imagens\\"+fase+"\\"+ramdon+"\\capa.png"));
        
        matriz1 = mat1;
        matriz2 = mat2;
        
        painel = new Panel();
        this.add(painel);
        painel.setLayout(null);
        
        BotaoAjuda = new JButton("Ajuda?");
        painel.add(BotaoAjuda);
        BotaoAjuda.setBounds(910,10,80,30);
        
        BotaoAjuda.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Clique em um botao azul ou vermelho,\n e tente encontrar a figura correspondente\n na outra cor");
            }
        });
        
        
        Botoes1 = new JButton [quant][quant];
        for(int i =0; i<quant;i++){
            for(int j=0;j<quant;j++){
                Botoes1[i][j] = new JButton();
                painel.add(Botoes1[i][j]);
                Botoes1[i][j].setBounds((j*100)+(j*50)+50,(i*100)+(i*50) +130, 100, 100);
                Botoes1[i][j].setBackground(Color.blue);
                ImageIcon img;
                img = new ImageIcon(System.getProperty("user.dir")+("\\src\\Telas\\")+("Imagens\\"+fase+"\\"+ramdon+"\\Resposta\\"+matriz1.ValorPos(i, j) + ".png"));
                Botoes1[i][j].setIcon(img);   
            }   
        }
        
        
        Botoes2 = new JButton [quant][quant];
        for(int i =0; i<quant;i++){
            for(int j=0;j<quant;j++){
                Botoes2[i][j] = new JButton();
                painel.add(Botoes2[i][j]);
                Botoes2[i][j].setBounds((j*100)+(j*50)+550,(i*100)+(i*50)+130, 100, 100);
                Botoes2[i][j].setBackground(Color.red);
                
                ImageIcon img;
                img = new ImageIcon(System.getProperty("user.dir")+("\\src\\Telas\\")+("Imagens\\"+fase+"\\"+ramdon+"\\Pergunta\\"+matriz2.ValorPos(i, j) + ".png"));
                Botoes2[i][j].setIcon(img);
                
            }   
        }
    }
    
    
    

    
    public class Panel extends JPanel{
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(fundo.getImage(), 0, 0, this);
        }
    }
    
    public class ApagaImg extends Thread{
        public void run(){
            while(flag==0){
                try{
                    Thread.sleep(3000);
                }catch(Exception e){
                    
                }
                for(int i=0;i<3;i++){
                    for(int j=0;j<3;j++){
                        Botoes1[i][j].setIcon(null);
                        Botoes2[i][j].setIcon(null);
                    }
                }
                flag=1;
            }
        }
    }
}
