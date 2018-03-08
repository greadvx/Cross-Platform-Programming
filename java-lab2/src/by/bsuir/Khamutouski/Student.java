package by.bsuir.Khamutouski;

public class Student extends Leaner {

    private final static int MINIMAL_VALUE = 1;
    private final static int MAXIMAL_VALUE = 4;
    private int course;

    Student(Scholar scholarPerson) {
        super(scholarPerson.getName(),
                scholarPerson.getSurname());
        this.course = MINIMAL_VALUE;
    }
    @Override
    public void studying() {
        if (this.course < MAXIMAL_VALUE) {
            this.course++;
        }
    }

}
