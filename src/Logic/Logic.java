package Logic;

/**
 *
 * @author Lairala
 *
 * Luokka Logic mallintaa laskimen laskutoimituksia suorittavan logiikan.
 */
public class Logic {

    /**
     * Metodi add laskee kahden parametrina saadun matriisin alkiot yhteen
     * asettaen ne uuteen tulosmatriisiin ja palauttaa tulosmatriisin. Metodi
     * olettaa parametreina annettujen matriisien olevan aina samantyyppiset.
     *
     * @param matrixA
     * @param matrixB
     * @return matrix
     */
    public double[][] add(double[][] matrixA, double[][] matrixB) {
        double[][] matrix = new double[matrixA.length][matrixA[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        return matrix;
    }

    /**
     * Metodi multiply laskee parametrina saatujen matriisien kertolaskun ja
     * palauttaa matriisin A sarakkeiden ja matriisin B rivien pistetuloista
     * saadun tulomatriisin. Metodi olettaa parametreina annettujen matriisin A
     * sarakkeiden ja matriisin B rivien lukumäärän olevan sama.
     *
     * @param matrixA
     * @param matrixB
     * @return determinant
     */
    public double[][] multiply(double[][] matrixA, double[][] matrixB) {
        double[][] matrix = new double[matrixB.length][matrixA[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
                for (int k = 0; k < matrixA.length; k++) {
                    matrix[i][j] = matrix[i][j] + (matrixA[k][j] * matrixB[i][k]);
                }
            }
        }
        return matrix;
    }

    /**
     * Metodi scalar laskee parametrina saadun matriisin ja skalaarin
     * skalaaritulon kertomalla kaikki matriisin alkiot skalaarilla ja palauttaa
     * tulosmatriisin.
     *
     * @param matrix
     * @param scalar
     * @return determinant
     */
    public double[][] scalar(double[][] matrix, double scalar) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = matrix[i][j] * scalar;
            }
        }
        return matrix;
    }

    /**
     * Metodi DeterminantLU tuottaa parametrina annetun matriisin LU-hajotelman
     * ja laskee sen avulla determinantin.
     *
     * @param matrix
     * @return determinant
     */
    public double determinantLU(double[][] matrix) {
        double determinant = 0;
        // Lu-hajotelma
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
        // Lasketaan hajotelma.
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
                    matrix[j][i] = matrix[j][i] - matrixL[k][i]*matrixU[j][k];
                }
            }
        }

        // Tulostetaan matriisit L ja U (testitoiminto). 
        System.out.println("Matriisi L:");
        printMatrix(matrixL);
        System.out.println("Matriisi U:");
        printMatrix(matrixU);

        // Lasketaan determinantti hajotelman U-matriisista.
        determinant = matrixU[0][0];
        for (int k = 1; k < n; k++) {
            determinant = determinant * matrixU[k][k];
        }
        return determinant;
    }

    /**
     * Metodi determinantSimple laskee parametrina saadun matriisin
     * determinantin ja palauttaa determinantiksi saadun luvun.
     *
     * @param matrix
     * @return determinant
     */
    public double determinantSimple(double[][] matrix) {
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
                    determinant = determinant + (matrix[k][0] * determinantSimple(innerMatrix));
                } else if (k % 2 == 1) {
                    determinant = determinant - (matrix[k][0] * determinantSimple(innerMatrix));
                }
            }
        } else if (matrix.length == 2) {
            determinant = (matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1]);
        }
        return determinant;
    }

    /**
     * Metodi sumRow laskee parametrina saadusta matriisista rivi- ja sarake-
     * parametrien määrittämän rivin tai sarakkeen alkoiden summan ja palauttaa
     * saadun luvun.
     *
     * @param matrix
     * @param row
     * @param column
     * @return sum
     */
    public double sumRow(double[][] matrix, int row, int column) {
        double sum = 0;
        if (row > -1) {
            for (int i = 0; i < matrix.length; i++) {
                sum = sum + matrix[i][row];
            }
        } else if (column > -1) {
            for (int i = 0; i < matrix[0].length; i++) {
                sum = sum + matrix[column][i];
            }
        }
        return sum;
    }

    /**
     * Metodi sumAll laskee parametrina saadun matriisin kaikkien alkioiden
     * summan ja palauttaa saadun luvun. Metodi käyttää apunaan sumRow-metodia
     * saadakseen rivien alkioiden summat.
     *
     * @param matrix
     * @return sum
     */
    public double sumAll(double[][] matrix) {
        double sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum = sum + sumRow(matrix, -1, i);
        }
        return sum;
    }

    /**
     * Metodi meanRow laskee parametrina saadusta matriisista rivi- ja sarake-
     * parametrien määrittämän rivin tai sarakkeen alkoiden keskiarvon ja
     * palauttaa saadun luvun.
     *
     * @param matrix
     * @param row
     * @param column
     * @return mean
     */
    public double meanRow(double[][] matrix, int row, int column) {
        double mean = 0;
        int count = 0;
        if (row > -1) {
            for (int i = 0; i < matrix.length; i++) {
                mean = mean + matrix[i][row];
                count++;
            }
        } else if (column > -1) {
            for (int i = 0; i < matrix[0].length; i++) {
                mean = mean + matrix[column][i];
                count++;
            }
        }
        mean = mean / count;
        return mean;
    }

    /**
     * Metodi meanAll laskee parametrina saadun matriisin kaikkien alkioiden
     * keskiarvon ja palauttaa saadun luvun. Metodi käyttää apunaan
     * sumRow-metodia saadakseen rivien alkioiden summat.
     *
     * @param matrix
     * @return sum
     */
    public double meanAll(double[][] matrix) {
        double mean = 0;
        for (int i = 0; i < matrix.length; i++) {
            mean = mean + sumRow(matrix, -1, i);
        }
        int count = matrix.length * matrix[0].length;
        mean = mean / count;
        return mean;
    }

    // Väliaikainen apumetodi tulostaa annetun matriisin konsoliin.
    public void printMatrix(double[][] matrix) {
        /*
         *  Tulostetaan annettu matriisi.
         */
        for (int i = 0; i < matrix[0].length; i++) {
            String rivi = "[";
            for (int j = 0; j < matrix.length; j++) {
                rivi = rivi.concat(" " + matrix[j][i]);
            }
            rivi = rivi.concat(" ]");
            System.out.println(rivi);
        }
    }
}
