
package Proyecto;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
           else if(cadenita.equals("Ocultar")){
               passver.setVisible(false);
               verpass.setText("Ver");
               contraa.setVisible(true);
               contraa.setText(passver.getText());
           }
           else if(cadenita.equals("Nuevo Usuario")){
               Ingresr.setVisible(false);
               NuevoUs.setVisible(false);
               Aceptar.setVisible(true);
               contraa.setText("");
               Usuario.setText("");
               NewUs.setVisible(true);
               newPass.setVisible(true);
               Usuario.setVisible(false);
               contraa.setVisible(false);
               passver.setVisible(false);
           }
           else if(cadenita.equals("Aceptar")){
               // Crear nuevo usuario
               String nuevoUsuario = NewUs.getText().trim();
               String nuevaContra = newPass.getText().trim();
               
               if(nuevoUsuario.isEmpty() || nuevaContra.isEmpty()){
                   JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                   return;
               }
               
               // Conectar a la base de datos
               Conecta conexion = new Conecta();
               ArrayList<datos> lista = conexion.conectar();
               
               // Verificar si el usuario ya existe
               boolean existe = false;
               for(datos d : lista){
                   if(d.getUsuario() != null && d.getUsuario().equals(nuevoUsuario)){
                       existe = true;
                       break;
                   }
               }
               
               if(existe){
                   JOptionPane.showMessageDialog(this, "El usuario ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                   return;
               }
               
               // Crear nuevo objeto datos con el usuario y contraseña
               datos nuevoRegistro = new datos();
               nuevoRegistro.setUsuario(nuevoUsuario);
               nuevoRegistro.setContraseña(nuevaContra);
               
               // Agregar a la lista y grabar
               lista.add(nuevoRegistro);
               conexion.grabar(lista);
               
               JOptionPane.showMessageDialog(this, "Usuario creado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
               
               // Restablecer la vista de login
               NewUs.setVisible(false);
               newPass.setVisible(false);
               Usuario.setVisible(true);
               contraa.setVisible(true);
               Ingresr.setVisible(true);
               NuevoUs.setVisible(true);
               Aceptar.setVisible(false);
               NewUs.setText("");
               newPass.setText("");
           }
           else if(cadenita.equals("Ingresar")){
               // Validar credenciales
               String usuario = Usuario.getText().trim();
               String contra = contraa.getText().trim();
               
               if(usuario.isEmpty() || contra.isEmpty()){
                   JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                   return;
               }
               
               Conecta conexion = new Conecta();
               ArrayList<datos> lista = conexion.conectar();
               
               boolean encontrado = false;
               for(datos d : lista){
                   if(d.getUsuario() != null && d.getUsuario().equals(usuario) && 
                      d.getContraseña() != null && d.getContraseña().equals(contra)){
                       encontrado = true;
                       break;
                   }
               }
               
               if(encontrado){
                   JOptionPane.showMessageDialog(this, "Bienvenido " + usuario, "Login Exitoso", JOptionPane.INFORMATION_MESSAGE);
                   // Aquí puedes abrir la ventana principal
                   this.dispose();
                   new Princi();
               } else {
                   JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
               }
           }
    }
}
        
