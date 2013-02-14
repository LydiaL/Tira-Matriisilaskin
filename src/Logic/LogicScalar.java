package Logic;

/**
 *
 * @author Lydia Lairala
 * 
 * Luokka LogicScalar sisältää matriisien skalaarikertolaskun metodin.
 */
public class LogicScalar {

    /**
     * Metodi scalar laskee parametrina saadun matriisin ja skalaarin
     * skalaaritulon kertomalla kaikki matriisin alkiot skalaarilla ja palauttaa
     * tulosmatriisin.
     *
     * @param matrix
     * @param scalar
     * @return double[][] matrix
     */
    public double[][] scalar(double[][] matrix, double scalar) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = matrix[i][j] * scalar;
            }
        }
        return matrix;
    }
}
