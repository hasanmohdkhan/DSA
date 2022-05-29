package merge;

/**
 * @Created: 29/05/2022
 * @author: hasan.khan
 */
public class Test {

    static class Parent {
        void printData() {
            System.out.println(getString());
        }

        String getString() {
            return "Parent";
        }
    }

    static class Child extends Parent {
        @Override
        String getString() {
            return "Child";
        }
    }

    public static void main(String[] args) {
       // Child ch = new Parent();
        // ch.printData();
        Parent p = new Child();
        p.printData();

    }
}
