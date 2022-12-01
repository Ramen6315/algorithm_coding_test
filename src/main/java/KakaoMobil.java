import java.util.LinkedList;
import java.util.Queue;

public class KakaoMobil {
    public static void main(String[] args) {
        KakaoMobil kakaoMobil = new KakaoMobil();
        int N = 3;
        int[] A = {1, 3};
        int[] B = {2, 2};
        System.out.println(kakaoMobil.solution(N, A, B));
    }

    public boolean solution(int N, int[] A, int[] B) {
        boolean result = false;
        boolean[][] visit = new boolean[N][N];
        for (int i = 0; i < A.length; i++) {
            if(A[i] == 1 && B[i] == 2) {
                visit[A[i] - 1][B[i] - 1] = true;
                result = bfs(visit, i, A, B, N);
                break;
            } else if(A[i] == 2 && B[i] == 1) {
                visit[A[i] - 1][B[i] - 1] = true;
                result = bfs(visit, i, A, B, N);
                break;
            }
        }

        return result;
    }

    private boolean bfs(boolean[][] visit, int i, int[] A, int[] B, int N) {
        Queue<Node> move = new LinkedList<>();
        move.add(new Node(A[i], B[i]));

        while(!move.isEmpty()) {
            Node nowLocation = move.poll();
            for (int j = 0; j < A.length; j++) {
                if (!visit[A[j] - 1][B[j] - 1] && nowLocation.isNextTarget(A[j], B[j])) {
                    visit[A[j] - 1][B[j] - 1] = true;
                    move.add(new Node(A[j], B[j]));
                    break;
                } else if (!visit[A[j] - 1][B[j] - 1] && nowLocation.isNextTarget(B[j], A[j])) {
                    visit[A[j] - 1][B[j] - 1] = true;
                    move.add(new Node(B[j], A[j]));
                    break;
                }
            }
            if(nowLocation.isLastTarget(N)) {
                return true;
            }
        }
        return false;
    }

    class Node {
        int now;
        int target;

        public Node(int now, int target) {
            this.now = now;
            this.target = target;
        }

        public int getNow() {
            return now;
        }

        public int getTarget() {
            return target;
        }

        public boolean isNextTarget(int target, int nextTarget) {
            return this.target == target && this.target + 1 == nextTarget;
        }

        public boolean isLastTarget(int finishTarget) {
            return this.target == finishTarget;
        }
    }
}
