/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crece_palabra;

/**
 *
 * @author javier
 */
public class Extender_Palabra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
       //Instanciamos CrearMenu
       CrearMenu MenuPrincipal = new CrearMenu();
       
      //Damos la bienvenida 
       System.out.print("*******************************\n"
                       +"*BIENVENIDO A EXTENDER_PALABRA*\n"
                       +"*******************************\n"
                        );
       
       //Llamamos a la funcion menuPrincipal de CrearMenu.java y nos imprime el menu
       MenuPrincipal.menuPrincipal();
    }
}