package by.bsuir.Khamutouski;
/**
 * <h1>Leaner</h1>
 * <p>
 * This class is used to
 * store info about leaner.
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
public class Leaner {
    /**
     * {@value #COUNT_OF_MARKS} Contains maximal
     * count of marks.
     * */
    public static final int COUNT_OF_MARKS = 3;
    /**
     * {@value #DEFAULT_MARK} Contains default
     * mark.
     * */
    private static final int DEFAULT_MARK = 0;
    /**
     * {@value #NONE} Contains default string
     * to fill row.
     * */
    private static final String NONE = "none";
    /**
     * {@value #DEFAULT_PHOTO} Default path to
     * the photo of profile.
     * */
    private static final String DEFAULT_PHOTO = "/Users/greadvx/"
            + "Desktop/ScholarImageProfile.jpg";
    /**
     * {@value #SPACE} Space between lines.
     * */
    private static final String SPACE = " ";
    /**
     * Private field name.
     * */
    private String name;
    /**
     * Private field surname.
     * */
    private String surname;
    /**
     * Private field photoPath.
     * */
    private String photoPath;
    /**
     * Private field array of marks.
     * */
    private int[] marks = new int[COUNT_OF_MARKS];
    /**
     * Default constructor.
     * */
    Leaner() {
        this.name = NONE;
        this.surname = NONE;
        this.photoPath = DEFAULT_PHOTO;
        for (int i = 0; i < COUNT_OF_MARKS; i++) {
            this.marks[i] = DEFAULT_MARK;
            this.photoPath = DEFAULT_PHOTO;
        }
    }
    /**
     * Constructor with params.
     * @param newName name.
     * @param newSurname surname.
     * @param photo photo path.
     * */
    Leaner(final String newName, final String newSurname,
           final String photo) {
        this.name = newName;
        this.surname = newSurname;
        for (int i = 0; i < COUNT_OF_MARKS; i++) {
            this.marks[i] = DEFAULT_MARK;
        }
        if (photo == "") {
            this.photoPath = DEFAULT_PHOTO;
        }
    }
    /**
     * Setter for the name.
     * @param newName name.
     * */
    public void setName(final String newName) {
        this.name = newName;
    }
    /**
     * Setter for the surname.
     * @param newSurname surname.
     * */
    public void setSurname(final String newSurname) {
        this.surname = newSurname;
    }
    /**
     * Getter for the name.
     * @return String name.
     * */
    public String getName() {
        return this.name;
    }
    /**
     * Getter for the surname.
     * @return String surname.
     * */
    public String getSurname() {
        return this.surname;
    }
    /**
     * Setter for the photoPath.
     * @param newPhotoPath photo path.
     * */
    public void setPhotoPath(final String newPhotoPath) {
        this.photoPath = newPhotoPath;
    }
    /**
     * Getter for the photoPath.
     * @return String photoPath.
     * */
    public String getPhotoPath() {
        return this.photoPath;
    }
    /**
     * Setter for the marks.
     * @param atIndex index in array of marks.
     * @param mark mark to save.
     * */
    public void setMark(final int atIndex, final int mark) {
        this.marks[atIndex] = mark;
    }
    /**
     * Method studing.
     * */
    public void studying() {

    }
    /**
     * Getter for the marks
     * to String.
     * @return String - array of marks.
     * */
    public String getAllMarksValue() {
        String arrayOfMarks = "";
        for (int mark : this.marks) {
            arrayOfMarks += Integer.toString(mark);
            arrayOfMarks += SPACE;
        }
        return arrayOfMarks;
    }
    /**
     * Making arithmetical operation
     * with marks to pass the exam.
     * @return double summary.
     * */
    public double voutes() {
        double sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        sum /= marks.length;
        return sum;
    }

}
