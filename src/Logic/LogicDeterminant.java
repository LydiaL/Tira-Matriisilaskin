package Logic;

/**
 *
 * @author Lydia Lairala
 *
 * Luokka LogicDeterminant sisältää matriisien determinantin määrityksen
 * metodit.
 */
public class LogicDeterminant {

    /**
     * Metodi LUDecomposition tuottaa parametrina annetun matriisin
     * LU-hajotelman ja palauttaa arvonaan hajotelman U-matriisin, josta voidaan
     * laskea determinantti.
     *
     * @param matrix
     * @return double[][] matrixU
     */
    public double[][] LUDecomposition(double[][] matrix) {
        int n = matrix.length;
        // Luodaan ja alustetaan matriisit L ja U.
        double[][] matrixL = new double[n][n];
        double[][] matrixU = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixL[i][j] = 0;
                matrixU[i][j] = 0;
                if (i == j) {
                    matrixL[i][j] = 1;
                }
            }
        }
        // Lasketaan hajotelma L- ja U-matriiseihin syötematriisin avulla.
        for (int k = 0; k < n; k++) {
            Double luku = Double.valueOf(matrix[k][k]);
            matrixU[k][k] = Double.valueOf(luku);
            for (int i = k + 1; i < n; i++) {
                matrixL[k][i] = matrix[k][i] / matrixU[k][k];
                Double luku2 = Double.valueOf(matrix[i][k]);
                matrixU[i][k] = Double.valueOf(luku2);
            }
            for (int i = k + 1; i < n; i++) {
                for (int j = k + 1; j < n; j++) {
                    matrix[j][i] = matrix[j][i] - matrixL[k][i] * matrixU[j][k];
                }
            }
        }
        // Palautetaan hajotelman algoritmin tuottama U-matriisi.
        return matrixU;
    }

   
    /**
     * Metodi determinantU laskee hajotelman tuottamasta L-matriisista determinantin.
     *
     * @param matrix
     * @return double determinant
     */
    public double determinantU(double[][] matrix) {
        int n = matrix.length;
        // Lasketaan determinantti hajotelman U-matriisista.
        double determinant = matrix[0][0];
        for (int k = 1; k < n; k++) {
            determinant = determinant * matrix[k][k];
        }
        // Pyöristetään laskennassa käytetyistä epätarkoista liukuluvuista aiheutuvat ylimääräiset desimaalit.
        // Koska LU-hajotelmassa murtoluvut käsitellään epätarkkoina liukulukuina, on determinanttina
        // ilman pyöristystä usein 1.00000000000001 silloin kun todellinen determinantti on 1.
        String det = Double.toString(determinant);
        if (det.length() > 10) {
            if (det.charAt(12) == '0') {
                determinant = Math.round(determinant);
            }
        }
        return determinant;
    }

    /**
     * Metodi determinantRecursive laskee parametrina saadun matriisin
     * determinantin ja palauttaa determinantiksi saadun luvun.
     * Metodi on toimintatavaltaan yksinkertaisempi, mutta rekursiivisuudessaan
     * tehottomampi kuin yllä olevat pääasialliset determinantin määritykseen
     * käytettävät metodit. Se on tarkoitettu tehokkuustestauksen tarpeisiin.
     *
     * @param matrix
     * @return double determinant
     */
    public double determinantRecursive(double[][] matrix) {
        double determinant = 0;
        if (matrix.length > 2) {
            for (int k = 0; k < matrix.length; k++) {
                double[][] innerMatrix = new double[matrix.length - 1][matrix.length - 1];
                /* Määritetään sisempi matriisi */
                for (int i = 0; i < innerMatrix.length; i++) {
                    for (int j = 0; j < innerMatrix[0].length; j++) {
                        if (i < k) {
                            innerMatrix[i][j] = matrix[i][j + 1];
                        } else if (i >= k) {
                            innerMatrix[i][j] = matrix[i + 1][j + 1];
                        }
                    }
                }
                /* Lisätään tai vähennetään tulevasta determinantista käsiteltävällä alkiolla kerrottu sisemmän matriisin determinatti. */
                if (k % 2 == 0) {
                    determinant = determinant + (matrix[k][0] * determinantRecursive(innerMatrix));
                } else if (k % 2 == 1) {
                    determinant = determinant - (matrix[k][0] * determinantRecursive(innerMatrix));
                }
            }
        } else if (matrix.length == 2) {
            determinant = (matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1]);
        }
        return determinant;
    }
}
