package sample;

import java.util.regex.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
/**
 * <h1>Vector calculator</h1>
 * <p>
 * The vector calculator is a programm
 * that helps students to compute length
 * of vector by using only pair
 * of 2 dimensions coordinates.
 * </p>
 *
 * Application has a graphical interface.
 * JavaFX is chosen as a graphic library.
 * Russian language is used as a main language
 * in GUI
 *
 * @author Yan Khamutouski
 * @version 1.0
 * @since 2018-02-20
 *
 * */
public class Main extends Application {
    /**
     * This method contains code written graphical user interface
     * and its aligment on the screen.
     * Added 2 handlers to control buttons and text fields.
     * @param primaryStage default stage.
     * @return Nothing.*/
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Векторный калькулятор");
        BorderPane borderPane = new BorderPane();

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(3);
        grid.setVgap(5);

        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 450, 250);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);

        Label lbl = new Label("Введите координаты:");
        lbl.setTextAlignment(TextAlignment.CENTER);
        grid.add(lbl,1,1);

        Label firstXCoordinate = new Label("x1");
        grid.add(firstXCoordinate, 0, 2);
        Label firstYCoordinate = new Label("y1");
        grid.add(firstYCoordinate, 0, 3);

        Label secondtXCoordinate = new Label("x2");
        grid.add(secondtXCoordinate, 0, 4);

        Label secondYCoordinate = new Label("y2");
        grid.add(secondYCoordinate, 0, 5);



        TextField firstXTextField = new TextField();
        grid.add(firstXTextField, 1, 2);

        TextField firstYTextField = new TextField();
        grid.add(firstYTextField, 1, 3);

        TextField secondXTextField = new TextField();
        grid.add(secondXTextField, 1, 4);

        TextField secondYTextField = new TextField();
        grid.add(secondYTextField, 1, 5);


        Label lengthOfVectorLabel = new Label("Норма вектора: ");
        grid.add(lengthOfVectorLabel, 2, 2);

        Label projectionXLabel = new Label("Проекция на х: ");
        grid.add(projectionXLabel, 2,3);

        Label projectionYLabel = new Label("Проекция на y: ");
        grid.add(projectionYLabel, 2, 4);


        Button clearButton = new Button("Очистить");
        Button countButton = new Button("Посчитать");

        HBox hBoxButtons = new HBox(10);
        hBoxButtons.setAlignment(Pos.CENTER);
        hBoxButtons.getChildren().add(clearButton);
        hBoxButtons.getChildren().add(countButton);
        grid.add(hBoxButtons, 1, 6);

        countButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent pushEvent) {

                Pattern digitsPattern = Pattern.compile("[0-9]+\\.?[0-9]*");
                Matcher line1 = digitsPattern.matcher(firstXTextField.getText());
                Matcher line2 = digitsPattern.matcher(firstYTextField.getText());
                Matcher line3 = digitsPattern.matcher(secondXTextField.getText());
                Matcher line4 = digitsPattern.matcher(secondYTextField.getText());

                if (!line1.matches() | !line2.matches() | !line3.matches() | !line4.matches()){
                    String reason;
                    if (firstXTextField.getText().isEmpty() | firstYTextField.getText().isEmpty() |
                            secondXTextField.getText().isEmpty() | secondYTextField.getText().isEmpty()){
                        reason = "Есть невведенные поля.";
                    } else {
                        reason = "Введены не цифровые символы.";
                    }
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Обнаружена ошибка!");
                    alert.setHeaderText(("Ошибка ввода! " + reason));
                    alert.setContentText("Внимание! В поля координат могут вводиться только цифровые значения " +
                            "в десятичной системе счисления!");
                    alert.showAndWait();
                    return;
                }
                double length = countingLengthOfVector(Double.parseDouble(firstXTextField.getText()),
                        Double.parseDouble(firstYTextField.getText()),
                        Double.parseDouble(secondXTextField.getText()),
                        Double.parseDouble(secondYTextField.getText()));

                lengthOfVectorLabel.setText("Норма вектора: " + length);

                projectionXLabel.setText("Проекция на х: " +
                        (Double.parseDouble(secondXTextField.getText())
                        - Double.parseDouble(firstXTextField.getText())));

                projectionYLabel.setText("Проекция на y: " +
                        (Double.parseDouble(secondYTextField.getText())
                                - Double.parseDouble(firstYTextField.getText())));
            }
        });
        clearButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent pushEvent) {
                firstXTextField.clear();
                firstYTextField.clear();
                secondXTextField.clear();
                secondYTextField.clear();

                lengthOfVectorLabel.setText("Норма вектора: ");
                projectionXLabel.setText("Проекция на х: ");
                projectionYLabel.setText("Проекция на y: ");

            }
        });

        primaryStage.show();
    }
    /**
     * This is a method that count length of vector
     * @param firstX First X coordinate.
     * @param firstY First Y coordinate.
     * @param secondX Second X coordnate.
     * @param secondY Second Y coordinate.
     * @return double This returns arithmetical length of
     * vector inputed by 2 pair of 2 dimensional coordinates.
     * */
    double countingLengthOfVector(double firstX, double firstY, double secondX, double secondY){
        double result = Math.pow(secondX - firstX, 2) + Math.pow(secondY - firstY, 2);
        return result;
    }
    /**
     * This is a main method that called for appearing
     * main window of vector calculator application.
     * It runs a launch method.
     * @param args  Unused.
     * @return Nothing.
     * */
    public static void main(String[] args) {
        launch(args);
    }
}
