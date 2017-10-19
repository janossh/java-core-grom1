package lesson8.classStudent;

import java.util.Date;

public class Demo {

    public Student createHighestParent() {
        Course[] coursesTaken = new Course[8];
        Student rr = new Student("firstName", "lastName", 20, coursesTaken);
        return rr;
    }

    public SpecialStudent createLowestChild () {
        Course[] coursesTaken = new Course[8];
        SpecialStudent rr = new SpecialStudent("firstName", "lastName", 20, coursesTaken, 4564, "email");
        return rr;
    }


}
