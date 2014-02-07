/*********************
 * CLASE Palabra     *
 * Autor: Lluis      *
 * Fecha: 27/12/2013 *
 *********************/
package crece_palabra;

import java.io.*;
import java.util.Arrays;

public class Palabra {
    // Atributos
    /*
    private static final char FINAL_SECUENCIA = '.';
    private static final int MAXIMO = 50;
    private static final char ESPACIO = ' ';
    private static char caracter = ESPACIO;
    private char [] caracteres = new char[MAXIMO];
    private int numCaracteres = 0;
    */
    public static int puntuacion = 0;
    
    // Interface
    // Metodos constructores 
    public Palabra() {}
    
   /* public void lectura() throws Exception {
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
    }*/
    
    //Genera automaticamente un un random, por cantida de letras deseadas
    public static void randomAbecedario() throws Exception {
        BufferedReader fr = new BufferedReader(new FileReader("archivos/configuracion.txt"));
        char [] Abecedario = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int CantidadLetras;
        //Preguntar y obtener la cantidad de letras
        System.out.print("Introduce cantidad de letras: ");
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        CantidadLetras = Integer.parseInt(teclado.readLine());   
        //Declaracion del array de las letras que se van a sacar por random
        char [] RandomAbecedario = new char[CantidadLetras];            
        //Bucle para relacionar lo obtenido por el random y el abecedario
        for(int i=0;i<CantidadLetras;i++){
           int NumRandom = (int)(Math.random()*26);          
           RandomAbecedario[i] = Abecedario[NumRandom];             
        }  
        //Parseamos a int el string que nos devuelve el readLine
        int NumDic = Integer.parseInt(fr.readLine());
        //Escribirmos en el archivo de configuracion el id del diccionario y las letras generadas
        Utilidades.EscribirConfiguracion(NumDic, RandomAbecedario);
        //Cerramos conecxiones
        fr.close();
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
        if (contador == 1) {
            puntuacion = puntuacion + 3;
            return true;
        }
        return false;
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
        if (contador == pActual.length) {
            puntuacion = puntuacion + 5;
            return true;
        }
        return false;
    }
    
    // Cambiar las letras de orden y sustituir una: 1 puntos
    public static boolean cambiarOrdenYSustituir(char[] pActual, char[] pNueva, int n) throws Exception {
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
            contador = contador + comprobarPActual[i];
        }
        if (contador == pActual.length) {
            if (n == 1) {
                puntuacion = puntuacion + 1;
            }
            else {
                puntuacion = puntuacion + 5;
            }
            return true;
        }
        return false;
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
        if (contador == pActual.length) {
            puntuacion = puntuacion + 10;
            return true;
        }
        return false;
    }
    
    //Añade la palabra que introduce el usuario al temp
    public static void añadirPalabraUsada(char[] pNueva) throws Exception {
        BufferedWriter Fwt = new BufferedWriter(new FileWriter("archivos/temp.txt", true));
        Fwt.write(pNueva);
        Fwt.newLine();
        Fwt.close();
    }
    
    //Recorre el fichero temp en busca de las palabras usadas
    public static boolean leerPalabraUsada(char[] pNueva) throws Exception {
        BufferedReader Fwt = new BufferedReader(new FileReader("archivos/temp.txt"));
        String palabra;
        while((palabra=Fwt.readLine()) != null) {
            char[] pal = palabra.toCharArray();
            if (Arrays.equals(pNueva, pal)) {
                Fwt.close();
                return true;
            }  
        }
        Fwt.close();
        return false; 
    }
    //Comprueba el tamaño de la palabra para enviarlo a una fucion u otra
    public static boolean ComprobarPaPn(char[] pActual, char[] pNueva) throws Exception {       
        int contador = 0;
        int[] repetidas = new int[Utilidades.Letras.length];
        for (int i = 0; i < pNueva.length; i++) {
            for (int j = 0; j < Utilidades.Letras.length; j++) {
                if(pNueva[i] == Utilidades.Letras[j]) {
                    repetidas[j]++;
                    break;
                }
            }
        }
        for (int i = 0; i < repetidas.length; i++) {
            if(repetidas[i] >= 1) {
                contador = contador + repetidas[i];
            }
        }
        if (contador == pNueva.length) {
            if(leerPalabraUsada(pNueva) == false) {
                if(Utilidades.MirarDiccionario(pNueva)) {
                    if(pActual != null) {
                        if(pActual.length == pNueva.length) {    
                            return ((cambioUnaLetra(pActual, pNueva)) || (cambiarLetrasOrden(pActual, pNueva)) || (cambiarOrdenYSustituir(pActual, pNueva, 1)));
                        }
                        if(pActual.length == (pNueva.length - 1)) {
                            return ((añadirLetraPalabraExistente(pActual, pNueva)) || (cambiarOrdenYSustituir(pActual, pNueva, 5)));
                        }
                    }
                    else {
                        Juego.PActual = pNueva;
                        return true;
                    }
                }
                else {
                    return(Juego.PalabraIncorrecta(pNueva));
                }
            }
            System.out.println("La palabra ha sido introducida anteriormente");
            return false;
        }
        System.out.println("La palabra no cumple las letras indicadas");
        return false;
    }
}