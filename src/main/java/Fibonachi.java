import java.math.BigDecimal;

public class Fibonachi {
    public  void main(String[] args) {
        System.out.println(solution(10000));
    }

    public  int solution(int n) {

        BigDecimal fibo = fibo(n);
        BigDecimal divide = fibo.remainder(new BigDecimal(1234567));
        divide.intValue();
        return divide.intValue();
    }

    private  BigDecimal fibo(int n) {
        BigDecimal[] fiboDP = new BigDecimal[n+1];
        fiboDP[0] = new BigDecimal(0);
        fiboDP[1] = new BigDecimal(1);
        fiboDP[2] = new BigDecimal(1);
        for (int i = 2; i <= n; i++) {
            fiboDP[i] = fiboDP[i-1].add(fiboDP[i-2]);
        }
        return fiboDP[n];
    }
}
