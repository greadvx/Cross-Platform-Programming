package by.bsuir.Khamutouski;

import javax.swing.*;

public class Main implements FormManager{

    private ScholarCreatingForm firstForm;
    private SchoolCreatingForm secondForm;
    private ControlPanelForm thirdForm;

    private Scholar scholar;
    private School school;

    public static void main(String args[]) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }

    public Main() {
        firstForm = new ScholarCreatingForm(this);
        firstForm.setVisible(true);
        secondForm = new SchoolCreatingForm(this);
        secondForm.setVisible(false);
        thirdForm = new ControlPanelForm(this);
        thirdForm.setVisible(false);

    }
    @Override
    public void closeFirstForm() {
        firstForm.setVisible(!firstForm.isVisible());
        scholar = firstForm.createScholar();
        secondForm.setVisible(!secondForm.isVisible());
    }
    @Override
    public void closeSecondForm() {
        secondForm.setVisible(!secondForm.isVisible());
        school = secondForm.createSchool();
        school.enrollLeaner(scholar);
        thirdForm.setVisible(!thirdForm.isVisible());
        thirdForm.attachSchool(school);
    }
    @Override
    public void closeThirdForm() {
        System.out.println("Сам иди нахуй");
    }

}
