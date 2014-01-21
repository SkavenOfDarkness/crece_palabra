/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package extender_palabra;

/**
 *
 * @author javier
 */
public class Pruebas {

 
    public static void main(String[] args) {
        // TODO code application logic here
   
     String [] abecedario = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M","N","O","P","Q","R","S","T","U","V","W", "X","Y","Z" };
     String [] Randomabecedario=new String[300000];
     for(int i=0;i<300000;i++){
                      // int numRandom =(int) Math.round(Math.random()*27);  
          int numRandom =(int) (Math.random()*26);
                  if (numRandom==25){
                      System.out.print("BINGO!!!!");
                  }      
                         
               Randomabecedario[i] = abecedario[numRandom];
               System.out.print(numRandom+"-"+Randomabecedario[i]+"\n");
               
      }
    }
    
}
