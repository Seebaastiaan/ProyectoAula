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
import javax.swing.JTextField;


public class Consultas extends JFrame implements java.io.Serializable, ActionListener{
    JTextField Nombre, Clave, Cantidad, Precio, Ingresa;    
    JLabel Nombresillo, Clavesilla, Cantidadilla, Precillo, Textito, superior, inferior;
    JButton Ingresar, Regresar, Regresarte;
      JLabel foto;                    ImageIcon iconoo;
      
    public Consultas(){
    setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(150, 10, 1000, 700);
        setTitle("Consultas");
        this.setResizable(false);
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
        
        Textito = new JLabel("CONSULTAS");
        Textito.setFont(new java.awt.Font("Segoe UI", 1, 28));
        Textito.setBounds(440, 120, 200, 60);
        add(Textito);
        
        inferior = new JLabel();
        inferior.setBounds(0, 620, 1000, 50);
        this.inferior.setBackground(new java.awt.Color(78, 197, 127));
        this.inferior.setOpaque(true);
        add(inferior);
        
        superior = new JLabel();
        superior.setBounds(0, 0, 1000, 100);
        this.superior.setBackground(new java.awt.Color(32, 67, 38));
        this.superior.setOpaque(true);
        add(superior);
        
        Ingresa = new JTextField();
        Ingresa.setBounds(400, 250, 230, 40);
        
        add(Ingresa);
        
        Clavesilla = new JLabel("Clave del producto: ");
        Clavesilla.setBounds(275, 250, 180, 40);
        add(Clavesilla);
        
        Ingresar = new JButton("Ingresa");
        Ingresar.setBounds(450, 350, 100, 40);
        this.Ingresar.setBackground(new java.awt.Color(50, 205, 50));
        this.Ingresar.setOpaque(true);
        Ingresar.addActionListener(this);
        add(Ingresar);
        
        Regresar = new JButton("Regresar");
        Regresar.setBounds(870, 570, 100, 30);
        Regresar.addActionListener(this);
        this.Regresar.setBackground(new java.awt.Color(50, 205, 50));
        this.Regresar.setOpaque(true);
        add(Regresar);
        setVisible(true);  
        
        Regresarte = new JButton("Volver");
        Regresarte.setBounds(700, 570, 100, 30);
        Regresarte.addActionListener(this);
        this.Regresarte.setBackground(new java.awt.Color(50, 205, 50));
        this.Regresarte.setOpaque(true);
        add(Regresarte);
        Regresarte.setVisible(false);
        
        Cantidadilla = new JLabel("Cantidad de producto");
        Cantidadilla.setFont(new java.awt.Font("Segoe UI", 1, 18));
        Cantidadilla.setBounds(200, 200, 250, 40);
        add(Cantidadilla);  
        Cantidadilla.setVisible(false);
        
        Nombresillo = new JLabel("Nombre de producto");
        Nombresillo.setFont(new java.awt.Font("Segoe UI", 1, 18));
        Nombresillo.setBounds(200, 300, 250, 40);
        add(Nombresillo);
        Nombresillo.setVisible(false);
        
        Precillo = new JLabel("Precio del producto");
        Precillo.setFont(new java.awt.Font("Segoe UI", 1, 18));
        Precillo.setBounds(200, 400, 250, 40);
        add(Precillo);
        Precillo.setVisible(false);
        
        Cantidad = new JTextField();
        Cantidad.setBounds(400, 200, 200, 50);
        add(Cantidad);
        Cantidad.setVisible(false);
        
        Nombre = new JTextField();
        Nombre.setBounds(400, 300, 200, 50);
        add(Nombre);
        Nombre.setVisible(false);
        
        Precio = new JTextField();
        Precio.setBounds(400, 400, 200, 50);
        add(Precio);
        Precio.setVisible(false);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String cadenita = e.getActionCommand();
        if(cadenita.equals("Ingresa")){
            Ingresa.setVisible(false);
            Clavesilla.setVisible(false);
            Ingresar.setVisible(false);
            Cantidadilla.setVisible(true);
            Nombresillo.setVisible(true);
            Precillo.setVisible(true);
            Cantidad.setVisible(true);
            Nombre.setVisible(true);
            Precio.setVisible(true);
            Regresarte.setVisible(true);
            Regresar.setVisible(true);
            
                ArrayList<datos> listita = new ArrayList();
                Conecta conectadito= new Conecta();
                listita = conectadito.conectar();        
                int cuantos = listita.size();
                int banderita = 0;
                
                    for (int i = 0; i < cuantos; i++) {
                    if(Integer.parseInt(Ingresa.getText()) == listita.get(i).getClave()){
                    Nombre.setText(listita.get(i).getNombre());
                    Cantidad.setText("" + listita.get(i).getCantidad());
                    Precio.setText("" + listita.get(i).getCosto());
                    JOptionPane.showMessageDialog(this, "Este es el objeto");
                    Nombre.setEditable(false);
                    Cantidad.setEditable(false);
                    Precio.setEditable(false);
                    Regresar.setText("Menu");
                    banderita = 1;
                    break;
                    
                    }
                    
                }
                    if(banderita == 0){
                    JOptionPane.showMessageDialog(this, "No existe el objeto");
                    
                    Ingresa.setVisible(true);
                    Clavesilla.setVisible(true);
                    Ingresar.setVisible(true);
                    
                    Cantidadilla.setVisible(false);
                    Nombresillo.setVisible(false);
                    Precillo.setVisible(false);
                    Cantidad.setVisible(false);
                    Nombre.setVisible(false);
                    Precio.setVisible(false);
                    Regresarte.setVisible(false);
                    Regresar.setVisible(false);
                    Ingresa.setText("");

                    }
                  

              
    }
        
       else
            if(cadenita.equals(("Volver"))){
                
            Ingresa.setVisible(true);
            Clavesilla.setVisible(true);
            Ingresar.setVisible(true);
            Cantidadilla.setVisible(false);
            Nombresillo.setVisible(false);
            Precillo.setVisible(false);
            Cantidad.setVisible(false);
            Nombre.setVisible(false);
            Precio.setVisible(false);
            Regresarte.setVisible(false);
            Regresar.setVisible(true);
            Ingresa.setText("");
            Nombre.setText("");
            Cantidad.setText("");
            Precio.setText("");
            Regresar.setText("Regresar");
            }
        else
                if(cadenita.equals("Regresar")){
                dispose();
                Princi alt = new Princi();
                }
        else
                if(cadenita.equals("Menu")){
                dispose();
                Princi alt = new Princi();
                }
}
}
