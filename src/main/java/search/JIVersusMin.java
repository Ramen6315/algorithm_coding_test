package search;

import java.util.Scanner;

public class JIVersusMin {
    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int result = 0;
        while(scanner.hasNextInt()) {
            try{
                String s = scanner.nextLine();
                String[] rgb = s.split(" ");

                for (int i = 0; i < rgb.length - 1; i++) {
                    int number = Integer.parseInt(rgb[i]);
                    for (int j = i + 1; j < rgb.length; j++) {
                        int next = Integer.parseInt(rgb[j]);
                        if((number + next) % 3 == 0) {
                            result += 1;
                        }
                    }
                }
            } catch(Exception e) {
                return;
            }
        }
        System.out.println(result);
    }
}
