package lesson19;

public class ThrowExample {
    private static String[] array = {"test", "test1", "tessdf", null, "sdfsdf", "sdfsdf"};

    public static void main(String[] args) {
        useOfTestMethod();
    }

    private static void test()  {
        for (String element : array) {
            if (element == null)
                throw new RuntimeException("null is detected");
        }
        System.out.println("Done");
    }

    private static void useOfTestMethod() {
        try {
            test();
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}
