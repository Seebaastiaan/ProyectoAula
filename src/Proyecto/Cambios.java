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

public class Cambios extends javax.swing.JFrame implements java.io.Serializable, ActionListener{
    JTextField Clave, Cantidad, Nombre, Precio, Cambiar;
    JLabel superior, inferior, titulo, tituprodu, titunom, titupre, pregunta, nuevo, clavz;
    JButton Ingresar, RegresarMenu, nCantidad, nNombre, nPrecio, nCambiar;
    int lugar = 0, pos = 0;;
      JLabel foto;                    ImageIcon iconoo, abarrotes;
       JLabel LogoAb;
      
    public Cambios(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(150, 10, 1000, 700);
        setTitle("Cambios");
        this.setResizable(false);
        setLocationRelativeTo(null);
        Image icon = new ImageIcon(getClass().getResource("/imagenes/LOFODEV.png")).getImage();
        setIconImage(icon);

        setLayout(null);
        foto = new JLabel();
        foto.setBounds(200, 10, 600, 80);
        add(foto);
        
        
        superior = new JLabel();
        superior.setBounds(0, 0, 1000, 100);
        this.superior.setBackground(new java.awt.Color(32, 67, 38));
        this.superior.setOpaque(true);
        add(superior);
        
        LogoAb  =new JLabel();
        LogoAb.setBounds(75, 100, 200, 150);
        add(LogoAb);
        
        abarrotes = new ImageIcon(getClass().getResource("/imagenes/Abarrotes.png"));
        Image aba2 = abarrotes.getImage();
        Image newaba2 = aba2.getScaledInstance(LogoAb.getWidth(), LogoAb.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newIcono = new ImageIcon(newaba2);
        LogoAb.setIcon(newIcono);
        
        inferior = new JLabel();
        inferior.setBounds(0, 620, 1000, 50);
        this.inferior.setBackground(new java.awt.Color(78, 197, 127));
        this.inferior.setOpaque(true);
        add(inferior);
        
        titulo = new JLabel("CAMBIOS");
        titulo.setBounds(440, 120, 200, 60);
        titulo.setFont(new java.awt.Font("Segoe UI", 1, 28));
        add(titulo);
        
        clavz = new JLabel("Ingrese una clave");
        clavz.setBounds(250, 230, 190, 80);
        add(clavz);
        
        Clave = new JTextField();
        Clave.setBounds(400, 250, 230, 40);
        add(Clave);
        
        Ingresar = new JButton("Ingresar");
        Ingresar.setBounds(450, 350, 100, 40);
        this.Ingresar.setBackground(new java.awt.Color(50, 205, 50));
        this.Ingresar.setOpaque(true);
        Ingresar.addActionListener(this);
        add(Ingresar);
        
        RegresarMenu = new JButton("Regresar");
        RegresarMenu.setBounds(870, 570, 100, 30);
        this.RegresarMenu.setBackground(new java.awt.Color(50, 205, 50));
        this.RegresarMenu.setOpaque(true);
        RegresarMenu.addActionListener(this);
        add(RegresarMenu);
        
        tituprodu = new JLabel("Cantidad de producto");
        tituprodu.setFont(new java.awt.Font("Segoe UI", 1, 18));
        tituprodu.setBounds(200, 200, 250, 40);
        add(tituprodu);
        tituprodu.setVisible(false);
        
        titunom = new JLabel("Nombre del producto");
        titunom.setFont(new java.awt.Font("Segoe UI", 1, 18));
        titunom.setBounds(200, 300, 250, 40);
        add(titunom);
        titunom.setVisible(false);
        
        titupre = new JLabel("Precio del producto");
        titupre.setFont(new java.awt.Font("Segoe UI", 1, 18));
        titupre.setBounds(200, 400, 250, 40);
        add(titupre);
        titupre.setVisible(false);
        
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
        
        pregunta = new JLabel("¿Que desea cambiar?");
        pregunta.setFont(new java.awt.Font("Segoe UI", 1, 18));
        pregunta.setBounds(420, 480, 250, 40);
        add(pregunta);
        pregunta.setVisible(false);
        
        nCantidad = new JButton("Cantidad");
        nCantidad.setBounds(230, 550, 100, 40);
        this.nCantidad.setBackground(new java.awt.Color(50, 205, 50));
        this.nCantidad.setOpaque(true);
        nCantidad.addActionListener(this);
        add(nCantidad);
        nCantidad.setVisible(false);
        
        nNombre = new JButton("Nombre");
        nNombre.setBounds(410, 550, 100, 40);
        this.nNombre.setBackground(new java.awt.Color(50, 205, 50));
        this.nNombre.setOpaque(true);
        nNombre.addActionListener(this);
        add(nNombre);
        nNombre.setVisible(false);
        
        nPrecio = new JButton("Precio");
        nPrecio.setBounds(590, 550, 100, 40);
        this.nPrecio.setBackground(new java.awt.Color(50, 205, 50));
        this.nPrecio.setOpaque(true);
        nPrecio.addActionListener(this);
        add(nPrecio);
        nPrecio.setVisible(false);
        
        nuevo = new JLabel();
        nuevo.setFont(new java.awt.Font("Segoe UI", 1, 18));
        nuevo.setBounds(220, 350, 250, 40);
        add(nuevo);
        nuevo.setVisible(false);
        
        Cambiar = new JTextField();
        Cambiar.setBounds(430, 350, 230, 40);
        add(Cambiar);
        Cambiar.setVisible(false);
        
        nCambiar = new JButton("Cambiar");
        nCambiar.setBounds(400, 450, 150, 40);
        this.nCambiar.setBackground(new java.awt.Color(50, 205, 50));
        this.nCambiar.setOpaque(true);
        nCambiar.addActionListener(this);
        add(nCambiar);
        nCambiar.setVisible(false);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cadenita = e.getActionCommand();
        if (cadenita.equals("Ingresar")) {
            Clave.setVisible(false);
            clavz.setVisible(false);
            Ingresar.setVisible(false);
            tituprodu.setVisible(true);
            titunom.setVisible(true);
            titupre.setVisible(true);
            pregunta.setVisible(true);
            Cantidad.setVisible(true);
            Nombre.setVisible(true);
            Precio.setVisible(true);
            nCantidad.setVisible(true);
            nNombre.setVisible(true);
            nPrecio.setVisible(true);
            
            ArrayList<datos> listita = new ArrayList();
            Conecta conectadito = new Conecta();
            listita = conectadito.conectar();
            int cuantos = listita.size();
            int banderita = 0;
         
            
            for (int i = 0; i < cuantos; i++) {
                if (Integer.parseInt(Clave.getText()) == listita.get(i).getClave()) {
                    Nombre.setText(listita.get(i).getNombre());
                    Cantidad.setText("" + listita.get(i).getCantidad());
                    Precio.setText("" + listita.get(i).getCosto());
                    JOptionPane.showMessageDialog(this, "Este es el objeto");
                    Nombre.setEditable(false);
                    Cantidad.setEditable(false);
                    Precio.setEditable(false);
                    banderita = 1;
                    pos = i;
                    break;
                }
            }
            if (banderita == 0) {
                JOptionPane.showMessageDialog(this, "No existe el objeto");
                Clave.setText("");
                Nombre.setText("");
                Precio.setText("");
                Cantidad.setText("");
                Clave.setVisible(true);
                Nombre.setVisible(false);
                Precio.setVisible(false);
                Cantidad.setVisible(false);
                tituprodu.setVisible(false);
                titunom.setVisible(false);
                titupre.setVisible(false);
                pregunta.setVisible(false);
                Ingresar.setVisible(true);
                RegresarMenu.setVisible(true);
                nCantidad.setVisible(false);
                nNombre.setVisible(false);
                nPrecio.setVisible(false);
                nCambiar.setVisible(false);
                nuevo.setVisible(false);
                Cambiar.setVisible(false);       
            }   
        }
        else
            if (cadenita.equals("Cantidad")) {
                Clave.setVisible(false);
                clavz.setVisible(false);
                Nombre.setVisible(false);
                Precio.setVisible(false);
                Cantidad.setVisible(false);
                tituprodu.setVisible(false);
                titunom.setVisible(false);
                titupre.setVisible(false);
                pregunta.setVisible(false);
                Ingresar.setVisible(false);
                RegresarMenu.setVisible(false);
                nCantidad.setVisible(false);
                nNombre.setVisible(false);
                nPrecio.setVisible(false);
                nCambiar.setVisible(true);
                nuevo.setVisible(true);
                Cambiar.setText("");
                nuevo.setText("Nueva Cantidad");
                Cambiar.setVisible(true); 
                nCambiar.setText("Cambiar Cantidad");
            }
                if (cadenita.equals("Cambiar Cantidad")) {
                    ArrayList <datos> listita = new ArrayList();
                    Conecta conectadito = new Conecta();
                    datos datito= new datos();
                    listita = conectadito.conectar();
                    datito.setClave(Integer.parseInt(Clave.getText()));
                    datito.setCosto(Integer.parseInt(Precio.getText()));
                    datito.setCantidad(Integer.parseInt(Cambiar.getText()));
                    datito.setNombre(Nombre.getText());
                    listita.set(pos, datito);
                    conectadito.grabar(listita);
                    JOptionPane.showMessageDialog(this, "El producto se cambio");
                    Clave.setVisible(false);
                    clavz.setVisible(false);
                    Nombre.setVisible(true);
                    Precio.setVisible(true);
                    Cantidad.setVisible(true);
                    tituprodu.setVisible(true);
                    titunom.setVisible(true);
                    titupre.setVisible(true);
                    pregunta.setVisible(true);
                    Ingresar.setVisible(false);
                    RegresarMenu.setVisible(true);
                    nCantidad.setVisible(true);
                    nNombre.setVisible(true);
                    nPrecio.setVisible(true);
                    nCambiar.setVisible(false);
                    nuevo.setVisible(false);
                    Cambiar.setVisible(false);
                    Cantidad.setText("");
                    Cantidad.setText(Integer.toString(listita.get(pos).getCantidad()));
                }
                else
                    if (cadenita.equals("Nombre")) {
                        Clave.setVisible(false);
                        clavz.setVisible(false);
                        Nombre.setVisible(false);
                        Precio.setVisible(false);
                        Cantidad.setVisible(false);
                        tituprodu.setVisible(false);
                        titunom.setVisible(false);
                        titupre.setVisible(false);
                        pregunta.setVisible(false);
                        Ingresar.setVisible(false);
                        RegresarMenu.setVisible(false);
                        nCantidad.setVisible(false);
                        nNombre.setVisible(false);
                        nPrecio.setVisible(false);
                        nCambiar.setVisible(true);
                        nuevo.setVisible(true);
                        Cambiar.setText("");
                        nuevo.setText("Nuevo Nombre");
                        Cambiar.setVisible(true); 
                        nCambiar.setText("Cambiar Nombre");
                    }
                        if (cadenita.equals("Cambiar Nombre")) {
                            ArrayList <datos> listita = new ArrayList();
                            Conecta conectadito = new Conecta();
                            datos datito= new datos();
                            listita = conectadito.conectar();
                            datito.setClave(Integer.parseInt(Clave.getText()));
                            datito.setCantidad(Integer.parseInt(Cantidad.getText()));
                            datito.setCosto(Integer.parseInt(Precio.getText()));
                            datito.setNombre(Cambiar.getText());
                            listita.set(pos, datito);
                            conectadito.grabar(listita);
                            JOptionPane.showMessageDialog(this, "El producto se cambio");
                            Clave.setVisible(false);
                            clavz.setVisible(false);
                            Nombre.setVisible(true);
                            Precio.setVisible(true);
                            Cantidad.setVisible(true);
                            tituprodu.setVisible(true);
                            titunom.setVisible(true);
                            titupre.setVisible(true);
                            pregunta.setVisible(true);
                            Ingresar.setVisible(false);
                            RegresarMenu.setVisible(true);
                            nCantidad.setVisible(true);
                            nNombre.setVisible(true);
                            nPrecio.setVisible(true);
                            nCambiar.setVisible(false);
                            nuevo.setVisible(false);
                            Cambiar.setVisible(false);
                            Nombre.setText("");
                            Nombre.setText((listita.get(pos).getNombre()));                       
                        }
                        else
                            if (cadenita.equals("Precio")) {
                                Clave.setVisible(false);
                                clavz.setVisible(false);
                                Nombre.setVisible(false);
                                Precio.setVisible(false);
                                Cantidad.setVisible(false);
                                tituprodu.setVisible(false);
                                titunom.setVisible(false);
                                titupre.setVisible(false);
                                pregunta.setVisible(false);
                                Ingresar.setVisible(false);
                                RegresarMenu.setVisible(false);
                                nCantidad.setVisible(false);
                                nNombre.setVisible(false);
                                nPrecio.setVisible(false);
                                nCambiar.setVisible(true);
                                nuevo.setVisible(true);
                                Cambiar.setText("");
                                nuevo.setText("Nuevo Precio");
                                Cambiar.setVisible(true); 
                                nCambiar.setText("Cambiar Precio");
                            }
                                if (cadenita.equals("Cambiar Precio")) {
                                    ArrayList <datos> listita = new ArrayList();
                                    Conecta conectadito = new Conecta();
                                    datos datito= new datos();
                                    listita = conectadito.conectar();
                                    datito.setClave(Integer.parseInt(Clave.getText()));
                                    datito.setCantidad(Integer.parseInt(Cantidad.getText()));
                                    datito.setCosto(Integer.parseInt(Cambiar.getText()));
                                    datito.setNombre(Nombre.getText());
                                    listita.set(pos, datito);
                                    conectadito.grabar(listita);
                                    JOptionPane.showMessageDialog(this, "El producto se cambio");
                                    Clave.setVisible(false);
                                    clavz.setVisible(false);
                                    Nombre.setVisible(true);
                                    Precio.setVisible(true);
                                    Cantidad.setVisible(true);
                                    tituprodu.setVisible(true);
                                    titunom.setVisible(true);
                                    titupre.setVisible(true);
                                    pregunta.setVisible(true);
                                    Ingresar.setVisible(false);
                                    RegresarMenu.setVisible(true);
                                    nCantidad.setVisible(true);
                                    nNombre.setVisible(true);
                                    nPrecio.setVisible(true);
                                    nCambiar.setVisible(false);
                                    nuevo.setVisible(false);
                                    Cambiar.setVisible(false);
                                    Precio.setText("");
                                    Precio.setText(Integer.toString((listita.get(pos).getCosto())));  
                                }
                                else
                                    if (cadenita.equals("Regresar")) {
                                        dispose();
                                        Princi alt = new Princi();
                                    }
    }
}
