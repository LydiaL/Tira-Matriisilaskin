/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Logic.Logic;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lytty
 */
public class LogicSumTest {
    
    public LogicSumTest() {
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

        @Test
    public void testSumRow() {
        Logic testlogic = new Logic();
        double[][] matrix = new double[2][3];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 1;
        matrix[1][0] = 1;
        matrix[1][1] = 3;
        matrix[1][2] = 1;
        double actual = testlogic.sumRow(matrix, 1, -1);
        double expected = matrix[0][1] + matrix[1][1];
        assertTrue(actual == expected);
    }
}
