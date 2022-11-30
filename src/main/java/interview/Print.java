package interview;

import java.util.Arrays;
import java.util.List;

public class Print {

    public static void main(String[] args) {
        String[] stringArray = {"Java", "fill", "the", "gaps"};
        var stringList = Arrays.asList(stringArray);
        System.out.println(stringList.contains("Java"));

        int[] intArray = {1, 2, 3};
        var intList = List.of(intArray);
        System.out.println(intList.contains(1));

        Integer[] intBoxArray = {1, 2, 3};
        var intBozList = Arrays.asList(intBoxArray);
        System.out.println(intList.contains(1));
        System.out.println(intList.contains(Integer.valueOf(1)));

    }


}
