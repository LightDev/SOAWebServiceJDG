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

    @WebMethod
    public String dodaj(String nip) {
        return "lol";
    }

    @WebMethod
    public String dodajObj(JDG jdg) throws FileNotFoundException, IOException, SQLException {
        DataConnection dc = new DataConnection(schemeName);
        dc.insert("jdg_users", "'" + jdg.getNip() + "','sad'");

        dc.close();
        String msg = "Dodano nowego JDG do bazy.";
        return msg;
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

    @WebMethod
    public String pokaz() throws SQLException {
        DataConnection dc = new DataConnection(schemeName);
        String list = dc.select("jdg_users");
        dc.close();



//        String jsonOut = getJSonOutput("http://localhost:9999/RSI_person_service/webresources/osoby/pobierz?pesel=111");
//        System.out.println(jsonOut);
//        System.out.println(toObj(jsonOut));
//        Osoba os = toObj(jsonOut);
//        System.out.println("os." + os.getImie());
//        String objOut = toObj(jsonOut).toString();
//
        //return objOut;
        return list;
    }
}
//        while (rs.next()) {
//                        System.out.print(rs.getInt(1));
//                        System.out.print(": ");
//                        System.out.print(rs.getString(2));
//                        System.out.print(": ");
//                        System.out.print(rs.getString(3));
//                        System.out.println("");
//                    }

