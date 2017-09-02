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



public class TelaPrincipal extends JFrame {
    ImageIcon fundo;
    
    
    private Matriz matriz1;
    private Matriz matriz2;
    
    private Valor valor1 = new Valor();
    private Valor valor2 = new Valor();
    
    private Panel painel;
    private JLabel label;
    private JButton BotaoAjuda;
    private JButton[][] Botoes1;
    private JButton[][] Botoes2;
    private int ramdon;
    private int Erros;
    private int flag=0;
    
    public TelaPrincipal(int quant,Matriz mat1,Matriz mat2,int fase ,int erros){
        super("Jogo Memoria");
        
        Random rand = new Random();
        Erros = erros;
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
        
        BotaoAjuda.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Clique em um botao azul ou vermelho,\n e tente encontrar a figura correspondente\n na outra cor");
            }
        });
        
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
    
    public void Alterar1(int posI,int posJ, JButton botao, Panel painel,int fase){
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
                    
                    TelaPrincipal tela = new TelaPrincipal(3,matr1,matr2,fase+1,Erros);
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
    
    public void Alterar2(int posI,int posJ, JButton botao, Panel painel,int fase){
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
                   
                    TelaPrincipal tela = new TelaPrincipal(3,matr1,matr2,fase+1,Erros);
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
        URL url = TelaPrincipal.class.getResource(nome+".wav");
        AudioClip audio = Applet.newAudioClip(url);
        audio.play();
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