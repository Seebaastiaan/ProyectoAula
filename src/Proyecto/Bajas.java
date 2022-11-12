package Proyecto;




import java.awt.Color;
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


public class Bajas extends JFrame implements ActionListener{

    JLabel superior, inferior;
    JTextField Ingresa, Cantidad, Nombre, Precio;
    JLabel Clavesilla, Textito, Cantidadilla, Nombresillo, Precillo ;
    JButton bajar, regresar;
      JLabel foto;                    ImageIcon iconoo;
    
    public Bajas (){
    
    setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(150, 10, 1000, 700);
        setTitle("Bajas");
        this.setResizable(false);
        setLocationRelativeTo(null);
        Image icon = new ImageIcon(getClass().getResource("/imagenes/LOFODEV.png")).getImage();
        setIconImage(icon);
        setLayout(null);

        foto = new JLabel();
        foto.setBounds(200, 10, 600, 80);
        add(foto);
        
        iconoo = new ImageIcon(getClass().getResource("/imagenes/LogoBarrita.png"));
        Image img2 = iconoo.getImage();
        Image newimg2 = img2.getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newimg2);
        foto.setIcon(newIcon);       
        
        Textito = new JLabel("Bajas");
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
        
        bajar = new JButton("Encontrar");
        bajar.setBounds(450, 450, 100, 50);
        bajar.setBackground(new java.awt.Color(50, 205, 50));
        bajar.setOpaque(true);
        bajar.addActionListener(this);
        add(bajar);
        
        regresar = new JButton("Regresar");
        regresar.setBounds(870, 570, 100, 30);
        regresar.addActionListener(this);
        this.regresar.setBackground(new java.awt.Color(50, 205, 50));
        this.regresar.setOpaque(true);
        add(regresar);
        
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
        
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String cadenita = e.getActionCommand();
        Ingresa.requestFocus();
        
        if (cadenita.equals("Encontrar")) {
                    ArrayList<datos> listita = new ArrayList();
                    Conecta conectito = new Conecta();
                    listita = conectito.conectar();
                    int cuantos = listita.size();
                    int banderita =0;
                    for (int i = 0; i < cuantos; i++) {
                    if(Integer.parseInt(Ingresa.getText()) == listita.get(i).getClave()){
                    Ingresa.setVisible(false);
                    Clavesilla.setVisible(false);
                    Nombre.setVisible(true);
                    Nombre.setText(listita.get(i).getNombre());
                    Cantidad.setVisible(true);
                    Cantidad.setText("" + listita.get(i).getCantidad());
                    Precio.setVisible(true);
                    Precio.setText("" + listita.get(i).getCosto());
                    int opcion = JOptionPane.showConfirmDialog(this, "Desea borrar el Producto?", "Seleccione la opcion", JOptionPane.YES_NO_OPTION);
                    Nombre.setEditable(false);
                    Cantidad.setEditable(false);
                    Precio.setEditable(false);
                    bajar.setVisible(false);
                    if(opcion ==0){
                    listita.remove(i);
                    JOptionPane.showMessageDialog(null, "Producto eliminado"); 
                    conectito.grabar(listita);
                    dispose ();
                    Princi alt = new Princi();
                    }else
                    if(opcion==1){
                    JOptionPane.showMessageDialog(this, "No se borro");
                    dispose ();
                    Princi alt = new Princi();
                    }
                                        
                    banderita =1;
                    break;                       
                    }
                    else 
                        JOptionPane.showMessageDialog(this, "El producto no existe");
                        dispose ();
                        Princi alt = new Princi();
                        break;
                    }
        }
        else
            if (cadenita.equals("Regresar")) {
                dispose();
                Princi alt = new Princi();
                
        }

    }
}


