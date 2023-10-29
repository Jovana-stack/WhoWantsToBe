/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package question_code;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nicet
 */
public class QuestionGenTest {
    
    public QuestionGenTest() {
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
     * Test of Genquestion method, of class QuestionGen.
     */
    @Test
    public void testGenquestion() {
        System.out.println("Genquestion");
        
        ArrayList<Question> resultlist = QuestionGen.Genquestion();
        int result= resultlist.size();
        
        assertEquals(15, result);
        
    }
    
}
