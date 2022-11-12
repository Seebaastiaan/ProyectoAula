package Proyecto;



import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

    public class Princi extends JFrame implements java.io.Serializable, ActionListener {
    
    JButton Altas;  JButton Bajas;  JButton Consultas;
    JButton Cambios;                JButton Ventas;
    JLabel superior;                JLabel inferior;
    JLabel foto;                    ImageIcon iconoo;
    
    public Princi(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(150, 10, 1000, 700);
        setTitle("Menu Principal");
        setLayout(null);
        setLocationRelativeTo(null);
        Image icon = new ImageIcon(getClass().getResource("/imagenes/LOFODEV.png")).getImage();
        setIconImage(icon);

        foto = new JLabel();
        foto.setBounds(200, 10, 600, 80);
        add(foto);
        
        iconoo = new ImageIcon(getClass().getResource("/imagenes/LogoBarrita.png"));
        Image img2 = iconoo.getImage();
        Image newimg2 = img2.getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newimg2);
        foto.setIcon(newIcon);
        
        superior = new JLabel();
        superior.setBounds(0, 0, 1000, 100);
        this.superior.setBackground(new java.awt.Color(32, 67, 38));
        this.superior.setOpaque(true);
        add(superior);
        
        
        inferior = new JLabel();
        inferior.setBounds(0, 620, 1000, 50);
        this.inferior.setBackground(new java.awt.Color(78, 197, 127));
        this.inferior.setOpaque(true);
        add(inferior);
        
        Altas = new JButton("Altas");
        Altas.setBounds(100, 380, 100, 40);
        Altas.addActionListener(this);
        this.Altas.setBackground(new java.awt.Color(50, 205, 50));
        this.Altas.setOpaque(true);
        add(Altas);
        
        Bajas = new JButton("Bajas");
        Bajas.setBounds(330, 380, 100, 40);
        Bajas.addActionListener(this);
        this.Bajas.setBackground(new java.awt.Color(50, 205, 50));
        this.Bajas.setOpaque(true);
        add(Bajas);
        
        Consultas = new JButton("Consultas");
        Consultas.setBounds(560, 380, 100, 40);
        Consultas.addActionListener(this);
        this.Consultas.setBackground(new java.awt.Color(50, 205, 50));
        this.Consultas.setOpaque(true);
        add(Consultas);
        
        Cambios = new JButton("Cambios");
        Cambios.setBounds(790, 380, 100, 40);
        Cambios.addActionListener(this);
        this.Cambios.setBackground(new java.awt.Color(50, 205, 50));
        this.Cambios.setOpaque(true);
        add(Cambios);
        
        Ventas = new JButton("Ventas");
        Ventas.setBounds(440, 470, 100, 40);
        Ventas.addActionListener(this);
        this.Ventas.setBackground(new java.awt.Color(50, 205, 50));
        this.Ventas.setOpaque(true);
        add(Ventas);
        
        this.setResizable(false);
        
        setVisible(true);
        

    }
    

    
    @Override
    public void actionPerformed(ActionEvent e) {
            String cadb = e.getActionCommand();
        if(cadb.equals("Altas")){
        dispose();
         
        Altas alt = new Altas (); 
    }
        else
            if(cadb.equals("Consultas")){
            dispose();
                Consultas alt = new Consultas();
            }
            else
                if(cadb.equals("Cambios")){
                
                dispose();
                Cambios alt = new Cambios();
                }
                else
                    if(cadb.equals("Bajas")){
                    dispose();
                    Bajas alt = new Bajas();
                    
                    }
         else
                    if(cadb.equals("Ventas")){
                    dispose();
                    Ventas alt = new Ventas();
                    
                    }
        
  }
}
