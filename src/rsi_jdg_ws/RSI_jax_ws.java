/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rsi_jdg_ws;

import javax.xml.ws.Endpoint;

/**
 *
 * @author drgeek
 */
public class RSI_jax_ws {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("publishing");
        //Endpoint.publish("http://localhost:8081/axis2/services/RSI/RSI_JDG_WSService?wsdl", new RSI_JDG_WS());
        Endpoint.publish("http://localhost:9999/RSI_JDG/", new RSI_JDG_WS());
        System.out.println("published");


    }
}
