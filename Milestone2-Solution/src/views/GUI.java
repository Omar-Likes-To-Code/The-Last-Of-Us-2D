package views;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class GUI extends Application {

    private static final String BACKGROUND_IMAGE_URL = "https://images8.alphacoders.com/532/532407.jpg";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Game Start Menu");

        // Create buttons
        Button playButton = createStyledButton("Play");
        Button exitButton = createStyledButton("Exit");

        // Set button actions
        playButton.setOnAction(e -> {
            // Create a new empty stage
            Stage gameStage = new Stage();
            gameStage.setTitle("Game");
            // Set the content of the new stage
            // ...
            gameStage.show();
            // Close the start menu stage
            primaryStage.close();
        });

        exitButton.setOnAction(e -> {
            // Exit the application
            primaryStage.close();
        });

        // Load the background image
        Image backgroundImage = new Image(BACKGROUND_IMAGE_URL);
        BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, false, false);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, backgroundSize);

        // Create the root pane with a stack pane
        StackPane rootPane = new StackPane();
        rootPane.setBackground(new Background(background));

        // Create a vertical layout for the buttons
        VBox buttonLayout = new VBox(20);
        buttonLayout.setAlignment(Pos.CENTER);
        buttonLayout.getChildren().addAll(playButton, exitButton);

        // Add the button layout to the root pane
        rootPane.getChildren().add(buttonLayout);

        // Create the scene and set it on the stage
        Scene scene = new Scene(rootPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button createStyledButton(String text) {
        Button button = new Button(text);
        button.setPrefWidth(200);
        button.setPrefHeight(50);
        button.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16px;");
        return button;
    }
}


