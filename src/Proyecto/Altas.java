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

    

    public class Altas extends javax.swing.JFrame implements java.io.Serializable, ActionListener{
        
    JTextField Nombre, Clave, Costo, Cantidad ;
    JLabel Titulo, Nombresillo, Clavesilla, Costillo, Cantidadilla, superior, inferior, Textito;
    JButton Agrega, Regresar;
      JLabel foto;                    ImageIcon iconoo, abarrotes;
       JLabel LogoAb;
    public Altas(){
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(150, 10, 1000, 700);
        setTitle("Altas");
        this.setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        Image icon = new ImageIcon(getClass().getResource("/imagenes/LOFODEV.png")).getImage();
        setIconImage(icon);
        
        foto = new JLabel();
        foto.setBounds(200, 10, 600, 80);
        add(foto);
          
        
        Textito = new JLabel("Ingrese datos");
        Textito.setFont(new java.awt.Font("Segoe UI", 1, 18));
        Textito.setBounds(440, 120, 150, 60);
        add(Textito);       
                

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
        
        
        
        Nombre = new JTextField();
        Nombre.setBounds(250, 200, 180, 40);
        add(Nombre);
        
        Nombresillo = new JLabel("Nombre");
        Nombresillo.setBounds(175, 200, 180, 40);
        add(Nombresillo);
        
        Clave = new JTextField();
        Clave.setBounds(250, 300, 180, 40);
        add(Clave);
        
        Clavesilla = new JLabel("Clave");
        Clavesilla.setBounds(175, 300, 180, 40);
        add(Clavesilla);
        
        Costo = new JTextField();
        Costo.setBounds(250, 400, 180, 40);
        add(Costo);
        
        Costillo = new JLabel("Costo          $ ");
        Costillo.setBounds(175, 400, 180, 40);
        add(Costillo);
        setVisible(true);
        
        Cantidad = new JTextField();
        Cantidad.setBounds(250, 500, 180, 40);
        add(Cantidad);
        
        Cantidadilla = new JLabel("Cantidad");
        Cantidadilla.setBounds(175, 500, 180, 40);
        add(Cantidadilla);
        
        
        Agrega = new JButton("Añadir");
        Agrega.setBounds(500, 570, 100, 40);
        Agrega.addActionListener(this);
        this.Agrega.setBackground(new java.awt.Color(50, 205, 50));
        this.Agrega.setOpaque(true);
        add(Agrega);
        
        Regresar = new JButton("Regresar");
        Regresar.setBounds(870, 570, 100, 30);
        Regresar.addActionListener(this);
        this.Regresar.setBackground(new java.awt.Color(50, 205, 50));
        this.Regresar.setOpaque(true);
        add(Regresar);
        
        setVisible(true);
      superior = new JLabel();
    }
        
        
    @Override
    public void actionPerformed(ActionEvent e) {
        String cadenita = e.getActionCommand();
        datos datito = new datos();
        if(cadenita.equals("Añadir")){
                    
        
        datito.setNombre(Nombre.getText());
        datito.setClave(Integer.parseInt(Clave.getText()));
        datito.setCosto(Integer.parseInt(Costo.getText()));
        datito.setCantidad(Integer.parseInt(Cantidad.getText()));
        
        ArrayList<datos> listita = new ArrayList();
        Conecta conectadito= new Conecta();
        listita = conectadito.conectar();        
        listita.add(datito);
        conectadito.grabar(listita);
        
        Clave.setText("");
        Clave.setEnabled(true);
        
        Nombre.setText("");
        Nombre.setEnabled(true);
        
        Costo.setText("");
        Costo.setEnabled(true);
        
        Cantidad.setText("");
        Cantidad.setEnabled(true);
        JOptionPane.showMessageDialog(this, "Agregado");

        }
        
        if(cadenita.equals("Regresar")){
        dispose();
        Princi alt = new Princi();
        }
    }
    
}
    
