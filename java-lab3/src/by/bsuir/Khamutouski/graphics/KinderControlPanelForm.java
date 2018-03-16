package by.bsuir.Khamutouski.graphics;

import by.bsuir.Khamutouski.establishments.Kindergarten;
import by.bsuir.Khamutouski.leaners.Kinder;
import by.bsuir.Khamutouski.leaners.Scholar;
import by.bsuir.Khamutouski.system.FormManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
/**
 * <h1>Panel to control kinder</h1>
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
public class KinderControlPanelForm extends JFrame {
    /**
     * {@value #NAME_OF_FORM} Contains
     * name of form.
     * */
    private static final String NAME_OF_FORM = "Панель управления";
    /**
     * {@value #PLAY_BUTTON} Contains name
     * of button performed to study.
     * */
    private static final String PLAY_BUTTON = "Покормить";
    /**
     * {@value #TO_SCHOOL_BUTTON} Contains name
     * of button performed to create scholar.
     * */
    private static final String TO_SCHOOL_BUTTON = "В школу";
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
     * {@value #GARTEN} Contains school name
     * constant.
     * */
    private static final String GARTEN = "Детсад: ";
    /**
     * {@value #GROUP} Contains name of group.
     * */
    private static final String GROUP = "Группа: ";
    /**
     * {@value #IQ} Contains text of iq
     * constant.
     * */
    private static final String IQ = "IQ: ";
    /**
     * {@value #FINISHED_KINDERGARTEN} Contains max value of
     * the group.
     * */
    private static final int FINISHED_KINDERGARTEN = 3;
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
     * Private field kinder.
     * */
    private Kinder kinder = null;
    /**
     * Private field kindergarten.
     * */
    private Kindergarten kindergarten = null;

    private Scholar scholar = null;
    /**
     * Form manager is used to change forms in
     * the application.
     * */
    private FormManager manager;
    /**
     * Default constructor.
     * @param manager used to change forms in the application
     * */
    public KinderControlPanelForm(final FormManager manager) {
        this.manager = manager;
        this.setName(NAME_OF_FORM);
        this.setSize(WIDTH, HEIGHT);
        this.setTitle(NAME_OF_FORM);
        this.setLocationRelativeTo(null);
        this.setResizable(SET_RESIZE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    /**
     * Method that adds needed information of kinder,
     * kindergarten and interrupt the actions with it.
     * GUI of this form is created here.
     */
    public void addElements() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints params = new GridBagConstraints();
        params.fill = GridBagConstraints.HORIZONTAL;

        File f;
        Image img = null;
        f = new File(kinder.getPhotoPath());
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
                + this.kinder.getSurname());
        panel.add(surnameLabel, params);

        JLabel nameLabel = new JLabel();
        params.gridx = ZERO;
        params.gridy = TWO;
        nameLabel.setText(NAME
                + this.kinder.getName());
        panel.add(nameLabel, params);


        JLabel kindergartenLabel = new JLabel();
        params.gridx = ZERO;
        params.gridy = THREE;
        kindergartenLabel.setText(GARTEN
                + this.kindergarten.getNameOfKindergarten());
        panel.add(kindergartenLabel, params);

        JLabel formLabel = new JLabel();
        params.gridx = ZERO;
        params.gridy = FOUR;
        formLabel.setText(GROUP
                + this.kinder.getGroupString());
        panel.add(formLabel, params);

        JLabel marksLabel = new JLabel();
        params.gridx = ZERO;
        params.gridy = FIVE;
        marksLabel.setText(IQ
                + this.kindergarten.iqOfChild(kinder));
        panel.add(marksLabel, params);

        JButton toSchoolButton = new JButton(TO_SCHOOL_BUTTON);
        panel.add(toSchoolButton);
        params.gridx = THREE;
        params.gridy = FIVE;
        toSchoolButton.setEnabled(false);
        panel.add(toSchoolButton, params);

        toSchoolButton.addActionListener(action -> {
            scholar = new Scholar(kinder);
            kinder = null;
            manager.closeThirdForm();
        });

        JButton studyButton = new JButton(PLAY_BUTTON);
        panel.add(studyButton);
        params.gridx = TWO;
        params.gridy = FIVE;
        panel.add(studyButton, params);

        studyButton.addActionListener(action -> {
            this.kindergarten.feedKids(kinder);
            marksLabel.setText(IQ
                    + this.kindergarten.iqOfChild(kinder));
            formLabel.setText(GROUP
                    + this.kinder.getGroupString());
            if (this.kinder.getGroup() == FINISHED_KINDERGARTEN) {
                toSchoolButton.setEnabled(true);
                studyButton.setEnabled(false);
                kindergarten = null;
            }
        });

        this.setContentPane(panel);
        this.setVisible(SET_VISIBLE);
    }
    /**
     * Method to attach the kindergarten to this form.
     * @param newKindergarten Kindergarten to attach.
     * */
    public void attachKindergarten(final Kindergarten newKindergarten) {
        this.kindergarten = newKindergarten;
    }
    /**
     * Method to attach the kinder to this form.
     * @param newKinder Kinder to attach.
     * */
    public void attachKinder(final Kinder newKinder) {
        this.kinder = newKinder;
    }
    /**
     * Method to get Scholar.
     * @return Scholar.
     * */
    public Scholar referScholar() {
        return this.scholar;
    }
}
