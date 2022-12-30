package interview.string_pool;

public class Main3 {

    public static void main(String[] args) {

        /*
        Что напечатается?
         */

        String s1 = "Java";
        String s2 = new String("Java");
        System.out.println(s1 == s2);
        s2 = s2.intern();
        System.out.println(s1 == s2);

        StringBuilder sb = new StringBuilder();
        sb.append("Happy ");
        sb.append("new ");
        sb.append("year!");
        String res = sb.toString();

        System.out.println(res == "Happy new year!");
        System.out.println(res.equals("Happy new year!"));

    }
}
