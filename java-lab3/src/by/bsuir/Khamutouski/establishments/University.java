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
 * @version 1.0
 * @since 2018-03-11
 *
 * */
public class University extends EstablishmentOfEducation {
    /**
     * {@value #PASSING_SCORE} Code of
     * success exit operation.
     * */
    private static final double PASSING_SCORE = 1.7;
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
     * Method to conduct exam.
     * @param enrollPerson Scholar.
     * @return boolean – result of exam.
     * */
    public boolean conductExam(final Scholar enrollPerson) {

        if (enrollPerson.voutesOfLeaner() >= PASSING_SCORE) {
            Student newStudent = new Student(enrollPerson);
            this.students.add(newStudent);
            newStudent.attachUniversity(this);
            return true;
        } else {
            return false;
        }
    }
    /**
     * Method deductLeaner.
     * Makes student deleted from ArrayList.
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
     * */
    public String getNameOfUniversity() {
        return this.nameOfUniversity;
    }
}

