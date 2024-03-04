package org.example.Loader;


import org.example.Automat.Automat;
import org.example.PrechodovaFunkce;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AutomatLoader {
    public static Automat loadAutomatFromFile(String filePath) throws IOException {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                int pocetPravidel = Integer.parseInt(reader.readLine().trim());
                char pocatecniStav = reader.readLine().trim().charAt(0);

                PrechodovaFunkce[] pravidlaPechodu = new PrechodovaFunkce[pocetPravidel];

                for (int i = 0; i < pocetPravidel; i++) {
                    String[] radka = reader.readLine().trim().split("\\s+");
                    pravidlaPechodu[i] = new PrechodovaFunkce(
                            radka[0].charAt(0),
                            radka[2].charAt(0),
                            radka[1]
                    );

                }

                return new Automat(pocatecniStav, pravidlaPechodu);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

