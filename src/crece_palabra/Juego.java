/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crece_palabra;

import java.io.*;

public class Juego {
    public static int ContadorPalabras = 0;
    public static boolean Comodin = true, Jugando = true;
    public static char respuesta;
    public static char[] PActual, PNueva;
    static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
    
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
                System.out.println("El idioma del juegos es: "+Utilidades.Idioma()+" ## "+"Comodin: "+ValComodin);
            }
            else {
                System.out.println("El idioma del juegos es: "+Utilidades.Idioma());
            }
            System.out.print("Letas disponibles: ");
            for (int i = 0; i < Utilidades.Letras.length; i++) {
                System.out.print("["+Utilidades.Letras[i]+"]");               
            }
            System.out.println();
            if(ContadorPalabras != 0){
                System.out.print("La palabra anterior es: ");
                for (int i = 0; i < PActual.length; i++) {
                    System.out.print(PActual[i]);
                }
                System.out.println();
            }
            System.out.print("Introduce una palabra: ");
            BufferedReader teclado2 = new BufferedReader(new InputStreamReader(System.in));
            PNueva = teclado2.readLine().toCharArray();
            if(ContadorPalabras != 0){
                if(Palabra.ComprobarPaPn(PActual, PNueva)) {
                    Palabra.añadirPalabraUsada(PNueva);
                    PActual = PNueva;
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
            if (ContadorPalabras == 100) {
                Palabra.puntuacion = Palabra.puntuacion + 500;
                FinJuego();
            }
        }
    }
    
    public static boolean PalabraIncorrecta(char[] pal)throws Exception{ 
        System.out.print("Palabra no encontrada en el diccionario. "
        + "La palabra realmente existe? (s/n) ");
        respuesta = (char)teclado.read();
        teclado.skip(1);
        if(respuesta == 's') {
            Utilidades.EscribirDiccionario(pal);
            if(Palabra.ComprobarPaPn(PActual, pal)) {
                ContadorPalabras++;
                //PActual = pal;
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
                    //pal2 = Utilidades.UsarComodin();
                    //Palabra.añadirPalabraUsada(pal2);
                    //ContadorPalabras++;
                    System.out.print("Comodín usado");
                    Comodin = false;
                    return true;
                }
                else {
                    Juego.FinJuego();
                }
            }
            else {
                Juego.FinJuego();
            }
        }
        return false;
    }
    
    public static void FinJuego() throws Exception {
        System.out.print("Quiere finalizar el juego? (s/n) ");
        respuesta = (char)teclado.read();
        teclado.skip(1); 
        if(respuesta == 's') {
            System.out.println("GAME OVER");
            Jugando = false;
            Utilidades.ResetearTemp();
            Utilidades.IntroducirRecord();
        }
    }  
//FIN
}
