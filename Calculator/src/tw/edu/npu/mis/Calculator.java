/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.npu.mis;

/**
 * The model class of the calculator application.
 */
public class Calculator extends Subject{
    
    String Digit = "", number = "", mark = "";
    /**
     * The available operators of the calculator.
     */
    public enum Operator {
        CLEAR,       // AC
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
        MEM_RECALL,   // MR
        SQUARE,        //平方   
    }
    /**
     * 數字相加，如果判斷是10自動加00，不然就是數字0~9
     */
    public void appendDigit(int digit) {
        if(digit == 10) Digit +="00";
        else Digit += digit;
        notifyObserver();
    }
    
    /**
     * 執行邏輯運算的結果
     */
    public void performOperation(Operator operator) {
        switch(operator) {
            case PLUS:
                number = Digit;
                Digit = "";
                mark = "+";
                break;
            case MINUS:
                number = Digit;
                Digit = "";
                mark = "-";
                break;
            case TIMES:
                number = Digit;
                Digit = "";
                mark = "*";
                break;
            case OVER:
                number = Digit;
                Digit = "";
                mark = "/";
                break;
            case EQUAL:
                if(mark == "+") Digit = String.valueOf(Integer.valueOf(number) + Integer.valueOf(Digit));
                else if(mark == "-") Digit = String.valueOf(Integer.valueOf(number) - Integer.valueOf(Digit));
                else if(mark == "*") Digit = String.valueOf(Integer.valueOf(number) * Integer.valueOf(Digit));
                else if(mark == "/") Digit = String.valueOf(Integer.valueOf(number) / Integer.valueOf(Digit));
                mark = "";
                break;
            case CLEAR:
                Digit = "";
                number = "";
                mark = "";
                break;
            case PLUS_MINUS:
                Digit = String.valueOf(Integer.valueOf(Digit) * -1);
                break;
            case SQUARE:
                Digit = String.valueOf(Integer.valueOf(Digit) * Integer.valueOf(Digit));
                break;
            case RECIPROCAL:
                Digit = String.valueOf(1 / Double.valueOf(Digit));
                break;
        }
        notifyObserver();
    }

    public String getDisplay() {
        return Digit;
    }

    /**
     * view跟model實作部分
     */
    public static void main(String[] args) {
        Calculator Model = new Calculator();
        computer View = new computer(Model);
        View.setVisible(true);
    }

}
