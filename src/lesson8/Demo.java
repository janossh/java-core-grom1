package lesson8;

public class Demo {
    public static void main(String[] args) {
        Adder myAdder = new Adder();
        int[] array = {11, 12, 10, 5, 4, 44, 94, 44, 11, 10, 11};
        System.out.println(myAdder.check(array));
        System.out.println(myAdder.add(5,15));
    }
}
