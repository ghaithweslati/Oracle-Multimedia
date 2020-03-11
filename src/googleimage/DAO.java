/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package googleimage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;
import oracle.ord.im.OrdImage;
import oracle.ord.im.OrdImageSignature;

/**
 *
 * @author ASUS
 */
public class DAO {
    
    private String login;
    public DAO() {
    }
    
    public DAO(String login) {
    this.login=login;
    }
    
    public OrdImage getImage(Image image){ 
     try 
     {
        Connection conn=new singletonConnection().getConnection();
        conn.setAutoCommit(false);
        Statement stmt = conn.createStatement();
        String sql = "select i.image from utilisateur u, table(u.images) i WHERE i.id="+image.getId()+" FOR UPDATE";
        OracleResultSet rset =(OracleResultSet) stmt.executeQuery(sql);
        OrdImage imgObj = null;
        if(rset.next()) 
            imgObj =(OrdImage) rset.getORAData(1, OrdImage.getORADataFactory());
        stmt.close();
        conn.close();
        return imgObj;        
        }
     catch(SQLException e) {
         e.printStackTrace(); }
         return null;
     }
    
    
    
       public ArrayList<OrdImage>  getImages(String cle){ 
        try {
            ArrayList<OrdImage> lstImage  = new ArrayList<OrdImage>();
            Connection conn=new singletonConnection().getConnection();
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            String sql = "SELECT  i.image from utilisateur u, table(u.images) i FOR UPDATE";
            OracleResultSet rset =(OracleResultSet) stmt.executeQuery(sql);
            OrdImage imgObj = null;
            while(rset.next()) 
            {
                imgObj =(OrdImage) rset.getORAData(1, OrdImage.getORADataFactory());
                if(imgObj.getSource().contains(cle))
                      lstImage.add(imgObj);
            } 
            stmt.close();
            conn.close();
                 return lstImage;
            
        } catch(SQLException e) { e.printStackTrace(); }
         return null;
     }
       
       
    public void generer(Image image) {
    try 
    {
        Connection conn=new singletonConnection().getConnection();
        conn.setAutoCommit(false);
        Statement stmt = conn.createStatement();
        String sql = "UPDATE TABLE(select images from utilisateur where login ='"+login+"') SET signature=ORDSYS.ORDImageSignature.init() where id="+image.getId();
        stmt.execute(sql);
        String sql2 = "SELECT image FROM TABLE(select images from utilisateur where login ='"+login+"') where id="+image.getId()+"  FOR UPDATE";
        OracleResultSet rset =(OracleResultSet) stmt.executeQuery(sql2);
        OrdImage imgObj = null;
        if(rset.next()) 
        {
            imgObj =(OrdImage) rset.getORAData(1, OrdImage.getORADataFactory());
            String sql3 = "SELECT signature FROM TABLE(select images from utilisateur where login ='"+login+"') where id="+image.getId()+"   FOR UPDATE";
            OracleResultSet rset2 = (OracleResultSet) stmt.executeQuery(sql3);
            OrdImageSignature imgSig = null;
            if(rset2.next()) 
            {
                imgSig = (OrdImageSignature) rset2.getORAData(1, OrdImageSignature.getORADataFactory());
                imgSig.generateSignature(imgObj);
                String sql4 = "UPDATE TABLE(select images from utilisateur where login ='"+login+"') SET signature = ? where id="+image.getId();
                OraclePreparedStatement update_sig = (OraclePreparedStatement)
                conn.prepareCall(sql4);
                update_sig.setORAData(1,imgSig);
                update_sig.execute( );
                update_sig.close();
                conn.commit();
            }
        }
        conn.setAutoCommit(true);
        conn.commit();
        stmt.close();
        conn.close(); 
        }catch(SQLException e) { e.printStackTrace() ;}
    }
    
    
     public  ArrayList<Image> allid(Image image,String commande) {    
    try 
    {
        Connection conn=new singletonConnection().getConnection();
        conn.setAutoCommit(false);
        Statement stmt = conn.createStatement();
        String sql0 = "select i.id from utilisateur u, table(u.images) i";
        OracleResultSet rset0 = (OracleResultSet) stmt.executeQuery(sql0);
        ArrayList<Image> lstImage = new  ArrayList<Image>();
        while(rset0.next())
        {
            String id=rset0.getString("id");
            Image img = comparer(id,image,commande);
            if(img!=null)
                lstImage.add(img);
        }
        return lstImage;
    } catch(SQLException e) { 
        e.printStackTrace() ;}        
        return null;
    }
     
     
     
    public  String getLogin(String email,String password) {    
    try 
    {
        Connection conn=new singletonConnection().getConnection();
        conn.setAutoCommit(false);
        Statement stmt = conn.createStatement();
        String sql0 = "select login from utilisateur where adresse='"+email+"' and password='"+password+"'";
        OracleResultSet rset0 = (OracleResultSet) stmt.executeQuery(sql0);
        if(rset0.next())
            return rset0.getString("login");;
    } catch(SQLException e) { 
        e.printStackTrace() ;}        
        return null;
    }
         
    
    
    
    
    public Image comparer(String id,Image image,String commande) throws SQLException
    {   
        
       
        Connection conn=new singletonConnection().getConnection();
        String sql = "select i.signature from utilisateur u, table(u.images) i WHERE i.id = "+image.getId()+" or id = "+id+" FOR UPDATE";
        Statement stmt = conn.createStatement();
        OracleResultSet rset = (OracleResultSet) stmt.executeQuery(sql);
        OrdImageSignature signature1 = null;
        OrdImageSignature signature2 = null;
        if(rset.next()) {
            signature1 = (OrdImageSignature) rset.getORAData(1, OrdImageSignature.getORADataFactory());
            if(rset.next()) 
            {
                signature2 = (OrdImageSignature) rset.getORAData(1, OrdImageSignature.getORADataFactory());
                 
                    float f = OrdImageSignature.evaluateScore(signature1, signature2,commande);
                    float seuil = 20;
                    int similaire = OrdImageSignature.isSimilar(signature1,signature2, commande,seuil); 
                    if(similaire==1 && f==0)
                        f=100;
                        return new Image(id,f);
            }
        }
        return null;    
    }
    
    
    public  void ajouter(Image image) throws SQLException{
        Connection conn=new singletonConnection().getConnection();
        conn.setAutoCommit(false);
        String sql0 = "insert into TABLE(select images from utilisateur where login ='"+login+"') values (timage("+image.getId()+", ORDSYS.ORDImage.init(),ORDSYS.ORDImageSignature.init()))";
       Statement stmt = conn.createStatement();
        stmt.execute(sql0);
        String sql = "UPDATE TABLE(select images from utilisateur where login ='"+login+"') SET image=ORDSYS.ORDImage.init() where id="+image.getId();
        Statement stmt2 = conn.createStatement();
        stmt2.execute(sql);
        String sql2 = "SELECT image FROM TABLE(select images from utilisateur where login ='"+login+"') where id="+image.getId()+" FOR UPDATE ";
        OracleResultSet rset=(OracleResultSet) stmt.executeQuery(sql2);
        if( rset.next()) {
        OrdImage imgObj = (OrdImage) rset.getORAData(1, OrdImage.getORADataFactory() );
         try{             
            imgObj.loadDataFromFile(image.getImage());                      
        }
        catch (IOException e){ e.printStackTrace(); }
        imgObj.setProperties();
        imgObj.setSource("File", image.getImage(), image.getImage());
        if(imgObj.checkProperties()) 
        {
            String sql3 = "UPDATE TABLE(select images from utilisateur where login ='"+login+"') SET image=? where id="+image.getId();
            OraclePreparedStatement pstmt = (OraclePreparedStatement) conn.prepareStatement(sql3);
            pstmt.setORAData(1, imgObj);
            pstmt.execute();
            pstmt.close();
            conn.commit();
            stmt.close();
            conn.setAutoCommit(true);   
        }
         generer(image);
         conn.commit(); 
    }
    }
    
    
    
    public  void inscrire(String login,String adresse,String password) throws SQLException{
        Connection conn=new singletonConnection().getConnection();
        conn.setAutoCommit(false);
        String sql0 = "insert into utilisateur values('"+login+"','"+adresse+"','"+password+"',timages())";
        Statement stmt = conn.createStatement();
        stmt.execute(sql0);
        conn.commit(); 
    }
}
