package by.bsuir.Khamutouski;
/**
 * <h1>University</h1>
 * <p>
 * This class in used to
 * store info about university.
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
public class University extends EstablishmentOfEducation {
    /**
     * {@value #PASSING_SCORE} Code of
     * success exit operation.
     * */
    private static final double PASSING_SCORE = 4.7;
    /**
     * Field student.
     * */
    private Student student;
    /**
     * Default constructor with params.
     * @param nameOfUniversity String name.
     * */
    University(final String nameOfUniversity) {
        super(nameOfUniversity);
        this.student = null;
    }
    /**
     * Method to conduct exam.
     * @param enrollPerson Scholar.
     * @return boolean – result of exam.
     * */
    public static boolean conductExam(final Scholar enrollPerson) {

        if (enrollPerson.voutes() >= PASSING_SCORE) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Method deductLeaner.
     * Makes student = null.
     * */
    @Override
    public void deductLeaner() {
        this.student = null;
    }
    /**
     * Method enrollLeaner.
     * It enroll a student to the university.
     * @param newStudent Student.
     * */
    public void enrollLeaner(final Student newStudent) {
        this.student = newStudent;
    }
}

