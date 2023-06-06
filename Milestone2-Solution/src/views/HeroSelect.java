package views;



	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class HeroSelect extends Application {

    private List<Hero> availableHeroes;
    private Hero selectedHero;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Initialize available heroes
        availableHeroes = new ArrayList<>();
        availableHeroes.add(new Hero("Hero 1", "Type 1", "Details 1"));
        availableHeroes.add(new Hero("Hero 2", "Type 2", "Details 2"));
        availableHeroes.add(new Hero("Hero 3", "Type 3", "Details 3"));

        // Create UI components
        ListView<Hero> heroListView = createHeroListView();
        Button selectButton = createSelectButton(heroListView);

        // Layout the UI components
        VBox vbox = new VBox(heroListView, selectButton);
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10));

        // Create the scene and show the stage
        Scene scene = new Scene(vbox);
        primaryStage.setTitle("Game Start");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private ListView<Hero> createHeroListView() {
        ListView<Hero> heroListView = new ListView<>();
        heroListView.setItems(FXCollections.observableArrayList(availableHeroes));
        heroListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectedHero = newValue;
            System.out.println("Selected Hero: " + selectedHero.getName());
        });
        return heroListView;
    }

    private Button createSelectButton(ListView<Hero> heroListView) {
        Button selectButton = new Button("Select Hero");
        selectButton.setOnAction(event -> {
            if (selectedHero != null) {
                // Start the game with the selected hero
                System.out.println("Starting the game with the selected hero: " + selectedHero.getName());
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING, "No hero selected!");
                alert.showAndWait();
            }
        });
        return selectButton;
    }

    private static class Hero {
        private String name;
        private String type;
        private String details;

        public Hero(String name, String type, String details) {
            this.name = name;
            this.type = type;
            this.details = details;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public String getDetails() {
            return details;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
