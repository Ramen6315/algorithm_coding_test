import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;

//1. 문제 요구 사항을 제대로 읽을것
//2. Map을 Class로 감싸서 푸는 것도 코테 볼때는 방법으로 보임
public class ParkingPay {
    public static void main(String[] args) {
        int[] fees = {1, 461, 1, 10};
        String[] records = {"00:00 1234 IN"};
        ParkingPay parkingPay = new ParkingPay();
        parkingPay.solution(fees, records);
    }

    public int[] solution(int[] fees, String[] records) {
        Fee fee = new Fee(fees);
        TimeLine timeLine = new TimeLine();
        for (String record : records) {
            timeLine.add(record);
        }
        List<Integer> totalTimes = timeLine.calculateTotalTime();
        List<Integer> totalFees = new ArrayList<>();
        for (int totalTime : totalTimes) {
            totalFees.add(fee.calculateFee(totalTime));
        }
        int[] answer = new int[totalFees.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = totalFees.get(i);
        }

        return answer;
    }

    class TimeLine {
        Map<String, CarState> carTimeline = new HashMap<>();

        public void add(String record) {
            String[] carRecord = record.split(" ");
            if(!carTimeline.containsKey(carRecord[1])) {
                carTimeline.put(carRecord[1], new CarState(carRecord, 0));
            } else {
                CarState carState = carTimeline.get(carRecord[1]);

                if("OUT".equals(carRecord[2])) {
                    long time = calculateDuration(carState, carRecord[0] + ":00");
                    carState.setTime(carRecord[0]);
                    carState.setState("OUT");
                    carState.setDuration(time);
                } else {
                    carState.setTime(carRecord[0]);
                    carState.setState("IN");
                }

            }
        }

        private long calculateDuration(CarState carState, String next) {
            String time = carState.time + ":00";
            String nextTime = next;
            LocalTime.parse(time);
            LocalTime.parse(nextTime);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            try {
                Date inTimeDate = simpleDateFormat.parse(time);
                Date outTimeDate = simpleDateFormat.parse(nextTime);
                return outTimeDate.getTime() - inTimeDate.getTime();
            } catch (Exception e) {
                new Exception();
            }

            return 0;
        }

        public List<Integer> calculateTotalTime() {
            List<String> keys = new ArrayList<>(carTimeline.keySet());
            Collections.sort(keys);
            List<Integer> fees = new ArrayList<>();
            for (String carNumber : keys) {
                CarState carState = carTimeline.get(carNumber);
                if(carState.state.equals("IN")) {
                    long extraFees = (carState.duration + calculateDuration(carState, "23:59:59")) / 60000;
                    fees.add((int) extraFees);
                } else {
                    fees.add((int) carState.getDuration() / 60000);
                }
            }
            return fees;
        }

    }

    class CarState {
        String time;
        long duration;
        String state;

        public CarState(String[] carRecord, int duration) {
            this.time = carRecord[0];
            this.duration = duration;
            this.state = carRecord[2];
        }

        public void setState(String state) {
            this.state = state;
        }

        public void setDuration(long time) {
            this.duration += time;
        }

        public void setTime(String s) {
            this.time = s;
        }

        public long getDuration() {
            return this.duration;
        }
    }

    class Fee {
        int baseTime;
        int baseFee;
        int perTime;
        int perFee;

        public Fee(int[] fees) {
            this.baseTime = fees[0];
            this.baseFee = fees[1];
            this.perTime = fees[2];
            this.perFee = fees[3];
        }

        public int getBaseTime() {
            return baseTime;
        }

        public int getBaseFee() {
            return baseFee;
        }

        public int getPerTime() {
            return perTime;
        }

        public int getPerFee() {
            return perFee;
        }

        public int calculateFee(int totalTime) {
            int fee = 0;
            if(totalTime > baseTime) {
                fee += baseFee;
                totalTime -= baseTime;
                if(totalTime % perTime != 0) {
                    return fee + ((totalTime / perTime) + 1) * perFee;
                }
                fee += (totalTime / perTime) * perFee;
            } else {
                return baseFee;
            }
            return fee;
        }
    }

}
