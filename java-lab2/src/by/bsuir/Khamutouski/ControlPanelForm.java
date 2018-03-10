package by.bsuir.Khamutouski;

import javax.swing.*;

public class ControlPanelForm extends JFrame {
    private FormManager manager;
    private final String NAME_OF_FORM = "Панель управления";
    private final int WIDTH = 400;
    private final int HEIGHT = 500;
    private final boolean SET_RESIZEBLE = false;


    public ControlPanelForm(final FormManager manager) {
        this.manager = manager;
        this.setName(NAME_OF_FORM);
        this.setSize(WIDTH, HEIGHT);
        this.setTitle(NAME_OF_FORM);
        this.setLocationRelativeTo(null);
        this.setResizable(SET_RESIZEBLE);
    }

}
