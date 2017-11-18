/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcclient;

/**
 *
 * @author yuri
 */
public class CalcClient {

    private static float add(float number1, float number2) {
        pack1.Calc1_Service service = new pack1.Calc1_Service();
        pack1.Calc1 port = service.getCalc1Port();
        return port.add(number1, number2);
    }

    private static float sub(float number1, float number2) {
        pack1.Calc1_Service service = new pack1.Calc1_Service();
        pack1.Calc1 port = service.getCalc1Port();
        return port.sub(number1, number2);
    }

    public static void main(String[] args) {
        float x = 10;
        float y = 1223;

        System.out.println("Soma: " + add(x, y));
        System.out.println("Sub: " + sub(y, x));
    }

}
