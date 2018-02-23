package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checker {

    public static boolean doubleRegEx(TextField inputedExpression){
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
    public static void addTextLimiter(final TextField tf, final int maxLength) {
        tf.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov,
                                final String oldValue, final String newValue) {
                if (tf.getText().length() > maxLength) {
                    String s = tf.getText().substring(0, maxLength);
                    tf.setText(s);
                }
            }
        });
    }
}
