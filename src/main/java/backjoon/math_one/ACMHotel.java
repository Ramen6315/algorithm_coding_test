package backjoon.math_one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//각 층수의 1호실 부터 채우는 문제
public class ACMHotel {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        for (int i = 0; i < input; i++) {
            String hotelRooms = br.readLine();
            System.out.println(findShortestWay(hotelRooms));
        }
    }

    private static int findShortestWay(String hotelRooms) {
        String[] hotelRoomArr = hotelRooms.split(" ");
        int height = Integer.parseInt(hotelRoomArr[0]);
        int width = Integer.parseInt(hotelRoomArr[1]);
        int queue = Integer.parseInt(hotelRoomArr[2]);
        int room = queue / height;
        int floor = queue - (height * room);
        int result = floor * 100 + (room + 1);
        if(floor == 0) {
            result = height * 100 + (room);
        }
        return result;
    }
}
