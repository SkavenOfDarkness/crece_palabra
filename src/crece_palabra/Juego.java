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
public class Juego {
    public static int ContadorPalabras = 0;
    public static boolean Comodin = true, Jugando = true;
    public static char respuesta;
    public static char[] PActual, PNueva;
    
    public Juego(){}
    
    public static void Jugar() throws Exception {      
        Utilidades.CargaConfiguraciones();
        String ValComodin = "Disponible";
        while(Jugando){
            Utilidades.limpiarPantalla();
            if(Comodin == false) {
                ValComodin = "No sisponible";
            }
            if(ContadorPalabras >= 1) {
                System.out.println("El idioma del juegos es: "+"idioma"+" ## "+"Comodin: "+ValComodin);
            }
            else {
                System.out.println("El idioma del juegos es: "+"idioma");
            }
            System.out.print("Letas disponibles: ");
            for (int i = 0; i < Utilidades.Letras.length; i++) {
                System.out.print("["+Utilidades.Letras[i]+"]");               
            }
            System.out.println();
            if(ContadorPalabras !=0){
                System.out.print("La palabra anterior es: ");
                for (int i = 0; i < PActual.length; i++) {
                    System.out.print(PActual[i]);
                }
                System.out.println();
            }
            System.out.print("Introduce una palabra: ");
            BufferedReader teclado2 = new BufferedReader(new InputStreamReader(System.in));
            PNueva = teclado2.readLine().toCharArray();
            if(ContadorPalabras !=0){
                System.out.println(Palabra.ComprobarPaPn(PActual, PNueva));
                if(Palabra.ComprobarPaPn(PActual, PNueva)) {
                    ContadorPalabras++;
                    System.out.println(Palabra.puntuacion);
                }
            }
            else{
                if(Utilidades.MirarDiccionario(PNueva)){
                    Palabra.añadirPalabraUsada(PNueva);
                    PActual = PNueva;
                    ContadorPalabras++;
                }
                else {
                    PalabraIncorrecta(PNueva);
                }
            }
        }
    }
    
    public static void PalabraIncorrecta(char[] PNueva)throws Exception{ 
        System.out.print("Palabra no encontrada en el diccionario. "
        + "La palabra realmente existe? (s/n) ");
        respuesta = (char)System.in.read();
        if(respuesta == 's') {
            Utilidades.EscribirDiccionario(PNueva);
            Palabra.añadirPalabraUsada(PNueva);
            if(Palabra.ComprobarPaPn(PActual, PNueva)) {
                ContadorPalabras++;
                PActual = PNueva;
                System.out.println(Palabra.puntuacion);
            }
        }
        else {
            if(Comodin && ContadorPalabras != 0) {
                System.out.print("Palabra no encontrada en el diccionario. "
                + "Quieres usar el comodín? (s/n) ");
                respuesta = (char)System.in.read();
                if(respuesta == 's') {
                    //PActual = Utilidades.UsarComodin();
                    Palabra.añadirPalabraUsada(PActual);
                    ContadorPalabras++;
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
    
    public static void FinJuego() throws Exception {
        System.out.print("Quiere finalizar el juego? (s/n) ");
        respuesta = (char)System.in.read();
        if(respuesta == 's') {
            System.out.println("GAME OVER");
            Jugando = false;
        }
    }
    
//FIN
}
