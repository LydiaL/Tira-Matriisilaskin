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
 * Luokka LogicMultiplyTest on yksikkötestiluokka, joka testaa matriisien kertolaskumetodia multiply.
 */
public class LogicMultiplyTest {

    public LogicMultiplyTest() {
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
    public void testMultiply() {
        Logic testlogic = new Logic();
        double[][] matrixA = new double[2][3];
        double[][] matrixB = new double[3][2];
        matrixA[0][0] = 2;
        matrixA[0][1] = 1;
        matrixA[0][2] = 4;
        matrixA[1][0] = 3;
        matrixA[1][1] = 4;
        matrixA[1][2] = 3;
        matrixB[0][0] = 2;
        matrixB[0][1] = 4;
        matrixB[1][0] = 2;
        matrixB[1][1] = 4;
        matrixB[2][0] = 4;
        matrixB[2][1] = 2;
        double[][] matrix = testlogic.multiply(matrixA, matrixB);
        double actual = matrix[1][1];
        double expected = 18;
        assertTrue(actual == expected);
    }
}
