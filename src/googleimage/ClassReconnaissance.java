/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package googleimage;

/**
 *
 * @author AlassaneOusmane
 */

import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.linguist.dictionary.FastDictionary;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import t2s.son.LecteurTexte;


/**
 * A simple HelloWorld demo showing a simple speech application built using Sphinx-4. This application uses the Sphinx-4
 * endpointer, which automatically segments incoming audio into utterances and silences.
 */
public class ClassReconnaissance {

             
   public   ConfigurationManager cm;	
     Acceuil a=new Acceuil();
    
 public   Recognizer recognizer ;
    public Microphone microphone;
   public static  LecteurTexte t=new LecteurTexte();
    
    public void arreter() {
        
        
       if(a.isActive())
       {a=null;
           System.gc();
       
        recognizer.deallocate();
        microphone.stopRecording();
        JOptionPane.showMessageDialog(null, "reconnaissance désactivée");
            try {
                finalize();
            } catch (Throwable ex) {
                Logger.getLogger(ClassReconnaissance.class.getName()).log(Level.SEVERE, null, ex);
            }
}}
    
    
public void maReconnaissance(){
   
  
          
            cm = new ConfigurationManager(HelloWorld.class.getResource("helloworld.config.xml"));
        

         recognizer = (Recognizer) cm.lookup("recognizer");
        recognizer.allocate();

        // start the microphone or exit if the programm if this is not possible
         microphone = (Microphone) cm.lookup("microphone");
        if (!microphone.startRecording()) {
            System.out.println("Erreur microphone.");
            recognizer.deallocate();
            System.exit(1);
        }

JOptionPane.showMessageDialog(null, "Vous pouvez commencer à parler !");String session=null;
        // loop the recognition until the programm exits.
        while (true) {
            t.muet();
            t.setTexte("");

            Result result = recognizer.recognize();
                System.out.println(result);
            if (result != null) {
                String resultText = result.getBestFinalResultNoFiller();
                     resultText=resultText.replace('è', 'e');
                 resultText=resultText.replace('ê', 'e');
                 resultText=resultText.replace('é', 'e');
                System.out.println("vous avez dit :"+resultText);
                if(resultText.length()>0)
                {
                            RechercheTexte rech;
        try {
            rech = new RechercheTexte(resultText);
            rech.setVisible (true);
        } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage());
            } 
                }
                
         
            }}}
    
}
