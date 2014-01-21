/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crece_palabra;
import java.io.*;
/**
 *
 * @author javier
 */
public class Record {
    
    
        public static void LeerRecords() throws IOException {
    int entrada;
    
    
    //archivo de record
    FileInputStream fichero=new FileInputStream("c:/pruebas/Record.txt");

   //Comprobamos la existencia del archivo
    File ficheroRecord = new File("c:/pruebas/Record.txt");       
        if (ficheroRecord.exists()) {
            System.out.println(ficheroRecord.canWrite() ? "es de escritura" : "no es de escritura");
            System.out.println(ficheroRecord.canRead() ? "es de lectura" : "no es de lectura");           

        //leemos b a b el fichero de records
                while( ( entrada=fichero.read() ) != -1 ) {                 
                  System.out.print((char)entrada );
                } 
                //Introducimos una linea en blanco 
                System.out.println(); 
                fichero.close();
        
            }
            else {
                System.out.println("Alguno de los ficheros no existe");
            }
    
   

        
  } 
}
