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
 * Luokka LogicDeterminantTest on yksikkötestiluokka, joka testaa matriisien determinantinmääritysmetodeita
 * determinantLU ja determinantSimple.
 */
public class LogicDeterminantTest {

    public LogicDeterminantTest() {
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
    public void testDeterminant2x2withSimpleMethod() {
        Logic testlogic = new Logic();
        double[][] matrix = new double[2][2];
        matrix[0][0] = 14;
        matrix[0][1] = 22;
        matrix[1][0] = 3;
        matrix[1][1] = 7;
        double actual = testlogic.determinantRecursive(matrix);
        double expected = 32;
        assertTrue(actual == expected);
    }

    @Test
    public void testDeterminant5x5withSimpleMEthod() {
        Logic testlogic = new Logic();
        double[][] matrix = new double[5][5];
        matrix[0][0] = 1;
        matrix[0][1] = 0;
        matrix[0][2] = 1;
        matrix[0][3] = 0;
        matrix[0][4] = 1;
        matrix[1][0] = 1;
        matrix[1][1] = 4;
        matrix[1][2] = 5;
        matrix[1][3] = 6;
        matrix[1][4] = 1;
        matrix[2][0] = 10;
        matrix[2][1] = 0;
        matrix[2][2] = 1;
        matrix[2][3] = 0;
        matrix[2][4] = 10;
        matrix[3][0] = 1;
        matrix[3][1] = 7;
        matrix[3][2] = 8;
        matrix[3][3] = 9;
        matrix[3][4] = 1;
        matrix[4][0] = 1;
        matrix[4][1] = 2;
        matrix[4][2] = -1;
        matrix[4][3] = 2;
        matrix[4][4] = 1;
        double actual = testlogic.determinantRecursive(matrix);
        double expected = 0;
        assertTrue(actual == expected);
    }

    @Test
    public void testDeterminant2x2withLUDecomposition() {
        Logic testlogic = new Logic();
        double[][] matrix = new double[2][2];
        matrix[0][0] = 14;
        matrix[0][1] = 22;
        matrix[1][0] = 3;
        matrix[1][1] = 7;
        double actual = testlogic.determinantLU(matrix);
        double expected = 32;
        assertTrue(actual == expected);
    }

    @Test
    public void testDeterminant5x5withLUDecomposition() {
        Logic testlogic = new Logic();
        double[][] matrix = new double[5][5];
        matrix[0][0] = 1;
        matrix[0][1] = 0;
        matrix[0][2] = 1;
        matrix[0][3] = 0;
        matrix[0][4] = 1;
        matrix[1][0] = 1;
        matrix[1][1] = 4;
        matrix[1][2] = 5;
        matrix[1][3] = 6;
        matrix[1][4] = 1;
        matrix[2][0] = 10;
        matrix[2][1] = 0;
        matrix[2][2] = 1;
        matrix[2][3] = 0;
        matrix[2][4] = 10;
        matrix[3][0] = 1;
        matrix[3][1] = 7;
        matrix[3][2] = 8;
        matrix[3][3] = 9;
        matrix[3][4] = 1;
        matrix[4][0] = 1;
        matrix[4][1] = 2;
        matrix[4][2] = -1;
        matrix[4][3] = 2;
        matrix[4][4] = 1;
        double actual = testlogic.determinantLU(matrix);
        double expected = 0;
        assertTrue(actual == expected);
    }
}
