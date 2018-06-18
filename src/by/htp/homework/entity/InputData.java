package by.htp.homework.entity;

import java.util.Scanner;

public class InputData {
    private static int iNumber;
    private static String sSymbol;

    public static String data(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter number of letter in word and press Enter");
        iNumber = sc.nextInt();

        System.out.println("Please enter symbol and press Enter");
        sSymbol = sc.next();

        return String.format("%d|%s",iNumber,sSymbol);
    }
}
