package lesson22.task2;


import lesson22.task2.exeption.BadRequestException;
import lesson22.task2.exeption.InternalServerException;
import lesson22.task2.exeption.LimitExceeded;

public class Controller {
    private TransactionDAO transactionDAO = new TransactionDAO();

    public Transaction save(Transaction transaction) throws LimitExceeded, BadRequestException, InternalServerException {
        return transactionDAO.save(transaction);
    }

    public Transaction[] transactionList() {
        return transactionDAO.transactionList();
    }

    public Transaction[] transactionList(String city) {
        return transactionDAO.transactionList(city);
    }

    public Transaction[] transactionList(int amount) {
        return transactionDAO.transactionList(amount);
    }
}
