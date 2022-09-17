package interview.overloading;

class SuperBase {

    public int i = 3;

    public void foo(Object o) {
        System.out.println("Object " + i);
    }

    public void foo(String s) {
        System.out.println("String " + i);
    }

}

class Base extends SuperBase {

    public Base() {
        i = 5;
    }

    public static void main(String[] args) {
        SuperBase sb = new Base();
        Object o = "";
        sb.foo(o);
        sb.foo("");
    }

}
