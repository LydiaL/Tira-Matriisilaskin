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
 * 
 * Luokka LogicAddTest on yksikkötestiluokka, joka testaa matriisien yhteenlaskumetodia add.
 */
public class LogicAddTest {

    public LogicAddTest() {
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
    public void testAdd() {
        Logic testlogic = new Logic();
        double[][] matrixA = new double[2][2];
        double[][] matrixB = new double[2][2];
        matrixA[0][0] = 4;
        matrixA[0][1] = 5;
        matrixA[1][0] = 6;
        matrixA[1][1] = 7;
        matrixB[0][0] = 8;
        matrixB[0][1] = 7;
        matrixB[1][0] = 6;
        matrixB[1][1] = 5;
        double[][] matrix = testlogic.add(matrixA, matrixB);
        double actual = matrix[0][0];
        double expected = matrixA[0][0] + matrixB[0][0];
        assertTrue(actual == expected);
    }
}
