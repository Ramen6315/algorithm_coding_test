
public class NumTri {
    public  void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(solution(triangle));
    }

    public  int solution(int[][] triangle) {
        int answer = 0;
        int[][] tri = new int[triangle.length][triangle.length];
        tri[0][0] = triangle[0][0];
        for (int i = 0; i < triangle.length-1; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                int sum = tri[i][j] + triangle[i + 1][j];
                if (tri[i + 1][j] < sum) {
                    tri[i + 1][j] = sum;
                }

                int sum2 = tri[i][j] + triangle[i + 1][j + 1];
                if (tri[i + 1][j + 1] < sum2) {
                    tri[i + 1][j + 1] = sum2;
                }
            }
        }
        for (int j = 0; j < triangle[triangle.length-1].length; j++) {
            if(answer < tri[triangle.length-1][j]) {
                answer = tri[triangle.length-1][j];
            }
        }
        return answer;
    }
}
