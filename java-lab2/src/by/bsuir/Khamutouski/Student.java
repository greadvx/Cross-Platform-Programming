package by.bsuir.Khamutouski;
/**
 * <h1>Student</h1>
 * <p>
 * This is a class of application
 * contains info about student.
 * </p>
 *
 * This class is used in hierarchy of
 * inheritance.
 *
 * @author Yan Khamutouski
 * @version 1.0
 * @since 2018-03-11
 *
 * */
public class Student extends Leaner {
    /**
     * {@value #MINIMAL_VALUE} Minimal value of
     * course.
     * */
    private static final int MINIMAL_VALUE = 1;
    /**
     * {@value #MINIMAL_VALUE} Maximal value of
     * course.
     * */
    private static final int MAXIMAL_VALUE = 4;
    /**
     * Field course.
     * */
    private int course;
    /**
     * Default constructor with params.
     * @param scholarPerson a scholar.
     * */
    Student(final Scholar scholarPerson) {
        super(scholarPerson.getName(),
                scholarPerson.getSurname(), "");
        this.course = MINIMAL_VALUE;
    }
    /**
     * Method that perform studying.
     * */
    @Override
    public void studying() {
        if (this.course < MAXIMAL_VALUE) {
            this.course++;
        }
    }

}
