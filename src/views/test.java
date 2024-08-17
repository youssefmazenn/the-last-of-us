package views;


	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class test extends Application {

    @Override
    public void start(Stage primaryStage) {
        StackPane stackPane = new StackPane();
        Scene scene1 = new Scene(stackPane, 200, 200);

        Label label = new Label("Scene 1");
        stackPane.getChildren().add(label);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText("Click me to change the scene!");
        alert.setContentText("This is an alert.");

        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                // Change the scene when OK is clicked
                StackPane newStackPane = new StackPane();
                Scene scene2 = new Scene(newStackPane, 200, 200);

                Label newLabel = new Label("Scene 2");
                newStackPane.getChildren().add(newLabel);

                primaryStage.setScene(scene2);
            }
        });

        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
