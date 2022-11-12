
package Proyecto;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Login  extends JFrame implements java.io.Serializable, ActionListener{
    JPasswordField contraa;         JButton NuevoUs;
    JTextField Usuario;             JTextField passver;
    JButton Ingresr;                JLabel foto;   
    JLabel superior;                JLabel inferior;
    JLabel Usuariotex;              JLabel Contratex;
    ImageIcon iconoo, abarrotes;    JLabel LogoAb;
    JLabel altas;                   JButton verpass;
    JButton Aceptar;                JTextField NewUs;
    JPasswordField newPass;             
    
  
    public Login(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(150, 10, 1000, 700);
        setTitle("Inicio de Sesion");
        setLayout(null);
        setLocationRelativeTo(null);
        Image icon = new ImageIcon(getClass().getResource("/imagenes/LOFODEV.png")).getImage();
        setIconImage(icon);
        setResizable(false);
    
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
        
        LogoAb  =new JLabel();
        LogoAb.setBounds(290, 50, 400, 300);
        add(LogoAb);
        
        abarrotes = new ImageIcon(getClass().getResource("/imagenes/Abarrotes.png"));
        Image aba2 = abarrotes.getImage();
        Image newaba2 = aba2.getScaledInstance(LogoAb.getWidth(), LogoAb.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newIcono = new ImageIcon(newaba2);
        LogoAb.setIcon(newIcono);
        
        Usuario = new JTextField();
        Usuario.setBounds(380, 350, 250, 40);
        add(Usuario);
        
        NewUs = new JTextField("kike");
        NewUs.setBounds(380, 350, 250, 40);
        add(NewUs);
        NewUs.setVisible(false);
        
        contraa = new JPasswordField();
        contraa.setBounds(380, 400, 250, 40);
        add(contraa);
        
        newPass = new JPasswordField("kike2");
        newPass.setBounds(380, 400, 250, 40);
        add(newPass);
        newPass.setVisible(false);
        
        
        passver = new JTextField();
        passver.setBounds(380, 400, 250, 40);
        add(passver);
        
        
        inferior = new JLabel();
        inferior.setBounds(0, 620, 1000, 50);
        this.inferior.setBackground(new java.awt.Color(78, 197, 127));
        this.inferior.setOpaque(true);
        add(inferior);
        
        verpass = new JButton("Ver");
        verpass.setBounds(650, 404, 60, 30);
        verpass.setFocusPainted(false);
        verpass.setBorderPainted(false);
        verpass.setContentAreaFilled(false);
        verpass.addActionListener(this);
        add(verpass);
        
        iconoo = new ImageIcon(getClass().getResource("/imagenes/ojocontra.png"));
        Image img3 = iconoo.getImage();
        Image newimg3 = img3.getScaledInstance(55, 30, Image.SCALE_REPLICATE);
        ImageIcon newIcooon = new ImageIcon(newimg3);
        verpass.setIcon(newIcooon);    
        
        Ingresr = new JButton("Ingresar");
        Ingresr.setBounds(359, 480, 120, 50);
        Ingresr.addActionListener(this);
        this.Ingresr.setBackground(new java.awt.Color(50, 205, 50));
        this.Ingresr.setOpaque(true);
        add(Ingresr);
        
        Aceptar = new JButton("Aceptar");
        Aceptar.setBounds(450, 480, 120, 50);
        Aceptar.addActionListener(this);
        this.Aceptar.setBackground(new java.awt.Color(50, 205, 50));
        this.Aceptar.setOpaque(true);
        add(Aceptar);
        Aceptar.setVisible(false);
        
        NuevoUs = new JButton("Nuevo Usuario");
        NuevoUs.setBounds(519, 480, 120, 50);
        NuevoUs.addActionListener(this);
        this.NuevoUs.setBackground(new java.awt.Color(50, 205, 50));
        this.NuevoUs.setOpaque(true);
        add(NuevoUs);
        
        Usuariotex = new JLabel("Usuario:");
        Usuariotex.setBounds(320, 325, 80, 90);
        add(Usuariotex);
        
        Contratex = new JLabel("Constraseña:");
        Contratex.setBounds(293, 375, 80, 90);
        add(Contratex);
        
        setVisible(true);
    
    
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
           String cadenita = e.getActionCommand();
           if(cadenita.equals("Ver")){
               passver.setText(contraa.getText());    
               passver.setVisible(true);
               passver.setEditable(true);
               contraa.setVisible(false);
               verpass.setText("Ocultar");
           }
           else
               if(cadenita.equals("Ocultar")){
               passver.setVisible(false);
               verpass.setText("Ver");
               contraa.setVisible(true);
               contraa.setText(passver.getText());
               }
           if(cadenita.equals("Nuevo Usuario")){
           Ingresr.setVisible(false);
           NuevoUs.setVisible(false);
           Aceptar.setVisible(true);
           contraa.setText("");
           Usuario.setText("");
               
                    
                    }
           
           }
           
    }
        
