package UserInterface;

import Logic.Logic;
import java.util.Scanner;

/**
 *
 * @author Lairala
 */
public class UserInterface {

    private static Logic logic = new Logic();

    public static void main(String args[]) {
        System.out.println("Mitä haluat laskea matriiseilla? 1 - yhteenlasku, 2 - rivin tai sarakkeen summa, 3 rivin tai sarakkeen keskiarvo.");
        Scanner scan = new Scanner(System.in);
        String action = scan.nextLine();
        
//        if (action.equals("0")) {
//            /* Pyydetään käyttäjää syöttämään matriisit. */
//            int[][] matrixA = inputMatrix();
//            int[][] matrixB = inputMatrix();
//            /* Tulostetaan syötetyt matriisit. */
//            printMatrix(matrixA);
//            printMatrix(matrixB);
//            /* Tutkitaan ovatko matriisit samaa tyyppiä ja suoritetaan laskutoimitus.  */
//            if (matrixA.length == matrixB.length) {
//                if (matrixA[0].length == matrixB[0].length) {
//                    System.out.println("?");
//                }
//            }
//        }
        
        if (action.equals("1")) {
            /* Pyydetään käyttäjää syöttämään matriisit. */
            int[][] matrixA = inputMatrix();
            int[][] matrixB = inputMatrix();
            /* Tulostetaan syötetyt matriisit. */
            printMatrix(matrixA);
            printMatrix(matrixB);
            /* Tutkitaan ovatko matriisit samaa tyyppiä ja suoritetaan laskutoimitus.  */
            if (matrixA.length == matrixB.length) {
                if (matrixA[0].length == matrixB[0].length) {
                    int[][] result = logic.add(matrixA, matrixB);
                    System.out.println("Matriisien yhteenlaskun tulosmatriisi:");
                    printMatrix(result);
                } else {
                    System.out.println("Erityyppisiä matriiseja ei voi laskea yhteen.");
                }
            } else {
                System.out.println("Erityyppisiä matriiseja ei voi laskea yhteen.");
            }
        }
        
        if (action.equals("2")) {
            /* Lasketaan matriisin halutun rivin tai sarakkeen summa. */
            /* Pyydetään käyttäjää syöttämään matriisi. */
            int[][] matrix = inputMatrix();
            /* Tulostetaan syötetty matriisi. */
            printMatrix(matrix);
            /* Selvitetään laskettava rivi/sarake. */
            System.out.println("Onko laskettavana vaakasuuntainen rivi (syötä r) vai pystysuuntainen sarake (syötä s)?");
            String input = scan.nextLine();
            int row = -1;
            int column = -1;
            if (input.equals("r")) {
                System.out.println("Anna laskettavan rivin numero");
                row = scan.nextInt();
            }
            if (input.equals("s")) {
                System.out.println("Anna laskettavan sarakkeen numero");
                column = scan.nextInt();
            }
            /* Lasketaan ja tulostetaan summa. */
            int sum = logic.sum(matrix, row, column);
            System.out.println("Alkioiden summa on " + sum);
        }
        
        if (action.equals("3")) {
            /* Lasketaan matriisin halutun rivin tai sarakkeen keskiarvo. */
            /* Pyydetään käyttäjää syöttämään matriisi. */
            int[][] matrix = inputMatrix();
            /* Tulostetaan syötetty matriisi. */
            printMatrix(matrix);
            /* Selvitetään laskettava rivi/sarake. */
            System.out.println("Onko laskettavana vaakasuuntainen rivi (syötä r) vai pystysuuntainen sarake (syötä s)?");
            String input = scan.nextLine();
            int row = -1;
            int column = -1;
            if (input.equals("r")) {
                System.out.println("Anna laskettavan rivin numero (ylhäältä alas alkaen luvusta 0).");
                row = scan.nextInt();
            }
            if (input.equals("s")) {
                System.out.println("Anna laskettavan sarakkeen numero (vasemmalta oikealle alkaen luvusta 0).");
                column = scan.nextInt();
            }
            /* Lasketaan ja tulostetaan keskiarvo. */
            int mean = logic.mean(matrix, row, column);
            System.out.println("Alkioiden keskiarvo on " + mean);
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
                matrix[j][i] = scan.nextInt();
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
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
