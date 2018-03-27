package by.bsuir.Khamutouski.system;

import by.bsuir.Khamutouski.graphic.MenuForm;
import org.eclipse.swt.widgets.Display;
/**
 * <h1>Main class of application</h1>
 *
 * <p>
 * This is a class of application
 * that create main menu and close it.
 * </p>
 *
 * @author Yan Khamutouski
 * @version 1.0
 * @since 2018-03-27
 *
 * */
public class Main {
    /**
     * Main method to run application.
     * @param args - arguments of command line.
     * @since 1.0
     * */
    public static void main(String[] args) {

        Display display = new Display();
        MenuForm menu = new MenuForm(display);
        display.dispose();
    }
}