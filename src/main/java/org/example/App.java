package org.example;

import org.example.Automat.Automat;
import org.example.Automat.KonecnyAutomat;
import org.example.Loader.AutomatLoader;
import org.example.Loader.KonecnyAutomatLoader;

import java.io.IOException;

import static org.example.Loader.AutomatLoader.loadAutomatFromFile;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        String[] cislo_array = {"12", "+12", "1.5", "-50", "ss", "+a"};
        String[] ident_array = {"aa", "22", "a2", "-1", "-a", "+a"};

        KonecnyAutomat cislo = KonecnyAutomatLoader.loadAutomatFromFile("src/main/java/org/example/files/cislo.txt");
        KonecnyAutomat ident = KonecnyAutomatLoader.loadAutomatFromFile("src/main/java/org/example/files/konecnyAutomat.txt");

        if(cislo != null ){
            System.out.println("\nčíslo");
            for (int j = 0; j < cislo_array.length; j++){
                System.out.println(cislo.match(cislo_array[j]));
            }
        }else {
            System.out.println("Chyba při načítání automatu ze souboru.");
        }

        if(ident != null ){
            System.out.println("\nidentifikátor");
            for (int j = 0; j < ident_array.length; j++){
                System.out.println(ident.match(ident_array[j]));
            }
        }else {
            System.out.println("Chyba při načítání automatu ze souboru.");
        }
    }
}
