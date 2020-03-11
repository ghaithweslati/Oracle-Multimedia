/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package googleimage;

/**
 *
 * @author AlassaneOusmane
 */
public class Thread2 extends Thread{
  public void run() {
   
    ClassReconnaissance r=new ClassReconnaissance();
    r.maReconnaissance();
     
      try {
        // pause
        Thread2.sleep(500);
      }
      catch(Exception ex){} 
    //<editor-fold defaultstate="collapsed" desc="comment">
    
    //</editor-fold>
  }  
 
}
