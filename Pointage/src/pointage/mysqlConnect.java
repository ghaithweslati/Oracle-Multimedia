/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pointage;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author AlassaneOusmane
 */
public class mysqlConnect {
  Connection conn;
  public static Connection ConnectionDB(){

try{
    Class.forName("com.mysql.jdbc.Driver"); 
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/pointage","root","");
//JOptionPane.showMessageDialog(null, "connection établie");


return conn;
}
catch(Exception e){
    JOptionPane.showMessageDialog(null, "erreur connexion: "+e);
    return null;
}
}
}
