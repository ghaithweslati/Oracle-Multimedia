/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pointage;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.util.props.ConfigurationManager;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author AlassaneOusmane
 */
public class MatiereJFrame extends javax.swing.JFrame {
Connection conn=null;
PreparedStatement requete=null;
ResultSet resultat=null;
private void Majtable(){

String sql="SELECT * FROM   matiere";
        try {
            requete=(PreparedStatement) conn.prepareStatement(sql);
            resultat=requete.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(resultat));
          
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
           
        }


}
    /**
     * Creates new form MatiereJFrame
     */
    public MatiereJFrame() {
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

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmtajoutmatiere = new javax.swing.JButton();
        txtcode = new javax.swing.JTextField();
        txtlibelle = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cmdmodifiermatiere = new javax.swing.JButton();
        cmdsuppmatiere = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 102));
        setForeground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tarzan", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Gestion Matiere");

        jLabel2.setText("Code Matiere :");

        cmtajoutmatiere.setText("Ajout");
        cmtajoutmatiere.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmtajoutmatiereMouseClicked(evt);
            }
        });

        jLabel3.setText("Libelle Matiere :");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "code_Matiere", "libelle_Matiere"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        cmdmodifiermatiere.setText("Modifier");
        cmdmodifiermatiere.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdmodifiermatiereMouseClicked(evt);
            }
        });

        cmdsuppmatiere.setText("Supprimer");
        cmdsuppmatiere.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdsuppmatiereMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtcode, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmtajoutmatiere)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmdmodifiermatiere)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmdsuppmatiere))
                                    .addComponent(txtlibelle, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(14, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(txtlibelle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmtajoutmatiere)
                            .addComponent(cmdsuppmatiere)
                            .addComponent(cmdmodifiermatiere))
                        .addGap(23, 23, 23))))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-790)/2, (screenSize.height-262)/2, 790, 262);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
 this.setBackground(Color.yellow);
        conn=   (Connection) mysqlConnect.ConnectionDB();  
Majtable();
// TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void cmtajoutmatiereMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmtajoutmatiereMouseClicked
        // TODO add your handling code here:
        String sql="INSERT INTO `pointage`.`matiere` (`CODE_MATIERE`, `ENTITULE`) VALUES (?, ?);";
        try {
            requete=(PreparedStatement) conn.prepareStatement(sql);
            requete.setString(1, txtcode.getText());
            requete.setString(2, txtlibelle.getText());
            requete.execute();
            
            JOptionPane.showMessageDialog(null, "ajouté");
            Majtable();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex); }
    }//GEN-LAST:event_cmtajoutmatiereMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int ligne=jTable1.getSelectedRow();
        txtcode.setText(jTable1.getModel().getValueAt(ligne, 0).toString());
        txtlibelle.setText(jTable1.getModel().getValueAt(ligne, 1).toString());
        
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void cmdmodifiermatiereMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdmodifiermatiereMouseClicked
        // TODO add your handling code here:
          String sql="UPDATE  `pointage`.`matiere` SET  CODE_MATIERE=?, `ENTITULE` =  ? "+
" WHERE  `MATIERE`.`CODE_MATIERE` ='"+txtcode.getText()+"';";
        try {
            requete=(PreparedStatement) conn.prepareStatement(sql);
            requete.setString(1, txtcode.getText());
           
            requete.setString(2, txtlibelle.getText());
         
            requete.executeUpdate();
            Majtable();
            JOptionPane.showMessageDialog(null, "Mise à jour réussie!");
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
        } 
        
       
    }//GEN-LAST:event_cmdmodifiermatiereMouseClicked

    private void cmdsuppmatiereMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdsuppmatiereMouseClicked
        // TODO add your handling code here:
         String sql="DELETE FROM pointage.matiere WHERE matiere.code_matiere ='"+txtcode.getText()+"';";
        try {
            requete=(PreparedStatement) conn.prepareStatement(sql);
        requete.execute();
            Majtable();
            JOptionPane.showMessageDialog(null, "Suppréssion réussie!");
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
        } 
    }//GEN-LAST:event_cmdsuppmatiereMouseClicked

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowStateChanged

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
            java.util.logging.Logger.getLogger(MatiereJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MatiereJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MatiereJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MatiereJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MatiereJFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdmodifiermatiere;
    private javax.swing.JButton cmdsuppmatiere;
    private javax.swing.JButton cmtajoutmatiere;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtcode;
    private javax.swing.JTextField txtlibelle;
    // End of variables declaration//GEN-END:variables
}
