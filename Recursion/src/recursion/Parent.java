package recursion;

/**
 * @Created: 25/05/2022
 * @author: hasan.khan
 */
public class Parent {

    public void greetings() {
        System.out.println("Hello from Parent");
    }
}

class Child extends Parent {
    public void greetings() {
        System.out.println("Hello from Child class...");
    }

}


class Test {

    public static void main(String[] args) {
        Parent p = new Parent();
        p.greetings();

        Parent p2 = new Child();
        p2.greetings();

    }
}
