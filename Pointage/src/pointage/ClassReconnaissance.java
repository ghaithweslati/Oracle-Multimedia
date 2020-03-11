/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pointage;

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
    public static  MatiereJFrame m=new MatiereJFrame();
    public static PrivilegeJFrame p = new PrivilegeJFrame();
    public static  PersonnelJFrame per = new PersonnelJFrame();
    public static AbsenceJFrame prof = new AbsenceJFrame();
    public static   ListAbsenceFrame1 la = new ListAbsenceFrame1();
      public static ListeJFrame1 lp = new ListeJFrame1();
        public static  DispenserJFrame1 as = new DispenserJFrame1();
        public static  EmploiDuTempsJFrame1 oh = new EmploiDuTempsJFrame1();
                      
    public static AbsenceEmployersJFrame1 pointageautre = new AbsenceEmployersJFrame1();
             
   public   ConfigurationManager cm;	
     TableauDeBord a=new TableauDeBord();
    
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

            if (result != null) {
                String resultText = result.getBestFinalResultNoFiller();
                     resultText=resultText.replace('è', 'e');
                 resultText=resultText.replace('ê', 'e');
                 resultText=resultText.replace('é', 'e');
                System.out.println("vous avez dit :"+resultText);
                
                if(resultText.equalsIgnoreCase("lancer application"))
                {
                    session="bien";
                t.setTexte("bienvenue."); 
                 t.play();
                microphone.initialize();
                 }
              if(session!=null){
                  
                  session="verifie";
                 
                  switch(resultText)
                {
                     
                       
           
           
                         
                  
         case "gestion matieres":
            
         t.setTexte("mise à jour des matières");
             t.play();
             microphone.initialize();
             m.setVisible(true);
             break;
              case "fermer fenetre":
           
        per.setVisible(false);
        prof.setVisible(false);
        la.setVisible(false);
        lp.setVisible(false);
        as.setVisible(false);
        oh.setVisible(false);
        p.setVisible(false);
        pointageautre.setVisible(false);
       
             m.setVisible(false);
             break;
         case "gestion privileges":
             t.setTexte("mise à jour des différents postes.");
             t.play();
             microphone.initialize();
             
             
             p.setVisible(true);
             break;
         case "gestion personnel":
            
          t.setTexte("mise à jour de l'ensemble du personnel.");
             t.play();
             microphone.initialize();
             per.setVisible(true);
             break;
         case "pointage professeur":
             
            t.setTexte("Pointage des professeurs pour le jour en cours.");
             t.play();
             microphone.initialize();
             prof.setVisible(true);
             break;
         case "pointage autre":
               t.setTexte("pointage des employers autre que les professeurs.");
             t.play();
             microphone.initialize();
             pointageautre.setVisible(true);
             break;
         case "liste absence":
            t.setTexte("Liste des absences pour tous le personnel.");
             t.play();
             microphone.initialize();
             la.setVisible(true);
             break;
         case "liste personnel":
              t.setTexte("Liste de tous le personnel.");
             t.play();
             microphone.initialize();
             lp.setVisible(true);
             break;
         case "ajout seance":
            t.setTexte("Attribution des matières au professeurs.");
             t.play();
             microphone.initialize();
             as.setVisible(true);
             break;
         case "ouvrir horaire":
             t.setTexte("Liste des cours de chaque professeur.");
             t.play();
             microphone.initialize();
             oh.setVisible(true);
             break;
              case "fermer application":
          System.exit(0);
             break;
              default: if(!resultText.equalsIgnoreCase("lancer application"))
        
                  t.setTexte("commande inconnu");
              t.play();
              //resultText="";
             // t.muet();
              microphone.initialize();
              break;
                 
                }}else{
            t.setTexte("Veuillez vous identifier");
            t.play();
            microphone.initialize();
            
                
              }
            } else {
                System.out.println("Je ne peux pas vous entendre.\n");
            }
        }}
    
}
