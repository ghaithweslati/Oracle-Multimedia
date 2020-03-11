/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pointage;

import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;
import javax.swing.JOptionPane;

/**
 *
 * @author AlassaneOusmane
 */
public class Reconnaissance {
  public Microphone microphone;
  public Recognizer recognizer;

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
    
    
    
    
    
    
    
    
    
    
    
    
    
       public void reconnaitre(){
           

        
            cm = new ConfigurationManager(HelloWorld.class.getResource("helloworld.config.xml"));
        

         recognizer = (Recognizer) cm.lookup("recognizer");
        recognizer.allocate();

        // start the microphone or exit if the programm if this is not possible
       
            
            microphone = (Microphone) cm.lookup("microphone");
        
       

       // System.out.println(" ouvrir | valider | commencer | fin | recommencer | aller | pause | abandonner | prendre /n etape | travail | tache | station | mission | calculatrice");

        // loop the recognition until the programm exits.
      JOptionPane.showMessageDialog(null, "vous pouez commencer à parler");
        while (getResultat().equals("non")) {
            
            
            
            
           if (microphone.startRecording()) {
            Result result = recognizer.recognize();
            
              
            System.out.println("Start speaking. Press Ctrl-C to quit.\n");

        
           

            if (result != null) {
                 resultText = result.getBestFinalResultNoFiller();
                 resultText=resultText.replace('è', 'e');
                 resultText=resultText.replace('ê', 'e');
                 resultText=resultText.replace('é', 'e');
                System.out.println("You said: " + resultText + '\n');
                if(resultText.equalsIgnoreCase("lancer application")||resultText.equalsIgnoreCase("ouvrir application"))
                 setResultat("oui");
             if(resultText.equalsIgnoreCase("arreter"))
                 setResultat("arreter");
             if(resultText.equalsIgnoreCase("gestion matieres"))
                 setResultat("gestion matiere");
              if(resultText.equalsIgnoreCase("gestion personnel"))
                 setResultat("gestion personnel");
             if(resultText.equalsIgnoreCase("pointage professeur"))
                 setResultat("pointage professeur");
             if(resultText.equalsIgnoreCase("pointage autre"))
                 setResultat("pointage autre");
             if(resultText.equalsIgnoreCase("liste absence"))
                 setResultat("liste absence");
              if(resultText.equalsIgnoreCase("liste personnel"))
                 setResultat("liste personnel");
             if(resultText.equalsIgnoreCase("ajout seance"))
                 setResultat("ajout seance");
             if(resultText.equalsIgnoreCase("ouvrir horaire"))
                 setResultat("ouvrir horaire");
             if(resultText.equalsIgnoreCase("fermer"))
                 setResultat("fermer");
            }else {
                    microphone.stopRecording();
            System.out.println("micro arreté");}
        }  
          else {
                recognizer.deallocate();
                System.out.println("reconnaissance arretée");
                
            }
        }
    
           
            
 }
  
  
  
       
    
}


    

