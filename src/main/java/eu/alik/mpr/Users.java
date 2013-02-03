/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.alik.mpr;

import java.beans.Statement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author allah
 */
public class Users {
    public static void ViewUsers(String NazwaBazy) throws IOException{
         
        Connection con;
 Statement statement;
 PreparedStatement preparedStatement;
 String Zapytanie =  "SELECT * FROM "+ NazwaBazy;
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/mpr","mpr","mpr");
            java.sql.Statement view = con.createStatement();
        ResultSet rs = view.executeQuery(Zapytanie);
        int i = 1 ;
        while(rs.next()){ 
        //rs.getObject("Imie");
        //System.out.println( new ResultSetDumper(rs ).toString() );
String imi = rs.getString("IMIE");
String naz = rs.getString("NAZWISKO");
System.out.println(i +" : "+ imi + " " + naz);
i++;
        }
        if (i==1){
        System.out.println("Nie ma uzytkownikow;/ ");
        }
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    public static void AddUser(String NazwaBazy) throws IOException{
    System.out.println("Dodaje userka:) ");
 InputStreamReader input = new InputStreamReader(System.in);
 BufferedReader reader = new BufferedReader(input); 
   System.out.print("Podaj Imie : ");
 String imie1 = (reader.readLine()).toString();
 System.out.print("Podaj Nazwisko : ");
 String nazwisko1 = (reader.readLine()).toString();
  System.out.print("Podaj Ha-Szlo : ");
 String haslo1 = (reader.readLine()).toString();
 
 Connection con;
 Statement statement;
  PreparedStatement preparedStatement;
  String Q = "" ;
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/mpr","mpr","mpr");
         if ("PSEUDOAD".equals(NazwaBazy)){
           Q = ("INSERT INTO PSEUDOAD " + "VALUES ('" + imie1+ "','" +nazwisko1+"','"+haslo1+"')");
         }
          if ("PSEUDOAD_ADMINI".equals(NazwaBazy)){
           Q = ("INSERT INTO PSEUDOAD_ADMINI "+ "VALUES ('" + imie1+ "','" +nazwisko1+"','"+haslo1+"')");
         }
          java.sql.Statement sta = con.createStatement();
   int dodaaajGGGGGooo = sta.executeUpdate(Q);
 
            con.commit();
  con.close();
  System.out.println("Pomyslnie dodalem :"+ imie1);
            
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }
     
      
    
    }
    
    
}
