package views;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class testing extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a StackPane as the root pane
        StackPane root = new StackPane();

        // Create a VBox
        VBox vbox = new VBox();
        vbox.setSpacing(10);  // Set spacing between child nodes

        // Create some labels to add to the VBox
        Label label1 = new Label("Label 1");
        Label label2 = new Label("Label 2");

        // Add labels to the VBox
        vbox.getChildren().addAll(label1, label2);

        // Set margin of the VBox to adjust position within the StackPane
        StackPane.setMargin(vbox, new Insets(50, 0, 0, 0));

        // Add the VBox to the StackPane
        root.getChildren().add(vbox);

        // Create a scene with the StackPane
        Scene scene = new Scene(root, 400, 400);

        // Set the scene to the stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
