package lesson30.task1;

public class Main {
    public static void main(String[] args) {
        Bank usBank = new USBank(1222, "Sweden", Currency.EUR, 100, 10, 4, 444343434);
        User user1 = new User(1001, "Denis", 200, 40, "GMD", 10, usBank);
        User user2 = new User(1002, "Taras", 200, 42, "DMG", 10, usBank);

        Bank euBank = new EUBank(1223, "Sweden", Currency.EUR, 100, 10, 4, 444343434);
        User user3 = new User(1003, "John", 200, 32, "GMD", 10, euBank);
        User user4 = new User(1004, "Sara", 200, 12, "GMD", 10, euBank);

        Bank chBank = new EUBank(1224, "Sweden", Currency.EUR, 100, 10, 4, 444343434);
        User user5 = new User(1005, "Ivan", 200, 14, "GMD", 10, chBank);
        User user6 = new User(1006, "Oleg", 200, 33, "GMD", 10, chBank);

        BankSystem bankSystem = new UkranianBankSystem();

        runMyMetod(new User[] {user1, user2,user3,user4, user5,user6}, bankSystem);
        //runMyMetod(new User[] {user1, user2}, bankSystem);

    }

    private static void runMyMetod(User[] users, BankSystem bankSystem) {

        for (int i = 0; i < users.length; i++) {
            bankSystem.withdraw(users[i], 10);
            bankSystem.fund(users[i], 200);
            bankSystem.paySalary(users[i]);
            bankSystem.transferMoney(users[i], users[i == (users.length - 1) ? 0 : i+1], 15);

        }

        for (User el: users)
            System.out.println(el.toString());

    }
}
