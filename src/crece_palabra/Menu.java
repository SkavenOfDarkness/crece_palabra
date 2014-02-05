/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crece_palabra;

import java.io.*;

public class Menu {
    
    public Menu() {}
    static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
    public void MenuPrincipal() throws Exception {    
        Utilidades.limpiarPantalla();
        System.out.print("_-Menu Principal-_\n"
                +"-------------------------------\n"
                +".  1 Jugar  \n"
                +".  2 Record  \n"
                +".  3 Configuración  \n"
                +".  0 Salir  \n"
                );      
        System.out.print("Introduzca una opcion: ");
        char opcion=(char)teclado.read();
        teclado.skip(1); 
        switch (opcion) {
            case '1': Juego.Jugar();MenuPrincipal();break;
            case '2': MenuRecord();break;            
            case '3': MenuConfiguracion();break;
            default: break;
        }  
    }

    public  void MenuRecord() throws Exception {
        Utilidades.limpiarPantalla();
        System.out.print("__Menu Record__\n"
                +"-------------------------------\n"
                +".  1 Ver records  .\n"
                +".  2 Resetear records  .\n"                                   
                +".  3 Atras  .\n"
                );        
        System.out.print("Introduzca una opcion: ");
        char opcion=(char) teclado.read();  
        teclado.skip(1); 
        switch (opcion) {
            case '1': Utilidades.LeerRecord();MenuRecord();break;
            case '2': Utilidades.ResetearRecord();MenuRecord();break;               
            default: MenuPrincipal();break;
        }        
    }
   
    public  void MenuConfiguracion() throws Exception {
        Utilidades.limpiarPantalla();
        System.out.print("_-Menu Configuracion-_\n"
                +"-------------------------------\n"
                +".  1 Letras iniciales  .\n"
                +".  2 Idioma diccionario  .\n"
                +".  3 Atras  .\n"
                );          
        System.out.print("Introduzca una opcion: ");
        char opcion=(char) teclado.read();  
        teclado.skip(1); 
        switch (opcion) {
            case '1': MenuLetrasIniciales();break;
            case '2': Utilidades.ElegirDiccionario();MenuConfiguracion();break;
            default: MenuPrincipal();break;
        }         
    }
      
    public  void MenuLetrasIniciales() throws Exception {
        Utilidades.limpiarPantalla();
        System.out.print("_-Menu Letras iniciales-_\n"
                +"-------------------------------\n"
                +".  1 Manual  .\n"
                +".  2 Automatico  .\n"
                +".  3 Atras  .\n"
                );     
        System.out.print("Introduzca una opcion: ");
        char opcion=(char) teclado.read();  
        teclado.skip(1); 
        switch (opcion) {
            case '1': Utilidades.ListaLetrasManual();MenuLetrasIniciales();break;  
            case '2': Palabra.randomAbecedario(0);MenuLetrasIniciales();break;
            default: MenuConfiguracion();break;
        }        
    }   
}