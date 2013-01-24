package Logic;

/**
 *
 * @author Lairala
 */
public class Logic {

    public float[][] add(float[][] matrixA, float[][] matrixB) {
        float[][] matrix = new float[matrixA.length][matrixA[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        return matrix;
    }

    public float[][] multiply(float[][] matrixA, float[][] matrixB) {
        return null;
    }

    /**
     *
     * @param matrix
     * @param row
     * @param column
     * @return
     */
    public float sum(float[][] matrix, int row, int column) {
        float sum = 0;
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

    public float mean(float[][] matrix, int row, int column) {
        float mean = 0;
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
