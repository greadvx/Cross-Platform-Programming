package by.bsuir.Khamutouski.graphic;

import by.bsuir.Khamutouski.convolution.Convolution;
import by.bsuir.Khamutouski.system.Checker;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;


public class ComputingForm {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 200;
    private static final int COLUMNS_COUNT = 2;

    private static final String FORM_NAME = "Линейная свертка";
    private static final String SPACE = " ";

    private static final boolean MAKE_NOT_EQUAL = false;


    private Display display;
    private String[] array = {"1", "2", "3", "4", "5"};

    public ComputingForm(final Display newDisplay) {
        this.display = newDisplay;
        Shell shell = new Shell(display);
        shell.setSize(WIDTH, HEIGHT);
        shell.setText(FORM_NAME);
        shell.setLayout(new GridLayout(COLUMNS_COUNT, MAKE_NOT_EQUAL));

        Group firstGroup = new Group(shell, SWT.FILL);
        firstGroup.setText("Сигнал 1");
        firstGroup.setLayoutData(new GridData(SWT.FILL,
                SWT.FILL, false, false)
        );
        firstGroup.setLayout(new GridLayout(COLUMNS_COUNT,
                true)
        );

        Label labelFCombo = new Label(firstGroup, SWT.FILL);
        labelFCombo.setText("Выберите отсчет");
        labelFCombo.setLayoutData(new GridData(SWT.FILL,
                SWT.FILL, false, false)
        );

        Combo firstComboBox = new Combo(firstGroup, SWT.LEFT);
        for (String value : array) {
            firstComboBox.add(value);
        }

        Label labelFirstSignal = new Label(firstGroup, SWT.FILL);
        labelFirstSignal.setText("Сигнал:");
        labelFirstSignal.setLayoutData(new GridData(SWT.FILL,
                SWT.FILL, false, false)
        );

        Text textOfFistSignal = new Text(firstGroup, SWT.FILL);
        textOfFistSignal.setLayoutData(new GridData(SWT.FILL,
                SWT.FILL, false, false));


        Group secondGroup = new Group(shell, SWT.FILL);
        secondGroup.setText("Сигнал 2");
        secondGroup.setLayoutData(new GridData(SWT.FILL,
                SWT.FILL, false, false)
        );
        secondGroup.setLayout(new GridLayout(COLUMNS_COUNT,
                true)
        );


        Label labelSecondCombo = new Label(secondGroup, SWT.FILL);
        labelSecondCombo.setText("Выберите отсчет");
        labelSecondCombo.setLayoutData(new GridData(SWT.FILL,
                SWT.FILL, false, false)
        );

        Combo secondComboBox = new Combo(secondGroup, SWT.LEFT);
        for (String value : array) {
            secondComboBox.add(value);
        }

        Label labelSecondSignal = new Label(secondGroup, SWT.FILL);
        labelSecondSignal.setText("Сигнал:");
        labelSecondSignal.setLayoutData(new GridData(SWT.FILL,
                SWT.FILL, false, false)
        );

        Text textOfSecondSignal = new Text(secondGroup, SWT.FILL);
        textOfSecondSignal.setLayoutData(new GridData(SWT.FILL,
                SWT.FILL, false, false));

        Button computeButton = new Button(shell, SWT.CENTER);
        computeButton.setLayoutData(new GridData(SWT.FILL,
                SWT.FILL, false, false));
        computeButton.setText("Вычислить");

        Button backButton = new Button(shell, SWT.CENTER);
        backButton.setLayoutData(new GridData(SWT.FILL,
                SWT.FILL, false, false));
        backButton.setText("Назад");
        backButton.addListener(SWT.Selection, action -> {
            shell.dispose();
        });
        Button clearButton = new Button(shell, SWT.CENTER);
        clearButton.setLayoutData(new GridData(SWT.FILL,
                SWT.FILL, false, false));
        clearButton.setText("Очистить");
        clearButton.addListener(SWT.Selection, action -> {
            textOfFistSignal.setText("");
            textOfSecondSignal.setText("");
            firstComboBox.setText("");
            secondComboBox.setText("");
        });

        Label resultLabel = new Label(shell, SWT.CENTER);
        resultLabel.setLayoutData(new GridData(SWT.FILL,
                SWT.FILL, false, false));
        resultLabel.setText("");

        computeButton.addListener(SWT.Selection, action -> {
            try {
                if (!Checker.NumericRegExp(textOfFistSignal) &&
                        !Checker.NumericRegExp(textOfSecondSignal)) {
                    throw new Error("TextField(Regular expression) error.");
                }
                if ((Checker.countOfSymbol(textOfFistSignal, SPACE)
                        != firstComboBox.getSelectionIndex()) &&
                        (Checker.countOfSymbol(textOfSecondSignal, SPACE)
                                != secondComboBox.getSelectionIndex())) {
                    throw new Error("Error of comboBox selection.");
                }
                    Convolution convolution = new Convolution(textOfFistSignal.getText(),
                            firstComboBox.getSelectionIndex() + 1,
                            textOfSecondSignal.getText(),
                            secondComboBox.getSelectionIndex() + 1
                    );
                    String result = convolution.compute();
                    resultLabel.setText("Result: " + result);

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
