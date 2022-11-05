package interview.exeption_or_not_compile;

// Что выведет код?
// 1. Произойдет RuntimeException в строке 1
// 2. null (5раз)
// 3. Произойдет RuntimeException в строке 2
// 4. Код не скомпилируется
// 5. Произойдет RuntimeException в строке 3
public class NullAndString {

    public static void main(String[] args) {
        String nullString = null;
        System.out.print(null + nullString); //1
        System.out.print(nullString + null); //2
        System.out.print((String) null); //3
    }

}
