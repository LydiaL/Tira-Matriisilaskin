package Logic;

/**
 *
 * @author Lydia Lairala
 * 
 * Luokka LogicSum sisältää matriisien alkioiden yhteenlaskun metodit.
 */
public class LogicSum {

    /**
     * Metodi sumSingleColumn laskee parametrina saadusta matriisista sarakeparametrin
     * määrittämän sarakkeen alkoiden summan ja palauttaa saadun luvun.
     *
     * @param matrix
     * @param column
     * @return double sum
     */
    public double sumSingleColumn(double[][] matrix, int column) {
        double sum = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            sum = sum + matrix[column][i];
        }
        return sum;
    }

    /**
     * Metodi sumSingleRow laskee parametrina saadusta matriisista riviparametrin
     * määrittämän rivin alkoiden summan ja palauttaa saadun luvun.
     *
     * @param matrix
     * @param row
     * @return double sum
     */
    public double sumSingleRow(double[][] matrix, int row) {
        double sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum = sum + matrix[i][row];
        }
        return sum;
    }

    /**
     * Metodi sumAll laskee parametrina saadun matriisin kaikkien alkioiden
     * summan ja palauttaa saadun luvun. Metodi käyttää apunaan
     * sumSingleColumn-metodia saadakseen sarakkeiden alkioiden summat.
     *
     * @param matrix
     * @return double sum
     */
    public double sumAll(double[][] matrix) {
        double sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum = sum + sumSingleColumn(matrix, i);
        }
        return sum;
    }
}
