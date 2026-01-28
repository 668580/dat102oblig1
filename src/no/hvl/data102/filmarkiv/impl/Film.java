package no.hvl.data102.filmarkiv.impl;

public class Film {
    private int filmnr;
    private String navnProdusent;
    private String tittel;
    private int aar;
    private Sjanger sjanger;
    private String filmselskap;


    public Film(){
    }

    public Film(int filmnr, String navnProdusent, String tittel, int aar, Sjanger sjanger, String filmselskap){
        this.filmnr = filmnr;
        this.navnProdusent = navnProdusent;
        this.tittel = tittel;
        this.aar = aar;
        this.sjanger = sjanger;
        this.filmselskap = filmselskap;
    }

    public int getFilmnr(){
        return filmnr;
    }

    public int getAar() {
        return aar;
    }

    public String getTittel() {
        return tittel;
    }

    public Sjanger getSjanger() {
        return sjanger;
    }

    public String getNavnProdusent() {
        return navnProdusent;
    }

    public String getFilmselskap() {
        return filmselskap;
    }

    public void setFilmnr(int filmnr) {
        this.filmnr = filmnr;
    }

    public void setAar(int aar) {
        this.aar = aar;
    }

    public void setFilmselskap(String filmselskap) {
        this.filmselskap = filmselskap;
    }

    public void setNavnProdusent(String navnProdusent) {
        this.navnProdusent = navnProdusent;
    }

    public void setSjanger(Sjanger sjanger) {
        this.sjanger = sjanger;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }
}