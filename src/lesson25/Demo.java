package lesson25;

public class Demo {
    public static void main(String[] args) throws Exception {
        GeneralDAO generalDAO = new GeneralDAO();
        Order order = new Order(1);
        generalDAO.validate(order);

        TestClass<String, Order, Long> testClass = new TestClass();
        System.out.println(testClass.doSomesing1("rrr"));

        int test = 100;
        long varaible = 111;
        Long variable2 = 222L;

        generalDAO.validate(variable2);
        generalDAO.validate(varaible);
        generalDAO.validate(test);
    }
}
