package backjoon.math_one;

import java.util.Scanner;

public class BeeHouse {
    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int cnt = 1;
        int end = 1;
        int gap = 6;
        while(true) {
            if(end >= i) {
                System.out.println(cnt);
                break;
            }
            end += gap * cnt;
            cnt++;
        }
    }
}
