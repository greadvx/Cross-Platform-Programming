package by.bsuir.Khamutouski.establishments;

import java.util.ArrayList;
import by.bsuir.Khamutouski.leaners.Scholar;

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
 * @version 2.0
 * @since 2018-03-16
 *
 * */
public class School extends EstablishmentOfEducation {
    /**
     * {@value #NO} Code of
     * not success exit operation.
     * */
    private static final int NO = -1;
    /**
     * {@value #DEFAULT_NAME} Default name.
     * */
    private static final String DEFAULT_NAME = "none";
    /**
     * Private field Name of School.
     * */
    private String nameOfSchool;
    /**
     * Field Scholar.
     */
    private ArrayList<Scholar> pupils;

    /**
     * Default constructor.
     */
    public School() {
        super();
        this.pupils = new ArrayList<>();
        this.nameOfSchool = DEFAULT_NAME;
    }

    /**
     * Constructor with params.
     * @param newNameOfSchool String – name.
     */
    public School(final String newNameOfSchool) {
        super();
        this.pupils = new ArrayList<>();
        this.nameOfSchool = newNameOfSchool;
    }
    public School(final School anotherSchool) {
        super();
        if (anotherSchool != null) {
            this.pupils = new ArrayList<>(anotherSchool.getPupils());
            this.nameOfSchool = anotherSchool.getNameOfSchool();
        }
    }
    /**
     * Getter of photoPath.
     * @param person - searching person.
     * @return String - photoPath.
     */
    public String getPhotoPath(final Scholar person) {
        int index = this.searchAroundThePupils(person);
        if (index == NO) {
            return DEFAULT_NAME;
        } else {
            return this.pupils.get(index).getPhotoPath();
        }
    }
    /**
     * Method deductLeaner.
     * Deduct Scholar from the school.
     * @param personToDeduct - scholar to deduct.
     */
    public void deductLeaner(Scholar personToDeduct) {
        int index = this.searchAroundThePupils(personToDeduct);
        if (index == NO) {
            return;
        } else {
            this.pupils.remove(index);
        }
    }
    /**
     * Method enrollLeaner.
     * It enrols scholar to school.
     * @param newPupil Scholar.
     * */
    public void enrollLeaner (final Scholar newPupil) {
        this.pupils.add(newPupil);
    }
    /**
     * Getter of Marks of scholar
     * by calling its own method.
     * @param person - current person.
     * @return String - All marks.
     * */
    public String marksOfScholar (final Scholar person) {
        int index = this.searchAroundThePupils(person);
        if (index == NO) {
            return DEFAULT_NAME;
        } else {
            return this.pupils.get(index).getAllMarksValue();
        }
    }
    /**
     * Getter of name of school.
     * @return String – Name.
     * */
    public String getNameOfSchool() {
        return this.nameOfSchool;
    }
    /**
     * Private method for searching person around the
     * Array list in the class School.
     * @param person - searching person.
     * @return number - in ArrayList.
     * */
    private int searchAroundThePupils(final Scholar person){
        for (int i = 0; i < this.pupils.size(); i++) {
            if (this.pupils.get(i).getName() == person.getName()) {
                return i;
            }
        }
        return NO;
    }
    /**
     * Getter for copying.
     * @return ArrayList - of pupils.
     * */
    public ArrayList<Scholar> getPupils() {
        return this.pupils;
    }
}
