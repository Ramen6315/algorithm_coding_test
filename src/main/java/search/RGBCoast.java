package search;

import java.util.Scanner;

public class RGBCoast {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = Integer.parseInt(scanner.nextLine());
        int[][] rgbs = new int[cnt][3];
        int result = 0;
        int index = 0;
        while(scanner.hasNextInt()) {

            try{
                String s = scanner.nextLine();
                String[] rgb = s.split(" ");

                rgbs[index][0] = Integer.parseInt(rgb[0]);
                rgbs[index][1] = Integer.parseInt(rgb[1]);
                rgbs[index][2] = Integer.parseInt(rgb[2]);
                index += 1;
            } catch(Exception e) {
                return;
            }

        }

        //메모이제이션을 풀어야하는데 중요한건 최소값으로 계산할떄 포함되지 않아야 하는것도 기록이 되어야함
        //메모이제이션 계산 해야함
    }
}
