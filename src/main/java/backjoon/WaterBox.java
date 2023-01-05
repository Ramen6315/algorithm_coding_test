package backjoon;

import java.util.Scanner;

public class WaterBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            int a = aChar;
            System.out.println(a);
        }
    }
}
