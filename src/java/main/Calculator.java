package main;

public class Calculator {
    private static String[] arab = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private static String[] rome = {"I", "V", "X", "L", "C", "D", "M"};
    private static String[] op = {"+", "-", "/", "*"};

    static String getEvaluated(String exp) {
        String operation = null;
        boolean Arab_is = false;
        boolean Roma_is = false;
        int a;
        int b;
        int answer;
        int index_operation = 0;
        StringBuffer str = new StringBuffer();
        exp=exp.replace(" ", "");

        for (String ar : arab) {
            if (exp.contains(ar)) {
                Arab_is = true;
                break;
            }
        }
        for (String ro : rome) {
            if (exp.contains(ro)) {
                Roma_is = true;
                break;
            }
        }

        if (Arab_is == true && Roma_is == true)
            throw new IllegalArgumentException("The expression contains both Roman and Arabic numerals");

        for (String o : op) {
            operation = exp.contains(o) ? o : null;
            if(operation!=null)
                break;
        }
        index_operation = exp.indexOf(operation);


        if (Arab_is) {
            a = ArabNumeral.convertStrToArabNum(exp.substring(0, index_operation));
            b = ArabNumeral.convertStrToArabNum(exp.substring(index_operation + 1));
        } else if ((Roma_is)) {
            a = RomanNumeral.convertRomanNumToArab(exp.substring(0, index_operation));
            b = RomanNumeral.convertRomanNumToArab(exp.substring(index_operation + 1));
        } else throw new IllegalArgumentException("");


        switch (operation) {
            case "+":
                answer = a + b;
                break;
            case "-":
                answer = a - b;
                break;
            case "/":
                answer = a / b;
                break;
            case "*":
                answer = a * b;
                break;
            default:
                answer = 0;
        }
        if(Roma_is)
            return RomanNumeral.convertArabNumToRoman(answer).toString();
        else
            return Integer.valueOf(answer).toString();

    }
}
