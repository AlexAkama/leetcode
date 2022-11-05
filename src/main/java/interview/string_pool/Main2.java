package interview.string_pool;

public class Main2 {

    public static void main(String[] args) {
        String s = new String("test");
        StringBuffer sb1 = new StringBuffer("test");
        StringBuffer sb2 = new StringBuffer("test");
        System.out.println(s.equals(sb1));
        System.out.println(sb1.equals(s));
        System.out.println(sb1.equals(sb2));
    }

}
