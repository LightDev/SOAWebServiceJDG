package rsi_jdg_ws;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebService;

//@Resource
@WebService
//@XmlSeeAlso(JDG.class)
//@SOAPBinding(
//        //style = SOAPBinding.Style.RPC,
//        style = SOAPBinding.Style.DOCUMENT,
//        use = SOAPBinding.Use.LITERAL,
//        parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class RSI_JDG_WS {

    private final String schemeName = "NLIGHT";
    private final String dbName = "jdg_db";
    private final String tableName = "jdg_users";

    @WebMethod
    public String dodaj(String nip) {
        return "lol";
    }

    @WebMethod
    public String dodajObj(JDG jdg) throws FileNotFoundException, IOException, SQLException {
        DataConnection dc = new DataConnection(schemeName, dbName);
        dc.insert(tableName,
                "'" + jdg.nip + "',"
                + "'" + jdg.nazwa + "',"
                + "'" + jdg.wlasciciel + "',"
                + "'" + jdg.dataZalozenia + "',"
                + "'" + jdg.krs + "',"
                + "'" + jdg.rodzajDzialalnosci + "',"
                + "'" + jdg.adresSiedziby + "',"
                + "'" + ((jdg.czyPierwsza == true) ? 'T' : 'F') + "'");

        dc.close();
        String msg = "Dodano nowego JDG.";
        return msg;
    }

    @WebMethod
    //public String modyfikuj(String nip) {
    public String modyfikuj(JDG jdg) {
        DataConnection dc = new DataConnection(schemeName, dbName);
        //JDG jdg = pobierz(jdg2.nip);
        System.out.println("przed updatem");
        System.out.println("wlascieciel " + jdg.wlasciciel);
        System.out.println("dataZalozenia " + jdg.dataZalozenia);
        dc.update(tableName,
                "nip='" + jdg.nip + "',"
                + "nazwa='" + jdg.nazwa + "',"
                + "wlasciciel='" + jdg.wlasciciel + "',"
                + "datazalozenia='" + jdg.dataZalozenia + "',"
                + "krs='" + jdg.krs + "',"
                + "rodzajdzialalnosci='" + jdg.rodzajDzialalnosci + "',"
                + "adressiedziby='" + jdg.adresSiedziby + "',"
                + "czyPierwsza='" + ((jdg.czyPierwsza == true) ? 'T' : 'F') + "'",
                "nip='" + jdg.nip + "'");
        System.out.println("row UPDATED");

        dc.close();
        String msg = "Zmodyfikowano.";
        return msg;

    }

    @WebMethod
    public String usun(String nip) {
        DataConnection dc = new DataConnection(schemeName, dbName);
        dc.delete(tableName, "nip='" + nip + "'");
        dc.close();
        String msg = "Usunięto JDG posiadającym NIP " + nip + ".";
        return msg;
    }

    @WebMethod
    public Osoba pobierzOsobe(String pesel) {
        String jsonOut = getJSonOutput("http://localhost:9999/RSI_person_service/webresources/osoby/pobierz?pesel=" + pesel);
        Osoba os = toObj(jsonOut);
        return os;
    }

    @WebMethod
    public JDG pobierz(String nip) {
        DataConnection dc = null;
        JDG jdgObj = null;
        try {
            dc = new DataConnection(schemeName, dbName);
            JDG[] jdg = dc.select(tableName, "nip='" + nip + "'");

            jdgObj = jdg[0];
            System.out.println(jdgObj);
        } finally {
            dc.close();
        }
        return jdgObj;
    }

    @WebMethod
    public JDG[] pokaz() throws SQLException {
        DataConnection dc = new DataConnection(schemeName, dbName);
        JDG[] list;
        list = dc.select(tableName);
        dc.close();

        for (int i = 0; i < list.length; i++) {
            Osoba os = pobierzOsobe(list[i].wlasciciel);
            String objOut = os.toString();
            list[i].wlasciciel = objOut;
        }
        return list;
    }

    @WebMethod
    private String getJSonOutput(String urlString) {
        String jsonOut = "";
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            System.out.println("Output from Server .... \n");
            String output = "";
            while ((output = br.readLine()) != null) {
                if (output != null) {
                    jsonOut = output;
                }
                //System.out.println(output);
            }
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonOut;
    }

    @WebMethod
    public Osoba toObj(String json) {
        Gson gson = new Gson();
        Osoba obj = gson.fromJson(json, Osoba.class);
        //System.out.println(obj);
        return obj;
    }
}
