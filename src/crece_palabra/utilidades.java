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
public class utilidades {
   
    public  utilidades(){};
            
            //Clase para limpiar pantalla
            public  void  limpiarPantalla() {
                     for (int i=0; i<10; i++){
                         System.out.println();
                     }
                 }
           //Obtener numero del menu
            
            
           
           public static void ListaLetrasManual() throws Exception{
                
                System.out.print("Introduce las letras que deseas: ");   
                BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
                char[] letras = teclado.readLine().toCharArray();
               /* for(int i=0;i<letras.length;i++){
                    System.out.print(letras[i]);
                    
                }*/
                utilidades.EscribirConfiguracion(1, letras);
           }
           /*
            1 - Español
            2 - Catalan
            3 - Ingles
            */
           public static void EscribirConfiguracion(int diccionario, char[] ListaLetras)throws Exception{
              //BufferedWriter fichero = new BufferedWriter(new FileWriter("archivos/configuracion.txt"));
             // FileOutputStream fichero=new FileOutputStream("archivos/configuracion.txt");
             // FileWriter fichero = new FileWriter ("archivos/configuracion.txt");
              /*String Lista = ListaLetras.toString();
              fichero.write("safas");
              fichero.close();*/
               FileWriter fw = new FileWriter("archivos/configuracion.txt");
                //Escribir, como ejemplo, los caracteres de la A a la Z
                int c=1;
                    fw.write(c);
                 //Cerrar el fichero
                fw.close();
           } 
           
           
           
           //Mostramos la lista de los diccionarios que hay 
         public static  void  ListarDiccionarios() throws Exception{
                 //Falta darle formato para mostrar los ficheros y quitarle que muestre .txt para mostrar como toca
                 // los diccionarios
                File directorioDiccionario = new File("c:/pruebas");
                String [] ListaDiccionarios = directorioDiccionario.list();
                            //Comprobamos la 
                            if (ListaDiccionarios == null){
                                System.out.println("No hay ficheros en el directorio especificado");
                            }
                                        else { 
                                            //Recorremos la lista de los diccionarios existentes
                                            for (int x=0;x<ListaDiccionarios.length;x++)
                                            System.out.println(ListaDiccionarios[x]);
                                            }
         }  
         
         public static void LeerRecord() throws Exception {
             int entrada;
             //buffer prinpial de lecutra del archivo
             BufferedReader buffer = new BufferedReader(new FileReader("archivos/record.txt"));
             //buffer segundo debido a mirar si el archivo esta vacio.
             BufferedReader buffer2 = new BufferedReader(new FileReader("archivos/record.txt"));
             if(buffer2.read() != -1){
                while((entrada=buffer.read()) != -1) {                 
                    System.out.print((char)entrada);
                }
                System.out.println();
             }
             else{
                 System.out.println("No hay records");
             }
             
             buffer.close();
             buffer2.close();
         } 
         
          public static void ResetearRecord() throws Exception {
            //Vaciamos el contenido del archivo.
             FileWriter fichero = new FileWriter("archivos/record.txt");
             fichero.close(); 
          }
          
}
