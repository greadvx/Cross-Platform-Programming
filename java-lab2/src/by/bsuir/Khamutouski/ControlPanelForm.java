package by.bsuir.Khamutouski;

import javax.swing.*;
import java.awt.*;

public class ControlPanelForm extends JFrame {

    private final String NAME_OF_FORM = "Панель управления";
    private final String STUDY_BUTTON = "Учиться";
    private final int WIDTH = 400;
    private final int HEIGHT = 500;
    private final boolean SET_RESIZEBLE = false;
    private final boolean SET_VISIBLE = true;

    private FormManager manager;
    private School school;

    public ControlPanelForm(final FormManager manager) {
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

        JLabel welcomeMessage = new JLabel();
        params.fill = GridBagConstraints.HORIZONTAL;
        panel.add(welcomeMessage, params);


        JLabel schoolName = new JLabel();
        params.gridx = 0;
        params.gridy = 1;
        params.weightx = 0.5;
        params.weighty = 0.1;
        panel.add(schoolName, params);

        JTextField inputedSchoolName = new JTextField();
        params.gridx = 1;
        params.gridy = 1;
        panel.add(inputedSchoolName, params);


        JButton createButton = new JButton(STUDY_BUTTON);
        panel.add(createButton);
        params.gridx = 1;
        params.gridy = 3;
        panel.add(createButton, params);
        createButton.addActionListener(action-> {

            manager.closeThirdForm();
        });

        this.setContentPane(panel);
        this.setVisible(SET_VISIBLE);
    }
    public void attachSchool(School newSchool) {
        this.school = newSchool;
    }
}
