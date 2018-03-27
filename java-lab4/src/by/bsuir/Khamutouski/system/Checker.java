package by.bsuir.Khamutouski.system;

import org.eclipse.swt.widgets.Text;
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
    public static boolean NumericRegExp(final Text inputedExpression) {
        Pattern stringPattern =
                Pattern.compile("^[0-9 ]+$");
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
    /**
     * This is a static method that checks how many symbols
     * contains in Textfield by RegExp methods.
     *
     * @param text TextField.
     * @param symbol - symbol for search.
     * @return int - count of symbol.
     * @since 1.0
     */
    public static int countOfSymbol(final Text text, final String symbol) {
        String buffer = text.getText();
        Pattern pattern = Pattern.compile(symbol);
        Matcher m = pattern.matcher(buffer);
        int counter = 0;
        while(m.find()) {
            counter++;
        }
        return counter;
    }
}
