/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author Lydia Lairala
 * 
 * Luokka UserInterfaceFileIO käsittelee tiedostojen lukemisen ja kirjoittamisen.
 */
public class UserInterfaceFileIO {

    /**
     * Metodi readMatrix lukee matriisin tiedostosta ja palauttaa sen.
     *
     * @param name
     * @return matrix
     */
    public double[][] readMatrix(String name) throws FileNotFoundException {
        /*
         *  Luetaan matriisi tiedostosta.
         */
        try {
            File file = new File(name);
            Scanner lukija = new Scanner(file);
            String line = lukija.nextLine();
            String[] stringArray = line.split(" ");
            double[][] matrix = new double[Integer.parseInt(stringArray[1])][Integer.parseInt(stringArray[0])];
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
    public void writeMatrix(double[][] matrix) {
        try {
            FileWriter stream = new FileWriter("result.txt");
            BufferedWriter out = new BufferedWriter(stream);
            String dimensions = matrix[0].length + " " + matrix.length;
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
    public void writeResult(double number) {
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
    public void printMatrix(double[][] matrix) {
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
