//노트에 적어 놓고 풀어야 했을 문제

public class Procession {
    public static void main(String[] args) {
        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = {{3, 3}, {3, 3}};
        solution(arr1, arr2);
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                int sum = 0;
                for (int x = 0; x < arr2.length; x++) {
                    sum += arr1[i][x] * arr2[x][j];
                }
                answer[i][j] = sum;
            }
        }
        return answer;
    }
}
