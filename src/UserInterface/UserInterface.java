package UserInterface;

import Logic.Logic;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author Lydia Lairala
 *
 * Luokka UserInterface mallintaa laskimen käyttöliittymän.
 */
public class UserInterface {

    private static Logic logic = new Logic();
    private static UserInterfaceFileIO io = new UserInterfaceFileIO();

    public static void main(String args[]) throws FileNotFoundException {
        System.out.println("Yksinkertainen matriisilaskin, syötä haluamasi toiminnon numero:");
        System.out.println("0 - matriisien kertolasku, 1 - matriisien yhteenlasku, 2 - skalaarikertolasku, 3 - determinantti,");
        System.out.println("4 - alkioiden summa, 5 - rivin tai sarakkeen summa, 6 - alkioiden keskiarvo, 7 - rivin tai sarakkeen keskiarvo.");
        Scanner scan = new Scanner(System.in);
        String name = "";
        String action = scan.nextLine();

        /* Matriisien kertolasku */
        if (action.equals("0")) {
            /* Pyydetään käyttäjää syöttämään matriisit. */
            System.out.println("Anna ensimmäisen ladattavan matriisin tiedostonimi.");
            name = scan.nextLine();
            double[][] matrixA = io.readMatrix(name);
            System.out.println("Anna toisen ladattavan matriisin tiedostonimi.");
            name = scan.nextLine();
            double[][] matrixB = io.readMatrix(name);
            /* Tutkitaan ovatko matriisit samaa tyyppiä ja suoritetaan laskutoimitus.  */
            if (matrixA.length == matrixB[0].length) {
                double[][] result = logic.multiply(matrixA, matrixB);
                System.out.println("Matriisien kertolaskun tulosmatriisi:");
                io.printMatrix(result);
                io.writeMatrix(result);
            } else {
                System.out.println("Matriiseja ei voi kertoa ellei ensimmäisessä matriisissa ole yhtä monta saraketta kuin toisessa matriisissa riviä.");
            }
        }

        /* Matriisien yhteenlasku */
        if (action.equals("1")) {
            /* Pyydetään käyttäjää syöttämään matriisit. */
            System.out.println("Syötä kaksi yhteenlaskettavaa samantyyppistä matriisia.");
            System.out.println("Anna ensimmäisen ladattavan matriisin tiedostonimi.");
            name = scan.nextLine();
            double[][] matrixA = io.readMatrix(name);
            System.out.println("Anna toisen ladattavan matriisin tiedostonimi.");
            name = scan.nextLine();
            double[][] matrixB = io.readMatrix(name);
            /* Tutkitaan ovatko matriisit samaa tyyppiä ja suoritetaan laskutoimitus.  */
            if (matrixA.length == matrixB.length) {
                if (matrixA[0].length == matrixB[0].length) {
                    double[][] result = logic.add(matrixA, matrixB);
                    System.out.println("Matriisien yhteenlaskun tulosmatriisi:");
                    io.printMatrix(result);
                    io.writeMatrix(result);
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
            System.out.println("Anna ladattavan matriisin tiedostonimi.");
            name = scan.nextLine();
            double[][] matrix = io.readMatrix(name);
            System.out.println("Syötä skalaarikokonaisluku.");
            int scalar = scan.nextInt();
            /* Suoritetaan laskutoimitus. */
            double[][] result = logic.scalar(matrix, scalar);
            System.out.println("Matriisin skalaarikertolaskun tulosmatriisi:");
            io.printMatrix(result);
            io.writeMatrix(result);
        }

        /* Determinantti */
        if (action.equals("3")) {
            /* Pyydetään käyttäjää syöttämään matriisi. */
            System.out.println("Anna ladattavan matriisin tiedostonimi.");
            name = scan.nextLine();
            double[][] matrix = io.readMatrix(name);
            /* Tutkitaan onko matriisi neliömatriisi ja suoritetaan laskutoimitus.  */
            if (matrix.length == matrix[0].length) {
                double result = logic.determinantLU(matrix);
                System.out.println("Matriisin determinantti on " + result + ".");
                io.writeResult(result);
            } else {
                System.out.println("Syötetty matriisi ei ole neliömatriisi.");
            }
        }

        /* Alkioiden summa, koko matriisi */
        if (action.equals("4")) {
            /* Lasketaan matriisin kaikkien alkioiden summa. */
            /* Pyydetään käyttäjää syöttämään matriisi. */
            System.out.println("Anna ladattavan matriisin tiedostonimi.");
            name = scan.nextLine();
            double[][] matrix = io.readMatrix(name);
            /* Lasketaan ja tulostetaan summa. */
            double sum = logic.sumAll(matrix);
            System.out.println("Kaikkien alkioiden summa on " + sum + ".");
            io.writeResult(sum);
        }

        /* Alkioiden summa, yksi rivi tai sarake */
        if (action.equals("5")) {
            /* Lasketaan matriisin halutun rivin tai sarakkeen summa. */
            /* Pyydetään käyttäjää syöttämään matriisi. */
            System.out.println("Anna ladattavan matriisin tiedostonimi.");
            name = scan.nextLine();
            double[][] matrix = io.readMatrix(name);
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
                System.out.println("Anna laskettavan sarakkeen numero ((vasemmalta oikealle alkaen luvusta 0).");
                column = scan.nextInt();
            }
            /* Lasketaan ja tulostetaan summa. */
            double sum = logic.sumSingle(matrix, row, column);
            System.out.println("Rivin/sarakkeen alkioiden summa on " + sum + ".");
            io.writeResult(sum);
        }

        /* Alkioiden keskiarvo, koko matriisi */
        if (action.equals("6")) {
            /* Lasketaan matriisin kaikkien alkioiden keskiarvo. */
            /* Pyydetään käyttäjää syöttämään matriisi. */
            System.out.println("Anna ladattavan matriisin tiedostonimi.");
            name = scan.nextLine();
            double[][] matrix = io.readMatrix(name);
            /* Lasketaan ja tulostetaan keskiarvo. */
            double mean = logic.meanAll(matrix);
            System.out.println("Kaikkien alkioiden keskiarvo on " + mean + ".");
            io.writeResult(mean);
        }

        /* Alkioiden keskiarvo, yksi rivi tai sarake */
        if (action.equals("7")) {
            /* Lasketaan matriisin halutun rivin tai sarakkeen keskiarvo. */
            /* Pyydetään käyttäjää syöttämään matriisi. */
            System.out.println("Anna ladattavan matriisin tiedostonimi.");
            name = scan.nextLine();
            double[][] matrix = io.readMatrix(name);
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
            double mean = logic.meanSingle(matrix, row, column);
            System.out.println("Rivin/sarakkeen alkioiden keskiarvo on " + mean + ".");
            io.writeResult(mean);
        }
    }
}
