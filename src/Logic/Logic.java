package Logic;

/**
 *
 * @author Lydia Lairala
 *
 * Luokka Logic mallintaa laskimen laskutoimituksia suorittavan logiikan.
 */
public class Logic {

    /**
     * Metodi add kutsuu luokan LogicAdd yhteenlaskumetodia add.
     *
     * @param matrixA
     * @param matrixB
     * @return double[][]
     */
    public double[][] add(double[][] matrixA, double[][] matrixB) {
        return new LogicAdd().add(matrixA, matrixB);
    }

    /**
     * Metodi multiply kutsuu luokan LogicMultiply kertolaskumetodia multiply.
     *
     * @param matrixA
     * @param matrixB
     * @return double[][]
     */
    public double[][] multiply(double[][] matrixA, double[][] matrixB) {
        return new LogicMultiply().multiply(matrixA, matrixB);
    }

    /**
     * Metodi scalar kutsuu luokan LogicScalar skalaarikertolaskumetodia scalar.
     *
     * @param matrix
     * @param scalar
     * @return double[][]
     */
    public double[][] scalar(double[][] matrix, double scalar) {
        return new LogicScalar().scalar(matrix, scalar);
    }

    /**
     * Metodi determinantLU kutsuu luokan LogicDeterminant LU-hajotelmametodia
     * LUDecomposition ja determinantinmääritysmetodia determinantU.
     *
     * @param matrix
     * @return double
     */
    public double determinantLU(double[][] matrix) {
        LogicDeterminant logic = new LogicDeterminant();
        matrix = logic.LUDecomposition(matrix);
        return logic.determinantU(matrix);
    }

    /**
     * Metodi determinantSimple kutsuu luokan LogicDeterminant rekursiivista
     * determinantinmääritysmetodia determinantRecursive.
     *
     * @param matrix
     * @return double
     */
    public double determinantRecursive(double[][] matrix) {
        return new LogicDeterminant().determinantRecursive(matrix);
    }

    /**
     * Metodi sumSingle kutsuu luokan LogicSum matriisin yhden rivin
     * yhteenlaskumetodia sumSingleRow tai yhden sarakkeen yhteenlaskumetodia
     * sumSingleColumn.
     *
     * @param matrix
     * @param row
     * @param column
     * @return double
     */
    public double sumSingle(double[][] matrix, int row, int column) {
        if (row > -1) {
            return new LogicSum().sumSingleRow(matrix, row);
        } else {
            return new LogicSum().sumSingleColumn(matrix, column);
        }
    }

    /**
     * Metodi sumAll kutsuu luokan LogicSum matriisin alkioiden
     * yhteenlaskumetodia sumAll.
     *
     * @param matrix
     * @return double
     */
    public double sumAll(double[][] matrix) {
        return new LogicSum().sumAll(matrix);
    }

    /**
     * Metodi meanSingle kutsuu luokan LogicSum matriisin yhden rivin
     * yhteenlaskumetodia sumSingleRow tai yhden sarakkeen yhteenlaskumetodia
     * sumSingleColumn ja jakaa tuloksen rivin tai sarakkeen pituudella tuottaen
     * rivin tai sarakkeen alkioiden keskiarvon.
     *
     * @param matrix
     * @param row
     * @param column
     * @return double mean
     */
    public double meanSingle(double[][] matrix, int row, int column) {
        double mean = 0;
        if (row > -1) {
            mean = new LogicSum().sumSingleRow(matrix, row);
            mean = (mean / (matrix.length));
        } else {
            mean = new LogicSum().sumSingleColumn(matrix, column);
            mean = (mean / (matrix[0].length));
        }
        return mean;
    }

    /**
     * Metodi meanAll kutsuu luokan LogicSum matriisin alkioiden
     * yhteenlaskumetodia sumAll ja jakaa luvun matriisin korkeuden ja leveyden
     * tulolla tuottaen kaikkien alkioiden keskiarvon.
     *
     * @param matrix
     * @return double mean
     */
    public double meanAll(double[][] matrix) {
        double mean = 0;
        mean = new LogicSum().sumAll(matrix);
        mean = (mean / (matrix.length * matrix[0].length));
        return mean;
    }
}
