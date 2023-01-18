package backjoon.math_one;

import java.util.Scanner;

public class BreakEvenPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String total = scanner.nextLine();
        String[] totals = total.split(" ");
        int base = Integer.parseInt(totals[0]);
        int income = Integer.parseInt(totals[1]);
        int sell = Integer.parseInt(totals[2]);
        if(income >= sell) {
            System.out.println(-1);
        } else {
            int earnMoney = sell - income;
            System.out.println((base / earnMoney) + 1);
        }
    }
}
