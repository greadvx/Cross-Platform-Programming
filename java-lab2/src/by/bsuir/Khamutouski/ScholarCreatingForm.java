package by.bsuir.Khamutouski;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ScholarCreatingForm extends JFrame {

    private final FormManager manager;

    private final String NAME_OF_FORM = "Создание профиля школьника";
    private final String SURNAME = "Фамилия";
    private final String NAME = "Имя";
    private final String BUTTON_NAME = "Создать";
    private final String PHOTO = "Выбрать фото";
    private final String WELCOME = "Введите информацию:";

    private final int WIDTH = 300;
    private final int HEIGHT = 200;

    private final boolean SET_VISIBLE = true;
    private final boolean SET_RESIZEBLE = false;

    private String name = "";
    private String surname;
    private String photo = "";

    public ScholarCreatingForm(final FormManager manager) {
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


        JLabel surname = new JLabel(SURNAME);
        params.gridx = 0;
        params.gridy = 1;
        params.weightx = 0.5;
        params.weighty = 0.1;
        panel.add(surname, params);

        JTextField inputedSurname = new JTextField();
        params.gridx = 1;
        params.gridy = 1;
        panel.add(inputedSurname, params);

        JLabel name = new JLabel(NAME);
        params.gridx = 0;
        params.gridy = 2;
        panel.add(name, params);

        JTextField inputedName = new JTextField();
        params.gridx = 1;
        params.gridy = 2;
        panel.add(inputedName, params);

        JButton photoButton = new JButton(PHOTO);
        panel.add(photoButton);
        params.gridx = 0;
        params.gridy = 3;
        panel.add(photoButton, params);
        photoButton.addActionListener(action -> {
            JFileChooser file = new JFileChooser();
            file.setDialogTitle(PHOTO);
            file.setAcceptAllFileFilterUsed(false);
            file.addChoosableFileFilter(new ImageFileFilter());
            switch (file.showDialog(null, PHOTO)) {
                case JFileChooser.APPROVE_OPTION: {
                    File selectedFile = file.getSelectedFile();
                    this.photo = selectedFile.getAbsolutePath();
                } break;
                case JFileChooser.CANCEL_OPTION: break;
                case JFileChooser.ERROR_OPTION: this.photo = ""; break;
            }
        });

        JButton createButton = new JButton(BUTTON_NAME);
        panel.add(createButton);
        params.gridx = 1;
        params.gridy = 3;
        panel.add(createButton, params);
        createButton.addActionListener(action-> {
            try {
                if (Checker.StringRegEx(inputedSurname) & Checker.StringRegEx(inputedName)) {
                    this.name = inputedName.getText();
                    this.surname = inputedSurname.getText();
                } else {
                    throw new Error("Введены неверные данные!");
                }
            } catch (Error errorName) {
                JOptionPane.showMessageDialog(null,
                        "Обнаружена ошибка: " + errorName.getMessage());
            }
            manager.closeFirstForm();
        });

        this.setContentPane(panel);
        this.setVisible(SET_VISIBLE);
    }
    public Scholar createScholar() {
        Scholar person = new Scholar(name, surname, photo);
        return person;
    }
}
