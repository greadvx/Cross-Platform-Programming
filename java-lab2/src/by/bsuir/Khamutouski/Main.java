package by.bsuir.Khamutouski;

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
     * Form on the screen to create scholar.
     * */
    private ScholarCreatingForm firstForm;
    /**
     * Form on the screen to create school.
     * */
    private SchoolCreatingForm secondForm;
    /**
     * Form on the screen to create ControlPanel
     * of the scholar.
     * */
    private ControlPanelForm thirdForm;
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
        firstForm = new ScholarCreatingForm(this);
        firstForm.setVisible(true);
        secondForm = new SchoolCreatingForm(this);
        secondForm.setVisible(false);
        thirdForm = new ControlPanelForm(this);
        thirdForm.setVisible(false);

    }
    /**This method contains code written to change screens
     * Close firstForm and make visible secondForm.
     * Also here we take info about created scholar.
     * */
    @Override
    public void closeFirstForm() {
        firstForm.setVisible(!firstForm.isVisible());
        scholar = firstForm.createScholar();
        secondForm.setVisible(!secondForm.isVisible());
    }
    /**This method contains code written to change screens.
     * Close secondForm and make visible third form.
     * Also here is attached scholar, school and university.
     * */
    @Override
    public void closeSecondForm() {
        secondForm.setVisible(!secondForm.isVisible());
        school = secondForm.createSchool();
        school.enrollLeaner(scholar);
        thirdForm.setVisible(!thirdForm.isVisible());
        thirdForm.attachSchool(school);
        thirdForm.attachUniversity(university);
        thirdForm.addElements();
    }
    /**This method contains code written to change screens
     * in this application.
     * It closes a third form and exit from the application with code 0.
     * */
    @Override
    public void closeThirdForm() {
        student = thirdForm.referStudent();
        thirdForm.setVisible(!thirdForm.isVisible());
        System.exit(EXIT_SUCCESS);
    }

}
