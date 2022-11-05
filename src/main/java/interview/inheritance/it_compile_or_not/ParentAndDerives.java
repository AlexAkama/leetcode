package interview.inheritance.it_compile_or_not;

public class ParentAndDerives {

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
    // Компилятор не даст присвоить (можно кастить к родителю, не к другому наследнику)

}
