/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crece_palabra;

import java.io.*;
import java.util.Arrays;

public class Juego {
    public static int ContadorPalabras = 0;
    public static boolean Comodin = true, Jugando = true;
    public static char respuesta;
    public static char[] PActual, PNueva;
    static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
    
    public Juego(){}
    
    //Logica troncal del juego
    public static void Jugar() throws Exception {
        //Carga la configuracion guardada en 
        Utilidades.CargaConfiguraciones();
        String ValComodin = "Disponible";
        //Establece un bucle que no acaba de jugar hasta que Jugando sea false
        while(Jugando){
            Utilidades.limpiarPantalla();
            //Si el comodin esta en false cambiamos la variable que muestra el estado
            if(Comodin == false) {
                ValComodin = "No sisponible";
            }
            //Se observa si la palabra es la primera a introduccir
            if(ContadorPalabras >= 1) {
                System.out.println("El idioma del juegos es: "+Utilidades.Idioma()+" ## "+"Comodin: "+ValComodin);
            }
            else {
                System.out.println("El idioma del juegos es: "+Utilidades.Idioma());
            }
            //Impresion de las letras disponibles
            System.out.print("Letas disponibles: ");
            for (int i = 0; i < Utilidades.Letras.length; i++) {
                System.out.print("["+Utilidades.Letras[i]+"]");               
            }
            //Muestra la palabra anteriormente introduccida
            System.out.println();
            if(ContadorPalabras != 0){
                System.out.print("La palabra anterior es: ");
                for (int i = 0; i < PActual.length; i++) {
                    System.out.print(PActual[i]);
                }
                System.out.println();
            }
            //Peticion de la palabra nueva
            System.out.print("Introduce una palabra: ");
            BufferedReader teclado2 = new BufferedReader(new InputStreamReader(System.in));
            PNueva = teclado2.readLine().toCharArray();
            //Caso en que no es la primera palabra
            if(ContadorPalabras != 0){
                //Comprueba la palabra nueva con la anterior,devuelve true o false
                if(Palabra.ComprobarPaPn(PActual, PNueva)) {
                    //Añade la palabra al temp, para saber si se ha usado
                    Palabra.añadirPalabraUsada(PNueva);
                    //Le da el valor de PNueva a PActual
                    PActual = PNueva;
                    ContadorPalabras++;
                    System.out.println(Palabra.puntuacion);
                }
            }
            //Caso en el que es la primera palabra
            else{
                //Se mira que exista la palabra en el diccionario, devuelve 
                if(Utilidades.MirarDiccionario(PNueva)){
                    //Añade la palabra al temp, para saber si se ha usado
                    Palabra.añadirPalabraUsada(PNueva);
                    //Le da el valor de PNueva a PActual
                    PActual = PNueva;
                    ContadorPalabras++;
                }
                //En caso de nos estar en el diccionario, preguntamos si existe
                else {
                    PalabraIncorrecta(PNueva);
                }
            }
            //Si han introduccido 100 palabras correctas acaba el juego y se le suma 500
            if (ContadorPalabras == 100) {
                Palabra.puntuacion = Palabra.puntuacion + 500;
                FinJuego();
            }
        }
    }
    
    public static boolean PalabraIncorrecta(char[] pal)throws Exception{
        int contador = 0;
        int[] repetidas = new int[Utilidades.Letras.length];
        for (int i = 0; i < pal.length; i++) {
            for (int j = 0; j < Utilidades.Letras.length; j++) {
                if(pal[i] == Utilidades.Letras[j]) {
                    repetidas[j]++;
                }
            }
        }
        for (int i = 0; i < repetidas.length; i++) {
            if(repetidas[i] >= 1) {
                contador++;
            }
        }
        if (contador == pal.length) {
            System.out.print("Palabra no encontrada en el diccionario. "
            + "La palabra realmente existe? (s/n) ");
            respuesta = (char)teclado.read();
            teclado.skip(1);
            if(respuesta == 's') {
                Utilidades.EscribirDiccionario(pal);
                if(Palabra.ComprobarPaPn(PActual, pal)) {
                    ContadorPalabras++;
                    return true;
                }
            }
            else {
                if((Comodin == true) && (ContadorPalabras != 0)) {
                    System.out.print("Palabra no encontrada en el diccionario. "
                    + "Quieres usar el comodín? (s/n) ");
                    respuesta = (char)teclado.read();
                    teclado.skip(1);
                    if(respuesta == 's') {
                        char[] n = "n".toCharArray();
                        char[] pal2 = Utilidades.UsarComodin();
                        if(!Arrays.equals(pal2, n)) {
                            Palabra.añadirPalabraUsada(pal2);
                            PNueva = pal2;
                            ContadorPalabras++;
                            System.out.print("Comodín usado");
                            Comodin = false;
                            return true;
                        }
                        System.out.println("No se a encontrado palabra");
                    }
                    else {
                        Juego.FinJuego();
                    }
                }
                else {
                    Juego.FinJuego();
                }
            }          
        }
        else {
            System.out.println("La palabra no cumple las letras indicadas");
        }
        return false;
    }
    
    //Administrar final de juego
    public static void FinJuego() throws Exception {
        System.out.print("Quiere finalizar el juego? (s/n) ");
        respuesta = (char)teclado.read();
        teclado.skip(1); 
        if(respuesta == 's') {
            System.out.println("GAME OVER");
            Jugando = false;
           /* if (PActual.length >= 7) {
                Palabra.puntuacion = Palabra.puntuacion + (PActual.length * 15);
            }*/
            //Reseteamos el archivo temp 
            Utilidades.ResetearTemp();
            //Miramos si ha habido record y se introduce
            Utilidades.IntroducirRecord();
        }
    }  
//FIN
}
