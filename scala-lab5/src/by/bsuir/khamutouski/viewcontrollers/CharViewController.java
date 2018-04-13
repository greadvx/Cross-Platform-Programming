package by.bsuir.khamutouski.viewcontrollers;

import by.bsuir.khamutouski.calculations.CountingSymbols;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.MessageBox;

/**
 * <h1>Searching char in string ViewController</h1>
 *
 * <p>
 * This is a class of GUI interface.
 * Here is created UI of this form.
 * As graphical library was used SWT by Eclipse.
 * </p>
 *
 *
 * @author Yan Khamutouski
 * @version 1.0
 * @since 2018-04-13
 *
 * */
public class CharViewController {
    /**
     * {@value #WIDTH} int value of width of this form.
     * */
    private static final int WIDTH = 250;
    /**
     * {@value #HEIGHT} int value of height of this
     * form.
     * */
    private static final int HEIGHT = 250;
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
    private static final String FORM_NAME = "Строковые операции";
    /**
     * {@value #CHAR_IN_STRING} String value constant.
     * */
    private static final String CHAR_IN_STRING = "Поиск символа "
            + "в строке";
    /**
     * {@value #INPUT_STRING} String value constant.
     * */
    private static final String INPUT_STRING = "Введите строку";
    /**
     * {@value #INPUT_SYM} String value constant.
     * */
    private static final String INPUT_SYM = "Введите символ";
    /**
     * {@value #TAIL_REC_BUTTON} String value constant.
     * */
    private static final String TAIL_REC_BUTTON = "Хвостовая рекурсия";
    /**
     * {@value #SIMPLY_REC_BUTTON} String value constant.
     * */
    private static final String SIMPLY_REC_BUTTON = "Обычная рекурсия";
    /**
     * {@value #COUNT_BUTTON} String value constant.
     * */
    private static final String COUNT_BUTTON = "Количество вхождений";
    /**
     * {@value #COUNT_OF_RADIOBUTTONS} Int value constant of count
     * of radioButtons.
     * */
    private static final int COUNT_OF_RADIOBUTTONS = 2;
    /**
     * {@value #FIRST_RADIOBUTTON} Int value constant of first
     * radioButton.
     * */
    private static final int FIRST_RADIOBUTTON = 0;
    /**
     * {@value #SECOND_RADIOBUTTON} Int value constant of second
     * radioButton.
     * */
    private static final int SECOND_RADIOBUTTON = 1;
    /**
     * Reference of main display.
     * */
    private Display display;
    /**
     * Constructor with params.
     * @param newDisplay - main display.
     * */
    public CharViewController(final Display newDisplay) {
        this.display = newDisplay;
        Shell shell = new Shell(display);
        shell.setSize(WIDTH, HEIGHT);
        shell.setText(FORM_NAME);
        shell.setLayout(new GridLayout(COLUMNS_COUNT, MAKE_NOT_EQUAL));

        Group group = new Group(shell, SWT.NONE);
        group.setText(CHAR_IN_STRING);
        group.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
                H_SPACE, V_SPACE));
        group.setLayout(new GridLayout(COLUMNS_COUNT,
                MAKE_EQUAL)
        );

        Label inputStringLabel = new Label(group, SWT.FILL);
        inputStringLabel.setText(INPUT_STRING);
        inputStringLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
                H_SPACE, V_SPACE)
        );

        Text inputStringTextField = new Text(group, SWT.FILL);
        inputStringTextField.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
                H_SPACE, V_SPACE)
        );

        Label inputSymbolLabel = new Label(group, SWT.FILL);
        inputSymbolLabel.setText(INPUT_SYM);
        inputSymbolLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
                H_SPACE, V_SPACE)
        );

        Text inputSymbolTextField = new Text(group, SWT.FILL);
        inputSymbolTextField.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
                H_SPACE, V_SPACE)
        );

        Label countOfSymbol = new Label(group, SWT.FILL);
        countOfSymbol.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
                H_SPACE, V_SPACE)
        );

        Button[] typeOfRecursion = new Button[COUNT_OF_RADIOBUTTONS];

        typeOfRecursion[FIRST_RADIOBUTTON] = new Button(group, SWT.RADIO);
        typeOfRecursion[FIRST_RADIOBUTTON].setText(TAIL_REC_BUTTON);
        typeOfRecursion[FIRST_RADIOBUTTON].setLayoutData(
                new GridData(SWT.FILL, SWT.FILL,
                H_SPACE, V_SPACE)
        );

        typeOfRecursion[SECOND_RADIOBUTTON] = new Button(group, SWT.RADIO);
        typeOfRecursion[SECOND_RADIOBUTTON].setText(SIMPLY_REC_BUTTON);
        typeOfRecursion[SECOND_RADIOBUTTON].setLayoutData(
                new GridData(SWT.FILL, SWT.FILL,
                H_SPACE, V_SPACE)
        );

        Button calculateButton = new Button(group, SWT.PUSH);
        calculateButton.setText(COUNT_BUTTON);
        calculateButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
                H_SPACE, V_SPACE)
        );

        calculateButton.addListener(SWT.Selection, action -> {

            int countOfSymbols = 0;

            try {
                if (!typeOfRecursion[FIRST_RADIOBUTTON].getSelection() &&
                        !typeOfRecursion[SECOND_RADIOBUTTON].getSelection())
                    throw new Error("Не выбран тип рекурсии");

                if (inputStringTextField.getText().isEmpty()
                        || inputSymbolTextField.getText().isEmpty())
                    throw new Error("Пустое поле ввода обнаружено!");
                    //tail-rec
                if (typeOfRecursion[FIRST_RADIOBUTTON].getSelection()) {

                    countOfSymbols = CountingSymbols.countSym(
                            inputSymbolTextField.getText().charAt(0),
                            inputStringTextField.getText(),
                            inputStringTextField.getText().length(),
                            countOfSymbols
                    );
                    countOfSymbol.setText("Кол-во вхождений: " +
                            String.valueOf(countOfSymbols)
                            + " раз(а).");
                    //non tail rec
                } else {
                    countOfSymbols = 0;

                    //РЕКУРСИЯ ОБЫЧНАЯ ДЛЯ ПОИСКА СИМВОЛА В СТРОКЕ
                    countOfSymbols = CountingSymbols.countSymRec(inputSymbolTextField.getText().charAt(0),
                            inputStringTextField.getText(),
                            inputStringTextField.getText().length(), countOfSymbols);
                    countOfSymbol.setText("Кол-во вхождений: " +
                            String.valueOf(countOfSymbols)
                            + " раз(а).");
                }
            } catch (final Error exception) {
                MessageBox dialog =
                        new MessageBox(shell, SWT.ERROR);
                dialog.setText("Внимание! Найдена ошибка ввода.");
                dialog.setMessage("Проверьте поля ввода. " +
                        exception.getMessage());
                dialog.open();
            }
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
