/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package gamestates;

import gui_Assignment.Game;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.io.IOException;
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
public class playingTest {
    
    public playingTest() {
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
     * Test of getQuestionNum method, of class playing.
     */
    @Test
    public void testGetQuestionNum() throws IOException {
        System.out.println("getQuestionNum");
        Game g = new Game();        
        playing instance = g.getPlaying();
        int expResult = 0;
        int result = instance.getQuestionNum();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getskipUsed method, of class playing.
     */
    @Test
    public void testGetskipUsed() throws IOException {
        System.out.println("getskipUsed");
        Game g = new Game();
        playing instance = g.getPlaying();
        boolean expResult = false;
        boolean result = instance.getskipUsed();
        assertEquals(expResult, result);
    }
    
}
