package backjoon.math_one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Snail {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int climb = Integer.parseInt(st.nextToken());
        int sleep = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int result = ((target - climb) / (climb - sleep)) + 1;
        if((target - climb) % (climb - sleep) != 0) {
            result++;
        }
        System.out.println(result);
    }
}
