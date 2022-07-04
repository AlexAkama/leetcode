package leetcode.solution;

import java.util.ArrayList;
import java.util.List;

//
//
//
public class Solution0412 {

    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            boolean divBy3 = i % 3 == 0;
            boolean divBy5 = i % 5 == 0;
            if (divBy3 && divBy5) {
                list.add("FizzBuzz");
            } else if (divBy3) {
                list.add("Fizz");
            } else if (divBy5) {
                list.add("Buzz");
            } else {
                list.add("" + i);
            }
        }
        return list;
    }

}
