/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package question_code;

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
public class triviaquestionTest {
    
    public triviaquestionTest() {
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
     * Test of checkAns method, of class triviaquestion.
     */
    @Test
    public void testCheckAns() {
        System.out.println("checkAns");
        double answer = 2;
        triviaquestion instance = new triviaquestion("ans0","ans1","ans2(the right one)","ans3","temp question 0",2);
        boolean expResult = true;
        boolean result = instance.checkAns(answer);
        assertEquals(expResult, result);

    }

    /**
     * Test of getOption method, of class triviaquestion.
     */
    @Test
    public void testGetOption() {
        System.out.println("getOption");
        int i = 0;
        triviaquestion instance = new triviaquestion("ans0","ans1","ans2(the right one)","ans3","temp question 0",2);
        String expResult = "ans0";
        String result = instance.getOption(i);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getQuestionText method, of class triviaquestion.
     */
    @Test
    public void testGetQuestionText() {
        System.out.println("getQuestionText");
        triviaquestion instance = new triviaquestion("ans0","ans1","ans2(the right one)","ans3","temp question 0",2);
        String expResult = "temp question 0";
        String result = instance.getQuestionText();
        assertEquals(expResult, result);
        
    }
    
}
