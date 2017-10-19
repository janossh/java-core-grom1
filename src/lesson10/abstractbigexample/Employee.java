package lesson10.abstractbigexample;

public abstract class Employee {
    private String name;
    private int age;
    private int earsOfExperience;

    private String curPosition;

    private int salaryPerMonth;
    private BankAccount bankAccaunt;

    private Company[] companiesWorked = new Company[10];
    private String[] positionsWorked = new String[10];

    abstract void paySalary();

    void changePosition(String newPosition) {
        saveCurPositionToHistory();
        curPosition = newPosition;
    }

    private void saveCurPositionToHistory() {
        int index = 0;
        for (String pos : positionsWorked) {
            if (pos == null) {
                positionsWorked[index] = curPosition;
                break;
            }
            index++;
        }
    }

    int getBalance() {
        return bankAccaunt.getBalance();
    }

    public int getSalaryPerMonth() {
        return salaryPerMonth;
    }

    public BankAccount getBankAccaunt() {
        return bankAccaunt;
    }

    public String getName() {
        return name;
    }
}
