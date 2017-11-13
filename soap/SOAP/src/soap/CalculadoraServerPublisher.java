/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soap;

import javax.xml.ws.Endpoint;

/**
 *
 * @author yuri
 */
public class CalculadoraServerPublisher {

    public static void main(String[] args) {
        Endpoint.publish("http://127.0.0.1/soap", new CalculadoraServer());
    }
}
