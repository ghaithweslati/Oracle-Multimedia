/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package googleimage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class singletonConnection {
    
    public Connection getConnection() throws SQLException
    {
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","system","system");
        return conn;
    }
    
}
