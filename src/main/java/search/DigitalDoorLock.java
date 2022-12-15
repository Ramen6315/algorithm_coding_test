package search;

import java.util.*;

//최소공약수 로직을 간단하게 구할수 있어야함 로직이 너무 길다.
public class DigitalDoorLock {
    public void main(String[] args) {
        int result = 1;
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] numbers = input.split(" ");
        boolean[] primeNumber;
        List<Map<Integer, Integer>> numbersCommonParts = new ArrayList<>();
        for (String number : numbers) {
            int num = Integer.parseInt(number);
            primeNumber = new boolean[num + 1];
            makePrimeNumber(primeNumber);
            numbersCommonParts.add(findCommonFactor(num, primeNumber));
        }
        Map<Integer, Integer> integerIntegerMap = numbersCommonParts.get(0);
        for (Integer key : integerIntegerMap.keySet()) {
            int min = integerIntegerMap.get(key);
            boolean isCommonPart = false;
            for (int i = 1; i < numbersCommonParts.size(); i++) {
                Map<Integer, Integer> nextCommonPart = numbersCommonParts.get(i);
                isCommonPart = nextCommonPart.containsKey(key);
                if(isCommonPart) {
                    Integer commonCnt = nextCommonPart.get(key);
                    if(commonCnt < min) {
                        min = commonCnt;
                    }
                }
            }
            if(isCommonPart) {
                result *= Math.pow(key, min);
            }
        }

        System.out.println(result);
    }

    private static void makePrimeNumber(boolean[] primeNumber) {
        primeNumber[0] = true;
        primeNumber[1] = true;
        for (int i = 2; i < primeNumber.length; i++) {
            if(!primeNumber[i]) {
                for (int j = i+i; j < primeNumber.length; j = j+i) {
                    primeNumber[j] = true;
                }
            }
        }
    }

    private static Map<Integer, Integer> findCommonFactor(int num, boolean[] primeNumber) {
        Map<Integer, Integer> commonNum = new HashMap<>();
        int number = num;
        double sqrt = Math.sqrt(num);

        for (int i = 0; i < sqrt + 1; i++) {
            if(!primeNumber[i]) {
                while(number % i == 0) {
                    number = number / i;
                    if(commonNum.containsKey(i)) {
                        Integer integer = commonNum.get(i);
                        commonNum.put(i, integer + 1);
                    } else {
                        commonNum.put(i, 1);
                    }
                }
                if(!primeNumber[number]) {
                    if(commonNum.containsKey(number)) {
                        Integer integer = commonNum.get(number);
                        commonNum.put(number, integer + 1);
                    } else {
                        commonNum.put(number, 1);
                    }
                    break;
                }
            }

        }
        return commonNum;
    }
}
