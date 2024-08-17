package views;

import java.io.IOException;
import javafx.scene.control.*;
//import javafx.scene.control.Alert.AlertType;
import model.world.*;
import model.collectibles.*;
import model.characters.*;
import javafx.scene.control.Alert;
//--module-path "\path\to\javafx-sdk-20\lib" --add-modules javafx.controls,javafx.fxml
import engine.Game;
import exceptions.InvalidTargetException;
import exceptions.MovementException;
import exceptions.NoAvailableResourcesException;
import exceptions.NotEnoughActionsException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import model.characters.Direction;
import model.characters.Hero;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.image.*;
import javafx.scene.text.*;
import javafx.scene.control.Button;
import javafx.stage.Popup;
import javafx.scene.layout.StackPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.geometry.HPos;
import javafx.geometry.VPos;

public class tlou extends Application {
	private Stage primaryStage;
    private Scene startScene, charactersScene, gameScene;
    private static final int GRID_SIZE=15;
	private static final int SQUARE_SIZE=50;
	private static Hero currentHero;
	private static GridPane gridPane;
	private static Button startButton;
	private static Button start1;
	private static Button start2;
	private Image hero = new Image("C:\\Users\\youss\\OneDrive\\Pictures\\TLOU\\862-8625673_luke-cage-2d-video-game-characters.png");
	private static StackPane charactersPane;
	
	
	 private static Button b1 = new Button("Joel Miller"+ "\nFighter" + "\nmax HP: 140" + "\nmax actions: 5" + "\natack DMG: 30");
     private static Button b2 = new Button("Ellie Williams" + "\nMedic" + "\n max HP: 110" + "\nmax actions: 6" + "\nattack DMG: 15");
     private static Button b3 = new Button("Tess" + "\n Explorer"  + "\nmax HP: 80" + "\nmax actions: 6" + "\nattack DMG: 20");
     private static Button b4 = new Button("Riley Abel" + "\nExplorer" + "\nmax HP: 90" + "\nmax actions: 5" + "\nattack DMG: 25");
     private static Button b5 = new Button("Tommy miller" + "\nExplorer" + "\nmax HP: 95" + "\nmax actions: 5" + "\nattack DMG: 25");
     private static Button b6 = new Button("Bill" + "\nMedic" + "\nmax HP: 100" + "\nmax actions: 7" + "\nattack DMG: 10");
     private static Button b7 = new Button("David" + "\nFighter" + "\nmax HP: 150" + "\nmax actions: 4" + "\nattack DMG: 35");
     private static Button b8 = new Button("Henry Burell" + "\nMedic" + "\nmax HP: 105" + "\nmax actions: 6" + "\nattack DMG: 15");
    
	
	


	
	
	
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
        Game.loadHeroes("Heroes.csv");
        
        Image backgroundImage = new Image("C:\\Users\\youss\\OneDrive\\Pictures\\TLOU\\dpjbepk.jpg");
        BackgroundImage backgroundImg = new BackgroundImage(backgroundImage,
        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
        BackgroundPosition.CENTER, new BackgroundSize(1.0, 1.0, true, true, false, false));

        Background background = new Background(backgroundImg);
        Label title = new Label("Welcome to the last of us legacy!");
        title.setFont(new Font(30));
        title.setTextFill(Color.WHITESMOKE);
        
        start1 = new Button();
        start1.setLayoutX(900);
        start1.setLayoutY(700);
        start1.setText("Start Game");
        start1.setOnAction(event ->{
        	primaryStage.setScene(charactersScene);
        });
        
        StackPane mainLayout = new StackPane();
        mainLayout.setPadding(new Insets(50));
        StackPane.setAlignment(start1, javafx.geometry.Pos.BOTTOM_RIGHT);
        
        start1.setOnAction(e ->{
        	primaryStage.setScene(charactersScene);
        });
       
        mainLayout.getChildren().addAll(start1,title);
        mainLayout.setBackground(background);
        startScene = new Scene(mainLayout, 1000, 800);
        Button switchBackButton = new Button("Back");
        switchBackButton.setOnAction(event ->{
        	primaryStage.setScene(startScene);
        });
        Button switchBackButton2 = new Button("Back");
        switchBackButton2.setOnAction(event ->{
        	primaryStage.setScene(charactersScene);
        });
        
        charactersPane = new StackPane();
        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.getChildren().addAll(b1, b2, b3, b4, b5, b6, b7, b8);
        charactersPane.getChildren().add(hbox);
        
        Label l1 = new Label("Select starting hero");
        l1.setFont(new Font(30));
        l1.setTextFill(Color.RED);
        charactersPane = new StackPane();
        
        
        
        
        
        
        
        
        
        primaryStage.setScene(startScene);
        primaryStage.setTitle("The last of us legacy");
        primaryStage.show();
	}
	

	public static void main(String[] args) {
		launch(args);

	}

}
