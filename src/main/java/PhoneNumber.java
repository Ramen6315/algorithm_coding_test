import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PhoneNumber {
    public  void main(String[] args) {
        String[] phone_book = {"123","456","789"};
        System.out.println(solution(phone_book));
    }

    public  boolean solution(String[] phone_book) {

        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            if(phone_book[i].length() <= phone_book[i+1].length()) {
                String substringNextPhone = phone_book[i + 1].substring(0, phone_book[i].length());
                if(phone_book[i].equals(substringNextPhone)) {
                    return false;
                }
            }
        }
        return true;
    }
}
