package eu.alik.mpr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void CreateTB(String Tabela) throws SQLException
                {
    if (!DBConnection.ShowTables(Tabela)){DBConnection.AddTables(Tabela);}
                }
    public static String  SelectDB() throws IOException, SQLException{
    System.out.println("Wybierz  Baze danych , lub wcisnij 4 by wrocic do menu  ");
      
         System.out.println("#1 :PSEUDOAD ");
         System.out.println("#2 :PSEUDOAD_ADMINI ");
         //System.out.println("#4 :Wrocic do menu ");
        String jeden = "PSEUDOAD";
        String dwa = "PSEUDOAD_ADMINI";
         InputStreamReader conv = new InputStreamReader(System.in);
        BufferedReader inNazwa = new BufferedReader(conv);
        String readNazwa = inNazwa.readLine();
            
            int IntReadNazwa = Integer.parseInt(readNazwa);
            switch (IntReadNazwa){
            case 1: 
                  
                   return jeden;

                case 2:
                 
                    return dwa;
                    case 4:
                
                    menu();
                     default: 
                    System.out.println("Wybierz 1 lub 2 lub 4  ");
                   SelectDB();
            }
        return null;
    }
    public static void View() throws IOException, SQLException{
    Users.ViewUsers(SelectDB());
    menu();
    }
    public static void ADDU() throws IOException, SQLException{
        Users.AddUser(SelectDB());
        menu();
      
    
    }
    public static void ReadInput() throws SQLException{
     InputStreamReader converter = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(converter);
        try {
            String read = in.readLine();
            try {
            int IntRead = Integer.parseInt(read);
                        switch (IntRead){
                case 1: 
                      System.out.println("Chcesz zobaczyc uzytkownikow ");
                    //System.out.println("Wybrales 1 ");
                    View();
                    break;
                case 2:
                      System.out.println("Chcesz dodac uzytkownika ");
                    //System.out.println("Wybrales 2 ");
                    ADDU();
                  break;
                case 3:
                        System.out.println("Chcesz Usunac uzytkownikow");
                    //System.out.println("Wybrales 3 ");
                     DBConnection.DropTABLE(SelectDB());
                      CreateTB("PSEUDOAD");
 CreateTB("PSEUDOAD_ADMINI");
 
                     menu();                   
                      break;
                case 4:
                      System.out.println("Pa-Pa ");
                      System.exit(0);
                              
                    break;
                default: 
                    System.out.println("Wybierz 1 , 2 ,3 lub 4  ");
                    menu();

            }
             
                     
            }
           catch(NumberFormatException nfe){
           System.out.println("Wybierz 1 , 2 ,3 lub 4  ");
                    menu();
                    
           }
            
       

             
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public static void  menu() throws IOException, SQLException{

        System.out.println("Menu : ");
        System.out.println("#1 : Wyswietl uzytkownikow");
        System.out.println("#2 : Dodaj uyztkownika");
        System.out.println("#3 : Wyczysc  uzytkownikow");
        System.out.println("#4 : Zakoncz Program");
        ReadInput();
            
        

    }
    
    public static void main( String[] args ) throws SQLException, IOException
    {
       
       
        DBConnection.Connect();

 //DBConnection.DropTABLE(two);
 //  DBConnection.DropTABLE(one);
//DBConnection.ShowTables(one);   

//if (!DBConnection.ShowTables(one)){
// DBConnection.AddTables(one);
//}
//if (!DBConnection.ShowTables(two)){
// DBConnection.AddTables(two);
//}
 //DBConnection.AddTables();
//DBConnection.test(null);
 CreateTB("PSEUDOAD");
 CreateTB("PSEUDOAD_ADMINI");
  
        menu();
//SelectDB();
//System.out.println(SelectDB());  
//  DBConnection.DropTABLE(two);
//    DBConnection.DropTABLE(one);
 
    }
}
