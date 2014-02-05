/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crece_palabra;

import java.io.*;
import java.util.Arrays;

public class Utilidades {
    //Valores de la configuracion inicial
    public static int Diccionario = 1;
    public static char[] Letras;
    
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
        Letras = teclado.readLine().toCharArray();       
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
        Letras = fr.readLine().toCharArray();
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
    
    public static void ResetearTemp() throws Exception {
        //Vaciamos el contenido del archivo.
        FileWriter fichero = new FileWriter("archivos/temp.txt");
        fichero.close(); 
    }
    
    public static void CargaConfiguraciones() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("archivos/configuracion.txt"));
        Diccionario = Integer.parseInt(br.readLine());
        Letras = br.readLine().toCharArray(); 
        //Cerrar conexiones
        br.close();  
    }
    
    public static String Idioma() throws Exception {
        String idioma;
        switch(Diccionario){
            case 1:
                idioma = "espanol";
                break;
            case 2:
                idioma = "catalan";
                break;
            case 3:
                idioma = "ingles";
                break;
            default:
                idioma = "";
        }
        return idioma;
    }
    
    public static boolean MirarDiccionario(char[] PComparar) throws Exception {
        BufferedReader Frd = new BufferedReader(new FileReader("archivos/diccionarios/"+Idioma()+".txt"));
        String PDiccionario;
        while((PDiccionario=Frd.readLine()) != null){
            char[] diccio = PDiccionario.toCharArray();
            if(Arrays.equals(diccio, PComparar)){
                Frd.close();
                return true;
            }
        }
        Frd.close();
        return false;
    }
    
    public static void EscribirDiccionario(char[] PNueva) throws Exception {
        BufferedWriter Fwd = new BufferedWriter(new FileWriter("archivos/diccionarios/"+Idioma()+".txt", true));
        Fwd.write(PNueva);
        Fwd.newLine();
        Fwd.close();
    }
    
    public static void IntroducirRecord() throws Exception {
        BufferedReader buffer = new BufferedReader(new FileReader("archivos/record.txt"));
        BufferedReader buffer2 = new BufferedReader(new FileReader("archivos/record.txt"));
        BufferedReader teclado= new BufferedReader(new InputStreamReader(System.in));
        if((buffer2.read()) != -1){
            String nombre = buffer.readLine();
            int record = Integer.parseInt(buffer.readLine());
            if (Palabra.puntuacion > record) {
                System.out.println("Has superado el record actual de "+nombre+" con "+record
                    +" puntos\n Tu record es: "+Palabra.puntuacion+ " puntos");
                System.out.print("Introduce tu nombre campeón: ");
                BufferedWriter bufferEscritura = new BufferedWriter(new FileWriter("archivos/record.txt"));
                bufferEscritura.write(teclado.readLine());
                bufferEscritura.newLine();
                bufferEscritura.write(String.valueOf(Palabra.puntuacion));
                bufferEscritura.close();
            }
            else {
                System.out.println("Tu puntuación es de: "+Palabra.puntuacion);
            }
        }
        else{
            System.out.println("Tu record es: "+Palabra.puntuacion+ " puntos");
            System.out.print("Introduce tu nombre campeón: ");
            BufferedWriter bufferEscritura = new BufferedWriter(new FileWriter("archivos/record.txt"));
            bufferEscritura.write(teclado.readLine());
            bufferEscritura.newLine();
            bufferEscritura.write(String.valueOf(Palabra.puntuacion));
            bufferEscritura.close();
        }
        buffer.close();
    }
//FINAL     
}
