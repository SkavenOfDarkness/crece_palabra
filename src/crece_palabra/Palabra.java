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
    
    public void lectura(BufferedReader f) throws Exception {
        numCaracteres=0;
        while ((caracter!=FINAL_SECUENCIA)&&(caracter!=ESPACIO)) {
            caracteres[numCaracteres]=caracter;
            numCaracteres++;
            caracter = (char) f.read();
        }
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
    
    public int getCaracteres() {
        return numCaracteres;
    }
    
    public static char[] randomAbecedario() throws Exception {
        char [] abecedario = "abcdefghijklmnopqrstuvwxyz".toCharArray();
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
    
    // Sustituir una letra: 3 puntos
    public static boolean cambioUnaLetra(char[] pActual, char[] pNueva) throws Exception {
        boolean [] comprobar = new boolean[pActual.length];
        int contador = 0;
        for (int i = 0; i < pActual.length; i++) {
            if (pActual[i] == pNueva[i]) {
                comprobar[i] = true;
            }
        }
        for (int i = 0; i < comprobar.length; i++) {
            if (!comprobar[i]) {
                contador++;
            }
        }
        return (contador == 1);
    }
    
    // Cambiar las letras de orden: 5 puntos
    public static boolean cambiarLetrasOrden(char[] pActual, char[] pNueva) throws Exception {
        char [] abecedario = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int [] comprobarPActual = new int[abecedario.length];
        int [] comprobarPNueva = new int[abecedario.length];
        int contador = 0;
        for (int i = 0; i < pActual.length; i++) {
            for (int j = 0; j < comprobarPActual.length; j++) {
                if (pActual[i] == abecedario[j]) {
                    comprobarPActual[j]++;
                }
            }
        }
        for (int i = 0; i < pNueva.length; i++) {
            for (int j = 0; j < comprobarPNueva.length; j++) {
                if (pNueva[i] == abecedario[j]) {
                    comprobarPNueva[j]++;
                }
            }
        }
        for (int i = 0; i < comprobarPActual.length; i++) {
            if (comprobarPActual[i] == comprobarPNueva[i]) {
                contador = contador + comprobarPActual[i];
            }
        }
        return (contador == pActual.length);
    }
    
    // Cambiar las letras de orden y sustituir una: 1 puntos
    public static boolean cambiarOrdenYSustituir(char[] pActual, char[] pNueva) throws Exception {
        char [] abecedario = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int [] comprobarPActual = new int[abecedario.length];
        int [] comprobarPNueva = new int[abecedario.length];
        int contador = 0;
        for (int i = 0; i < pActual.length; i++) {
            for (int j = 0; j < comprobarPActual.length; j++) {
                if (pActual[i] == abecedario[j]) {
                    comprobarPActual[j]++;
                }
            }
        }
        for (int i = 0; i < pNueva.length; i++) {
            for (int j = 0; j < comprobarPNueva.length; j++) {
                if (pNueva[i] == abecedario[j]) {
                    comprobarPNueva[j]++;
                }
            }
        }
        for (int i = 0; i < comprobarPActual.length; i++) {
            //if ((comprobarPActual[i] >= comprobarPNueva[i]) || (comprobarPActual[i] <= comprobarPNueva[i])) {
                contador = contador + comprobarPActual[i];
            //}
        }
        return (contador == pActual.length);
    }
    
    // Añadir una letra en la palabra existente: 10 puntos
    public static boolean añadirLetraPalabraExistente(char[] pActual, char[] pNueva) throws Exception {
        char [] temp = new char[pNueva.length];
        int contador = 0;
        for (int i = 0; i < pActual.length; i++) {
            for (int j = 0; j < pNueva.length; j++) {
                if (pActual[i] == pNueva[j]) {
                    temp[j] = pNueva[j];
                    break;
                }
            }
        }
        int j = 0; //Variable que permite recorrer la palabra actual evitando el espacio
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != '\0') {
                if (temp[i] == pActual[j]) {
                    contador++;
                    j++;
                }
            }
        }
        return (contador == pActual.length);
    }
}