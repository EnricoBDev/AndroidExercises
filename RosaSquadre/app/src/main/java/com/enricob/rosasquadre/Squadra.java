package com.enricob.rosasquadre;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;

public class Squadra implements Serializable {
    String nome;
    ArrayList<Giocatore> giocatori = new ArrayList<>();

    public Squadra(){

    }

    public Squadra(String nome) {
        this.nome = nome;
    }

    // utile nel futuro nel caso ci siano altri attributi che possono cambiare nel tempo
    public void addGiocatore(Giocatore giocatore){
        for (Giocatore i : giocatori){
            if (giocatore.toString().trim().equals(i.toString().trim())){
                int idxGiocatore = giocatori.indexOf(i);
                giocatori.set(idxGiocatore, giocatore);
                return;
            }
        }
        giocatori.add(giocatore);
    }

    public ArrayList<Giocatore> getGiocatori() {
        return giocatori;
    }

    public String getNome() {
        return nome;
    }



    @NonNull
    @Override
    public String toString() {
        return nome;
    }
}
