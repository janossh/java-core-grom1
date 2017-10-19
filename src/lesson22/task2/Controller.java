package lesson22.task2;


import lesson22.task2.exeption.BadRequestException;
import lesson22.task2.exeption.InternalServerException;
import lesson22.task2.exeption.LimitExceeded;

public class Controller {
    //private TransactionDAO transactionDAO = new TransactionDAO();

    public static Transaction save(Transaction transaction) throws LimitExceeded, BadRequestException, InternalServerException {
        return TransactionDAO.save(transaction);
    }

    public static Transaction[] transactionList() {
        return TransactionDAO.transactionList();
    }

    public static Transaction[] transactionList(String city) {
        return TransactionDAO.transactionList(city);
    }

    public static Transaction[] transactionList(int amount) {
        return TransactionDAO.transactionList(amount);
    }
}
