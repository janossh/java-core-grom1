package lesson8.accaunts;

public class Accaunt {
    String bankName;
    String ownerName;
    int moneyAmount;

    public Accaunt(String bankName, String ownerName, int moneyAmount) {
        this.bankName = bankName;
        this.ownerName = ownerName;
        this.moneyAmount = moneyAmount;
    }

    void depositMoney(int amount) {
        moneyAmount +=amount;
    }
    void depositMoney() {
        moneyAmount +=1000;
        System.out.println("deposit was successful");
    }


    void changeOwnerName(String newOwnerName) {
        ownerName = newOwnerName;
    }
}
