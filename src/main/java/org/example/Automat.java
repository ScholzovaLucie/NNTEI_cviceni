package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Automat {
    private char pocatecniStav;
    private PrechodovaFunkce[] pravidlaPechodu;

    public char getPocatecniStav() {
        return pocatecniStav;
    }

    public void setPocatecniStav(char pocatecniStav) {
        this.pocatecniStav = pocatecniStav;
    }

    public PrechodovaFunkce[] getPravidlaPechodu() {
        return pravidlaPechodu;
    }

    public void setPravidlaPechodu(PrechodovaFunkce[] pravidlaPechodu) {
        this.pravidlaPechodu = pravidlaPechodu;
    }

    public Automat(char pocatecniStav, PrechodovaFunkce[] pravidlaPechodu) {
        this.pocatecniStav = pocatecniStav;
        this.pravidlaPechodu = pravidlaPechodu;
    }

    public boolean match(String text){
        char aktualniStav = pocatecniStav;
        for (int i = 0; i < text.length(); i++) {
            String znak = text.substring(i, i+1);
            for (int j = 0; j < pravidlaPechodu.length; j++){
                if (aktualniStav == pravidlaPechodu[j].getPocatecniStav()){
                    Pattern p = Pattern.compile(pravidlaPechodu[j].getPrechodovaFunkce());
                    Matcher m = p.matcher(znak);
                    if (!m.find()){
                        return false;
                    }
                    else{
                        aktualniStav = pravidlaPechodu[j].getKoncovyStav();
                    }
                }
            }
        }
        return true;
    }

    private boolean jeCislice(char znak) {
        return (znak >= '0' && znak <= '9');
    }

    public boolean jeCeleCislo(String text) {
        char stav = 'S';
        final char STAV_CISLO = 'A';

        for (int i = 0; i < text.length(); i++) {
            char znak = text.charAt(i);
            switch (stav) {
                case 'S':
                    if (znak == '+' || znak == '-' || jeCislice(znak)) {
                        stav = STAV_CISLO;
                    } else {
                        return false;
                    }
                    break;
                case 'A':
                    if (!jeCislice(znak)) {
                        return false;
                    }
                    break;
            }
        }

        return stav == STAV_CISLO;
    }

}