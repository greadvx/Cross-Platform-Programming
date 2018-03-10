package by.bsuir.Khamutouski;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ControlPanelForm extends JFrame {

    private final String NAME_OF_FORM = "Панель управления";
    private final String STUDY_BUTTON = "Учиться";
    private final String EXAM_BUTTON = "Сдать экзамен";
    private final String SURNAME = "Фамилия: ";
    private final String NAME = "Имя: ";
    private final String SCHOOL = "Школа: ";
    private final String FORM = "Год обучения: ";
    private final String MARKS = "Оценки: ";
    private final String UNIVERSITY = "БГУИР";
    private final int FINISHED_SCHOOL = 11;
    private final int BAD_EXIT = 33;
    private final int WIDTH = 400;
    private final int HEIGHT = 300;
    private final boolean SET_RESIZEBLE = false;
    private final boolean SET_VISIBLE = true;

    public boolean ch = false;
    private FormManager manager;
    private School school = null;
    private University university = null;
    private Scholar thisScholar = null;
    private Student student = null;

    public ControlPanelForm(final FormManager manager) {
        this.manager = manager;
        this.setName(NAME_OF_FORM);
        this.setSize(WIDTH, HEIGHT);
        this.setTitle(NAME_OF_FORM);
        this.setLocationRelativeTo(null);
        this.setResizable(SET_RESIZEBLE);

        //this.addElements();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void addElements() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints params = new GridBagConstraints();
        params.fill = GridBagConstraints.HORIZONTAL;

        File f; // Создаём файл
        Image img = null;
        f = new File(school.getPhotoPath()); // Устанавливаем путь для файла
        try {
            img = ImageIO.read(f); // Считываем картинку
        } catch(IOException ioe) {
            JOptionPane.showConfirmDialog(null, "Что-то неправильно!\n" + ioe.toString(),
                    "Error!", JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
        }
        params.weightx = 0;
        params.weighty = 0;

        JLabel photoLabel = new JLabel(new ImageIcon(img));
        params.gridx = 3;
        params.gridy = 3;

        panel.add(photoLabel, params);

        params.weightx = 0.3;
        params.weighty = 0;

        JLabel surnameLabel = new JLabel();
        params.gridx = 0;
        params.gridy = 1;
        surnameLabel.setText(SURNAME
                + this.school.surnameOfScholar());
        panel.add(surnameLabel, params);

        JLabel nameLabel = new JLabel();
        params.gridx = 0;
        params.gridy = 2;
        nameLabel.setText(NAME
                + this.school.nameOfScholar());
        panel.add(nameLabel, params);


        JLabel schoolLabel = new JLabel();
        params.gridx = 0;
        params.gridy = 3;
        schoolLabel.setText(SCHOOL
                + this.school.nameOfSchool());
        panel.add(schoolLabel, params);

        JLabel formLabel = new JLabel();
        params.gridx = 0;
        params.gridy = 4;
        formLabel.setText(FORM
                + this.school.formOfScholar());
        panel.add(formLabel, params);

        JLabel marksLabel = new JLabel();
        params.gridx = 0;
        params.gridy = 5;
        marksLabel.setText(MARKS
                + this.school.marksOfScholar());
        panel.add(marksLabel, params);

        JButton tryExamination = new JButton(EXAM_BUTTON);
        panel.add(tryExamination);
        params.gridx = 3;
        params.gridy = 5;
        tryExamination.setEnabled(false);
        panel.add(tryExamination, params);
        tryExamination.addActionListener(action->{
            university = new University(UNIVERSITY);
            boolean result = university.conductExam(thisScholar);
            if (result) {
                student = new Student(thisScholar);
                thisScholar = null;
                manager.closeThirdForm();
           } else {
                JOptionPane.showMessageDialog(null,
                        "Школьник: " + thisScholar.getName() + " "
                                + thisScholar.getSurname()
                                + " не справился с экзаменом.");
                System.exit(BAD_EXIT);
            }

        });

        JButton studyButton = new JButton(STUDY_BUTTON);
        panel.add(studyButton);
        params.gridx = 2;
        params.gridy = 5;
        panel.add(studyButton, params);
        studyButton.addActionListener(action-> {
            this.school.teachPupil();
            marksLabel.setText(MARKS
                    + this.school.marksOfScholar());
            formLabel.setText(FORM
                    + this.school.formOfScholar());
            if (this.school.formOfScholar() == FINISHED_SCHOOL) {
                tryExamination.setEnabled(true);
                studyButton.setEnabled(false);
                thisScholar = this.school.thisPupil();
                this.school.deductLeaner();
            }
        });

        this.setContentPane(panel);
        this.setVisible(SET_VISIBLE);
    }
    public void attachSchool(School newSchool) {
        this.school = newSchool;
    }
    public void attachUniversity(University newUniversity) {
        this.university = newUniversity;
    }
    public Student referStudent() {
        return this.student;
    }
}
