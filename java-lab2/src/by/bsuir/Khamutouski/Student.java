package by.bsuir.Khamutouski;

public class Student extends Leaner {

    private final static int MINIMAL_VALUE = 1;
    private final static int MAXIMAL_VALUE = 4;
    private int course;
    Student(){
        super();
        this.course = MINIMAL_VALUE;
    }
    Student(final String name, final String surname) {
        super(name, surname);
        this.course = MINIMAL_VALUE;
    }
    @Override
    public void studying() {
        if (this.course < MAXIMAL_VALUE) {
            this.course++;
        }
    }

}
