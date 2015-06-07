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
    private String mData1 = "", mData2 = "", mEvent = "", mMemorize = "0";
    
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
        mData1 += ".";
        getDisplay();
        
    }
    
    public void performOperation(Operator operator) {
        // TODO code application logic here
        switch(operator)
        {
            case BACKSPACE:
                if(mData1.length() > 0)mData1 = mData1.substring(0, mData1.length()-1);
                break;
            case SQRT:
                mData1 = String.valueOf(Math.sqrt(Double.valueOf(mData1)));
                break;
            case PERCENT:
                if(!mData2.equals("")) mData1 = String.valueOf((Double.valueOf(mData1) * Double.valueOf(mData2))/100);
                break;
            case RECIPROCAL:
                mData1 = String.valueOf(1 / Double.valueOf(mData1));
                break;
            case MEM_CLEAR:
                mMemorize = "0";
                break;
            case MEM_SET:
                mMemorize = mData1;
                mData1 = "";
                break;
            case MEM_PLUS:
                mMemorize = String.valueOf(Double.valueOf(mMemorize) + Double.valueOf(mData1));
                mData1 = "";
                if(mMemorize.substring(mMemorize.length()-2, mMemorize.length()).equals(".0")) mMemorize = mMemorize.replace(".0", "");
                break;
            case MEM_MINUS:
                mMemorize = String.valueOf(Double.valueOf(mMemorize) - Double.valueOf(mData1));
                mData1 = "";
                if(mMemorize.substring(mMemorize.length()-2, mMemorize.length()).equals(".0")) mMemorize = mMemorize.replace(".0", "");
                break;
            case MEM_RECALL:
                mData1 = mMemorize;
                break;
            case PLUS_MINUS:
                mData1 = String.valueOf(Double.valueOf(mData1) - Double.valueOf(mData1)*2);
                if(mData1.substring(mData1.length()-2, mData1.length()).equals(".0")) mData1 = mData1.replace(".0", "");
                break;
            case CLEAR:
                mData2 = "";
                mData1 = "";
                mEvent = "";
                break;
            case CLEAR_ENTRY:
                mData1 = "";
                break;
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
                if(mEvent.equals(""))break;
                else if(mEvent.equals("+"))
                mData1 = String.valueOf(Double.valueOf(mData2) + Double.valueOf(mData1));
                else if(mEvent.equals("-"))
                mData1 = String.valueOf(Double.valueOf(mData2) - Double.valueOf(mData1));
                else if(mEvent.equals("*"))
                mData1 = String.valueOf(Double.valueOf(mData2) * Double.valueOf(mData1));
                else if(mEvent.equals("/"))
                mData1 = String.valueOf(Double.valueOf(mData2) / Double.valueOf(mData1));
                if(mData1.substring(mData1.length()-2, mData1.length()).equals(".0")) mData1 = mData1.replace(".0", "");
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
            case ".":
                appendDot();
                break;
            case "←":
                performOperation(Operator.BACKSPACE);
                break;
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
            case "C":
                performOperation(Operator.CLEAR);
                break;
            case "CE":
                performOperation(Operator.CLEAR_ENTRY);
                break;
            case "±":
                performOperation(Operator.PLUS_MINUS);
                break;
            case "MC":
                performOperation(Operator.MEM_CLEAR);
                break;
            case "MS":
                performOperation(Operator.MEM_SET);
                break;
            case "M+":
                performOperation(Operator.MEM_PLUS);
                break;
            case "M-":
                performOperation(Operator.MEM_MINUS);
                break;
            case "MR":
                performOperation(Operator.MEM_RECALL);
                break;
            case "√":
                performOperation(Operator.SQRT);
                break;
            case "%":
                performOperation(Operator.PERCENT);
                break;
            case "1/x":
                performOperation(Operator.RECIPROCAL);
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
