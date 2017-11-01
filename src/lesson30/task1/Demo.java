package lesson30.task1;

public class Demo {
    public static void main(String[] args) throws Exception {
        Bank euBank = new EUBank(1222, "Sweden", Currency.EUR, 100, 10, 4, 444343434);
        User user = new User(1005, "Ivan", 200, 14, "GMD", 10, euBank);

        UkranianBankSystem bankSystem = new UkranianBankSystem();

        Thread.sleep(2000);

        bankSystem.withdraw(user, 150);
        System.out.println(bankSystem.getTransactions());
    }
}
