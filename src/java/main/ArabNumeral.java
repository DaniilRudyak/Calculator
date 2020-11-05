package main;

public class ArabNumeral {
    private Integer number;

    ArabNumeral(String str) {
        int num = 0;
        for (int i = 0; i < str.length(); ++i) {
            num += Integer.parseInt(String.valueOf(str.charAt(i))) * Math.pow(10, (str.length() - i - 1));
        }
        number = num;
    }

    static int convertStrToArabNum(String str){
        return new ArabNumeral(str).number.intValue();
    }
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return number.toString();
    }
}
