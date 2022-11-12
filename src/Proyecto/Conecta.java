package Proyecto;




import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Conecta implements java.io.Serializable{
    
     
  ArrayList<datos> lista  = new ArrayList();

  public ArrayList conectar(){
   try{ 
    FileInputStream fis = new FileInputStream("datos");
    ObjectInputStream entrada = new ObjectInputStream(fis);	  
	 lista = (ArrayList <datos>) entrada.readObject(); 
    fis.close();
    entrada.close();
   } 
   catch(ClassNotFoundException | IOException e){        
     System.out.println("Archivo no existe, sera creado");
   } 
   return lista;
  }
  public void grabar(ArrayList  lista) {
   try {
    FileOutputStream fos = new FileOutputStream("datos");
    ObjectOutputStream grabar = new ObjectOutputStream(fos);
    grabar.writeObject(lista);
    fos.close();
    grabar.close(); 
   } 
   catch(IOException e){
     System.out.println("no se crea");
   }
  }
}
