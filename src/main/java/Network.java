import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Network {
    public static void main(String[] args) {
        Network network = new Network();
        int n = 4;
        int[][] computers = {{1, 1, 0, 1}, {1, 1, 0, 0 }, {0, 0, 1, 1}, {1, 0, 1, 1}};
        System.out.println(network.solution(n, computers));
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[][] visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(computers[i][j] == 1 && !visit[i][j]) {
                    bfs(computers, visit, i, j);
                    answer++;
                }
            }
        }

        return answer;
    }

    private void bfs(int[][] computers, boolean[][] visit, int i, int j) {
        visit[i][j] = true;
        Queue<Coordinate> bfsQueue = new LinkedList<>();

        bfsQueue.add(new Coordinate(i, j));

        while(!bfsQueue.isEmpty()) {
            Coordinate target = bfsQueue.poll();
            for (int k = 0; k < computers.length; k++) {
                if(computers[target.getX()][k] == 1 && !visit[target.getX()][k]) {
                    bfsQueue.add(new Coordinate(target.getX(),k));
                    bfsQueue.add(new Coordinate(k, target.getX()));
                    visit[target.getX()][k] = true;
                    visit[k][target.getX()] = true;
                }
            }
        }
    }

    class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
