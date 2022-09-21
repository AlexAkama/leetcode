package interview.overloading;

// Что будет?
// - Ошибка компиляции
// - Ошибка выполнения
// - Напечатано 2
// - Напечатано 1
public class Testing {

    private int value = 1;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
//        value = value; // -> 1
        this.value = value; // -> 2
    }

    public static void main(String[] args) {
        int a = 2;
        Testing t = new Testing();
        t.setValue(a);
        System.out.println(t.getValue());
    }

}
