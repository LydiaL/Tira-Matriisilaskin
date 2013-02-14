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
 * Luokka LogicScalarTest on yksikkötestiluokka, joka testaa matriisin skalaarikertolaskumetodia scalar.
 */
public class LogicScalarTest {

    public LogicScalarTest() {
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
    public void testScalar() {
        Logic testlogic = new Logic();
        double[][] matrix = new double[1][2];
        matrix[0][0] = 2;
        matrix[0][1] = 1;
        double[][] result = testlogic.scalar(matrix, -2);
        double actual = result[0][0];
        double expected = -4;
        assertTrue(actual == expected);
    }
}
