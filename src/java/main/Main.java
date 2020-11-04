package main;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Input your expression:");
        Scanner in = new Scanner(System.in);
        System.out.println(Calculator.getEvaluated(in.nextLine()));




        //System.out.println(new ArabNumber("111"));
        // System.out.println(RomanNumerals.convertArabNumToRoman(999));

    }
}
