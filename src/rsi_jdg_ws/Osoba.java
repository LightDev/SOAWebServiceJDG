package rsi_jdg_ws;

import java.util.ArrayList;

public class Osoba {

    public Osoba() {
    }

    public Osoba(String pesel, String imie, String nazwisko, String data_ur, boolean plec, String adres) {
        this.pesel = pesel;
        this.imie = imie;
        this.nazwisko = nazwisko;

        this.data_ur = data_ur;
        this.plec = plec;
        this.adres = adres;
    }
    private String pesel;
    private String imie;
    private String nazwisko;
    private String data_ur;
    private boolean plec;
    private String adres;
    public ArrayList osoby = new ArrayList<Osoba>();

    /**
     * @return the pesel
     */
    public String getPesel() {
        return pesel;
    }

    /**
     * @param pesel the pesel to set
     */
    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    /**
     * @return the imie
     */
    public String getImie() {
        return imie;
    }

    /**
     * @param imie the imie to set
     */
    public void setImie(String imie) {
        this.imie = imie;
    }

    /**
     * @return the nazwisko
     */
    public String getNazwisko() {
        return nazwisko;
    }

    /**
     * @param nazwisko the nazwisko to set
     */
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    /**
     * @return the plec
     */
    public boolean isPlec() {
        return plec;
    }

    /**
     * @param plec the plec to set
     */
    public void setPlec(boolean plec) {
        this.plec = plec;
    }

    /**
     * @return the adres
     */
    public String getAdres() {
        return adres;
    }

    /**
     * @param adres the adres to set
     */
    public void setAdres(String adres) {
        this.adres = adres;
    }

    /**
     * @return the data_ur
     */
    public String getData_ur() {
        return data_ur;
    }

    /**
     * @param data_ur the data_ur to set
     */
    public void setData_ur(String data_ur) {
        this.data_ur = data_ur;
    }

    public String toString() {
        return "PESEL: " + pesel + "\n"
                + "Imię: " + imie + "\n"
                + "Nazwisko: " + nazwisko + "\n"
                + "Data urodzenia: " + data_ur + "\n"
                + "Płeć: " + ((plec == true) ? "Mężczyzna" : "Kobieta") + "\n"
                + "Adres: " + adres + "\n";

    }
//    public String toString() {
//        return "PESEL: " + pesel + "<br />"
//                + "Imię: " + imie + "<br />"
//                + "Nazwisko: " + nazwisko + "<br />"
//                + "Data urodzenia: " + data_ur + "<br />"
//                + "Płeć: " + ((plec == true) ? "Mężczyzna" : "Kobieta") + "<br />"
//                + "Adres: " + adres + "<br />";
//
//    }
}
