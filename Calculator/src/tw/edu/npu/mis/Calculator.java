/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.npu.mis;

/**
 * The model class of the calculator application.
 */
public class Calculator extends java.util.Observable{
    //String data = "";
    private int data;
    
    /**
     * The available operators of the calculator.
     */
    public enum Operator {
        CLEAR,       // C
        CLEAR_ENTRY, // CE
        BACKSPACE,   // ⌫
        EQUAL,       // =
        PLUS,        // +
        MINUS,       // -
        TIMES,       // ×
        OVER,        // ⁄
        PLUS_MINUS,  // ±
        RECIPROCAL,  // 1/x
        PERCENT,     // %
        SQRT,        // √
        MEM_CLEAR,   // MC
        MEM_SET,     // MS
        MEM_PLUS,    // M+
        MEM_MINUS,   // M-
        MEM_RECALL   // MR
    }
    
    public void appendDigit(int digit) {
        // TODO code application logic here
        //data += String.valueOf(digit);
        data = 1;
        setChanged();
	notifyObservers(data);
        
    }
    
    public void appendDot() {
        // TODO code application logic here
        setChanged();
	notifyObservers(data);
        
    }
    
    public void performOperation(Operator operator) {
        // TODO code application logic here
        setChanged();
	notifyObservers(data);
        
    }
    
    public String getDisplay() {
        // TODO code application logic here
        return null;
    }
    
    public void setValue(int value) {
        this.data = value;
        setChanged();
	notifyObservers(data);
    }

    public void incrementValue() {

	++data;
	System.out.println("Model     : counter = " + data);
	setChanged();
	notifyObservers(data);

    }
    
    /**
     * @param args the command line arguments
     */
    /*public static void main(String[] args) {
        // TODO code application logic here
        
    }*/

}
