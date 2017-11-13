/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soap;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 *
 * @author yuri
 */
@WebService
@SOAPBinding(style = Style.RPC)
public interface ICalculadora {

    @WebMethod
    float sum(float x, float y);

    @WebMethod
    float sub(float x, float y);

    @WebMethod
    float mul(float x, float y);

    @WebMethod
    float div(float x, float y);
}
