/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crece_palabra;

/**
 *
 * @author javier
 */
public class Pruebas {
    public static void main(String[] args) throws Exception {
        char[] pActual = "casa".toCharArray();
        char[] pNueva = "saco".toCharArray();
        if(Palabra.cambioUnaLetra(pActual, pNueva)){
            System.out.println("3 puntos");
        }
        else {
            System.out.println("No has cambiado una letra");
        }
        if(Palabra.cambiarLetrasOrden(pActual, pNueva)) {
            System.out.println("5 puntos");
        }
        else {
            System.out.println("No has cambiado de orden las letras");
        }
        if(Palabra.cambiarOrdenYSustituir(pActual, pNueva)) {
            System.out.println("1 punto");
        }
        else {
            System.out.println("No has cambiado una letra y tampoco el orden");
        }
    }
}
