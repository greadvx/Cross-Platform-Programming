package by.bsuir.Khamutouski;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class SchoolCreatingForm extends JFrame {
    private final FormManager manager;
    private final String NAME_OF_FORM = "Создание школы";
    private final String WELCOME = "Введите данные:";
    private final String SCHOOL = "Название школы";
    private final String BUTTON_NAME = "Создать";
    private final int WIDTH = 300;
    private final int HEIGHT = 200;

    private final boolean SET_VISIBLE = true;
    private final boolean SET_RESIZEBLE = false;

    private String nameOfSchool;

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
    private void addElements() {
        JPanel panel = new JPanel();
        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        panel.setLayout(new GridBagLayout());

        GridBagConstraints params = new GridBagConstraints();
        params.fill = GridBagConstraints.HORIZONTAL;

        params.weightx = 0;
        params.weighty = 0.2;

        JLabel welcomeMessage = new JLabel(WELCOME);
        params.fill = GridBagConstraints.HORIZONTAL;
        panel.add(welcomeMessage, params);


        JLabel schoolName = new JLabel(SCHOOL);
        params.gridx = 0;
        params.gridy = 1;
        params.weightx = 0.5;
        params.weighty = 0.1;
        panel.add(schoolName, params);

        JTextField inputedSchoolName = new JTextField();
        params.gridx = 1;
        params.gridy = 1;
        panel.add(inputedSchoolName, params);


        JButton createButton = new JButton(BUTTON_NAME);
        panel.add(createButton);
        params.gridx = 1;
        params.gridy = 3;
        panel.add(createButton, params);
        createButton.addActionListener(action-> {
            try {
                if (Checker.StringRegEx(inputedSchoolName)) {
                    this.nameOfSchool = inputedSchoolName.getText();
                    manager.closeSecondForm();
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
    public School createSchool() {
        School newSchool = new School(nameOfSchool);
        return newSchool;
    }
}
