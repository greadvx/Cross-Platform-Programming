package by.bsuir.Khamutouski;

import javax.swing.*;
import java.awt.*;
import java.io.File;
/**
 * <h1>Form for creating scholar</h1>
 * <p>
 * This class in used to create
 * scholar form in the application.
 * </p>
 *
 * @author Yan Khamutouski
 * @version 1.0
 * @since 2018-03-11
 *
 * */
public class ScholarCreatingForm extends JFrame {
    /**
     * Field for changing form on the screen.
     * */
    private final FormManager manager;
    /**
     * {@value #NAME_OF_FORM} String name
     * of form.
     * */
    private static final String NAME_OF_FORM = "Создание профиля"
            + " школьника";
    /**
     * {@value #SURNAME} String surname.
     * */
    private static final String SURNAME = "Фамилия";
    /**
     * {@value #NAME} String name.
     * */
    private static final String NAME = "Имя";
    /**
     * {@value #BUTTON_NAME} String for
     * naming button create.
     * */
    private static final String BUTTON_NAME = "Создать";
    /**
     * {@value #PHOTO} String for button
     * to select photo.
     * */
    private static final String PHOTO = "Выбрать фото";
    /**
     * {@value #WELCOME} Message that
     * says what to do.
     * */
    private static final String WELCOME = "Введите информацию:";
    /**
     * {@value #WIDTH} Size of form(width).
     * */
    private static final int WIDTH = 300;
    /**
     * {@value #HEIGHT} Size of form(height).
     * */
    private static final int HEIGHT = 200;
    /**
     * {@value #SET_VISIBLE} Boolean visible.
     * */
    private static final boolean SET_VISIBLE = true;
    /**
     * {@value #SET_RESIZEBLE} Boolean resize window.
     * */
    private static final boolean SET_RESIZEBLE = false;
    /**
     * {@value #ZERO} Value for alignment.
     * */
    private static final int ZERO = 0;
    /**
     * {@value #ONE} Value for alignment.
     * */
    private static final int ONE = 1;
    /**
     * {@value #TWO} Value for alignment.
     * */
    private static final int TWO = 2;
    /**
     * {@value #THREE} Value for alignment.
     * */
    private static final int THREE = 3;
    /**
     * {@value #ZERO_POINT_ONE} Value for alignment..
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
     * Filed of name.
     * */
    private String name = "";
    /**
     * Field of surname.
     * */
    private String surname;
    /**
     * Field of photoPath.
     * */
    private String photo = "";
    /**
     * Default constructor with params.
     * @param manager used to manage GUI forms.
     * */
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
    /**
     * Method that adds elements on the form.
     * All GUI is created here.
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

        JLabel surnameLabel = new JLabel(SURNAME);
        params.gridx = ZERO;
        params.gridy = ONE;
        params.weightx = ZERO_POINT_FIVE;
        params.weighty = ZERO_POINT_ONE;
        panel.add(surnameLabel, params);

        JTextField inputedSurname = new JTextField();
        params.gridx = ONE;
        params.gridy = ONE;
        panel.add(inputedSurname, params);

        JLabel nameLabel = new JLabel(NAME);
        params.gridx = ZERO;
        params.gridy = TWO;
        panel.add(nameLabel, params);

        JTextField inputedName = new JTextField();
        params.gridx = ONE;
        params.gridy = TWO;
        panel.add(inputedName, params);

        JButton photoButton = new JButton(PHOTO);
        panel.add(photoButton);
        params.gridx = ZERO;
        params.gridy = THREE;
        panel.add(photoButton, params);
        photoButton.addActionListener(action -> {
            JFileChooser file = new JFileChooser();
            file.setDialogTitle(PHOTO);
            file.setAcceptAllFileFilterUsed(false);
            file.addChoosableFileFilter(new ImageFileFilter());
            switch (file.showDialog(null, PHOTO)) {
                case JFileChooser.APPROVE_OPTION:
                    File selectedFile = file.getSelectedFile();
                    this.photo = selectedFile.getAbsolutePath();
                    break;
                case JFileChooser.CANCEL_OPTION: break;
                case JFileChooser.ERROR_OPTION: this.photo = ""; break;
                default: break;
            }
        });

        JButton createButton = new JButton(BUTTON_NAME);
        panel.add(createButton);
        params.gridx = ONE;
        params.gridy = THREE;
        panel.add(createButton, params);
        createButton.addActionListener(action -> {
            try {
                if (Checker.StringRegEx(inputedSurname)
                        & Checker.StringRegEx(inputedName)) {
                    this.name = inputedName.getText();
                    this.surname = inputedSurname.getText();
                    manager.closeFirstForm();
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
     * Method create a Scholar person.
     * @return Scholar person.
     * */
    public Scholar createScholar() {
        Scholar person = new Scholar(name, surname, photo);
        return person;
    }
}
