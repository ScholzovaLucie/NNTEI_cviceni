package org.example;

public class PrechodovaFunkce {
    private char pocatecniStav;
    private char koncovyStav;

    private String prechodovaFunkce;

    public PrechodovaFunkce(char pocatecniStav, char koncovyStav, String prechodovaFunkce) {
        this.pocatecniStav = pocatecniStav;
        this.koncovyStav = koncovyStav;
        this.prechodovaFunkce = prechodovaFunkce;
    }

    public char getPocatecniStav() {
        return pocatecniStav;
    }

    public void setPocatecniStav(char pocatecniStav) {
        this.pocatecniStav = pocatecniStav;
    }

    public char getKoncovyStav() {
        return koncovyStav;
    }

    public void setKoncovyStav(char koncovyStav) {
        this.koncovyStav = koncovyStav;
    }

    public String getPrechodovaFunkce() {
        return prechodovaFunkce;
    }

    public void setPrechodovaFunkce(String prechodovaFunkce) {
        this.prechodovaFunkce = prechodovaFunkce;
    }
}
