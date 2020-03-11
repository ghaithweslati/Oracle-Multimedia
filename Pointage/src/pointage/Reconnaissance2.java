/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pointage;

import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;
import edu.cmu.sphinx.util.props.PropertyException;
import java.io.IOException;
import java.net.URL;
import javax.swing.JOptionPane;

/**
 *
 * @author AlassaneOusmane
 */
public class Reconnaissance2 {
  
  public Result result;
  public  ConfigurationManager cm;
     static  String resultat="non", motreconnu=" je ne vous entends pas!";
 String resultText;
    public String getMotreconnu() {
        return motreconnu;
    }

    public void setMotreconnu(String motreconnu) {
        this.motreconnu = motreconnu;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }
    
    
    
    
    
    
    
    
        public String ecouter() {
    
    
    Recognizer recognizer;
    Microphone microphone;

    ConfigurationManager cm;

    URL url= this.getClass().getResource("helloworld.config.xml");

    

        cm = new ConfigurationManager(url);

        
                recognizer = (Recognizer) cm.lookup("recognizer");
                microphone = (Microphone) cm.lookup("microphone");

            /* allocate the resource necessary for the recognizer */
            recognizer.allocate();

            /* the microphone will keep recording until the program exits */
            while(resultat.equals("non"))
            if (microphone.startRecording()) {

                Result result = recognizer.recognize();

                if (result != null) {
        String resultText = result.getBestResultNoFiller();
        if(resultText.equals("quitter"))
            setResultat("oui");
        return("tu as dit: "+resultText);
                } else {
                    microphone.stopRecording();
            return("je n'entends pas");
                
            } }
			else {
                recognizer.deallocate();
                return("micro bleme");
            }

        return "je ne vous entends pas";}
  
        
       
    
}


    

