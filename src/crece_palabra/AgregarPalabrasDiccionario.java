/********************************************************************************************
 * Funcionalidad: Programa que agrege la palabra introducida por teclado en diccionatio.txt *
 * al final de este mismo, creando así un diccionario de palabras.                          *
 * Autor: Lluís                                                                             *
 * Fecha: 27/12/2013                                                                        *
 ********************************************************************************************/
package crece_palabra;

import java.io.*;

public class AgregarPalabrasDiccionario {
    public static void main(String[] arg) throws Exception {
        Palabra pal = new Palabra();
        BufferedWriter buffer = new BufferedWriter(new FileWriter("/home/lluis/pruebas/diccionatio.txt", true));
        System.out.print("Introduce una secuéncia de caracteres: ");
        while(Palabra.quedenPalabra()) {
            pal.lectura();
            pal.escritura(buffer);
        }
        buffer.close();
    }
}
