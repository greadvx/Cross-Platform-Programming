package by.bsuir.Khamutouski;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
     * {@value #H_GAP} Horizontal Quantity of cells.
     * */
    static final int H_GAP = 3;
    /**
     * {@value #V_GAP} Vertical Quantity of cells.
     * */
    static final int V_GAP = 5;
    /**
     * {@value #PADDING_ROWS} Size of paddig rows.
     * */
    static final int PADDING_ROWS = 25;
    /**
     * {@value #SCENE_WIDTH} Width of the scene.
     * */
    static final int SCENE_WIDTH = 450;
    /**
     * {@value #SCENE_HEIGHT} Height of the scene.
     * */
    static final int SCENE_HEIGHT = 250;
    /**
     * {@value #H_SPACING} Size of spaces between
     * elements in HBox.
     * */
    static final int H_SPACING = 10;
    /**
     * {@value #ZERO_COLUMN} 0 column.
     * */
    static final int ZERO_COLUMN = 0;
    /**
     * {@value #FIRST_COLUMN} 1 column
     * in GridPane.
     * */
    static final int FIRST_COLUMN = 1;
    /**
     * {@value #SECOND_COLUMN} 2 column
     *  * in GridPane.
     * */
    static final int SECOND_COLUMN = 2;
    /**
     * {@value #FIRST_ROW} 1 row
     * in GridPane.
     * */
    static final int FIRST_ROW = 1;
    /**
     * {@value #SECOND_ROW} 2 row
     * in GridPane.
     * */
    static final int SECOND_ROW = 2;
    /**
     * {@value #THIRD_ROW} 3 row
     * in GridPane.
     * */
    static final int THIRD_ROW = 3;
    /**
     * {@value #FOURTH_ROW} 4 row
     * in GridPane.
     * */
    static final int FOURTH_ROW = 4;
    /**
     * {@value #FIFTH_ROW} 5 row
     * in GridPane.
     * */
    static final int FIFTH_ROW = 5;
    /**
     * {@value #SIXTH_ROW} 6 row
     * in GridPane.
     * */
    static final int SIXTH_ROW = 6;
    /**
     * {@value #MAX_LENGTH} maximal quantity
     * of inputed characters in TextField.
     * */
    static final int MAX_LENGTH = 4;

    /**This method contains code written graphical user interface
     * and its aligment on the screen.
     * Added 2 handlers to control buttons and text fields.
     * @param primaryStage default stage.
     * */

    @Override
    public void start(final Stage primaryStage)
            throws Exception {
        primaryStage.setTitle("Векторный калькулятор");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(H_GAP);
        grid.setVgap(V_GAP);
        grid.setPadding(new Insets(PADDING_ROWS, PADDING_ROWS,
                PADDING_ROWS, PADDING_ROWS));

        Scene scene = new Scene(grid, SCENE_WIDTH, SCENE_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);

        Label lbl = new Label("Введите координаты:");
        lbl.setTextAlignment(TextAlignment.CENTER);
        grid.add(lbl, FIRST_COLUMN, FIRST_ROW);

        Label firstXCoordinate = new Label("x1");
        grid.add(firstXCoordinate, ZERO_COLUMN, SECOND_ROW);

        Label firstYCoordinate = new Label("y1");
        grid.add(firstYCoordinate, ZERO_COLUMN, THIRD_ROW);

        Label secondXCoordinate = new Label("x2");
        grid.add(secondXCoordinate, ZERO_COLUMN, FOURTH_ROW);

        Label secondYCoordinate = new Label("y2");
        grid.add(secondYCoordinate, ZERO_COLUMN, FIFTH_ROW);

        TextField firstXTextField = new TextField();
        Checker.addTextLimiter(firstXTextField, MAX_LENGTH);
        grid.add(firstXTextField, FIRST_COLUMN, SECOND_ROW);

        TextField firstYTextField = new TextField();
        Checker.addTextLimiter(firstYTextField, MAX_LENGTH);
        grid.add(firstYTextField, FIRST_COLUMN, THIRD_ROW);

        TextField secondXTextField = new TextField();
        Checker.addTextLimiter(secondXTextField, MAX_LENGTH);
        grid.add(secondXTextField, FIRST_COLUMN, FOURTH_ROW);

        TextField secondYTextField = new TextField();
        Checker.addTextLimiter(secondYTextField, MAX_LENGTH);
        grid.add(secondYTextField, FIRST_COLUMN, FIFTH_ROW);

        Label lengthOfVectorLabel = new Label("Норма вектора: ");
        grid.add(lengthOfVectorLabel, SECOND_COLUMN, SECOND_ROW);

        Label projectionXLabel = new Label("Проекция на х: ");
        grid.add(projectionXLabel, SECOND_COLUMN, THIRD_ROW);

        Label projectionYLabel = new Label("Проекция на y: ");
        grid.add(projectionYLabel, SECOND_COLUMN, FOURTH_ROW);

        Button clearButton = new Button("Очистить");
        Button countButton = new Button("Посчитать");

        HBox hBoxButtons = new HBox(H_SPACING);
        hBoxButtons.setAlignment(Pos.CENTER);
        hBoxButtons.getChildren().add(clearButton);
        hBoxButtons.getChildren().add(countButton);
        grid.add(hBoxButtons, FIRST_COLUMN, SIXTH_ROW);

        countButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent pushEvent) {

                if (!Checker.doubleRegEx(firstXTextField)
                        || !Checker.doubleRegEx(firstYTextField)
                        || !Checker.doubleRegEx(secondXTextField)
                        || !Checker.doubleRegEx(secondYTextField)) {

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Информация об ошибке");
                    alert.setHeaderText("Внимание! Обнаружена ошибка!");
                    alert.setContentText("Некорректный ввод. "
                            + "Пожалуйста, повторите ввод.");
                    alert.showAndWait();
                    return;
                }
            Vector vector =
                    new Vector(Double.parseDouble(firstXTextField.getText()),
                    Double.parseDouble(firstYTextField.getText()),
                    Double.parseDouble(secondXTextField.getText()),
                    Double.parseDouble(secondYTextField.getText()));

                lengthOfVectorLabel.setText("Норма вектора: "
                        + vector.countingLengthOfVector());
                projectionXLabel.setText("Проекция на х: "
                        + vector.projectionOnX());
                projectionYLabel.setText("Проекция на y: "
                        + vector.projectionOnY());
            }
        });
        clearButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent pushEvent) {
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

    /** This is a main method that called for appearing
     * main window of vector calculator application.
     * It runs a launch method.
     * @param args  Unused.
     * */
    public static void main(final String[] args) {
        launch(args);
    }
}
