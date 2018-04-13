package by.bsuir.khamutouski.viewcontrollers;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;

/**
 * <h1>GUI form menu</h1>
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
 * @since 2018-04-13
 *
 * */
public class SelectorViewController {
    /**
     * {@value #WIDTH} int value of width of this form.
     * */
    private static final int WIDTH = 250;
    /**
     * {@value #HEIGHT} int value of height of this
     * form.
     * */
    private static final int HEIGHT = 180;
    /**
     * {@value #COLUMNS_COUNT} Columns count.
     * */
    private static final int COLUMNS_COUNT = 1;
    /**
     * {@value #STATUS_SUCCESS} Exit status.
     * */
    private static final int STATUS_SUCCESS = 0;
    /**
     * {@value #MAKE_EQUAL} Boolean value of equal.
     * */
    private static final boolean MAKE_EQUAL = true;
    /**
     * {@value #MAKE_NOT_EQUAL} Boolean value of equal.
     * */
    private static final boolean MAKE_NOT_EQUAL = false;
    /**
     * {@value #H_SPACE} Boolean value of horizontal
     * spacing.
     * */
    private static final boolean H_SPACE = true;
    /**
     * {@value #V_SPACE} Boolean value of vertical
     * spacing.
     * */
    private static final boolean V_SPACE = true;
    /**
     * {@value #FORM_NAME} String value constant.
     * */
    private static final String FORM_NAME = "Рекурсивные операции";
    /**
     * {@value #MAIN_MENU} String value constant.
     * */
    private static final String MAIN_MENU = "Главное меню";
    /**
     * {@value #CHAR_IN_STRING} String value constant.
     * */
    private static final String CHAR_IN_STRING = "Поиск символа "
            + "в строке";
    /**
     * {@value #SIMPLY_NUM} String value constant.
     * */
    private static final String SIMPLY_NUM = "Поиск простого "
            + "числа";
    /**
     * {@value #EXIT} String value constant.
     * */
    private static final String EXIT = "Выход";
    /**
     * Reference of main display.
     * */
    private Display display;
    /**
     * Constructor with params.
     * @param newDisplay - main display.
     * */
    public SelectorViewController(final Display
                                          newDisplay) {

        this.display = newDisplay;

        Shell shell = new Shell(display);
        shell.setSize(WIDTH, HEIGHT);
        shell.setText(FORM_NAME);
        shell.setLayout(new GridLayout(COLUMNS_COUNT, MAKE_NOT_EQUAL));

        Group outerGroup = new Group(shell, SWT.NONE);
        outerGroup.setText(MAIN_MENU);
        outerGroup.setLayoutData(new GridData(SWT.FILL,
                SWT.FILL, H_SPACE, V_SPACE)
        );
        outerGroup.setLayout(new GridLayout(COLUMNS_COUNT,
                MAKE_EQUAL)
        );


        Button findSymInString = new Button(outerGroup, SWT.PUSH);
        findSymInString.setText(CHAR_IN_STRING);
        findSymInString.setLayoutData(new GridData(SWT.FILL,
                SWT.CENTER, H_SPACE, V_SPACE)
        );
        findSymInString.addListener(SWT.Selection, action -> {
            CharViewController viewController =
                   new CharViewController(display);

        });

        Button simplyNumbersInCollection = new Button(outerGroup, SWT.PUSH);
        simplyNumbersInCollection.setText(SIMPLY_NUM);
        simplyNumbersInCollection.setLayoutData(new GridData(SWT.FILL,
                SWT.CENTER, H_SPACE, V_SPACE)
        );
        simplyNumbersInCollection.addListener(SWT.Selection, action -> {

            NumsViewController viewController =
                    new NumsViewController(display);
        });


        Button exitButton = new Button(outerGroup, SWT.PUSH);
        exitButton.setText(EXIT);
        exitButton.setLayoutData(new GridData(SWT.FILL,
                SWT.CENTER, H_SPACE, V_SPACE)
        );
        exitButton.addListener(SWT.Selection, action -> {
            System.exit(STATUS_SUCCESS);
        });

        /** take the primary monitor */
        Monitor primary = display.getPrimaryMonitor();
        Rectangle bounds = primary.getBounds();
        Rectangle rect = shell.getBounds();
        /** calculate the centre */
        int x = bounds.x + (bounds.width - rect.width) / 2;
        int y = bounds.y + (bounds.height - rect.height) / 2;
        shell.setLocation(x, y);

        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }
}
