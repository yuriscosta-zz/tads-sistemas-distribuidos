package soap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

/**
 *
 * @author yuri
 */
public class CalculadoraClient {

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://127.0.0.1/9876/soap?wsdl");
        QName qname = new QName("http://soap/", "CalculadoraServerService");
        Service ws = Service.create(url, qname);
        CalculadoraServer calc = ws.getPort(CalculadoraServer.class);

        System.out.println("10 + 10 = " + calc.sum(10, 10));
        System.out.println("100 - 21 = " + calc.sub(100, 21));
        System.out.println("13 * 15 = " + calc.mul(13, 15));
        System.out.println("9 / 2.1 = " + calc.div(9, (float) 2.1));
    }
}
