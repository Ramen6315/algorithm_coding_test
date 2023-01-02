package search;

import java.util.Arrays;
import java.util.Scanner;

public class PlusMinus {
    static int answer = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = new String[3];
        int index = 0;
        while(scanner.hasNext()) {
            inputs[index] = scanner.nextLine();
            index++;
            if(index == 3) {
                break;
            }
        }
        int result = Integer.parseInt(inputs[0]);
        int pickCount = Integer.parseInt(inputs[1]);
        if(pickCount == 0) {
            System.out.println(0);
            return;
        }
        int[] nums = getNums(inputs[2]);
        int cnt = 0;
        int sum = 0;
        plusMinus(result, pickCount, nums, cnt, sum);
        System.out.println(answer);
    }

    private static int[] getNums(String input) {
        String[] numbers = input.split(" ");
        int[] nums = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = Integer.parseInt(numbers[i]);
        }
        return nums;
    }

    private static void plusMinus(int result, int pickCount, int[] nums, int cnt, int sum) {
        if(cnt < pickCount) {
            plusMinus(result, pickCount,  nums, cnt + 1, sum + nums[cnt]);
            plusMinus(result, pickCount,  nums, cnt + 1, sum - nums[cnt]);
        } else if(result == sum) {
            answer++;
        }
    }
}
