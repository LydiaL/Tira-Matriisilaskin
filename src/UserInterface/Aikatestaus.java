package UserInterface;

import Logic.Logic;
import java.io.FileNotFoundException;

/**
 *
 * @author Lydia Lairala
 *
 * Luokka Aikatestaus testaa ohjelman aikavaatimuksia.
 */
public class Aikatestaus {

    private static Logic logic = new Logic();
    private static UserInterfaceFileIO io = new UserInterfaceFileIO();
    private static double[][] matrix1 = new double[100][100];
    private static double[][] matrix2 = new double[200][200];
    private static double[][] matrix3 = new double[300][300];
    private static double[][] matrix4 = new double[400][400];
    private static double[][] matrix5 = new double[500][500];
    private static double[][] matrix6 = new double[600][600];
    private static double[][] matrix7 = new double[700][700];
    private static double[][] matrix8 = new double[800][800];
    private static double[][] matrix9 = new double[900][900];
    private static double[][] matrix10 = new double[1000][1000];

    public static void main(String args[]) throws FileNotFoundException {
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                matrix1[i][j] = 0.1;
            }
        }
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                matrix2[i][j] = 0.1;
            }
        }
        for (int i = 0; i < matrix3.length; i++) {
            for (int j = 0; j < matrix3[0].length; j++) {
                matrix3[i][j] = 0.1;
            }
        }
        for (int i = 0; i < matrix4.length; i++) {
            for (int j = 0; j < matrix4[0].length; j++) {
                matrix4[i][j] = 0.1;
            }
        }
        for (int i = 0; i < matrix5.length; i++) {
            for (int j = 0; j < matrix5[0].length; j++) {
                matrix5[i][j] = 0.1;
            }
        }
        for (int i = 0; i < matrix6.length; i++) {
            for (int j = 0; j < matrix6[0].length; j++) {
                matrix6[i][j] = 0.1;
            }
        }
        for (int i = 0; i < matrix7.length; i++) {
            for (int j = 0; j < matrix7[0].length; j++) {
                matrix7[i][j] = 0.1;
            }
        }
        for (int i = 0; i < matrix8.length; i++) {
            for (int j = 0; j < matrix8[0].length; j++) {
                matrix8[i][j] = 0.1;
            }
        }
        for (int i = 0; i < matrix9.length; i++) {
            for (int j = 0; j < matrix9[0].length; j++) {
                matrix9[i][j] = 0.1;
            }
        }
        for (int i = 0; i < matrix10.length; i++) {
            for (int j = 0; j < matrix10[0].length; j++) {
                matrix10[i][j] = 0.1;
            }
        }

        long alku1 = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            double result = logic.determinantLU(matrix1);
        }
        long loppu1 = System.nanoTime();
        System.out.println("10x10 : " + (loppu1 - alku1) / 10 + " nS");

        long alku2 = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            double result = logic.determinantLU(matrix2);
        }
        long loppu2 = System.nanoTime();
        System.out.println("20x20 : " + (loppu2 - alku2) / 10 + " nS");

        long alku3 = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            double result = logic.determinantLU(matrix3);
        }
        long loppu3 = System.nanoTime();
        System.out.println("30x30 : " + (loppu3 - alku3) / 10 + " nS");

        long alku4 = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            double result = logic.determinantLU(matrix4);
        }
        long loppu4 = System.nanoTime();
        System.out.println("40x40 : " + (loppu4 - alku4) / 10 + " nS");

        long alku5 = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            double result = logic.determinantLU(matrix5);
        }
        long loppu5 = System.nanoTime();
        System.out.println("50x50 : " + (loppu5 - alku5) / 10 + " nS");

        long alku6 = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            double result = logic.determinantLU(matrix6);
        }
        long loppu6 = System.nanoTime();
        System.out.println("60x60 : " + (loppu6 - alku6) / 10 + " nS");

        long alku7 = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            double result = logic.determinantLU(matrix7);
        }
        long loppu7 = System.nanoTime();
        System.out.println("70x70 : " + (loppu7 - alku7) / 10 + " nS");

        long alku8 = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            double result = logic.determinantLU(matrix8);
        }
        long loppu8 = System.nanoTime();
        System.out.println("80x80 : " + (loppu8 - alku8) / 10 + " nS");

        long alku9 = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            double result = logic.determinantLU(matrix9);
        }
        long loppu9 = System.nanoTime();
        System.out.println("90x90 : " + (loppu9 - alku9) / 10 + " nS");

        long alku10 = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            double result = logic.determinantLU(matrix10);
        }
        long loppu10 = System.nanoTime();
        System.out.println("100x 100 : " + (loppu10 - alku10) / 10 + " nS");

    }
}
