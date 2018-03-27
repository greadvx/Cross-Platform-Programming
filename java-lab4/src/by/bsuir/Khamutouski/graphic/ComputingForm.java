package by.bsuir.Khamutouski.graphic;

import by.bsuir.Khamutouski.convolution.Convolution;
import by.bsuir.Khamutouski.system.Checker;

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
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.MessageBox;
/**
 * <h1>GUI form computing</h1>
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
public class ComputingForm {
    /**
     * {@value #WIDTH} int value of width of this form.
     * */
    private static final int WIDTH = 500;
    /**
     * {@value #HEIGHT} int value of height of this
     * form.
     * */
    private static final int HEIGHT = 200;
    /**
     * {@value #COLUMNS_COUNT} Columns count.
     * */
    private static final int COLUMNS_COUNT = 2;
    /**
     * {@value #ONE} One constant.
     * */
    private static final int ONE = 1;

    /**
     * {@value #FORM_NAME} Constant of name of the form.
     * */
    private static final String FORM_NAME = "Линейная "
            + "свертка";
    /**
     * {@value #SPACE} Spacer constant.
     * */
    private static final String SPACE = " ";
    /**
     * {@value #SIGNAL} String value constant.
     * */
    private static final String SIGNAL = "Сигнал :";
    /**
     * {@value #SIGNAL_1} String value constant.
     * */
    private static final String SIGNAL_1 = "Сигнал 1:";
    /**
     * {@value #SIGNAL_2} String value constant.
     * */
    private static final String SIGNAL_2 = "Сигнал 2:";
    /**
     * {@value #INDICATION} String value constant.
     * */
    private static final String INDICATION = "Выберите отсчет";
    /**
     * {@value #BACK} String value constant.
     * */
    private static final String BACK = "Назад";
    /**
     * {@value #COMPUTE} String value constant.
     * */
    private static final String COMPUTE = "Вычислить";
    /**
     * {@value #CLEAR} String value constant.
     * */
    private static final String CLEAR = "Очистить";
    /**
     * {@value #TEXT_FIELD_EXCEPTION}
     * String value constant.
     * */
    private static final String TEXT_FIELD_EXCEPTION
            = "TextField(Regular expression) error.";
    /**
     * {@value #COMBO_BOX_EXCEPTION}
     * String value constant.
     * */
    private static final String COMBO_BOX_EXCEPTION
            = "Error of comboBox selection.";
    /**
     * {@value #MAKE_NOT_EQUAL} Boolean value of equal.
     * */
    private static final boolean MAKE_NOT_EQUAL = false;
    /**
     * {@value #MAKE_EQUAL} Boolean value of equal.
     * */
    private static final boolean MAKE_EQUAL = true;
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
     * Field used to fill comboBoxes.
     * */
    private String[] array = {"1", "2", "3", "4", "5"};

    /**
     * Constructor with params.
     * @param newDisplay - main display.
     * */
    public ComputingForm(final Display newDisplay) {
        this.display = newDisplay;
        Shell shell = new Shell(display);
        shell.setSize(WIDTH, HEIGHT);
        shell.setText(FORM_NAME);
        shell.setLayout(new GridLayout(COLUMNS_COUNT,
                MAKE_NOT_EQUAL)
        );

        Group firstGroup = new Group(shell, SWT.FILL);
        firstGroup.setText(SIGNAL_1);
        firstGroup.setLayoutData(new GridData(SWT.FILL,
                SWT.FILL, H_SPACE, V_SPACE)
        );
        firstGroup.setLayout(new GridLayout(COLUMNS_COUNT,
                MAKE_EQUAL)
        );

        Label labelFCombo = new Label(firstGroup, SWT.FILL);
        labelFCombo.setText(INDICATION);
        labelFCombo.setLayoutData(new GridData(SWT.FILL,
                SWT.FILL, H_SPACE, V_SPACE)
        );

        Combo firstComboBox = new Combo(firstGroup, SWT.LEFT);
        for (String value : array) {
            firstComboBox.add(value);
        }

        Label labelFirstSignal = new Label(firstGroup, SWT.FILL);
        labelFirstSignal.setText(SIGNAL);
        labelFirstSignal.setLayoutData(new GridData(SWT.FILL,
                SWT.FILL, H_SPACE, V_SPACE)
        );

        Text textOfFistSignal = new Text(firstGroup, SWT.FILL);
        textOfFistSignal.setLayoutData(new GridData(SWT.FILL,
                SWT.FILL, H_SPACE, V_SPACE)
        );

        Group secondGroup = new Group(shell, SWT.FILL);
        secondGroup.setText(SIGNAL_2);
        secondGroup.setLayoutData(new GridData(SWT.FILL,
                SWT.FILL, H_SPACE, V_SPACE)
        );
        secondGroup.setLayout(new GridLayout(COLUMNS_COUNT,
                MAKE_EQUAL)
        );

        Label labelSecondCombo = new Label(secondGroup, SWT.FILL);
        labelSecondCombo.setText(INDICATION);
        labelSecondCombo.setLayoutData(new GridData(SWT.FILL,
                SWT.FILL, H_SPACE, V_SPACE)
        );

        Combo secondComboBox = new Combo(secondGroup, SWT.LEFT);
        for (String value : array) {
            secondComboBox.add(value);
        }

        Label labelSecondSignal = new Label(secondGroup, SWT.FILL);
        labelSecondSignal.setText(SIGNAL);
        labelSecondSignal.setLayoutData(new GridData(SWT.FILL,
                SWT.FILL, H_SPACE, V_SPACE)
        );

        Text textOfSecondSignal = new Text(secondGroup, SWT.FILL);
        textOfSecondSignal.setLayoutData(new GridData(SWT.FILL,
                SWT.FILL, H_SPACE, V_SPACE)
        );

        Button computeButton = new Button(shell, SWT.CENTER);
        computeButton.setLayoutData(new GridData(SWT.FILL,
                SWT.FILL, H_SPACE, V_SPACE)
        );
        computeButton.setText(COMPUTE);

        Button backButton = new Button(shell, SWT.CENTER);
        backButton.setLayoutData(new GridData(SWT.FILL,
                SWT.FILL, H_SPACE, V_SPACE)
        );
        backButton.setText(BACK);
        backButton.addListener(SWT.Selection, action -> {
            shell.dispose();
        });

        Button clearButton = new Button(shell, SWT.CENTER);
        clearButton.setLayoutData(new GridData(SWT.FILL,
                SWT.FILL, H_SPACE, V_SPACE)
        );
        clearButton.setText(CLEAR);

        Label resultLabel = new Label(shell, SWT.CENTER);
        resultLabel.setLayoutData(new GridData(SWT.FILL,
                SWT.FILL, H_SPACE, V_SPACE)
        );
        resultLabel.setText("");

        clearButton.addListener(SWT.Selection, action -> {
            textOfFistSignal.setText("");
            textOfSecondSignal.setText("");
            firstComboBox.setText("");
            secondComboBox.setText("");
            resultLabel.setText("");
        });
        computeButton.addListener(SWT.Selection, action -> {
            try {
                if (!Checker.NumericRegExp(textOfFistSignal) &&
                        !Checker.NumericRegExp(textOfSecondSignal)) {
                    throw new Error(TEXT_FIELD_EXCEPTION);
                }
                if ((Checker.countOfSymbol(textOfFistSignal, SPACE)
                        != firstComboBox.getSelectionIndex()) &&
                        (Checker.countOfSymbol(textOfSecondSignal, SPACE)
                                != secondComboBox.getSelectionIndex())) {
                    throw new Error(COMBO_BOX_EXCEPTION);
                }
                    Convolution convolution = new Convolution(textOfFistSignal.getText(),
                            firstComboBox.getSelectionIndex() + ONE,
                            textOfSecondSignal.getText(),
                            secondComboBox.getSelectionIndex() + ONE
                    );
                    String result = convolution.compute();
                    resultLabel.setText("Результат: " + result);

            } catch (final Error exception) {
            MessageBox dialog =
                        new MessageBox(shell, SWT.ERROR);
                dialog.setText("Attention! Error of input occurred.");
                dialog.setMessage("Check input fields. It is possible "
                       + "to input only numbers. " + exception.getMessage());
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
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
    }
}
