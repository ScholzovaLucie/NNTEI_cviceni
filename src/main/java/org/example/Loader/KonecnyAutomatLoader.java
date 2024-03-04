package org.example.Loader;

import org.example.Automat.Automat;
import org.example.Automat.KonecnyAutomat;
import org.example.PrechodovaFunkce;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class KonecnyAutomatLoader {
    public static KonecnyAutomat loadAutomatFromFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int pocetPravidel = Integer.parseInt(reader.readLine().trim());
            String[] koncovyStav = reader.readLine().trim().split(" ");

            PrechodovaFunkce[] pravidlaPechodu = new PrechodovaFunkce[pocetPravidel];

            for (int i = 0; i < pocetPravidel; i++) {
                String[] radka = reader.readLine().trim().split("\\s+");
                pravidlaPechodu[i] = new PrechodovaFunkce(
                        radka[0].charAt(0),
                        radka[2].charAt(0),
                        radka[1]
                );

            }

            return new KonecnyAutomat(koncovyStav, pravidlaPechodu);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
