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
 * @author Lydia Lairala
 */
public class LogicMeanTest {

    public LogicMeanTest() {
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
    public void testMeanAll() {
        Logic testlogic = new Logic();
        double[][] matrix = new double[3][3];
        matrix[0][0] = 6;
        matrix[0][1] = 8;
        matrix[0][2] = 6;
        matrix[1][0] = -2;
        matrix[1][1] = 3;
        matrix[1][2] = 6;
        matrix[2][0] = 10;
        matrix[2][1] = 8;
        matrix[2][2] = 9;
        double actual = testlogic.meanAll(matrix);
        double expected = 6;
        assertTrue(actual == expected);
    }

    @Test
    public void testMeanRow() {
        Logic testlogic = new Logic();
        double[][] matrix = new double[2][3];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 1;
        matrix[1][0] = 1;
        matrix[1][1] = 3;
        matrix[1][2] = 1;
        double actual = testlogic.meanRow(matrix, 1, -1);
        double expected = (matrix[0][1] + matrix[1][1]) / 2;
        assertTrue(actual == expected);
    }
}
