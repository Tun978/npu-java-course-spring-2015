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
    private String mData1 = "", mData2 = "", mEvent = "";
    
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
        mData1 += String.valueOf(digit);
        getDisplay();
        
    }
    
    public void appendDot() {
        // TODO code application logic here
        getDisplay();
        
    }
    
    public void performOperation(Operator operator) {
        // TODO code application logic here
        switch(operator)
        {
            case PLUS:
                mData2 = mData1;
                mData1 = "";
                mEvent = "+";
                break;
            case MINUS:
                mData2 = mData1;
                mData1 = "";
                mEvent = "-";
                break;
            case TIMES:
                mData2 = mData1;
                mData1 = "";
                mEvent = "*";
                break;
            case OVER:
                mData2 = mData1;
                mData1 = "";
                mEvent = "/";
                break;
            case EQUAL:
                if(mEvent.equals("+"))
                mData1 = String.valueOf(Integer.valueOf(mData2) + Integer.valueOf(mData1));
                else if(mEvent.equals("-"))
                mData1 = String.valueOf(Integer.valueOf(mData2) - Integer.valueOf(mData1));
                else if(mEvent.equals("*"))
                mData1 = String.valueOf(Integer.valueOf(mData2) * Integer.valueOf(mData1));
                else if(mEvent.equals("/"))
                mData1 = String.valueOf(Integer.valueOf(mData2) / Integer.valueOf(mData1));
                break;
        }
        getDisplay();
        
    }
    
    public String getDisplay() {
        // TODO code application logic here
        setChanged();
	notifyObservers(mData1);
        return null;
    }
    
    public void setEvent(String e) {
        for(int i = 0; i < 10; i++)if(e.equals(String.valueOf(i)))appendDigit(Integer.valueOf(e));
        switch(e)
        {
            case "+":
                performOperation(Operator.PLUS);
                break;
            case "-":
                performOperation(Operator.MINUS);
                break;
            case "*":
                performOperation(Operator.TIMES);
                break;
            case "/":
                performOperation(Operator.OVER);
                break;
            case "=":
                performOperation(Operator.EQUAL);
                break;    
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Calculator myModel = new Calculator();
        View myView = new View();

        myModel.addObserver(myView);
        Controller myController = new Controller();
        myController.addModel(myModel);
        myController.addView(myView);
        myView.addController(myController);
    }

}
