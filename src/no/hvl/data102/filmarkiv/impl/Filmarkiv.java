package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {

    private Film[] filmer;
    private int antall;

    public Filmarkiv(int kapasitet) {
        if (kapasitet < 1) {
            kapasitet = 1;
        }
        this.filmer = new Film[kapasitet];
        this.antall = 0;
    }

    private void utvid() {
        Film[] ny = new Film[filmer.length * 2];
        for (int i = 0; i < antall; i++) {
            ny[i] = filmer[i];
        }
        filmer = ny;
    }

    @Override
    public Film finnFilm(int filmnr) {
        for (int i = 0; i < antall; i++) {
            {
                if (filmer[i].getFilmnr() == filmnr)
                    return filmer[i];
            }
        }
        return null;
    }

    @Override
    public boolean leggTilFilm(Film nyFilm) {
        if (nyFilm == null) return false;

        if (finnFilm(nyFilm.getFilmnr()) != null) {
            return false;
        }

        if (antall == filmer.length) {
            utvid();
        }

        filmer[antall] = nyFilm;
        antall++;
        return true;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        for (int i = 0; i < antall; i++) {
            if (filmer[i].getFilmnr() == filmnr) {

                for (int j = i; j < antall - 1; j++) {
                    filmer[j] = filmer[j + 1];
                }


                filmer[antall - 1] = null;
                antall--;
                return true;
            }
        }
        return false;
    }
    @Override
    public Film[] soekTittel(String delstreng){
        if(delstreng == null) delstreng ="";
        String s = delstreng.toLowerCase();

        int treff = 0;
        for(int i =0; i < antall; i++){
            if(filmer[i].getTittel() != null && filmer[i].getTittel().toLowerCase().contains(s)){
                treff++;
            }
        }
        Film[] resultat = new Film[treff];
        int k = 0;
        for(int i = 0; i < antall; i++){
            if(filmer[i].getTittel() != null && filmer[i].getTittel().toLowerCase().contains(s)){
                resultat[k++] = filmer[i];
            }
        }
        return resultat;
    }
    @Override
    public Film[] soekProdusent(String delstreng){
        if(delstreng == null) delstreng ="";
        String s = delstreng.toLowerCase();
        int treff = 0;
        for(int i = 0; i < antall; i++){
            if(filmer[i].getNavnProdusent() != null && filmer[i].getNavnProdusent().toLowerCase().contains(s)){
                treff++;
            }
        }
        Film[] resultat = new Film[treff];
        int k = 0;
        for(int i = 0; i < antall; i++){
            if (filmer[i].getNavnProdusent() != null && filmer[i].getNavnProdusent().toLowerCase().contains(s)){
                resultat[k++] = filmer[i];
            }
        }
        return resultat;
    }

    @Override
    public int antall(Sjanger sjanger) {
        int count = 0;
        for (int i = 0; i < antall; i++) {
            if (filmer[i].getSjanger() == sjanger) {
                count++;
            }
        }
        return count;
    }


    @Override
    public int antall() {
        return antall;
    }
}
