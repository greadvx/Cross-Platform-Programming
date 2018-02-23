package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Class Checker
 * This class is used for a correct user input
 * @since 1.0
 * */
public class Checker {
    /**
     * This is a static method that checks if the Textfield
     * equals to regular expression
     * @param inputedExpression TextField
     * @return true if String is equal to regular expression,
     * false if String not equal to regular expression or empty
     * @since 1.0
     */
    public static boolean doubleRegEx(final TextField inputedExpression){
        Pattern digitsPattern = Pattern.compile("[0-9]+\\.?[0-9]*");
        Matcher line = digitsPattern.matcher(inputedExpression.getText());
        if (!line.matches()){
            return false;
        } else {
            if (inputedExpression.getText().isEmpty()){
                return false;
            }
            return true;
        }
    }
    /**
     * This is a static method that controls quantity of
     * inputed characters to the TextField
     * @param textField TextField object
     * @param maxLength Maximal length of the string
     * @since 1.0
     * */
    public static void addTextLimiter(final TextField textField, final int maxLength) {
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov,
                                final String oldValue, final String newValue) {
                if (textField.getText().length() > maxLength) {
                    String s = textField.getText().substring(0, maxLength);
                    textField.setText(s);
                }
            }
        });
    }
}
