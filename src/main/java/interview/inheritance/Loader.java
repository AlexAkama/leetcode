package interview.inheritance;

public class Loader {

    class Parent {

    }

    class DeriveOne extends Parent {

    }

    class DeriveTwo extends Parent {

    }

    Parent p = new Parent();
    DeriveOne d1 = new DeriveOne();
    DeriveTwo d2 = new DeriveTwo();
    //d1 = (DeriveOne) d2;

}
