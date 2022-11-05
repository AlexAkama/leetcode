package interview.inheritance;

// Что будет напечатано?
public class Family {

    public static void main(String[] args) {
        Me me = new Me();
        Daddy daddy = new Me();
        me.say();
        daddy.say();
    }

}

class Daddy {

    void say() {
        System.out.println("I'm a Daddy");
    }

}

class Me extends Daddy {

    void say() {
        System.out.println("I's Me");
    }

}