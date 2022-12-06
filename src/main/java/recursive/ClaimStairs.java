package recursive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


// for문으로 해결 했지만 재귀 방법으로는 다시 생각 해봐야함
public class ClaimStairs {
    public  void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> stairAmounts = new ArrayList<>();

        for (int i = 0; i < 111; i++) {
            String stairAmount = scanner.next();
            stairAmounts.add(Integer.parseInt(stairAmount));
        }
        while(scanner.hasNextInt()) {
            try{
                String stairAmount = scanner.next();
                stairAmount.trim();
                stairAmounts.add(Integer.parseInt(stairAmount));
            } catch(Exception e) {
                return;
            }

        }

        int[] result = new int[stairAmounts.size() - 1];
        for (int i = 1; i <= result.length; i++) {
            result[i - 1] = stairAmounts.get(i);
        }
        int[] amount = new int[result.length];
        int i = claimStairs(result, amount);
        System.out.println(i);
    }

    public  int claimStairs(int[] result, int[] amount) {
        if(result.length == 3) {
            amount[0] = result[0];
            amount[1] = result[0] + result[1];
            amount[2] = Math.max(result[0], result[1]) + result[2];
            return amount[2];
        } else if(result.length == 2) {
            amount[0] = result[0];
            amount[1] = result[0] + result[1];
            return amount[1];
        } else if(result.length == 1) {
            return result[0];
        }
        for (int i = 0; i < result.length; i++) {
            if(i==0) {
                amount[0] = result[0];
            } else if(i == 1) {
                amount[1] = result[0] + result[1];
            } else if (i == 2) {
                amount[i] = Math.max(result[0], result[1]) + result[i];
            } else {
                amount[i] = Math.max(amount[i - 2], amount[i - 3] + result[i - 1]) + result[i];
            }
        }

        return amount[result.length - 1];
    }
}
