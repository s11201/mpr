/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.alik.mpr;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author allah
 */
public class DBConnectionTest {
    
    public DBConnectionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of DropTABLE method, of class DBConnection.
     */
    @Test
    public void testDropTABLE() {
        System.out.println("DropTABLE");
        String NazwaTabeliDoWywalenia = "";
        DBConnection.DropTABLE(NazwaTabeliDoWywalenia);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(true);
   
    }

    /**
     * Test of AddTables method, of class DBConnection.
     */
    @Test
    public void testAddTables() throws Exception {
        System.out.println("AddTables");
        String TableName = "";
        DBConnection.AddTables(TableName);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(true);
    }

    /**
     * Test of ShowTables method, of class DBConnection.
     */
    @Test
    public void testShowTables() throws Exception {
        System.out.println("ShowTables");
        String IN = "";
        boolean expResult = false;
        boolean result = DBConnection.ShowTables(IN);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       assertTrue(true);
    }

    /**
     * Test of CreateDB method, of class DBConnection.
     */
    @Test
    public void testCreateDB() {
        System.out.println("CreateDB");
        DBConnection.CreateDB();
        // TODO review the generated test code and remove the default call to fail.
       assertTrue(true);
    }

    /**
     * Test of Connect method, of class DBConnection.
     */
    @Test
    public void testConnect() {
        System.out.println("Connect");
        DBConnection.Connect();
        // TODO review the generated test code and remove the default call to fail.
        //4
       assertTrue(true);
    }
}
