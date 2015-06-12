/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.npu.mis;

/**
 * Model
 * 繼承 java.util.Observable 觀察者模式
 * 內有 mData1 mData2 mEvent mMemorize字串
 * The model class of the calculator application.
 */
public class Calculator extends java.util.Observable{
    private String mData1 = "", mData2 = "", mEvent = "", mMemorize = "0";
    private boolean mMft = false;
    
    /**
     * Operator列舉
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
    
    /**
     * 加入0~9數字到 mData1
     * 判斷內容是否過多 0
     * 加入數字完呼叫 getDisplay
     * @param digit 傳入點擊的數字 
     */
    public void appendDigit(int digit) {
        // TODO code application logic here
        if(!(mData1.length() == 1 && mData1.indexOf("0") >= 0)) mData1 += String.valueOf(digit);
        else if(mData1.length() == 1 && digit != 0) mData1 = String.valueOf(digit);
        getDisplay();
        
    }
    
    /**
     * 加入小數點到 mData1
     * 判斷不要過多點
     * 加完呼叫 getDisplay
     */
    public void appendDot() {
        // TODO code application logic here
        if(mMft == true) {mData1 = "0."; mMft = false;}
        else if(mData1.indexOf(".") < 0)mData1 += ".";
        getDisplay();
        
    }
    
    /**
     * 傳入列舉內容
     * 依傳入的內容選擇運算
     * 運算完呼叫 getDisplay
     * @param operator 傳入Operator列舉
     */
    public void performOperation(Operator operator) {
        // TODO code application logic here
        switch(operator)
        {
            case BACKSPACE:
                if(mMft == false && mData1.length() > 0 && !mData1.equals("0"))
                {
                    if(mData1.indexOf("-") >= 0 && mData1.length() == 2) mData1 = "0";
                    else mData1 = mData1.substring(0, mData1.length()-1);
                }
                break;
            case SQRT:
                if(!mData1.equals(""))mData1 = String.valueOf(Math.sqrt(Double.valueOf(mData1)));
                else mData1 = "0";
                if(mData1.substring(mData1.length()-2, mData1.length()).equals(".0")) mData1 = mData1.replace(".0", ""); 
                break;
            case PERCENT:
                if(!mData1.equals(""))
                {
                    if(!mData2.equals("") && !mData1.equals("")) mData1 = String.valueOf((Double.valueOf(mData1) * Double.valueOf(mData2))/100);
                    else if(mData1.equals("")) mData1 = String.valueOf((Double.valueOf(mData2)/100));
                }
                else mData1 = "0";
                break;
            case RECIPROCAL:
                if(mMft == false && !mData1.equals("") && !mData1.equals("0"))
                {
                    mData1 = String.valueOf(1 / Double.valueOf(mData1));
                    if(mData1.substring(mData1.length()-2, mData1.length()).equals(".0")) mData1 = mData1.replace(".0", ""); 
                }
                
                break;
            case MEM_CLEAR:
                mMemorize = "0";
                break;
            case MEM_SET:
                mMemorize = mData1;
                break;
            case MEM_PLUS:
                mMemorize = String.valueOf(Double.valueOf(mMemorize) + Double.valueOf(mData1));
                if(mMemorize.substring(mMemorize.length()-2, mMemorize.length()).equals(".0")) mMemorize = mMemorize.replace(".0", "");
                mMft = true;
                break;
            case MEM_MINUS:
                mMemorize = String.valueOf(Double.valueOf(mMemorize) - Double.valueOf(mData1));
                if(mMemorize.substring(mMemorize.length()-2, mMemorize.length()).equals(".0")) mMemorize = mMemorize.replace(".0", "");
                mMft = true;
                break;
            case MEM_RECALL:
                mData1 = mMemorize;
                mMft = true;
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
                performEqual();
                if(!mData1.equals(""))mData2 = mData1;
                mData1 = "";
                mEvent = "+";
                break;
            case MINUS:
                performEqual();
                if(!mData1.equals(""))mData2 = mData1;
                mData1 = "";
                mEvent = "-";
                break;
            case TIMES:
                performEqual();
                if(!mData1.equals(""))mData2 = mData1;
                mData1 = "";
                mEvent = "*";
                break;
            case OVER:
                performEqual();
                if(!mData1.equals(""))mData2 = mData1;
                mData1 = "";
                mEvent = "/";
                break;
            case EQUAL:
                performEqual();
                mData2 = "";
                break;
        }
        getDisplay();
        
    }
    
    /**
     * 等於運算
     * 加,減,乘,除,等於 運算時先執行現有內容的等於運算
     */
    public void performEqual()
    {
        if(mData1.equals("") || mData2.equals(""))return;
        switch(mEvent)
        {
            case "":
                return;
            case "+":
                mData1 = String.valueOf(Double.valueOf(mData2) + Double.valueOf(mData1));
                break;
            case "-":
                mData1 = String.valueOf(Double.valueOf(mData2) - Double.valueOf(mData1));
                break;
            case "*":
                mData1 = String.valueOf(Double.valueOf(mData2) * Double.valueOf(mData1));
                break;
            case "/":
                mData1 = String.valueOf(Double.valueOf(mData2) / Double.valueOf(mData1));
                break;
        }
        if(mData1.substring(mData1.length()-2, mData1.length()).equals(".0")) mData1 = mData1.replace(".0", "");
        
    }
    
    /**
     * 顯示內容數字
     * 判斷是否有記憶數字與運算符號
     * notifyObservers 內容傳給 View 接收
     */
    public void getDisplay() {
        // TODO code application logic here
        setChanged();
        String sendString = "";
        if(!this.mMemorize.equals("0"))sendString += "M";
        if(!mEvent.equals("") && mData1.equals(""))
        {
            sendString += mData2;
            notifyObservers(sendString);
        }
        else 
        {
            sendString += mData1;
            notifyObservers(sendString);
        }
    }
    
    /**
     * 接收要執行按鈕
     * 選擇要執行的方法
     * @param e 傳入按鈕名稱
     */
    public void setEvent(String e) {
        for(int i = 0; i < 10; i++)
        {
            if(e.equals(String.valueOf(i)))
            {
                if(mMft == true) {mMft = false; mData1 = "";}
                appendDigit(Integer.valueOf(e));
            }
        }
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
     * 主程式
     * 建立 Model View Controller
     * Controller 傳入 Model View
     * View 的按鈕行動加入 Controller
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
