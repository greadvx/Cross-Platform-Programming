package by.bsuir.Khamutouski;
/**
 * <h1>School</h1>
 * <p>
 * This class in used to
 * store info about school.
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
public class School extends EstablishmentOfEducation {
    /**
     * Field Scholar.
     * */
    private Scholar pupil;

    /**
     * Default constructor.
     * */
    School() {
        super();
        this.pupil = null;
    }
    /**
     * Constructor with params.
     * @param nameOfSchool String – name.
     * */
    School(final String nameOfSchool) {
        super(nameOfSchool);
        this.pupil = null;
    }
    /**
     * Getter of photoPath.
     * @return String - photoPath.
     * */
    public String getPhotoPath() {
        return this.pupil.getPhotoPath();
    }
    /**
     * Method deductLeaner.
     * Deduct Scholar from the school.
     * */
    @Override
    public void deductLeaner() {
        this.pupil = null;
    }
    /**
     * Method enrollLeaner.
     * It enrols scholar to school.
     * @param newPupil Scholar.
     * */
    public void enrollLeaner(final Scholar newPupil) {
        this.pupil = newPupil;
    }
    /**
     * Getter of surname of scholar
     * by calling its own getter.
     * @return String – Surname.*/
    public String surnameOfScholar() {
        return this.pupil.getSurname();
    }
    /**
     * Getter of name of scholar
     * by calling its own getter.
     * @return String – Name.
     * */
    public String nameOfScholar() {
        return this.pupil.getName();
    }
    /**
     * Getter of Form of scholar
     * by calling its own getter.
     * @return Int – Form.
     * */
    public int formOfScholar() {
        return this.pupil.getForm();
    }
    /**
     * Getter of Marks of scholar
     * by calling its own method.
     * @return String - All marks.
     * */
    public String marksOfScholar() {
        return this.pupil.getAllMarksValue();
    }
    /**
     * Getter of name of school.
     * @return String – Name.
     * */
    public String nameOfSchool() {
        return this.getNameOfEstablishment();
    }
    /**
     * Method teach Pupil.
     * Randomizing of marks. */
    public void teachPupil() {
        this.pupil.studying();
    }
    /**
     * Getter of current pupil at the school.
     * @return Scholar - this pupil.*/
    public Scholar thisPupil() {
        return this.pupil;
    }
}
