package utils;


import constant.Constant;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CommonUtils {

    public static void printOptionsForUsers() {

        printString(Constant.SEPERATOR);
        printString(Constant.WELCOME_TO_DMART);
        printString(Constant.ADD_PRODUCT);
        printString(Constant.CHECKOUT);
        printString(Constant.EXIT);
        printString(Constant.SEPERATOR);

    }


    public static void printString(String optionString) {
        System.out.println(optionString);
    }


    public static int acceptIntegerInputFromUser() {
        try {
            Scanner scan = new Scanner(System.in);
            return scan.nextInt();
        } catch (InputMismatchException exp) {
            return -1;
        }
    }


}
