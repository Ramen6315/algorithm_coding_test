public class Airplane {
    public  void main(String[] args) {
        Airplane airplane = new Airplane();
        airplane.solution(2, "1A 2F 1C");
    }

    public int solution(int N, String S) {
        int result = 0;
        boolean[][] seats = new boolean[N][11];
        String[] alreadySeat = S.split(" ");
        if(S.equals("")) {
            return N * 2;
        }
        seatReservation(seats, alreadySeat);
        for (boolean[] seat : seats) {
            if (!isClearSeat(seat)) {
                result += 2;
            } else if(isOneFamily(seat)) {
                result += 1;
            }
        }
        return result;
    }

    private boolean isOneFamily(boolean[] seat) {
        if (!seat[4] || !seat[5] || !seat[6] || !seat[7]) {
            return true;
        } else if(!seat[1] || !seat[2] || !seat[3] || !seat[4]) {
            return true;
        } else return !seat[5] || !seat[6] || !seat[7] || !seat[8];
    }

    private boolean isClearSeat(boolean[] seat) {
        boolean result = false;
        for (int i = 1; i < seat.length - 1; i++) {
            result = result || seat[i];
        }
        return result;
    }

    private void seatReservation(boolean[][] seats, String[] alreadySeat) {
        for (String seat : alreadySeat) {
            String seatRow = seat.substring(0, seat.length()-1);
            String seatColumn = seat.substring(seat.length()-1);
            char column = seatColumn.charAt(0);
            if(seatColumn.equals("K") || seatColumn.equals("J")) {
                seats[Integer.parseInt(seatRow)][column - 66] = true;
            }
            seats[Integer.parseInt(seatRow) - 1][column - 65] = true;
        }
    }
}
