/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pointage;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import t2s.son.LecteurTexte;

/**
 *
 * @author AlassaneOusmane
 */
public class AbsenceEmployersJFrame1 extends javax.swing.JFrame {
 Connection conn=null;
PreparedStatement requete=null;
ResultSet resultat=null;
public static String Matricule_p=null,hr_d="08:00",hr_fin="18:00";
Date dateabs=new Date();
private void Majtable(){

String sql="SELECT  personnel.matricule_personnel,nom, prenom, libelle as fonction"+
"  FROM personnel, privilege"+
" WHERE personnel.id_privilege = privilege.id_privilege"+
" AND privilege.libelle <>'professeur'";
        try {
            requete=(PreparedStatement) conn.prepareStatement(sql);
            resultat=requete.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(resultat));
           
          
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
           
        }
}
    /**
     * Creates new form AbsenceEmployersJFrame1
     */
    public AbsenceEmployersJFrame1() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        motif = new javax.swing.JTextArea();
        ajoutabsence = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        aujourdhui = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        motif.setColumns(20);
        motif.setFont(new java.awt.Font("Monospaced", 2, 14)); // NOI18N
        motif.setForeground(new java.awt.Color(0, 51, 255));
        motif.setRows(5);
        motif.setText("pas de motif !");
        jScrollPane1.setViewportView(motif);

        ajoutabsence.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pointage/images/marquer.jpg"))); // NOI18N
        ajoutabsence.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ajoutabsenceMouseClicked(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jLabel1.setForeground(new java.awt.Color(249, 3, 3));
        jLabel1.setText("Marquer Absent");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ajoutabsence, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(37, 37, 37)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(aujourdhui, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(aujourdhui, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(440, 440, 440))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(189, 189, 189))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(ajoutabsence, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-838)/2, (screenSize.height-523)/2, 838, 523);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
     
         jTable1.clearSelection();
        ajoutabsence.setVisible(false);
        motif.setVisible(false);
        conn=(Connection) mysqlConnect.ConnectionDB();
          Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder dateactuelle=new StringBuilder(sdf.format(date));
        aujourdhui.setText(" Aujourd'hui le :   "+dateactuelle);
      
        Majtable();
    }//GEN-LAST:event_formWindowOpened

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
         ajoutabsence.setVisible(true);
        motif.setVisible(true);
        int ligne=jTable1.getSelectedRow();
        Matricule_p=jTable1.getModel().getValueAt(ligne, 0).toString();
      
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void ajoutabsenceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ajoutabsenceMouseClicked
        // TODO add your handling code here:
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        StringBuilder dateactuelle=new StringBuilder(sdf.format(date));
          String sql="INSERT INTO `pointage`.`absence` (`MATRICULE_PERSONNEL`, `HR_DEBUT`, `HR_FIN`, `MOTIF`, `DATE_ABSENCE`) VALUES ( ?, ?,?, ?, ?);";
        try {
            requete=(PreparedStatement) conn.prepareStatement(sql);
       
            requete.setString(1, Matricule_p);
            requete.setString(2, hr_d);
            requete.setString(3, hr_fin);
            requete.setString(4, motif.getText());
            requete.setString(5, dateactuelle.toString());
            requete.execute();
            Majtable();
            JOptionPane.showMessageDialog(null, "Ajouté");
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_ajoutabsenceMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AbsenceEmployersJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AbsenceEmployersJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AbsenceEmployersJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AbsenceEmployersJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AbsenceEmployersJFrame1().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajoutabsence;
    private javax.swing.JLabel aujourdhui;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea motif;
    // End of variables declaration//GEN-END:variables
}
