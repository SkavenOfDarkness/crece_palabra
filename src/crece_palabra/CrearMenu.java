/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crece_palabra;



/**
 *
 * @author javier
 */
public class CrearMenu {
    //Instanciar utilidades  
  public static   utilidades utilidades=new utilidades();
  public static   Record record = new Record();
    
  public static int NumMenu;
  //Metodo para crear el menu principal
  
  public  void menuPrincipal() throws Exception{
      //Imprimir por pantalla el menu Principal       
     
      System.out.print("_-Menu Principal-_\n"
                    +"-------------------------------\n"
                    +".  1 Jugar  \n"
                    +".  2 Record  \n"
                    +".  3 Configuración  \n"
                    +".  4 Salir  \n"
                    );      
     // Obtenemos el numero apartir de la utlidad numeroMenu
      NumMenu= utilidades.numeroMenu();
            switch(NumMenu){  
                  case 1:
                      utilidades.limpiarPantalla();
                      System.out.print("Jugar \n");
                      //Llamar a jugar
                      menuPrincipal();                     
                  case 2:
                      utilidades.limpiarPantalla();
                      System.out.print("Menu Record \n");
                      menuRecord();
                  case 3:
                      utilidades.limpiarPantalla();
                      System.out.print("Menu Configuracion \n");
                      menuConfiguracion();
                  case 4:
                      utilidades.limpiarPantalla();
                      System.out.print("ADIOS \n");
                      break;
                      // FALTA PROBAR System.exit(0);
            }
  }
  
  public void menuRecord() throws Exception{
       
     //Imprimir por pantalla el menu Record     
      System.out.print("__Menu Record__\n"
                    +"-------------------------------\n"
                    +".  1 Ver records  .\n"
                    +".  2 Resetear records  .\n"                                   
                    +".  3 Atras  .\n"
                    );      
     // Obtenemos el numero apartir de la utlidad numeroMenu
      NumMenu= utilidades.numeroMenu();
      switch(NumMenu){  
            case 1:
                utilidades.limpiarPantalla();
                System.out.print("Ver records \n");
                //Llamar a ver records
                record.LeerRecords();
                menuRecord();
            case 2:
                utilidades.limpiarPantalla();
                System.out.print("Resetear records \n");
                menuPrincipal();
            case 3:
                utilidades.limpiarPantalla();
                System.out.print("Atras \n");
                menuPrincipal();
            
      }
  
    }
  
  public  void menuConfiguracion() throws Exception{
      //Imprimir por pantalla el menu Principal       
     
      System.out.print("_-Menu Configuracion-_\n"
                    +"-------------------------------\n"
                    +".  1 Numero de letras iniciales  .\n"
                    +".  2 Letras iniciales  .\n"
                    +".  3 Idioma diccionario  .\n"
                    +".  4 Atras  .\n"
                    );      
     // Obtenemos el numero apartir de la utlidad numeroMenu
      NumMenu= utilidades.numeroMenu();
            switch(NumMenu){  
                  case 1:
                      utilidades.limpiarPantalla();
                      System.out.print("Numero de letras iniciales \n");
                      //Llamar a numero de letras iniciales
                      utilidades.Randomabecedario();
                  case 2:
                      utilidades.limpiarPantalla();
                      System.out.print("Letras iniciales \n");
                      menuPrincipal();
                  case 3:
                      utilidades.limpiarPantalla();
                      System.out.print("Idioma diccionario \n");
                      utilidades.ListarDiccionarios();
                  case 4:
                      utilidades.limpiarPantalla();
                       System.out.print("Atras \n");
                      menuPrincipal();
                      
            }
  }
  
  
  //Cierre del final
  
}
