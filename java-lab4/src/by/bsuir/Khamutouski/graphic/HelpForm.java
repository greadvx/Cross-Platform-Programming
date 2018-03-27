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

/**
 * <h1>GUI form help</h1>
 *
 * <p>
 * This is a class of GUI interface.
 * Here is created all UI of this form.
 * As graphical library was used SWT by Eclipse.
 * </p>
 *
 *
 * @author Yan Khamutouski
 * @version 1.0
 * @since 2018-03-27
 *
 * */

public class HelpForm {
    /**
     * {@value #WIDTH} int value of width of this form.
     * */
    private static final int WIDTH = 1000;
    /**
     * {@value #HEIGHT} int value of height of this
     * form.
     * */
    private static final int HEIGHT = 1000;
    /**
     * {@value #COLUMNS_COUNT} Columns count.
     * */
    private static final int COLUMNS_COUNT = 1;
    /**
     * {@value #FORM_NAME} String value constant.
     * */
    private static final String FORM_NAME = "Помощь";
    /**
     * {@value #FORM_NAME} String value constant.
     * */
    private static final String EXIT = "Все понятно!";
    /**
     * {@value #IMAGE_PATH} Constant path to photo.
     * */
    private static final String IMAGE_PATH = "/Users/greadvx/"
            + "Cross-Platform-Programming/java-lab4/"
            + "resources/graphic/Info.png";
    /**
     * {@value #MAKE_NOT_EQUAL} Boolean value of equal.
     * */
    private static final boolean MAKE_NOT_EQUAL = false;
    /**
     * {@value #H_SPACE} Boolean value of horizontal
     * spacing.
     * */
    private static final boolean H_SPACE = false;
    /**
     * {@value #V_SPACE} Boolean value of vertical
     * spacing.
     * */
    private static final boolean V_SPACE = false;
    /**
     * Reference of main display.
     * */
    private Display display;
    /**
     * Constructor with params.
     * @param newDisplay - main display.
     * */
    public HelpForm(final Display newDisplay) {
        this.display = newDisplay;
        Shell shell = new Shell(display);
        shell.setSize(WIDTH, HEIGHT);
        shell.setText(FORM_NAME);
        shell.setLayout(new GridLayout(COLUMNS_COUNT, MAKE_NOT_EQUAL));

        Image image = new Image(display, IMAGE_PATH);
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
