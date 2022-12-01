//다시 확인 해봐야함


public class Fatigue {
    public static void main(String[] args) {
        Fatigue fatigue = new Fatigue();
        int[][] dungeons = {
                {80, 20},
                {50, 40},
                {30, 10}

        };
        System.out.println(fatigue.solution(80, dungeons));
    }
    int answer = 0;
    boolean[] visit;
    public int solution(int k, int[][] dungeons) {
        int cnt = 0;
        visit = new boolean[dungeons.length];
        dfs(k, cnt, dungeons);
        return answer;
    }

    private void dfs(int k, int cnt, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            if(k >= dungeons[i][0] && !visit[i]) {
                visit[i] = true;
                dfs(k - dungeons[i][1], cnt+1,  dungeons);
                visit[i] = false;
            }
        }

        answer = Math.max(cnt, answer);
    }
}
