/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.npu.mis;

/**
 *
 * @author STP
 */
public class Controller {
    public Calculator mcalculator;
    public Controller(Calculator calculator) {
        mcalculator = calculator;
        //mcalculator.appendDigit(0);
    }
}
