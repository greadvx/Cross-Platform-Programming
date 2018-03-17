package by.bsuir.Khamutouski.establishments;

import by.bsuir.Khamutouski.leaners.Scholar;
import by.bsuir.Khamutouski.leaners.Student;

import java.util.ArrayList;

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
 * @version 2.0
 * @since 2018-03-16
 *
 * */
public class University extends EstablishmentOfEducation {
    /**
     * {@value #PASSING_SCORE} Code of
     * success exit operation.
     * */
    private static final double PASSING_SCORE = 1.1;
    /**
     * {@value #NO} Code of
     * not success exit operation.
     * */
    private static final int NO = -1;
    /**
     * {@value #DEFAULT_NAME} Code of
     * not success exit operation.
     * */
    private static final String DEFAULT_NAME = "none";
    /**
     * Private field name of university.
     * */
    private String nameOfUniversity;
    /**
     * ArrayList of students.
     * */
    private ArrayList<Student> students;
    /**
     * Default constructor.
     * */
    public University() {
        super();
        this.nameOfUniversity = DEFAULT_NAME;
        this.students = new ArrayList<>();
    }
    /**
     * Constructor with params.
     * @param newNameOfUniversity String name.
     * */
    public University(final String newNameOfUniversity) {
        super();
        this.nameOfUniversity = newNameOfUniversity;
        this.students = new ArrayList<>();
    }
    /**
     * Constructor of copying.
     * @param anotherUniversity - University.
     * */
    public University(final University anotherUniversity) {
        super();
        if (anotherUniversity != null) {
            this.nameOfUniversity =
                    anotherUniversity.getNameOfUniversity();
            this.students = new ArrayList<>(anotherUniversity.getStudents());
        }
    }
    /**
     * Method to conduct exam.
     * @param enrollPerson Scholar.
     * @return boolean – result of exam.
     * */
    public boolean conductExam(final Scholar enrollPerson) {

        if (enrollPerson.votesOfLeaner() >= PASSING_SCORE) {
            //Student newStudent = new Student(enrollPerson);
            //this.students.add(newStudent);
            //newStudent.attachUniversity(this);
            return true;
        } else {
            return false;
        }
    }
    /**
     * Method deductLeaner.
     * Makes student deleted from ArrayList.
     * @param personToDeduct - Student to deduct.
     * */
    public void deductLeaner(final Student personToDeduct) {
        int index = this.searchForStudent(personToDeduct);
        if (index == NO) {
            return;
        } else {
            this.students.remove(index);
        }
    }
    /**
     * Method enrollLeaner.
     * It enroll a student to the university.
     * @param newStudent Student.
     * */
    public void enrollLeaner(final Student newStudent) {
        this.students.add(newStudent);
    }
    public Student referenceOfCreatedStudent() {
        int lastObject = this.students.size();
        lastObject--;
        return this.students.get(lastObject);
    }
    /**
     * Method to search student in ArrayList of students.
     * @param person - searching person.
     * */
    private int searchForStudent(final Student person) {
        for (int i = 0; i < this.students.size(); i++) {
            if (this.students.get(i).getName() == person.getName()) {
                return i;
            }
        }
        return NO;
    }
    /**
     * Getter of Marks of student
     * by calling its own method.
     * @param person - current person.
     * @return String - All marks.
     * */
    public String marksOfStudent (final Student person) {
        int index = this.searchForStudent(person);
        if (index == NO) {
            return DEFAULT_NAME;
        } else {
            return this.students.get(index).getAllMarksValue();
        }
    }
    /**
     * Getter for nameOf university.
     * @return String - name.
     * */
    public String getNameOfUniversity() {
        return this.nameOfUniversity;
    }
    /**
     * Getter for copying.
     * @return ArrayList.
     * */
    public ArrayList<Student> getStudents() {
        return this.students;
    }
    /**
     * Method conduct Lection.
     * */
    public void conductLection() {
        for (Student person : students) {
            person.increaseIntellect();
        }
    }
    /**
     * Method conduct Seminar.
     * */
    public void conductSeminar() {
        for (Student person : students) {
            person.increaseIntellect();
        }
    }
    /**
     * Method conduct Labwork.
     * */
    public void conductLabwork() {
        for (Student person : students) {
            person.increaseIntellect();
        }
    }

}

