package interview.inheritance;

// Что будет напечатано
public class BaseClass {

    int x = 0;

    public int getX() {
        return x;
    }

    public static void main(String[] args) {
        BaseClass clazz = new SubClass();
        System.out.println(clazz.x + " " + clazz.getX());
        SubClass sub = (SubClass) clazz;
        System.out.println(sub.x + " " + sub.getX());
    }

}

class SubClass extends BaseClass {

    //Переменная специально названа также как суперклассе!!!
    int x = 1;

    @Override
    public int getX() {
        return x;
    }

}
