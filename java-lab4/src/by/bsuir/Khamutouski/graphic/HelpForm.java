package by.bsuir.Khamutouski.graphic;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Display;



public class HelpForm {

    private static final int WIDTH = 1000;
    private static final int HEIGHT = 1000;
    private static final int COLUMNS_COUNT = 1;

    private static final String FORM_NAME = "Помощь";
    private static final String EXIT = "Все понятно!";

    private static final String imagePath = "/Users/greadvx/"
            + "Cross-Platform-Programming/java-lab4/"
            + "resources/graphic/Info.png";

    private static final boolean MAKE_NOT_EQUAL = false;
    private static final boolean H_SPACE = false;
    private static final boolean V_SPACE = false;

    private Display display;

    public HelpForm(final Display newDisplay) {
        this.display = newDisplay;
        Shell shell = new Shell(display);
        shell.setSize(WIDTH, HEIGHT);
        shell.setText(FORM_NAME);
        shell.setLayout(new GridLayout(COLUMNS_COUNT, MAKE_NOT_EQUAL));

        Image image = new Image(display, imagePath);
        Label infoImage = new Label(shell, SWT.NONE);
        infoImage.setImage(image);

        Button exitButton = new Button(shell, SWT.PUSH);
        exitButton.setText(EXIT);
        exitButton.setLayoutData(new GridData(SWT.FILL,
                SWT.CENTER, H_SPACE, V_SPACE)
        );
        exitButton.addListener(SWT.Selection, action -> {
            shell.dispose();
        });


        /** take the primary monitor */
        Monitor primary = display.getPrimaryMonitor();
        Rectangle bounds = primary.getBounds();
        Rectangle rect = shell.getBounds();
        /** calculate the centre */
        int x = bounds.x + (bounds.width - rect.width) / 2;
        int y = bounds.y + (bounds.height - rect.height) / 2;
        shell.setLocation(x, y);
        shell.pack();
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
    }
}
