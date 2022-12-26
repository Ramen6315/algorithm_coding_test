package search;

import java.util.Scanner;

public class XYZ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] XYZValues = input.split(" ");
        int a = Integer.parseInt(XYZValues[0]);
        int b = Integer.parseInt(XYZValues[1]);
        int c = Integer.parseInt(XYZValues[2]);

        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));
        int mid = a + b + c - max - min;

        System.out.println(findMinCalculate(min, mid, max));
    }

    private static int findMinCalculate(int min, int mid, int max) {
        //여기서 중요한 포인트라고 생각되는 부분은 홀수 차이 -> 짝수 차이로 만들어준다.

        if ((mid - min) % 2 != 0 && (max - mid) % 2 != 0) {
            //두 수의 차이가 다 홀수일 경우 작은 두수 +1씩 제일 큰수+2해서 서로의 차이를 짝수로
            // 전부 짝수 차이가 되기 때문에 그냥 차이 나누기 2하면 횟수가됨
            return 2 + calculateDiff(min + 1, mid + 2, max + 1);
        } else if((mid - min) % 2 == 0 && (max - mid) % 2 != 0) {
            //112, 136 min하고 mid를 +1씩하면 애초에 짝수 차이인 min, mid는 짝수 차이로 유지가 되고, 홀수인 차이인 mid와 max는 짝수 차이가됨
            // 전부 짝수 차이가 되기 때문에 그냥 차이 나누기 2하면 횟수가됨
            return 1 + calculateDiff(min + 1, mid + 1, max);
        } else if((mid - min) % 2 != 0 && (max - mid) % 2 == 0) {
            // mid, max를 1씩 증가 시키면, 이미 짝수차이인 max와 mid는 그대로 유지,  min, mid가 홀수차이에서 짝수 차이가됨
            // 전부 짝수 차이가 되기 때문에 그냥 차이 나누기 2하면 횟수가됨
            return 1 + calculateDiff(min, mid + 1, max + 1);
        } else {
            //2 4 6 양쪽다 짝수의 차이가 나는 경우는 아래 차이를 2로 나눈 값을 그냥 더해주면됨
            return calculateDiff(min, mid, max);
        }
    }

    private static int calculateDiff(int min, int mid, int max) {
        return (mid - min) / 2 + (max - mid) / 2;
    }
}
