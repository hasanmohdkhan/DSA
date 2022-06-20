package merge;

/**
 * @Created: 16/06/2022
 * @author: hasan.khan
 */
public class TestValue {
    static int a1 = 5;
    static int b2 = 7;

    class Data {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("data{");
            sb.append("name='").append(name).append('\'');
            sb.append(", age=").append(age);
            sb.append('}');
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 7;
        swap(a1, b2);
        System.out.println("OutSide : a: " + a1 + ",  b:" + b2);

        TestValue testValue = new TestValue();
        Data data = testValue.getData();
        data.setName("outside");
        data.setAge(1);


        alterObject(data);

        System.out.println("out Object: "+data);
    }

    private Data getData() {
        return new Data();
    }

    private static void alterObject(Data data) {
        data.setName("inside alter");
        data.setAge(2);

        System.out.println("Object: "+data);

    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;

        System.out.println("Inside : a: " + a + ",  b:" + b);

    }


}
