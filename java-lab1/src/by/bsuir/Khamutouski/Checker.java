package by.bsuir.Khamutouski;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Class Checker.
 * This class is used for a correct user input.
 * @since 1.0
 * */
public final class Checker {
    /**
     * {@value #BEGIN_INDEX} Begin index for the substring.
     * */
    private static final int BEGIN_INDEX = 0;
    /**
     * Default constructor.
     */
    private Checker() {

    }
    /**
     * This is a static method that checks if the Textfield
     * equals to regular expression.
     * @param inputedExpression TextField
     * @return true if String is equal to regular expression,
     * false if String not equal to regular expression or empty
     * @since 1.0
     */
    public static boolean doubleRegEx(final TextField inputedExpression) {
        Pattern digitsPattern = Pattern.compile("[0-9]+\\.?[0-9]*");
        Matcher line = digitsPattern.matcher(inputedExpression.getText());
        if (!line.matches()) {
            return false;
        } else {
            if (inputedExpression.getText().isEmpty()) {
                return false;
            }
            return true;
        }
    }
    /**
     * This is a static method.
     * Controls quantity of inputed characters
     * to the TextField.
     * @param textField TextField object
     * @param maxLength Maximal length of the string
     * @since 1.0
     * */
    public static void addTextLimiter(final TextField textField,
                                      final int maxLength) {
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov,
                                final String oldValue, final String newValue) {
                if (textField.getText().length() > maxLength) {
                    String s =
                            textField.getText().substring(BEGIN_INDEX,
                            maxLength);
                    textField.setText(s);
                }
            }
        });
    }
}
