package lesson12;

public class UkranianBankSystem implements BankSystem {

//    public UkranianBankSystem() {
//    }

    @Override
    public void withdraw(User user, int amount) {

        if (!checkWithdraw(user, amount))
            return;

        user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));

    }

    @Override
    public void fund(User user, int amount) {
        if (user.getBank().getLimitOfFunding() > amount)
            user.setBalance(user.getBalance() + (amount - amount * user.getBank().getCommission(amount)));
        else
            System.err.println("Can't fund money " + user.getSalary() + " to user " + user.toString());
    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {

        if (!checkWithdraw(fromUser, amount))
            return;

        if (toUser.getBank().getLimitOfFunding() < amount)
            return;

        //fromUser.setBalance(fromUser.getBalance() - amount - fromUser.getBank().getCommission(amount));

        withdraw(fromUser, amount);
        fund(toUser, amount);
    }

    @Override
    public void paySalary(User user) {
        if (user.getBank().getLimitOfFunding() > user.getSalary())
            user.setBalance(user.getBalance() + (user.getSalary() - user.getSalary() * user.getBank().getCommission(user.getSalary())));
        else
            System.err.println("Can't pay salary " + user.getSalary() + " to user " + user.toString());
    }

    private void printWithdravalErrorMsg(int amount, User user) {
        System.err.println("Can't withdraw money " + amount + " from user " + user.toString());
    }

    private boolean checkWithdraw(User user, int amount) {
        return checkWithdrawLimits(user, amount, user.getBank().getLimitOfWithdrawal()) && checkWithdrawLimits(user, amount, user.getBalance());
    }

    private boolean checkWithdrawLimits(User user, int amount, double limit) {
        if (amount + user.getBank().getCommission(amount) > limit) {
            printWithdravalErrorMsg(amount, user);
            return false;
        }
        return true;
    }

}
