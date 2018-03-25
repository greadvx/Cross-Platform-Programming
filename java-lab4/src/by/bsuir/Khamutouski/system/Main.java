package by.bsuir.Khamutouski.system;

import by.bsuir.Khamutouski.graphic.MenuForm;
import org.eclipse.swt.widgets.*;


public class Main {

    public static void main(String[] args) {

        Display display = new Display();
        MenuForm menu = new MenuForm(display);
        display.dispose();
    }
}