package sample;

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
        Checker.addTextLimiter(firstXTextField, 4);
        grid.add(firstXTextField, 1, 2);

        TextField firstYTextField = new TextField();
        Checker.addTextLimiter(firstYTextField, 4);
        grid.add(firstYTextField, 1, 3);

        TextField secondXTextField = new TextField();
        Checker.addTextLimiter(secondXTextField, 4);
        grid.add(secondXTextField, 1, 4);

        TextField secondYTextField = new TextField();
        Checker.addTextLimiter(secondYTextField, 4);
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

                if (!Checker.doubleRegEx(firstXTextField) || !Checker.doubleRegEx(firstYTextField)
                        || !Checker.doubleRegEx(secondXTextField) || !Checker.doubleRegEx(secondYTextField)) {

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Информация об ошибке");
                    alert.setHeaderText("Внимание! Обнаружена ошибка!");
                    alert.setContentText("Некорректный ввод. Пожалуйста, повторите ввод.");
                    alert.showAndWait();
                    return;
                }
            Vector vector = new Vector(Double.parseDouble(firstXTextField.getText()), Double.parseDouble(firstYTextField.getText()),
                    Double.parseDouble(secondXTextField.getText()), Double.parseDouble(secondYTextField.getText()));

                lengthOfVectorLabel.setText("Норма вектора: " + vector.countingLengthOfVector());
                projectionXLabel.setText("Проекция на х: " + vector.projectionOnX());
                projectionYLabel.setText("Проекция на y: " + vector.projectionOnY());
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
