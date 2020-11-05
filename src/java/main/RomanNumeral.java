package main;

import javafx.util.Pair;

import java.util.*;

public class RomanNumeral {

    private String number;
    private Integer value;
    private static Map<String, Integer> roma_num = new HashMap<String, Integer>() {{
        put("I", Integer.valueOf(1));
        put("V", Integer.valueOf(5));
        put("X", Integer.valueOf(10));
        put("L", Integer.valueOf(50));
        put("C", Integer.valueOf(100));
        put("D", Integer.valueOf(500));
        put("M", Integer.valueOf(1000));
    }};
    private static String[] basic = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    private static List<Pair<Integer, String>> convertToRom = Arrays.asList(
            new Pair<Integer, String>(new Integer(1), "I"),
            new Pair<Integer, String>(new Integer(5), "V"),
            new Pair<Integer, String>(new Integer(10), "X"),
            new Pair<Integer, String>(new Integer(50), "L"),
            new Pair<Integer, String>(new Integer(100), "C"),
            new Pair<Integer, String>(new Integer(500), "D"),
            new Pair<Integer, String>(new Integer(1000), "M")
    );

    RomanNumeral(String str) {
        number = str;
        value = roma_num.get(String.valueOf(str.charAt(0)));
        for (int i = 1; i < str.length(); ++i) {
            if (value >= roma_num.get(String.valueOf(str.charAt(i))).intValue())
                value += roma_num.get(String.valueOf(str.charAt(i))).intValue();
            else
                value = roma_num.get(String.valueOf(str.charAt(i))).intValue() - value;
        }
    }

    static int convertRomanNumToArab(String str) {
        return new RomanNumeral(str).value.intValue();
    }

    static RomanNumeral convertArabNumToRoman(int value) {
        StringBuffer a = new StringBuffer("");
        String str;
        int curValue;
        int copyValue = value;

        a.append(M(copyValue));
        copyValue = copyValue % 1000;


        str = D(copyValue);
        a.append(str);
        if (str.equals("CM"))
            copyValue -= 900;
        else if (!str.equals(""))
            copyValue -= 500;

        str = C(copyValue);
        a.append(str);
        if (str.equals("CD"))
            copyValue -= 400;
        else if (!str.equals(""))
            copyValue %= 100;

        str = L(copyValue);
        a.append(str);
        if (str.equals("XC"))
            copyValue -= 90;
        else if (!str.equals(""))
            copyValue -= 50;

        str = X(copyValue);
        a.append(str);
        if (str.equals("XL"))
            copyValue -= 40;
        else if (!str.equals(""))
            copyValue %= 10;


        a.append(basic[copyValue]);
        return new RomanNumeral(a.toString());
    }

    private static String M(int value) {
        StringBuffer a = new StringBuffer("");
        int i = 0;
        int j = value / 1000;
        while (i < j) {
            a.append("M");
            i++;
        }
        return a.toString();
    }

    private static String D(int value) {

        if (value - 500 >= 400) return "CM"; // if 900, then 1000-100
        else if (value / 500 == 1) return "D";
        else return "";
    }

    private static String C(int value) {
        if (value / 100 == 4) return "CD"; //if 400, then 500-100
        else if (value / 100 > 0) {
            StringBuffer a = new StringBuffer("");
            int i = 0;
            while (i < value) {
                a.append("C");
                i++;
            }
            return a.toString();
        } else return "";
    }

    private static String L(int value) {
        if (value - 50 >= 40) return "XC";// if 90, then 100-10
        else if (value / 50 == 1) return "L";
        else return "";

    }

    private static String X(int value) {
        if (value / 10 == 4) return "XL"; // if 40, then 50-10
        else if (value / 10 > 0) {
            StringBuffer a = new StringBuffer("");
            int i = 0;
            int j = value / 10;
            while (i < j) {
                a.append("X");
                i++;
            }
            return a.toString();
        } else return "";
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return number;
    }

}
