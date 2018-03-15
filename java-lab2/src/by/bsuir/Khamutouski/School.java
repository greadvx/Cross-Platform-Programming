package by.bsuir.Khamutouski;

import java.util.ArrayList;

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

    private static final int NO = -1;
    private static final String DEFAULT_NAME = "none";
    private String nameOfSchool;
    /**
     * Field Scholar.
     */
    private ArrayList<Scholar> pupils;

    /**
     * Default constructor.
     */
    School() {
        super();
        this.pupils = new ArrayList<>();
        this.nameOfSchool = DEFAULT_NAME;
    }

    /**
     * Constructor with params.
     * @param newNameOfSchool String – name.
     */
    School(final String newNameOfSchool) {
        super();
        this.pupils = new ArrayList<>();
        this.nameOfSchool = newNameOfSchool;
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
    }
