package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {

    // Instansvariabler

    // Konstruktør(er)

    @Override
    public void leggTilFilm(Film film) {
        // TODO
    }

    @Override
    public boolean slettFilm(int filmnr) {
        // TODO
        return false;
    }

    @Override
    public Film finnFilm(int filmnr) {
        // TODO
        return null;
    }

    @Override
    public Film[] hentFilmerISjanger(Sjanger sjanger) {
        // TODO
        return null;
    }

    @Override
    public int antallFilmer() {
        // TODO
        return 0;
    }
}
