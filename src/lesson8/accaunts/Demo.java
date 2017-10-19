package lesson8.accaunts;

public class Demo {
    public static void main(String[] args) {
        SavingAccaut savingAccaut = new SavingAccaut("SomeBank", "Denis", 1000, 50);
        savingAccaut.depositMoney(100);

        System.out.println(savingAccaut.moneyAmount);

        savingAccaut.changeOwnerName("Oleg");
        System.out.println(savingAccaut.ownerName);

        ChekingAccaunt chekingAccaunt = new ChekingAccaunt("SomeBank", "Denis", 1000, 500 );
        chekingAccaunt.changeOwnerName("Oleg");

        System.out.println(chekingAccaunt.ownerName);
    }
}
