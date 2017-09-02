
package Telas;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Vitoria extends JFrame {
    ImageIcon img;
    
    private Panel painel;
    
    public Vitoria(){
        super("Creditos");
        img = new ImageIcon(System.getProperty("user.dir")+("\\src\\Telas")+("\\Imagens\\Creditos.png"));
        painel = new Panel();
        
        this.add(painel);
        painel.setLayout(null);
        
        this.setBounds(100, 100, 520, 560);
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
}
