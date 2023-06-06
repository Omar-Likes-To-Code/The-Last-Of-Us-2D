package views;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GRID extends Application {

    private static final int GRID_SIZE = 15;
    private static final int CELL_SIZE = 30;

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();

        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                Rectangle cell = new Rectangle(CELL_SIZE, CELL_SIZE);
                cell.setFill(Color.WHITE);
                cell.setStroke(Color.BLACK);
                gridPane.add(cell, col, row);
            }
        }

        Scene scene = new Scene(gridPane, GRID_SIZE * CELL_SIZE, GRID_SIZE * CELL_SIZE);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Grid Example");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
