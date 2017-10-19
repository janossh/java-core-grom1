package lesson5;

import java.util.Arrays;

public class HomeWork2 {

    public static void main(String[] args) {
        String[] names = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"};
        int[] balances = {100, 500, 8432, -100, 12000, -54, 0};

        System.out.println(withdraw(names, balances, "Andrey", 2147483647));
        //System.out.println ( Arrays.toString (balances));
    }

    public static int withdraw(String[] clients, int[] balances, String client, int amount) {
        int index = findClientIndexByName(clients, client);
        if (index < 0)
            return -1;

        if (((long) balances[index] - (long) amount) < 0) {
            return -1;
        } else {
            balances[index] -= amount;
            return balances[index];
        }
    }

    public static int findClientIndexByName(String[] clients, String client) {
        int clientIndex = 0;

        for (String cl : clients) {
            if (cl == client) {
                break;
            }
            clientIndex++;
        }
        return clientIndex > clients.length - 1 ? -1 : clientIndex;
    }
}