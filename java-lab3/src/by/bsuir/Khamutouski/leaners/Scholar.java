package by.bsuir.Khamutouski.leaners;

import java.util.Random;
import by.bsuir.Khamutouski.establishments.School;
import by.bsuir.Khamutouski.establishments.University;
/**
 * <h1>Scholar</h1>
 * <p>
 * This class of application contains
 * info about scholar
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
public class Scholar extends Leaner {
    /**
     * {@value #MAXIMAL_FORM} Maximal form value.
     * */
    private static final int MAXIMAL_FORM = 11;
    /**
     * {@value #DEFAULT_FORM} Default form value.
     * */
    private static final int DEFAULT_FORM = 1;
    /**
     * {@value #MAXIMAL_MARK} Maximal mark value.
     * */
    public static final int MAXIMAL_MARK = 10;
    /**
     * Field form – year of education.
     * */
    private int form;
    /**
     * Field school.
     * */
    private School school;
    /**
     * Default constructor.
     * */
    Scholar() {
        super();
        this.form = DEFAULT_FORM;
        this.school = null;
    }
    /**
     * Constructor with params.
     * @param name name of scholar.
     * @param surname surname of scholar.
     * @param photo photo path.
     *
     * */
    Scholar(final String name, final String surname,
            final String photo) {
        super(name, surname, photo);
        this.form = DEFAULT_FORM;
    }
    /**
     * Method to attach school.
     * @param thisSchool - school to attach.
     * */
    public void attachSchool(final School thisSchool) {
        this.school = thisSchool;
    }
    /**
     * Method studying.
     * Its randomize value of marks
     * and its upscale his iq.
     * */
    public void studying() {
        if (this.form == MAXIMAL_FORM) {
            this.leaveSchool();
        } else {
            this.form++;
            this.iq++;
            Random randNumber = new Random();
            for (int index = 0; index < COUNT_OF_MARKS; index++) {
                this.setMark(index, randNumber.nextInt(MAXIMAL_MARK));
            }
        }
    }
    /**
     * Getter for the for of the scholar.
     * @return int Form.
     * */
    public int getForm() {
        return this.form;
    }
    /**
     * Method to leave the school.
     * */
    public void leaveSchool() {
        school.deductLeaner(this);
    }
    /**
     * Method to pass exam, that
     * calls conduct exam of class University.
     * @return booleat passed or not.
     * */
    public boolean passTheExam(University university) {
        return university.conductExam(this);
    }
}
