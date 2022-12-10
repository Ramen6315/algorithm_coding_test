package search;


import java.util.Scanner;


//유클리드 호제법을 통한 최대 공약수 푸는 방법은 기억 할 것
public class CommonPart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String bothNumber = scanner.nextLine();
        String[] number = bothNumber.split(" ");
        int numberOne = Integer.parseInt(number[0]);
        int numberTwo = Integer.parseInt(number[1]);
        int result = 1;
        for (int i = 1; i <= numberOne && i <= numberTwo; i++) {
            if(numberOne % i == 0 && numberTwo % i == 0) {
                result *= i;
            }
        }
        System.out.println(result);
    }
}
