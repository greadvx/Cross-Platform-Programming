package by.bsuir.Khamutouski;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
/**
 * <h1>Panel to control student</h1>
 * <p>
 * This is a class of application
 * that create a GUI form Control Panel.
 * </p>
 *
 * @author Yan Khamutouski
 * @version 1.0
 * @since 2018-03-11
 *
 * */

public class StudentControlPanelForm extends JFrame {
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
     * {@value #EXIT_BUTTON} Contains name
     * of button performed to conduct exam.
     * */
    private static final String EXIT_BUTTON = "Выход";
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
     * {@value #UNIVERSITY} Contains school name
     * constant.
     * */
    private static final String UNIVERSITY = "Университет: ";
    /**
     * {@value #COURSE} Contains number of form
     * constant.
     * */
    private static final String COURSE = "Год обучения: ";
    /**
     * {@value #MARKS} Contains text of marks
     * constant.
     * */
    private static final String MARKS = "Оценки: ";

    /**
     * {@value #FINISHED_UNIVERSITY} Contains max value of
     * the form.
     * */
    private static final int FINISHED_UNIVERSITY = 4;
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
     * University is created if the scholar pass
     * successful exams.
     * */
    private University university = null;

    /**
     * Student is created when scholar pass the
     * exams.
     * */
    private Student student = null;
    /**
     * Default constructor.
     * @param manager used to change forms in the application
     * */
    public StudentControlPanelForm(final FormManager manager) {
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
        f = new File(student.getPhotoPath());
        try {
            img = ImageIO.read(f);
        } catch (IOException ioe) {
            JOptionPane.showConfirmDialog(null, ioe.toString(),
                    "Error!", JOptionPane.PLAIN_MESSAGE);
            System.exit(ZERO);
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
                + this.student.getSurname());
        panel.add(surnameLabel, params);

        JLabel nameLabel = new JLabel();
        params.gridx = ZERO;
        params.gridy = TWO;
        nameLabel.setText(NAME
                + this.student.getName());
        panel.add(nameLabel, params);


        JLabel universityLabel = new JLabel();
        params.gridx = ZERO;
        params.gridy = THREE;
        universityLabel.setText(UNIVERSITY
                + this.university.getNameOfUniversity());
        panel.add(universityLabel, params);

        JLabel courseLabel = new JLabel();
        params.gridx = ZERO;
        params.gridy = FOUR;
        courseLabel.setText(COURSE
                + this.student.getCourse());
        panel.add(courseLabel, params);

        JLabel marksLabel = new JLabel();
        params.gridx = ZERO;
        params.gridy = FIVE;
        marksLabel.setText(MARKS
                + this.university.marksOfStudent(student));
        panel.add(marksLabel, params);

        JButton exitButton = new JButton(EXIT_BUTTON);
        panel.add(exitButton);
        params.gridx = THREE;
        params.gridy = FIVE;
        exitButton.setEnabled(false);
        panel.add(exitButton, params);

        exitButton.addActionListener(action -> {
            manager.closeFourthForm();
        });

        JButton studyButton = new JButton(STUDY_BUTTON);
        panel.add(studyButton);
        params.gridx = TWO;
        params.gridy = FIVE;
        panel.add(studyButton, params);

        studyButton.addActionListener(action -> {
            this.student.studying();
            marksLabel.setText(MARKS
                    + this.university.marksOfStudent(student));
            courseLabel.setText(COURSE
                    + this.student.getCourse());
            if (this.student.getCourse() == FINISHED_UNIVERSITY) {
                exitButton.setEnabled(true);
                studyButton.setEnabled(false);
            }
        });

        this.setContentPane(panel);
        this.setVisible(SET_VISIBLE);
    }
    /**
     * Method to attach university.
     * @param thisUniversity - University.
     * */
    public void attachUniversity(final University thisUniversity) {
        this.university = thisUniversity;
    }
    /**
     * Method to attach student.
     * @param thisStudent  - Student.
     * */
    public void attachStudent(final Student thisStudent) {
        this.student = thisStudent;
    }
}
