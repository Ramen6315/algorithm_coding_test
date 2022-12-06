public class SoloNumber  {
    public  void main(String[] args) {
        SoloNumber soloNumber = new SoloNumber();
        int[] A = {9, 3, 9, 3, 9, 7, 9};
        System.out.println(soloNumber.solution(A));
    }
    public int solution(int[] A) {
        int result = 0;
        for (int i : A) {
            result = result ^ i;
        }

        return result;
    }
}
