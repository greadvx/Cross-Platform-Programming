package by.bsuir.khamutouski.viewcontrollers;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.MessageBox;

import java.util.ArrayList;
import java.util.Random;

/**
 * <h1>Creating new collection by choosing simply numbers</h1>
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

public class NumsViewController {
    /**
     * {@value #WIDTH} int value of width of this form.
     * */
    private static final int WIDTH = 280;
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
    private static final String FORM_NAME = "Операции с "
            + "коллекциями";
    /**
     * {@value #SIMPLY_NUMS} String value constant.
     * */
    private static final String SIMPLY_NUMS = "Поиск простых "
            + "чисел в коллекции";
    /**
     * {@value #TAIL_REC_BUTTON} String value constant.
     * */
    private static final String TAIL_REC_BUTTON = "Хвостовая рекурсия";
    /**
     * {@value #SIMPLY_REC_BUTTON} String value constant.
     * */
    private static final String SIMPLY_REC_BUTTON = "Обычная рекурсия";
    /**
     * {@value #GENERATE_COLLECTION_BUTTON} String value constant.
     * */
    private static final String GENERATE_COLLECTION_BUTTON = "Сгенерировать "
            + "коллекции";
    /**
     * {@value #COUNT_OF_RADIOBUTTONS} Int value constant of count
     * of radioButtons.
     * */
    private static final int COUNT_OF_RADIOBUTTONS = 2;
    /**
     * {@value #INIT_COLLECTION} String value constant of initial collection.
     * */
    private static final String INIT_COLLECTION = "Исходная коллекция";
    /**
     * {@value #OUT_COLLECTION} String value constant of result collection.
     * */
    private static final String OUT_COLLECTION = "Результирующая коллекция";

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

    public NumsViewController(final Display newDisplay) {

        this.display = newDisplay;
        Shell shell = new Shell(display);
        shell.setSize(WIDTH, HEIGHT);
        shell.setText(FORM_NAME);
        shell.setLayout(new GridLayout(COLUMNS_COUNT, MAKE_NOT_EQUAL));

        Group group = new Group(shell, SWT.NONE);
        group.setText(SIMPLY_NUMS);
        group.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
                H_SPACE, V_SPACE));
        group.setLayout(new GridLayout(COLUMNS_COUNT,
                MAKE_EQUAL)
        );

        Label initialCollectionLabel = new Label(group, SWT.FILL);
        initialCollectionLabel.setText(INIT_COLLECTION);
        initialCollectionLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
                H_SPACE, V_SPACE)
        );

        Label initialValuesOfCollectionLabel = new Label(group, SWT.FILL);
        initialValuesOfCollectionLabel.setText("");
        initialValuesOfCollectionLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
                        H_SPACE, V_SPACE)
        );

        Label outputCollectionLabel = new Label(group, SWT.FILL);
        outputCollectionLabel.setText(OUT_COLLECTION);
        outputCollectionLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
                H_SPACE, V_SPACE)
        );

        Label outputValueOfCollection = new Label(group, SWT.FILL);
        outputValueOfCollection.setText("");
        outputValueOfCollection.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
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

        Button produceNewCollectionButton = new Button(group, SWT.PUSH);
        produceNewCollectionButton.setText(GENERATE_COLLECTION_BUTTON);
        produceNewCollectionButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
                H_SPACE, V_SPACE)
        );

        produceNewCollectionButton.addListener(SWT.Selection, action -> {
            try{

                if (!typeOfRecursion[FIRST_RADIOBUTTON].getSelection() &&
                        !typeOfRecursion[SECOND_RADIOBUTTON].getSelection())
                    throw new Error("Не выбран тип рекурсии");
                    //tail-rec
                if (typeOfRecursion[FIRST_RADIOBUTTON].getSelection()) {


                    //non tail rec
                } else {


                }

            } catch (final Error exception) {
                MessageBox dialog =
                        new MessageBox(shell, SWT.ERROR);
                dialog.setText("Внимание! Найдена ошибка ввода.");
                dialog.setMessage("Ошибка ввода. " +
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
    private String listToStingValues(final ArrayList<Integer> listToConvert) {

        String result = new String();
        for (int element : listToConvert) {
            result += String.valueOf(element);
            result += ' ';
        }
        return result;
    }

    private ArrayList<Integer> generateCollection() {
        ArrayList<Integer> list = new ArrayList<>(10);
        Random random = new Random(99);
        for (int index = 0; index < 10; index++) {
            list.add(index, random.nextInt());
        }
        return list;
    }
}
