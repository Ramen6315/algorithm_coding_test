// 전체곱 / 최대공약수 -> 최소공배수
// 최대공약수 구하는 법 -> 유클리드 호제법
public class MinMultiple {
    public static void main(String[] args) {
        int[] arrs = {2, 6, 8, 14};
        solution(arrs);
    }

    public static int solution(int[] arr) {
        return createMultipleNumbers(arr);
    }

    private static int createMultipleNumbers(int[] arr) {
        int minDivide = arr[0];
        for (int i = 1; i < arr.length; i++) {
            minDivide = minDivide * arr[i] / getMinDivide(minDivide, arr[i]);
        }
        return minDivide;
    }

    private static int getMinDivide(int i, int j) {
        while(j != 0) {
            int r = i % j;
            i = j;
            j = r;
        }
        return i;
    }
}
