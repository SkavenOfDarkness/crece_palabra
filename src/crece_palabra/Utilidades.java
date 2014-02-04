/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crece_palabra;

import java.io.*;

public class Utilidades {
    
    public  Utilidades(){};
    
    //Clase para limpiar pantalla
    public static void  limpiarPantalla() {
        for (int i=0; i<10; i++){
            System.out.println();
        }
    }
    
    public static void ListaLetrasManual() throws Exception{ 
        BufferedReader fr = new BufferedReader(new FileReader("archivos/configuracion.txt"));
        System.out.print("Introduce las letras que deseas: ");   
        BufferedReader teclado= new BufferedReader(new InputStreamReader(System.in));
        char[] Letras = teclado.readLine().toCharArray();       
        int NumDic = Integer.parseInt(fr.readLine());
        Utilidades.EscribirConfiguracion(NumDic, Letras);             
        //Cerrar bufferes
        fr.close();
        
    }
    
    public static void ElegirDiccionario() throws Exception{
        BufferedReader fr = new BufferedReader(new FileReader("archivos/configuracion.txt"));
        Utilidades.limpiarPantalla();
        System.out.print("_-Menu Configuracion Diccionario-_\n"
                + "-------------------------------\n"
                + "1 Español \n"
                + "2 Catalan \n"
                + "3 Ingles \n"
                + "Instroduce el numero del diccionario: ");
        BufferedReader teclado= new BufferedReader(new InputStreamReader(System.in));
        int NumDic = Integer.parseInt(teclado.readLine());
        fr.readLine();
        char[] Letras = fr.readLine().toCharArray();
        Utilidades.EscribirConfiguracion(NumDic, Letras);
        //Cerrar bufferes
        fr.close();
    }
    /*
     1 - Español
     2 - Catalan
     3 - Ingles
     */
    public static void EscribirConfiguracion(int Diccionario, char[] ListaLetras)throws Exception{
        BufferedWriter fw = new BufferedWriter(new FileWriter("archivos/configuracion.txt"));
        
        char NumDic = Character.forDigit(Diccionario, 10);
        fw.write(NumDic);
        fw.newLine();
        fw.write(ListaLetras);
        
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
            for (int i=0; i < ListaDiccionarios.length; i++) {
                System.out.println(ListaDiccionarios[i]);
            }
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
