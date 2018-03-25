package by.bsuir.Khamutouski.graphic;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;

public class MenuForm {

    private static final int WIDTH = 210;
    private static final int HEIGHT = 180;
    private static final int COLUMNS_COUNT = 1;
    private static final int STATUS_SUCCESS = 0;

    private static final boolean MAKE_EQUAL = true;
    private static final boolean MAKE_NOT_EQUAL = false;
    private static final boolean H_SPACE = true;
    private static final boolean V_SPACE = true;

    private static final String FORM_NAME = "Вычисление свертки";
    private static final String MAIN_MENU = "Главное меню";
    private static final String HELP = "Помощь";
    private static final String COMPUTE = "Вычислить";
    private static final String EXIT = "Выход";

    private Display display;

    public MenuForm(final Display newDisplay) {

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


        Button helpButton = new Button(outerGroup, SWT.PUSH);
        helpButton.setText(HELP);
        helpButton.setLayoutData(new GridData(SWT.FILL,
                SWT.CENTER, H_SPACE, V_SPACE)
        );
        helpButton.addListener(SWT.Selection, action -> {
            HelpForm helpForm = new HelpForm(display);

        });


        Button computeButton = new Button(outerGroup, SWT.PUSH);
        computeButton.setText(COMPUTE);
        computeButton.setLayoutData(new GridData(SWT.FILL,
                SWT.CENTER, H_SPACE, V_SPACE)
        );
        computeButton.addListener(SWT.Selection, action -> {
            ComputingForm computeForm = new ComputingForm(display);
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
