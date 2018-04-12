package by.bsuir.khamutouski.viewcontrollers;

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

public class CharViewController {
    private Display display;

    public CharViewController(final Display newDisplay) {
        this.display = newDisplay;
        Shell shell = new Shell(display);
        shell.setSize(250, 200);
        shell.setText("Строковые операции");
        shell.setLayout(new GridLayout(1, false));

        Group group = new Group(shell, SWT.NONE);
        group.setText("Поиск символа в строке");
        group.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
                true, true));
        group.setLayout(new GridLayout(1,
                true)
        );

        Label inputStringLabel = new Label(group, SWT.FILL);
        inputStringLabel.setText("Введите строку");
        inputStringLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
                true, true));

        Text inputStringTextField = new Text(group, SWT.FILL);
        inputStringTextField.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
                true, true));

        Label inputSymbolLabel = new Label(group, SWT.FILL);
        inputSymbolLabel.setText("Введите символ");
        inputSymbolLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
                true, true));

        Text inputSymbolTextField = new Text(group, SWT.FILL);
        inputSymbolTextField.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
                true, true));
        Label countOfSymbol = new Label(group, SWT.FILL);
        countOfSymbol.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
                true, true));
        Button calculateButton = new Button(group, SWT.PUSH);
        calculateButton.setText("Количество вхождений");
        calculateButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
                true, true));

        calculateButton.addListener(SWT.Selection, action -> {

            //TODO: String check.

        });

        /** take the primary monitor */
        Monitor primary = display.getPrimaryMonitor();
        Rectangle bounds = primary.getBounds();
        Rectangle rect = shell.getBounds();
        /** calculate the centre */
        int x = bounds.x + (bounds.width - rect.width) / 2;
        int y = bounds.y + (bounds.height - rect.height) / 2;

        shell.setLocation(x, y);
        //shell.pack();
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
    }
}
