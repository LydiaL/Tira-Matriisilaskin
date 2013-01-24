package Logic;

/**
 *
 * @author Lairala
 */
public class Logic {

    public int[][] add(int[][] matrixA, int[][] matrixB) {
        return null;
    }

    public int[][] multiply(int[][] matrixA, int[][] matrixB) {
        return null;
    }

    public int sum(int[][] matrix, int row, int column) {
        int sum = 0;
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

    public int mean(int[][] matrix, int row, int column) {
        int mean = 0;
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
        mean = mean/count;
        return mean;
    }
}
