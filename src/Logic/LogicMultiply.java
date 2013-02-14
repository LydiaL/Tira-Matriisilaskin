package Logic;

/**
 *
 * @author Lydia Lairala
 * 
 * Luokka LogicMultiply sisältää matriisien kertolaskun metodin.
 */
public class LogicMultiply {

    /**
     * Metodi multiply laskee parametrina saatujen matriisien kertolaskun ja
     * palauttaa matriisin A sarakkeiden ja matriisin B rivien pistetuloista
     * saadun tulomatriisin. Metodi olettaa parametreina annettujen matriisin A
     * sarakkeiden ja matriisin B rivien lukumäärän olevan sama.
     *
     * @param matrixA
     * @param matrixB
     * @return resultMatrix
     */
    public double[][] multiply(double[][] matrixA, double[][] matrixB) {
        double[][] resultMatrix = new double[matrixB.length][matrixA[0].length];
        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[0].length; j++) {
                resultMatrix[i][j] = 0;
                for (int k = 0; k < matrixA.length; k++) {
                    resultMatrix[i][j] = resultMatrix[i][j] + (matrixA[k][j] * matrixB[i][k]);
                }
            }
        }
        return resultMatrix;
    }
}
