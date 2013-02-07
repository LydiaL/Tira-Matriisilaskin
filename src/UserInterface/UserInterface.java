package UserInterface;

import Logic.Logic;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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
        String name = "";
        String action = scan.nextLine();

        /* Matriisien kertolasku */
        if (action.equals("0")) {
            /* Pyydetään käyttäjää syöttämään matriisit. */
            System.out.println("Anna ensimmäisen ladattavan matriisin tiedostonimi.");
            name = scan.nextLine();
            double[][] matrixA = readMatrix(name);
            System.out.println("Anna toisen ladattavan matriisin tiedostonimi.");
            name = scan.nextLine();
            double[][] matrixB = readMatrix(name);
            /* Tutkitaan ovatko matriisit samaa tyyppiä ja suoritetaan laskutoimitus.  */
            if (matrixA.length == matrixB[0].length) {
                double[][] result = logic.multiply(matrixA, matrixB);
                System.out.println("Matriisien kertolaskun tulosmatriisi:");
                printMatrix(result);
                writeMatrix(result);
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
            double[][] matrixA = readMatrix(name);
            System.out.println("Anna toisen ladattavan matriisin tiedostonimi.");
            name = scan.nextLine();
            double[][] matrixB = readMatrix(name);
            /* Tutkitaan ovatko matriisit samaa tyyppiä ja suoritetaan laskutoimitus.  */
            if (matrixA.length == matrixB.length) {
                if (matrixA[0].length == matrixB[0].length) {
                    double[][] result = logic.add(matrixA, matrixB);
                    System.out.println("Matriisien yhteenlaskun tulosmatriisi:");
                    printMatrix(result);
                    writeMatrix(result);
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
            double[][] matrix = readMatrix(name);
            System.out.println("Syötä skalaarikokonaisluku.");
            int scalar = scan.nextInt();
            /* Suoritetaan laskutoimitus. */
            double[][] result = logic.scalar(matrix, scalar);
            System.out.println("Matriisin skalaarikertolaskun tulosmatriisi:");
            printMatrix(result);
            writeMatrix(result);
        }

        /* Determinantti */
        if (action.equals("3")) {
            /* Pyydetään käyttäjää syöttämään matriisi. */
            System.out.println("Anna ladattavan matriisin tiedostonimi.");
            name = scan.nextLine();
            double[][] matrix = readMatrix(name);
            /* Tutkitaan onko matriisi neliömatriisi ja suoritetaan laskutoimitus.  */
            if (matrix.length == matrix[0].length) {
                double result = logic.determinantLU(matrix);
                System.out.println("Matriisin determinantti on " + result);
                writeResult(result);
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
            double[][] matrix = readMatrix(name);
            /* Lasketaan ja tulostetaan summa. */
            double sum = logic.sumAll(matrix);
            System.out.println("Kaikkien alkioiden summa on " + sum);
            writeResult(sum);
        }

        /* Alkioiden summa, yksi rivi tai sarake */
        if (action.equals("5")) {
            /* Lasketaan matriisin halutun rivin tai sarakkeen summa. */
            /* Pyydetään käyttäjää syöttämään matriisi. */
            System.out.println("Anna ladattavan matriisin tiedostonimi.");
            name = scan.nextLine();
            double[][] matrix = readMatrix(name);
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
            writeResult(sum);
        }

        /* Alkioiden keskiarvo, koko matriisi */
        if (action.equals("6")) {
            /* Lasketaan matriisin kaikkien alkioiden keskiarvo. */
            /* Pyydetään käyttäjää syöttämään matriisi. */
            System.out.println("Anna ladattavan matriisin tiedostonimi.");
            name = scan.nextLine();
            double[][] matrix = readMatrix(name);
            /* Lasketaan ja tulostetaan keskiarvo. */
            double mean = logic.meanAll(matrix);
            System.out.println("Kaikkien alkioiden keskiarvo on " + mean);
            writeResult(mean);
        }

        /* Alkioiden keskiarvo, yksi rivi tai sarake */
        if (action.equals("7")) {
            /* Lasketaan matriisin halutun rivin tai sarakkeen keskiarvo. */
            /* Pyydetään käyttäjää syöttämään matriisi. */
            System.out.println("Anna ladattavan matriisin tiedostonimi.");
            name = scan.nextLine();
            double[][] matrix = readMatrix(name);
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
            writeResult(mean);
        }
    }

    /**
     * Metodi readMatrix lukee matriisin tiedostosta ja palauttaa sen.
     *
     * @param name
     * @return matrix
     */
    public static double[][] readMatrix(String name) throws FileNotFoundException {
        /*
         *  Luetaan matriisi tiedostosta.
         */
        try {
            File file = new File(name);
            Scanner lukija = new Scanner(file);
            String line = lukija.nextLine();
            String[] stringArray = line.split(" ");
            double[][] matrix = new double[Integer.parseInt(stringArray[0])][Integer.parseInt(stringArray[1])];
            int i = 0;
            while (lukija.hasNextLine()) {
                line = lukija.nextLine();
                stringArray = line.split(" ");
                for (int j = 0; j < stringArray.length; j++) {
                    matrix[j][i] = Double.parseDouble(stringArray[j]);
                }
                i++;
            }
            return matrix;
        } catch (FileNotFoundException ex) {
            System.out.println("Tiedostoa ei löytynyt tai se oli väärää muotoa.");
        }
        return null;
    }

    /**
     * Metodi writeMatrix kirjoittaa matriisin tiedostoon.
     *
     * @param matrix
     */
    public static void writeMatrix(double[][] matrix) {
        try {
            FileWriter stream = new FileWriter("result.txt");
            BufferedWriter out = new BufferedWriter(stream);
            String dimensions = matrix.length + " " + matrix[0].length;
            out.write(dimensions);
            out.newLine();
            for (int i = 0; i < matrix[0].length; i++) {
                String row = "";
                row = row.concat("" + matrix[0][i]);
                for (int j = 1; j < matrix.length; j++) {
                    row = row.concat(" " + matrix[j][i]);
                }
                out.write(row);
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            System.out.println("Tulostiedoston tallennus ei onnistunut.");
        }
    }

    /**
     * Metodi writeResult kirjoittaa tuloksena saadun yksittäisen luvun
     * tiedostoon.
     *
     * @param number
     */
    public static void writeResult(double number) {
        try {
            FileWriter stream = new FileWriter("result.txt");
            BufferedWriter out = new BufferedWriter(stream);
            out.write("" + number);
            out.close();
        } catch (Exception e) {
            System.out.println("Tulostiedoston tallennus ei onnistunut.");
        }
    }

    /**
     * Metodi printMatrix tulostaa matriisin konsoliin.
     *
     * @param matrix
     */
    public static void printMatrix(double[][] matrix) {
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
