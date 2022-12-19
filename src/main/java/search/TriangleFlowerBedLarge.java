package search;

import java.util.Scanner;
//남은 변을 for문이 아니라 2개의 변이 설정되면 남은 변은 자동적으로 설정이 되으로 굳이 3중 반복문을 할 필요가 없음
public class TriangleFlowerBedLarge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int round = scanner.nextInt();
        int side = round / 3 + 1;
        int nextSide = round / 2 + 1;
        int count = 0;
        for (int i = 1; i < side; i++) {
            for (int j = 1; j < nextSide; j++) {
                int lastSide = round - i - j;
                if (i <= j && j <= lastSide && i + j > lastSide) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
