package search;

import java.util.Scanner;

public class TriangleFlowerBed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int round = sc.nextInt();
        int count = 0;
        for(int a = 1; a < round ;a++) {
            for(int b =1; b < round;b++) {
                for(int c = 1;c < round;c++) {
                    if(a <= b && b <= c && a+b>c && a+b+c == round)
                        count++;
                }
            }
        }
        System.out.print(count);
    }
}
