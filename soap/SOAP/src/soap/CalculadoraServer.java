/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soap;

import javax.jws.WebService;

/**
 *
 * @author yuri
 */
@WebService(endpointInterface = "soap.CalculadoraServer")
public class CalculadoraServer {

    public float sum(float x, float y) {
        return x + y;
    }

    public float sub(float x, float y) {
        return x - y;
    }

    public float mul(float x, float y) {
        return x * y;
    }

    public float div(float x, float y) {
        return x / y;
    }
}
