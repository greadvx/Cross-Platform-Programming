package by.bsuir.Khamutouski.leaners;

import java.util.Random;
import by.bsuir.Khamutouski.establishments.University;

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
 * @version 2.0
 * @since 2018-03-16
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
     * {@value #IQ_COEFFICIENT} Value to upscale iq.
     * */
    public static final int IQ_COEFFICIENT = 5;
    /**
     * {@value #DEFAULT_PHOTO} Default path.
     * */
    private static final String DEFAULT_PHOTO = "/Users/greadvx/"
            + "Desktop/StudentImageProfile.jpg";
    /**
     * Private field course.
     * */
    private int course;
    /**
     * Private field university.
     * */
    private University university;
    /**
     * Default constructor with params.
     * @param scholarPerson a scholar.
     * */
    public Student(final Scholar scholarPerson) {
        super(scholarPerson.getName(),
                scholarPerson.getSurname(), DEFAULT_PHOTO);
        this.course = MINIMAL_VALUE;
        this.iq = scholarPerson.iq;
    }
    /**
     * Constructor of copying.
     * @param anotherStudent - Student.
     * */
    public Student(final Student anotherStudent) {
        super(anotherStudent.getName(), anotherStudent.getSurname(),
                anotherStudent.getPhotoPath());
        this.course = anotherStudent.getCourse();
        this.iq = anotherStudent.iq;
        this.university = new University(anotherStudent.getUniversity());

    }
    /**
     * Method that perform studying.
     * */
    @Override
    public void studying() {
        if (this.course < MAXIMAL_VALUE) {
            this.course++;
        }
        this.iq += IQ_COEFFICIENT;
        Random randNumber = new Random();
        for (int index = 0; index < COUNT_OF_MARKS; index++) {
            this.setMark(index, randNumber.nextInt(MAXIMAL_MARK));
        }
    }
    /**
     * Method increase intellect.
     * */
    public void increaseIntellect() {
        this.iq += MINIMAL_VALUE;
    }
    /**
     * Getter for course.
     * @return int - course.
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

    /**
     * Getter for copying.
     * @return University.
     * */
    public University getUniversity() {
        return this.university;
    }
}