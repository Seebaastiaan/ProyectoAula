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

public class Ventas extends JFrame implements java.io.Serializable, ActionListener{ 

    private int posicion = 0, totalV = 0,  banderita = 0, nCant=0;
    JTextField Clave, cantidad, nomb, cost, cant;
    JLabel  total, titulo, superior, inferior, txtNomb, txtCant, txtTot;
    JButton vender, menu, añadir, mas;
      JLabel foto;                    ImageIcon iconoo, abarrotes;
       JLabel LogoAb;
    public Ventas(){
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(150, 10, 1000, 700);
        setTitle("Ventas");
        this.setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        Image icon = new ImageIcon(getClass().getResource("/imagenes/LOFODEV.png")).getImage();
        setIconImage(icon);
        foto = new JLabel();
        foto.setBounds(200, 10, 600, 80);
        add(foto);
        
        titulo = new JLabel("Ventas");
        titulo.setFont(new java.awt.Font("Segoe UI", 1, 18));
        titulo.setBounds(440, 120, 150, 60);
        add(titulo);       
                
                
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
        
        txtNomb = new JLabel("Clave:");
        txtNomb.setBounds(350, 200, 40, 40);
        add(txtNomb);
        
        
        txtCant = new JLabel("Cantidad:");
        txtCant.setBounds(700, 275, 180, 40);
        add(txtCant);
        
        
        txtTot = new JLabel("Total:");
        txtTot.setBounds(720, 425, 180, 40);
        add(txtTot);
        
        Clave = new JTextField();
        Clave.setBounds(400, 200, 200, 40);
        add(Clave);
        
        cantidad = new JTextField();
        cantidad.setBounds(775, 275, 100, 40);        
        cantidad.setEnabled(false);
        add(cantidad);

        total = new JLabel();
        total.setBounds(775, 425, 100, 40);
        add(total);
        
        nomb = new JTextField();
        nomb.setBounds(300, 400, 100, 40);
        add(nomb);
        
        cost = new JTextField();
        cost.setBounds(425, 400, 100, 40);
        add(cost);
        
        cant = new JTextField();
        cant.setBounds(550, 400, 100, 40);
        add(cant);
        
        añadir = new JButton("Añadir");
        añadir.setBounds(445, 250, 100, 40);
        añadir.addActionListener(this);
        this.añadir.setBackground(new java.awt.Color(50, 205, 50 ));
        this.añadir.setOpaque(true);
        add(añadir);
        
        vender = new JButton("Vender");
        vender.setBounds(750, 350, 100, 40);
        vender.addActionListener(this);
        this.vender.setBackground(new java.awt.Color(50, 205, 50 ));
        this.vender.setOpaque(true);
        add(vender);
        
        menu = new JButton("Menu");
        menu.setBounds(750, 475, 100, 40);
        menu.addActionListener(this);
        this.menu.setBackground(new java.awt.Color(50, 205, 50 ));
        this.menu.setOpaque(true);
        add(menu);
        
        mas = new JButton("Carrito");
        mas.setBounds(350, 450, 100, 40);
        mas.addActionListener(this);
        this.mas.setBackground(new java.awt.Color(50, 205, 50 ));
        this.mas.setOpaque(true);
        add(mas);
        mas.setVisible(false);
        
        
        setVisible(true);
}
    @Override
    public void actionPerformed(ActionEvent e) {
        String cadenita = e.getActionCommand();
        
        
        if(cadenita.equals("Añadir")){
           
            ArrayList<datos> listita = new ArrayList();
            Conecta conectadito = new Conecta();
            listita = conectadito.conectar();
            
            
            cantidad.setEnabled(true);
            

            
            int cuantos = listita.size();
            
            
            
            for (int i = 0; i < cuantos; i++) {
                
                String buscado = Clave.getText();
                if(Integer.parseInt(Clave.getText())==listita.get(i).getClave() ){
                    nomb.setText(listita.get(i).getNombre());
                    cant.setText(""+listita.get(i).getCantidad());
                    cost.setText("$"+listita.get(i).getCosto());
                    banderita = 1;
                    posicion = i;
                   
                    break;
                    
                }
            }
                if (banderita==0){
                    JOptionPane.showMessageDialog(this, "No existe el prodcuto");  
                
                Clave.setText("");
                nomb.setText("");
                cant.setText("");
                cost.setText("");
                }
  


        }
      
        
        if(cadenita.equals("Vender" )&& banderita ==1){
            
            
             ArrayList<datos> listita = new ArrayList();
            Conecta conectito = new Conecta();
            listita = conectito.conectar();
            totalV = totalV + (Integer.parseInt(cantidad.getText()) * listita.get(posicion).getCosto());
            total.setText("$"+Integer.toString(totalV));
            nCant = (listita.get(posicion).getCantidad()) - Integer.parseInt(cantidad.getText());
            
                    Conecta conectadito = new Conecta();
                    datos datito= new datos();
                    listita = conectadito.conectar();
                  
                    listita.get(posicion).setCantidad(nCant);
                    
                    conectadito.grabar(listita);
                    JOptionPane.showMessageDialog(this, "Producto vendido");
                    
                    Clave.setText("");
                    cantidad.setText("");
                    cost.setText("");
                    nomb.setText("");
                    cant.setText("");
            
            
            vender.setVisible(true);
            
            cantidad.setText("");       

    }
                   
        if(cadenita.equals("Menu")){
            dispose();
            Princi alt = new Princi();
        }
        
            if(cadenita.equals("Mas?")){

                    
        }
    }

    
}   
