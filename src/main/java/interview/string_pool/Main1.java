package interview.string_pool;

public class Main1 {

    public static void main(String[] args) {
        String s = new String("test");
        String s1 = new String("test");
        String s2 = new String("test");
        System.out.println(s.equals(s1));
        System.out.println(s1.equals(s));
        System.out.println(s1.equals(s2));
    }

}
