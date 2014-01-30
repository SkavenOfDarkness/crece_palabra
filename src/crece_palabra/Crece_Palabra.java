/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crece_palabra;

/**
 *
 * @author lluis
 */
public class Crece_Palabra {
    public static void main(String[] args) throws Exception {
        //Instanciamos CrearMenu
        // CrearMenu MenuPrincipal = new CrearMenu();
        Menu MenuPrin = new Menu();
        //Damos la bienvenida 
        System.out.print("*******************************\n"
                        +"*BIENVENIDO A EXTENDER_PALABRA*\n"
                        +"*******************************\n"
                         );
        //Llamamos a la funcion menuPrincipal de CrearMenu.java y nos imprime el menu
        // MenuPrincipal.menuPrincipal();
        MenuPrin.MenuPrincipal();
    }
}

