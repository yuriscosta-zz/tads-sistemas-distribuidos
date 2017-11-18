/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack1;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author yuri
 */
@WebService(serviceName = "Calc1")
@Stateless()
public class Calc1 {

    /**
     * Operação de soma
     *
     * @param number1
     * @param number2
     * @return number1 + number2
     */
    @WebMethod(operationName = "add")
    public float add(@WebParam(name = "number1") float number1, @WebParam(name = "number2") float number2) {
        //TODO write your implementation code here:
        return number1 + number2;
    }

    /**
     * Operação de subtração
     *
     * @param number1
     * @param number2
     * @return number1 - number2
     */
    @WebMethod(operationName = "sub")
    public float sub(@WebParam(name = "number1") float number1, @WebParam(name = "number2") float number2) {
        //TODO write your implementation code here:
        return number1 - number2;
    }
}
