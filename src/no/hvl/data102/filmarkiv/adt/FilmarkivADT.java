package no.hvl.data102.filmarkiv.adt;

import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public interface FilmarkivADT {

    void leggTilFilm(Film film);

    boolean slettFilm(int filmnr);

    Film finnFilm(int filmnr);

    Film[] hentFilmerISjanger(Sjanger sjanger);

    int antallFilmer();
}
