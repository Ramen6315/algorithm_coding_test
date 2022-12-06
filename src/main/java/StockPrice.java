import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class StockPrice {
    public  void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        int[] input = {1, 2, 3, 2, 3};
        stockPrice.solution(input);
    }

    public int[] solution(int[] prices) {
        int[] results = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                results[i] +=1;
                if(prices[i] > prices[j]) {
                    break;
                }
            }
        }
        return results;
    }
}
