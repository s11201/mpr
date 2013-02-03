/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.alik.mpr;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author allah
 */


public class DBConnection {
  
public static void  DropTABLE(String NazwaTabeliDoWywalenia){
Connection con;
 Statement statement;
  PreparedStatement preparedStatement;
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/mpr","mpr","mpr");
            java.sql.Statement sta = con.createStatement();
String DropString =("DROP TABLE " + NazwaTabeliDoWywalenia);
  int dropIt = sta.executeUpdate(DropString);
  //System.out.println("I juz nie ma "+ NazwaTabeliDoWywalenia);
  
            
        } catch (SQLException ex) {
           // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("Nie udalo mi sie dropna tabeli "+ NazwaTabeliDoWywalenia);
        }

}




 public static void AddTables(String TableName) throws SQLException{
    // System.out.println("Nazwa tabeli do dodania to : "+ TableName);    
    String QueryString = " " ;
     if (TableName == "PSEUDOAD"){
      QueryString =("CREATE TABLE PSEUDOAD ( Imie VARCHAR(20),Nazwisko VARCHAR(20),Haslo VARCHAR(20) )");
     }
     if (TableName =="PSEUDOAD_ADMINI"){
      QueryString =("CREATE TABLE PSEUDOAD_ADMINI ( Imie VARCHAR(20),Nazwisko VARCHAR(20),Haslo VARCHAR(20) )");

     }
  Connection con;
 Statement statement;
  PreparedStatement preparedStatement;
  try{
  con = DriverManager.getConnection("jdbc:derby://localhost:1527/mpr","mpr","mpr");

java.sql.Statement sta = con.createStatement();
  int go = sta.executeUpdate(QueryString);
System.out.println("Dodalem Tabele" + TableName);
sta.close();


con.close();  
  }
  
  
  catch(SQLException ex){
  System.out.println("Nie udalo mi sie stworzyc tabel");
 
  }
//con.close();
 }
    
    
    
    
    
    
    
public static boolean  ShowTables(String IN) throws SQLException {
 Connection con;
    Statement statement;
    PreparedStatement preparedStatement;
 con = DriverManager.getConnection("jdbc:derby://localhost:1527/mpr","mpr","mpr");
 DatabaseMetaData dbmd = con.getMetaData();
//ResultSet resultSet = dbmd.getTables(null, null, "PseudoAD", null); 
ResultSet resultSet = dbmd.getTables(null, null, "%", null); 
 int i = 0 ;
while (resultSet.next()) {
    String strTableName = resultSet.getString("TABLE_NAME");
            if (IN.equals(strTableName))
            { i=1; }
           
   // System.out.println("TABLE_NAME is " + strTableName);
   

}
if (i==1){
            return true;
}
else{
        return false;
    }
     
}    
 

   
    
 
  public static void CreateDB(){
   System.out.println("Tworze DB");
    
   Connection con;
    Statement statement;
    PreparedStatement preparedStatement;
    try {
        
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/mpr;create=true;user=mpr;password=mpr");
         con.close();
        } catch (SQLException ex) {
         
        System.out.println("Nie udalo mi sie stworzyc bazy ... ;/ ");
        }
  }
  public static void Connect(){
    Connection con;
    Statement statement;
    PreparedStatement preparedStatement;
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/mpr","mpr","mpr");
            System.out.println("Halo Baza, slyszysz mnie ? ");
            System.out.println("... Slysze :P");
            con.close();
        } catch (SQLException ex) {
        System.out.println("Nie udalo sie podlaczyc, widocznie baza nie istnieje  ,Tworze Baze");
        CreateDB();
        }
        
        
    
  }
}
