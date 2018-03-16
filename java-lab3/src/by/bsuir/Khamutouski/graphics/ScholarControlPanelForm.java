package by.bsuir.Khamutouski.graphics;

import by.bsuir.Khamutouski.establishments.School;
import by.bsuir.Khamutouski.establishments.University;
import by.bsuir.Khamutouski.leaners.Scholar;
import by.bsuir.Khamutouski.leaners.Student;
import by.bsuir.Khamutouski.system.FormManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
/**
 * <h1>Panel to control scholar</h1>
 * <p>
 * This is a class of application
 * that create a GUI form Control Panel.
 * </p>
 *
 * @author Yan Khamutouski
 * @version 2.0
 * @since 2018-03-16
 *
 * */
public class ScholarControlPanelForm extends JFrame {
    /**
     * {@value #NAME_OF_FORM} Contains
     * name of form.
     * */
    private static final String NAME_OF_FORM = "Панель управления";
    /**
     * {@value #STUDY_BUTTON} Contains name
     * of button performed to study.
     * */
    private static final String STUDY_BUTTON = "Учиться";
    /**
     * {@value #EXAM_BUTTON} Contains name
     * of button performed to conduct exam.
     * */
    private static final String EXAM_BUTTON = "Сдать экзамен";
    /**
     * {@value #SURNAME} Contains surname
     * constant.
     * */
    private static final String SURNAME = "Фамилия: ";
    /**
     * {@value #NAME} Contains name
     * constant.
     * */
    private static final String NAME = "Имя: ";
    /**
     * {@value #SCHOOL} Contains school name
     * constant.
     * */
    private static final String SCHOOL = "Школа: ";
    /**
     * {@value #FORM} Contains number of form
     * constant.
     * */
    private static final String FORM = "Год обучения: ";
    /**
     * {@value #MARKS} Contains text of marks
     * constant.
     * */
    private static final String MARKS = "Оценки: ";
    /**
     * {@value #UNIVERSITY} Contains text of university
     * constant.
     * */
    private static final String UNIVERSITY = "БГУИР";
    /**
     * {@value #FINISHED_SCHOOL} Contains max value of
     * the form.
     * */
    private static final int FINISHED_SCHOOL = 11;
    /**
     * {@value #BAD_EXIT} Code of
     * unsuccessful exit operation.
     * */
    private static final int BAD_EXIT = 10;
    /**
     * {@value #WIDTH} Size of form(width).
     * */
    private static final int WIDTH = 400;
    /**
     * {@value #HEIGHT} Size of form(height).
     * */
    private static final int HEIGHT = 300;
    /**
     * {@value #SET_RESIZE} Boolean to set
     * resize window constant.
     * */
    private static final boolean SET_RESIZE = false;
    /**
     * {@value #SET_VISIBLE} Boolean to set
     * visible window constant.
     * */
    private static final boolean SET_VISIBLE = true;
    /**
     * {@value #SPACER} Value for make space
     * between elements on the form.
     * */
    private static final double SPACER = 0.3;
    /**
     * {@value #ZERO} Coordinates for alignment.
     * */
    private static final int ZERO = 0;
    /**
     * {@value #ONE} Coordinates for alignment.
     * */
    private static final int ONE = 1;
    /**
     * {@value #TWO} Coordinates for alignment.
     * */
    private static final int TWO = 2;
    /**
     * {@value #THREE} Coordinates for alignment.
     * */
    private static  final int THREE = 3;
    /**
     * {@value #FOUR} Coordinates for alignment.
     * */
    private static final int FOUR = 4;
    /**
     * {@value #FIVE} Coordinates for alignment.
     * */
    private static final int FIVE = 5;
    /**
     * {@value #SPACE} String to make space
     * between lines.
     * */
    private static final String SPACE = " ";
    /**
     * Form manager is used to change forms in
     * the application.
     * */
    private FormManager manager;
    /**
     * School is created for communicate
     * with other forms in the app.
     * */
    private School school = null;
    /**
     * University is created if the scholar pass
     * successful exams.
     * */
    private University university = null;
    /**
     * Scholar is used to teach it, and to check
     * exam result.
     * */
    private Scholar thisScholar = null;
    /**
     * Student is created when scholar pass the
     * exams.
     * */
    private Student student = null;
    /**
     * Default constructor.
     * @param manager used to change forms in the application
     * */
    public ScholarControlPanelForm(final FormManager manager) {
        this.manager = manager;
        this.setName(NAME_OF_FORM);
        this.setSize(WIDTH, HEIGHT);
        this.setTitle(NAME_OF_FORM);
        this.setLocationRelativeTo(null);
        this.setResizable(SET_RESIZE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    /**
     * Method that adds needed information of scholar
     * and interrupt the actions with it.
     * GUI of this form is created here.
     */
    public void addElements() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints params = new GridBagConstraints();
        params.fill = GridBagConstraints.HORIZONTAL;

        File f;
        Image img = null;
        f = new File(thisScholar.getPhotoPath());
        try {
            img = ImageIO.read(f);
        } catch (IOException ioe) {
            JOptionPane.showConfirmDialog(null, ioe.toString(),
                    "Error!", JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
        }
        params.weightx = ZERO;
        params.weighty = ZERO;

        JLabel photoLabel = new JLabel(new ImageIcon(img));
        params.gridx = THREE;
        params.gridy = THREE;

        panel.add(photoLabel, params);

        params.weightx = SPACER;
        params.weighty = ZERO;

        JLabel surnameLabel = new JLabel();
        params.gridx = ZERO;
        params.gridy = ONE;
        surnameLabel.setText(SURNAME
                + this.thisScholar.getSurname());
        panel.add(surnameLabel, params);

        JLabel nameLabel = new JLabel();
        params.gridx = ZERO;
        params.gridy = TWO;
        nameLabel.setText(NAME
                + this.thisScholar.getName());
        panel.add(nameLabel, params);


        JLabel schoolLabel = new JLabel();
        params.gridx = ZERO;
        params.gridy = THREE;
        schoolLabel.setText(SCHOOL
                + this.school.getNameOfSchool());
        panel.add(schoolLabel, params);

        JLabel formLabel = new JLabel();
        params.gridx = ZERO;
        params.gridy = FOUR;
        formLabel.setText(FORM
                + this.thisScholar.getForm());
        panel.add(formLabel, params);

        JLabel marksLabel = new JLabel();
        params.gridx = ZERO;
        params.gridy = FIVE;
        marksLabel.setText(MARKS
                + this.school.marksOfScholar(thisScholar));
        panel.add(marksLabel, params);

        JButton tryExamination = new JButton(EXAM_BUTTON);
        panel.add(tryExamination);
        params.gridx = THREE;
        params.gridy = FIVE;
        tryExamination.setEnabled(false);
        panel.add(tryExamination, params);

        tryExamination.addActionListener(action -> {
            university = new University(UNIVERSITY);
            boolean result = thisScholar.passTheExam(university);
            if (result) {
                student = new Student(thisScholar);
                thisScholar = null;
                manager.closeFifthForm();
            } else {
                JOptionPane.showMessageDialog(null,
                        "Школьник: " + thisScholar.getName() + SPACE
                                + thisScholar.getSurname()
                                + " не справился с экзаменом.");
                System.exit(BAD_EXIT);
            }

        });

        JButton studyButton = new JButton(STUDY_BUTTON);
        panel.add(studyButton);
        params.gridx = TWO;
        params.gridy = FIVE;
        panel.add(studyButton, params);

        studyButton.addActionListener(action -> {
            this.thisScholar.studying();
            marksLabel.setText(MARKS
                    + this.school.marksOfScholar(thisScholar));
            formLabel.setText(FORM
                    + this.thisScholar.getForm());
            if (this.thisScholar.getForm() == FINISHED_SCHOOL) {
                tryExamination.setEnabled(true);
                studyButton.setEnabled(false);
                school = null;
            }
        });

        this.setContentPane(panel);
        this.setVisible(SET_VISIBLE);
    }
    /**
     * Method to attach the school to this form.
     * @param newSchool School to attach.
     * */
    public void attachSchool(final School newSchool) {
        this.school = newSchool;
    }
    /**
     * Method to attach the university to this form.
     * @param newUniversity University to attach.
     * */
    public void attachUniversity(final University newUniversity) {
        this.university = newUniversity;
    }

    public void attachSchoolar(final Scholar scholar) {
        this.thisScholar = scholar;
    }
    /**
     * Method to attach the student to the global
     * main method.
     * @return Student.
     * */
    public Student referStudent() {
        return this.student;
    }
    /**
     * Method to attach the university to the global
     * main method.
     * @return University.
     * */
    public University referUniversity() {
        return this.university;
    }
}
