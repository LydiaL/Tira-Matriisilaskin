package UserInterface;

import Logic.Logic;
import java.util.Scanner;

/**
 *
 * @author Lairala
 */
public class UserInterface {

    private static Logic logic;

    public static void main(String args[]) {
        System.out.println("Mitä haluat laskea matriiseilla? A - kertolasku, B - yhteenlasku, C - rivin tai sarakkeen summa, D rivin tai sarakkeen keskiarvo.");
        Scanner scan = new Scanner(System.in);
        String action = scan.nextLine();
        if (action.equals("A")) {

            /* Pyydetään käyttäjää syöttämään matriisit. */
            int[][] matrixA = inputMatrix();
            int[][] matrixB = inputMatrix();
            /* Tulostetaan syötetyt matriisit. */
            printMatrix(matrixA);
            printMatrix(matrixB);

        }
        if (action.equals("B")) {

            /* Pyydetään käyttäjää syöttämään matriisit. */
            int[][] matrixA = inputMatrix();
            int[][] matrixB = inputMatrix();
            /* Tulostetaan syötetyt matriisit. */
            printMatrix(matrixA);
            printMatrix(matrixB);

        }
        if (action.equals("C")) {
            /* Lasketaan matriisin halutun rivin tai sarakkeen summa. */
            /* Pyydetään käyttäjää syöttämään matriisi. */
            int[][] matrix = inputMatrix();
            /* Tulostetaan syötetty matriisi. */
            printMatrix(matrix);
            /* Selvitetään laskettava rivi/sarake. */
            System.out.println("Onko laskettavana rivi (vaakasuuntainen) vai sarake (pystysuuntainen)?");
            String choice = scan.nextLine();
            int row = 0;
            int column = 0;
            if (choice.equals("rivi")) {
                System.out.println("Anna laskettavan rivin numero");
                row = scan.nextInt();
            }
            if (choice.equals("sarake")) {
                System.out.println("Anna laskettavan sarakkeen numero");
                column = scan.nextInt();
            }
            /* Lasketaan ja tulostetaan summa. */
            int sum = logic.sum(matrix, row, column);
            System.out.println("Rivin alkioiden summa on " + sum);
        }
        if (action.equals("D")) {
            /* Lasketaan matriisin halutun rivin tai sarakkeen keskiarvo. */
            /* Pyydetään käyttäjää syöttämään matriisi. */
            int[][] matrix = inputMatrix();
            /* Tulostetaan syötetty matriisi. */
            printMatrix(matrix);
            /* Selvitetään laskettava rivi/sarake. */
            System.out.println("Onko laskettavana rivi (vaakasuuntainen) vai sarake (pystysuuntainen)?");
            String choice = scan.nextLine();
            int row = -1;
            int column = -1;
            if (choice.equals("rivi")) {
                System.out.println("Anna laskettavan rivin numero (ylhäältä alas alkaen luvusta 0).");
                row = scan.nextInt();
            }
            if (choice.equals("sarake")) {
                System.out.println("Anna laskettavan sarakkeen numero (vasemmalta oikealle alkaen luvusta 0).");
                column = scan.nextInt();
            }
            /* Lasketaan ja tulostetaan keskiarvo. */
            int mean = logic.mean(matrix, row, column);
            System.out.println("Rivin alkioiden keskiarvo on " + mean);
        }
    }

    public static int[][] inputMatrix() {
        /*
         *  Pyydetään käyttäjää syöttämään matriisi konsoliin.
         */
        Scanner scan = new Scanner(System.in);
        System.out.println("Anna matriisin sarakkeiden lukumäärä (toistaiseksi enintään 5).");
        int columns = scan.nextInt();
        if (columns > 5) {
            columns = 5;
        }
        System.out.println("Anna matriisin rivien lukumäärä (toistaiseksi enintään 5).");
        int rows = scan.nextInt();
        if (rows > 5) {
            rows = 5;
        }
        int[][] matrix = new int[columns][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.println("Anna matriisin " + (i + 1) + ". rivin " + (j + 1) + ". luku.");
                matrix[i][j] = scan.nextInt();
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        /*
         *  Tulostetaan annettu matriisi.
         */
        System.out.println("Matriisi:");
        for (int i = 0; i < matrix.length; i++) {
            String rivi = "[";
            for (int j = 0; j < matrix[0].length; j++) {
                rivi = rivi.concat(" " + matrix[i][j]);
            }
            rivi = rivi.concat(" ]");
            System.out.println(rivi);
        }
    }
}
