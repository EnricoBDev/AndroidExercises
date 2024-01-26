package com.enricob.indovinanumero;

public class Giocatore {
    String nome;
    int nGuess;

    public Giocatore(String nome, int nGuess) {
        this.nome = nome;
        this.nGuess = nGuess;
    }

    @Override
    public String toString() {
        return this.nome + " " + String.valueOf(nGuess);
    }
}
