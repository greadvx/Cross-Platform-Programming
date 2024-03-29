package by.bsuir.Khamutouski;

import java.util.Random;

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
     * {@value #MAXIMAL_MARK} Maximal mark value.
     * */
    public static final int MAXIMAL_MARK = 10;
    /**
     * {@value #DEFAULT_PHOTO} Default path.
     * */
    private static final String DEFAULT_PHOTO = "/Users/greadvx/"
            + "Desktop/StudentImageProfile.jpg";
    private int course;
    private University university;
    /**
     * Default constructor with params.
     * @param scholarPerson a scholar.
     * */
    Student(final Scholar scholarPerson) {
        super(scholarPerson.getName(),
                scholarPerson.getSurname(), DEFAULT_PHOTO);
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
        Random randNumber = new Random();
        for (int index = 0; index < COUNT_OF_MARKS; index++) {
            this.setMark(index, randNumber.nextInt(MAXIMAL_MARK));
        }
    }
    /**
     * Getter for course.
     * */
    public int getCourse() {
        return this.course;
    }
    /**
     * Method to attach university.
     * @param thisUniversity - university.
     * */
    public void attachUniversity(final University thisUniversity) {
        this.university = thisUniversity;
    }
}
