/*********************
 * CLASE Palabra     *
 * Autor: Lluis      *
 * Fecha: 27/12/2013 *
 *********************/
package crece_palabra;

import java.io.*;

public class Palabra {
    // Atributos
    private static final char FINAL_SECUENCIA = '.';
    private static final int MAXIMO = 50;
    private static final char ESPACIO = ' ';
    private static char caracter = ESPACIO;
    private char [] caracteres = new char[MAXIMO];
    private int numCaracteres = 0;
    
    // Interface
    // Metodos constructores 
    public Palabra() {}
    
    public void lectura() throws Exception {
        numCaracteres = 0;
        while (((caracter >= 'a') && (caracter <= 'z')) || ((caracter >= 'A') && (caracter <= 'Z'))) {
            caracteres[numCaracteres] = caracter;
            numCaracteres++;
            caracter = (char)System.in.read();
        }
    }
    
    public void lectura(BufferedReader f) {
        numCaracteres=0;
        try {
            while ((caracter!=FINAL_SECUENCIA)&&(caracter!=ESPACIO)) {
                caracteres[numCaracteres]=caracter;
                numCaracteres++;
                caracter = (char) f.read();
            }
        }catch (IOException e) {}
    }
    
    public void escritura(BufferedWriter f) throws Exception {
        for (int i=0;i<numCaracteres;i++) {
            f.write(caracteres[i]);
        }
        f.write(ESPACIO);
    }
    
    private static void buscarPalabra() throws Exception {
        //while (caracter == ESPACIO)
        while ((caracter != FINAL_SECUENCIA) && !((caracter >= 'a') && (caracter <= 'z') && (caracter >= 'A') && (caracter <= 'Z'))) {
            caracter = (char)System.in.read();
        }
    }
    
    public  static void buscarPalabra(BufferedReader f) throws Exception {
        while (caracter==ESPACIO) {
            caracter = (char) f.read();
        }
    }
    
    public static boolean quedenPalabra() throws Exception {
        buscarPalabra();
        return (caracter != FINAL_SECUENCIA);
    }
    
    public static boolean quedenPalabra(BufferedReader f) throws Exception {
        buscarPalabra(f);
        return (caracter != (char) -1);
    }
    
    @Override
    public String toString() {
        String pal = "";
        for (int i = 0; i < numCaracteres; i++) {
            pal = pal + caracteres[i];
        }
        return pal;
    }
    
    public int getCaracteres() {
        return numCaracteres;
    }
    
    public static char[] Randomabecedario() throws Exception{
        char [] abecedario = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        int cantidadLetras;
        //Preguntar y obtener la cantidad de letras
        System.out.print("Introduce cantidad de letras: ");
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        cantidadLetras = Integer.parseInt(teclado.readLine());
        //Declaracion del array de las letras que se van a sacar por random
        char [] Randomabecedario = new char[cantidadLetras];
        //System.out.println(cantidadLetras+" esto es la opcion elegida");
        //String todo = "";

        //fallo en recorrer el array Randomabecedario hay que ponerlo con .leght            
        // Bucle para relacionar lo obtenido por el random y el abecedario
        for(int i=0;i<cantidadLetras;i++){
           int numRandom = (int)Math.random()*26;                        
           //System.out.print(numRandom+"-");
           Randomabecedario[i] = abecedario[numRandom];
           //Comprobar que escupe
           //System.out.println(Randomabecedario[i]);
        }
        // Devolvemos el valor de las letras aleatorias
        return Randomabecedario;
        //Metemos todas las letras en una variable codigo temporal
//        for (int en=0; en<Randomabecedario.length; en++){                     
//            //System.out.print(Randomabecedario[en]);
//            todo = todo + Randomabecedario[en];
//        }
    }
}
