package UserInterface;

import Logic.Logic;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Lairala
 *
 * Luokka UserInterface mallintaa laskimen käyttöliittymän.
 */
public class UserInterface {

    private static Logic logic = new Logic();

    public static void main(String args[]) throws FileNotFoundException {
        System.out.println("Yksinkertainen matriisilaskin, syötä haluamasi toiminnon numero:");
        System.out.println("0 - matriisien kertolasku, 1 - matriisien yhteenlasku, 2 - skalaarikertolasku, 3 - determinantti,");
        System.out.println("4 - alkioiden summa, 5 - rivin tai sarakkeen summa, 6 - alkioiden keskiarvo, 7 - rivin tai sarakkeen keskiarvo.");
        Scanner scan = new Scanner(System.in);
        String action = scan.nextLine();

        /* Matriisien kertolasku */
        if (action.equals("0")) {
            /* Pyydetään käyttäjää syöttämään matriisit. */
            double[][] matrixA = inputMatrix();
            double[][] matrixB = inputMatrix();
            /* Tulostetaan syötetyt matriisit. */
            printMatrix(matrixA);
            printMatrix(matrixB);
            /* Tutkitaan ovatko matriisit samaa tyyppiä ja suoritetaan laskutoimitus.  */
            if (matrixA.length == matrixB[0].length) {
                double[][] result = logic.multiply(matrixA, matrixB);
                System.out.println("Matriisien kertolaskun tulosmatriisi:");
                printMatrix(result);
            } else {
                System.out.println("Matriiseja ei voi kertoa ellei ensimmäisessä matriisissa ole yhtä monta saraketta kuin toisessa matriisissa riviä.");
            }
        }

        /* Matriisien yhteenlasku */
        if (action.equals("1")) {
            /* Pyydetään käyttäjää syöttämään matriisit. */
            System.out.println("Syötä kaksi yhteenlaskettavaa samantyyppistä matriisia.");
            double[][] matrixA = inputMatrix();
            double[][] matrixB = inputMatrix();
            /* Tulostetaan syötetyt matriisit. */
            System.out.println("Ensimmäinen syötetty matriisi.");
            printMatrix(matrixA);
            System.out.println("Toinen syötetty matriisi.");
            printMatrix(matrixB);
            /* Tutkitaan ovatko matriisit samaa tyyppiä ja suoritetaan laskutoimitus.  */
            if (matrixA.length == matrixB.length) {
                if (matrixA[0].length == matrixB[0].length) {
                    double[][] result = logic.add(matrixA, matrixB);
                    System.out.println("Matriisien yhteenlaskun tulosmatriisi:");
                    printMatrix(result);
                } else {
                    System.out.println("Erityyppisiä matriiseja ei voi laskea yhteen.");
                }
            } else {
                System.out.println("Erityyppisiä matriiseja ei voi laskea yhteen.");
            }
        }

        /* Skalaarikertolasku */
        if (action.equals("2")) {
            /* Pyydetään käyttäjää syöttämään matriisi. */
            System.out.println("Syötä skalaarikertolaskulla kerrottava matriisi.");
            double[][] matrix = inputMatrix();
            /* Tulostetaan syötetyt matriisit. */
            System.out.println("Syötetty matriisi.");
            printMatrix(matrix);
            System.out.println("Syötä skalaarikokonaisluku.");
            int scalar = scan.nextInt();
            /* Suoritetaan laskutoimitus. */
            double[][] result = logic.scalar(matrix, scalar);
            System.out.println("Matriisin skalaarikertolaskun tulosmatriisi:");
            printMatrix(result);
        }

        /* Determinantti */
        if (action.equals("3")) {
            /* Pyydetään käyttäjää syöttämään matriisi. */
            System.out.println("Syötä neliömatriisi, jonka determinantin haluat määrittää.");
            double[][] matrix = inputMatrix();
            /* Tulostetaan syötetyt matriisit. */
            System.out.println("Syötetty matriisi.");
            printMatrix(matrix);
            /* Tutkitaan onko matriisi neliömatriisi ja suoritetaan laskutoimitus.  */
            if (matrix.length == matrix[0].length) {
                double result = logic.determinantLU(matrix);
                System.out.println("Matriisin determinantti on " + result);
            } else {
                System.out.println("Syötetty matriisi ei ole neliömatriisi.");
            }
        }

        /* Alkioiden summa, koko matriisi */
        if (action.equals("4")) {
            /* Lasketaan matriisin kaikkien alkioiden summa. */
            /* Pyydetään käyttäjää syöttämään matriisi. */
            double[][] matrix = inputMatrix();
            /* Tulostetaan syötetty matriisi. */
            System.out.println("Syötetty matriisi:");
            printMatrix(matrix);
            /* Lasketaan ja tulostetaan summa. */
            double sum = logic.sumAll(matrix);
            System.out.println("Kaikkien alkioiden summa on " + sum);
        }

        /* Alkioiden summa, yksi rivi tai sarake */
        if (action.equals("5")) {
            /* Lasketaan matriisin halutun rivin tai sarakkeen summa. */
            /* Pyydetään käyttäjää syöttämään matriisi. */
            double[][] matrix = inputMatrix();
            /* Tulostetaan syötetty matriisi. */
            System.out.println("Syötetty matriisi:");
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
            double sum = logic.sumRow(matrix, row, column);
            System.out.println("Rivin/sarakkeen alkioiden summa on " + sum);
        }

        /* Alkioiden keskiarvo, koko matriisi */
        if (action.equals("6")) {
            /* Lasketaan matriisin kaikkien alkioiden keskiarvo. */
            /* Pyydetään käyttäjää syöttämään matriisi. */
            double[][] matrix = inputMatrix();
            /* Tulostetaan syötetty matriisi. */
            System.out.println("Syötetty matriisi:");
            printMatrix(matrix);
            /* Lasketaan ja tulostetaan keskiarvo. */
            double sum = logic.meanAll(matrix);
            System.out.println("Kaikkien alkioiden keskiarvo on " + sum);
        }


        /* Alkioiden keskiarvo, yksi rivi tai sarake */
        if (action.equals("7")) {
            /* Lasketaan matriisin halutun rivin tai sarakkeen keskiarvo. */
            /* Pyydetään käyttäjää syöttämään matriisi. */
            double[][] matrix = inputMatrix();
            /* Tulostetaan syötetty matriisi. */
            System.out.println("Syötetty matriisi:");
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
            double mean = logic.meanRow(matrix, row, column);
            System.out.println("Rivin/sarakkeen alkioiden keskiarvo on " + mean);
        }


    }

    public static double[][] inputMatrix() throws FileNotFoundException {
        /*
         *  Luetaan matriisi tiedostosta.
         */
        try {
            File file = new File("text.txt");
            Scanner scan = new Scanner(file);
            String rivi = scan.nextLine();
            System.out.println(rivi);
            return null;
        } catch (FileNotFoundException ex) {
            System.out.println("Tiedostoa ei löytynyt tai se oli väärää muotoa.");
        }
        return null;
    }

    public static void printMatrix(double[][] matrix) {
        /*
         *  Tulostetaan annettu matriisi tiedostoon.
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
