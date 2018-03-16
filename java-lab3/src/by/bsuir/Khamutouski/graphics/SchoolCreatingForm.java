package by.bsuir.Khamutouski.graphics;

import by.bsuir.Khamutouski.establishments.School;
import by.bsuir.Khamutouski.system.Checker;
import by.bsuir.Khamutouski.system.FormManager;

import javax.swing.*;
import java.awt.*;
/**
 * <h1>Form for creating school</h1>
 * <p>
 * This is a class of application
 * that create a GUI form SchoolCreating.
 * </p>
 *
 * @author Yan Khamutouski
 * @version 2.0
 * @since 2018-03-16
 *
 * */

public class SchoolCreatingForm extends JFrame {
    /**
     * Field for changing GUI form.
     * */
    private final FormManager manager;
    /**
     * {@value #NAME_OF_FORM} Contains
     * name of form.
     * */
    private static final String NAME_OF_FORM = "Создание школы";
    /**
     * {@value #WELCOME} Contains
     * welcome message and what to do.
     * */
    private static final String WELCOME = "Введите данные:";
    /**
     * {@value #SCHOOL} Contains
     * name of school constant.
     * */
    private static final String SCHOOL = "Название школы";
    /**
     * {@value #BUTTON_NAME} Contains
     * name for button create.
     * */
    private static final String BUTTON_NAME = "Создать";
    /**
     * {@value #WIDTH} Size of form(width).
     * */
    private static final int WIDTH = 300;
    /**
     * {@value #HEIGHT} Size of form(height).
     * */
    private static final int HEIGHT = 200;
    /**
     * {@value #ZERO} Value for alignment.
     * */
    private static final int ZERO = 0;
    /**
     * {@value #ONE} Value for alignment.
     * */
    private static final int ONE = 1;
    /**
     * {@value #THREE} Value for alignment.
     * */
    private static final int THREE = 3;
    /**
     * {@value #ZERO_POINT_ONE} Value for alignment.
     * */
    private static final double ZERO_POINT_ONE = 0.1;
    /**
     * {@value #ZERO_POINT_TWO} Value for alignment.
     * */
    private static final double ZERO_POINT_TWO = 0.2;
    /**
     * {@value #ZERO_POINT_FIVE} Value for alignment.
     * */
    private static final double ZERO_POINT_FIVE = 0.5;
    /**
     * {@value #SET_VISIBLE} Boolean visible.
     * */
    private static final boolean SET_VISIBLE = true;
    /**
     * {@value #SET_RESIZEBLE} Boolean to resize.
     * */
    private static final boolean SET_RESIZEBLE = false;
    /**
     * Field name of school.
     * */
    private String nameOfSchool;
    /**
     * Constructor with params.
     * @param manager used to change GUI forms.
     * */
    public SchoolCreatingForm(final FormManager manager) {
        this.manager = manager;
        this.setName(NAME_OF_FORM);
        this.setSize(WIDTH, HEIGHT);
        this.setTitle(NAME_OF_FORM);
        this.setLocationRelativeTo(null);
        this.setResizable(SET_RESIZEBLE);
        this.addElements();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    /**
     * Method add all needed elements to
     * the GUI form.
     * */
    private void addElements() {
        JPanel panel = new JPanel();
        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        panel.setLayout(new GridBagLayout());

        GridBagConstraints params = new GridBagConstraints();
        params.fill = GridBagConstraints.HORIZONTAL;

        params.weightx = ZERO;
        params.weighty = ZERO_POINT_TWO;

        JLabel welcomeMessage = new JLabel(WELCOME);
        params.fill = GridBagConstraints.HORIZONTAL;
        panel.add(welcomeMessage, params);

        JLabel schoolName = new JLabel(SCHOOL);
        params.gridx = ZERO;
        params.gridy = ONE;
        params.weightx = ZERO_POINT_FIVE;
        params.weighty = ZERO_POINT_ONE;
        panel.add(schoolName, params);

        JTextField inputedSchoolName = new JTextField();
        params.gridx = ONE;
        params.gridy = ONE;
        panel.add(inputedSchoolName, params);

        JButton createButton = new JButton(BUTTON_NAME);
        panel.add(createButton);
        params.gridx = ONE;
        params.gridy = THREE;
        panel.add(createButton, params);
        createButton.addActionListener(action -> {
            try {
                if (Checker.StringRegEx(inputedSchoolName)) {
                    this.nameOfSchool = inputedSchoolName.getText();
                    manager.closeFourthForm();
                } else {
                    throw new Error("Введены неверные данные!");
                }
            } catch (Error errorName) {
                JOptionPane.showMessageDialog(null,
                        "Обнаружена ошибка: " + errorName.getMessage());
            }
        });

        this.setContentPane(panel);
        this.setVisible(SET_VISIBLE);
    }
    /**
     * Method that create a school.
     * @return School – new School.
     * */
    public School createSchool() {
        School newSchool = new School(nameOfSchool);
        return newSchool;
    }
}
