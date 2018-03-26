package by.bsuir.Khamutouski.system;

import by.bsuir.Khamutouski.graphic.MenuForm;
import org.eclipse.swt.widgets.Display;

public class Main {
    //TODO: Javadoc for all project
    public static void main(String[] args) {

        Display display = new Display();
        MenuForm menu = new MenuForm(display);
        display.dispose();
    }
}