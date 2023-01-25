package backjoon.math_one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BecomeOwner {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[][] rooms = new int[15][15];
        initRooms(rooms);
        for (int i = 1; i < rooms.length; i++) {
            for (int j = 1; j < rooms[i].length; j++) {
                rooms[i][j] = rooms[i-1][j] + rooms[i][j-1];
            }
        }
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(rooms[k][n-1]);
        }
    }

    private static void initRooms(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            rooms[0][i] = i+1;
            rooms[i][0] = 1;
        }
    }
}
