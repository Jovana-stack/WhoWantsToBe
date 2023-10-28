/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package question_code;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jovan
 */
public class triviaquestionTest {
    
    public triviaquestionTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of checkAns method, of class triviaquestion.
     */
    @Test
    public void testCheckAns() {
        System.out.println("checkAns");
        double answer = 0.0;
        triviaquestion instance = null;
        boolean expResult = false;
        boolean result = instance.checkAns(answer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOption method, of class triviaquestion.
     */
    @Test
    public void testGetOption() {
        System.out.println("getOption");
        int i = 0;
        triviaquestion instance = null;
        String expResult = "";
        String result = instance.getOption(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuestionText method, of class triviaquestion.
     */
    @Test
    public void testGetQuestionText() {
        System.out.println("getQuestionText");
        triviaquestion instance = null;
        String expResult = "";
        String result = instance.getQuestionText();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
