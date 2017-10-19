package lesson22.task2;

import lesson22.task2.exeption.BadRequestException;
import lesson22.task2.exeption.InternalServerException;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Transaction transaction0 = new Transaction(123, "Kiev", 12, "AAA", TransactionType.INCOME, new Date());
        Transaction transaction1 = new Transaction(123, "Kiev", 12, "AAA", TransactionType.INCOME, new Date());
        Transaction transaction2 = new Transaction(123, "Kiev", 12, "AAA", TransactionType.INCOME, new Date());
        //Controller controller = new Controller();

        try {
            System.out.println(Controller.save(transaction0).getId());
            System.out.println(Arrays.toString(Controller.transactionList()));
            System.out.println(Arrays.toString(Controller.transactionList("Kiev")));
            System.out.println(Arrays.toString(Controller.transactionList(10)));

        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        } catch (InternalServerException e) {
            System.out.println(e.getMessage());
        }

    }
}
