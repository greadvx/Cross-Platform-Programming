package by.bsuir.Khamutouski.system;

import javax.swing.JTextField;
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
     */
    private static final int BEGIN_INDEX = 0;

    /**
     * Default constructor.
     */
    private Checker() {

    }

    /**
     * This is a static method that checks if the Textfield
     * equals to regular expression.
     *
     * @param inputedExpression TextField
     * @return true if String is equal to regular expression,
     * false if String not equal to regular expression or empty
     * @since 1.0
     */
    public static boolean StringRegEx(final JTextField inputedExpression) {
        Pattern stringPattern =
                Pattern.compile("^[a-zA-Zа-яА-Я'][a-zA-Zа-яА-Я-' ]"
                        + "+[a-zA-Zа-яА-Я']?$");
        Matcher line = stringPattern.matcher(inputedExpression.getText());
        if (!line.matches()) {
            return false;
        } else {
            if (inputedExpression.getText().isEmpty()) {
                return false;
            }
            return true;
        }
    }
}
