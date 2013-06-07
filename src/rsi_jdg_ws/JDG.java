package rsi_jdg_ws;
//@XmlRootElement(name = "JDG")
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlSeeAlso({JDG.class})
//public class JDG implements Serializable {
public class JDG {

    public JDG() {
    }

//    public JDG(JDG jdg) {
//        this.nip = jdg.getNip();
//    }
//    public JDG(JDG jdg) {
//        //this.nip = jdg.getNip();
//        this.nip = jdg.nip;
//    }
//
//    public JDG(String nip) {
//        this.nip = nip;
//    }
//    public JDG(JDG jdg) {
//        this.nip = jdg.nip;
//        this.nazwa = jdg.nazwa;
//        this.wlasciciel = jdg.wlasciciel;
//        this.dataZalozenia = jdg.dataZalozenia;
//        this.krs = jdg.krs;
//        this.rodzajDzialalnosci = jdg.rodzajDzialalnosci;
//        this.adresSiedziby = jdg.adresSiedziby;
//        this.czyPierwsza = jdg.czyPierwsza;
//    }
    public JDG(
            String nip,
            String nazwa,
            String wlasciciel,
            String dataZalozenia,
            String krs,
            String rodzajDzialalnosci,
            String adresSiedziby,
            boolean czyPierwsza) {
        this.nip = nip;
        this.nazwa = nazwa;
        this.wlasciciel = wlasciciel;
        this.dataZalozenia = dataZalozenia;
        this.krs = krs;
        this.rodzajDzialalnosci = rodzajDzialalnosci;
        this.adresSiedziby = adresSiedziby;
        this.czyPierwsza = czyPierwsza;
    }
    //@XmlElement(name = "nipp")
    // @XmlElement //@XmlElement(required = true)
    //@XmlAnyElement
    public String nip;
    public String nazwa;
    public String wlasciciel;
    public String adresSiedziby;
    public String rodzajDzialalnosci;
    public String krs;
    public String dataZalozenia;
    public boolean czyPierwsza;
//    public String nip;
//    private String nazwa;
//    private String wlasciciel;
//    private String adresSiedziby;
//    private String rodzajDzialalnosci;
//    private String krs;
//    private String dataZalozenia;
//    private boolean czyPierwsza;

//    /**
//     * @return the nazwa
//     */
//    public String getNazwa() {
//        return nazwa;
//    }
//
//    /**
//     * @param nazwa the nazwa to set
//     */
//    public void setNazwa(String nazwa) {
//        this.nazwa = nazwa;
//    }
//
//    /**
//     * @return the wlasciciel
//     */
//    public String getWlasciciel() {
//        return wlasciciel;
//    }
//
//    /**
//     * @param wlasciciel the wlasciciel to set
//     */
//    public void setWlasciciel(String wlasciciel) {
//        this.wlasciciel = wlasciciel;
//    }
//
//    /**
//     * @return the adresSiedziby
//     */
//    public String getAdresSiedziby() {
//        return adresSiedziby;
//    }
//
//    /**
//     * @param adresSiedziby the adresSiedziby to set
//     */
//    public void setAdresSiedziby(String adresSiedziby) {
//        this.adresSiedziby = adresSiedziby;
//    }
//
//    /**
//     * @return the rodzajDzialalnosci
//     */
//    public String getRodzajDzialalnosci() {
//        return rodzajDzialalnosci;
//    }
//
//    /**
//     * @param rodzajDzialalnosci the rodzajDzialalnosci to set
//     */
//    public void setRodzajDzialalnosci(String rodzajDzialalnosci) {
//        this.rodzajDzialalnosci = rodzajDzialalnosci;
//    }
//
//    /**
//     * @return the krs
//     */
//    public String getKrs() {
//        return krs;
//    }
//
//    /**
//     * @param krs the krs to set
//     */
//    public void setKrs(String krs) {
//        this.krs = krs;
//    }
//
//    public String getNip() {
//        return nip;
//    }
//
//    public void setNip(String nip) {
//        this.nip = nip;
//    }
//
//    public String getDataZalozenia() {
//        return dataZalozenia;
//    }
//
//    public void setDataZalozenia(String dataZalozenia) {
//        this.dataZalozenia = dataZalozenia;
//    }
//
//    public boolean isCzyPierwsza() {
//        return czyPierwsza;
//    }
//
//    public void setCzyPierwsza(boolean czyPierwsza) {
//        this.czyPierwsza = czyPierwsza;
//    }
    public String toString() {
        return "nip" + nip + "\n";
    }
}
