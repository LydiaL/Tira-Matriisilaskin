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
     * olettaa matriisien olevan aina samantyyppiset.
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

    public double[][] multiply(double[][] matrixA, double[][] matrixB) {
        double[][] matrix = new double[matrixB.length][matrixA[0].length];
        System.out.println(matrixA[0].length + " " + matrixB.length);
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

    public double[][] scalar(double[][] matrix, double scalar) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = matrix[i][j] * scalar;
            }
        }
        return matrix;
    }

    public double determinant(double[][] matrix) {
        Logic logic = new Logic();
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
                    determinant = determinant + (matrix[k][0] * logic.determinant(innerMatrix));
                } else if (k % 2 == 1) {
                    determinant = determinant - (matrix[k][0] * logic.determinant(innerMatrix));
                }
            }
        } else if (matrix.length == 2) {
            determinant = (matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1]);
        }
        return determinant;
    }

    /**
     * Metodi sum laskee parametrina saadusta matriisista rivi- ja sarake-
     * parametrien määrittämän rivin tai sarakkeen alkoiden summan ja palauttaa
     * sen.
     *
     * @param matrix
     * @param row
     * @param column
     * @return sum
     */
    public double sum(double[][] matrix, int row, int column) {
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
     * Metodi mean laskee parametrina saadusta matriisista rivi- ja sarake-
     * parametrien määrittämän rivin tai sarakkeen alkoiden keskiarvon ja
     * palauttaa sen.
     *
     * @param matrix
     * @param row
     * @param column
     * @return mean
     */
    public double mean(double[][] matrix, int row, int column) {
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
}
