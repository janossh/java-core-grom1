package lesson8.accaunts;

public class ChekingAccaunt extends Accaunt {
    int limitOfExpenses;

    public ChekingAccaunt(String bankName, String ownerName, int moneyAmount, int limitOfExpenses) {
        super(bankName, ownerName, moneyAmount);
        this.limitOfExpenses = limitOfExpenses;
    }

    void whisdraw(int amount) {
        if (amount > limitOfExpenses)
            return;
        moneyAmount -= amount;
    }


}
