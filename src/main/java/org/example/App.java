package org.example;

import java.io.IOException;

import static org.example.AutomatLoader.loadAutomatFromFile;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        String[] string_array = {"Ab", "A2", "aa", "a5", "á_", "Á."};

        Automat automat = loadAutomatFromFile("src/main/java/org/example/automat.txt");
        if (automat != null) {
            System.out.println("Automat načten ze souboru:");
            System.out.println("Počáteční stav: " + automat.getPocatecniStav());
            System.out.println("Pravidla přechodu:");
            for (int i = 0; i < automat.getPravidlaPechodu().length; i++) {
                System.out.println(automat.getPravidlaPechodu()[i].getPocatecniStav() + " -> " + automat.getPravidlaPechodu()[i].getPrechodovaFunkce() + " -> " + automat.getPravidlaPechodu()[i].getKoncovyStav());
            }
            for (String text: string_array){
                System.out.println(automat.match(text));

            }

            System.out.println("\n cele číslo");
            System.out.println(automat.jeCeleCislo("123"));
            System.out.println(automat.jeCeleCislo("-456"));
            System.out.println(automat.jeCeleCislo("abc"));
            System.out.println(automat.jeCeleCislo("12abc"));
        } else {
            System.out.println("Chyba při načítání automatu ze souboru.");
        }
    }
}
