package by.bsuir.Khamutouski.system;

import by.bsuir.Khamutouski.leaners.Kinder;
import by.bsuir.Khamutouski.establishments.Kindergarten;
import by.bsuir.Khamutouski.leaners.Scholar;
import by.bsuir.Khamutouski.establishments.School;
import by.bsuir.Khamutouski.leaners.Student;
import by.bsuir.Khamutouski.establishments.University;
import by.bsuir.Khamutouski.graphics.*;

import javax.swing.*;

/**
 * <h1>Main class</h1>
 * <p>
 * This is a main class of application
 * that model real teaching process
 * </p>
 * This class is used to change screens
 * in the application.
 *
 * Application has a simply GUI,
 * Swing is chosen as Graphic library.
 *
 * Russian language is used as main language
 * in GUI.
 *
 * @author Yan Khamutouski
 * @version 1.0
 * @since 2018-03-11
 *
 * */
public class Main implements FormManager {
    /**
     * {@value #EXIT_SUCCESS} Code of
     * success exit operation.
     * */
    private static final int EXIT_SUCCESS = 0;
    /**
     * Form on the screen to create child.
     * */
    private KinderCreatingForm firstForm;
    /**
     * Form on the screen to create Kindergarten.
     * */
    private KindergartenCreatingForm secondForm;
    /**
     * Form on the screen to create Control Panel of
     * kinder.
     * */
    private KinderControlPanelForm thirdForm;
    /**
     * Form on the screen to create school.
     * */
    private SchoolCreatingForm fourthForm;
    /**
     * Form on the screen to create Control Panel of
     * scholar.
     * */
    private ScholarControlPanelForm fifthForm;
    /**
     * Form on the screen to create Control Panel of
     * student.
     * */
    private StudentControlPanelForm sixthForm;


    private Kinder kinder = null;
    private Kindergarten kindergarten = null;

    /**
     * Scholar created for connect it in different
     * forms of this application.
     * */
    private Scholar scholar = null;
    /**
     * Scholar created for connect it in different
     * forms of this application.
     * */
    private School school = null;
    /**
     * School created for connect it in different
     * forms of this application.
     * */
    private University university = null;
    /**
     * University created for connect it in different
     * forms of this application.
     * */
    private Student student = null;

    /**This is a main method contains code written to create
     * GUI forms.
     * All GUI forms are created on the first launch,
     * but only one is active – others are hidden.
     * @param args commandline arguments.
     * */
    public static void main(final String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            /**
             * Redefinition of method to run
             *  Main().
             *  */
            @Override
            public void run() {
                new Main();
            }
        });
    }
    /**
     * This is a constructor method contains
     * code written to change screensin this
     * application.
     * All GUI forms are created on the first launch,
     * but only one is active – others are hidden.
     * */
    public Main() {
        firstForm = new KinderCreatingForm(this);
        firstForm.setVisible(true);
        secondForm = new KindergartenCreatingForm(this);
        secondForm.setVisible(false);
        thirdForm = new KinderControlPanelForm(this);
        thirdForm.setVisible(false);
        fourthForm = new SchoolCreatingForm(this);
        fourthForm.setVisible(false);
        fifthForm = new ScholarControlPanelForm(this);
        fifthForm.setVisible(false);
        sixthForm = new StudentControlPanelForm(this);
        sixthForm.setVisible(false);

    }
    /**
     * This method contains code written to change screens
     * Close firstForm and make visible secondForm.
     * Also here we take info about created scholar.
     * */
    @Override
    public void closeFirstForm() {
        firstForm.setVisible(!firstForm.isVisible());
        kinder = new Kinder(firstForm.createKinder());

        firstForm = null;

        secondForm.setVisible(!secondForm.isVisible());
    }
    /**
     * This method contains code written to change screens.
     * Close secondForm and make visible third form.
     * Also here is attached scholar, school and university.
     * */
    @Override
    public void closeSecondForm() {
        secondForm.setVisible(!secondForm.isVisible());
        kindergarten = new Kindergarten(secondForm.createKindergarten());

        secondForm = null;

        kindergarten.enrollLeaner(kinder);
        kinder.attachNusery(kindergarten);

        thirdForm.setVisible(!thirdForm.isVisible());
        thirdForm.attachKinder(kinder);
        thirdForm.attachKindergarten(kindergarten);
        thirdForm.addElements();
    }
    /**
     * This method contains code written to change screens
     * in this application.
     * It closes a third form.
     * */
    @Override
    public void closeThirdForm() {

        scholar = new Scholar(thirdForm.referScholar());
        thirdForm.setVisible(!thirdForm.isVisible());

        thirdForm = null;
        kinder = null;
        kindergarten = null;

        fourthForm.setVisible(!fourthForm.isVisible());
    }
    /**
     * This method contains code written to change screens
     * in this application.
     * */
    @Override
    public void closeFourthForm() {
        fourthForm.setVisible(!fourthForm.isVisible());
        school = new School(fourthForm.createSchool());
        school.enrollLeaner(scholar);
        scholar.attachSchool(school);

        fourthForm = null;

        fifthForm.setVisible(!fifthForm.isVisible());
        fifthForm.attachSchool(school);
        fifthForm.attachSchoolar(scholar);
        fifthForm.addElements();
    }
    /**
     * This method contains code written to change screens
     * in this application.
     * */
    @Override
    public void closeFifthForm() {
        fifthForm.setVisible(!fifthForm.isVisible());
        student = new Student(fifthForm.referStudent());
        university = new University(fifthForm.referUniversity());

        fifthForm = null;
        scholar = null;
        school = null;

        student.attachUniversity(university);
        university.enrollLeaner(student);

        sixthForm.setVisible(!sixthForm.isVisible());
        sixthForm.attachStudent(student);
        sixthForm.attachUniversity(university);
        sixthForm.addElements();
    }
    /**
     * This method contains code written to change screens
     * in this application.
     * It closes a sixth form and exit from the application with code 0.
     * */
    @Override
    public void closeSixthForm() {
        System.exit(EXIT_SUCCESS);
    }

}