package by.bsuir.Khamutouski;
/**
 * <h1>Establishment of education</h1>
 *
 * <p>
 * This is a class of application
 * that contain name of establishment of education.
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
public class EstablishmentOfEducation {
    /**
     * {@value #DEFAULT_NAME} default name of
     * educational establishment.
     * */
    private static final String DEFAULT_NAME = "none";
    /***/
    private Leaner leaner;
    /***/
    private String nameOfEstablishment;
    /**
     * Default constructor.
     * */
    EstablishmentOfEducation() {
        this.nameOfEstablishment = DEFAULT_NAME;
    }
    /**
     * Constructor with params.
     * @param name Name for establishment.
     */
    EstablishmentOfEducation(final String name) {
        this.nameOfEstablishment = name;
    }
    /**
     * Method to set name.
     * @param newName Name for establishment.
     */
    public void setNameOfEstablishment(final String newName) {
        this.nameOfEstablishment = newName;
    }
    /**
     * Method to deduct Leaner.
     */
    public void deductLeaner() {
        leaner = null;
    }
    /**
     * Method to enroll Leaner.
     */
    public void enrollLeaner() {

    }
    /**
     * Method to get name of the
     * establishment of education.
     * @return String its name.
     */
    public String getNameOfEstablishment() {
        return this.nameOfEstablishment;
    }
}
