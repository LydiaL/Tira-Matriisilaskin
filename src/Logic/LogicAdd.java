package Logic;

/**
 *
 * @author Lydia Lairala
 *
 * Luokka LogicAdd sisältää matriisien yhteenlaskun metodin.
 */
public class LogicAdd {

    /**
     * Metodi add laskee kahden parametrina saadun matriisin alkiot yhteen
     * asettaen ne uuteen tulosmatriisiin ja palauttaa tulosmatriisin. Metodi
     * olettaa parametreina annettujen matriisien olevan aina samantyyppiset.
     *
     * @param matrixA
     * @param matrixB
     * @return resultMatrix
     */
    public double[][] add(double[][] matrixA, double[][] matrixB) {
        double[][] resultMatrix = new double[matrixA.length][matrixA[0].length];
        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[0].length; j++) {
                resultMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        return resultMatrix;
    }
}
