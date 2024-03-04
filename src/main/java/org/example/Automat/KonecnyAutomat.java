package org.example.Automat;

import org.example.PrechodovaFunkce;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KonecnyAutomat {
    private String[] konecneStavy;
    private PrechodovaFunkce[] pravidlaPechodu;

    public String[] getKonecneStavy() {
        return konecneStavy;
    }

    public PrechodovaFunkce[] getPravidlaPechodu() {
        return pravidlaPechodu;
    }

    public KonecnyAutomat(String[] konecneStavy, PrechodovaFunkce[] pravidlaPechodu) {
        this.konecneStavy = konecneStavy;
        this.pravidlaPechodu = pravidlaPechodu;
    }

    public boolean match(String text){
        char aktualniStav = 'S';
        for (int i = 0; i < text.length(); i++) {
            String znak = text.substring(i, i + 1);
            PrechodovaFunkce[] funkce = najdiPrechodovouFunkci(aktualniStav);
            boolean nalezen = false;
            for (PrechodovaFunkce prechodovaFunkce : funkce) {
                Pattern p = Pattern.compile(prechodovaFunkce.getPrechodovaFunkce());
                Matcher m = p.matcher(znak);
                if (m.find()) {
                    aktualniStav = prechodovaFunkce.getKoncovyStav();
                    nalezen = true;
                    break;
                }
            }
            if (!nalezen) return false;
        }

        if (jeKoncovyStav(aktualniStav)) return true;

        return false;
    }

    private boolean jeKoncovyStav(char stav){
        for (int j = 0; j < konecneStavy.length; j++){
            if (konecneStavy[j].charAt(0) == stav) return true;
        }
        return false;
    }

    private PrechodovaFunkce[] najdiPrechodovouFunkci(char pocatecniStav){
        List<PrechodovaFunkce> list = new ArrayList<>();
        for (int i = 0; i < pravidlaPechodu.length; i++){
            if (pravidlaPechodu[i].getPocatecniStav() == pocatecniStav) list.add(pravidlaPechodu[i]);
        }

        PrechodovaFunkce[] funkce = new PrechodovaFunkce[list.size()];
        list.toArray(funkce);
        return funkce;
    }



}
