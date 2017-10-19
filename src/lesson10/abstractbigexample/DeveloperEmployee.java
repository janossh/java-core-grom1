package lesson10.abstractbigexample;

public class DeveloperEmployee extends Employee{
    private String[] frameworks = new String[10];

    @Override
    void paySalary() {
        int newBalance = getBankAccaunt().getBalance()+getSalaryPerMonth()+1000;
        getBankAccaunt().setBalance(newBalance);
    }
}
