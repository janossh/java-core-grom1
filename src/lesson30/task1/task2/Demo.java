package lesson30.task1.task2;

public class Demo {
    public static void main(String[] args) {
        Controller controller = new Controller();
        //System.out.println(controller.employeesByProject(controller.getProject(0)));
        System.out.println(controller.employeesByTeamLead(controller.getEmployee(2)));
    }
}
