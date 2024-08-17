package views;
import java.io.IOException;
import javafx.scene.control.*;
//import javafx.scene.control.Alert.AlertType;
import model.world.*;
import model.collectibles.*;
import model.characters.*;
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
import javafx.stage.Popup;
import javafx.scene.layout.StackPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

public class view extends Application {

    private Stage primaryStage;
    private Scene mainScene, otherScene, game;
    private static final int GRID_SIZE=15;
	private static final int SQUARE_SIZE=50;
	private static Hero currentHero;
	
	private int col=0;
	private int xloc=0;
	
	 private int targetX = -1;
	 private int targetY = -1;
	private Image joel = new Image("C:\\Users\\youss\\OneDrive\\Pictures\\TLOU\\joel.png");
	private Image ellie = new Image("C:\\Users\\youss\\OneDrive\\Pictures\\TLOU\\ellie.png");
	private Image tess = new Image("C:\\Users\\youss\\OneDrive\\Pictures\\TLOU\\tess.jpg");
	private Image riley = new Image("C:\\Users\\youss\\OneDrive\\Pictures\\TLOU\\riley.jpg");
	private Image tommy = new Image("C:\\Users\\youss\\OneDrive\\Pictures\\TLOU\\tommy.jpg");
	private Image bill = new Image("C:\\Users\\youss\\OneDrive\\Pictures\\TLOU\\bill.png");
	private Image david = new Image("C:\\Users\\youss\\OneDrive\\Pictures\\TLOU\\david.jpg");
	private Image henry = new Image("C:\\Users\\youss\\OneDrive\\Pictures\\TLOU\\henry.jpg");
	private Image vaccine = new Image("C:\\Users\\youss\\OneDrive\\Pictures\\TLOU\\vaccine.png");
	private Image supply = new Image("C:\\Users\\youss\\OneDrive\\Pictures\\TLOU\\supply.png");
	private Image zombie = new Image("C:\\Users\\youss\\OneDrive\\Pictures\\TLOU\\zombie.png");
	private static MenuBar menuBar = new MenuBar();
	private static Menu fileMenu = new Menu();
	private static Menu fileMenu2 = new Menu();
	private static Menu fileMenu3 = new Menu();
	private static Menu fileMenu4 = new Menu();
	private static String type;
	//private static Text heroes;
	

	
			
	
	
	
	
	
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        Game.loadHeroes("Heroes.csv");
        

        // Create the main scene
        Image backgroundImage = new Image("C:\\Users\\youss\\OneDrive\\Pictures\\TLOU\\dpjbepk.jpg");
        // Create a BackgroundImage with the image, specify its properties
        BackgroundImage backgroundImg = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(1.0, 1.0, true, true, false, false));

        // Create a Background with the BackgroundImage
        Background background = new Background(backgroundImg);
        
       
        
        Label title = new Label("Welcome to the last of us legacy!");
        title.setFont(new Font(30));
        title.setTextFill(Color.WHITESMOKE);
       // primaryStage.getChildren().add(l1);
        Button switchButton = new Button();
      
        switchButton.setLayoutX(900);
        switchButton.setLayoutY(700);
        switchButton.setText("Start Game");
        switchButton.setOnAction(event -> playGame());
        
        

        StackPane mainLayout = new StackPane();
        mainLayout.setPadding(new Insets(50));
        StackPane.setAlignment(switchButton, javafx.geometry.Pos.BOTTOM_RIGHT);
        
       // mainLayout.setStyle("-fx-background-color: #00000f;");
        //mainLayout.getChildren().add(title);
        mainLayout.getChildren().addAll(switchButton,title);
        mainLayout.setBackground(background);


        mainScene = new Scene(mainLayout, 1000, 800);
        

        // Create the other scene
        Button switchBackButton = new Button("Back");
        switchBackButton.setOnAction(event -> switchToMainScene());
        
        
        //layout of the start game scene
        StackPane otherLayout = new StackPane();
        //otherLayout.setStyle("-fx-background-color: #000000;");
        HBox hbox = new HBox();
        hbox.setSpacing(10);


        // Create buttons with text
        Button b1 = new Button("Joel Miller"+ "\nFighter" + "\nmax HP: 140" + "\nmax actions: 5" + "\natack DMG: 30");
        Button b2 = new Button("Ellie Williams" + "\nMedic" + "\n max HP: 110" + "\nmax actions: 6" + "\nattack DMG: 15");
        Button b3 = new Button("Tess" + "\n Explorer"  + "\nmax HP: 80" + "\nmax actions: 6" + "\nattack DMG: 20");
        Button b4 = new Button("Riley Abel" + "\nExplorer" + "\nmax HP: 90" + "\nmax actions: 5" + "\nattack DMG: 25");
        Button b5 = new Button("Tommy miller" + "\nExplorer" + "\nmax HP: 95" + "\nmax actions: 5" + "\nattack DMG: 25");
        Button b6 = new Button("Bill" + "\nMedic" + "\nmax HP: 100" + "\nmax actions: 7" + "\nattack DMG: 10");
        Button b7 = new Button("David" + "\nFighter" + "\nmax HP: 150" + "\nmax actions: 4" + "\nattack DMG: 35");
        Button b8 = new Button("Henry Burell" + "\nMedic" + "\nmax HP: 105" + "\nmax actions: 6" + "\nattack DMG: 15");
        hbox.getChildren().addAll(b1, b2, b3, b4, b5, b6, b7, b8);
        otherLayout.getChildren().add(hbox);
        
       
    	        
        Image bg = new Image("C:\\Users\\youss\\OneDrive\\Pictures\\TLOU\\dpjbepk.jpg");
        BackgroundImage backgroundImg2 = new BackgroundImage(bg,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(1.0, 1.0, true, true, false, false));
        Background background2 = new Background(backgroundImg2);
        otherLayout.setBackground(background2);


        
        
        
        Label l1 = new Label("Select starting hero");
        l1.setFont(new Font(30));
        l1.setTextFill(Color.WHITE);
        
        otherLayout.getChildren().add(l1);
        
       
		StackPane gameLayout = new StackPane();
    	GridPane gridPane = new GridPane();


        
    	b1.setOnAction(event -> {
            currentHero = Game.availableHeroes.get(0);
            Game.startGame(currentHero);
           
           
            gridPane.setAlignment(Pos.CENTER);
           
        for(int row=0;row<GRID_SIZE;row++){
        int rowMap=14-row;
        	for(int col1 =0;col1<GRID_SIZE;col1++){
       
      
       
                        if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                        Rectangle square= createSquare();
            gridPane.add(square,col1,row);
                        ImageView jImageView = new ImageView(joel);
    jImageView.setFitWidth(50);  
    jImageView.setFitHeight(50);
        gridPane.add(jImageView, col1, row);

        }
                        else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
        Rectangle square= createSquare();
            gridPane.add(square,col1,row);
        ImageView vaccineIV = new ImageView(vaccine);
        vaccineIV.setFitWidth(50);  
                    vaccineIV.setFitHeight(50);
        gridPane.add(vaccineIV, col1, row);
        }
                        else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
        Rectangle square= createSquare();
            gridPane.add(square,col1,row);
        ImageView supplyIV = new ImageView(supply);
        supplyIV.setFitWidth(50);  
                    supplyIV.setFitHeight(50);
        gridPane.add(supplyIV, col1, row);
        }
                        else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
       
                        Rectangle square= createSquare();
        Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
               text.setFont(new Font(10));
               l1.setTextFill(Color.BLACK);
                         
        gridPane.add(square, col1, row);
                   gridPane.add(text, col1, row);
                   
       
        }
                        else {
            Rectangle square= createSquare();
            gridPane.add(square,col1,row);
            }
        }
       
        }

             
        gameLayout.getChildren().add(gridPane);
           
               
                 
                 gameLayout.setStyle("-fx-background-color: #000000;");
         
               
         
            Rectangle rectangle = new Rectangle(160, 150, Color.DARKGRAY);
            Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                 text.setFont(Font.font("Arial", 14));
                 text.setFill(Color.BLACK);
                 
               


              gameLayout.setAlignment(Pos.TOP_RIGHT);


                rectangle.setTranslateY(-10);

           
            double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
               
                text.relocate(textX, textY);
                
                
            

            
            gameLayout.getChildren().addAll(rectangle,text);
            

           
                Button up = new Button("↑");
                Button down = new Button("↓");
            Button left = new Button("←");
            Button right = new Button("→");
               
               
                Button attack = new Button("ATTACK");
                Button cure = new Button("CURE");
                Button useSpecial = new Button("USE SPECIAL");
                Button endTurn = new Button("END TURN");
                

               
               
                menuBar= new MenuBar();
                fileMenu= new Menu("Select Zombie");
                fileMenu2 = new Menu ("Select HeroTarget");
            fileMenu3 = new Menu ("Pick a Hero");
           fileMenu4 = new Menu ("View Heroes Details");
            fileMenu.setStyle("-fx-text-fill: white;");
            fileMenu2.setStyle("-fx-text-fill: white;");
            fileMenu3.setStyle("-fx-text-fill: white;");
            fileMenu4.setStyle("-fx-text-fill: white;");
                menuBar.setPrefWidth(50);
                menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                for(int i=0; i<Game.zombies.size();i++){
                 MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                 fileMenu.getItems().add(openMenuItem);
                 int x=i;
                 openMenuItem.setOnAction(event2->{
                 currentHero.setTarget(Game.zombies.get(x));
                 System.out.println(currentHero.getTarget());
                 });
                }
                for(int i=0; i<Game.heroes.size();i++){
                 MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                 fileMenu3.getItems().add(openMenuItem);
                 int x=i;
                 openMenuItem.setOnAction(event2->{
                 currentHero = Game.heroes.get(x);
                 
                 });
                }
                for(int i=0; i<Game.heroes.size();i++){
                 MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                 fileMenu2.getItems().add(openMenuItem);
                 int x=i;
                 openMenuItem.setOnAction(event2->{
                 currentHero.setTarget(Game.heroes.get(x));
                 System.out.println(currentHero.getTarget());
                 });
                }
                for(int i=0; i<Game.heroes.size();i++){
        			 if(Game.heroes.get(i) instanceof Fighter) {
     				  type = "Fighter";

     			 }
     			 else if(Game.heroes.get(i) instanceof Medic) {
     				 type = "Medic";

     			 }
     			 else {
     				type = "Explorer";
     			 }
        			 
        			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
        			 fileMenu4.getItems().add(openMenuItem);
     	            

     			 	
     		 }	
                
               
             
                menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                gameLayout.getChildren().add(menuBar);
               
               
               
               
                if(Game.checkWin()){
                	Alert win = new Alert(Alert.AlertType.INFORMATION);
		             win.setTitle("All done!");
		             win.setHeaderText("Close game");
		             win.setContentText("This is an alert.");
		             win.showAndWait().ifPresent(response -> {
		                 if (response == ButtonType.OK) {
		                     primaryStage.close();
		                 }
		             });
		             win.setOnCloseRequest(close -> {
		                 // Change the scene when the alert is closed
		                 

		                 primaryStage.close();
		             });
       
                }
                if(Game.checkGameOver()){
                	Alert lose = new Alert(Alert.AlertType.INFORMATION);
		             lose.setTitle("You lost");
		             lose.setHeaderText("Close game");
		             lose.setContentText("This is an alert.");
		             lose.showAndWait().ifPresent(response -> {
		                 if (response == ButtonType.OK) {
		                     primaryStage.close();
		                 }
		             });
		             lose.setOnCloseRequest(close -> {
		                 // Change the scene when the alert is closed
		                 

		                 primaryStage.close();
		             });
                }
               

               
                VBox buttonsBox = new VBox();              
                buttonsBox.getChildren().addAll(menuBar,up,down,left,right,attack,cure,useSpecial, endTurn);
                
                
                
                
                gameLayout.getChildren().add(buttonsBox);
                buttonsBox.setAlignment(Pos.TOP_LEFT);
               
               
               
               
               
               
               
               
               
               
               
               


               up.setOnMouseClicked(new EventHandler<Event>() {  
    public void handle(Event event) {
    try {
    col = (int) currentHero.getLocation().getY();
            xloc = (int) (15 -1 - currentHero.getLocation().getX());
            if(Game.map[((int)currentHero.getLocation().getX()) + 1][(int) currentHero.getLocation().getY()]instanceof TrapCell) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Warning");
    alert.setContentText("You have entered a trap cell!");
    alert.showAndWait();
            }
    currentHero.move(Direction.UP);
    for(int row=0;row<GRID_SIZE;row++){
        int rowMap=14-row;
        	for(int col1 =0;col1<GRID_SIZE;col1++){
       
      
       
                        if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                        Rectangle square= createSquare();
            gridPane.add(square,col1,row);
                        ImageView jImageView = new ImageView(joel);
    jImageView.setFitWidth(50);  
    jImageView.setFitHeight(50);
        gridPane.add(jImageView, col1, row);

        }
                        else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
        Rectangle square= createSquare();
            gridPane.add(square,col1,row);
        ImageView vaccineIV = new ImageView(vaccine);
        vaccineIV.setFitWidth(50);  
                    vaccineIV.setFitHeight(50);
        gridPane.add(vaccineIV, col1, row);
        }
                        else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
        Rectangle square= createSquare();
            gridPane.add(square,col1,row);
        ImageView supplyIV = new ImageView(supply);
        supplyIV.setFitWidth(50);  
                    supplyIV.setFitHeight(50);
        gridPane.add(supplyIV, col1, row);
        }
                        else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
       
                        Rectangle square= createSquare();
        Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
               text.setFont(new Font(10));
               l1.setTextFill(Color.BLACK);
                         
        gridPane.add(square, col1, row);
                   gridPane.add(text, col1, row);
                   
       
        }
                        else {
            Rectangle square= createSquare();
            gridPane.add(square,col1,row);
            }
        }
       
        }
    Rectangle rectangle = new Rectangle(160, 150, Color.DARKGRAY);
    Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                text.setFont(Font.font("Arial", 14));
                text.setFill(Color.BLACK);
            gameLayout.setAlignment(Pos.TOP_RIGHT);
               rectangle.setTranslateY(-10);
            double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
               double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
               text.relocate(textX, textY);
           gameLayout.getChildren().add(rectangle);
            gameLayout.getChildren().add(text);
            
            
            

     	
		 	

            
            menuBar= new MenuBar();
            fileMenu= new Menu("Select Zombie");
            fileMenu2 = new Menu ("Select HeroTarget");
        fileMenu3 = new Menu ("Pick a Hero");
       fileMenu4 = new Menu ("View Heroes Details");
        fileMenu.setStyle("-fx-text-fill: white;");
        fileMenu2.setStyle("-fx-text-fill: white;");
        fileMenu3.setStyle("-fx-text-fill: white;");
        fileMenu4.setStyle("-fx-text-fill: white;");
            menuBar.setPrefWidth(50);
            menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
            for(int i=0; i<Game.zombies.size();i++){
             MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
             fileMenu.getItems().add(openMenuItem);
             int x=i;
             openMenuItem.setOnAction(event2->{
             currentHero.setTarget(Game.zombies.get(x));
             System.out.println(currentHero.getTarget());
             });
            }
            for(int i=0; i<Game.heroes.size();i++){
             MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
             fileMenu3.getItems().add(openMenuItem);
             int x=i;
             openMenuItem.setOnAction(event2->{
             currentHero = Game.heroes.get(x);
             
             });
            }
            for(int i=0; i<Game.heroes.size();i++){
             MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
             fileMenu2.getItems().add(openMenuItem);
             int x=i;
             openMenuItem.setOnAction(event2->{
             currentHero.setTarget(Game.heroes.get(x));
             System.out.println(currentHero.getTarget());
             });
            }
            for(int i=0; i<Game.heroes.size();i++){
    			 if(Game.heroes.get(i) instanceof Fighter) {
 				  type = "Fighter";

 			 }
 			 else if(Game.heroes.get(i) instanceof Medic) {
 				 type = "Medic";

 			 }
 			 else {
 				type = "Explorer";
 			 }
    			 
    			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
    			 fileMenu4.getItems().add(openMenuItem);
 	            

 			 	
 		 }	
            
           
         
            menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
            gameLayout.getChildren().add(menuBar);

               
               


                if(Game.checkWin()){
                	Alert win = new Alert(Alert.AlertType.INFORMATION);
		             win.setTitle("All done!");
		             win.setHeaderText("Close game");
		             win.setContentText("This is an alert.");
		             win.showAndWait().ifPresent(response -> {
		                 if (response == ButtonType.OK) {
		                     primaryStage.close();
		                 }
		             });
		             win.setOnCloseRequest(close -> {
		                 // Change the scene when the alert is closed
		                 

		                 primaryStage.close();
		             });
       
                }
                if(Game.checkGameOver()){
                	Alert lose = new Alert(Alert.AlertType.INFORMATION);
		             lose.setTitle("You lost");
		             lose.setHeaderText("Close game");
		             lose.setContentText("This is an alert.");
		             lose.showAndWait().ifPresent(response -> {
		                 if (response == ButtonType.OK) {
		                     primaryStage.close();
		                 }
		             });
		             lose.setOnCloseRequest(close -> {
		                 // Change the scene when the alert is closed
		                 

		                 primaryStage.close();
		             });
                }
                
               
                          

    }
    catch (NotEnoughActionsException e) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Insufficient Actions");
    alert.setContentText(e.getMessage());
    alert.showAndWait();
    }

    catch (MovementException e) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Invalid Movement");
    
    alert.setContentText(e.getMessage());
    alert.showAndWait();
    }
    }
    
               });
               down.setOnMouseClicked(new EventHandler<Event>() {
             
        @Override
        public void handle(Event event) {
        try {
        col = (int) currentHero.getLocation().getY();
                xloc = (int) (15 -1 - currentHero.getLocation().getX());
                if(Game.map[((int)currentHero.getLocation().getX()) - 1][(int) currentHero.getLocation().getY()]instanceof TrapCell) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Warning");
    alert.setContentText("You have entered a trap cell!");
    alert.showAndWait();
                }
               
               
                currentHero.move(Direction.DOWN);
                for(int row=0;row<GRID_SIZE;row++){
                    int rowMap=14-row;
                    	for(int col1 =0;col1<GRID_SIZE;col1++){
                   
                  
                   
                                    if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                                    Rectangle square= createSquare();
                        gridPane.add(square,col1,row);
                                    ImageView jImageView = new ImageView(joel);
                jImageView.setFitWidth(50);  
                jImageView.setFitHeight(50);
                    gridPane.add(jImageView, col1, row);

                    }
                                    else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
                    Rectangle square= createSquare();
                        gridPane.add(square,col1,row);
                    ImageView vaccineIV = new ImageView(vaccine);
                    vaccineIV.setFitWidth(50);  
                                vaccineIV.setFitHeight(50);
                    gridPane.add(vaccineIV, col1, row);
                    }
                                    else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
                    Rectangle square= createSquare();
                        gridPane.add(square,col1,row);
                    ImageView supplyIV = new ImageView(supply);
                    supplyIV.setFitWidth(50);  
                                supplyIV.setFitHeight(50);
                    gridPane.add(supplyIV, col1, row);
                    }
                                    else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
                   
                                    Rectangle square= createSquare();
                    Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                           text.setFont(new Font(10));
                           l1.setTextFill(Color.BLACK);
                                     
                    gridPane.add(square, col1, row);
                               gridPane.add(text, col1, row);
                               
                   
                    }
                                    else {
                        Rectangle square= createSquare();
                        gridPane.add(square,col1,row);
                        }
                    }
                   
                    }
        Rectangle rectangle = new Rectangle(160, 150, Color.DARKGRAY);
        Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                       
        //Text text = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                     text.setFont(Font.font("Arial", 14));
                     text.setFill(Color.BLACK);
                  gameLayout.setAlignment(Pos.TOP_RIGHT);
                     rectangle.setTranslateY(-10);
                  double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                     double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                     text.relocate(textX, textY);
                 gameLayout.getChildren().add(rectangle);
                  gameLayout.getChildren().add(text);
                  
                                    
                  
                  menuBar= new MenuBar();
                  fileMenu= new Menu("Select Zombie");
                  fileMenu2 = new Menu ("Select HeroTarget");
              fileMenu3 = new Menu ("Pick a Hero");
             fileMenu4 = new Menu ("View Heroes Details");
              fileMenu.setStyle("-fx-text-fill: white;");
              fileMenu2.setStyle("-fx-text-fill: white;");
              fileMenu3.setStyle("-fx-text-fill: white;");
              fileMenu4.setStyle("-fx-text-fill: white;");
                  menuBar.setPrefWidth(50);
                  menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                  for(int i=0; i<Game.zombies.size();i++){
                   MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                   fileMenu.getItems().add(openMenuItem);
                   int x=i;
                   openMenuItem.setOnAction(event2->{
                   currentHero.setTarget(Game.zombies.get(x));
                   System.out.println(currentHero.getTarget());
                   });
                  }
                  for(int i=0; i<Game.heroes.size();i++){
                   MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                   fileMenu3.getItems().add(openMenuItem);
                   int x=i;
                   openMenuItem.setOnAction(event2->{
                   currentHero = Game.heroes.get(x);
                   
                   });
                  }
                  for(int i=0; i<Game.heroes.size();i++){
                   MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                   fileMenu2.getItems().add(openMenuItem);
                   int x=i;
                   openMenuItem.setOnAction(event2->{
                   currentHero.setTarget(Game.heroes.get(x));
                   System.out.println(currentHero.getTarget());
                   });
                  }
                  for(int i=0; i<Game.heroes.size();i++){
          			 if(Game.heroes.get(i) instanceof Fighter) {
       				  type = "Fighter";

       			 }
       			 else if(Game.heroes.get(i) instanceof Medic) {
       				 type = "Medic";

       			 }
       			 else {
       				type = "Explorer";
       			 }
          			 
          			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
          			 fileMenu4.getItems().add(openMenuItem);
       	            

       			 	
       		 }	
                  
                 
               
                  menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                  gameLayout.getChildren().add(menuBar);
                   
                  if(Game.checkWin()){
                    	Alert win = new Alert(Alert.AlertType.INFORMATION);
    		             win.setTitle("All done!");
    		             win.setHeaderText("Close game");
    		             win.setContentText("This is an alert.");
    		             win.showAndWait().ifPresent(response -> {
    		                 if (response == ButtonType.OK) {
    		                     primaryStage.close();
    		                 }
    		             });
    		             win.setOnCloseRequest(close -> {
    		                 // Change the scene when the alert is closed
    		                 

    		                 primaryStage.close();
    		             });
           
                    }
                    if(Game.checkGameOver()){
                    	Alert lose = new Alert(Alert.AlertType.INFORMATION);
    		             lose.setTitle("You lost");
    		             lose.setHeaderText("Close game");
    		             lose.setContentText("This is an alert.");
    		             lose.showAndWait().ifPresent(response -> {
    		                 if (response == ButtonType.OK) {
    		                     primaryStage.close();
    		                 }
    		             });
    		             lose.setOnCloseRequest(close -> {
    		                 // Change the scene when the alert is closed
    		                 

    		                 primaryStage.close();
    		             });
                    }
                    
                   
                     
               
        } catch (NotEnoughActionsException e) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Insufficient Actions");
    alert.setContentText(e.getMessage());
    alert.showAndWait();
    }

    catch (MovementException e) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Invalid Movement");
    alert.setContentText(e.getMessage());
    alert.showAndWait();

    }
    }
                 
                 
            });

               left.setOnMouseClicked(new EventHandler<Event>() {
               
          @Override
          public void handle(Event event) {
          try {
          col = (int) currentHero.getLocation().getY();
                  xloc = (int) (15 -1 - currentHero.getLocation().getX());
                 
                  if(Game.map[((int)currentHero.getLocation().getX())][(int) currentHero.getLocation().getY() - 1]instanceof TrapCell) {
                  Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setContentText("You have entered a trap cell!");
        alert.showAndWait();
                  }
                 
                 
                  currentHero.move(Direction.LEFT);
                  for(int row=0;row<GRID_SIZE;row++){
                      int rowMap=14-row;
                      	for(int col1 =0;col1<GRID_SIZE;col1++){
                     
                    
                     
                                      if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                                      Rectangle square= createSquare();
                          gridPane.add(square,col1,row);
                                      ImageView jImageView = new ImageView(joel);
                  jImageView.setFitWidth(50);  
                  jImageView.setFitHeight(50);
                      gridPane.add(jImageView, col1, row);

                      }
                                      else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
                      Rectangle square= createSquare();
                          gridPane.add(square,col1,row);
                      ImageView vaccineIV = new ImageView(vaccine);
                      vaccineIV.setFitWidth(50);  
                                  vaccineIV.setFitHeight(50);
                      gridPane.add(vaccineIV, col1, row);
                      }
                                      else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
                      Rectangle square= createSquare();
                          gridPane.add(square,col1,row);
                      ImageView supplyIV = new ImageView(supply);
                      supplyIV.setFitWidth(50);  
                                  supplyIV.setFitHeight(50);
                      gridPane.add(supplyIV, col1, row);
                      }
                                      else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
                     
                                      Rectangle square= createSquare();
                      Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                             text.setFont(new Font(10));
                             l1.setTextFill(Color.BLACK);
                                       
                      gridPane.add(square, col1, row);
                                 gridPane.add(text, col1, row);
                                 
                     
                      }
                                      else {
                          Rectangle square= createSquare();
                          gridPane.add(square,col1,row);
                          }
                      }
                     
                      }
          Rectangle rectangle = new Rectangle(160, 150, Color.DARKGRAY);
          Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                  //Text text = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                     text.setFont(Font.font("Arial", 14));
                     text.setFill(Color.BLACK);
                  gameLayout.setAlignment(Pos.TOP_RIGHT);
                     rectangle.setTranslateY(-10);
                  double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                     double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                     text.relocate(textX, textY);
                 gameLayout.getChildren().add(rectangle);
                  gameLayout.getChildren().add(text);
                  
                  
         
                  menuBar= new MenuBar();
                  fileMenu= new Menu("Select Zombie");
                  fileMenu2 = new Menu ("Select HeroTarget");
              fileMenu3 = new Menu ("Pick a Hero");
             fileMenu4 = new Menu ("View Heroes Details");
              fileMenu.setStyle("-fx-text-fill: white;");
              fileMenu2.setStyle("-fx-text-fill: white;");
              fileMenu3.setStyle("-fx-text-fill: white;");
              fileMenu4.setStyle("-fx-text-fill: white;");
                  menuBar.setPrefWidth(50);
                  menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                  for(int i=0; i<Game.zombies.size();i++){
                   MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                   fileMenu.getItems().add(openMenuItem);
                   int x=i;
                   openMenuItem.setOnAction(event2->{
                   currentHero.setTarget(Game.zombies.get(x));
                   System.out.println(currentHero.getTarget());
                   });
                  }
                  for(int i=0; i<Game.heroes.size();i++){
                   MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                   fileMenu3.getItems().add(openMenuItem);
                   int x=i;
                   openMenuItem.setOnAction(event2->{
                   currentHero = Game.heroes.get(x);
                   
                   });
                  }
                  for(int i=0; i<Game.heroes.size();i++){
                   MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                   fileMenu2.getItems().add(openMenuItem);
                   int x=i;
                   openMenuItem.setOnAction(event2->{
                   currentHero.setTarget(Game.heroes.get(x));
                   System.out.println(currentHero.getTarget());
                   });
                  }
                  for(int i=0; i<Game.heroes.size();i++){
          			 if(Game.heroes.get(i) instanceof Fighter) {
       				  type = "Fighter";

       			 }
       			 else if(Game.heroes.get(i) instanceof Medic) {
       				 type = "Medic";

       			 }
       			 else {
       				type = "Explorer";
       			 }
          			 
          			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
          			 fileMenu4.getItems().add(openMenuItem);
       	            

       			 	
       		 }	
                  
                 
               
                  menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                  gameLayout.getChildren().add(menuBar);
                      
                      if(Game.checkWin()){
                      	Alert win = new Alert(Alert.AlertType.INFORMATION);
      		             win.setTitle("All done!");
      		             win.setHeaderText("Close game");
      		             win.setContentText("This is an alert.");
      		             win.showAndWait().ifPresent(response -> {
      		                 if (response == ButtonType.OK) {
      		                     primaryStage.close();
      		                 }
      		             });
      		             win.setOnCloseRequest(close -> {
      		                 // Change the scene when the alert is closed
      		                 

      		                 primaryStage.close();
      		             });
             
                      }
                      if(Game.checkGameOver()){
                      	Alert lose = new Alert(Alert.AlertType.INFORMATION);
      		             lose.setTitle("You lost");
      		             lose.setHeaderText("Close game");
      		             lose.setContentText("This is an alert.");
      		             lose.showAndWait().ifPresent(response -> {
      		                 if (response == ButtonType.OK) {
      		                     primaryStage.close();
      		                 }
      		             });
      		             lose.setOnCloseRequest(close -> {
      		                 // Change the scene when the alert is closed
      		                 

      		                 primaryStage.close();
      		             });
                      }
                     
                 
          } catch (NotEnoughActionsException e) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Insufficient Actions");
        alert.setContentText(e.getMessage());
        alert.showAndWait();
        }

        catch (MovementException e) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Invalid Movement");
        alert.setContentText(e.getMessage());
        alert.showAndWait();
       
        }
        }
                   });
               right.setOnMouseClicked(new EventHandler<Event>() {
               
          @Override
          public void handle(Event event) {
          try {
          col = (int) currentHero.getLocation().getY();
                  xloc = (int) (15 -1 - currentHero.getLocation().getX());
                    if(Game.map[((int)currentHero.getLocation().getX())][(int) currentHero.getLocation().getY() + 1]instanceof TrapCell) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setContentText("You have entered a trap cell");
        alert.showAndWait();
                    }

          currentHero.move(Direction.RIGHT);
          for(int row=0;row<GRID_SIZE;row++){
              int rowMap=14-row;
              	for(int col1 =0;col1<GRID_SIZE;col1++){
             
            
             
                              if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                              Rectangle square= createSquare();
                  gridPane.add(square,col1,row);
                              ImageView jImageView = new ImageView(joel);
          jImageView.setFitWidth(50);  
          jImageView.setFitHeight(50);
              gridPane.add(jImageView, col1, row);

              }
                              else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
              Rectangle square= createSquare();
                  gridPane.add(square,col1,row);
              ImageView vaccineIV = new ImageView(vaccine);
              vaccineIV.setFitWidth(50);  
                          vaccineIV.setFitHeight(50);
              gridPane.add(vaccineIV, col1, row);
              }
                              else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
              Rectangle square= createSquare();
                  gridPane.add(square,col1,row);
              ImageView supplyIV = new ImageView(supply);
              supplyIV.setFitWidth(50);  
                          supplyIV.setFitHeight(50);
              gridPane.add(supplyIV, col1, row);
              }
                              else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
             
                              Rectangle square= createSquare();
              Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                     text.setFont(new Font(10));
                     l1.setTextFill(Color.BLACK);
                               
              gridPane.add(square, col1, row);
                         gridPane.add(text, col1, row);
                         
             
              }
                              else {
                  Rectangle square= createSquare();
                  gridPane.add(square,col1,row);
                  }
              }
             
              }
         
          Rectangle rectangle = new Rectangle(160, 150, Color.DARKGRAY);
          Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                //  Text text = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                 text.setFont(Font.font("Arial", 14));
                 text.setFill(Color.BLACK);
              gameLayout.setAlignment(Pos.TOP_RIGHT);
                 rectangle.setTranslateY(-10);
              double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                 double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                 text.relocate(textX, textY);
             gameLayout.getChildren().add(rectangle);
              gameLayout.getChildren().add(text);
              
                         
             
              menuBar= new MenuBar();
              fileMenu= new Menu("Select Zombie");
              fileMenu2 = new Menu ("Select HeroTarget");
          fileMenu3 = new Menu ("Pick a Hero");
         fileMenu4 = new Menu ("View Heroes Details");
          fileMenu.setStyle("-fx-text-fill: white;");
          fileMenu2.setStyle("-fx-text-fill: white;");
          fileMenu3.setStyle("-fx-text-fill: white;");
          fileMenu4.setStyle("-fx-text-fill: white;");
              menuBar.setPrefWidth(50);
              menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
              for(int i=0; i<Game.zombies.size();i++){
               MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
               fileMenu.getItems().add(openMenuItem);
               int x=i;
               openMenuItem.setOnAction(event2->{
               currentHero.setTarget(Game.zombies.get(x));
               System.out.println(currentHero.getTarget());
               });
              }
              for(int i=0; i<Game.heroes.size();i++){
               MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
               fileMenu3.getItems().add(openMenuItem);
               int x=i;
               openMenuItem.setOnAction(event2->{
               currentHero = Game.heroes.get(x);
               
               });
              }
              for(int i=0; i<Game.heroes.size();i++){
               MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
               fileMenu2.getItems().add(openMenuItem);
               int x=i;
               openMenuItem.setOnAction(event2->{
               currentHero.setTarget(Game.heroes.get(x));
               System.out.println(currentHero.getTarget());
               });
              }
              for(int i=0; i<Game.heroes.size();i++){
      			 if(Game.heroes.get(i) instanceof Fighter) {
   				  type = "Fighter";

   			 }
   			 else if(Game.heroes.get(i) instanceof Medic) {
   				 type = "Medic";

   			 }
   			 else {
   				type = "Explorer";
   			 }
      			 
      			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
      			 fileMenu4.getItems().add(openMenuItem);
   	            

   			 	
   		 }	
              
             
           
              menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
              gameLayout.getChildren().add(menuBar);
             
                  if(Game.checkWin()){
                  	Alert win = new Alert(Alert.AlertType.INFORMATION);
  		             win.setTitle("All done!");
  		             win.setHeaderText("Close game");
  		             win.setContentText("This is an alert.");
  		             win.showAndWait().ifPresent(response -> {
  		                 if (response == ButtonType.OK) {
  		                     primaryStage.close();
  		                 }
  		             });
  		             win.setOnCloseRequest(close -> {
  		                 // Change the scene when the alert is closed
  		                 

  		                 primaryStage.close();
  		             });
         
                  }
                  if(Game.checkGameOver()){
                  	Alert lose = new Alert(Alert.AlertType.INFORMATION);
  		             lose.setTitle("You lost");
  		             lose.setHeaderText("Close game");
  		             lose.setContentText("This is an alert.");
  		             lose.showAndWait().ifPresent(response -> {
  		                 if (response == ButtonType.OK) {
  		                     primaryStage.close();
  		                 }
  		             });
  		             lose.setOnCloseRequest(close -> {
  		                 // Change the scene when the alert is closed
  		                 

  		                 primaryStage.close();
  		             });
                  }
                 
                 
          } catch (NotEnoughActionsException e) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Insufficient Actions");
        alert.setContentText(e.getMessage());
        alert.showAndWait();
        }

          catch (MovementException e) {
        	    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        	    alert.setTitle("Invalid Movement");
        	    
        	    alert.setContentText(e.getMessage());
        	    alert.showAndWait();
        	    }
        	    }
        
                   });
              
               
               
              
               
               
               attack.setOnAction(event2 -> {
            	   
                try {

                   

                    currentHero.attack();
                 

                    for(int row=0;row<GRID_SIZE;row++){
                        int rowMap=14-row;
                        	for(int col1 =0;col1<GRID_SIZE;col1++){
                       
                      
                       
                                        if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                                        Rectangle square= createSquare();
                            gridPane.add(square,col1,row);
                                        ImageView jImageView = new ImageView(joel);
                    jImageView.setFitWidth(50);  
                    jImageView.setFitHeight(50);
                        gridPane.add(jImageView, col1, row);

                        }
                                        else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
                        Rectangle square= createSquare();
                            gridPane.add(square,col1,row);
                        ImageView vaccineIV = new ImageView(vaccine);
                        vaccineIV.setFitWidth(50);  
                                    vaccineIV.setFitHeight(50);
                        gridPane.add(vaccineIV, col1, row);
                        }
                                        else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
                        Rectangle square= createSquare();
                            gridPane.add(square,col1,row);
                        ImageView supplyIV = new ImageView(supply);
                        supplyIV.setFitWidth(50);  
                                    supplyIV.setFitHeight(50);
                        gridPane.add(supplyIV, col1, row);
                        }
                                        else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
                       
                                        Rectangle square= createSquare();
                        Label text2 = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                               text2.setFont(new Font(10));
                               l1.setTextFill(Color.BLACK);
                                         
                        gridPane.add(square, col1, row);
                                   gridPane.add(text2, col1, row);
                                   
                       
                        }
                                        else {
                            Rectangle square= createSquare();
                            gridPane.add(square,col1,row);
                            }
                        }
                       
                        }

              
                
               Rectangle rectangle2 = new Rectangle(160, 150, Color.DARKGRAY);
               Text text2 = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
               // Text text2 = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                    text2.setFont(Font.font("Arial", 14));
                    text2.setFill(Color.BLACK);
                    gameLayout.setAlignment(Pos.TOP_RIGHT);

                    rectangle2.setTranslateY(-10);
                   
               
                double textX2 = rectangle2.getX() + (rectangle2.getWidth() - text2.getLayoutBounds().getWidth()) / 2;
                    double textY2= rectangle2.getY() + (rectangle2.getHeight() + text2.getLayoutBounds().getHeight()) / 2;
                    text2.relocate(textX2, textY2);
                gameLayout.getChildren().add(rectangle2);
                gameLayout.getChildren().add(text2);
                
                
                
                menuBar= new MenuBar();
                fileMenu= new Menu("Select Zombie");
                fileMenu2 = new Menu ("Select HeroTarget");
            fileMenu3 = new Menu ("Pick a Hero");
           fileMenu4 = new Menu ("View Heroes Details");
            fileMenu.setStyle("-fx-text-fill: white;");
            fileMenu2.setStyle("-fx-text-fill: white;");
            fileMenu3.setStyle("-fx-text-fill: white;");
            fileMenu4.setStyle("-fx-text-fill: white;");
                menuBar.setPrefWidth(50);
                menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                for(int i=0; i<Game.zombies.size();i++){
                 MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                 fileMenu.getItems().add(openMenuItem);
                 int x=i;
                 openMenuItem.setOnAction(event3->{
                 currentHero.setTarget(Game.zombies.get(x));
                 System.out.println(currentHero.getTarget());
                 });
                }
                for(int i=0; i<Game.heroes.size();i++){
                 MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                 fileMenu3.getItems().add(openMenuItem);
                 int x=i;
                 openMenuItem.setOnAction(event3->{
                 currentHero = Game.heroes.get(x);
                 
                 });
                }
                for(int i=0; i<Game.heroes.size();i++){
                 MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                 fileMenu2.getItems().add(openMenuItem);
                 int x=i;
                 openMenuItem.setOnAction(event3->{
                 currentHero.setTarget(Game.heroes.get(x));
                 System.out.println(currentHero.getTarget());
                 });
                }
                for(int i=0; i<Game.heroes.size();i++){
        			 if(Game.heroes.get(i) instanceof Fighter) {
     				  type = "Fighter";

     			 }
     			 else if(Game.heroes.get(i) instanceof Medic) {
     				 type = "Medic";

     			 }
     			 else {
     				type = "Explorer";
     			 }
        			 
        			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
        			 fileMenu4.getItems().add(openMenuItem);
     	            

     			 	
     		 }	
                
               
             
                menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                gameLayout.getChildren().add(menuBar);
                
               
                if(Game.checkWin()){
                	Alert win = new Alert(Alert.AlertType.INFORMATION);
		             win.setTitle("All done!");
		             win.setHeaderText("Close game");
		             win.setContentText("This is an alert.");
		             win.showAndWait().ifPresent(response -> {
		                 if (response == ButtonType.OK) {
		                     primaryStage.close();
		                 }
		             });
		             win.setOnCloseRequest(close -> {
		                 // Change the scene when the alert is closed
		                 

		                 primaryStage.close();
		             });
       
                }
                if(Game.checkGameOver()){
                	Alert lose = new Alert(Alert.AlertType.INFORMATION);
		             lose.setTitle("You lost");
		             lose.setHeaderText("Close game");
		             lose.setContentText("This is an alert.");
		             lose.showAndWait().ifPresent(response -> {
		                 if (response == ButtonType.OK) {
		                     primaryStage.close();
		                 }
		             });
		             lose.setOnCloseRequest(close -> {
		                 // Change the scene when the alert is closed
		                 

		                 primaryStage.close();
		             });
                }
                
       
        } catch (NotEnoughActionsException e) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Insufficient Actions");
        alert.setContentText(e.getMessage());
    alert.showAndWait();

        } catch (InvalidTargetException e) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Invalid Target");
        alert.setContentText(e.getMessage());
    alert.showAndWait();

        }
               });
               
               
               
               cure.setOnMouseClicked(new EventHandler< Event >(){

    @Override
    public void handle(Event arg0) {
    try {
    currentHero.cure();
    for(int row=0;row<GRID_SIZE;row++){
        int rowMap=14-row;
        	for(int col1 =0;col1<GRID_SIZE;col1++){
       
      
       
                        if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                        Rectangle square= createSquare();
            gridPane.add(square,col1,row);
                        ImageView jImageView = new ImageView(joel);
    jImageView.setFitWidth(50);  
    jImageView.setFitHeight(50);
        gridPane.add(jImageView, col1, row);

        }
                        else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
        Rectangle square= createSquare();
            gridPane.add(square,col1,row);
        ImageView vaccineIV = new ImageView(vaccine);
        vaccineIV.setFitWidth(50);  
                    vaccineIV.setFitHeight(50);
        gridPane.add(vaccineIV, col1, row);
        }
                        else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
        Rectangle square= createSquare();
            gridPane.add(square,col1,row);
        ImageView supplyIV = new ImageView(supply);
        supplyIV.setFitWidth(50);  
                    supplyIV.setFitHeight(50);
        gridPane.add(supplyIV, col1, row);
        }
                        else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
       
                        Rectangle square= createSquare();
        Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
               text.setFont(new Font(10));
               l1.setTextFill(Color.BLACK);
                         
        gridPane.add(square, col1, row);
                   gridPane.add(text, col1, row);
                   
       
        }
                        else {
            Rectangle square= createSquare();
            gridPane.add(square,col1,row);
            }
        }
       
        }
    
    
    Rectangle rectangle = new Rectangle(160, 120, Color.DARKGRAY);
    Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
             // Text text = new Text("\n" + Game.heroes.get(Game.heroes.size()-1).getName() + "\nCurrent Hp: " + Game.heroes.get(Game.heroes.size()-1).getCurrentHp() + "\nActions available: " +  Game.heroes.get(Game.heroes.size()-1).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(Game.heroes.size()-1).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
               text.setFont(Font.font("Arial", 14));
               text.setFill(Color.BLACK);
            gameLayout.setAlignment(Pos.TOP_RIGHT);
               rectangle.setTranslateY(-10);
            double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
               double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
               text.relocate(textX, textY);
           gameLayout.getChildren().add(rectangle);
            gameLayout.getChildren().add(text);
            
            
            
            menuBar= new MenuBar();
            fileMenu= new Menu("Select Zombie");
            fileMenu2 = new Menu ("Select HeroTarget");
        fileMenu3 = new Menu ("Pick a Hero");
       fileMenu4 = new Menu ("View Heroes Details");
        fileMenu.setStyle("-fx-text-fill: white;");
        fileMenu2.setStyle("-fx-text-fill: white;");
        fileMenu3.setStyle("-fx-text-fill: white;");
        fileMenu4.setStyle("-fx-text-fill: white;");
            menuBar.setPrefWidth(50);
            menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
            for(int i=0; i<Game.zombies.size();i++){
             MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
             fileMenu.getItems().add(openMenuItem);
             int x=i;
             openMenuItem.setOnAction(event2->{
             currentHero.setTarget(Game.zombies.get(x));
             System.out.println(currentHero.getTarget());
             });
            }
            for(int i=0; i<Game.heroes.size();i++){
             MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
             fileMenu3.getItems().add(openMenuItem);
             int x=i;
             openMenuItem.setOnAction(event2->{
             currentHero = Game.heroes.get(x);
             
             });
            }
            for(int i=0; i<Game.heroes.size();i++){
             MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
             fileMenu2.getItems().add(openMenuItem);
             int x=i;
             openMenuItem.setOnAction(event2->{
             currentHero.setTarget(Game.heroes.get(x));
             System.out.println(currentHero.getTarget());
             });
            }
            for(int i=0; i<Game.heroes.size();i++){
    			 if(Game.heroes.get(i) instanceof Fighter) {
 				  type = "Fighter";

 			 }
 			 else if(Game.heroes.get(i) instanceof Medic) {
 				 type = "Medic";

 			 }
 			 else {
 				type = "Explorer";
 			 }
    			 
    			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
    			 fileMenu4.getItems().add(openMenuItem);
 	            

 			 	
 		 }	
            
           
         
            menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
            gameLayout.getChildren().add(menuBar);
               
               
           
                if(Game.checkWin()){
                	Alert win = new Alert(Alert.AlertType.INFORMATION);
		             win.setTitle("All done!");
		             win.setHeaderText("Close game");
		             win.setContentText("This is an alert.");
		             win.showAndWait().ifPresent(response -> {
		                 if (response == ButtonType.OK) {
		                     primaryStage.close();
		                 }
		             });
		             win.setOnCloseRequest(close -> {
		                 // Change the scene when the alert is closed
		                 

		                 primaryStage.close();
		             });
       
                }
                if(Game.checkGameOver()){
                	Alert lose = new Alert(Alert.AlertType.INFORMATION);
		             lose.setTitle("You lost");
		             lose.setHeaderText("Close game");
		             lose.setContentText("This is an alert.");
		             lose.showAndWait().ifPresent(response -> {
		                 if (response == ButtonType.OK) {
		                     primaryStage.close();
		                 }
		             });
		             lose.setOnCloseRequest(close -> {
		                 // Change the scene when the alert is closed
		                 

		                 primaryStage.close();
		             });
                }
                
                          
    } catch (NoAvailableResourcesException e) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Insufficient resources");
    alert.setContentText(e.getMessage());
    alert.showAndWait();
    } catch (InvalidTargetException e) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Invalid Target");
    alert.setContentText(e.getMessage());
    alert.showAndWait();
    } catch (NotEnoughActionsException e) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Insufficient Actions");
    alert.setContentText(e.getMessage());
    alert.showAndWait();
    }
    }
             
               });
               
               
               
               endTurn.setOnMouseClicked(new EventHandler<Event>(){

    @Override
    public void handle(Event event3) {
    try {
    Game.endTurn();

    if(Game.checkWin()){
    	Alert win = new Alert(Alert.AlertType.INFORMATION);
         win.setTitle("All done!");
         win.setHeaderText("Close game");
         win.setContentText("This is an alert.");
         win.showAndWait().ifPresent(response -> {
             if (response == ButtonType.OK) {
                 primaryStage.close();
             }
         });
         win.setOnCloseRequest(close -> {
             // Change the scene when the alert is closed
             

             primaryStage.close();
         });

    }
    if(Game.checkGameOver()){
    	Alert lose = new Alert(Alert.AlertType.INFORMATION);
         lose.setTitle("You lost");
         lose.setHeaderText("Close game");
         lose.setContentText("This is an alert.");
         lose.showAndWait().ifPresent(response -> {
             if (response == ButtonType.OK) {
                 primaryStage.close();
             }
         });
         lose.setOnCloseRequest(close -> {
             // Change the scene when the alert is closed
             

             primaryStage.close();
         });
    }

    for(int row=0;row<GRID_SIZE;row++){
        int rowMap=14-row;
        	for(int col1 =0;col1<GRID_SIZE;col1++){
       
      
       
                        if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                        Rectangle square= createSquare();
            gridPane.add(square,col1,row);
                        ImageView jImageView = new ImageView(joel);
    jImageView.setFitWidth(50);  
    jImageView.setFitHeight(50);
        gridPane.add(jImageView, col1, row);

        }
                        else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
        Rectangle square= createSquare();
            gridPane.add(square,col1,row);
        ImageView vaccineIV = new ImageView(vaccine);
        vaccineIV.setFitWidth(50);  
                    vaccineIV.setFitHeight(50);
        gridPane.add(vaccineIV, col1, row);
        }
                        else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
        Rectangle square= createSquare();
            gridPane.add(square,col1,row);
        ImageView supplyIV = new ImageView(supply);
        supplyIV.setFitWidth(50);  
                    supplyIV.setFitHeight(50);
        gridPane.add(supplyIV, col1, row);
        }
                        else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
       
                        Rectangle square= createSquare();
        Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
               text.setFont(new Font(10));
               l1.setTextFill(Color.BLACK);
                         
        gridPane.add(square, col1, row);
                   gridPane.add(text, col1, row);
                   
       
        }
                        else {
            Rectangle square= createSquare();
            gridPane.add(square,col1,row);
            }
        }
       
        }
    Rectangle rectangle = new Rectangle(160, 120, Color.DARKGRAY);
    Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
              //Text text = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
               text.setFont(Font.font("Arial", 14));
               text.setFill(Color.BLACK);
            gameLayout.setAlignment(Pos.TOP_RIGHT);
               rectangle.setTranslateY(-10);
            double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
               double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
               text.relocate(textX, textY);
           gameLayout.getChildren().add(rectangle);
            gameLayout.getChildren().add(text);
            
            
            
            menuBar= new MenuBar();
            fileMenu= new Menu("Select Zombie");
            fileMenu2 = new Menu ("Select HeroTarget");
        fileMenu3 = new Menu ("Pick a Hero");
       fileMenu4 = new Menu ("View Heroes Details");
        fileMenu.setStyle("-fx-text-fill: white;");
        fileMenu2.setStyle("-fx-text-fill: white;");
        fileMenu3.setStyle("-fx-text-fill: white;");
        fileMenu4.setStyle("-fx-text-fill: white;");
            menuBar.setPrefWidth(50);
            menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
            for(int i=0; i<Game.zombies.size();i++){
             MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
             fileMenu.getItems().add(openMenuItem);
             int x=i;
             openMenuItem.setOnAction(event2->{
             currentHero.setTarget(Game.zombies.get(x));
             System.out.println(currentHero.getTarget());
             });
            }
            for(int i=0; i<Game.heroes.size();i++){
             MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
             fileMenu3.getItems().add(openMenuItem);
             int x=i;
             openMenuItem.setOnAction(event2->{
             currentHero = Game.heroes.get(x);
             
             });
            }
            for(int i=0; i<Game.heroes.size();i++){
             MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
             fileMenu2.getItems().add(openMenuItem);
             int x=i;
             openMenuItem.setOnAction(event2->{
             currentHero.setTarget(Game.heroes.get(x));
             System.out.println(currentHero.getTarget());
             });
            }
            for(int i=0; i<Game.heroes.size();i++){
    			 if(Game.heroes.get(i) instanceof Fighter) {
 				  type = "Fighter";

 			 }
 			 else if(Game.heroes.get(i) instanceof Medic) {
 				 type = "Medic";

 			 }
 			 else {
 				type = "Explorer";
 			 }
    			 
    			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
    			 fileMenu4.getItems().add(openMenuItem);
 	            

 			 	
 		 }	
            
           
         
            menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
            gameLayout.getChildren().add(menuBar);
                
               
    } catch (NotEnoughActionsException e) {

    } catch (InvalidTargetException e) {

    }
    }
             
               });
               
               useSpecial.setOnMouseClicked(new EventHandler< Event >(){

    @Override
    public void handle(Event event) {
    try {
    currentHero.useSpecial();
    for(int row=0;row<GRID_SIZE;row++){
        int rowMap=14-row;
        	for(int col1 =0;col1<GRID_SIZE;col1++){
       
      
       
                        if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                        Rectangle square= createSquare();
            gridPane.add(square,col1,row);
                        ImageView jImageView = new ImageView(joel);
    jImageView.setFitWidth(50);  
    jImageView.setFitHeight(50);
        gridPane.add(jImageView, col1, row);

        }
                        else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
        Rectangle square= createSquare();
            gridPane.add(square,col1,row);
        ImageView vaccineIV = new ImageView(vaccine);
        vaccineIV.setFitWidth(50);  
                    vaccineIV.setFitHeight(50);
        gridPane.add(vaccineIV, col1, row);
        }
                        else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
        Rectangle square= createSquare();
            gridPane.add(square,col1,row);
        ImageView supplyIV = new ImageView(supply);
        supplyIV.setFitWidth(50);  
                    supplyIV.setFitHeight(50);
        gridPane.add(supplyIV, col1, row);
        }
                        else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
       
                        Rectangle square= createSquare();
        Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
               text.setFont(new Font(10));
               l1.setTextFill(Color.BLACK);
                         
        gridPane.add(square, col1, row);
                   gridPane.add(text, col1, row);
                   
       
        }
                        else {
            Rectangle square= createSquare();
            gridPane.add(square,col1,row);
            }
        }
       
        }
    Rectangle rectangle = new Rectangle(160, 120, Color.DARKGRAY);
    Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
             // Text text = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
               text.setFont(Font.font("Arial", 14));
               text.setFill(Color.BLACK);
            gameLayout.setAlignment(Pos.TOP_RIGHT);
               rectangle.setTranslateY(-10);
            double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
               double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
               text.relocate(textX, textY);
           gameLayout.getChildren().add(rectangle);
           gameLayout.getChildren().add(text);

           menuBar= new MenuBar();
           fileMenu= new Menu("Select Zombie");
           fileMenu2 = new Menu ("Select HeroTarget");
       fileMenu3 = new Menu ("Pick a Hero");
      fileMenu4 = new Menu ("View Heroes Details");
       fileMenu.setStyle("-fx-text-fill: white;");
       fileMenu2.setStyle("-fx-text-fill: white;");
       fileMenu3.setStyle("-fx-text-fill: white;");
       fileMenu4.setStyle("-fx-text-fill: white;");
           menuBar.setPrefWidth(50);
           menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
           for(int i=0; i<Game.zombies.size();i++){
            MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
            fileMenu.getItems().add(openMenuItem);
            int x=i;
            openMenuItem.setOnAction(event2->{
            currentHero.setTarget(Game.zombies.get(x));
            System.out.println(currentHero.getTarget());
            });
           }
           for(int i=0; i<Game.heroes.size();i++){
            MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
            fileMenu3.getItems().add(openMenuItem);
            int x=i;
            openMenuItem.setOnAction(event2->{
            currentHero = Game.heroes.get(x);
            
            });
           }
           for(int i=0; i<Game.heroes.size();i++){
            MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
            fileMenu2.getItems().add(openMenuItem);
            int x=i;
            openMenuItem.setOnAction(event2->{
            currentHero.setTarget(Game.heroes.get(x));
            System.out.println(currentHero.getTarget());
            });
           }
           for(int i=0; i<Game.heroes.size();i++){
   			 if(Game.heroes.get(i) instanceof Fighter) {
				  type = "Fighter";

			 }
			 else if(Game.heroes.get(i) instanceof Medic) {
				 type = "Medic";

			 }
			 else {
				type = "Explorer";
			 }
   			 
   			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
   			 fileMenu4.getItems().add(openMenuItem);
	            

			 	
		 }	
           
          
        
           menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
           gameLayout.getChildren().add(menuBar);
               
                if(Game.checkWin()){
                	Alert win = new Alert(Alert.AlertType.INFORMATION);
		             win.setTitle("All done!");
		             win.setHeaderText("Close game");
		             win.setContentText("This is an alert.");
		             win.showAndWait().ifPresent(response -> {
		                 if (response == ButtonType.OK) {
		                     primaryStage.close();
		                 }
		             });
		             win.setOnCloseRequest(close -> {
		                 // Change the scene when the alert is closed
		                 

		                 primaryStage.close();
		             });
       
                }
                if(Game.checkGameOver()){
                	Alert lose = new Alert(Alert.AlertType.INFORMATION);
		             lose.setTitle("You lost");
		             lose.setHeaderText("Close game");
		             lose.setContentText("This is an alert.");
		             lose.showAndWait().ifPresent(response -> {
		                 if (response == ButtonType.OK) {
		                     primaryStage.close();
		                 }
		             });
		             lose.setOnCloseRequest(close -> {
		                 // Change the scene when the alert is closed
		                 

		                 primaryStage.close();
		             });
                }
               
     
    } catch (NoAvailableResourcesException e) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Insufficient Supply");
    alert.setContentText(e.getMessage());
    alert.showAndWait();
    } catch (InvalidTargetException e) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Invalid Target");
    alert.setContentText(e.getMessage());
    alert.showAndWait();
    }

    }});
       

            game = new Scene(gameLayout, 1470, 800);
          primaryStage.setScene(game);

           

            });
    	b2.setOnAction(event -> {
    	 currentHero = Game.availableHeroes.get(1);
         Game.startGame(currentHero);
        
        
         gridPane.setAlignment(Pos.CENTER);
         
         for(int row=0;row<GRID_SIZE;row++){
         int rowMap=14-row;
         	for(int col1 =0;col1<GRID_SIZE;col1++){
        
       
        
                         if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                         Rectangle square= createSquare();
             gridPane.add(square,col1,row);
                         ImageView jImageView = new ImageView(joel);
     jImageView.setFitWidth(50);  
     jImageView.setFitHeight(50);
         gridPane.add(jImageView, col1, row);

         }
                         else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
         Rectangle square= createSquare();
             gridPane.add(square,col1,row);
         ImageView vaccineIV = new ImageView(vaccine);
         vaccineIV.setFitWidth(50);  
                     vaccineIV.setFitHeight(50);
         gridPane.add(vaccineIV, col1, row);
         }
                         else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
         Rectangle square= createSquare();
             gridPane.add(square,col1,row);
         ImageView supplyIV = new ImageView(supply);
         supplyIV.setFitWidth(50);  
                     supplyIV.setFitHeight(50);
         gridPane.add(supplyIV, col1, row);
         }
                         else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
        
                         Rectangle square= createSquare();
         Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                text.setFont(new Font(10));
                l1.setTextFill(Color.BLACK);
                          
         gridPane.add(square, col1, row);
                    gridPane.add(text, col1, row);
                    
        
         }
                         else {
             Rectangle square= createSquare();
             gridPane.add(square,col1,row);
             }
         }
        
         }

              
         gameLayout.getChildren().add(gridPane);
            
                
                  
                  gameLayout.setStyle("-fx-background-color: #000000;");
          
                
          
             Rectangle rectangle = new Rectangle(160, 150, Color.DARKGRAY);
             Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Medic" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                  text.setFont(Font.font("Arial", 14));
                  text.setFill(Color.BLACK);
                  
                


               gameLayout.setAlignment(Pos.TOP_RIGHT);


                 rectangle.setTranslateY(-10);

            
             double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                 double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                
                 text.relocate(textX, textY);
                 
                 
             

             
             gameLayout.getChildren().addAll(rectangle,text);
             

            
                 Button up = new Button("↑");
                 Button down = new Button("↓");
             Button left = new Button("←");
             Button right = new Button("→");
                
                
                 Button attack = new Button("ATTACK");
                 Button cure = new Button("CURE");
                 Button useSpecial = new Button("USE SPECIAL");
                 Button endTurn = new Button("END TURN");
                 

                
                
                 menuBar= new MenuBar();
                 fileMenu= new Menu("Select Zombie");
                 fileMenu2 = new Menu ("Select HeroTarget");
             fileMenu3 = new Menu ("Pick a Hero");
            fileMenu4 = new Menu ("View Heroes Details");
             fileMenu.setStyle("-fx-text-fill: white;");
             fileMenu2.setStyle("-fx-text-fill: white;");
             fileMenu3.setStyle("-fx-text-fill: white;");
             fileMenu4.setStyle("-fx-text-fill: white;");
                 menuBar.setPrefWidth(50);
                 menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                 for(int i=0; i<Game.zombies.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                  fileMenu.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero.setTarget(Game.zombies.get(x));
                  System.out.println(currentHero.getTarget());
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                  fileMenu3.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero = Game.heroes.get(x);
                  
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                  fileMenu2.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero.setTarget(Game.heroes.get(x));
                  System.out.println(currentHero.getTarget());
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
         			 if(Game.heroes.get(i) instanceof Fighter) {
      				  type = "Fighter";

      			 }
      			 else if(Game.heroes.get(i) instanceof Medic) {
      				 type = "Medic";

      			 }
      			 else {
      				type = "Explorer";
      			 }
         			 
         			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
         			 fileMenu4.getItems().add(openMenuItem);
      	            

      			 	
      		 }	
                 
                
              
                 menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                 gameLayout.getChildren().add(menuBar);
                
                
                
                
                 if(Game.checkWin()){
                 	Alert win = new Alert(Alert.AlertType.INFORMATION);
 		             win.setTitle("All done!");
 		             win.setHeaderText("Close game");
 		             win.setContentText("This is an alert.");
 		             win.showAndWait().ifPresent(response -> {
 		                 if (response == ButtonType.OK) {
 		                     primaryStage.close();
 		                 }
 		             });
 		             win.setOnCloseRequest(close -> {
 		                 // Change the scene when the alert is closed
 		                 

 		                 primaryStage.close();
 		             });
        
                 }
                 if(Game.checkGameOver()){
                 	Alert lose = new Alert(Alert.AlertType.INFORMATION);
 		             lose.setTitle("You lost");
 		             lose.setHeaderText("Close game");
 		             lose.setContentText("This is an alert.");
 		             lose.showAndWait().ifPresent(response -> {
 		                 if (response == ButtonType.OK) {
 		                     primaryStage.close();
 		                 }
 		             });
 		             lose.setOnCloseRequest(close -> {
 		                 // Change the scene when the alert is closed
 		                 

 		                 primaryStage.close();
 		             });
                 }
                

                
                 VBox buttonsBox = new VBox();              
                 buttonsBox.getChildren().addAll(menuBar,up,down,left,right,attack,cure,useSpecial, endTurn);
                 
                 
                 
                 
                 gameLayout.getChildren().add(buttonsBox);
                 buttonsBox.setAlignment(Pos.TOP_LEFT);
                
                
                
                
                
                
                
                
                
                
                
                


                up.setOnMouseClicked(new EventHandler<Event>() {  
     public void handle(Event event) {
     try {
     col = (int) currentHero.getLocation().getY();
             xloc = (int) (15 -1 - currentHero.getLocation().getX());
             if(Game.map[((int)currentHero.getLocation().getX()) + 1][(int) currentHero.getLocation().getY()]instanceof TrapCell) {
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
     alert.setTitle("Warning");
     alert.setContentText("You have entered a trap cell!");
     alert.showAndWait();
             }
     currentHero.move(Direction.UP);
     for(int row=0;row<GRID_SIZE;row++){
         int rowMap=14-row;
         	for(int col1 =0;col1<GRID_SIZE;col1++){
        
       
        
                         if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                         Rectangle square= createSquare();
             gridPane.add(square,col1,row);
                         ImageView jImageView = new ImageView(joel);
     jImageView.setFitWidth(50);  
     jImageView.setFitHeight(50);
         gridPane.add(jImageView, col1, row);

         }
                         else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
         Rectangle square= createSquare();
             gridPane.add(square,col1,row);
         ImageView vaccineIV = new ImageView(vaccine);
         vaccineIV.setFitWidth(50);  
                     vaccineIV.setFitHeight(50);
         gridPane.add(vaccineIV, col1, row);
         }
                         else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
         Rectangle square= createSquare();
             gridPane.add(square,col1,row);
         ImageView supplyIV = new ImageView(supply);
         supplyIV.setFitWidth(50);  
                     supplyIV.setFitHeight(50);
         gridPane.add(supplyIV, col1, row);
         }
                         else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
        
                         Rectangle square= createSquare();
         Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                text.setFont(new Font(10));
                l1.setTextFill(Color.BLACK);
                          
         gridPane.add(square, col1, row);
                    gridPane.add(text, col1, row);
                    
        
         }
                         else {
             Rectangle square= createSquare();
             gridPane.add(square,col1,row);
             }
         }
        
         }
     Rectangle rectangle = new Rectangle(160, 150, Color.DARKGRAY);
     Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Medic" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                 text.setFont(Font.font("Arial", 14));
                 text.setFill(Color.BLACK);
             gameLayout.setAlignment(Pos.TOP_RIGHT);
                rectangle.setTranslateY(-10);
             double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                text.relocate(textX, textY);
            gameLayout.getChildren().add(rectangle);
             gameLayout.getChildren().add(text);
             
             
             

      	
 		 	

             
             menuBar= new MenuBar();
             fileMenu= new Menu("Select Zombie");
             fileMenu2 = new Menu ("Select HeroTarget");
         fileMenu3 = new Menu ("Pick a Hero");
        fileMenu4 = new Menu ("View Heroes Details");
         fileMenu.setStyle("-fx-text-fill: white;");
         fileMenu2.setStyle("-fx-text-fill: white;");
         fileMenu3.setStyle("-fx-text-fill: white;");
         fileMenu4.setStyle("-fx-text-fill: white;");
             menuBar.setPrefWidth(50);
             menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
             for(int i=0; i<Game.zombies.size();i++){
              MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
              fileMenu.getItems().add(openMenuItem);
              int x=i;
              openMenuItem.setOnAction(event2->{
              currentHero.setTarget(Game.zombies.get(x));
              System.out.println(currentHero.getTarget());
              });
             }
             for(int i=0; i<Game.heroes.size();i++){
              MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
              fileMenu3.getItems().add(openMenuItem);
              int x=i;
              openMenuItem.setOnAction(event2->{
              currentHero = Game.heroes.get(x);
              
              });
             }
             for(int i=0; i<Game.heroes.size();i++){
              MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
              fileMenu2.getItems().add(openMenuItem);
              int x=i;
              openMenuItem.setOnAction(event2->{
              currentHero.setTarget(Game.heroes.get(x));
              System.out.println(currentHero.getTarget());
              });
             }
             for(int i=0; i<Game.heroes.size();i++){
     			 if(Game.heroes.get(i) instanceof Fighter) {
  				  type = "Fighter";

  			 }
  			 else if(Game.heroes.get(i) instanceof Medic) {
  				 type = "Medic";

  			 }
  			 else {
  				type = "Explorer";
  			 }
     			 
     			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
     			 fileMenu4.getItems().add(openMenuItem);
  	            

  			 	
  		 }	
             
            
          
             menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
             gameLayout.getChildren().add(menuBar);

                
                


                 if(Game.checkWin()){
                 	Alert win = new Alert(Alert.AlertType.INFORMATION);
 		             win.setTitle("All done!");
 		             win.setHeaderText("Close game");
 		             win.setContentText("This is an alert.");
 		             win.showAndWait().ifPresent(response -> {
 		                 if (response == ButtonType.OK) {
 		                     primaryStage.close();
 		                 }
 		             });
 		             win.setOnCloseRequest(close -> {
 		                 // Change the scene when the alert is closed
 		                 

 		                 primaryStage.close();
 		             });
        
                 }
                 if(Game.checkGameOver()){
                 	Alert lose = new Alert(Alert.AlertType.INFORMATION);
 		             lose.setTitle("You lost");
 		             lose.setHeaderText("Close game");
 		             lose.setContentText("This is an alert.");
 		             lose.showAndWait().ifPresent(response -> {
 		                 if (response == ButtonType.OK) {
 		                     primaryStage.close();
 		                 }
 		             });
 		             lose.setOnCloseRequest(close -> {
 		                 // Change the scene when the alert is closed
 		                 

 		                 primaryStage.close();
 		             });
                 }
                 
                
                           

     }
     catch (NotEnoughActionsException e) {
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
     alert.setTitle("Insufficient Actions");
     alert.setContentText(e.getMessage());
     alert.showAndWait();
     }

     catch (MovementException e) {
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
     alert.setTitle("Invalid Movement");
     
     alert.setContentText(e.getMessage());
     alert.showAndWait();
     }
     }
     
                });
                down.setOnMouseClicked(new EventHandler<Event>() {
              
         @Override
         public void handle(Event event) {
         try {
         col = (int) currentHero.getLocation().getY();
                 xloc = (int) (15 -1 - currentHero.getLocation().getX());
                 if(Game.map[((int)currentHero.getLocation().getX()) - 1][(int) currentHero.getLocation().getY()]instanceof TrapCell) {
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
     alert.setTitle("Warning");
     alert.setContentText("You have entered a trap cell!");
     alert.showAndWait();
                 }
                
                
                 currentHero.move(Direction.DOWN);
                 for(int row=0;row<GRID_SIZE;row++){
                     int rowMap=14-row;
                     	for(int col1 =0;col1<GRID_SIZE;col1++){
                    
                   
                    
                                     if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                                     Rectangle square= createSquare();
                         gridPane.add(square,col1,row);
                                     ImageView jImageView = new ImageView(joel);
                 jImageView.setFitWidth(50);  
                 jImageView.setFitHeight(50);
                     gridPane.add(jImageView, col1, row);

                     }
                                     else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
                     Rectangle square= createSquare();
                         gridPane.add(square,col1,row);
                     ImageView vaccineIV = new ImageView(vaccine);
                     vaccineIV.setFitWidth(50);  
                                 vaccineIV.setFitHeight(50);
                     gridPane.add(vaccineIV, col1, row);
                     }
                                     else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
                     Rectangle square= createSquare();
                         gridPane.add(square,col1,row);
                     ImageView supplyIV = new ImageView(supply);
                     supplyIV.setFitWidth(50);  
                                 supplyIV.setFitHeight(50);
                     gridPane.add(supplyIV, col1, row);
                     }
                                     else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
                    
                                     Rectangle square= createSquare();
                     Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                            text.setFont(new Font(10));
                            l1.setTextFill(Color.BLACK);
                                      
                     gridPane.add(square, col1, row);
                                gridPane.add(text, col1, row);
                                
                    
                     }
                                     else {
                         Rectangle square= createSquare();
                         gridPane.add(square,col1,row);
                         }
                     }
                    
                     }
         Rectangle rectangle = new Rectangle(160, 150, Color.DARKGRAY);
         Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Medic" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
         //Text text = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                      text.setFont(Font.font("Arial", 14));
                      text.setFill(Color.BLACK);
                   gameLayout.setAlignment(Pos.TOP_RIGHT);
                      rectangle.setTranslateY(-10);
                   double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                      double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                      text.relocate(textX, textY);
                  gameLayout.getChildren().add(rectangle);
                   gameLayout.getChildren().add(text);
                   
                                     
                   
                   menuBar= new MenuBar();
                   fileMenu= new Menu("Select Zombie");
                   fileMenu2 = new Menu ("Select HeroTarget");
               fileMenu3 = new Menu ("Pick a Hero");
              fileMenu4 = new Menu ("View Heroes Details");
               fileMenu.setStyle("-fx-text-fill: white;");
               fileMenu2.setStyle("-fx-text-fill: white;");
               fileMenu3.setStyle("-fx-text-fill: white;");
               fileMenu4.setStyle("-fx-text-fill: white;");
                   menuBar.setPrefWidth(50);
                   menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                   for(int i=0; i<Game.zombies.size();i++){
                    MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                    fileMenu.getItems().add(openMenuItem);
                    int x=i;
                    openMenuItem.setOnAction(event2->{
                    currentHero.setTarget(Game.zombies.get(x));
                    System.out.println(currentHero.getTarget());
                    });
                   }
                   for(int i=0; i<Game.heroes.size();i++){
                    MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                    fileMenu3.getItems().add(openMenuItem);
                    int x=i;
                    openMenuItem.setOnAction(event2->{
                    currentHero = Game.heroes.get(x);
                    
                    });
                   }
                   for(int i=0; i<Game.heroes.size();i++){
                    MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                    fileMenu2.getItems().add(openMenuItem);
                    int x=i;
                    openMenuItem.setOnAction(event2->{
                    currentHero.setTarget(Game.heroes.get(x));
                    System.out.println(currentHero.getTarget());
                    });
                   }
                   for(int i=0; i<Game.heroes.size();i++){
           			 if(Game.heroes.get(i) instanceof Fighter) {
        				  type = "Fighter";

        			 }
        			 else if(Game.heroes.get(i) instanceof Medic) {
        				 type = "Medic";

        			 }
        			 else {
        				type = "Explorer";
        			 }
           			 
           			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
           			 fileMenu4.getItems().add(openMenuItem);
        	            

        			 	
        		 }	
                   
                  
                
                   menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                   gameLayout.getChildren().add(menuBar);
                    
                   if(Game.checkWin()){
                     	Alert win = new Alert(Alert.AlertType.INFORMATION);
     		             win.setTitle("All done!");
     		             win.setHeaderText("Close game");
     		             win.setContentText("This is an alert.");
     		             win.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             win.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
            
                     }
                     if(Game.checkGameOver()){
                     	Alert lose = new Alert(Alert.AlertType.INFORMATION);
     		             lose.setTitle("You lost");
     		             lose.setHeaderText("Close game");
     		             lose.setContentText("This is an alert.");
     		             lose.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             lose.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
                     }
                     
                    
                      
                
         } catch (NotEnoughActionsException e) {
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
     alert.setTitle("Insufficient Actions");
     alert.setContentText(e.getMessage());
     alert.showAndWait();
     }

     catch (MovementException e) {
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
     alert.setTitle("Invalid Movement");
     alert.setContentText(e.getMessage());
     alert.showAndWait();

     }
     }
                  
                  
             });

                left.setOnMouseClicked(new EventHandler<Event>() {
                
           @Override
           public void handle(Event event) {
           try {
           col = (int) currentHero.getLocation().getY();
                   xloc = (int) (15 -1 - currentHero.getLocation().getX());
                  
                   if(Game.map[((int)currentHero.getLocation().getX())][(int) currentHero.getLocation().getY() - 1]instanceof TrapCell) {
                   Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Warning");
         alert.setContentText("You have entered a trap cell!");
         alert.showAndWait();
                   }
                  
                  
                   currentHero.move(Direction.LEFT);
                   for(int row=0;row<GRID_SIZE;row++){
                       int rowMap=14-row;
                       	for(int col1 =0;col1<GRID_SIZE;col1++){
                      
                     
                      
                                       if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                                       Rectangle square= createSquare();
                           gridPane.add(square,col1,row);
                                       ImageView jImageView = new ImageView(joel);
                   jImageView.setFitWidth(50);  
                   jImageView.setFitHeight(50);
                       gridPane.add(jImageView, col1, row);

                       }
                                       else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
                       Rectangle square= createSquare();
                           gridPane.add(square,col1,row);
                       ImageView vaccineIV = new ImageView(vaccine);
                       vaccineIV.setFitWidth(50);  
                                   vaccineIV.setFitHeight(50);
                       gridPane.add(vaccineIV, col1, row);
                       }
                                       else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
                       Rectangle square= createSquare();
                           gridPane.add(square,col1,row);
                       ImageView supplyIV = new ImageView(supply);
                       supplyIV.setFitWidth(50);  
                                   supplyIV.setFitHeight(50);
                       gridPane.add(supplyIV, col1, row);
                       }
                                       else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
                      
                                       Rectangle square= createSquare();
                       Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                              text.setFont(new Font(10));
                              l1.setTextFill(Color.BLACK);
                                        
                       gridPane.add(square, col1, row);
                                  gridPane.add(text, col1, row);
                                  
                      
                       }
                                       else {
                           Rectangle square= createSquare();
                           gridPane.add(square,col1,row);
                           }
                       }
                      
                       }
           Rectangle rectangle = new Rectangle(160, 150, Color.DARKGRAY);
           Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Medic" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                   //Text text = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                      text.setFont(Font.font("Arial", 14));
                      text.setFill(Color.BLACK);
                   gameLayout.setAlignment(Pos.TOP_RIGHT);
                      rectangle.setTranslateY(-10);
                   double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                      double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                      text.relocate(textX, textY);
                  gameLayout.getChildren().add(rectangle);
                   gameLayout.getChildren().add(text);
                   
                   
          
                   menuBar= new MenuBar();
                   fileMenu= new Menu("Select Zombie");
                   fileMenu2 = new Menu ("Select HeroTarget");
               fileMenu3 = new Menu ("Pick a Hero");
              fileMenu4 = new Menu ("View Heroes Details");
               fileMenu.setStyle("-fx-text-fill: white;");
               fileMenu2.setStyle("-fx-text-fill: white;");
               fileMenu3.setStyle("-fx-text-fill: white;");
               fileMenu4.setStyle("-fx-text-fill: white;");
                   menuBar.setPrefWidth(50);
                   menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                   for(int i=0; i<Game.zombies.size();i++){
                    MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                    fileMenu.getItems().add(openMenuItem);
                    int x=i;
                    openMenuItem.setOnAction(event2->{
                    currentHero.setTarget(Game.zombies.get(x));
                    System.out.println(currentHero.getTarget());
                    });
                   }
                   for(int i=0; i<Game.heroes.size();i++){
                    MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                    fileMenu3.getItems().add(openMenuItem);
                    int x=i;
                    openMenuItem.setOnAction(event2->{
                    currentHero = Game.heroes.get(x);
                    
                    });
                   }
                   for(int i=0; i<Game.heroes.size();i++){
                    MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                    fileMenu2.getItems().add(openMenuItem);
                    int x=i;
                    openMenuItem.setOnAction(event2->{
                    currentHero.setTarget(Game.heroes.get(x));
                    System.out.println(currentHero.getTarget());
                    });
                   }
                   for(int i=0; i<Game.heroes.size();i++){
           			 if(Game.heroes.get(i) instanceof Fighter) {
        				  type = "Fighter";

        			 }
        			 else if(Game.heroes.get(i) instanceof Medic) {
        				 type = "Medic";

        			 }
        			 else {
        				type = "Explorer";
        			 }
           			 
           			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
           			 fileMenu4.getItems().add(openMenuItem);
        	            

        			 	
        		 }	
                   
                  
                
                   menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                   gameLayout.getChildren().add(menuBar);
                       
                       if(Game.checkWin()){
                       	Alert win = new Alert(Alert.AlertType.INFORMATION);
       		             win.setTitle("All done!");
       		             win.setHeaderText("Close game");
       		             win.setContentText("This is an alert.");
       		             win.showAndWait().ifPresent(response -> {
       		                 if (response == ButtonType.OK) {
       		                     primaryStage.close();
       		                 }
       		             });
       		             win.setOnCloseRequest(close -> {
       		                 // Change the scene when the alert is closed
       		                 

       		                 primaryStage.close();
       		             });
              
                       }
                       if(Game.checkGameOver()){
                       	Alert lose = new Alert(Alert.AlertType.INFORMATION);
       		             lose.setTitle("You lost");
       		             lose.setHeaderText("Close game");
       		             lose.setContentText("This is an alert.");
       		             lose.showAndWait().ifPresent(response -> {
       		                 if (response == ButtonType.OK) {
       		                     primaryStage.close();
       		                 }
       		             });
       		             lose.setOnCloseRequest(close -> {
       		                 // Change the scene when the alert is closed
       		                 

       		                 primaryStage.close();
       		             });
                       }
                      
                  
           } catch (NotEnoughActionsException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Insufficient Actions");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         }

         catch (MovementException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Invalid Movement");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
        
         }
         }
                    });
                right.setOnMouseClicked(new EventHandler<Event>() {
                
           @Override
           public void handle(Event event) {
           try {
           col = (int) currentHero.getLocation().getY();
                   xloc = (int) (15 -1 - currentHero.getLocation().getX());
                     if(Game.map[((int)currentHero.getLocation().getX())][(int) currentHero.getLocation().getY() + 1]instanceof TrapCell) {
                     Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Warning");
         alert.setContentText("You have entered a trap cell");
         alert.showAndWait();
                     }

           currentHero.move(Direction.RIGHT);
           for(int row=0;row<GRID_SIZE;row++){
               int rowMap=14-row;
               	for(int col1 =0;col1<GRID_SIZE;col1++){
              
             
              
                               if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                               Rectangle square= createSquare();
                   gridPane.add(square,col1,row);
                               ImageView jImageView = new ImageView(joel);
           jImageView.setFitWidth(50);  
           jImageView.setFitHeight(50);
               gridPane.add(jImageView, col1, row);

               }
                               else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
               Rectangle square= createSquare();
                   gridPane.add(square,col1,row);
               ImageView vaccineIV = new ImageView(vaccine);
               vaccineIV.setFitWidth(50);  
                           vaccineIV.setFitHeight(50);
               gridPane.add(vaccineIV, col1, row);
               }
                               else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
               Rectangle square= createSquare();
                   gridPane.add(square,col1,row);
               ImageView supplyIV = new ImageView(supply);
               supplyIV.setFitWidth(50);  
                           supplyIV.setFitHeight(50);
               gridPane.add(supplyIV, col1, row);
               }
                               else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
              
                               Rectangle square= createSquare();
               Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                      text.setFont(new Font(10));
                      l1.setTextFill(Color.BLACK);
                                
               gridPane.add(square, col1, row);
                          gridPane.add(text, col1, row);
                          
              
               }
                               else {
                   Rectangle square= createSquare();
                   gridPane.add(square,col1,row);
                   }
               }
              
               }
          
           Rectangle rectangle = new Rectangle(160, 150, Color.DARKGRAY);
           Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Medic" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                 //  Text text = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                  text.setFont(Font.font("Arial", 14));
                  text.setFill(Color.BLACK);
               gameLayout.setAlignment(Pos.TOP_RIGHT);
                  rectangle.setTranslateY(-10);
               double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                  double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                  text.relocate(textX, textY);
              gameLayout.getChildren().add(rectangle);
               gameLayout.getChildren().add(text);
               
                          
              
               menuBar= new MenuBar();
               fileMenu= new Menu("Select Zombie");
               fileMenu2 = new Menu ("Select HeroTarget");
           fileMenu3 = new Menu ("Pick a Hero");
          fileMenu4 = new Menu ("View Heroes Details");
           fileMenu.setStyle("-fx-text-fill: white;");
           fileMenu2.setStyle("-fx-text-fill: white;");
           fileMenu3.setStyle("-fx-text-fill: white;");
           fileMenu4.setStyle("-fx-text-fill: white;");
               menuBar.setPrefWidth(50);
               menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
               for(int i=0; i<Game.zombies.size();i++){
                MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                fileMenu.getItems().add(openMenuItem);
                int x=i;
                openMenuItem.setOnAction(event2->{
                currentHero.setTarget(Game.zombies.get(x));
                System.out.println(currentHero.getTarget());
                });
               }
               for(int i=0; i<Game.heroes.size();i++){
                MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                fileMenu3.getItems().add(openMenuItem);
                int x=i;
                openMenuItem.setOnAction(event2->{
                currentHero = Game.heroes.get(x);
                
                });
               }
               for(int i=0; i<Game.heroes.size();i++){
                MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                fileMenu2.getItems().add(openMenuItem);
                int x=i;
                openMenuItem.setOnAction(event2->{
                currentHero.setTarget(Game.heroes.get(x));
                System.out.println(currentHero.getTarget());
                });
               }
               for(int i=0; i<Game.heroes.size();i++){
       			 if(Game.heroes.get(i) instanceof Fighter) {
    				  type = "Fighter";

    			 }
    			 else if(Game.heroes.get(i) instanceof Medic) {
    				 type = "Medic";

    			 }
    			 else {
    				type = "Explorer";
    			 }
       			 
       			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
       			 fileMenu4.getItems().add(openMenuItem);
    	            

    			 	
    		 }	
               
              
            
               menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
               gameLayout.getChildren().add(menuBar);
              
                   if(Game.checkWin()){
                   	Alert win = new Alert(Alert.AlertType.INFORMATION);
   		             win.setTitle("All done!");
   		             win.setHeaderText("Close game");
   		             win.setContentText("This is an alert.");
   		             win.showAndWait().ifPresent(response -> {
   		                 if (response == ButtonType.OK) {
   		                     primaryStage.close();
   		                 }
   		             });
   		             win.setOnCloseRequest(close -> {
   		                 // Change the scene when the alert is closed
   		                 

   		                 primaryStage.close();
   		             });
          
                   }
                   if(Game.checkGameOver()){
                   	Alert lose = new Alert(Alert.AlertType.INFORMATION);
   		             lose.setTitle("You lost");
   		             lose.setHeaderText("Close game");
   		             lose.setContentText("This is an alert.");
   		             lose.showAndWait().ifPresent(response -> {
   		                 if (response == ButtonType.OK) {
   		                     primaryStage.close();
   		                 }
   		             });
   		             lose.setOnCloseRequest(close -> {
   		                 // Change the scene when the alert is closed
   		                 

   		                 primaryStage.close();
   		             });
                   }
                  
                  
           } catch (NotEnoughActionsException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Insufficient Actions");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         }

           catch (MovementException e) {
         	    Alert alert = new Alert(Alert.AlertType.INFORMATION);
         	    alert.setTitle("Invalid Movement");
         	    
         	    alert.setContentText(e.getMessage());
         	    alert.showAndWait();
         	    }
         	    }
         
                    });
               
                
                
               
                
                
                attack.setOnAction(event2 -> {
             	   
                 try {

                    

                     currentHero.attack();
                  

                     for(int row=0;row<GRID_SIZE;row++){
                         int rowMap=14-row;
                         	for(int col1 =0;col1<GRID_SIZE;col1++){
                        
                       
                        
                                         if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                                         Rectangle square= createSquare();
                             gridPane.add(square,col1,row);
                                         ImageView jImageView = new ImageView(joel);
                     jImageView.setFitWidth(50);  
                     jImageView.setFitHeight(50);
                         gridPane.add(jImageView, col1, row);

                         }
                                         else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
                         Rectangle square= createSquare();
                             gridPane.add(square,col1,row);
                         ImageView vaccineIV = new ImageView(vaccine);
                         vaccineIV.setFitWidth(50);  
                                     vaccineIV.setFitHeight(50);
                         gridPane.add(vaccineIV, col1, row);
                         }
                                         else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
                         Rectangle square= createSquare();
                             gridPane.add(square,col1,row);
                         ImageView supplyIV = new ImageView(supply);
                         supplyIV.setFitWidth(50);  
                                     supplyIV.setFitHeight(50);
                         gridPane.add(supplyIV, col1, row);
                         }
                                         else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
                        
                                         Rectangle square= createSquare();
                         Label text2 = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                                text2.setFont(new Font(10));
                                l1.setTextFill(Color.BLACK);
                                          
                         gridPane.add(square, col1, row);
                                    gridPane.add(text2, col1, row);
                                    
                        
                         }
                                         else {
                             Rectangle square= createSquare();
                             gridPane.add(square,col1,row);
                             }
                         }
                        
                         }

               
                 
                Rectangle rectangle2 = new Rectangle(160, 150, Color.DARKGRAY);
                Text text2 = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Medic" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                // Text text2 = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                     text2.setFont(Font.font("Arial", 14));
                     text2.setFill(Color.BLACK);
                     gameLayout.setAlignment(Pos.TOP_RIGHT);

                     rectangle2.setTranslateY(-10);
                    
                
                 double textX2 = rectangle2.getX() + (rectangle2.getWidth() - text2.getLayoutBounds().getWidth()) / 2;
                     double textY2= rectangle2.getY() + (rectangle2.getHeight() + text2.getLayoutBounds().getHeight()) / 2;
                     text2.relocate(textX2, textY2);
                 gameLayout.getChildren().add(rectangle2);
                 gameLayout.getChildren().add(text2);
                 
                 
                 
                 menuBar= new MenuBar();
                 fileMenu= new Menu("Select Zombie");
                 fileMenu2 = new Menu ("Select HeroTarget");
             fileMenu3 = new Menu ("Pick a Hero");
            fileMenu4 = new Menu ("View Heroes Details");
             fileMenu.setStyle("-fx-text-fill: white;");
             fileMenu2.setStyle("-fx-text-fill: white;");
             fileMenu3.setStyle("-fx-text-fill: white;");
             fileMenu4.setStyle("-fx-text-fill: white;");
                 menuBar.setPrefWidth(50);
                 menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                 for(int i=0; i<Game.zombies.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                  fileMenu.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event3->{
                  currentHero.setTarget(Game.zombies.get(x));
                  System.out.println(currentHero.getTarget());
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                  fileMenu3.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event3->{
                  currentHero = Game.heroes.get(x);
                  
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                  fileMenu2.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event3->{
                  currentHero.setTarget(Game.heroes.get(x));
                  System.out.println(currentHero.getTarget());
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
         			 if(Game.heroes.get(i) instanceof Fighter) {
      				  type = "Fighter";

      			 }
      			 else if(Game.heroes.get(i) instanceof Medic) {
      				 type = "Medic";

      			 }
      			 else {
      				type = "Explorer";
      			 }
         			 
         			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
         			 fileMenu4.getItems().add(openMenuItem);
      	            

      			 	
      		 }	
                 
                
              
                 menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                 gameLayout.getChildren().add(menuBar);
                 
                
                 if(Game.checkWin()){
                 	Alert win = new Alert(Alert.AlertType.INFORMATION);
 		             win.setTitle("All done!");
 		             win.setHeaderText("Close game");
 		             win.setContentText("This is an alert.");
 		             win.showAndWait().ifPresent(response -> {
 		                 if (response == ButtonType.OK) {
 		                     primaryStage.close();
 		                 }
 		             });
 		             win.setOnCloseRequest(close -> {
 		                 // Change the scene when the alert is closed
 		                 

 		                 primaryStage.close();
 		             });
        
                 }
                 if(Game.checkGameOver()){
                 	Alert lose = new Alert(Alert.AlertType.INFORMATION);
 		             lose.setTitle("You lost");
 		             lose.setHeaderText("Close game");
 		             lose.setContentText("This is an alert.");
 		             lose.showAndWait().ifPresent(response -> {
 		                 if (response == ButtonType.OK) {
 		                     primaryStage.close();
 		                 }
 		             });
 		             lose.setOnCloseRequest(close -> {
 		                 // Change the scene when the alert is closed
 		                 

 		                 primaryStage.close();
 		             });
                 }
                 
        
         } catch (NotEnoughActionsException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Insufficient Actions");
         alert.setContentText(e.getMessage());
     alert.showAndWait();

         } catch (InvalidTargetException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Invalid Target");
         alert.setContentText(e.getMessage());
     alert.showAndWait();

         }
                });
                
                
                
                cure.setOnMouseClicked(new EventHandler< Event >(){

     @Override
     public void handle(Event arg0) {
     try {
     currentHero.cure();
     for(int row=0;row<GRID_SIZE;row++){
         int rowMap=14-row;
         	for(int col1 =0;col1<GRID_SIZE;col1++){
        
       
        
                         if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                         Rectangle square= createSquare();
             gridPane.add(square,col1,row);
                         ImageView jImageView = new ImageView(joel);
     jImageView.setFitWidth(50);  
     jImageView.setFitHeight(50);
         gridPane.add(jImageView, col1, row);

         }
                         else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
         Rectangle square= createSquare();
             gridPane.add(square,col1,row);
         ImageView vaccineIV = new ImageView(vaccine);
         vaccineIV.setFitWidth(50);  
                     vaccineIV.setFitHeight(50);
         gridPane.add(vaccineIV, col1, row);
         }
                         else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
         Rectangle square= createSquare();
             gridPane.add(square,col1,row);
         ImageView supplyIV = new ImageView(supply);
         supplyIV.setFitWidth(50);  
                     supplyIV.setFitHeight(50);
         gridPane.add(supplyIV, col1, row);
         }
                         else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
        
                         Rectangle square= createSquare();
         Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                text.setFont(new Font(10));
                l1.setTextFill(Color.BLACK);
                          
         gridPane.add(square, col1, row);
                    gridPane.add(text, col1, row);
                    
        
         }
                         else {
             Rectangle square= createSquare();
             gridPane.add(square,col1,row);
             }
         }
        
         }
     
     
     Rectangle rectangle = new Rectangle(160, 120, Color.DARKGRAY);
     Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Medic" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
              // Text text = new Text("\n" + Game.heroes.get(Game.heroes.size()-1).getName() + "\nCurrent Hp: " + Game.heroes.get(Game.heroes.size()-1).getCurrentHp() + "\nActions available: " +  Game.heroes.get(Game.heroes.size()-1).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(Game.heroes.size()-1).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                text.setFont(Font.font("Arial", 14));
                text.setFill(Color.BLACK);
             gameLayout.setAlignment(Pos.TOP_RIGHT);
                rectangle.setTranslateY(-10);
             double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                text.relocate(textX, textY);
            gameLayout.getChildren().add(rectangle);
             gameLayout.getChildren().add(text);
             
             
             
             menuBar= new MenuBar();
             fileMenu= new Menu("Select Zombie");
             fileMenu2 = new Menu ("Select HeroTarget");
         fileMenu3 = new Menu ("Pick a Hero");
        fileMenu4 = new Menu ("View Heroes Details");
         fileMenu.setStyle("-fx-text-fill: white;");
         fileMenu2.setStyle("-fx-text-fill: white;");
         fileMenu3.setStyle("-fx-text-fill: white;");
         fileMenu4.setStyle("-fx-text-fill: white;");
             menuBar.setPrefWidth(50);
             menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
             for(int i=0; i<Game.zombies.size();i++){
              MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
              fileMenu.getItems().add(openMenuItem);
              int x=i;
              openMenuItem.setOnAction(event2->{
              currentHero.setTarget(Game.zombies.get(x));
              System.out.println(currentHero.getTarget());
              });
             }
             for(int i=0; i<Game.heroes.size();i++){
              MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
              fileMenu3.getItems().add(openMenuItem);
              int x=i;
              openMenuItem.setOnAction(event2->{
              currentHero = Game.heroes.get(x);
              
              });
             }
             for(int i=0; i<Game.heroes.size();i++){
              MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
              fileMenu2.getItems().add(openMenuItem);
              int x=i;
              openMenuItem.setOnAction(event2->{
              currentHero.setTarget(Game.heroes.get(x));
              System.out.println(currentHero.getTarget());
              });
             }
             for(int i=0; i<Game.heroes.size();i++){
     			 if(Game.heroes.get(i) instanceof Fighter) {
  				  type = "Fighter";

  			 }
  			 else if(Game.heroes.get(i) instanceof Medic) {
  				 type = "Medic";

  			 }
  			 else {
  				type = "Explorer";
  			 }
     			 
     			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
     			 fileMenu4.getItems().add(openMenuItem);
  	            

  			 	
  		 }	
             
            
          
             menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
             gameLayout.getChildren().add(menuBar);
                
                
            
                 if(Game.checkWin()){
                 	Alert win = new Alert(Alert.AlertType.INFORMATION);
 		             win.setTitle("All done!");
 		             win.setHeaderText("Close game");
 		             win.setContentText("This is an alert.");
 		             win.showAndWait().ifPresent(response -> {
 		                 if (response == ButtonType.OK) {
 		                     primaryStage.close();
 		                 }
 		             });
 		             win.setOnCloseRequest(close -> {
 		                 // Change the scene when the alert is closed
 		                 

 		                 primaryStage.close();
 		             });
        
                 }
                 if(Game.checkGameOver()){
                 	Alert lose = new Alert(Alert.AlertType.INFORMATION);
 		             lose.setTitle("You lost");
 		             lose.setHeaderText("Close game");
 		             lose.setContentText("This is an alert.");
 		             lose.showAndWait().ifPresent(response -> {
 		                 if (response == ButtonType.OK) {
 		                     primaryStage.close();
 		                 }
 		             });
 		             lose.setOnCloseRequest(close -> {
 		                 // Change the scene when the alert is closed
 		                 

 		                 primaryStage.close();
 		             });
                 }
                 
                           
     } catch (NoAvailableResourcesException e) {
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
     alert.setTitle("Insufficient resources");
     alert.setContentText(e.getMessage());
     alert.showAndWait();
     } catch (InvalidTargetException e) {
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
     alert.setTitle("Invalid Target");
     alert.setContentText(e.getMessage());
     alert.showAndWait();
     } catch (NotEnoughActionsException e) {
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
     alert.setTitle("Insufficient Actions");
     alert.setContentText(e.getMessage());
     alert.showAndWait();
     }
     }
              
                });
                
                
                
                endTurn.setOnMouseClicked(new EventHandler<Event>(){

     @Override
     public void handle(Event event3) {
     try {
     Game.endTurn();

     if(Game.checkWin()){
     	Alert win = new Alert(Alert.AlertType.INFORMATION);
          win.setTitle("All done!");
          win.setHeaderText("Close game");
          win.setContentText("This is an alert.");
          win.showAndWait().ifPresent(response -> {
              if (response == ButtonType.OK) {
                  primaryStage.close();
              }
          });
          win.setOnCloseRequest(close -> {
              // Change the scene when the alert is closed
              

              primaryStage.close();
          });

     }
     if(Game.checkGameOver()){
     	Alert lose = new Alert(Alert.AlertType.INFORMATION);
          lose.setTitle("You lost");
          lose.setHeaderText("Close game");
          lose.setContentText("This is an alert.");
          lose.showAndWait().ifPresent(response -> {
              if (response == ButtonType.OK) {
                  primaryStage.close();
              }
          });
          lose.setOnCloseRequest(close -> {
              // Change the scene when the alert is closed
              

              primaryStage.close();
          });
     }

     for(int row=0;row<GRID_SIZE;row++){
         int rowMap=14-row;
         	for(int col1 =0;col1<GRID_SIZE;col1++){
        
       
        
                         if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                         Rectangle square= createSquare();
             gridPane.add(square,col1,row);
                         ImageView jImageView = new ImageView(joel);
     jImageView.setFitWidth(50);  
     jImageView.setFitHeight(50);
         gridPane.add(jImageView, col1, row);

         }
                         else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
         Rectangle square= createSquare();
             gridPane.add(square,col1,row);
         ImageView vaccineIV = new ImageView(vaccine);
         vaccineIV.setFitWidth(50);  
                     vaccineIV.setFitHeight(50);
         gridPane.add(vaccineIV, col1, row);
         }
                         else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
         Rectangle square= createSquare();
             gridPane.add(square,col1,row);
         ImageView supplyIV = new ImageView(supply);
         supplyIV.setFitWidth(50);  
                     supplyIV.setFitHeight(50);
         gridPane.add(supplyIV, col1, row);
         }
                         else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
        
                         Rectangle square= createSquare();
         Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                text.setFont(new Font(10));
                l1.setTextFill(Color.BLACK);
                          
         gridPane.add(square, col1, row);
                    gridPane.add(text, col1, row);
                    
        
         }
                         else {
             Rectangle square= createSquare();
             gridPane.add(square,col1,row);
             }
         }
        
         }
     Rectangle rectangle = new Rectangle(160, 120, Color.DARKGRAY);
     Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Medic" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
               //Text text = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                text.setFont(Font.font("Arial", 14));
                text.setFill(Color.BLACK);
             gameLayout.setAlignment(Pos.TOP_RIGHT);
                rectangle.setTranslateY(-10);
             double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                text.relocate(textX, textY);
            gameLayout.getChildren().add(rectangle);
             gameLayout.getChildren().add(text);
             
             
             
             menuBar= new MenuBar();
             fileMenu= new Menu("Select Zombie");
             fileMenu2 = new Menu ("Select HeroTarget");
         fileMenu3 = new Menu ("Pick a Hero");
        fileMenu4 = new Menu ("View Heroes Details");
         fileMenu.setStyle("-fx-text-fill: white;");
         fileMenu2.setStyle("-fx-text-fill: white;");
         fileMenu3.setStyle("-fx-text-fill: white;");
         fileMenu4.setStyle("-fx-text-fill: white;");
             menuBar.setPrefWidth(50);
             menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
             for(int i=0; i<Game.zombies.size();i++){
              MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
              fileMenu.getItems().add(openMenuItem);
              int x=i;
              openMenuItem.setOnAction(event2->{
              currentHero.setTarget(Game.zombies.get(x));
              System.out.println(currentHero.getTarget());
              });
             }
             for(int i=0; i<Game.heroes.size();i++){
              MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
              fileMenu3.getItems().add(openMenuItem);
              int x=i;
              openMenuItem.setOnAction(event2->{
              currentHero = Game.heroes.get(x);
              
              });
             }
             for(int i=0; i<Game.heroes.size();i++){
              MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
              fileMenu2.getItems().add(openMenuItem);
              int x=i;
              openMenuItem.setOnAction(event2->{
              currentHero.setTarget(Game.heroes.get(x));
              System.out.println(currentHero.getTarget());
              });
             }
             for(int i=0; i<Game.heroes.size();i++){
     			 if(Game.heroes.get(i) instanceof Fighter) {
  				  type = "Fighter";

  			 }
  			 else if(Game.heroes.get(i) instanceof Medic) {
  				 type = "Medic";

  			 }
  			 else {
  				type = "Explorer";
  			 }
     			 
     			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
     			 fileMenu4.getItems().add(openMenuItem);
  	            

  			 	
  		 }	
             
            
          
             menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
             gameLayout.getChildren().add(menuBar);
                 
                
     } catch (NotEnoughActionsException e) {

     } catch (InvalidTargetException e) {

     }
     }
              
                });
                
                useSpecial.setOnMouseClicked(new EventHandler< Event >(){

     @Override
     public void handle(Event event) {
     try {
     currentHero.useSpecial();
     for(int row=0;row<GRID_SIZE;row++){
         int rowMap=14-row;
         	for(int col1 =0;col1<GRID_SIZE;col1++){
        
       
        
                         if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                         Rectangle square= createSquare();
             gridPane.add(square,col1,row);
                         ImageView jImageView = new ImageView(joel);
     jImageView.setFitWidth(50);  
     jImageView.setFitHeight(50);
         gridPane.add(jImageView, col1, row);

         }
                         else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
         Rectangle square= createSquare();
             gridPane.add(square,col1,row);
         ImageView vaccineIV = new ImageView(vaccine);
         vaccineIV.setFitWidth(50);  
                     vaccineIV.setFitHeight(50);
         gridPane.add(vaccineIV, col1, row);
         }
                         else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
         Rectangle square= createSquare();
             gridPane.add(square,col1,row);
         ImageView supplyIV = new ImageView(supply);
         supplyIV.setFitWidth(50);  
                     supplyIV.setFitHeight(50);
         gridPane.add(supplyIV, col1, row);
         }
                         else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
        
                         Rectangle square= createSquare();
         Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                text.setFont(new Font(10));
                l1.setTextFill(Color.BLACK);
                          
         gridPane.add(square, col1, row);
                    gridPane.add(text, col1, row);
                    
        
         }
                         else {
             Rectangle square= createSquare();
             gridPane.add(square,col1,row);
             }
         }
        
         }
     Rectangle rectangle = new Rectangle(160, 120, Color.DARKGRAY);
     Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Medic" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
              // Text text = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                text.setFont(Font.font("Arial", 14));
                text.setFill(Color.BLACK);
             gameLayout.setAlignment(Pos.TOP_RIGHT);
                rectangle.setTranslateY(-10);
             double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                text.relocate(textX, textY);
            gameLayout.getChildren().add(rectangle);
            gameLayout.getChildren().add(text);

            menuBar= new MenuBar();
            fileMenu= new Menu("Select Zombie");
            fileMenu2 = new Menu ("Select HeroTarget");
        fileMenu3 = new Menu ("Pick a Hero");
       fileMenu4 = new Menu ("View Heroes Details");
        fileMenu.setStyle("-fx-text-fill: white;");
        fileMenu2.setStyle("-fx-text-fill: white;");
        fileMenu3.setStyle("-fx-text-fill: white;");
        fileMenu4.setStyle("-fx-text-fill: white;");
            menuBar.setPrefWidth(50);
            menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
            for(int i=0; i<Game.zombies.size();i++){
             MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
             fileMenu.getItems().add(openMenuItem);
             int x=i;
             openMenuItem.setOnAction(event2->{
             currentHero.setTarget(Game.zombies.get(x));
             System.out.println(currentHero.getTarget());
             });
            }
            for(int i=0; i<Game.heroes.size();i++){
             MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
             fileMenu3.getItems().add(openMenuItem);
             int x=i;
             openMenuItem.setOnAction(event2->{
             currentHero = Game.heroes.get(x);
             
             });
            }
            for(int i=0; i<Game.heroes.size();i++){
             MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
             fileMenu2.getItems().add(openMenuItem);
             int x=i;
             openMenuItem.setOnAction(event2->{
             currentHero.setTarget(Game.heroes.get(x));
             System.out.println(currentHero.getTarget());
             });
            }
            for(int i=0; i<Game.heroes.size();i++){
    			 if(Game.heroes.get(i) instanceof Fighter) {
 				  type = "Fighter";

 			 }
 			 else if(Game.heroes.get(i) instanceof Medic) {
 				 type = "Medic";

 			 }
 			 else {
 				type = "Explorer";
 			 }
    			 
    			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
    			 fileMenu4.getItems().add(openMenuItem);
 	            

 			 	
 		 }	
            
           
         
            menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
            gameLayout.getChildren().add(menuBar);
                
                 if(Game.checkWin()){
                 	Alert win = new Alert(Alert.AlertType.INFORMATION);
 		             win.setTitle("All done!");
 		             win.setHeaderText("Close game");
 		             win.setContentText("This is an alert.");
 		             win.showAndWait().ifPresent(response -> {
 		                 if (response == ButtonType.OK) {
 		                     primaryStage.close();
 		                 }
 		             });
 		             win.setOnCloseRequest(close -> {
 		                 // Change the scene when the alert is closed
 		                 

 		                 primaryStage.close();
 		             });
        
                 }
                 if(Game.checkGameOver()){
                 	Alert lose = new Alert(Alert.AlertType.INFORMATION);
 		             lose.setTitle("You lost");
 		             lose.setHeaderText("Close game");
 		             lose.setContentText("This is an alert.");
 		             lose.showAndWait().ifPresent(response -> {
 		                 if (response == ButtonType.OK) {
 		                     primaryStage.close();
 		                 }
 		             });
 		             lose.setOnCloseRequest(close -> {
 		                 // Change the scene when the alert is closed
 		                 

 		                 primaryStage.close();
 		             });
                 }
                
      
     } catch (NoAvailableResourcesException e) {
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
     alert.setTitle("Insufficient Supply");
     alert.setContentText(e.getMessage());
     alert.showAndWait();
     } catch (InvalidTargetException e) {
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
     alert.setTitle("Invalid Target");
     alert.setContentText(e.getMessage());
     alert.showAndWait();
     }

     }});
        

             game = new Scene(gameLayout, 1470, 800);
           primaryStage.setScene(game);

            

             });
     	
        	
        	

        
        b3.setOnAction(event -> {
        	 currentHero = Game.availableHeroes.get(2);
             Game.startGame(currentHero);
            
            
             gridPane.setAlignment(Pos.CENTER);
             
             for(int row=0;row<GRID_SIZE;row++){
             int rowMap=14-row;
             	for(int col1 =0;col1<GRID_SIZE;col1++){
            
           
            
                             if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                             ImageView jImageView = new ImageView(joel);
         jImageView.setFitWidth(50);  
         jImageView.setFitHeight(50);
             gridPane.add(jImageView, col1, row);

             }
                             else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView vaccineIV = new ImageView(vaccine);
             vaccineIV.setFitWidth(50);  
                         vaccineIV.setFitHeight(50);
             gridPane.add(vaccineIV, col1, row);
             }
                             else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView supplyIV = new ImageView(supply);
             supplyIV.setFitWidth(50);  
                         supplyIV.setFitHeight(50);
             gridPane.add(supplyIV, col1, row);
             }
                             else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
            
                             Rectangle square= createSquare();
             Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                    text.setFont(new Font(10));
                    l1.setTextFill(Color.BLACK);
                              
             gridPane.add(square, col1, row);
                        gridPane.add(text, col1, row);
                        
            
             }
                             else {
                 Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                 }
             }
            
             }

                  
             gameLayout.getChildren().add(gridPane);
                
                    
                      
                      gameLayout.setStyle("-fx-background-color: #000000;");
              
                    
              
                 Rectangle rectangle = new Rectangle(160, 150, Color.DARKGRAY);
                 Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Explorer" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                      text.setFont(Font.font("Arial", 14));
                      text.setFill(Color.BLACK);
                      
                    


                   gameLayout.setAlignment(Pos.TOP_RIGHT);


                     rectangle.setTranslateY(-10);

                
                 double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                     double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                    
                     text.relocate(textX, textY);
                     
                     
                 

                 
                 gameLayout.getChildren().addAll(rectangle,text);
                 

                
                     Button up = new Button("↑");
                     Button down = new Button("↓");
                 Button left = new Button("←");
                 Button right = new Button("→");
                    
                    
                     Button attack = new Button("ATTACK");
                     Button cure = new Button("CURE");
                     Button useSpecial = new Button("USE SPECIAL");
                     Button endTurn = new Button("END TURN");
                     

                    
                    
                     menuBar= new MenuBar();
                     fileMenu= new Menu("Select Zombie");
                     fileMenu2 = new Menu ("Select HeroTarget");
                 fileMenu3 = new Menu ("Pick a Hero");
                fileMenu4 = new Menu ("View Heroes Details");
                 fileMenu.setStyle("-fx-text-fill: white;");
                 fileMenu2.setStyle("-fx-text-fill: white;");
                 fileMenu3.setStyle("-fx-text-fill: white;");
                 fileMenu4.setStyle("-fx-text-fill: white;");
                     menuBar.setPrefWidth(50);
                     menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                     for(int i=0; i<Game.zombies.size();i++){
                      MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                      fileMenu.getItems().add(openMenuItem);
                      int x=i;
                      openMenuItem.setOnAction(event2->{
                      currentHero.setTarget(Game.zombies.get(x));
                      System.out.println(currentHero.getTarget());
                      });
                     }
                     for(int i=0; i<Game.heroes.size();i++){
                      MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                      fileMenu3.getItems().add(openMenuItem);
                      int x=i;
                      openMenuItem.setOnAction(event2->{
                      currentHero = Game.heroes.get(x);
                      
                      });
                     }
                     for(int i=0; i<Game.heroes.size();i++){
                      MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                      fileMenu2.getItems().add(openMenuItem);
                      int x=i;
                      openMenuItem.setOnAction(event2->{
                      currentHero.setTarget(Game.heroes.get(x));
                      System.out.println(currentHero.getTarget());
                      });
                     }
                     for(int i=0; i<Game.heroes.size();i++){
             			 if(Game.heroes.get(i) instanceof Fighter) {
          				  type = "Fighter";

          			 }
          			 else if(Game.heroes.get(i) instanceof Medic) {
          				 type = "Medic";

          			 }
          			 else {
          				type = "Explorer";
          			 }
             			 
             			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
             			 fileMenu4.getItems().add(openMenuItem);
          	            

          			 	
          		 }	
                     
                    
                  
                     menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                     gameLayout.getChildren().add(menuBar);
                    
                    
                    
                    
                     if(Game.checkWin()){
                     	Alert win = new Alert(Alert.AlertType.INFORMATION);
     		             win.setTitle("All done!");
     		             win.setHeaderText("Close game");
     		             win.setContentText("This is an alert.");
     		             win.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             win.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
            
                     }
                     if(Game.checkGameOver()){
                     	Alert lose = new Alert(Alert.AlertType.INFORMATION);
     		             lose.setTitle("You lost");
     		             lose.setHeaderText("Close game");
     		             lose.setContentText("This is an alert.");
     		             lose.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             lose.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
                     }
                    

                    
                     VBox buttonsBox = new VBox();              
                     buttonsBox.getChildren().addAll(menuBar,up,down,left,right,attack,cure,useSpecial, endTurn);
                     
                     
                     
                     
                     gameLayout.getChildren().add(buttonsBox);
                     buttonsBox.setAlignment(Pos.TOP_LEFT);
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    


                    up.setOnMouseClicked(new EventHandler<Event>() {  
         public void handle(Event event) {
         try {
         col = (int) currentHero.getLocation().getY();
                 xloc = (int) (15 -1 - currentHero.getLocation().getX());
                 if(Game.map[((int)currentHero.getLocation().getX()) + 1][(int) currentHero.getLocation().getY()]instanceof TrapCell) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Warning");
         alert.setContentText("You have entered a trap cell!");
         alert.showAndWait();
                 }
         currentHero.move(Direction.UP);
         for(int row=0;row<GRID_SIZE;row++){
             int rowMap=14-row;
             	for(int col1 =0;col1<GRID_SIZE;col1++){
            
           
            
                             if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                             ImageView jImageView = new ImageView(joel);
         jImageView.setFitWidth(50);  
         jImageView.setFitHeight(50);
             gridPane.add(jImageView, col1, row);

             }
                             else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView vaccineIV = new ImageView(vaccine);
             vaccineIV.setFitWidth(50);  
                         vaccineIV.setFitHeight(50);
             gridPane.add(vaccineIV, col1, row);
             }
                             else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView supplyIV = new ImageView(supply);
             supplyIV.setFitWidth(50);  
                         supplyIV.setFitHeight(50);
             gridPane.add(supplyIV, col1, row);
             }
                             else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
            
                             Rectangle square= createSquare();
             Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                    text.setFont(new Font(10));
                    l1.setTextFill(Color.BLACK);
                              
             gridPane.add(square, col1, row);
                        gridPane.add(text, col1, row);
                        
            
             }
                             else {
                 Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                 }
             }
            
             }
         Rectangle rectangle = new Rectangle(160, 150, Color.DARKGRAY);
         Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Explorer" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                     text.setFont(Font.font("Arial", 14));
                     text.setFill(Color.BLACK);
                 gameLayout.setAlignment(Pos.TOP_RIGHT);
                    rectangle.setTranslateY(-10);
                 double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                    double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                    text.relocate(textX, textY);
                gameLayout.getChildren().add(rectangle);
                 gameLayout.getChildren().add(text);
                 
                 
                 

          	
     		 	

                 
                 menuBar= new MenuBar();
                 fileMenu= new Menu("Select Zombie");
                 fileMenu2 = new Menu ("Select HeroTarget");
             fileMenu3 = new Menu ("Pick a Hero");
            fileMenu4 = new Menu ("View Heroes Details");
             fileMenu.setStyle("-fx-text-fill: white;");
             fileMenu2.setStyle("-fx-text-fill: white;");
             fileMenu3.setStyle("-fx-text-fill: white;");
             fileMenu4.setStyle("-fx-text-fill: white;");
                 menuBar.setPrefWidth(50);
                 menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                 for(int i=0; i<Game.zombies.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                  fileMenu.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero.setTarget(Game.zombies.get(x));
                  System.out.println(currentHero.getTarget());
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                  fileMenu3.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero = Game.heroes.get(x);
                  
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                  fileMenu2.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero.setTarget(Game.heroes.get(x));
                  System.out.println(currentHero.getTarget());
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
         			 if(Game.heroes.get(i) instanceof Fighter) {
      				  type = "Fighter";

      			 }
      			 else if(Game.heroes.get(i) instanceof Medic) {
      				 type = "Medic";

      			 }
      			 else {
      				type = "Explorer";
      			 }
         			 
         			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
         			 fileMenu4.getItems().add(openMenuItem);
      	            

      			 	
      		 }	
                 
                
              
                 menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                 gameLayout.getChildren().add(menuBar);

                    
                    


                     if(Game.checkWin()){
                     	Alert win = new Alert(Alert.AlertType.INFORMATION);
     		             win.setTitle("All done!");
     		             win.setHeaderText("Close game");
     		             win.setContentText("This is an alert.");
     		             win.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             win.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
            
                     }
                     if(Game.checkGameOver()){
                     	Alert lose = new Alert(Alert.AlertType.INFORMATION);
     		             lose.setTitle("You lost");
     		             lose.setHeaderText("Close game");
     		             lose.setContentText("This is an alert.");
     		             lose.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             lose.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
                     }
                     
                    
                               

         }
         catch (NotEnoughActionsException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Insufficient Actions");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         }

         catch (MovementException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Invalid Movement");
         
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         }
         }
         
                    });
                    down.setOnMouseClicked(new EventHandler<Event>() {
                  
             @Override
             public void handle(Event event) {
             try {
             col = (int) currentHero.getLocation().getY();
                     xloc = (int) (15 -1 - currentHero.getLocation().getX());
                     if(Game.map[((int)currentHero.getLocation().getX()) - 1][(int) currentHero.getLocation().getY()]instanceof TrapCell) {
                     Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Warning");
         alert.setContentText("You have entered a trap cell!");
         alert.showAndWait();
                     }
                    
                    
                     currentHero.move(Direction.DOWN);
                     for(int row=0;row<GRID_SIZE;row++){
                         int rowMap=14-row;
                         	for(int col1 =0;col1<GRID_SIZE;col1++){
                        
                       
                        
                                         if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                                         Rectangle square= createSquare();
                             gridPane.add(square,col1,row);
                                         ImageView jImageView = new ImageView(joel);
                     jImageView.setFitWidth(50);  
                     jImageView.setFitHeight(50);
                         gridPane.add(jImageView, col1, row);

                         }
                                         else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
                         Rectangle square= createSquare();
                             gridPane.add(square,col1,row);
                         ImageView vaccineIV = new ImageView(vaccine);
                         vaccineIV.setFitWidth(50);  
                                     vaccineIV.setFitHeight(50);
                         gridPane.add(vaccineIV, col1, row);
                         }
                                         else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
                         Rectangle square= createSquare();
                             gridPane.add(square,col1,row);
                         ImageView supplyIV = new ImageView(supply);
                         supplyIV.setFitWidth(50);  
                                     supplyIV.setFitHeight(50);
                         gridPane.add(supplyIV, col1, row);
                         }
                                         else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
                        
                                         Rectangle square= createSquare();
                         Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                                text.setFont(new Font(10));
                                l1.setTextFill(Color.BLACK);
                                          
                         gridPane.add(square, col1, row);
                                    gridPane.add(text, col1, row);
                                    
                        
                         }
                                         else {
                             Rectangle square= createSquare();
                             gridPane.add(square,col1,row);
                             }
                         }
                        
                         }
             Rectangle rectangle = new Rectangle(160, 150, Color.DARKGRAY);
             Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Explorer" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
             //Text text = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                          text.setFont(Font.font("Arial", 14));
                          text.setFill(Color.BLACK);
                       gameLayout.setAlignment(Pos.TOP_RIGHT);
                          rectangle.setTranslateY(-10);
                       double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                          double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                          text.relocate(textX, textY);
                      gameLayout.getChildren().add(rectangle);
                       gameLayout.getChildren().add(text);
                       
                                         
                       
                       menuBar= new MenuBar();
                       fileMenu= new Menu("Select Zombie");
                       fileMenu2 = new Menu ("Select HeroTarget");
                   fileMenu3 = new Menu ("Pick a Hero");
                  fileMenu4 = new Menu ("View Heroes Details");
                   fileMenu.setStyle("-fx-text-fill: white;");
                   fileMenu2.setStyle("-fx-text-fill: white;");
                   fileMenu3.setStyle("-fx-text-fill: white;");
                   fileMenu4.setStyle("-fx-text-fill: white;");
                       menuBar.setPrefWidth(50);
                       menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                       for(int i=0; i<Game.zombies.size();i++){
                        MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                        fileMenu.getItems().add(openMenuItem);
                        int x=i;
                        openMenuItem.setOnAction(event2->{
                        currentHero.setTarget(Game.zombies.get(x));
                        System.out.println(currentHero.getTarget());
                        });
                       }
                       for(int i=0; i<Game.heroes.size();i++){
                        MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                        fileMenu3.getItems().add(openMenuItem);
                        int x=i;
                        openMenuItem.setOnAction(event2->{
                        currentHero = Game.heroes.get(x);
                        
                        });
                       }
                       for(int i=0; i<Game.heroes.size();i++){
                        MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                        fileMenu2.getItems().add(openMenuItem);
                        int x=i;
                        openMenuItem.setOnAction(event2->{
                        currentHero.setTarget(Game.heroes.get(x));
                        System.out.println(currentHero.getTarget());
                        });
                       }
                       for(int i=0; i<Game.heroes.size();i++){
               			 if(Game.heroes.get(i) instanceof Fighter) {
            				  type = "Fighter";

            			 }
            			 else if(Game.heroes.get(i) instanceof Medic) {
            				 type = "Medic";

            			 }
            			 else {
            				type = "Explorer";
            			 }
               			 
               			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
               			 fileMenu4.getItems().add(openMenuItem);
            	            

            			 	
            		 }	
                       
                      
                    
                       menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                       gameLayout.getChildren().add(menuBar);
                        
                       if(Game.checkWin()){
                         	Alert win = new Alert(Alert.AlertType.INFORMATION);
         		             win.setTitle("All done!");
         		             win.setHeaderText("Close game");
         		             win.setContentText("This is an alert.");
         		             win.showAndWait().ifPresent(response -> {
         		                 if (response == ButtonType.OK) {
         		                     primaryStage.close();
         		                 }
         		             });
         		             win.setOnCloseRequest(close -> {
         		                 // Change the scene when the alert is closed
         		                 

         		                 primaryStage.close();
         		             });
                
                         }
                         if(Game.checkGameOver()){
                         	Alert lose = new Alert(Alert.AlertType.INFORMATION);
         		             lose.setTitle("You lost");
         		             lose.setHeaderText("Close game");
         		             lose.setContentText("This is an alert.");
         		             lose.showAndWait().ifPresent(response -> {
         		                 if (response == ButtonType.OK) {
         		                     primaryStage.close();
         		                 }
         		             });
         		             lose.setOnCloseRequest(close -> {
         		                 // Change the scene when the alert is closed
         		                 

         		                 primaryStage.close();
         		             });
                         }
                         
                        
                          
                    
             } catch (NotEnoughActionsException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Insufficient Actions");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         }

         catch (MovementException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Invalid Movement");
         alert.setContentText(e.getMessage());
         alert.showAndWait();

         }
         }
                      
                      
                 });

                    left.setOnMouseClicked(new EventHandler<Event>() {
                    
               @Override
               public void handle(Event event) {
               try {
               col = (int) currentHero.getLocation().getY();
                       xloc = (int) (15 -1 - currentHero.getLocation().getX());
                      
                       if(Game.map[((int)currentHero.getLocation().getX())][(int) currentHero.getLocation().getY() - 1]instanceof TrapCell) {
                       Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Warning");
             alert.setContentText("You have entered a trap cell!");
             alert.showAndWait();
                       }
                      
                      
                       currentHero.move(Direction.LEFT);
                       for(int row=0;row<GRID_SIZE;row++){
                           int rowMap=14-row;
                           	for(int col1 =0;col1<GRID_SIZE;col1++){
                          
                         
                          
                                           if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                                           Rectangle square= createSquare();
                               gridPane.add(square,col1,row);
                                           ImageView jImageView = new ImageView(joel);
                       jImageView.setFitWidth(50);  
                       jImageView.setFitHeight(50);
                           gridPane.add(jImageView, col1, row);

                           }
                                           else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
                           Rectangle square= createSquare();
                               gridPane.add(square,col1,row);
                           ImageView vaccineIV = new ImageView(vaccine);
                           vaccineIV.setFitWidth(50);  
                                       vaccineIV.setFitHeight(50);
                           gridPane.add(vaccineIV, col1, row);
                           }
                                           else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
                           Rectangle square= createSquare();
                               gridPane.add(square,col1,row);
                           ImageView supplyIV = new ImageView(supply);
                           supplyIV.setFitWidth(50);  
                                       supplyIV.setFitHeight(50);
                           gridPane.add(supplyIV, col1, row);
                           }
                                           else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
                          
                                           Rectangle square= createSquare();
                           Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                                  text.setFont(new Font(10));
                                  l1.setTextFill(Color.BLACK);
                                            
                           gridPane.add(square, col1, row);
                                      gridPane.add(text, col1, row);
                                      
                          
                           }
                                           else {
                               Rectangle square= createSquare();
                               gridPane.add(square,col1,row);
                               }
                           }
                          
                           }
               Rectangle rectangle = new Rectangle(160, 150, Color.DARKGRAY);
               Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Explorer" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                       //Text text = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                          text.setFont(Font.font("Arial", 14));
                          text.setFill(Color.BLACK);
                       gameLayout.setAlignment(Pos.TOP_RIGHT);
                          rectangle.setTranslateY(-10);
                       double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                          double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                          text.relocate(textX, textY);
                      gameLayout.getChildren().add(rectangle);
                       gameLayout.getChildren().add(text);
                       
                       
              
                       menuBar= new MenuBar();
                       fileMenu= new Menu("Select Zombie");
                       fileMenu2 = new Menu ("Select HeroTarget");
                   fileMenu3 = new Menu ("Pick a Hero");
                  fileMenu4 = new Menu ("View Heroes Details");
                   fileMenu.setStyle("-fx-text-fill: white;");
                   fileMenu2.setStyle("-fx-text-fill: white;");
                   fileMenu3.setStyle("-fx-text-fill: white;");
                   fileMenu4.setStyle("-fx-text-fill: white;");
                       menuBar.setPrefWidth(50);
                       menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                       for(int i=0; i<Game.zombies.size();i++){
                        MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                        fileMenu.getItems().add(openMenuItem);
                        int x=i;
                        openMenuItem.setOnAction(event2->{
                        currentHero.setTarget(Game.zombies.get(x));
                        System.out.println(currentHero.getTarget());
                        });
                       }
                       for(int i=0; i<Game.heroes.size();i++){
                        MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                        fileMenu3.getItems().add(openMenuItem);
                        int x=i;
                        openMenuItem.setOnAction(event2->{
                        currentHero = Game.heroes.get(x);
                        
                        });
                       }
                       for(int i=0; i<Game.heroes.size();i++){
                        MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                        fileMenu2.getItems().add(openMenuItem);
                        int x=i;
                        openMenuItem.setOnAction(event2->{
                        currentHero.setTarget(Game.heroes.get(x));
                        System.out.println(currentHero.getTarget());
                        });
                       }
                       for(int i=0; i<Game.heroes.size();i++){
               			 if(Game.heroes.get(i) instanceof Fighter) {
            				  type = "Fighter";

            			 }
            			 else if(Game.heroes.get(i) instanceof Medic) {
            				 type = "Medic";

            			 }
            			 else {
            				type = "Explorer";
            			 }
               			 
               			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
               			 fileMenu4.getItems().add(openMenuItem);
            	            

            			 	
            		 }	
                       
                      
                    
                       menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                       gameLayout.getChildren().add(menuBar);
                           
                           if(Game.checkWin()){
                           	Alert win = new Alert(Alert.AlertType.INFORMATION);
           		             win.setTitle("All done!");
           		             win.setHeaderText("Close game");
           		             win.setContentText("This is an alert.");
           		             win.showAndWait().ifPresent(response -> {
           		                 if (response == ButtonType.OK) {
           		                     primaryStage.close();
           		                 }
           		             });
           		             win.setOnCloseRequest(close -> {
           		                 // Change the scene when the alert is closed
           		                 

           		                 primaryStage.close();
           		             });
                  
                           }
                           if(Game.checkGameOver()){
                           	Alert lose = new Alert(Alert.AlertType.INFORMATION);
           		             lose.setTitle("You lost");
           		             lose.setHeaderText("Close game");
           		             lose.setContentText("This is an alert.");
           		             lose.showAndWait().ifPresent(response -> {
           		                 if (response == ButtonType.OK) {
           		                     primaryStage.close();
           		                 }
           		             });
           		             lose.setOnCloseRequest(close -> {
           		                 // Change the scene when the alert is closed
           		                 

           		                 primaryStage.close();
           		             });
                           }
                          
                      
               } catch (NotEnoughActionsException e) {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Insufficient Actions");
             alert.setContentText(e.getMessage());
             alert.showAndWait();
             }

             catch (MovementException e) {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Invalid Movement");
             alert.setContentText(e.getMessage());
             alert.showAndWait();
            
             }
             }
                        });
                    right.setOnMouseClicked(new EventHandler<Event>() {
                    
               @Override
               public void handle(Event event) {
               try {
               col = (int) currentHero.getLocation().getY();
                       xloc = (int) (15 -1 - currentHero.getLocation().getX());
                         if(Game.map[((int)currentHero.getLocation().getX())][(int) currentHero.getLocation().getY() + 1]instanceof TrapCell) {
                         Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Warning");
             alert.setContentText("You have entered a trap cell");
             alert.showAndWait();
                         }

               currentHero.move(Direction.RIGHT);
               for(int row=0;row<GRID_SIZE;row++){
                   int rowMap=14-row;
                   	for(int col1 =0;col1<GRID_SIZE;col1++){
                  
                 
                  
                                   if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                                   Rectangle square= createSquare();
                       gridPane.add(square,col1,row);
                                   ImageView jImageView = new ImageView(joel);
               jImageView.setFitWidth(50);  
               jImageView.setFitHeight(50);
                   gridPane.add(jImageView, col1, row);

                   }
                                   else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
                   Rectangle square= createSquare();
                       gridPane.add(square,col1,row);
                   ImageView vaccineIV = new ImageView(vaccine);
                   vaccineIV.setFitWidth(50);  
                               vaccineIV.setFitHeight(50);
                   gridPane.add(vaccineIV, col1, row);
                   }
                                   else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
                   Rectangle square= createSquare();
                       gridPane.add(square,col1,row);
                   ImageView supplyIV = new ImageView(supply);
                   supplyIV.setFitWidth(50);  
                               supplyIV.setFitHeight(50);
                   gridPane.add(supplyIV, col1, row);
                   }
                                   else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
                  
                                   Rectangle square= createSquare();
                   Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                          text.setFont(new Font(10));
                          l1.setTextFill(Color.BLACK);
                                    
                   gridPane.add(square, col1, row);
                              gridPane.add(text, col1, row);
                              
                  
                   }
                                   else {
                       Rectangle square= createSquare();
                       gridPane.add(square,col1,row);
                       }
                   }
                  
                   }
              
               Rectangle rectangle = new Rectangle(160, 150, Color.DARKGRAY);
               Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Explorer" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                     //  Text text = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                      text.setFont(Font.font("Arial", 14));
                      text.setFill(Color.BLACK);
                   gameLayout.setAlignment(Pos.TOP_RIGHT);
                      rectangle.setTranslateY(-10);
                   double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                      double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                      text.relocate(textX, textY);
                  gameLayout.getChildren().add(rectangle);
                   gameLayout.getChildren().add(text);
                   
                              
                  
                   menuBar= new MenuBar();
                   fileMenu= new Menu("Select Zombie");
                   fileMenu2 = new Menu ("Select HeroTarget");
               fileMenu3 = new Menu ("Pick a Hero");
              fileMenu4 = new Menu ("View Heroes Details");
               fileMenu.setStyle("-fx-text-fill: white;");
               fileMenu2.setStyle("-fx-text-fill: white;");
               fileMenu3.setStyle("-fx-text-fill: white;");
               fileMenu4.setStyle("-fx-text-fill: white;");
                   menuBar.setPrefWidth(50);
                   menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                   for(int i=0; i<Game.zombies.size();i++){
                    MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                    fileMenu.getItems().add(openMenuItem);
                    int x=i;
                    openMenuItem.setOnAction(event2->{
                    currentHero.setTarget(Game.zombies.get(x));
                    System.out.println(currentHero.getTarget());
                    });
                   }
                   for(int i=0; i<Game.heroes.size();i++){
                    MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                    fileMenu3.getItems().add(openMenuItem);
                    int x=i;
                    openMenuItem.setOnAction(event2->{
                    currentHero = Game.heroes.get(x);
                    
                    });
                   }
                   for(int i=0; i<Game.heroes.size();i++){
                    MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                    fileMenu2.getItems().add(openMenuItem);
                    int x=i;
                    openMenuItem.setOnAction(event2->{
                    currentHero.setTarget(Game.heroes.get(x));
                    System.out.println(currentHero.getTarget());
                    });
                   }
                   for(int i=0; i<Game.heroes.size();i++){
           			 if(Game.heroes.get(i) instanceof Fighter) {
        				  type = "Fighter";

        			 }
        			 else if(Game.heroes.get(i) instanceof Medic) {
        				 type = "Medic";

        			 }
        			 else {
        				type = "Explorer";
        			 }
           			 
           			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
           			 fileMenu4.getItems().add(openMenuItem);
        	            

        			 	
        		 }	
                   
                  
                
                   menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                   gameLayout.getChildren().add(menuBar);
                  
                       if(Game.checkWin()){
                       	Alert win = new Alert(Alert.AlertType.INFORMATION);
       		             win.setTitle("All done!");
       		             win.setHeaderText("Close game");
       		             win.setContentText("This is an alert.");
       		             win.showAndWait().ifPresent(response -> {
       		                 if (response == ButtonType.OK) {
       		                     primaryStage.close();
       		                 }
       		             });
       		             win.setOnCloseRequest(close -> {
       		                 // Change the scene when the alert is closed
       		                 

       		                 primaryStage.close();
       		             });
              
                       }
                       if(Game.checkGameOver()){
                       	Alert lose = new Alert(Alert.AlertType.INFORMATION);
       		             lose.setTitle("You lost");
       		             lose.setHeaderText("Close game");
       		             lose.setContentText("This is an alert.");
       		             lose.showAndWait().ifPresent(response -> {
       		                 if (response == ButtonType.OK) {
       		                     primaryStage.close();
       		                 }
       		             });
       		             lose.setOnCloseRequest(close -> {
       		                 // Change the scene when the alert is closed
       		                 

       		                 primaryStage.close();
       		             });
                       }
                      
                      
               } catch (NotEnoughActionsException e) {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Insufficient Actions");
             alert.setContentText(e.getMessage());
             alert.showAndWait();
             }

               catch (MovementException e) {
             	    Alert alert = new Alert(Alert.AlertType.INFORMATION);
             	    alert.setTitle("Invalid Movement");
             	    
             	    alert.setContentText(e.getMessage());
             	    alert.showAndWait();
             	    }
             	    }
             
                        });
                   
                    
                    
                   
                    
                    
                    attack.setOnAction(event2 -> {
                 	   
                     try {

                        

                         currentHero.attack();
                      

                         for(int row=0;row<GRID_SIZE;row++){
                             int rowMap=14-row;
                             	for(int col1 =0;col1<GRID_SIZE;col1++){
                            
                           
                            
                                             if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                                             Rectangle square= createSquare();
                                 gridPane.add(square,col1,row);
                                             ImageView jImageView = new ImageView(joel);
                         jImageView.setFitWidth(50);  
                         jImageView.setFitHeight(50);
                             gridPane.add(jImageView, col1, row);

                             }
                                             else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
                             Rectangle square= createSquare();
                                 gridPane.add(square,col1,row);
                             ImageView vaccineIV = new ImageView(vaccine);
                             vaccineIV.setFitWidth(50);  
                                         vaccineIV.setFitHeight(50);
                             gridPane.add(vaccineIV, col1, row);
                             }
                                             else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
                             Rectangle square= createSquare();
                                 gridPane.add(square,col1,row);
                             ImageView supplyIV = new ImageView(supply);
                             supplyIV.setFitWidth(50);  
                                         supplyIV.setFitHeight(50);
                             gridPane.add(supplyIV, col1, row);
                             }
                                             else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
                            
                                             Rectangle square= createSquare();
                             Label text2 = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                                    text2.setFont(new Font(10));
                                    l1.setTextFill(Color.BLACK);
                                              
                             gridPane.add(square, col1, row);
                                        gridPane.add(text2, col1, row);
                                        
                            
                             }
                                             else {
                                 Rectangle square= createSquare();
                                 gridPane.add(square,col1,row);
                                 }
                             }
                            
                             }

                   
                     
                    Rectangle rectangle2 = new Rectangle(160, 150, Color.DARKGRAY);
                    Text text2 = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Explorer" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                    // Text text2 = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                         text2.setFont(Font.font("Arial", 14));
                         text2.setFill(Color.BLACK);
                         gameLayout.setAlignment(Pos.TOP_RIGHT);

                         rectangle2.setTranslateY(-10);
                        
                    
                     double textX2 = rectangle2.getX() + (rectangle2.getWidth() - text2.getLayoutBounds().getWidth()) / 2;
                         double textY2= rectangle2.getY() + (rectangle2.getHeight() + text2.getLayoutBounds().getHeight()) / 2;
                         text2.relocate(textX2, textY2);
                     gameLayout.getChildren().add(rectangle2);
                     gameLayout.getChildren().add(text2);
                     
                     
                     
                     menuBar= new MenuBar();
                     fileMenu= new Menu("Select Zombie");
                     fileMenu2 = new Menu ("Select HeroTarget");
                 fileMenu3 = new Menu ("Pick a Hero");
                fileMenu4 = new Menu ("View Heroes Details");
                 fileMenu.setStyle("-fx-text-fill: white;");
                 fileMenu2.setStyle("-fx-text-fill: white;");
                 fileMenu3.setStyle("-fx-text-fill: white;");
                 fileMenu4.setStyle("-fx-text-fill: white;");
                     menuBar.setPrefWidth(50);
                     menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                     for(int i=0; i<Game.zombies.size();i++){
                      MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                      fileMenu.getItems().add(openMenuItem);
                      int x=i;
                      openMenuItem.setOnAction(event3->{
                      currentHero.setTarget(Game.zombies.get(x));
                      System.out.println(currentHero.getTarget());
                      });
                     }
                     for(int i=0; i<Game.heroes.size();i++){
                      MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                      fileMenu3.getItems().add(openMenuItem);
                      int x=i;
                      openMenuItem.setOnAction(event3->{
                      currentHero = Game.heroes.get(x);
                      
                      });
                     }
                     for(int i=0; i<Game.heroes.size();i++){
                      MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                      fileMenu2.getItems().add(openMenuItem);
                      int x=i;
                      openMenuItem.setOnAction(event3->{
                      currentHero.setTarget(Game.heroes.get(x));
                      System.out.println(currentHero.getTarget());
                      });
                     }
                     for(int i=0; i<Game.heroes.size();i++){
             			 if(Game.heroes.get(i) instanceof Fighter) {
          				  type = "Fighter";

          			 }
          			 else if(Game.heroes.get(i) instanceof Medic) {
          				 type = "Medic";

          			 }
          			 else {
          				type = "Explorer";
          			 }
             			 
             			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
             			 fileMenu4.getItems().add(openMenuItem);
          	            

          			 	
          		 }	
                     
                    
                  
                     menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                     gameLayout.getChildren().add(menuBar);
                     
                    
                     if(Game.checkWin()){
                     	Alert win = new Alert(Alert.AlertType.INFORMATION);
     		             win.setTitle("All done!");
     		             win.setHeaderText("Close game");
     		             win.setContentText("This is an alert.");
     		             win.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             win.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
            
                     }
                     if(Game.checkGameOver()){
                     	Alert lose = new Alert(Alert.AlertType.INFORMATION);
     		             lose.setTitle("You lost");
     		             lose.setHeaderText("Close game");
     		             lose.setContentText("This is an alert.");
     		             lose.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             lose.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
                     }
                     
            
             } catch (NotEnoughActionsException e) {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Insufficient Actions");
             alert.setContentText(e.getMessage());
         alert.showAndWait();

             } catch (InvalidTargetException e) {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Invalid Target");
             alert.setContentText(e.getMessage());
         alert.showAndWait();

             }
                    });
                    
                    
                    
                    cure.setOnMouseClicked(new EventHandler< Event >(){

         @Override
         public void handle(Event arg0) {
         try {
         currentHero.cure();
         for(int row=0;row<GRID_SIZE;row++){
             int rowMap=14-row;
             	for(int col1 =0;col1<GRID_SIZE;col1++){
            
           
            
                             if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                             ImageView jImageView = new ImageView(joel);
         jImageView.setFitWidth(50);  
         jImageView.setFitHeight(50);
             gridPane.add(jImageView, col1, row);

             }
                             else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView vaccineIV = new ImageView(vaccine);
             vaccineIV.setFitWidth(50);  
                         vaccineIV.setFitHeight(50);
             gridPane.add(vaccineIV, col1, row);
             }
                             else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView supplyIV = new ImageView(supply);
             supplyIV.setFitWidth(50);  
                         supplyIV.setFitHeight(50);
             gridPane.add(supplyIV, col1, row);
             }
                             else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
            
                             Rectangle square= createSquare();
             Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                    text.setFont(new Font(10));
                    l1.setTextFill(Color.BLACK);
                              
             gridPane.add(square, col1, row);
                        gridPane.add(text, col1, row);
                        
            
             }
                             else {
                 Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                 }
             }
            
             }
         
         
         Rectangle rectangle = new Rectangle(160, 120, Color.DARKGRAY);
         Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Explorer" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                  // Text text = new Text("\n" + Game.heroes.get(Game.heroes.size()-1).getName() + "\nCurrent Hp: " + Game.heroes.get(Game.heroes.size()-1).getCurrentHp() + "\nActions available: " +  Game.heroes.get(Game.heroes.size()-1).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(Game.heroes.size()-1).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                    text.setFont(Font.font("Arial", 14));
                    text.setFill(Color.BLACK);
                 gameLayout.setAlignment(Pos.TOP_RIGHT);
                    rectangle.setTranslateY(-10);
                 double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                    double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                    text.relocate(textX, textY);
                gameLayout.getChildren().add(rectangle);
                 gameLayout.getChildren().add(text);
                 
                 
                 
                 menuBar= new MenuBar();
                 fileMenu= new Menu("Select Zombie");
                 fileMenu2 = new Menu ("Select HeroTarget");
             fileMenu3 = new Menu ("Pick a Hero");
            fileMenu4 = new Menu ("View Heroes Details");
             fileMenu.setStyle("-fx-text-fill: white;");
             fileMenu2.setStyle("-fx-text-fill: white;");
             fileMenu3.setStyle("-fx-text-fill: white;");
             fileMenu4.setStyle("-fx-text-fill: white;");
                 menuBar.setPrefWidth(50);
                 menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                 for(int i=0; i<Game.zombies.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                  fileMenu.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero.setTarget(Game.zombies.get(x));
                  System.out.println(currentHero.getTarget());
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                  fileMenu3.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero = Game.heroes.get(x);
                  
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                  fileMenu2.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero.setTarget(Game.heroes.get(x));
                  System.out.println(currentHero.getTarget());
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
         			 if(Game.heroes.get(i) instanceof Fighter) {
      				  type = "Fighter";

      			 }
      			 else if(Game.heroes.get(i) instanceof Medic) {
      				 type = "Medic";

      			 }
      			 else {
      				type = "Explorer";
      			 }
         			 
         			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
         			 fileMenu4.getItems().add(openMenuItem);
      	            

      			 	
      		 }	
                 
                
              
                 menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                 gameLayout.getChildren().add(menuBar);
                    
                    
                
                     if(Game.checkWin()){
                     	Alert win = new Alert(Alert.AlertType.INFORMATION);
     		             win.setTitle("All done!");
     		             win.setHeaderText("Close game");
     		             win.setContentText("This is an alert.");
     		             win.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             win.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
            
                     }
                     if(Game.checkGameOver()){
                     	Alert lose = new Alert(Alert.AlertType.INFORMATION);
     		             lose.setTitle("You lost");
     		             lose.setHeaderText("Close game");
     		             lose.setContentText("This is an alert.");
     		             lose.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             lose.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
                     }
                     
                               
         } catch (NoAvailableResourcesException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Insufficient resources");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         } catch (InvalidTargetException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Invalid Target");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         } catch (NotEnoughActionsException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Insufficient Actions");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         }
         }
                  
                    });
                    
                    
                    
                    endTurn.setOnMouseClicked(new EventHandler<Event>(){

         @Override
         public void handle(Event event3) {
         try {
         Game.endTurn();

         if(Game.checkWin()){
         	Alert win = new Alert(Alert.AlertType.INFORMATION);
              win.setTitle("All done!");
              win.setHeaderText("Close game");
              win.setContentText("This is an alert.");
              win.showAndWait().ifPresent(response -> {
                  if (response == ButtonType.OK) {
                      primaryStage.close();
                  }
              });
              win.setOnCloseRequest(close -> {
                  // Change the scene when the alert is closed
                  

                  primaryStage.close();
              });

         }
         if(Game.checkGameOver()){
         	Alert lose = new Alert(Alert.AlertType.INFORMATION);
              lose.setTitle("You lost");
              lose.setHeaderText("Close game");
              lose.setContentText("This is an alert.");
              lose.showAndWait().ifPresent(response -> {
                  if (response == ButtonType.OK) {
                      primaryStage.close();
                  }
              });
              lose.setOnCloseRequest(close -> {
                  // Change the scene when the alert is closed
                  

                  primaryStage.close();
              });
         }

         for(int row=0;row<GRID_SIZE;row++){
             int rowMap=14-row;
             	for(int col1 =0;col1<GRID_SIZE;col1++){
            
           
            
                             if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                             ImageView jImageView = new ImageView(joel);
         jImageView.setFitWidth(50);  
         jImageView.setFitHeight(50);
             gridPane.add(jImageView, col1, row);

             }
                             else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView vaccineIV = new ImageView(vaccine);
             vaccineIV.setFitWidth(50);  
                         vaccineIV.setFitHeight(50);
             gridPane.add(vaccineIV, col1, row);
             }
                             else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView supplyIV = new ImageView(supply);
             supplyIV.setFitWidth(50);  
                         supplyIV.setFitHeight(50);
             gridPane.add(supplyIV, col1, row);
             }
                             else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
            
                             Rectangle square= createSquare();
             Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                    text.setFont(new Font(10));
                    l1.setTextFill(Color.BLACK);
                              
             gridPane.add(square, col1, row);
                        gridPane.add(text, col1, row);
                        
            
             }
                             else {
                 Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                 }
             }
            
             }
         Rectangle rectangle = new Rectangle(160, 120, Color.DARKGRAY);
         Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Explorer" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                   //Text text = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                    text.setFont(Font.font("Arial", 14));
                    text.setFill(Color.BLACK);
                 gameLayout.setAlignment(Pos.TOP_RIGHT);
                    rectangle.setTranslateY(-10);
                 double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                    double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                    text.relocate(textX, textY);
                gameLayout.getChildren().add(rectangle);
                 gameLayout.getChildren().add(text);
                 
                 
                 
                 menuBar= new MenuBar();
                 fileMenu= new Menu("Select Zombie");
                 fileMenu2 = new Menu ("Select HeroTarget");
             fileMenu3 = new Menu ("Pick a Hero");
            fileMenu4 = new Menu ("View Heroes Details");
             fileMenu.setStyle("-fx-text-fill: white;");
             fileMenu2.setStyle("-fx-text-fill: white;");
             fileMenu3.setStyle("-fx-text-fill: white;");
             fileMenu4.setStyle("-fx-text-fill: white;");
                 menuBar.setPrefWidth(50);
                 menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                 for(int i=0; i<Game.zombies.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                  fileMenu.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero.setTarget(Game.zombies.get(x));
                  System.out.println(currentHero.getTarget());
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                  fileMenu3.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero = Game.heroes.get(x);
                  
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                  fileMenu2.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero.setTarget(Game.heroes.get(x));
                  System.out.println(currentHero.getTarget());
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
         			 if(Game.heroes.get(i) instanceof Fighter) {
      				  type = "Fighter";

      			 }
      			 else if(Game.heroes.get(i) instanceof Medic) {
      				 type = "Medic";

      			 }
      			 else {
      				type = "Explorer";
      			 }
         			 
         			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
         			 fileMenu4.getItems().add(openMenuItem);
      	            

      			 	
      		 }	
                 
                
              
                 menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                 gameLayout.getChildren().add(menuBar);
                     
                    
         } catch (NotEnoughActionsException e) {

         } catch (InvalidTargetException e) {

         }
         }
                  
                    });
                    
                    useSpecial.setOnMouseClicked(new EventHandler< Event >(){

         @Override
         public void handle(Event event) {
         try {
         currentHero.useSpecial();
         for(int row=0;row<GRID_SIZE;row++){
             int rowMap=14-row;
             	for(int col1 =0;col1<GRID_SIZE;col1++){
            
           
            
                             if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                             ImageView jImageView = new ImageView(joel);
         jImageView.setFitWidth(50);  
         jImageView.setFitHeight(50);
             gridPane.add(jImageView, col1, row);

             }
                             else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView vaccineIV = new ImageView(vaccine);
             vaccineIV.setFitWidth(50);  
                         vaccineIV.setFitHeight(50);
             gridPane.add(vaccineIV, col1, row);
             }
                             else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView supplyIV = new ImageView(supply);
             supplyIV.setFitWidth(50);  
                         supplyIV.setFitHeight(50);
             gridPane.add(supplyIV, col1, row);
             }
                             else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
            
                             Rectangle square= createSquare();
             Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                    text.setFont(new Font(10));
                    l1.setTextFill(Color.BLACK);
                              
             gridPane.add(square, col1, row);
                        gridPane.add(text, col1, row);
                        
            
             }
                             else {
                 Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                 }
             }
            
             }
         Rectangle rectangle = new Rectangle(160, 120, Color.DARKGRAY);
         Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Explorer" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                  // Text text = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                    text.setFont(Font.font("Arial", 14));
                    text.setFill(Color.BLACK);
                 gameLayout.setAlignment(Pos.TOP_RIGHT);
                    rectangle.setTranslateY(-10);
                 double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                    double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                    text.relocate(textX, textY);
                gameLayout.getChildren().add(rectangle);
                gameLayout.getChildren().add(text);

                menuBar= new MenuBar();
                fileMenu= new Menu("Select Zombie");
                fileMenu2 = new Menu ("Select HeroTarget");
            fileMenu3 = new Menu ("Pick a Hero");
           fileMenu4 = new Menu ("View Heroes Details");
            fileMenu.setStyle("-fx-text-fill: white;");
            fileMenu2.setStyle("-fx-text-fill: white;");
            fileMenu3.setStyle("-fx-text-fill: white;");
            fileMenu4.setStyle("-fx-text-fill: white;");
                menuBar.setPrefWidth(50);
                menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                for(int i=0; i<Game.zombies.size();i++){
                 MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                 fileMenu.getItems().add(openMenuItem);
                 int x=i;
                 openMenuItem.setOnAction(event2->{
                 currentHero.setTarget(Game.zombies.get(x));
                 System.out.println(currentHero.getTarget());
                 });
                }
                for(int i=0; i<Game.heroes.size();i++){
                 MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                 fileMenu3.getItems().add(openMenuItem);
                 int x=i;
                 openMenuItem.setOnAction(event2->{
                 currentHero = Game.heroes.get(x);
                 
                 });
                }
                for(int i=0; i<Game.heroes.size();i++){
                 MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                 fileMenu2.getItems().add(openMenuItem);
                 int x=i;
                 openMenuItem.setOnAction(event2->{
                 currentHero.setTarget(Game.heroes.get(x));
                 System.out.println(currentHero.getTarget());
                 });
                }
                for(int i=0; i<Game.heroes.size();i++){
        			 if(Game.heroes.get(i) instanceof Fighter) {
     				  type = "Fighter";

     			 }
     			 else if(Game.heroes.get(i) instanceof Medic) {
     				 type = "Medic";

     			 }
     			 else {
     				type = "Explorer";
     			 }
        			 
        			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
        			 fileMenu4.getItems().add(openMenuItem);
     	            

     			 	
     		 }	
                
               
             
                menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                gameLayout.getChildren().add(menuBar);
                    
                     if(Game.checkWin()){
                     	Alert win = new Alert(Alert.AlertType.INFORMATION);
     		             win.setTitle("All done!");
     		             win.setHeaderText("Close game");
     		             win.setContentText("This is an alert.");
     		             win.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             win.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
            
                     }
                     if(Game.checkGameOver()){
                     	Alert lose = new Alert(Alert.AlertType.INFORMATION);
     		             lose.setTitle("You lost");
     		             lose.setHeaderText("Close game");
     		             lose.setContentText("This is an alert.");
     		             lose.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             lose.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
                     }
                    
          
         } catch (NoAvailableResourcesException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Insufficient Supply");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         } catch (InvalidTargetException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Invalid Target");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         }

         }});
            

                 game = new Scene(gameLayout, 1470, 800);
               primaryStage.setScene(game);

                

                 });
         	
        b4.setOnAction(event -> {
        	 currentHero = Game.availableHeroes.get(3);
             Game.startGame(currentHero);
            
            
             gridPane.setAlignment(Pos.CENTER);
             
             for(int row=0;row<GRID_SIZE;row++){
             int rowMap=14-row;
             	for(int col1 =0;col1<GRID_SIZE;col1++){
            
           
            
                             if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                             ImageView jImageView = new ImageView(joel);
         jImageView.setFitWidth(50);  
         jImageView.setFitHeight(50);
             gridPane.add(jImageView, col1, row);

             }
                             else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView vaccineIV = new ImageView(vaccine);
             vaccineIV.setFitWidth(50);  
                         vaccineIV.setFitHeight(50);
             gridPane.add(vaccineIV, col1, row);
             }
                             else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView supplyIV = new ImageView(supply);
             supplyIV.setFitWidth(50);  
                         supplyIV.setFitHeight(50);
             gridPane.add(supplyIV, col1, row);
             }
                             else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
            
                             Rectangle square= createSquare();
             Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                    text.setFont(new Font(10));
                    l1.setTextFill(Color.BLACK);
                              
             gridPane.add(square, col1, row);
                        gridPane.add(text, col1, row);
                        
            
             }
                             else {
                 Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                 }
             }
            
             }

                  
             gameLayout.getChildren().add(gridPane);
                
                    
                      
                      gameLayout.setStyle("-fx-background-color: #000000;");
              
                    
              
                 Rectangle rectangle = new Rectangle(160, 150, Color.DARKGRAY);
                 Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Explorer" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                      text.setFont(Font.font("Arial", 14));
                      text.setFill(Color.BLACK);
                      
                    


                   gameLayout.setAlignment(Pos.TOP_RIGHT);


                     rectangle.setTranslateY(-10);

                
                 double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                     double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                    
                     text.relocate(textX, textY);
                     
                     
                 

                 
                 gameLayout.getChildren().addAll(rectangle,text);
                 

                
                     Button up = new Button("↑");
                     Button down = new Button("↓");
                 Button left = new Button("←");
                 Button right = new Button("→");
                    
                    
                     Button attack = new Button("ATTACK");
                     Button cure = new Button("CURE");
                     Button useSpecial = new Button("USE SPECIAL");
                     Button endTurn = new Button("END TURN");
                     

                    
                    
                     menuBar= new MenuBar();
                     fileMenu= new Menu("Select Zombie");
                     fileMenu2 = new Menu ("Select HeroTarget");
                 fileMenu3 = new Menu ("Pick a Hero");
                fileMenu4 = new Menu ("View Heroes Details");
                 fileMenu.setStyle("-fx-text-fill: white;");
                 fileMenu2.setStyle("-fx-text-fill: white;");
                 fileMenu3.setStyle("-fx-text-fill: white;");
                 fileMenu4.setStyle("-fx-text-fill: white;");
                     menuBar.setPrefWidth(50);
                     menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                     for(int i=0; i<Game.zombies.size();i++){
                      MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                      fileMenu.getItems().add(openMenuItem);
                      int x=i;
                      openMenuItem.setOnAction(event2->{
                      currentHero.setTarget(Game.zombies.get(x));
                      System.out.println(currentHero.getTarget());
                      });
                     }
                     for(int i=0; i<Game.heroes.size();i++){
                      MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                      fileMenu3.getItems().add(openMenuItem);
                      int x=i;
                      openMenuItem.setOnAction(event2->{
                      currentHero = Game.heroes.get(x);
                      
                      });
                     }
                     for(int i=0; i<Game.heroes.size();i++){
                      MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                      fileMenu2.getItems().add(openMenuItem);
                      int x=i;
                      openMenuItem.setOnAction(event2->{
                      currentHero.setTarget(Game.heroes.get(x));
                      System.out.println(currentHero.getTarget());
                      });
                     }
                     for(int i=0; i<Game.heroes.size();i++){
             			 if(Game.heroes.get(i) instanceof Fighter) {
          				  type = "Fighter";

          			 }
          			 else if(Game.heroes.get(i) instanceof Medic) {
          				 type = "Medic";

          			 }
          			 else {
          				type = "Explorer";
          			 }
             			 
             			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
             			 fileMenu4.getItems().add(openMenuItem);
          	            

          			 	
          		 }	
                     
                    
                  
                     menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                     gameLayout.getChildren().add(menuBar);
                    
                    
                    
                    
                     if(Game.checkWin()){
                     	Alert win = new Alert(Alert.AlertType.INFORMATION);
     		             win.setTitle("All done!");
     		             win.setHeaderText("Close game");
     		             win.setContentText("This is an alert.");
     		             win.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             win.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
            
                     }
                     if(Game.checkGameOver()){
                     	Alert lose = new Alert(Alert.AlertType.INFORMATION);
     		             lose.setTitle("You lost");
     		             lose.setHeaderText("Close game");
     		             lose.setContentText("This is an alert.");
     		             lose.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             lose.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
                     }
                    

                    
                     VBox buttonsBox = new VBox();              
                     buttonsBox.getChildren().addAll(menuBar,up,down,left,right,attack,cure,useSpecial, endTurn);
                     
                     
                     
                     
                     gameLayout.getChildren().add(buttonsBox);
                     buttonsBox.setAlignment(Pos.TOP_LEFT);
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    


                    up.setOnMouseClicked(new EventHandler<Event>() {  
         public void handle(Event event) {
         try {
         col = (int) currentHero.getLocation().getY();
                 xloc = (int) (15 -1 - currentHero.getLocation().getX());
                 if(Game.map[((int)currentHero.getLocation().getX()) + 1][(int) currentHero.getLocation().getY()]instanceof TrapCell) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Warning");
         alert.setContentText("You have entered a trap cell!");
         alert.showAndWait();
                 }
         currentHero.move(Direction.UP);
         for(int row=0;row<GRID_SIZE;row++){
             int rowMap=14-row;
             	for(int col1 =0;col1<GRID_SIZE;col1++){
            
           
            
                             if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                             ImageView jImageView = new ImageView(joel);
         jImageView.setFitWidth(50);  
         jImageView.setFitHeight(50);
             gridPane.add(jImageView, col1, row);

             }
                             else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView vaccineIV = new ImageView(vaccine);
             vaccineIV.setFitWidth(50);  
                         vaccineIV.setFitHeight(50);
             gridPane.add(vaccineIV, col1, row);
             }
                             else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView supplyIV = new ImageView(supply);
             supplyIV.setFitWidth(50);  
                         supplyIV.setFitHeight(50);
             gridPane.add(supplyIV, col1, row);
             }
                             else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
            
                             Rectangle square= createSquare();
             Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                    text.setFont(new Font(10));
                    l1.setTextFill(Color.BLACK);
                              
             gridPane.add(square, col1, row);
                        gridPane.add(text, col1, row);
                        
            
             }
                             else {
                 Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                 }
             }
            
             }
         Rectangle rectangle = new Rectangle(160, 150, Color.DARKGRAY);
         Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Explorer" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                     text.setFont(Font.font("Arial", 14));
                     text.setFill(Color.BLACK);
                 gameLayout.setAlignment(Pos.TOP_RIGHT);
                    rectangle.setTranslateY(-10);
                 double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                    double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                    text.relocate(textX, textY);
                gameLayout.getChildren().add(rectangle);
                 gameLayout.getChildren().add(text);
                 
                 
                 

          	
     		 	

                 
                 menuBar= new MenuBar();
                 fileMenu= new Menu("Select Zombie");
                 fileMenu2 = new Menu ("Select HeroTarget");
             fileMenu3 = new Menu ("Pick a Hero");
            fileMenu4 = new Menu ("View Heroes Details");
             fileMenu.setStyle("-fx-text-fill: white;");
             fileMenu2.setStyle("-fx-text-fill: white;");
             fileMenu3.setStyle("-fx-text-fill: white;");
             fileMenu4.setStyle("-fx-text-fill: white;");
                 menuBar.setPrefWidth(50);
                 menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                 for(int i=0; i<Game.zombies.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                  fileMenu.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero.setTarget(Game.zombies.get(x));
                  System.out.println(currentHero.getTarget());
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                  fileMenu3.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero = Game.heroes.get(x);
                  
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                  fileMenu2.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero.setTarget(Game.heroes.get(x));
                  System.out.println(currentHero.getTarget());
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
         			 if(Game.heroes.get(i) instanceof Fighter) {
      				  type = "Fighter";

      			 }
      			 else if(Game.heroes.get(i) instanceof Medic) {
      				 type = "Medic";

      			 }
      			 else {
      				type = "Explorer";
      			 }
         			 
         			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
         			 fileMenu4.getItems().add(openMenuItem);
      	            

      			 	
      		 }	
                 
                
              
                 menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                 gameLayout.getChildren().add(menuBar);

                    
                    


                     if(Game.checkWin()){
                     	Alert win = new Alert(Alert.AlertType.INFORMATION);
     		             win.setTitle("All done!");
     		             win.setHeaderText("Close game");
     		             win.setContentText("This is an alert.");
     		             win.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             win.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
            
                     }
                     if(Game.checkGameOver()){
                     	Alert lose = new Alert(Alert.AlertType.INFORMATION);
     		             lose.setTitle("You lost");
     		             lose.setHeaderText("Close game");
     		             lose.setContentText("This is an alert.");
     		             lose.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             lose.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
                     }
                     
                    
                               

         }
         catch (NotEnoughActionsException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Insufficient Actions");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         }

         catch (MovementException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Invalid Movement");
         
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         }
         }
         
                    });
                    down.setOnMouseClicked(new EventHandler<Event>() {
                  
             @Override
             public void handle(Event event) {
             try {
             col = (int) currentHero.getLocation().getY();
                     xloc = (int) (15 -1 - currentHero.getLocation().getX());
                     if(Game.map[((int)currentHero.getLocation().getX()) - 1][(int) currentHero.getLocation().getY()]instanceof TrapCell) {
                     Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Warning");
         alert.setContentText("You have entered a trap cell!");
         alert.showAndWait();
                     }
                    
                    
                     currentHero.move(Direction.DOWN);
                     for(int row=0;row<GRID_SIZE;row++){
                         int rowMap=14-row;
                         	for(int col1 =0;col1<GRID_SIZE;col1++){
                        
                       
                        
                                         if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                                         Rectangle square= createSquare();
                             gridPane.add(square,col1,row);
                                         ImageView jImageView = new ImageView(joel);
                     jImageView.setFitWidth(50);  
                     jImageView.setFitHeight(50);
                         gridPane.add(jImageView, col1, row);

                         }
                                         else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
                         Rectangle square= createSquare();
                             gridPane.add(square,col1,row);
                         ImageView vaccineIV = new ImageView(vaccine);
                         vaccineIV.setFitWidth(50);  
                                     vaccineIV.setFitHeight(50);
                         gridPane.add(vaccineIV, col1, row);
                         }
                                         else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
                         Rectangle square= createSquare();
                             gridPane.add(square,col1,row);
                         ImageView supplyIV = new ImageView(supply);
                         supplyIV.setFitWidth(50);  
                                     supplyIV.setFitHeight(50);
                         gridPane.add(supplyIV, col1, row);
                         }
                                         else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
                        
                                         Rectangle square= createSquare();
                         Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                                text.setFont(new Font(10));
                                l1.setTextFill(Color.BLACK);
                                          
                         gridPane.add(square, col1, row);
                                    gridPane.add(text, col1, row);
                                    
                        
                         }
                                         else {
                             Rectangle square= createSquare();
                             gridPane.add(square,col1,row);
                             }
                         }
                        
                         }
             Rectangle rectangle = new Rectangle(160, 150, Color.DARKGRAY);
             Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Explorer" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
             //Text text = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                          text.setFont(Font.font("Arial", 14));
                          text.setFill(Color.BLACK);
                       gameLayout.setAlignment(Pos.TOP_RIGHT);
                          rectangle.setTranslateY(-10);
                       double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                          double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                          text.relocate(textX, textY);
                      gameLayout.getChildren().add(rectangle);
                       gameLayout.getChildren().add(text);
                       
                                         
                       
                       menuBar= new MenuBar();
                       fileMenu= new Menu("Select Zombie");
                       fileMenu2 = new Menu ("Select HeroTarget");
                   fileMenu3 = new Menu ("Pick a Hero");
                  fileMenu4 = new Menu ("View Heroes Details");
                   fileMenu.setStyle("-fx-text-fill: white;");
                   fileMenu2.setStyle("-fx-text-fill: white;");
                   fileMenu3.setStyle("-fx-text-fill: white;");
                   fileMenu4.setStyle("-fx-text-fill: white;");
                       menuBar.setPrefWidth(50);
                       menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                       for(int i=0; i<Game.zombies.size();i++){
                        MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                        fileMenu.getItems().add(openMenuItem);
                        int x=i;
                        openMenuItem.setOnAction(event2->{
                        currentHero.setTarget(Game.zombies.get(x));
                        System.out.println(currentHero.getTarget());
                        });
                       }
                       for(int i=0; i<Game.heroes.size();i++){
                        MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                        fileMenu3.getItems().add(openMenuItem);
                        int x=i;
                        openMenuItem.setOnAction(event2->{
                        currentHero = Game.heroes.get(x);
                        
                        });
                       }
                       for(int i=0; i<Game.heroes.size();i++){
                        MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                        fileMenu2.getItems().add(openMenuItem);
                        int x=i;
                        openMenuItem.setOnAction(event2->{
                        currentHero.setTarget(Game.heroes.get(x));
                        System.out.println(currentHero.getTarget());
                        });
                       }
                       for(int i=0; i<Game.heroes.size();i++){
               			 if(Game.heroes.get(i) instanceof Fighter) {
            				  type = "Fighter";

            			 }
            			 else if(Game.heroes.get(i) instanceof Medic) {
            				 type = "Medic";

            			 }
            			 else {
            				type = "Explorer";
            			 }
               			 
               			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
               			 fileMenu4.getItems().add(openMenuItem);
            	            

            			 	
            		 }	
                       
                      
                    
                       menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                       gameLayout.getChildren().add(menuBar);
                        
                       if(Game.checkWin()){
                         	Alert win = new Alert(Alert.AlertType.INFORMATION);
         		             win.setTitle("All done!");
         		             win.setHeaderText("Close game");
         		             win.setContentText("This is an alert.");
         		             win.showAndWait().ifPresent(response -> {
         		                 if (response == ButtonType.OK) {
         		                     primaryStage.close();
         		                 }
         		             });
         		             win.setOnCloseRequest(close -> {
         		                 // Change the scene when the alert is closed
         		                 

         		                 primaryStage.close();
         		             });
                
                         }
                         if(Game.checkGameOver()){
                         	Alert lose = new Alert(Alert.AlertType.INFORMATION);
         		             lose.setTitle("You lost");
         		             lose.setHeaderText("Close game");
         		             lose.setContentText("This is an alert.");
         		             lose.showAndWait().ifPresent(response -> {
         		                 if (response == ButtonType.OK) {
         		                     primaryStage.close();
         		                 }
         		             });
         		             lose.setOnCloseRequest(close -> {
         		                 // Change the scene when the alert is closed
         		                 

         		                 primaryStage.close();
         		             });
                         }
                         
                        
                          
                    
             } catch (NotEnoughActionsException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Insufficient Actions");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         }

         catch (MovementException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Invalid Movement");
         alert.setContentText(e.getMessage());
         alert.showAndWait();

         }
         }
                      
                      
                 });

                    left.setOnMouseClicked(new EventHandler<Event>() {
                    
               @Override
               public void handle(Event event) {
               try {
               col = (int) currentHero.getLocation().getY();
                       xloc = (int) (15 -1 - currentHero.getLocation().getX());
                      
                       if(Game.map[((int)currentHero.getLocation().getX())][(int) currentHero.getLocation().getY() - 1]instanceof TrapCell) {
                       Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Warning");
             alert.setContentText("You have entered a trap cell!");
             alert.showAndWait();
                       }
                      
                      
                       currentHero.move(Direction.LEFT);
                       for(int row=0;row<GRID_SIZE;row++){
                           int rowMap=14-row;
                           	for(int col1 =0;col1<GRID_SIZE;col1++){
                          
                         
                          
                                           if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                                           Rectangle square= createSquare();
                               gridPane.add(square,col1,row);
                                           ImageView jImageView = new ImageView(joel);
                       jImageView.setFitWidth(50);  
                       jImageView.setFitHeight(50);
                           gridPane.add(jImageView, col1, row);

                           }
                                           else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
                           Rectangle square= createSquare();
                               gridPane.add(square,col1,row);
                           ImageView vaccineIV = new ImageView(vaccine);
                           vaccineIV.setFitWidth(50);  
                                       vaccineIV.setFitHeight(50);
                           gridPane.add(vaccineIV, col1, row);
                           }
                                           else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
                           Rectangle square= createSquare();
                               gridPane.add(square,col1,row);
                           ImageView supplyIV = new ImageView(supply);
                           supplyIV.setFitWidth(50);  
                                       supplyIV.setFitHeight(50);
                           gridPane.add(supplyIV, col1, row);
                           }
                                           else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
                          
                                           Rectangle square= createSquare();
                           Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                                  text.setFont(new Font(10));
                                  l1.setTextFill(Color.BLACK);
                                            
                           gridPane.add(square, col1, row);
                                      gridPane.add(text, col1, row);
                                      
                          
                           }
                                           else {
                               Rectangle square= createSquare();
                               gridPane.add(square,col1,row);
                               }
                           }
                          
                           }
               Rectangle rectangle = new Rectangle(160, 150, Color.DARKGRAY);
               Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Explorer" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                       //Text text = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                          text.setFont(Font.font("Arial", 14));
                          text.setFill(Color.BLACK);
                       gameLayout.setAlignment(Pos.TOP_RIGHT);
                          rectangle.setTranslateY(-10);
                       double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                          double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                          text.relocate(textX, textY);
                      gameLayout.getChildren().add(rectangle);
                       gameLayout.getChildren().add(text);
                       
                       
              
                       menuBar= new MenuBar();
                       fileMenu= new Menu("Select Zombie");
                       fileMenu2 = new Menu ("Select HeroTarget");
                   fileMenu3 = new Menu ("Pick a Hero");
                  fileMenu4 = new Menu ("View Heroes Details");
                   fileMenu.setStyle("-fx-text-fill: white;");
                   fileMenu2.setStyle("-fx-text-fill: white;");
                   fileMenu3.setStyle("-fx-text-fill: white;");
                   fileMenu4.setStyle("-fx-text-fill: white;");
                       menuBar.setPrefWidth(50);
                       menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                       for(int i=0; i<Game.zombies.size();i++){
                        MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                        fileMenu.getItems().add(openMenuItem);
                        int x=i;
                        openMenuItem.setOnAction(event2->{
                        currentHero.setTarget(Game.zombies.get(x));
                        System.out.println(currentHero.getTarget());
                        });
                       }
                       for(int i=0; i<Game.heroes.size();i++){
                        MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                        fileMenu3.getItems().add(openMenuItem);
                        int x=i;
                        openMenuItem.setOnAction(event2->{
                        currentHero = Game.heroes.get(x);
                        
                        });
                       }
                       for(int i=0; i<Game.heroes.size();i++){
                        MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                        fileMenu2.getItems().add(openMenuItem);
                        int x=i;
                        openMenuItem.setOnAction(event2->{
                        currentHero.setTarget(Game.heroes.get(x));
                        System.out.println(currentHero.getTarget());
                        });
                       }
                       for(int i=0; i<Game.heroes.size();i++){
               			 if(Game.heroes.get(i) instanceof Fighter) {
            				  type = "Fighter";

            			 }
            			 else if(Game.heroes.get(i) instanceof Medic) {
            				 type = "Medic";

            			 }
            			 else {
            				type = "Explorer";
            			 }
               			 
               			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
               			 fileMenu4.getItems().add(openMenuItem);
            	            

            			 	
            		 }	
                       
                      
                    
                       menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                       gameLayout.getChildren().add(menuBar);
                           
                           if(Game.checkWin()){
                           	Alert win = new Alert(Alert.AlertType.INFORMATION);
           		             win.setTitle("All done!");
           		             win.setHeaderText("Close game");
           		             win.setContentText("This is an alert.");
           		             win.showAndWait().ifPresent(response -> {
           		                 if (response == ButtonType.OK) {
           		                     primaryStage.close();
           		                 }
           		             });
           		             win.setOnCloseRequest(close -> {
           		                 // Change the scene when the alert is closed
           		                 

           		                 primaryStage.close();
           		             });
                  
                           }
                           if(Game.checkGameOver()){
                           	Alert lose = new Alert(Alert.AlertType.INFORMATION);
           		             lose.setTitle("You lost");
           		             lose.setHeaderText("Close game");
           		             lose.setContentText("This is an alert.");
           		             lose.showAndWait().ifPresent(response -> {
           		                 if (response == ButtonType.OK) {
           		                     primaryStage.close();
           		                 }
           		             });
           		             lose.setOnCloseRequest(close -> {
           		                 // Change the scene when the alert is closed
           		                 

           		                 primaryStage.close();
           		             });
                           }
                          
                      
               } catch (NotEnoughActionsException e) {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Insufficient Actions");
             alert.setContentText(e.getMessage());
             alert.showAndWait();
             }

             catch (MovementException e) {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Invalid Movement");
             alert.setContentText(e.getMessage());
             alert.showAndWait();
            
             }
             }
                        });
                    right.setOnMouseClicked(new EventHandler<Event>() {
                    
               @Override
               public void handle(Event event) {
               try {
               col = (int) currentHero.getLocation().getY();
                       xloc = (int) (15 -1 - currentHero.getLocation().getX());
                         if(Game.map[((int)currentHero.getLocation().getX())][(int) currentHero.getLocation().getY() + 1]instanceof TrapCell) {
                         Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Warning");
             alert.setContentText("You have entered a trap cell");
             alert.showAndWait();
                         }

               currentHero.move(Direction.RIGHT);
               for(int row=0;row<GRID_SIZE;row++){
                   int rowMap=14-row;
                   	for(int col1 =0;col1<GRID_SIZE;col1++){
                  
                 
                  
                                   if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                                   Rectangle square= createSquare();
                       gridPane.add(square,col1,row);
                                   ImageView jImageView = new ImageView(joel);
               jImageView.setFitWidth(50);  
               jImageView.setFitHeight(50);
                   gridPane.add(jImageView, col1, row);

                   }
                                   else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
                   Rectangle square= createSquare();
                       gridPane.add(square,col1,row);
                   ImageView vaccineIV = new ImageView(vaccine);
                   vaccineIV.setFitWidth(50);  
                               vaccineIV.setFitHeight(50);
                   gridPane.add(vaccineIV, col1, row);
                   }
                                   else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
                   Rectangle square= createSquare();
                       gridPane.add(square,col1,row);
                   ImageView supplyIV = new ImageView(supply);
                   supplyIV.setFitWidth(50);  
                               supplyIV.setFitHeight(50);
                   gridPane.add(supplyIV, col1, row);
                   }
                                   else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
                  
                                   Rectangle square= createSquare();
                   Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                          text.setFont(new Font(10));
                          l1.setTextFill(Color.BLACK);
                                    
                   gridPane.add(square, col1, row);
                              gridPane.add(text, col1, row);
                              
                  
                   }
                                   else {
                       Rectangle square= createSquare();
                       gridPane.add(square,col1,row);
                       }
                   }
                  
                   }
              
               Rectangle rectangle = new Rectangle(160, 150, Color.DARKGRAY);
               Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Explorer" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                     //  Text text = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                      text.setFont(Font.font("Arial", 14));
                      text.setFill(Color.BLACK);
                   gameLayout.setAlignment(Pos.TOP_RIGHT);
                      rectangle.setTranslateY(-10);
                   double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                      double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                      text.relocate(textX, textY);
                  gameLayout.getChildren().add(rectangle);
                   gameLayout.getChildren().add(text);
                   
                              
                  
                   menuBar= new MenuBar();
                   fileMenu= new Menu("Select Zombie");
                   fileMenu2 = new Menu ("Select HeroTarget");
               fileMenu3 = new Menu ("Pick a Hero");
              fileMenu4 = new Menu ("View Heroes Details");
               fileMenu.setStyle("-fx-text-fill: white;");
               fileMenu2.setStyle("-fx-text-fill: white;");
               fileMenu3.setStyle("-fx-text-fill: white;");
               fileMenu4.setStyle("-fx-text-fill: white;");
                   menuBar.setPrefWidth(50);
                   menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                   for(int i=0; i<Game.zombies.size();i++){
                    MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                    fileMenu.getItems().add(openMenuItem);
                    int x=i;
                    openMenuItem.setOnAction(event2->{
                    currentHero.setTarget(Game.zombies.get(x));
                    System.out.println(currentHero.getTarget());
                    });
                   }
                   for(int i=0; i<Game.heroes.size();i++){
                    MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                    fileMenu3.getItems().add(openMenuItem);
                    int x=i;
                    openMenuItem.setOnAction(event2->{
                    currentHero = Game.heroes.get(x);
                    
                    });
                   }
                   for(int i=0; i<Game.heroes.size();i++){
                    MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                    fileMenu2.getItems().add(openMenuItem);
                    int x=i;
                    openMenuItem.setOnAction(event2->{
                    currentHero.setTarget(Game.heroes.get(x));
                    System.out.println(currentHero.getTarget());
                    });
                   }
                   for(int i=0; i<Game.heroes.size();i++){
           			 if(Game.heroes.get(i) instanceof Fighter) {
        				  type = "Fighter";

        			 }
        			 else if(Game.heroes.get(i) instanceof Medic) {
        				 type = "Medic";

        			 }
        			 else {
        				type = "Explorer";
        			 }
           			 
           			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
           			 fileMenu4.getItems().add(openMenuItem);
        	            

        			 	
        		 }	
                   
                  
                
                   menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                   gameLayout.getChildren().add(menuBar);
                  
                       if(Game.checkWin()){
                       	Alert win = new Alert(Alert.AlertType.INFORMATION);
       		             win.setTitle("All done!");
       		             win.setHeaderText("Close game");
       		             win.setContentText("This is an alert.");
       		             win.showAndWait().ifPresent(response -> {
       		                 if (response == ButtonType.OK) {
       		                     primaryStage.close();
       		                 }
       		             });
       		             win.setOnCloseRequest(close -> {
       		                 // Change the scene when the alert is closed
       		                 

       		                 primaryStage.close();
       		             });
              
                       }
                       if(Game.checkGameOver()){
                       	Alert lose = new Alert(Alert.AlertType.INFORMATION);
       		             lose.setTitle("You lost");
       		             lose.setHeaderText("Close game");
       		             lose.setContentText("This is an alert.");
       		             lose.showAndWait().ifPresent(response -> {
       		                 if (response == ButtonType.OK) {
       		                     primaryStage.close();
       		                 }
       		             });
       		             lose.setOnCloseRequest(close -> {
       		                 // Change the scene when the alert is closed
       		                 

       		                 primaryStage.close();
       		             });
                       }
                      
                      
               } catch (NotEnoughActionsException e) {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Insufficient Actions");
             alert.setContentText(e.getMessage());
             alert.showAndWait();
             }

               catch (MovementException e) {
             	    Alert alert = new Alert(Alert.AlertType.INFORMATION);
             	    alert.setTitle("Invalid Movement");
             	    
             	    alert.setContentText(e.getMessage());
             	    alert.showAndWait();
             	    }
             	    }
             
                        });
                   
                    
                    
                   
                    
                    
                    attack.setOnAction(event2 -> {
                 	   
                     try {

                        

                         currentHero.attack();
                      

                         for(int row=0;row<GRID_SIZE;row++){
                             int rowMap=14-row;
                             	for(int col1 =0;col1<GRID_SIZE;col1++){
                            
                           
                            
                                             if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                                             Rectangle square= createSquare();
                                 gridPane.add(square,col1,row);
                                             ImageView jImageView = new ImageView(joel);
                         jImageView.setFitWidth(50);  
                         jImageView.setFitHeight(50);
                             gridPane.add(jImageView, col1, row);

                             }
                                             else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
                             Rectangle square= createSquare();
                                 gridPane.add(square,col1,row);
                             ImageView vaccineIV = new ImageView(vaccine);
                             vaccineIV.setFitWidth(50);  
                                         vaccineIV.setFitHeight(50);
                             gridPane.add(vaccineIV, col1, row);
                             }
                                             else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
                             Rectangle square= createSquare();
                                 gridPane.add(square,col1,row);
                             ImageView supplyIV = new ImageView(supply);
                             supplyIV.setFitWidth(50);  
                                         supplyIV.setFitHeight(50);
                             gridPane.add(supplyIV, col1, row);
                             }
                                             else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
                            
                                             Rectangle square= createSquare();
                             Label text2 = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                                    text2.setFont(new Font(10));
                                    l1.setTextFill(Color.BLACK);
                                              
                             gridPane.add(square, col1, row);
                                        gridPane.add(text2, col1, row);
                                        
                            
                             }
                                             else {
                                 Rectangle square= createSquare();
                                 gridPane.add(square,col1,row);
                                 }
                             }
                            
                             }

                   
                     
                    Rectangle rectangle2 = new Rectangle(160, 150, Color.DARKGRAY);
                    Text text2 = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Explorer" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                    // Text text2 = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                         text2.setFont(Font.font("Arial", 14));
                         text2.setFill(Color.BLACK);
                         gameLayout.setAlignment(Pos.TOP_RIGHT);

                         rectangle2.setTranslateY(-10);
                        
                    
                     double textX2 = rectangle2.getX() + (rectangle2.getWidth() - text2.getLayoutBounds().getWidth()) / 2;
                         double textY2= rectangle2.getY() + (rectangle2.getHeight() + text2.getLayoutBounds().getHeight()) / 2;
                         text2.relocate(textX2, textY2);
                     gameLayout.getChildren().add(rectangle2);
                     gameLayout.getChildren().add(text2);
                     
                     
                     
                     menuBar= new MenuBar();
                     fileMenu= new Menu("Select Zombie");
                     fileMenu2 = new Menu ("Select HeroTarget");
                 fileMenu3 = new Menu ("Pick a Hero");
                fileMenu4 = new Menu ("View Heroes Details");
                 fileMenu.setStyle("-fx-text-fill: white;");
                 fileMenu2.setStyle("-fx-text-fill: white;");
                 fileMenu3.setStyle("-fx-text-fill: white;");
                 fileMenu4.setStyle("-fx-text-fill: white;");
                     menuBar.setPrefWidth(50);
                     menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                     for(int i=0; i<Game.zombies.size();i++){
                      MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                      fileMenu.getItems().add(openMenuItem);
                      int x=i;
                      openMenuItem.setOnAction(event3->{
                      currentHero.setTarget(Game.zombies.get(x));
                      System.out.println(currentHero.getTarget());
                      });
                     }
                     for(int i=0; i<Game.heroes.size();i++){
                      MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                      fileMenu3.getItems().add(openMenuItem);
                      int x=i;
                      openMenuItem.setOnAction(event3->{
                      currentHero = Game.heroes.get(x);
                      
                      });
                     }
                     for(int i=0; i<Game.heroes.size();i++){
                      MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                      fileMenu2.getItems().add(openMenuItem);
                      int x=i;
                      openMenuItem.setOnAction(event3->{
                      currentHero.setTarget(Game.heroes.get(x));
                      System.out.println(currentHero.getTarget());
                      });
                     }
                     for(int i=0; i<Game.heroes.size();i++){
             			 if(Game.heroes.get(i) instanceof Fighter) {
          				  type = "Fighter";

          			 }
          			 else if(Game.heroes.get(i) instanceof Medic) {
          				 type = "Medic";

          			 }
          			 else {
          				type = "Explorer";
          			 }
             			 
             			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
             			 fileMenu4.getItems().add(openMenuItem);
          	            

          			 	
          		 }	
                     
                    
                  
                     menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                     gameLayout.getChildren().add(menuBar);
                     
                    
                     if(Game.checkWin()){
                     	Alert win = new Alert(Alert.AlertType.INFORMATION);
     		             win.setTitle("All done!");
     		             win.setHeaderText("Close game");
     		             win.setContentText("This is an alert.");
     		             win.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             win.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
            
                     }
                     if(Game.checkGameOver()){
                     	Alert lose = new Alert(Alert.AlertType.INFORMATION);
     		             lose.setTitle("You lost");
     		             lose.setHeaderText("Close game");
     		             lose.setContentText("This is an alert.");
     		             lose.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             lose.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
                     }
                     
            
             } catch (NotEnoughActionsException e) {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Insufficient Actions");
             alert.setContentText(e.getMessage());
         alert.showAndWait();

             } catch (InvalidTargetException e) {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Invalid Target");
             alert.setContentText(e.getMessage());
         alert.showAndWait();

             }
                    });
                    
                    
                    
                    cure.setOnMouseClicked(new EventHandler< Event >(){

         @Override
         public void handle(Event arg0) {
         try {
         currentHero.cure();
         for(int row=0;row<GRID_SIZE;row++){
             int rowMap=14-row;
             	for(int col1 =0;col1<GRID_SIZE;col1++){
            
           
            
                             if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                             ImageView jImageView = new ImageView(joel);
         jImageView.setFitWidth(50);  
         jImageView.setFitHeight(50);
             gridPane.add(jImageView, col1, row);

             }
                             else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView vaccineIV = new ImageView(vaccine);
             vaccineIV.setFitWidth(50);  
                         vaccineIV.setFitHeight(50);
             gridPane.add(vaccineIV, col1, row);
             }
                             else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView supplyIV = new ImageView(supply);
             supplyIV.setFitWidth(50);  
                         supplyIV.setFitHeight(50);
             gridPane.add(supplyIV, col1, row);
             }
                             else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
            
                             Rectangle square= createSquare();
             Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                    text.setFont(new Font(10));
                    l1.setTextFill(Color.BLACK);
                              
             gridPane.add(square, col1, row);
                        gridPane.add(text, col1, row);
                        
            
             }
                             else {
                 Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                 }
             }
            
             }
         
         
         Rectangle rectangle = new Rectangle(160, 120, Color.DARKGRAY);
         Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Explorer" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                  // Text text = new Text("\n" + Game.heroes.get(Game.heroes.size()-1).getName() + "\nCurrent Hp: " + Game.heroes.get(Game.heroes.size()-1).getCurrentHp() + "\nActions available: " +  Game.heroes.get(Game.heroes.size()-1).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(Game.heroes.size()-1).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                    text.setFont(Font.font("Arial", 14));
                    text.setFill(Color.BLACK);
                 gameLayout.setAlignment(Pos.TOP_RIGHT);
                    rectangle.setTranslateY(-10);
                 double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                    double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                    text.relocate(textX, textY);
                gameLayout.getChildren().add(rectangle);
                 gameLayout.getChildren().add(text);
                 
                 
                 
                 menuBar= new MenuBar();
                 fileMenu= new Menu("Select Zombie");
                 fileMenu2 = new Menu ("Select HeroTarget");
             fileMenu3 = new Menu ("Pick a Hero");
            fileMenu4 = new Menu ("View Heroes Details");
             fileMenu.setStyle("-fx-text-fill: white;");
             fileMenu2.setStyle("-fx-text-fill: white;");
             fileMenu3.setStyle("-fx-text-fill: white;");
             fileMenu4.setStyle("-fx-text-fill: white;");
                 menuBar.setPrefWidth(50);
                 menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                 for(int i=0; i<Game.zombies.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                  fileMenu.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero.setTarget(Game.zombies.get(x));
                  System.out.println(currentHero.getTarget());
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                  fileMenu3.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero = Game.heroes.get(x);
                  
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                  fileMenu2.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero.setTarget(Game.heroes.get(x));
                  System.out.println(currentHero.getTarget());
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
         			 if(Game.heroes.get(i) instanceof Fighter) {
      				  type = "Fighter";

      			 }
      			 else if(Game.heroes.get(i) instanceof Medic) {
      				 type = "Medic";

      			 }
      			 else {
      				type = "Explorer";
      			 }
         			 
         			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
         			 fileMenu4.getItems().add(openMenuItem);
      	            

      			 	
      		 }	
                 
                
              
                 menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                 gameLayout.getChildren().add(menuBar);
                    
                    
                
                     if(Game.checkWin()){
                     	Alert win = new Alert(Alert.AlertType.INFORMATION);
     		             win.setTitle("All done!");
     		             win.setHeaderText("Close game");
     		             win.setContentText("This is an alert.");
     		             win.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             win.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
            
                     }
                     if(Game.checkGameOver()){
                     	Alert lose = new Alert(Alert.AlertType.INFORMATION);
     		             lose.setTitle("You lost");
     		             lose.setHeaderText("Close game");
     		             lose.setContentText("This is an alert.");
     		             lose.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             lose.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
                     }
                     
                               
         } catch (NoAvailableResourcesException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Insufficient resources");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         } catch (InvalidTargetException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Invalid Target");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         } catch (NotEnoughActionsException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Insufficient Actions");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         }
         }
                  
                    });
                    
                    
                    
                    endTurn.setOnMouseClicked(new EventHandler<Event>(){

         @Override
         public void handle(Event event3) {
         try {
         Game.endTurn();

         if(Game.checkWin()){
         	Alert win = new Alert(Alert.AlertType.INFORMATION);
              win.setTitle("All done!");
              win.setHeaderText("Close game");
              win.setContentText("This is an alert.");
              win.showAndWait().ifPresent(response -> {
                  if (response == ButtonType.OK) {
                      primaryStage.close();
                  }
              });
              win.setOnCloseRequest(close -> {
                  // Change the scene when the alert is closed
                  

                  primaryStage.close();
              });

         }
         if(Game.checkGameOver()){
         	Alert lose = new Alert(Alert.AlertType.INFORMATION);
              lose.setTitle("You lost");
              lose.setHeaderText("Close game");
              lose.setContentText("This is an alert.");
              lose.showAndWait().ifPresent(response -> {
                  if (response == ButtonType.OK) {
                      primaryStage.close();
                  }
              });
              lose.setOnCloseRequest(close -> {
                  // Change the scene when the alert is closed
                  

                  primaryStage.close();
              });
         }

         for(int row=0;row<GRID_SIZE;row++){
             int rowMap=14-row;
             	for(int col1 =0;col1<GRID_SIZE;col1++){
            
           
            
                             if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                             ImageView jImageView = new ImageView(joel);
         jImageView.setFitWidth(50);  
         jImageView.setFitHeight(50);
             gridPane.add(jImageView, col1, row);

             }
                             else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView vaccineIV = new ImageView(vaccine);
             vaccineIV.setFitWidth(50);  
                         vaccineIV.setFitHeight(50);
             gridPane.add(vaccineIV, col1, row);
             }
                             else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView supplyIV = new ImageView(supply);
             supplyIV.setFitWidth(50);  
                         supplyIV.setFitHeight(50);
             gridPane.add(supplyIV, col1, row);
             }
                             else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
            
                             Rectangle square= createSquare();
             Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                    text.setFont(new Font(10));
                    l1.setTextFill(Color.BLACK);
                              
             gridPane.add(square, col1, row);
                        gridPane.add(text, col1, row);
                        
            
             }
                             else {
                 Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                 }
             }
            
             }
         Rectangle rectangle = new Rectangle(160, 120, Color.DARKGRAY);
         Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Explorer" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                   //Text text = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                    text.setFont(Font.font("Arial", 14));
                    text.setFill(Color.BLACK);
                 gameLayout.setAlignment(Pos.TOP_RIGHT);
                    rectangle.setTranslateY(-10);
                 double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                    double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                    text.relocate(textX, textY);
                gameLayout.getChildren().add(rectangle);
                 gameLayout.getChildren().add(text);
                 
                 
                 
                 menuBar= new MenuBar();
                 fileMenu= new Menu("Select Zombie");
                 fileMenu2 = new Menu ("Select HeroTarget");
             fileMenu3 = new Menu ("Pick a Hero");
            fileMenu4 = new Menu ("View Heroes Details");
             fileMenu.setStyle("-fx-text-fill: white;");
             fileMenu2.setStyle("-fx-text-fill: white;");
             fileMenu3.setStyle("-fx-text-fill: white;");
             fileMenu4.setStyle("-fx-text-fill: white;");
                 menuBar.setPrefWidth(50);
                 menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                 for(int i=0; i<Game.zombies.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                  fileMenu.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero.setTarget(Game.zombies.get(x));
                  System.out.println(currentHero.getTarget());
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                  fileMenu3.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero = Game.heroes.get(x);
                  
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                  fileMenu2.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero.setTarget(Game.heroes.get(x));
                  System.out.println(currentHero.getTarget());
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
         			 if(Game.heroes.get(i) instanceof Fighter) {
      				  type = "Fighter";

      			 }
      			 else if(Game.heroes.get(i) instanceof Medic) {
      				 type = "Medic";

      			 }
      			 else {
      				type = "Explorer";
      			 }
         			 
         			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
         			 fileMenu4.getItems().add(openMenuItem);
      	            

      			 	
      		 }	
                 
                
              
                 menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                 gameLayout.getChildren().add(menuBar);
                     
                    
         } catch (NotEnoughActionsException e) {

         } catch (InvalidTargetException e) {

         }
         }
                  
                    });
                    
                    useSpecial.setOnMouseClicked(new EventHandler< Event >(){

         @Override
         public void handle(Event event) {
         try {
         currentHero.useSpecial();
         for(int row=0;row<GRID_SIZE;row++){
             int rowMap=14-row;
             	for(int col1 =0;col1<GRID_SIZE;col1++){
            
           
            
                             if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                             ImageView jImageView = new ImageView(joel);
         jImageView.setFitWidth(50);  
         jImageView.setFitHeight(50);
             gridPane.add(jImageView, col1, row);

             }
                             else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView vaccineIV = new ImageView(vaccine);
             vaccineIV.setFitWidth(50);  
                         vaccineIV.setFitHeight(50);
             gridPane.add(vaccineIV, col1, row);
             }
                             else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView supplyIV = new ImageView(supply);
             supplyIV.setFitWidth(50);  
                         supplyIV.setFitHeight(50);
             gridPane.add(supplyIV, col1, row);
             }
                             else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
            
                             Rectangle square= createSquare();
             Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                    text.setFont(new Font(10));
                    l1.setTextFill(Color.BLACK);
                              
             gridPane.add(square, col1, row);
                        gridPane.add(text, col1, row);
                        
            
             }
                             else {
                 Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                 }
             }
            
             }
         Rectangle rectangle = new Rectangle(160, 120, Color.DARKGRAY);
         Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Explorer" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                  // Text text = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                    text.setFont(Font.font("Arial", 14));
                    text.setFill(Color.BLACK);
                 gameLayout.setAlignment(Pos.TOP_RIGHT);
                    rectangle.setTranslateY(-10);
                 double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                    double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                    text.relocate(textX, textY);
                gameLayout.getChildren().add(rectangle);
                gameLayout.getChildren().add(text);

                menuBar= new MenuBar();
                fileMenu= new Menu("Select Zombie");
                fileMenu2 = new Menu ("Select HeroTarget");
            fileMenu3 = new Menu ("Pick a Hero");
           fileMenu4 = new Menu ("View Heroes Details");
            fileMenu.setStyle("-fx-text-fill: white;");
            fileMenu2.setStyle("-fx-text-fill: white;");
            fileMenu3.setStyle("-fx-text-fill: white;");
            fileMenu4.setStyle("-fx-text-fill: white;");
                menuBar.setPrefWidth(50);
                menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                for(int i=0; i<Game.zombies.size();i++){
                 MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                 fileMenu.getItems().add(openMenuItem);
                 int x=i;
                 openMenuItem.setOnAction(event2->{
                 currentHero.setTarget(Game.zombies.get(x));
                 System.out.println(currentHero.getTarget());
                 });
                }
                for(int i=0; i<Game.heroes.size();i++){
                 MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                 fileMenu3.getItems().add(openMenuItem);
                 int x=i;
                 openMenuItem.setOnAction(event2->{
                 currentHero = Game.heroes.get(x);
                 
                 });
                }
                for(int i=0; i<Game.heroes.size();i++){
                 MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                 fileMenu2.getItems().add(openMenuItem);
                 int x=i;
                 openMenuItem.setOnAction(event2->{
                 currentHero.setTarget(Game.heroes.get(x));
                 System.out.println(currentHero.getTarget());
                 });
                }
                for(int i=0; i<Game.heroes.size();i++){
        			 if(Game.heroes.get(i) instanceof Fighter) {
     				  type = "Fighter";

     			 }
     			 else if(Game.heroes.get(i) instanceof Medic) {
     				 type = "Medic";

     			 }
     			 else {
     				type = "Explorer";
     			 }
        			 
        			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
        			 fileMenu4.getItems().add(openMenuItem);
     	            

     			 	
     		 }	
                
               
             
                menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                gameLayout.getChildren().add(menuBar);
                    
                     if(Game.checkWin()){
                     	Alert win = new Alert(Alert.AlertType.INFORMATION);
     		             win.setTitle("All done!");
     		             win.setHeaderText("Close game");
     		             win.setContentText("This is an alert.");
     		             win.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             win.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
            
                     }
                     if(Game.checkGameOver()){
                     	Alert lose = new Alert(Alert.AlertType.INFORMATION);
     		             lose.setTitle("You lost");
     		             lose.setHeaderText("Close game");
     		             lose.setContentText("This is an alert.");
     		             lose.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             lose.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
                     }
                    
          
         } catch (NoAvailableResourcesException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Insufficient Supply");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         } catch (InvalidTargetException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Invalid Target");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         }

         }});
            

                 game = new Scene(gameLayout, 1470, 800);
               primaryStage.setScene(game);

                

                 });
         	
        b5.setOnAction(event -> {
        	 currentHero = Game.availableHeroes.get(4);
             Game.startGame(currentHero);
            
            
             gridPane.setAlignment(Pos.CENTER);
             
             for(int row=0;row<GRID_SIZE;row++){
             int rowMap=14-row;
             	for(int col1 =0;col1<GRID_SIZE;col1++){
            
           
            
                             if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                             ImageView jImageView = new ImageView(joel);
         jImageView.setFitWidth(50);  
         jImageView.setFitHeight(50);
             gridPane.add(jImageView, col1, row);

             }
                             else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView vaccineIV = new ImageView(vaccine);
             vaccineIV.setFitWidth(50);  
                         vaccineIV.setFitHeight(50);
             gridPane.add(vaccineIV, col1, row);
             }
                             else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView supplyIV = new ImageView(supply);
             supplyIV.setFitWidth(50);  
                         supplyIV.setFitHeight(50);
             gridPane.add(supplyIV, col1, row);
             }
                             else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
            
                             Rectangle square= createSquare();
             Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                    text.setFont(new Font(10));
                    l1.setTextFill(Color.BLACK);
                              
             gridPane.add(square, col1, row);
                        gridPane.add(text, col1, row);
                        
            
             }
                             else {
                 Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                 }
             }
            
             }

                  
             gameLayout.getChildren().add(gridPane);
                
                    
                      
                      gameLayout.setStyle("-fx-background-color: #000000;");
              
                    
              
                 Rectangle rectangle = new Rectangle(160, 150, Color.DARKGRAY);
                 Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Explorer" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                      text.setFont(Font.font("Arial", 14));
                      text.setFill(Color.BLACK);
                      
                    


                   gameLayout.setAlignment(Pos.TOP_RIGHT);


                     rectangle.setTranslateY(-10);

                
                 double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                     double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                    
                     text.relocate(textX, textY);
                     
                     
                 

                 
                 gameLayout.getChildren().addAll(rectangle,text);
                 

                
                     Button up = new Button("↑");
                     Button down = new Button("↓");
                 Button left = new Button("←");
                 Button right = new Button("→");
                    
                    
                     Button attack = new Button("ATTACK");
                     Button cure = new Button("CURE");
                     Button useSpecial = new Button("USE SPECIAL");
                     Button endTurn = new Button("END TURN");
                     

                    
                    
                     menuBar= new MenuBar();
                     fileMenu= new Menu("Select Zombie");
                     fileMenu2 = new Menu ("Select HeroTarget");
                 fileMenu3 = new Menu ("Pick a Hero");
                fileMenu4 = new Menu ("View Heroes Details");
                 fileMenu.setStyle("-fx-text-fill: white;");
                 fileMenu2.setStyle("-fx-text-fill: white;");
                 fileMenu3.setStyle("-fx-text-fill: white;");
                 fileMenu4.setStyle("-fx-text-fill: white;");
                     menuBar.setPrefWidth(50);
                     menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                     for(int i=0; i<Game.zombies.size();i++){
                      MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                      fileMenu.getItems().add(openMenuItem);
                      int x=i;
                      openMenuItem.setOnAction(event2->{
                      currentHero.setTarget(Game.zombies.get(x));
                      System.out.println(currentHero.getTarget());
                      });
                     }
                     for(int i=0; i<Game.heroes.size();i++){
                      MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                      fileMenu3.getItems().add(openMenuItem);
                      int x=i;
                      openMenuItem.setOnAction(event2->{
                      currentHero = Game.heroes.get(x);
                      
                      });
                     }
                     for(int i=0; i<Game.heroes.size();i++){
                      MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                      fileMenu2.getItems().add(openMenuItem);
                      int x=i;
                      openMenuItem.setOnAction(event2->{
                      currentHero.setTarget(Game.heroes.get(x));
                      System.out.println(currentHero.getTarget());
                      });
                     }
                     for(int i=0; i<Game.heroes.size();i++){
             			 if(Game.heroes.get(i) instanceof Fighter) {
          				  type = "Fighter";

          			 }
          			 else if(Game.heroes.get(i) instanceof Medic) {
          				 type = "Medic";

          			 }
          			 else {
          				type = "Explorer";
          			 }
             			 
             			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
             			 fileMenu4.getItems().add(openMenuItem);
          	            

          			 	
          		 }	
                     
                    
                  
                     menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                     gameLayout.getChildren().add(menuBar);
                    
                    
                    
                    
                     if(Game.checkWin()){
                     	Alert win = new Alert(Alert.AlertType.INFORMATION);
     		             win.setTitle("All done!");
     		             win.setHeaderText("Close game");
     		             win.setContentText("This is an alert.");
     		             win.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             win.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
            
                     }
                     if(Game.checkGameOver()){
                     	Alert lose = new Alert(Alert.AlertType.INFORMATION);
     		             lose.setTitle("You lost");
     		             lose.setHeaderText("Close game");
     		             lose.setContentText("This is an alert.");
     		             lose.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             lose.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
                     }
                    

                    
                     VBox buttonsBox = new VBox();              
                     buttonsBox.getChildren().addAll(menuBar,up,down,left,right,attack,cure,useSpecial, endTurn);
                     
                     
                     
                     
                     gameLayout.getChildren().add(buttonsBox);
                     buttonsBox.setAlignment(Pos.TOP_LEFT);
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    


                    up.setOnMouseClicked(new EventHandler<Event>() {  
         public void handle(Event event) {
         try {
         col = (int) currentHero.getLocation().getY();
                 xloc = (int) (15 -1 - currentHero.getLocation().getX());
                 if(Game.map[((int)currentHero.getLocation().getX()) + 1][(int) currentHero.getLocation().getY()]instanceof TrapCell) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Warning");
         alert.setContentText("You have entered a trap cell!");
         alert.showAndWait();
                 }
         currentHero.move(Direction.UP);
         for(int row=0;row<GRID_SIZE;row++){
             int rowMap=14-row;
             	for(int col1 =0;col1<GRID_SIZE;col1++){
            
           
            
                             if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                             ImageView jImageView = new ImageView(joel);
         jImageView.setFitWidth(50);  
         jImageView.setFitHeight(50);
             gridPane.add(jImageView, col1, row);

             }
                             else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView vaccineIV = new ImageView(vaccine);
             vaccineIV.setFitWidth(50);  
                         vaccineIV.setFitHeight(50);
             gridPane.add(vaccineIV, col1, row);
             }
                             else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView supplyIV = new ImageView(supply);
             supplyIV.setFitWidth(50);  
                         supplyIV.setFitHeight(50);
             gridPane.add(supplyIV, col1, row);
             }
                             else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
            
                             Rectangle square= createSquare();
             Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                    text.setFont(new Font(10));
                    l1.setTextFill(Color.BLACK);
                              
             gridPane.add(square, col1, row);
                        gridPane.add(text, col1, row);
                        
            
             }
                             else {
                 Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                 }
             }
            
             }
         Rectangle rectangle = new Rectangle(160, 150, Color.DARKGRAY);
         Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Explorer" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                     text.setFont(Font.font("Arial", 14));
                     text.setFill(Color.BLACK);
                 gameLayout.setAlignment(Pos.TOP_RIGHT);
                    rectangle.setTranslateY(-10);
                 double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                    double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                    text.relocate(textX, textY);
                gameLayout.getChildren().add(rectangle);
                 gameLayout.getChildren().add(text);
                 
                 
                 

          	
     		 	

                 
                 menuBar= new MenuBar();
                 fileMenu= new Menu("Select Zombie");
                 fileMenu2 = new Menu ("Select HeroTarget");
             fileMenu3 = new Menu ("Pick a Hero");
            fileMenu4 = new Menu ("View Heroes Details");
             fileMenu.setStyle("-fx-text-fill: white;");
             fileMenu2.setStyle("-fx-text-fill: white;");
             fileMenu3.setStyle("-fx-text-fill: white;");
             fileMenu4.setStyle("-fx-text-fill: white;");
                 menuBar.setPrefWidth(50);
                 menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                 for(int i=0; i<Game.zombies.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                  fileMenu.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero.setTarget(Game.zombies.get(x));
                  System.out.println(currentHero.getTarget());
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                  fileMenu3.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero = Game.heroes.get(x);
                  
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                  fileMenu2.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero.setTarget(Game.heroes.get(x));
                  System.out.println(currentHero.getTarget());
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
         			 if(Game.heroes.get(i) instanceof Fighter) {
      				  type = "Fighter";

      			 }
      			 else if(Game.heroes.get(i) instanceof Medic) {
      				 type = "Medic";

      			 }
      			 else {
      				type = "Explorer";
      			 }
         			 
         			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
         			 fileMenu4.getItems().add(openMenuItem);
      	            

      			 	
      		 }	
                 
                
              
                 menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                 gameLayout.getChildren().add(menuBar);

                    
                    


                     if(Game.checkWin()){
                     	Alert win = new Alert(Alert.AlertType.INFORMATION);
     		             win.setTitle("All done!");
     		             win.setHeaderText("Close game");
     		             win.setContentText("This is an alert.");
     		             win.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             win.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
            
                     }
                     if(Game.checkGameOver()){
                     	Alert lose = new Alert(Alert.AlertType.INFORMATION);
     		             lose.setTitle("You lost");
     		             lose.setHeaderText("Close game");
     		             lose.setContentText("This is an alert.");
     		             lose.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             lose.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
                     }
                     
                    
                               

         }
         catch (NotEnoughActionsException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Insufficient Actions");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         }

         catch (MovementException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Invalid Movement");
         
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         }
         }
         
                    });
                    down.setOnMouseClicked(new EventHandler<Event>() {
                  
             @Override
             public void handle(Event event) {
             try {
             col = (int) currentHero.getLocation().getY();
                     xloc = (int) (15 -1 - currentHero.getLocation().getX());
                     if(Game.map[((int)currentHero.getLocation().getX()) - 1][(int) currentHero.getLocation().getY()]instanceof TrapCell) {
                     Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Warning");
         alert.setContentText("You have entered a trap cell!");
         alert.showAndWait();
                     }
                    
                    
                     currentHero.move(Direction.DOWN);
                     for(int row=0;row<GRID_SIZE;row++){
                         int rowMap=14-row;
                         	for(int col1 =0;col1<GRID_SIZE;col1++){
                        
                       
                        
                                         if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                                         Rectangle square= createSquare();
                             gridPane.add(square,col1,row);
                                         ImageView jImageView = new ImageView(joel);
                     jImageView.setFitWidth(50);  
                     jImageView.setFitHeight(50);
                         gridPane.add(jImageView, col1, row);

                         }
                                         else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
                         Rectangle square= createSquare();
                             gridPane.add(square,col1,row);
                         ImageView vaccineIV = new ImageView(vaccine);
                         vaccineIV.setFitWidth(50);  
                                     vaccineIV.setFitHeight(50);
                         gridPane.add(vaccineIV, col1, row);
                         }
                                         else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
                         Rectangle square= createSquare();
                             gridPane.add(square,col1,row);
                         ImageView supplyIV = new ImageView(supply);
                         supplyIV.setFitWidth(50);  
                                     supplyIV.setFitHeight(50);
                         gridPane.add(supplyIV, col1, row);
                         }
                                         else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
                        
                                         Rectangle square= createSquare();
                         Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                                text.setFont(new Font(10));
                                l1.setTextFill(Color.BLACK);
                                          
                         gridPane.add(square, col1, row);
                                    gridPane.add(text, col1, row);
                                    
                        
                         }
                                         else {
                             Rectangle square= createSquare();
                             gridPane.add(square,col1,row);
                             }
                         }
                        
                         }
             Rectangle rectangle = new Rectangle(160, 150, Color.DARKGRAY);
             Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Explorer" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
             //Text text = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                          text.setFont(Font.font("Arial", 14));
                          text.setFill(Color.BLACK);
                       gameLayout.setAlignment(Pos.TOP_RIGHT);
                          rectangle.setTranslateY(-10);
                       double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                          double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                          text.relocate(textX, textY);
                      gameLayout.getChildren().add(rectangle);
                       gameLayout.getChildren().add(text);
                       
                                         
                       
                       menuBar= new MenuBar();
                       fileMenu= new Menu("Select Zombie");
                       fileMenu2 = new Menu ("Select HeroTarget");
                   fileMenu3 = new Menu ("Pick a Hero");
                  fileMenu4 = new Menu ("View Heroes Details");
                   fileMenu.setStyle("-fx-text-fill: white;");
                   fileMenu2.setStyle("-fx-text-fill: white;");
                   fileMenu3.setStyle("-fx-text-fill: white;");
                   fileMenu4.setStyle("-fx-text-fill: white;");
                       menuBar.setPrefWidth(50);
                       menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                       for(int i=0; i<Game.zombies.size();i++){
                        MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                        fileMenu.getItems().add(openMenuItem);
                        int x=i;
                        openMenuItem.setOnAction(event2->{
                        currentHero.setTarget(Game.zombies.get(x));
                        System.out.println(currentHero.getTarget());
                        });
                       }
                       for(int i=0; i<Game.heroes.size();i++){
                        MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                        fileMenu3.getItems().add(openMenuItem);
                        int x=i;
                        openMenuItem.setOnAction(event2->{
                        currentHero = Game.heroes.get(x);
                        
                        });
                       }
                       for(int i=0; i<Game.heroes.size();i++){
                        MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                        fileMenu2.getItems().add(openMenuItem);
                        int x=i;
                        openMenuItem.setOnAction(event2->{
                        currentHero.setTarget(Game.heroes.get(x));
                        System.out.println(currentHero.getTarget());
                        });
                       }
                       for(int i=0; i<Game.heroes.size();i++){
               			 if(Game.heroes.get(i) instanceof Fighter) {
            				  type = "Fighter";

            			 }
            			 else if(Game.heroes.get(i) instanceof Medic) {
            				 type = "Medic";

            			 }
            			 else {
            				type = "Explorer";
            			 }
               			 
               			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
               			 fileMenu4.getItems().add(openMenuItem);
            	            

            			 	
            		 }	
                       
                      
                    
                       menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                       gameLayout.getChildren().add(menuBar);
                        
                       if(Game.checkWin()){
                         	Alert win = new Alert(Alert.AlertType.INFORMATION);
         		             win.setTitle("All done!");
         		             win.setHeaderText("Close game");
         		             win.setContentText("This is an alert.");
         		             win.showAndWait().ifPresent(response -> {
         		                 if (response == ButtonType.OK) {
         		                     primaryStage.close();
         		                 }
         		             });
         		             win.setOnCloseRequest(close -> {
         		                 // Change the scene when the alert is closed
         		                 

         		                 primaryStage.close();
         		             });
                
                         }
                         if(Game.checkGameOver()){
                         	Alert lose = new Alert(Alert.AlertType.INFORMATION);
         		             lose.setTitle("You lost");
         		             lose.setHeaderText("Close game");
         		             lose.setContentText("This is an alert.");
         		             lose.showAndWait().ifPresent(response -> {
         		                 if (response == ButtonType.OK) {
         		                     primaryStage.close();
         		                 }
         		             });
         		             lose.setOnCloseRequest(close -> {
         		                 // Change the scene when the alert is closed
         		                 

         		                 primaryStage.close();
         		             });
                         }
                         
                        
                          
                    
             } catch (NotEnoughActionsException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Insufficient Actions");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         }

         catch (MovementException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Invalid Movement");
         alert.setContentText(e.getMessage());
         alert.showAndWait();

         }
         }
                      
                      
                 });

                    left.setOnMouseClicked(new EventHandler<Event>() {
                    
               @Override
               public void handle(Event event) {
               try {
               col = (int) currentHero.getLocation().getY();
                       xloc = (int) (15 -1 - currentHero.getLocation().getX());
                      
                       if(Game.map[((int)currentHero.getLocation().getX())][(int) currentHero.getLocation().getY() - 1]instanceof TrapCell) {
                       Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Warning");
             alert.setContentText("You have entered a trap cell!");
             alert.showAndWait();
                       }
                      
                      
                       currentHero.move(Direction.LEFT);
                       for(int row=0;row<GRID_SIZE;row++){
                           int rowMap=14-row;
                           	for(int col1 =0;col1<GRID_SIZE;col1++){
                          
                         
                          
                                           if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                                           Rectangle square= createSquare();
                               gridPane.add(square,col1,row);
                                           ImageView jImageView = new ImageView(joel);
                       jImageView.setFitWidth(50);  
                       jImageView.setFitHeight(50);
                           gridPane.add(jImageView, col1, row);

                           }
                                           else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
                           Rectangle square= createSquare();
                               gridPane.add(square,col1,row);
                           ImageView vaccineIV = new ImageView(vaccine);
                           vaccineIV.setFitWidth(50);  
                                       vaccineIV.setFitHeight(50);
                           gridPane.add(vaccineIV, col1, row);
                           }
                                           else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
                           Rectangle square= createSquare();
                               gridPane.add(square,col1,row);
                           ImageView supplyIV = new ImageView(supply);
                           supplyIV.setFitWidth(50);  
                                       supplyIV.setFitHeight(50);
                           gridPane.add(supplyIV, col1, row);
                           }
                                           else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
                          
                                           Rectangle square= createSquare();
                           Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                                  text.setFont(new Font(10));
                                  l1.setTextFill(Color.BLACK);
                                            
                           gridPane.add(square, col1, row);
                                      gridPane.add(text, col1, row);
                                      
                          
                           }
                                           else {
                               Rectangle square= createSquare();
                               gridPane.add(square,col1,row);
                               }
                           }
                          
                           }
               Rectangle rectangle = new Rectangle(160, 150, Color.DARKGRAY);
               Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Explorer" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                       //Text text = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                          text.setFont(Font.font("Arial", 14));
                          text.setFill(Color.BLACK);
                       gameLayout.setAlignment(Pos.TOP_RIGHT);
                          rectangle.setTranslateY(-10);
                       double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                          double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                          text.relocate(textX, textY);
                      gameLayout.getChildren().add(rectangle);
                       gameLayout.getChildren().add(text);
                       
                       
              
                       menuBar= new MenuBar();
                       fileMenu= new Menu("Select Zombie");
                       fileMenu2 = new Menu ("Select HeroTarget");
                   fileMenu3 = new Menu ("Pick a Hero");
                  fileMenu4 = new Menu ("View Heroes Details");
                   fileMenu.setStyle("-fx-text-fill: white;");
                   fileMenu2.setStyle("-fx-text-fill: white;");
                   fileMenu3.setStyle("-fx-text-fill: white;");
                   fileMenu4.setStyle("-fx-text-fill: white;");
                       menuBar.setPrefWidth(50);
                       menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                       for(int i=0; i<Game.zombies.size();i++){
                        MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                        fileMenu.getItems().add(openMenuItem);
                        int x=i;
                        openMenuItem.setOnAction(event2->{
                        currentHero.setTarget(Game.zombies.get(x));
                        System.out.println(currentHero.getTarget());
                        });
                       }
                       for(int i=0; i<Game.heroes.size();i++){
                        MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                        fileMenu3.getItems().add(openMenuItem);
                        int x=i;
                        openMenuItem.setOnAction(event2->{
                        currentHero = Game.heroes.get(x);
                        
                        });
                       }
                       for(int i=0; i<Game.heroes.size();i++){
                        MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                        fileMenu2.getItems().add(openMenuItem);
                        int x=i;
                        openMenuItem.setOnAction(event2->{
                        currentHero.setTarget(Game.heroes.get(x));
                        System.out.println(currentHero.getTarget());
                        });
                       }
                       for(int i=0; i<Game.heroes.size();i++){
               			 if(Game.heroes.get(i) instanceof Fighter) {
            				  type = "Fighter";

            			 }
            			 else if(Game.heroes.get(i) instanceof Medic) {
            				 type = "Medic";

            			 }
            			 else {
            				type = "Explorer";
            			 }
               			 
               			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
               			 fileMenu4.getItems().add(openMenuItem);
            	            

            			 	
            		 }	
                       
                      
                    
                       menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                       gameLayout.getChildren().add(menuBar);
                           
                           if(Game.checkWin()){
                           	Alert win = new Alert(Alert.AlertType.INFORMATION);
           		             win.setTitle("All done!");
           		             win.setHeaderText("Close game");
           		             win.setContentText("This is an alert.");
           		             win.showAndWait().ifPresent(response -> {
           		                 if (response == ButtonType.OK) {
           		                     primaryStage.close();
           		                 }
           		             });
           		             win.setOnCloseRequest(close -> {
           		                 // Change the scene when the alert is closed
           		                 

           		                 primaryStage.close();
           		             });
                  
                           }
                           if(Game.checkGameOver()){
                           	Alert lose = new Alert(Alert.AlertType.INFORMATION);
           		             lose.setTitle("You lost");
           		             lose.setHeaderText("Close game");
           		             lose.setContentText("This is an alert.");
           		             lose.showAndWait().ifPresent(response -> {
           		                 if (response == ButtonType.OK) {
           		                     primaryStage.close();
           		                 }
           		             });
           		             lose.setOnCloseRequest(close -> {
           		                 // Change the scene when the alert is closed
           		                 

           		                 primaryStage.close();
           		             });
                           }
                          
                      
               } catch (NotEnoughActionsException e) {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Insufficient Actions");
             alert.setContentText(e.getMessage());
             alert.showAndWait();
             }

             catch (MovementException e) {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Invalid Movement");
             alert.setContentText(e.getMessage());
             alert.showAndWait();
            
             }
             }
                        });
                    right.setOnMouseClicked(new EventHandler<Event>() {
                    
               @Override
               public void handle(Event event) {
               try {
               col = (int) currentHero.getLocation().getY();
                       xloc = (int) (15 -1 - currentHero.getLocation().getX());
                         if(Game.map[((int)currentHero.getLocation().getX())][(int) currentHero.getLocation().getY() + 1]instanceof TrapCell) {
                         Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Warning");
             alert.setContentText("You have entered a trap cell");
             alert.showAndWait();
                         }

               currentHero.move(Direction.RIGHT);
               for(int row=0;row<GRID_SIZE;row++){
                   int rowMap=14-row;
                   	for(int col1 =0;col1<GRID_SIZE;col1++){
                  
                 
                  
                                   if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                                   Rectangle square= createSquare();
                       gridPane.add(square,col1,row);
                                   ImageView jImageView = new ImageView(joel);
               jImageView.setFitWidth(50);  
               jImageView.setFitHeight(50);
                   gridPane.add(jImageView, col1, row);

                   }
                                   else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
                   Rectangle square= createSquare();
                       gridPane.add(square,col1,row);
                   ImageView vaccineIV = new ImageView(vaccine);
                   vaccineIV.setFitWidth(50);  
                               vaccineIV.setFitHeight(50);
                   gridPane.add(vaccineIV, col1, row);
                   }
                                   else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
                   Rectangle square= createSquare();
                       gridPane.add(square,col1,row);
                   ImageView supplyIV = new ImageView(supply);
                   supplyIV.setFitWidth(50);  
                               supplyIV.setFitHeight(50);
                   gridPane.add(supplyIV, col1, row);
                   }
                                   else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
                  
                                   Rectangle square= createSquare();
                   Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                          text.setFont(new Font(10));
                          l1.setTextFill(Color.BLACK);
                                    
                   gridPane.add(square, col1, row);
                              gridPane.add(text, col1, row);
                              
                  
                   }
                                   else {
                       Rectangle square= createSquare();
                       gridPane.add(square,col1,row);
                       }
                   }
                  
                   }
              
               Rectangle rectangle = new Rectangle(160, 150, Color.DARKGRAY);
               Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Explorer" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                     //  Text text = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                      text.setFont(Font.font("Arial", 14));
                      text.setFill(Color.BLACK);
                   gameLayout.setAlignment(Pos.TOP_RIGHT);
                      rectangle.setTranslateY(-10);
                   double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                      double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                      text.relocate(textX, textY);
                  gameLayout.getChildren().add(rectangle);
                   gameLayout.getChildren().add(text);
                   
                              
                  
                   menuBar= new MenuBar();
                   fileMenu= new Menu("Select Zombie");
                   fileMenu2 = new Menu ("Select HeroTarget");
               fileMenu3 = new Menu ("Pick a Hero");
              fileMenu4 = new Menu ("View Heroes Details");
               fileMenu.setStyle("-fx-text-fill: white;");
               fileMenu2.setStyle("-fx-text-fill: white;");
               fileMenu3.setStyle("-fx-text-fill: white;");
               fileMenu4.setStyle("-fx-text-fill: white;");
                   menuBar.setPrefWidth(50);
                   menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                   for(int i=0; i<Game.zombies.size();i++){
                    MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                    fileMenu.getItems().add(openMenuItem);
                    int x=i;
                    openMenuItem.setOnAction(event2->{
                    currentHero.setTarget(Game.zombies.get(x));
                    System.out.println(currentHero.getTarget());
                    });
                   }
                   for(int i=0; i<Game.heroes.size();i++){
                    MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                    fileMenu3.getItems().add(openMenuItem);
                    int x=i;
                    openMenuItem.setOnAction(event2->{
                    currentHero = Game.heroes.get(x);
                    
                    });
                   }
                   for(int i=0; i<Game.heroes.size();i++){
                    MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                    fileMenu2.getItems().add(openMenuItem);
                    int x=i;
                    openMenuItem.setOnAction(event2->{
                    currentHero.setTarget(Game.heroes.get(x));
                    System.out.println(currentHero.getTarget());
                    });
                   }
                   for(int i=0; i<Game.heroes.size();i++){
           			 if(Game.heroes.get(i) instanceof Fighter) {
        				  type = "Fighter";

        			 }
        			 else if(Game.heroes.get(i) instanceof Medic) {
        				 type = "Medic";

        			 }
        			 else {
        				type = "Explorer";
        			 }
           			 
           			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
           			 fileMenu4.getItems().add(openMenuItem);
        	            

        			 	
        		 }	
                   
                  
                
                   menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                   gameLayout.getChildren().add(menuBar);
                  
                       if(Game.checkWin()){
                       	Alert win = new Alert(Alert.AlertType.INFORMATION);
       		             win.setTitle("All done!");
       		             win.setHeaderText("Close game");
       		             win.setContentText("This is an alert.");
       		             win.showAndWait().ifPresent(response -> {
       		                 if (response == ButtonType.OK) {
       		                     primaryStage.close();
       		                 }
       		             });
       		             win.setOnCloseRequest(close -> {
       		                 // Change the scene when the alert is closed
       		                 

       		                 primaryStage.close();
       		             });
              
                       }
                       if(Game.checkGameOver()){
                       	Alert lose = new Alert(Alert.AlertType.INFORMATION);
       		             lose.setTitle("You lost");
       		             lose.setHeaderText("Close game");
       		             lose.setContentText("This is an alert.");
       		             lose.showAndWait().ifPresent(response -> {
       		                 if (response == ButtonType.OK) {
       		                     primaryStage.close();
       		                 }
       		             });
       		             lose.setOnCloseRequest(close -> {
       		                 // Change the scene when the alert is closed
       		                 

       		                 primaryStage.close();
       		             });
                       }
                      
                      
               } catch (NotEnoughActionsException e) {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Insufficient Actions");
             alert.setContentText(e.getMessage());
             alert.showAndWait();
             }

               catch (MovementException e) {
             	    Alert alert = new Alert(Alert.AlertType.INFORMATION);
             	    alert.setTitle("Invalid Movement");
             	    
             	    alert.setContentText(e.getMessage());
             	    alert.showAndWait();
             	    }
             	    }
             
                        });
                   
                    
                    
                   
                    
                    
                    attack.setOnAction(event2 -> {
                 	   
                     try {

                        

                         currentHero.attack();
                      

                         for(int row=0;row<GRID_SIZE;row++){
                             int rowMap=14-row;
                             	for(int col1 =0;col1<GRID_SIZE;col1++){
                            
                           
                            
                                             if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                                             Rectangle square= createSquare();
                                 gridPane.add(square,col1,row);
                                             ImageView jImageView = new ImageView(joel);
                         jImageView.setFitWidth(50);  
                         jImageView.setFitHeight(50);
                             gridPane.add(jImageView, col1, row);

                             }
                                             else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
                             Rectangle square= createSquare();
                                 gridPane.add(square,col1,row);
                             ImageView vaccineIV = new ImageView(vaccine);
                             vaccineIV.setFitWidth(50);  
                                         vaccineIV.setFitHeight(50);
                             gridPane.add(vaccineIV, col1, row);
                             }
                                             else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
                             Rectangle square= createSquare();
                                 gridPane.add(square,col1,row);
                             ImageView supplyIV = new ImageView(supply);
                             supplyIV.setFitWidth(50);  
                                         supplyIV.setFitHeight(50);
                             gridPane.add(supplyIV, col1, row);
                             }
                                             else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
                            
                                             Rectangle square= createSquare();
                             Label text2 = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                                    text2.setFont(new Font(10));
                                    l1.setTextFill(Color.BLACK);
                                              
                             gridPane.add(square, col1, row);
                                        gridPane.add(text2, col1, row);
                                        
                            
                             }
                                             else {
                                 Rectangle square= createSquare();
                                 gridPane.add(square,col1,row);
                                 }
                             }
                            
                             }

                   
                     
                    Rectangle rectangle2 = new Rectangle(160, 150, Color.DARKGRAY);
                    Text text2 = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Explorer" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                    // Text text2 = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                         text2.setFont(Font.font("Arial", 14));
                         text2.setFill(Color.BLACK);
                         gameLayout.setAlignment(Pos.TOP_RIGHT);

                         rectangle2.setTranslateY(-10);
                        
                    
                     double textX2 = rectangle2.getX() + (rectangle2.getWidth() - text2.getLayoutBounds().getWidth()) / 2;
                         double textY2= rectangle2.getY() + (rectangle2.getHeight() + text2.getLayoutBounds().getHeight()) / 2;
                         text2.relocate(textX2, textY2);
                     gameLayout.getChildren().add(rectangle2);
                     gameLayout.getChildren().add(text2);
                     
                     
                     
                     menuBar= new MenuBar();
                     fileMenu= new Menu("Select Zombie");
                     fileMenu2 = new Menu ("Select HeroTarget");
                 fileMenu3 = new Menu ("Pick a Hero");
                fileMenu4 = new Menu ("View Heroes Details");
                 fileMenu.setStyle("-fx-text-fill: white;");
                 fileMenu2.setStyle("-fx-text-fill: white;");
                 fileMenu3.setStyle("-fx-text-fill: white;");
                 fileMenu4.setStyle("-fx-text-fill: white;");
                     menuBar.setPrefWidth(50);
                     menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                     for(int i=0; i<Game.zombies.size();i++){
                      MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                      fileMenu.getItems().add(openMenuItem);
                      int x=i;
                      openMenuItem.setOnAction(event3->{
                      currentHero.setTarget(Game.zombies.get(x));
                      System.out.println(currentHero.getTarget());
                      });
                     }
                     for(int i=0; i<Game.heroes.size();i++){
                      MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                      fileMenu3.getItems().add(openMenuItem);
                      int x=i;
                      openMenuItem.setOnAction(event3->{
                      currentHero = Game.heroes.get(x);
                      
                      });
                     }
                     for(int i=0; i<Game.heroes.size();i++){
                      MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                      fileMenu2.getItems().add(openMenuItem);
                      int x=i;
                      openMenuItem.setOnAction(event3->{
                      currentHero.setTarget(Game.heroes.get(x));
                      System.out.println(currentHero.getTarget());
                      });
                     }
                     for(int i=0; i<Game.heroes.size();i++){
             			 if(Game.heroes.get(i) instanceof Fighter) {
          				  type = "Fighter";

          			 }
          			 else if(Game.heroes.get(i) instanceof Medic) {
          				 type = "Medic";

          			 }
          			 else {
          				type = "Explorer";
          			 }
             			 
             			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
             			 fileMenu4.getItems().add(openMenuItem);
          	            

          			 	
          		 }	
                     
                    
                  
                     menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                     gameLayout.getChildren().add(menuBar);
                     
                    
                     if(Game.checkWin()){
                     	Alert win = new Alert(Alert.AlertType.INFORMATION);
     		             win.setTitle("All done!");
     		             win.setHeaderText("Close game");
     		             win.setContentText("This is an alert.");
     		             win.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             win.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
            
                     }
                     if(Game.checkGameOver()){
                     	Alert lose = new Alert(Alert.AlertType.INFORMATION);
     		             lose.setTitle("You lost");
     		             lose.setHeaderText("Close game");
     		             lose.setContentText("This is an alert.");
     		             lose.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             lose.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
                     }
                     
            
             } catch (NotEnoughActionsException e) {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Insufficient Actions");
             alert.setContentText(e.getMessage());
         alert.showAndWait();

             } catch (InvalidTargetException e) {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Invalid Target");
             alert.setContentText(e.getMessage());
         alert.showAndWait();

             }
                    });
                    
                    
                    
                    cure.setOnMouseClicked(new EventHandler< Event >(){

         @Override
         public void handle(Event arg0) {
         try {
         currentHero.cure();
         for(int row=0;row<GRID_SIZE;row++){
             int rowMap=14-row;
             	for(int col1 =0;col1<GRID_SIZE;col1++){
            
           
            
                             if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                             ImageView jImageView = new ImageView(joel);
         jImageView.setFitWidth(50);  
         jImageView.setFitHeight(50);
             gridPane.add(jImageView, col1, row);

             }
                             else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView vaccineIV = new ImageView(vaccine);
             vaccineIV.setFitWidth(50);  
                         vaccineIV.setFitHeight(50);
             gridPane.add(vaccineIV, col1, row);
             }
                             else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView supplyIV = new ImageView(supply);
             supplyIV.setFitWidth(50);  
                         supplyIV.setFitHeight(50);
             gridPane.add(supplyIV, col1, row);
             }
                             else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
            
                             Rectangle square= createSquare();
             Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                    text.setFont(new Font(10));
                    l1.setTextFill(Color.BLACK);
                              
             gridPane.add(square, col1, row);
                        gridPane.add(text, col1, row);
                        
            
             }
                             else {
                 Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                 }
             }
            
             }
         
         
         Rectangle rectangle = new Rectangle(160, 120, Color.DARKGRAY);
         Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Explorer" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                  // Text text = new Text("\n" + Game.heroes.get(Game.heroes.size()-1).getName() + "\nCurrent Hp: " + Game.heroes.get(Game.heroes.size()-1).getCurrentHp() + "\nActions available: " +  Game.heroes.get(Game.heroes.size()-1).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(Game.heroes.size()-1).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                    text.setFont(Font.font("Arial", 14));
                    text.setFill(Color.BLACK);
                 gameLayout.setAlignment(Pos.TOP_RIGHT);
                    rectangle.setTranslateY(-10);
                 double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                    double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                    text.relocate(textX, textY);
                gameLayout.getChildren().add(rectangle);
                 gameLayout.getChildren().add(text);
                 
                 
                 
                 menuBar= new MenuBar();
                 fileMenu= new Menu("Select Zombie");
                 fileMenu2 = new Menu ("Select HeroTarget");
             fileMenu3 = new Menu ("Pick a Hero");
            fileMenu4 = new Menu ("View Heroes Details");
             fileMenu.setStyle("-fx-text-fill: white;");
             fileMenu2.setStyle("-fx-text-fill: white;");
             fileMenu3.setStyle("-fx-text-fill: white;");
             fileMenu4.setStyle("-fx-text-fill: white;");
                 menuBar.setPrefWidth(50);
                 menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                 for(int i=0; i<Game.zombies.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                  fileMenu.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero.setTarget(Game.zombies.get(x));
                  System.out.println(currentHero.getTarget());
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                  fileMenu3.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero = Game.heroes.get(x);
                  
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                  fileMenu2.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero.setTarget(Game.heroes.get(x));
                  System.out.println(currentHero.getTarget());
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
         			 if(Game.heroes.get(i) instanceof Fighter) {
      				  type = "Fighter";

      			 }
      			 else if(Game.heroes.get(i) instanceof Medic) {
      				 type = "Medic";

      			 }
      			 else {
      				type = "Explorer";
      			 }
         			 
         			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
         			 fileMenu4.getItems().add(openMenuItem);
      	            

      			 	
      		 }	
                 
                
              
                 menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                 gameLayout.getChildren().add(menuBar);
                    
                    
                
                     if(Game.checkWin()){
                     	Alert win = new Alert(Alert.AlertType.INFORMATION);
     		             win.setTitle("All done!");
     		             win.setHeaderText("Close game");
     		             win.setContentText("This is an alert.");
     		             win.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             win.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
            
                     }
                     if(Game.checkGameOver()){
                     	Alert lose = new Alert(Alert.AlertType.INFORMATION);
     		             lose.setTitle("You lost");
     		             lose.setHeaderText("Close game");
     		             lose.setContentText("This is an alert.");
     		             lose.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             lose.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
                     }
                     
                               
         } catch (NoAvailableResourcesException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Insufficient resources");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         } catch (InvalidTargetException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Invalid Target");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         } catch (NotEnoughActionsException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Insufficient Actions");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         }
         }
                  
                    });
                    
                    
                    
                    endTurn.setOnMouseClicked(new EventHandler<Event>(){

         @Override
         public void handle(Event event3) {
         try {
         Game.endTurn();

         if(Game.checkWin()){
         	Alert win = new Alert(Alert.AlertType.INFORMATION);
              win.setTitle("All done!");
              win.setHeaderText("Close game");
              win.setContentText("This is an alert.");
              win.showAndWait().ifPresent(response -> {
                  if (response == ButtonType.OK) {
                      primaryStage.close();
                  }
              });
              win.setOnCloseRequest(close -> {
                  // Change the scene when the alert is closed
                  

                  primaryStage.close();
              });

         }
         if(Game.checkGameOver()){
         	Alert lose = new Alert(Alert.AlertType.INFORMATION);
              lose.setTitle("You lost");
              lose.setHeaderText("Close game");
              lose.setContentText("This is an alert.");
              lose.showAndWait().ifPresent(response -> {
                  if (response == ButtonType.OK) {
                      primaryStage.close();
                  }
              });
              lose.setOnCloseRequest(close -> {
                  // Change the scene when the alert is closed
                  

                  primaryStage.close();
              });
         }

         for(int row=0;row<GRID_SIZE;row++){
             int rowMap=14-row;
             	for(int col1 =0;col1<GRID_SIZE;col1++){
            
           
            
                             if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                             ImageView jImageView = new ImageView(joel);
         jImageView.setFitWidth(50);  
         jImageView.setFitHeight(50);
             gridPane.add(jImageView, col1, row);

             }
                             else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView vaccineIV = new ImageView(vaccine);
             vaccineIV.setFitWidth(50);  
                         vaccineIV.setFitHeight(50);
             gridPane.add(vaccineIV, col1, row);
             }
                             else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView supplyIV = new ImageView(supply);
             supplyIV.setFitWidth(50);  
                         supplyIV.setFitHeight(50);
             gridPane.add(supplyIV, col1, row);
             }
                             else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
            
                             Rectangle square= createSquare();
             Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                    text.setFont(new Font(10));
                    l1.setTextFill(Color.BLACK);
                              
             gridPane.add(square, col1, row);
                        gridPane.add(text, col1, row);
                        
            
             }
                             else {
                 Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                 }
             }
            
             }
         Rectangle rectangle = new Rectangle(160, 120, Color.DARKGRAY);
         Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Explorer" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                   //Text text = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                    text.setFont(Font.font("Arial", 14));
                    text.setFill(Color.BLACK);
                 gameLayout.setAlignment(Pos.TOP_RIGHT);
                    rectangle.setTranslateY(-10);
                 double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                    double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                    text.relocate(textX, textY);
                gameLayout.getChildren().add(rectangle);
                 gameLayout.getChildren().add(text);
                 
                 
                 
                 menuBar= new MenuBar();
                 fileMenu= new Menu("Select Zombie");
                 fileMenu2 = new Menu ("Select HeroTarget");
             fileMenu3 = new Menu ("Pick a Hero");
            fileMenu4 = new Menu ("View Heroes Details");
             fileMenu.setStyle("-fx-text-fill: white;");
             fileMenu2.setStyle("-fx-text-fill: white;");
             fileMenu3.setStyle("-fx-text-fill: white;");
             fileMenu4.setStyle("-fx-text-fill: white;");
                 menuBar.setPrefWidth(50);
                 menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                 for(int i=0; i<Game.zombies.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                  fileMenu.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero.setTarget(Game.zombies.get(x));
                  System.out.println(currentHero.getTarget());
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                  fileMenu3.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero = Game.heroes.get(x);
                  
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                  fileMenu2.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero.setTarget(Game.heroes.get(x));
                  System.out.println(currentHero.getTarget());
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
         			 if(Game.heroes.get(i) instanceof Fighter) {
      				  type = "Fighter";

      			 }
      			 else if(Game.heroes.get(i) instanceof Medic) {
      				 type = "Medic";

      			 }
      			 else {
      				type = "Explorer";
      			 }
         			 
         			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
         			 fileMenu4.getItems().add(openMenuItem);
      	            

      			 	
      		 }	
                 
                
              
                 menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                 gameLayout.getChildren().add(menuBar);
                     
                    
         } catch (NotEnoughActionsException e) {

         } catch (InvalidTargetException e) {

         }
         }
                  
                    });
                    
                    useSpecial.setOnMouseClicked(new EventHandler< Event >(){

         @Override
         public void handle(Event event) {
         try {
         currentHero.useSpecial();
         for(int row=0;row<GRID_SIZE;row++){
             int rowMap=14-row;
             	for(int col1 =0;col1<GRID_SIZE;col1++){
            
           
            
                             if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                             ImageView jImageView = new ImageView(joel);
         jImageView.setFitWidth(50);  
         jImageView.setFitHeight(50);
             gridPane.add(jImageView, col1, row);

             }
                             else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView vaccineIV = new ImageView(vaccine);
             vaccineIV.setFitWidth(50);  
                         vaccineIV.setFitHeight(50);
             gridPane.add(vaccineIV, col1, row);
             }
                             else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView supplyIV = new ImageView(supply);
             supplyIV.setFitWidth(50);  
                         supplyIV.setFitHeight(50);
             gridPane.add(supplyIV, col1, row);
             }
                             else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
            
                             Rectangle square= createSquare();
             Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                    text.setFont(new Font(10));
                    l1.setTextFill(Color.BLACK);
                              
             gridPane.add(square, col1, row);
                        gridPane.add(text, col1, row);
                        
            
             }
                             else {
                 Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                 }
             }
            
             }
         Rectangle rectangle = new Rectangle(160, 120, Color.DARKGRAY);
         Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Explorer" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                  // Text text = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                    text.setFont(Font.font("Arial", 14));
                    text.setFill(Color.BLACK);
                 gameLayout.setAlignment(Pos.TOP_RIGHT);
                    rectangle.setTranslateY(-10);
                 double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                    double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                    text.relocate(textX, textY);
                gameLayout.getChildren().add(rectangle);
                gameLayout.getChildren().add(text);

                menuBar= new MenuBar();
                fileMenu= new Menu("Select Zombie");
                fileMenu2 = new Menu ("Select HeroTarget");
            fileMenu3 = new Menu ("Pick a Hero");
           fileMenu4 = new Menu ("View Heroes Details");
            fileMenu.setStyle("-fx-text-fill: white;");
            fileMenu2.setStyle("-fx-text-fill: white;");
            fileMenu3.setStyle("-fx-text-fill: white;");
            fileMenu4.setStyle("-fx-text-fill: white;");
                menuBar.setPrefWidth(50);
                menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                for(int i=0; i<Game.zombies.size();i++){
                 MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                 fileMenu.getItems().add(openMenuItem);
                 int x=i;
                 openMenuItem.setOnAction(event2->{
                 currentHero.setTarget(Game.zombies.get(x));
                 System.out.println(currentHero.getTarget());
                 });
                }
                for(int i=0; i<Game.heroes.size();i++){
                 MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                 fileMenu3.getItems().add(openMenuItem);
                 int x=i;
                 openMenuItem.setOnAction(event2->{
                 currentHero = Game.heroes.get(x);
                 
                 });
                }
                for(int i=0; i<Game.heroes.size();i++){
                 MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                 fileMenu2.getItems().add(openMenuItem);
                 int x=i;
                 openMenuItem.setOnAction(event2->{
                 currentHero.setTarget(Game.heroes.get(x));
                 System.out.println(currentHero.getTarget());
                 });
                }
                for(int i=0; i<Game.heroes.size();i++){
        			 if(Game.heroes.get(i) instanceof Fighter) {
     				  type = "Fighter";

     			 }
     			 else if(Game.heroes.get(i) instanceof Medic) {
     				 type = "Medic";

     			 }
     			 else {
     				type = "Explorer";
     			 }
        			 
        			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
        			 fileMenu4.getItems().add(openMenuItem);
     	            

     			 	
     		 }	
                
               
             
                menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                gameLayout.getChildren().add(menuBar);
                    
                     if(Game.checkWin()){
                     	Alert win = new Alert(Alert.AlertType.INFORMATION);
     		             win.setTitle("All done!");
     		             win.setHeaderText("Close game");
     		             win.setContentText("This is an alert.");
     		             win.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             win.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
            
                     }
                     if(Game.checkGameOver()){
                     	Alert lose = new Alert(Alert.AlertType.INFORMATION);
     		             lose.setTitle("You lost");
     		             lose.setHeaderText("Close game");
     		             lose.setContentText("This is an alert.");
     		             lose.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             lose.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
                     }
                    
          
         } catch (NoAvailableResourcesException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Insufficient Supply");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         } catch (InvalidTargetException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Invalid Target");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         }

         }});
            

                 game = new Scene(gameLayout, 1470, 800);
               primaryStage.setScene(game);

                

                 });
         	
        b6.setOnAction(event -> {
        	 currentHero = Game.availableHeroes.get(5);
             Game.startGame(currentHero);
            
            
             gridPane.setAlignment(Pos.CENTER);
             
             for(int row=0;row<GRID_SIZE;row++){
             int rowMap=14-row;
             	for(int col1 =0;col1<GRID_SIZE;col1++){
            
           
            
                             if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                             ImageView jImageView = new ImageView(joel);
         jImageView.setFitWidth(50);  
         jImageView.setFitHeight(50);
             gridPane.add(jImageView, col1, row);

             }
                             else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView vaccineIV = new ImageView(vaccine);
             vaccineIV.setFitWidth(50);  
                         vaccineIV.setFitHeight(50);
             gridPane.add(vaccineIV, col1, row);
             }
                             else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView supplyIV = new ImageView(supply);
             supplyIV.setFitWidth(50);  
                         supplyIV.setFitHeight(50);
             gridPane.add(supplyIV, col1, row);
             }
                             else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
            
                             Rectangle square= createSquare();
             Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                    text.setFont(new Font(10));
                    l1.setTextFill(Color.BLACK);
                              
             gridPane.add(square, col1, row);
                        gridPane.add(text, col1, row);
                        
            
             }
                             else {
                 Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                 }
             }
            
             }

                  
             gameLayout.getChildren().add(gridPane);
                
                    
                      
                      gameLayout.setStyle("-fx-background-color: #000000;");
              
                    
              
                 Rectangle rectangle = new Rectangle(160, 150, Color.DARKGRAY);
                 Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Medic" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                      text.setFont(Font.font("Arial", 14));
                      text.setFill(Color.BLACK);
                      
                    


                   gameLayout.setAlignment(Pos.TOP_RIGHT);


                     rectangle.setTranslateY(-10);

                
                 double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                     double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                    
                     text.relocate(textX, textY);
                     
                     
                 

                 
                 gameLayout.getChildren().addAll(rectangle,text);
                 

                
                     Button up = new Button("↑");
                     Button down = new Button("↓");
                 Button left = new Button("←");
                 Button right = new Button("→");
                    
                    
                     Button attack = new Button("ATTACK");
                     Button cure = new Button("CURE");
                     Button useSpecial = new Button("USE SPECIAL");
                     Button endTurn = new Button("END TURN");
                     

                    
                    
                     menuBar= new MenuBar();
                     fileMenu= new Menu("Select Zombie");
                     fileMenu2 = new Menu ("Select HeroTarget");
                 fileMenu3 = new Menu ("Pick a Hero");
                fileMenu4 = new Menu ("View Heroes Details");
                 fileMenu.setStyle("-fx-text-fill: white;");
                 fileMenu2.setStyle("-fx-text-fill: white;");
                 fileMenu3.setStyle("-fx-text-fill: white;");
                 fileMenu4.setStyle("-fx-text-fill: white;");
                     menuBar.setPrefWidth(50);
                     menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                     for(int i=0; i<Game.zombies.size();i++){
                      MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                      fileMenu.getItems().add(openMenuItem);
                      int x=i;
                      openMenuItem.setOnAction(event2->{
                      currentHero.setTarget(Game.zombies.get(x));
                      System.out.println(currentHero.getTarget());
                      });
                     }
                     for(int i=0; i<Game.heroes.size();i++){
                      MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                      fileMenu3.getItems().add(openMenuItem);
                      int x=i;
                      openMenuItem.setOnAction(event2->{
                      currentHero = Game.heroes.get(x);
                      
                      });
                     }
                     for(int i=0; i<Game.heroes.size();i++){
                      MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                      fileMenu2.getItems().add(openMenuItem);
                      int x=i;
                      openMenuItem.setOnAction(event2->{
                      currentHero.setTarget(Game.heroes.get(x));
                      System.out.println(currentHero.getTarget());
                      });
                     }
                     for(int i=0; i<Game.heroes.size();i++){
             			 if(Game.heroes.get(i) instanceof Fighter) {
          				  type = "Fighter";

          			 }
          			 else if(Game.heroes.get(i) instanceof Medic) {
          				 type = "Medic";

          			 }
          			 else {
          				type = "Explorer";
          			 }
             			 
             			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
             			 fileMenu4.getItems().add(openMenuItem);
          	            

          			 	
          		 }	
                     
                    
                  
                     menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                     gameLayout.getChildren().add(menuBar);
                    
                    
                    
                    
                     if(Game.checkWin()){
                     	Alert win = new Alert(Alert.AlertType.INFORMATION);
     		             win.setTitle("All done!");
     		             win.setHeaderText("Close game");
     		             win.setContentText("This is an alert.");
     		             win.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             win.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
            
                     }
                     if(Game.checkGameOver()){
                     	Alert lose = new Alert(Alert.AlertType.INFORMATION);
     		             lose.setTitle("You lost");
     		             lose.setHeaderText("Close game");
     		             lose.setContentText("This is an alert.");
     		             lose.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             lose.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
                     }
                    

                    
                     VBox buttonsBox = new VBox();              
                     buttonsBox.getChildren().addAll(menuBar,up,down,left,right,attack,cure,useSpecial, endTurn);
                     
                     
                     
                     
                     gameLayout.getChildren().add(buttonsBox);
                     buttonsBox.setAlignment(Pos.TOP_LEFT);
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    


                    up.setOnMouseClicked(new EventHandler<Event>() {  
         public void handle(Event event) {
         try {
         col = (int) currentHero.getLocation().getY();
                 xloc = (int) (15 -1 - currentHero.getLocation().getX());
                 if(Game.map[((int)currentHero.getLocation().getX()) + 1][(int) currentHero.getLocation().getY()]instanceof TrapCell) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Warning");
         alert.setContentText("You have entered a trap cell!");
         alert.showAndWait();
                 }
         currentHero.move(Direction.UP);
         for(int row=0;row<GRID_SIZE;row++){
             int rowMap=14-row;
             	for(int col1 =0;col1<GRID_SIZE;col1++){
            
           
            
                             if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                             ImageView jImageView = new ImageView(joel);
         jImageView.setFitWidth(50);  
         jImageView.setFitHeight(50);
             gridPane.add(jImageView, col1, row);

             }
                             else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView vaccineIV = new ImageView(vaccine);
             vaccineIV.setFitWidth(50);  
                         vaccineIV.setFitHeight(50);
             gridPane.add(vaccineIV, col1, row);
             }
                             else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView supplyIV = new ImageView(supply);
             supplyIV.setFitWidth(50);  
                         supplyIV.setFitHeight(50);
             gridPane.add(supplyIV, col1, row);
             }
                             else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
            
                             Rectangle square= createSquare();
             Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                    text.setFont(new Font(10));
                    l1.setTextFill(Color.BLACK);
                              
             gridPane.add(square, col1, row);
                        gridPane.add(text, col1, row);
                        
            
             }
                             else {
                 Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                 }
             }
            
             }
         Rectangle rectangle = new Rectangle(160, 150, Color.DARKGRAY);
         Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Medic" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                     text.setFont(Font.font("Arial", 14));
                     text.setFill(Color.BLACK);
                 gameLayout.setAlignment(Pos.TOP_RIGHT);
                    rectangle.setTranslateY(-10);
                 double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                    double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                    text.relocate(textX, textY);
                gameLayout.getChildren().add(rectangle);
                 gameLayout.getChildren().add(text);
                 
                 
                 

          	
     		 	

                 
                 menuBar= new MenuBar();
                 fileMenu= new Menu("Select Zombie");
                 fileMenu2 = new Menu ("Select HeroTarget");
             fileMenu3 = new Menu ("Pick a Hero");
            fileMenu4 = new Menu ("View Heroes Details");
             fileMenu.setStyle("-fx-text-fill: white;");
             fileMenu2.setStyle("-fx-text-fill: white;");
             fileMenu3.setStyle("-fx-text-fill: white;");
             fileMenu4.setStyle("-fx-text-fill: white;");
                 menuBar.setPrefWidth(50);
                 menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                 for(int i=0; i<Game.zombies.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                  fileMenu.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero.setTarget(Game.zombies.get(x));
                  System.out.println(currentHero.getTarget());
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                  fileMenu3.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero = Game.heroes.get(x);
                  
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                  fileMenu2.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero.setTarget(Game.heroes.get(x));
                  System.out.println(currentHero.getTarget());
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
         			 if(Game.heroes.get(i) instanceof Fighter) {
      				  type = "Fighter";

      			 }
      			 else if(Game.heroes.get(i) instanceof Medic) {
      				 type = "Medic";

      			 }
      			 else {
      				type = "Explorer";
      			 }
         			 
         			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
         			 fileMenu4.getItems().add(openMenuItem);
      	            

      			 	
      		 }	
                 
                
              
                 menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                 gameLayout.getChildren().add(menuBar);

                    
                    


                     if(Game.checkWin()){
                     	Alert win = new Alert(Alert.AlertType.INFORMATION);
     		             win.setTitle("All done!");
     		             win.setHeaderText("Close game");
     		             win.setContentText("This is an alert.");
     		             win.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             win.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
            
                     }
                     if(Game.checkGameOver()){
                     	Alert lose = new Alert(Alert.AlertType.INFORMATION);
     		             lose.setTitle("You lost");
     		             lose.setHeaderText("Close game");
     		             lose.setContentText("This is an alert.");
     		             lose.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             lose.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
                     }
                     
                    
                               

         }
         catch (NotEnoughActionsException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Insufficient Actions");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         }

         catch (MovementException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Invalid Movement");
         
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         }
         }
         
                    });
                    down.setOnMouseClicked(new EventHandler<Event>() {
                  
             @Override
             public void handle(Event event) {
             try {
             col = (int) currentHero.getLocation().getY();
                     xloc = (int) (15 -1 - currentHero.getLocation().getX());
                     if(Game.map[((int)currentHero.getLocation().getX()) - 1][(int) currentHero.getLocation().getY()]instanceof TrapCell) {
                     Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Warning");
         alert.setContentText("You have entered a trap cell!");
         alert.showAndWait();
                     }
                    
                    
                     currentHero.move(Direction.DOWN);
                     for(int row=0;row<GRID_SIZE;row++){
                         int rowMap=14-row;
                         	for(int col1 =0;col1<GRID_SIZE;col1++){
                        
                       
                        
                                         if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                                         Rectangle square= createSquare();
                             gridPane.add(square,col1,row);
                                         ImageView jImageView = new ImageView(joel);
                     jImageView.setFitWidth(50);  
                     jImageView.setFitHeight(50);
                         gridPane.add(jImageView, col1, row);

                         }
                                         else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
                         Rectangle square= createSquare();
                             gridPane.add(square,col1,row);
                         ImageView vaccineIV = new ImageView(vaccine);
                         vaccineIV.setFitWidth(50);  
                                     vaccineIV.setFitHeight(50);
                         gridPane.add(vaccineIV, col1, row);
                         }
                                         else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
                         Rectangle square= createSquare();
                             gridPane.add(square,col1,row);
                         ImageView supplyIV = new ImageView(supply);
                         supplyIV.setFitWidth(50);  
                                     supplyIV.setFitHeight(50);
                         gridPane.add(supplyIV, col1, row);
                         }
                                         else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
                        
                                         Rectangle square= createSquare();
                         Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                                text.setFont(new Font(10));
                                l1.setTextFill(Color.BLACK);
                                          
                         gridPane.add(square, col1, row);
                                    gridPane.add(text, col1, row);
                                    
                        
                         }
                                         else {
                             Rectangle square= createSquare();
                             gridPane.add(square,col1,row);
                             }
                         }
                        
                         }
             Rectangle rectangle = new Rectangle(160, 150, Color.DARKGRAY);
             Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Medic" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
             //Text text = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                          text.setFont(Font.font("Arial", 14));
                          text.setFill(Color.BLACK);
                       gameLayout.setAlignment(Pos.TOP_RIGHT);
                          rectangle.setTranslateY(-10);
                       double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                          double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                          text.relocate(textX, textY);
                      gameLayout.getChildren().add(rectangle);
                       gameLayout.getChildren().add(text);
                       
                                         
                       
                       menuBar= new MenuBar();
                       fileMenu= new Menu("Select Zombie");
                       fileMenu2 = new Menu ("Select HeroTarget");
                   fileMenu3 = new Menu ("Pick a Hero");
                  fileMenu4 = new Menu ("View Heroes Details");
                   fileMenu.setStyle("-fx-text-fill: white;");
                   fileMenu2.setStyle("-fx-text-fill: white;");
                   fileMenu3.setStyle("-fx-text-fill: white;");
                   fileMenu4.setStyle("-fx-text-fill: white;");
                       menuBar.setPrefWidth(50);
                       menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                       for(int i=0; i<Game.zombies.size();i++){
                        MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                        fileMenu.getItems().add(openMenuItem);
                        int x=i;
                        openMenuItem.setOnAction(event2->{
                        currentHero.setTarget(Game.zombies.get(x));
                        System.out.println(currentHero.getTarget());
                        });
                       }
                       for(int i=0; i<Game.heroes.size();i++){
                        MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                        fileMenu3.getItems().add(openMenuItem);
                        int x=i;
                        openMenuItem.setOnAction(event2->{
                        currentHero = Game.heroes.get(x);
                        
                        });
                       }
                       for(int i=0; i<Game.heroes.size();i++){
                        MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                        fileMenu2.getItems().add(openMenuItem);
                        int x=i;
                        openMenuItem.setOnAction(event2->{
                        currentHero.setTarget(Game.heroes.get(x));
                        System.out.println(currentHero.getTarget());
                        });
                       }
                       for(int i=0; i<Game.heroes.size();i++){
               			 if(Game.heroes.get(i) instanceof Fighter) {
            				  type = "Fighter";

            			 }
            			 else if(Game.heroes.get(i) instanceof Medic) {
            				 type = "Medic";

            			 }
            			 else {
            				type = "Explorer";
            			 }
               			 
               			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
               			 fileMenu4.getItems().add(openMenuItem);
            	            

            			 	
            		 }	
                       
                      
                    
                       menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                       gameLayout.getChildren().add(menuBar);
                        
                       if(Game.checkWin()){
                         	Alert win = new Alert(Alert.AlertType.INFORMATION);
         		             win.setTitle("All done!");
         		             win.setHeaderText("Close game");
         		             win.setContentText("This is an alert.");
         		             win.showAndWait().ifPresent(response -> {
         		                 if (response == ButtonType.OK) {
         		                     primaryStage.close();
         		                 }
         		             });
         		             win.setOnCloseRequest(close -> {
         		                 // Change the scene when the alert is closed
         		                 

         		                 primaryStage.close();
         		             });
                
                         }
                         if(Game.checkGameOver()){
                         	Alert lose = new Alert(Alert.AlertType.INFORMATION);
         		             lose.setTitle("You lost");
         		             lose.setHeaderText("Close game");
         		             lose.setContentText("This is an alert.");
         		             lose.showAndWait().ifPresent(response -> {
         		                 if (response == ButtonType.OK) {
         		                     primaryStage.close();
         		                 }
         		             });
         		             lose.setOnCloseRequest(close -> {
         		                 // Change the scene when the alert is closed
         		                 

         		                 primaryStage.close();
         		             });
                         }
                         
                        
                          
                    
             } catch (NotEnoughActionsException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Insufficient Actions");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         }

         catch (MovementException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Invalid Movement");
         alert.setContentText(e.getMessage());
         alert.showAndWait();

         }
         }
                      
                      
                 });

                    left.setOnMouseClicked(new EventHandler<Event>() {
                    
               @Override
               public void handle(Event event) {
               try {
               col = (int) currentHero.getLocation().getY();
                       xloc = (int) (15 -1 - currentHero.getLocation().getX());
                      
                       if(Game.map[((int)currentHero.getLocation().getX())][(int) currentHero.getLocation().getY() - 1]instanceof TrapCell) {
                       Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Warning");
             alert.setContentText("You have entered a trap cell!");
             alert.showAndWait();
                       }
                      
                      
                       currentHero.move(Direction.LEFT);
                       for(int row=0;row<GRID_SIZE;row++){
                           int rowMap=14-row;
                           	for(int col1 =0;col1<GRID_SIZE;col1++){
                          
                         
                          
                                           if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                                           Rectangle square= createSquare();
                               gridPane.add(square,col1,row);
                                           ImageView jImageView = new ImageView(joel);
                       jImageView.setFitWidth(50);  
                       jImageView.setFitHeight(50);
                           gridPane.add(jImageView, col1, row);

                           }
                                           else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
                           Rectangle square= createSquare();
                               gridPane.add(square,col1,row);
                           ImageView vaccineIV = new ImageView(vaccine);
                           vaccineIV.setFitWidth(50);  
                                       vaccineIV.setFitHeight(50);
                           gridPane.add(vaccineIV, col1, row);
                           }
                                           else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
                           Rectangle square= createSquare();
                               gridPane.add(square,col1,row);
                           ImageView supplyIV = new ImageView(supply);
                           supplyIV.setFitWidth(50);  
                                       supplyIV.setFitHeight(50);
                           gridPane.add(supplyIV, col1, row);
                           }
                                           else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
                          
                                           Rectangle square= createSquare();
                           Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                                  text.setFont(new Font(10));
                                  l1.setTextFill(Color.BLACK);
                                            
                           gridPane.add(square, col1, row);
                                      gridPane.add(text, col1, row);
                                      
                          
                           }
                                           else {
                               Rectangle square= createSquare();
                               gridPane.add(square,col1,row);
                               }
                           }
                          
                           }
               Rectangle rectangle = new Rectangle(160, 150, Color.DARKGRAY);
               Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Medic" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                       //Text text = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                          text.setFont(Font.font("Arial", 14));
                          text.setFill(Color.BLACK);
                       gameLayout.setAlignment(Pos.TOP_RIGHT);
                          rectangle.setTranslateY(-10);
                       double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                          double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                          text.relocate(textX, textY);
                      gameLayout.getChildren().add(rectangle);
                       gameLayout.getChildren().add(text);
                       
                       
              
                       menuBar= new MenuBar();
                       fileMenu= new Menu("Select Zombie");
                       fileMenu2 = new Menu ("Select HeroTarget");
                   fileMenu3 = new Menu ("Pick a Hero");
                  fileMenu4 = new Menu ("View Heroes Details");
                   fileMenu.setStyle("-fx-text-fill: white;");
                   fileMenu2.setStyle("-fx-text-fill: white;");
                   fileMenu3.setStyle("-fx-text-fill: white;");
                   fileMenu4.setStyle("-fx-text-fill: white;");
                       menuBar.setPrefWidth(50);
                       menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                       for(int i=0; i<Game.zombies.size();i++){
                        MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                        fileMenu.getItems().add(openMenuItem);
                        int x=i;
                        openMenuItem.setOnAction(event2->{
                        currentHero.setTarget(Game.zombies.get(x));
                        System.out.println(currentHero.getTarget());
                        });
                       }
                       for(int i=0; i<Game.heroes.size();i++){
                        MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                        fileMenu3.getItems().add(openMenuItem);
                        int x=i;
                        openMenuItem.setOnAction(event2->{
                        currentHero = Game.heroes.get(x);
                        
                        });
                       }
                       for(int i=0; i<Game.heroes.size();i++){
                        MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                        fileMenu2.getItems().add(openMenuItem);
                        int x=i;
                        openMenuItem.setOnAction(event2->{
                        currentHero.setTarget(Game.heroes.get(x));
                        System.out.println(currentHero.getTarget());
                        });
                       }
                       for(int i=0; i<Game.heroes.size();i++){
               			 if(Game.heroes.get(i) instanceof Fighter) {
            				  type = "Fighter";

            			 }
            			 else if(Game.heroes.get(i) instanceof Medic) {
            				 type = "Medic";

            			 }
            			 else {
            				type = "Explorer";
            			 }
               			 
               			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
               			 fileMenu4.getItems().add(openMenuItem);
            	            

            			 	
            		 }	
                       
                      
                    
                       menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                       gameLayout.getChildren().add(menuBar);
                           
                           if(Game.checkWin()){
                           	Alert win = new Alert(Alert.AlertType.INFORMATION);
           		             win.setTitle("All done!");
           		             win.setHeaderText("Close game");
           		             win.setContentText("This is an alert.");
           		             win.showAndWait().ifPresent(response -> {
           		                 if (response == ButtonType.OK) {
           		                     primaryStage.close();
           		                 }
           		             });
           		             win.setOnCloseRequest(close -> {
           		                 // Change the scene when the alert is closed
           		                 

           		                 primaryStage.close();
           		             });
                  
                           }
                           if(Game.checkGameOver()){
                           	Alert lose = new Alert(Alert.AlertType.INFORMATION);
           		             lose.setTitle("You lost");
           		             lose.setHeaderText("Close game");
           		             lose.setContentText("This is an alert.");
           		             lose.showAndWait().ifPresent(response -> {
           		                 if (response == ButtonType.OK) {
           		                     primaryStage.close();
           		                 }
           		             });
           		             lose.setOnCloseRequest(close -> {
           		                 // Change the scene when the alert is closed
           		                 

           		                 primaryStage.close();
           		             });
                           }
                          
                      
               } catch (NotEnoughActionsException e) {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Insufficient Actions");
             alert.setContentText(e.getMessage());
             alert.showAndWait();
             }

             catch (MovementException e) {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Invalid Movement");
             alert.setContentText(e.getMessage());
             alert.showAndWait();
            
             }
             }
                        });
                    right.setOnMouseClicked(new EventHandler<Event>() {
                    
               @Override
               public void handle(Event event) {
               try {
               col = (int) currentHero.getLocation().getY();
                       xloc = (int) (15 -1 - currentHero.getLocation().getX());
                         if(Game.map[((int)currentHero.getLocation().getX())][(int) currentHero.getLocation().getY() + 1]instanceof TrapCell) {
                         Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Warning");
             alert.setContentText("You have entered a trap cell");
             alert.showAndWait();
                         }

               currentHero.move(Direction.RIGHT);
               for(int row=0;row<GRID_SIZE;row++){
                   int rowMap=14-row;
                   	for(int col1 =0;col1<GRID_SIZE;col1++){
                  
                 
                  
                                   if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                                   Rectangle square= createSquare();
                       gridPane.add(square,col1,row);
                                   ImageView jImageView = new ImageView(joel);
               jImageView.setFitWidth(50);  
               jImageView.setFitHeight(50);
                   gridPane.add(jImageView, col1, row);

                   }
                                   else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
                   Rectangle square= createSquare();
                       gridPane.add(square,col1,row);
                   ImageView vaccineIV = new ImageView(vaccine);
                   vaccineIV.setFitWidth(50);  
                               vaccineIV.setFitHeight(50);
                   gridPane.add(vaccineIV, col1, row);
                   }
                                   else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
                   Rectangle square= createSquare();
                       gridPane.add(square,col1,row);
                   ImageView supplyIV = new ImageView(supply);
                   supplyIV.setFitWidth(50);  
                               supplyIV.setFitHeight(50);
                   gridPane.add(supplyIV, col1, row);
                   }
                                   else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
                  
                                   Rectangle square= createSquare();
                   Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                          text.setFont(new Font(10));
                          l1.setTextFill(Color.BLACK);
                                    
                   gridPane.add(square, col1, row);
                              gridPane.add(text, col1, row);
                              
                  
                   }
                                   else {
                       Rectangle square= createSquare();
                       gridPane.add(square,col1,row);
                       }
                   }
                  
                   }
              
               Rectangle rectangle = new Rectangle(160, 150, Color.DARKGRAY);
               Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Medic" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                     //  Text text = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                      text.setFont(Font.font("Arial", 14));
                      text.setFill(Color.BLACK);
                   gameLayout.setAlignment(Pos.TOP_RIGHT);
                      rectangle.setTranslateY(-10);
                   double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                      double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                      text.relocate(textX, textY);
                  gameLayout.getChildren().add(rectangle);
                   gameLayout.getChildren().add(text);
                   
                              
                  
                   menuBar= new MenuBar();
                   fileMenu= new Menu("Select Zombie");
                   fileMenu2 = new Menu ("Select HeroTarget");
               fileMenu3 = new Menu ("Pick a Hero");
              fileMenu4 = new Menu ("View Heroes Details");
               fileMenu.setStyle("-fx-text-fill: white;");
               fileMenu2.setStyle("-fx-text-fill: white;");
               fileMenu3.setStyle("-fx-text-fill: white;");
               fileMenu4.setStyle("-fx-text-fill: white;");
                   menuBar.setPrefWidth(50);
                   menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                   for(int i=0; i<Game.zombies.size();i++){
                    MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                    fileMenu.getItems().add(openMenuItem);
                    int x=i;
                    openMenuItem.setOnAction(event2->{
                    currentHero.setTarget(Game.zombies.get(x));
                    System.out.println(currentHero.getTarget());
                    });
                   }
                   for(int i=0; i<Game.heroes.size();i++){
                    MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                    fileMenu3.getItems().add(openMenuItem);
                    int x=i;
                    openMenuItem.setOnAction(event2->{
                    currentHero = Game.heroes.get(x);
                    
                    });
                   }
                   for(int i=0; i<Game.heroes.size();i++){
                    MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                    fileMenu2.getItems().add(openMenuItem);
                    int x=i;
                    openMenuItem.setOnAction(event2->{
                    currentHero.setTarget(Game.heroes.get(x));
                    System.out.println(currentHero.getTarget());
                    });
                   }
                   for(int i=0; i<Game.heroes.size();i++){
           			 if(Game.heroes.get(i) instanceof Fighter) {
        				  type = "Fighter";

        			 }
        			 else if(Game.heroes.get(i) instanceof Medic) {
        				 type = "Medic";

        			 }
        			 else {
        				type = "Explorer";
        			 }
           			 
           			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
           			 fileMenu4.getItems().add(openMenuItem);
        	            

        			 	
        		 }	
                   
                  
                
                   menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                   gameLayout.getChildren().add(menuBar);
                  
                       if(Game.checkWin()){
                       	Alert win = new Alert(Alert.AlertType.INFORMATION);
       		             win.setTitle("All done!");
       		             win.setHeaderText("Close game");
       		             win.setContentText("This is an alert.");
       		             win.showAndWait().ifPresent(response -> {
       		                 if (response == ButtonType.OK) {
       		                     primaryStage.close();
       		                 }
       		             });
       		             win.setOnCloseRequest(close -> {
       		                 // Change the scene when the alert is closed
       		                 

       		                 primaryStage.close();
       		             });
              
                       }
                       if(Game.checkGameOver()){
                       	Alert lose = new Alert(Alert.AlertType.INFORMATION);
       		             lose.setTitle("You lost");
       		             lose.setHeaderText("Close game");
       		             lose.setContentText("This is an alert.");
       		             lose.showAndWait().ifPresent(response -> {
       		                 if (response == ButtonType.OK) {
       		                     primaryStage.close();
       		                 }
       		             });
       		             lose.setOnCloseRequest(close -> {
       		                 // Change the scene when the alert is closed
       		                 

       		                 primaryStage.close();
       		             });
                       }
                      
                      
               } catch (NotEnoughActionsException e) {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Insufficient Actions");
             alert.setContentText(e.getMessage());
             alert.showAndWait();
             }

               catch (MovementException e) {
             	    Alert alert = new Alert(Alert.AlertType.INFORMATION);
             	    alert.setTitle("Invalid Movement");
             	    
             	    alert.setContentText(e.getMessage());
             	    alert.showAndWait();
             	    }
             	    }
             
                        });
                   
                    
                    
                   
                    
                    
                    attack.setOnAction(event2 -> {
                 	   
                     try {

                        

                         currentHero.attack();
                      

                         for(int row=0;row<GRID_SIZE;row++){
                             int rowMap=14-row;
                             	for(int col1 =0;col1<GRID_SIZE;col1++){
                            
                           
                            
                                             if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                                             Rectangle square= createSquare();
                                 gridPane.add(square,col1,row);
                                             ImageView jImageView = new ImageView(joel);
                         jImageView.setFitWidth(50);  
                         jImageView.setFitHeight(50);
                             gridPane.add(jImageView, col1, row);

                             }
                                             else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
                             Rectangle square= createSquare();
                                 gridPane.add(square,col1,row);
                             ImageView vaccineIV = new ImageView(vaccine);
                             vaccineIV.setFitWidth(50);  
                                         vaccineIV.setFitHeight(50);
                             gridPane.add(vaccineIV, col1, row);
                             }
                                             else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
                             Rectangle square= createSquare();
                                 gridPane.add(square,col1,row);
                             ImageView supplyIV = new ImageView(supply);
                             supplyIV.setFitWidth(50);  
                                         supplyIV.setFitHeight(50);
                             gridPane.add(supplyIV, col1, row);
                             }
                                             else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
                            
                                             Rectangle square= createSquare();
                             Label text2 = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                                    text2.setFont(new Font(10));
                                    l1.setTextFill(Color.BLACK);
                                              
                             gridPane.add(square, col1, row);
                                        gridPane.add(text2, col1, row);
                                        
                            
                             }
                                             else {
                                 Rectangle square= createSquare();
                                 gridPane.add(square,col1,row);
                                 }
                             }
                            
                             }

                   
                     
                    Rectangle rectangle2 = new Rectangle(160, 150, Color.DARKGRAY);
                    Text text2 = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Medic" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                    // Text text2 = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                         text2.setFont(Font.font("Arial", 14));
                         text2.setFill(Color.BLACK);
                         gameLayout.setAlignment(Pos.TOP_RIGHT);

                         rectangle2.setTranslateY(-10);
                        
                    
                     double textX2 = rectangle2.getX() + (rectangle2.getWidth() - text2.getLayoutBounds().getWidth()) / 2;
                         double textY2= rectangle2.getY() + (rectangle2.getHeight() + text2.getLayoutBounds().getHeight()) / 2;
                         text2.relocate(textX2, textY2);
                     gameLayout.getChildren().add(rectangle2);
                     gameLayout.getChildren().add(text2);
                     
                     
                     
                     menuBar= new MenuBar();
                     fileMenu= new Menu("Select Zombie");
                     fileMenu2 = new Menu ("Select HeroTarget");
                 fileMenu3 = new Menu ("Pick a Hero");
                fileMenu4 = new Menu ("View Heroes Details");
                 fileMenu.setStyle("-fx-text-fill: white;");
                 fileMenu2.setStyle("-fx-text-fill: white;");
                 fileMenu3.setStyle("-fx-text-fill: white;");
                 fileMenu4.setStyle("-fx-text-fill: white;");
                     menuBar.setPrefWidth(50);
                     menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                     for(int i=0; i<Game.zombies.size();i++){
                      MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                      fileMenu.getItems().add(openMenuItem);
                      int x=i;
                      openMenuItem.setOnAction(event3->{
                      currentHero.setTarget(Game.zombies.get(x));
                      System.out.println(currentHero.getTarget());
                      });
                     }
                     for(int i=0; i<Game.heroes.size();i++){
                      MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                      fileMenu3.getItems().add(openMenuItem);
                      int x=i;
                      openMenuItem.setOnAction(event3->{
                      currentHero = Game.heroes.get(x);
                      
                      });
                     }
                     for(int i=0; i<Game.heroes.size();i++){
                      MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                      fileMenu2.getItems().add(openMenuItem);
                      int x=i;
                      openMenuItem.setOnAction(event3->{
                      currentHero.setTarget(Game.heroes.get(x));
                      System.out.println(currentHero.getTarget());
                      });
                     }
                     for(int i=0; i<Game.heroes.size();i++){
             			 if(Game.heroes.get(i) instanceof Fighter) {
          				  type = "Fighter";

          			 }
          			 else if(Game.heroes.get(i) instanceof Medic) {
          				 type = "Medic";

          			 }
          			 else {
          				type = "Explorer";
          			 }
             			 
             			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
             			 fileMenu4.getItems().add(openMenuItem);
          	            

          			 	
          		 }	
                     
                    
                  
                     menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                     gameLayout.getChildren().add(menuBar);
                     
                    
                     if(Game.checkWin()){
                     	Alert win = new Alert(Alert.AlertType.INFORMATION);
     		             win.setTitle("All done!");
     		             win.setHeaderText("Close game");
     		             win.setContentText("This is an alert.");
     		             win.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             win.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
            
                     }
                     if(Game.checkGameOver()){
                     	Alert lose = new Alert(Alert.AlertType.INFORMATION);
     		             lose.setTitle("You lost");
     		             lose.setHeaderText("Close game");
     		             lose.setContentText("This is an alert.");
     		             lose.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             lose.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
                     }
                     
            
             } catch (NotEnoughActionsException e) {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Insufficient Actions");
             alert.setContentText(e.getMessage());
         alert.showAndWait();

             } catch (InvalidTargetException e) {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Invalid Target");
             alert.setContentText(e.getMessage());
         alert.showAndWait();

             }
                    });
                    
                    
                    
                    cure.setOnMouseClicked(new EventHandler< Event >(){

         @Override
         public void handle(Event arg0) {
         try {
         currentHero.cure();
         for(int row=0;row<GRID_SIZE;row++){
             int rowMap=14-row;
             	for(int col1 =0;col1<GRID_SIZE;col1++){
            
           
            
                             if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                             ImageView jImageView = new ImageView(joel);
         jImageView.setFitWidth(50);  
         jImageView.setFitHeight(50);
             gridPane.add(jImageView, col1, row);

             }
                             else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView vaccineIV = new ImageView(vaccine);
             vaccineIV.setFitWidth(50);  
                         vaccineIV.setFitHeight(50);
             gridPane.add(vaccineIV, col1, row);
             }
                             else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView supplyIV = new ImageView(supply);
             supplyIV.setFitWidth(50);  
                         supplyIV.setFitHeight(50);
             gridPane.add(supplyIV, col1, row);
             }
                             else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
            
                             Rectangle square= createSquare();
             Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                    text.setFont(new Font(10));
                    l1.setTextFill(Color.BLACK);
                              
             gridPane.add(square, col1, row);
                        gridPane.add(text, col1, row);
                        
            
             }
                             else {
                 Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                 }
             }
            
             }
         
         
         Rectangle rectangle = new Rectangle(160, 120, Color.DARKGRAY);
         Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Medic" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                  // Text text = new Text("\n" + Game.heroes.get(Game.heroes.size()-1).getName() + "\nCurrent Hp: " + Game.heroes.get(Game.heroes.size()-1).getCurrentHp() + "\nActions available: " +  Game.heroes.get(Game.heroes.size()-1).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(Game.heroes.size()-1).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                    text.setFont(Font.font("Arial", 14));
                    text.setFill(Color.BLACK);
                 gameLayout.setAlignment(Pos.TOP_RIGHT);
                    rectangle.setTranslateY(-10);
                 double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                    double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                    text.relocate(textX, textY);
                gameLayout.getChildren().add(rectangle);
                 gameLayout.getChildren().add(text);
                 
                 
                 
                 menuBar= new MenuBar();
                 fileMenu= new Menu("Select Zombie");
                 fileMenu2 = new Menu ("Select HeroTarget");
             fileMenu3 = new Menu ("Pick a Hero");
            fileMenu4 = new Menu ("View Heroes Details");
             fileMenu.setStyle("-fx-text-fill: white;");
             fileMenu2.setStyle("-fx-text-fill: white;");
             fileMenu3.setStyle("-fx-text-fill: white;");
             fileMenu4.setStyle("-fx-text-fill: white;");
                 menuBar.setPrefWidth(50);
                 menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                 for(int i=0; i<Game.zombies.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                  fileMenu.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero.setTarget(Game.zombies.get(x));
                  System.out.println(currentHero.getTarget());
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                  fileMenu3.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero = Game.heroes.get(x);
                  
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                  fileMenu2.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero.setTarget(Game.heroes.get(x));
                  System.out.println(currentHero.getTarget());
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
         			 if(Game.heroes.get(i) instanceof Fighter) {
      				  type = "Fighter";

      			 }
      			 else if(Game.heroes.get(i) instanceof Medic) {
      				 type = "Medic";

      			 }
      			 else {
      				type = "Explorer";
      			 }
         			 
         			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
         			 fileMenu4.getItems().add(openMenuItem);
      	            

      			 	
      		 }	
                 
                
              
                 menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                 gameLayout.getChildren().add(menuBar);
                    
                    
                
                     if(Game.checkWin()){
                     	Alert win = new Alert(Alert.AlertType.INFORMATION);
     		             win.setTitle("All done!");
     		             win.setHeaderText("Close game");
     		             win.setContentText("This is an alert.");
     		             win.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             win.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
            
                     }
                     if(Game.checkGameOver()){
                     	Alert lose = new Alert(Alert.AlertType.INFORMATION);
     		             lose.setTitle("You lost");
     		             lose.setHeaderText("Close game");
     		             lose.setContentText("This is an alert.");
     		             lose.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             lose.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
                     }
                     
                               
         } catch (NoAvailableResourcesException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Insufficient resources");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         } catch (InvalidTargetException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Invalid Target");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         } catch (NotEnoughActionsException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Insufficient Actions");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         }
         }
                  
                    });
                    
                    
                    
                    endTurn.setOnMouseClicked(new EventHandler<Event>(){

         @Override
         public void handle(Event event3) {
         try {
         Game.endTurn();

         if(Game.checkWin()){
         	Alert win = new Alert(Alert.AlertType.INFORMATION);
              win.setTitle("All done!");
              win.setHeaderText("Close game");
              win.setContentText("This is an alert.");
              win.showAndWait().ifPresent(response -> {
                  if (response == ButtonType.OK) {
                      primaryStage.close();
                  }
              });
              win.setOnCloseRequest(close -> {
                  // Change the scene when the alert is closed
                  

                  primaryStage.close();
              });

         }
         if(Game.checkGameOver()){
         	Alert lose = new Alert(Alert.AlertType.INFORMATION);
              lose.setTitle("You lost");
              lose.setHeaderText("Close game");
              lose.setContentText("This is an alert.");
              lose.showAndWait().ifPresent(response -> {
                  if (response == ButtonType.OK) {
                      primaryStage.close();
                  }
              });
              lose.setOnCloseRequest(close -> {
                  // Change the scene when the alert is closed
                  

                  primaryStage.close();
              });
         }

         for(int row=0;row<GRID_SIZE;row++){
             int rowMap=14-row;
             	for(int col1 =0;col1<GRID_SIZE;col1++){
            
           
            
                             if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                             ImageView jImageView = new ImageView(joel);
         jImageView.setFitWidth(50);  
         jImageView.setFitHeight(50);
             gridPane.add(jImageView, col1, row);

             }
                             else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView vaccineIV = new ImageView(vaccine);
             vaccineIV.setFitWidth(50);  
                         vaccineIV.setFitHeight(50);
             gridPane.add(vaccineIV, col1, row);
             }
                             else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView supplyIV = new ImageView(supply);
             supplyIV.setFitWidth(50);  
                         supplyIV.setFitHeight(50);
             gridPane.add(supplyIV, col1, row);
             }
                             else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
            
                             Rectangle square= createSquare();
             Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                    text.setFont(new Font(10));
                    l1.setTextFill(Color.BLACK);
                              
             gridPane.add(square, col1, row);
                        gridPane.add(text, col1, row);
                        
            
             }
                             else {
                 Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                 }
             }
            
             }
         Rectangle rectangle = new Rectangle(160, 120, Color.DARKGRAY);
         Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Medic" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                   //Text text = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                    text.setFont(Font.font("Arial", 14));
                    text.setFill(Color.BLACK);
                 gameLayout.setAlignment(Pos.TOP_RIGHT);
                    rectangle.setTranslateY(-10);
                 double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                    double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                    text.relocate(textX, textY);
                gameLayout.getChildren().add(rectangle);
                 gameLayout.getChildren().add(text);
                 
                 
                 
                 menuBar= new MenuBar();
                 fileMenu= new Menu("Select Zombie");
                 fileMenu2 = new Menu ("Select HeroTarget");
             fileMenu3 = new Menu ("Pick a Hero");
            fileMenu4 = new Menu ("View Heroes Details");
             fileMenu.setStyle("-fx-text-fill: white;");
             fileMenu2.setStyle("-fx-text-fill: white;");
             fileMenu3.setStyle("-fx-text-fill: white;");
             fileMenu4.setStyle("-fx-text-fill: white;");
                 menuBar.setPrefWidth(50);
                 menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                 for(int i=0; i<Game.zombies.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                  fileMenu.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero.setTarget(Game.zombies.get(x));
                  System.out.println(currentHero.getTarget());
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                  fileMenu3.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero = Game.heroes.get(x);
                  
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                  fileMenu2.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero.setTarget(Game.heroes.get(x));
                  System.out.println(currentHero.getTarget());
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
         			 if(Game.heroes.get(i) instanceof Fighter) {
      				  type = "Fighter";

      			 }
      			 else if(Game.heroes.get(i) instanceof Medic) {
      				 type = "Medic";

      			 }
      			 else {
      				type = "Explorer";
      			 }
         			 
         			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
         			 fileMenu4.getItems().add(openMenuItem);
      	            

      			 	
      		 }	
                 
                
              
                 menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                 gameLayout.getChildren().add(menuBar);
                     
                    
         } catch (NotEnoughActionsException e) {

         } catch (InvalidTargetException e) {

         }
         }
                  
                    });
                    
                    useSpecial.setOnMouseClicked(new EventHandler< Event >(){

         @Override
         public void handle(Event event) {
         try {
         currentHero.useSpecial();
         for(int row=0;row<GRID_SIZE;row++){
             int rowMap=14-row;
             	for(int col1 =0;col1<GRID_SIZE;col1++){
            
           
            
                             if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                             ImageView jImageView = new ImageView(joel);
         jImageView.setFitWidth(50);  
         jImageView.setFitHeight(50);
             gridPane.add(jImageView, col1, row);

             }
                             else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView vaccineIV = new ImageView(vaccine);
             vaccineIV.setFitWidth(50);  
                         vaccineIV.setFitHeight(50);
             gridPane.add(vaccineIV, col1, row);
             }
                             else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView supplyIV = new ImageView(supply);
             supplyIV.setFitWidth(50);  
                         supplyIV.setFitHeight(50);
             gridPane.add(supplyIV, col1, row);
             }
                             else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
            
                             Rectangle square= createSquare();
             Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                    text.setFont(new Font(10));
                    l1.setTextFill(Color.BLACK);
                              
             gridPane.add(square, col1, row);
                        gridPane.add(text, col1, row);
                        
            
             }
                             else {
                 Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                 }
             }
            
             }
         Rectangle rectangle = new Rectangle(160, 120, Color.DARKGRAY);
         Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Medic" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                  // Text text = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                    text.setFont(Font.font("Arial", 14));
                    text.setFill(Color.BLACK);
                 gameLayout.setAlignment(Pos.TOP_RIGHT);
                    rectangle.setTranslateY(-10);
                 double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                    double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                    text.relocate(textX, textY);
                gameLayout.getChildren().add(rectangle);
                gameLayout.getChildren().add(text);

                menuBar= new MenuBar();
                fileMenu= new Menu("Select Zombie");
                fileMenu2 = new Menu ("Select HeroTarget");
            fileMenu3 = new Menu ("Pick a Hero");
           fileMenu4 = new Menu ("View Heroes Details");
            fileMenu.setStyle("-fx-text-fill: white;");
            fileMenu2.setStyle("-fx-text-fill: white;");
            fileMenu3.setStyle("-fx-text-fill: white;");
            fileMenu4.setStyle("-fx-text-fill: white;");
                menuBar.setPrefWidth(50);
                menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                for(int i=0; i<Game.zombies.size();i++){
                 MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                 fileMenu.getItems().add(openMenuItem);
                 int x=i;
                 openMenuItem.setOnAction(event2->{
                 currentHero.setTarget(Game.zombies.get(x));
                 System.out.println(currentHero.getTarget());
                 });
                }
                for(int i=0; i<Game.heroes.size();i++){
                 MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                 fileMenu3.getItems().add(openMenuItem);
                 int x=i;
                 openMenuItem.setOnAction(event2->{
                 currentHero = Game.heroes.get(x);
                 
                 });
                }
                for(int i=0; i<Game.heroes.size();i++){
                 MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                 fileMenu2.getItems().add(openMenuItem);
                 int x=i;
                 openMenuItem.setOnAction(event2->{
                 currentHero.setTarget(Game.heroes.get(x));
                 System.out.println(currentHero.getTarget());
                 });
                }
                for(int i=0; i<Game.heroes.size();i++){
        			 if(Game.heroes.get(i) instanceof Fighter) {
     				  type = "Fighter";

     			 }
     			 else if(Game.heroes.get(i) instanceof Medic) {
     				 type = "Medic";

     			 }
     			 else {
     				type = "Explorer";
     			 }
        			 
        			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
        			 fileMenu4.getItems().add(openMenuItem);
     	            

     			 	
     		 }	
                
               
             
                menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                gameLayout.getChildren().add(menuBar);
                    
                     if(Game.checkWin()){
                     	Alert win = new Alert(Alert.AlertType.INFORMATION);
     		             win.setTitle("All done!");
     		             win.setHeaderText("Close game");
     		             win.setContentText("This is an alert.");
     		             win.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             win.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
            
                     }
                     if(Game.checkGameOver()){
                     	Alert lose = new Alert(Alert.AlertType.INFORMATION);
     		             lose.setTitle("You lost");
     		             lose.setHeaderText("Close game");
     		             lose.setContentText("This is an alert.");
     		             lose.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             lose.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
                     }
                    
          
         } catch (NoAvailableResourcesException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Insufficient Supply");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         } catch (InvalidTargetException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Invalid Target");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         }

         }});
            

                 game = new Scene(gameLayout, 1470, 800);
               primaryStage.setScene(game);

                

                 });
         	
        b7.setOnAction(event -> {
        	 currentHero = Game.availableHeroes.get(6);
             Game.startGame(currentHero);
            
            
             gridPane.setAlignment(Pos.CENTER);
             
             for(int row=0;row<GRID_SIZE;row++){
             int rowMap=14-row;
             	for(int col1 =0;col1<GRID_SIZE;col1++){
            
           
            
                             if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                             ImageView jImageView = new ImageView(joel);
         jImageView.setFitWidth(50);  
         jImageView.setFitHeight(50);
             gridPane.add(jImageView, col1, row);

             }
                             else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView vaccineIV = new ImageView(vaccine);
             vaccineIV.setFitWidth(50);  
                         vaccineIV.setFitHeight(50);
             gridPane.add(vaccineIV, col1, row);
             }
                             else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView supplyIV = new ImageView(supply);
             supplyIV.setFitWidth(50);  
                         supplyIV.setFitHeight(50);
             gridPane.add(supplyIV, col1, row);
             }
                             else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
            
                             Rectangle square= createSquare();
             Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                    text.setFont(new Font(10));
                    l1.setTextFill(Color.BLACK);
                              
             gridPane.add(square, col1, row);
                        gridPane.add(text, col1, row);
                        
            
             }
                             else {
                 Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                 }
             }
            
             }

                  
             gameLayout.getChildren().add(gridPane);
                
                    
                      
                      gameLayout.setStyle("-fx-background-color: #000000;");
              
                    
              
                 Rectangle rectangle = new Rectangle(160, 150, Color.DARKGRAY);
                 Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                      text.setFont(Font.font("Arial", 14));
                      text.setFill(Color.BLACK);
                      
                    


                   gameLayout.setAlignment(Pos.TOP_RIGHT);


                     rectangle.setTranslateY(-10);

                
                 double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                     double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                    
                     text.relocate(textX, textY);
                     
                     
                 

                 
                 gameLayout.getChildren().addAll(rectangle,text);
                 

                
                     Button up = new Button("↑");
                     Button down = new Button("↓");
                 Button left = new Button("←");
                 Button right = new Button("→");
                    
                    
                     Button attack = new Button("ATTACK");
                     Button cure = new Button("CURE");
                     Button useSpecial = new Button("USE SPECIAL");
                     Button endTurn = new Button("END TURN");
                     

                    
                    
                     menuBar= new MenuBar();
                     fileMenu= new Menu("Select Zombie");
                     fileMenu2 = new Menu ("Select HeroTarget");
                 fileMenu3 = new Menu ("Pick a Hero");
                fileMenu4 = new Menu ("View Heroes Details");
                 fileMenu.setStyle("-fx-text-fill: white;");
                 fileMenu2.setStyle("-fx-text-fill: white;");
                 fileMenu3.setStyle("-fx-text-fill: white;");
                 fileMenu4.setStyle("-fx-text-fill: white;");
                     menuBar.setPrefWidth(50);
                     menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                     for(int i=0; i<Game.zombies.size();i++){
                      MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                      fileMenu.getItems().add(openMenuItem);
                      int x=i;
                      openMenuItem.setOnAction(event2->{
                      currentHero.setTarget(Game.zombies.get(x));
                      System.out.println(currentHero.getTarget());
                      });
                     }
                     for(int i=0; i<Game.heroes.size();i++){
                      MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                      fileMenu3.getItems().add(openMenuItem);
                      int x=i;
                      openMenuItem.setOnAction(event2->{
                      currentHero = Game.heroes.get(x);
                      
                      });
                     }
                     for(int i=0; i<Game.heroes.size();i++){
                      MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                      fileMenu2.getItems().add(openMenuItem);
                      int x=i;
                      openMenuItem.setOnAction(event2->{
                      currentHero.setTarget(Game.heroes.get(x));
                      System.out.println(currentHero.getTarget());
                      });
                     }
                     for(int i=0; i<Game.heroes.size();i++){
             			 if(Game.heroes.get(i) instanceof Fighter) {
          				  type = "Fighter";

          			 }
          			 else if(Game.heroes.get(i) instanceof Medic) {
          				 type = "Medic";

          			 }
          			 else {
          				type = "Explorer";
          			 }
             			 
             			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
             			 fileMenu4.getItems().add(openMenuItem);
          	            

          			 	
          		 }	
                     
                    
                  
                     menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                     gameLayout.getChildren().add(menuBar);
                    
                    
                    
                    
                     if(Game.checkWin()){
                     	Alert win = new Alert(Alert.AlertType.INFORMATION);
     		             win.setTitle("All done!");
     		             win.setHeaderText("Close game");
     		             win.setContentText("This is an alert.");
     		             win.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             win.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
            
                     }
                     if(Game.checkGameOver()){
                     	Alert lose = new Alert(Alert.AlertType.INFORMATION);
     		             lose.setTitle("You lost");
     		             lose.setHeaderText("Close game");
     		             lose.setContentText("This is an alert.");
     		             lose.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             lose.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
                     }
                    

                    
                     VBox buttonsBox = new VBox();              
                     buttonsBox.getChildren().addAll(menuBar,up,down,left,right,attack,cure,useSpecial, endTurn);
                     
                     
                     
                     
                     gameLayout.getChildren().add(buttonsBox);
                     buttonsBox.setAlignment(Pos.TOP_LEFT);
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    


                    up.setOnMouseClicked(new EventHandler<Event>() {  
         public void handle(Event event) {
         try {
         col = (int) currentHero.getLocation().getY();
                 xloc = (int) (15 -1 - currentHero.getLocation().getX());
                 if(Game.map[((int)currentHero.getLocation().getX()) + 1][(int) currentHero.getLocation().getY()]instanceof TrapCell) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Warning");
         alert.setContentText("You have entered a trap cell!");
         alert.showAndWait();
                 }
         currentHero.move(Direction.UP);
         for(int row=0;row<GRID_SIZE;row++){
             int rowMap=14-row;
             	for(int col1 =0;col1<GRID_SIZE;col1++){
            
           
            
                             if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                             ImageView jImageView = new ImageView(joel);
         jImageView.setFitWidth(50);  
         jImageView.setFitHeight(50);
             gridPane.add(jImageView, col1, row);

             }
                             else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView vaccineIV = new ImageView(vaccine);
             vaccineIV.setFitWidth(50);  
                         vaccineIV.setFitHeight(50);
             gridPane.add(vaccineIV, col1, row);
             }
                             else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView supplyIV = new ImageView(supply);
             supplyIV.setFitWidth(50);  
                         supplyIV.setFitHeight(50);
             gridPane.add(supplyIV, col1, row);
             }
                             else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
            
                             Rectangle square= createSquare();
             Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                    text.setFont(new Font(10));
                    l1.setTextFill(Color.BLACK);
                              
             gridPane.add(square, col1, row);
                        gridPane.add(text, col1, row);
                        
            
             }
                             else {
                 Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                 }
             }
            
             }
         Rectangle rectangle = new Rectangle(160, 150, Color.DARKGRAY);
         Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                     text.setFont(Font.font("Arial", 14));
                     text.setFill(Color.BLACK);
                 gameLayout.setAlignment(Pos.TOP_RIGHT);
                    rectangle.setTranslateY(-10);
                 double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                    double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                    text.relocate(textX, textY);
                gameLayout.getChildren().add(rectangle);
                 gameLayout.getChildren().add(text);
                 
                 
                 

          	
     		 	

                 
                 menuBar= new MenuBar();
                 fileMenu= new Menu("Select Zombie");
                 fileMenu2 = new Menu ("Select HeroTarget");
             fileMenu3 = new Menu ("Pick a Hero");
            fileMenu4 = new Menu ("View Heroes Details");
             fileMenu.setStyle("-fx-text-fill: white;");
             fileMenu2.setStyle("-fx-text-fill: white;");
             fileMenu3.setStyle("-fx-text-fill: white;");
             fileMenu4.setStyle("-fx-text-fill: white;");
                 menuBar.setPrefWidth(50);
                 menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                 for(int i=0; i<Game.zombies.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                  fileMenu.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero.setTarget(Game.zombies.get(x));
                  System.out.println(currentHero.getTarget());
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                  fileMenu3.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero = Game.heroes.get(x);
                  
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                  fileMenu2.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero.setTarget(Game.heroes.get(x));
                  System.out.println(currentHero.getTarget());
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
         			 if(Game.heroes.get(i) instanceof Fighter) {
      				  type = "Fighter";

      			 }
      			 else if(Game.heroes.get(i) instanceof Medic) {
      				 type = "Medic";

      			 }
      			 else {
      				type = "Explorer";
      			 }
         			 
         			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
         			 fileMenu4.getItems().add(openMenuItem);
      	            

      			 	
      		 }	
                 
                
              
                 menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                 gameLayout.getChildren().add(menuBar);

                    
                    


                     if(Game.checkWin()){
                     	Alert win = new Alert(Alert.AlertType.INFORMATION);
     		             win.setTitle("All done!");
     		             win.setHeaderText("Close game");
     		             win.setContentText("This is an alert.");
     		             win.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             win.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
            
                     }
                     if(Game.checkGameOver()){
                     	Alert lose = new Alert(Alert.AlertType.INFORMATION);
     		             lose.setTitle("You lost");
     		             lose.setHeaderText("Close game");
     		             lose.setContentText("This is an alert.");
     		             lose.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             lose.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
                     }
                     
                    
                               

         }
         catch (NotEnoughActionsException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Insufficient Actions");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         }

         catch (MovementException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Invalid Movement");
         
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         }
         }
         
                    });
                    down.setOnMouseClicked(new EventHandler<Event>() {
                  
             @Override
             public void handle(Event event) {
             try {
             col = (int) currentHero.getLocation().getY();
                     xloc = (int) (15 -1 - currentHero.getLocation().getX());
                     if(Game.map[((int)currentHero.getLocation().getX()) - 1][(int) currentHero.getLocation().getY()]instanceof TrapCell) {
                     Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Warning");
         alert.setContentText("You have entered a trap cell!");
         alert.showAndWait();
                     }
                    
                    
                     currentHero.move(Direction.DOWN);
                     for(int row=0;row<GRID_SIZE;row++){
                         int rowMap=14-row;
                         	for(int col1 =0;col1<GRID_SIZE;col1++){
                        
                       
                        
                                         if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                                         Rectangle square= createSquare();
                             gridPane.add(square,col1,row);
                                         ImageView jImageView = new ImageView(joel);
                     jImageView.setFitWidth(50);  
                     jImageView.setFitHeight(50);
                         gridPane.add(jImageView, col1, row);

                         }
                                         else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
                         Rectangle square= createSquare();
                             gridPane.add(square,col1,row);
                         ImageView vaccineIV = new ImageView(vaccine);
                         vaccineIV.setFitWidth(50);  
                                     vaccineIV.setFitHeight(50);
                         gridPane.add(vaccineIV, col1, row);
                         }
                                         else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
                         Rectangle square= createSquare();
                             gridPane.add(square,col1,row);
                         ImageView supplyIV = new ImageView(supply);
                         supplyIV.setFitWidth(50);  
                                     supplyIV.setFitHeight(50);
                         gridPane.add(supplyIV, col1, row);
                         }
                                         else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
                        
                                         Rectangle square= createSquare();
                         Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                                text.setFont(new Font(10));
                                l1.setTextFill(Color.BLACK);
                                          
                         gridPane.add(square, col1, row);
                                    gridPane.add(text, col1, row);
                                    
                        
                         }
                                         else {
                             Rectangle square= createSquare();
                             gridPane.add(square,col1,row);
                             }
                         }
                        
                         }
             Rectangle rectangle = new Rectangle(160, 150, Color.DARKGRAY);
             Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                       
             //Text text = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                          text.setFont(Font.font("Arial", 14));
                          text.setFill(Color.BLACK);
                       gameLayout.setAlignment(Pos.TOP_RIGHT);
                          rectangle.setTranslateY(-10);
                       double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                          double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                          text.relocate(textX, textY);
                      gameLayout.getChildren().add(rectangle);
                       gameLayout.getChildren().add(text);
                       
                                         
                       
                       menuBar= new MenuBar();
                       fileMenu= new Menu("Select Zombie");
                       fileMenu2 = new Menu ("Select HeroTarget");
                   fileMenu3 = new Menu ("Pick a Hero");
                  fileMenu4 = new Menu ("View Heroes Details");
                   fileMenu.setStyle("-fx-text-fill: white;");
                   fileMenu2.setStyle("-fx-text-fill: white;");
                   fileMenu3.setStyle("-fx-text-fill: white;");
                   fileMenu4.setStyle("-fx-text-fill: white;");
                       menuBar.setPrefWidth(50);
                       menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                       for(int i=0; i<Game.zombies.size();i++){
                        MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                        fileMenu.getItems().add(openMenuItem);
                        int x=i;
                        openMenuItem.setOnAction(event2->{
                        currentHero.setTarget(Game.zombies.get(x));
                        System.out.println(currentHero.getTarget());
                        });
                       }
                       for(int i=0; i<Game.heroes.size();i++){
                        MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                        fileMenu3.getItems().add(openMenuItem);
                        int x=i;
                        openMenuItem.setOnAction(event2->{
                        currentHero = Game.heroes.get(x);
                        
                        });
                       }
                       for(int i=0; i<Game.heroes.size();i++){
                        MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                        fileMenu2.getItems().add(openMenuItem);
                        int x=i;
                        openMenuItem.setOnAction(event2->{
                        currentHero.setTarget(Game.heroes.get(x));
                        System.out.println(currentHero.getTarget());
                        });
                       }
                       for(int i=0; i<Game.heroes.size();i++){
               			 if(Game.heroes.get(i) instanceof Fighter) {
            				  type = "Fighter";

            			 }
            			 else if(Game.heroes.get(i) instanceof Medic) {
            				 type = "Medic";

            			 }
            			 else {
            				type = "Explorer";
            			 }
               			 
               			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
               			 fileMenu4.getItems().add(openMenuItem);
            	            

            			 	
            		 }	
                       
                      
                    
                       menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                       gameLayout.getChildren().add(menuBar);
                        
                       if(Game.checkWin()){
                         	Alert win = new Alert(Alert.AlertType.INFORMATION);
         		             win.setTitle("All done!");
         		             win.setHeaderText("Close game");
         		             win.setContentText("This is an alert.");
         		             win.showAndWait().ifPresent(response -> {
         		                 if (response == ButtonType.OK) {
         		                     primaryStage.close();
         		                 }
         		             });
         		             win.setOnCloseRequest(close -> {
         		                 // Change the scene when the alert is closed
         		                 

         		                 primaryStage.close();
         		             });
                
                         }
                         if(Game.checkGameOver()){
                         	Alert lose = new Alert(Alert.AlertType.INFORMATION);
         		             lose.setTitle("You lost");
         		             lose.setHeaderText("Close game");
         		             lose.setContentText("This is an alert.");
         		             lose.showAndWait().ifPresent(response -> {
         		                 if (response == ButtonType.OK) {
         		                     primaryStage.close();
         		                 }
         		             });
         		             lose.setOnCloseRequest(close -> {
         		                 // Change the scene when the alert is closed
         		                 

         		                 primaryStage.close();
         		             });
                         }
                         
                        
                          
                    
             } catch (NotEnoughActionsException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Insufficient Actions");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         }

         catch (MovementException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Invalid Movement");
         alert.setContentText(e.getMessage());
         alert.showAndWait();

         }
         }
                      
                      
                 });

                    left.setOnMouseClicked(new EventHandler<Event>() {
                    
               @Override
               public void handle(Event event) {
               try {
               col = (int) currentHero.getLocation().getY();
                       xloc = (int) (15 -1 - currentHero.getLocation().getX());
                      
                       if(Game.map[((int)currentHero.getLocation().getX())][(int) currentHero.getLocation().getY() - 1]instanceof TrapCell) {
                       Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Warning");
             alert.setContentText("You have entered a trap cell!");
             alert.showAndWait();
                       }
                      
                      
                       currentHero.move(Direction.LEFT);
                       for(int row=0;row<GRID_SIZE;row++){
                           int rowMap=14-row;
                           	for(int col1 =0;col1<GRID_SIZE;col1++){
                          
                         
                          
                                           if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                                           Rectangle square= createSquare();
                               gridPane.add(square,col1,row);
                                           ImageView jImageView = new ImageView(joel);
                       jImageView.setFitWidth(50);  
                       jImageView.setFitHeight(50);
                           gridPane.add(jImageView, col1, row);

                           }
                                           else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
                           Rectangle square= createSquare();
                               gridPane.add(square,col1,row);
                           ImageView vaccineIV = new ImageView(vaccine);
                           vaccineIV.setFitWidth(50);  
                                       vaccineIV.setFitHeight(50);
                           gridPane.add(vaccineIV, col1, row);
                           }
                                           else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
                           Rectangle square= createSquare();
                               gridPane.add(square,col1,row);
                           ImageView supplyIV = new ImageView(supply);
                           supplyIV.setFitWidth(50);  
                                       supplyIV.setFitHeight(50);
                           gridPane.add(supplyIV, col1, row);
                           }
                                           else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
                          
                                           Rectangle square= createSquare();
                           Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                                  text.setFont(new Font(10));
                                  l1.setTextFill(Color.BLACK);
                                            
                           gridPane.add(square, col1, row);
                                      gridPane.add(text, col1, row);
                                      
                          
                           }
                                           else {
                               Rectangle square= createSquare();
                               gridPane.add(square,col1,row);
                               }
                           }
                          
                           }
               Rectangle rectangle = new Rectangle(160, 150, Color.DARKGRAY);
               Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                       //Text text = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                          text.setFont(Font.font("Arial", 14));
                          text.setFill(Color.BLACK);
                       gameLayout.setAlignment(Pos.TOP_RIGHT);
                          rectangle.setTranslateY(-10);
                       double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                          double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                          text.relocate(textX, textY);
                      gameLayout.getChildren().add(rectangle);
                       gameLayout.getChildren().add(text);
                       
                       
              
                       menuBar= new MenuBar();
                       fileMenu= new Menu("Select Zombie");
                       fileMenu2 = new Menu ("Select HeroTarget");
                   fileMenu3 = new Menu ("Pick a Hero");
                  fileMenu4 = new Menu ("View Heroes Details");
                   fileMenu.setStyle("-fx-text-fill: white;");
                   fileMenu2.setStyle("-fx-text-fill: white;");
                   fileMenu3.setStyle("-fx-text-fill: white;");
                   fileMenu4.setStyle("-fx-text-fill: white;");
                       menuBar.setPrefWidth(50);
                       menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                       for(int i=0; i<Game.zombies.size();i++){
                        MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                        fileMenu.getItems().add(openMenuItem);
                        int x=i;
                        openMenuItem.setOnAction(event2->{
                        currentHero.setTarget(Game.zombies.get(x));
                        System.out.println(currentHero.getTarget());
                        });
                       }
                       for(int i=0; i<Game.heroes.size();i++){
                        MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                        fileMenu3.getItems().add(openMenuItem);
                        int x=i;
                        openMenuItem.setOnAction(event2->{
                        currentHero = Game.heroes.get(x);
                        
                        });
                       }
                       for(int i=0; i<Game.heroes.size();i++){
                        MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                        fileMenu2.getItems().add(openMenuItem);
                        int x=i;
                        openMenuItem.setOnAction(event2->{
                        currentHero.setTarget(Game.heroes.get(x));
                        System.out.println(currentHero.getTarget());
                        });
                       }
                       for(int i=0; i<Game.heroes.size();i++){
               			 if(Game.heroes.get(i) instanceof Fighter) {
            				  type = "Fighter";

            			 }
            			 else if(Game.heroes.get(i) instanceof Medic) {
            				 type = "Medic";

            			 }
            			 else {
            				type = "Explorer";
            			 }
               			 
               			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
               			 fileMenu4.getItems().add(openMenuItem);
            	            

            			 	
            		 }	
                       
                      
                    
                       menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                       gameLayout.getChildren().add(menuBar);
                           
                           if(Game.checkWin()){
                           	Alert win = new Alert(Alert.AlertType.INFORMATION);
           		             win.setTitle("All done!");
           		             win.setHeaderText("Close game");
           		             win.setContentText("This is an alert.");
           		             win.showAndWait().ifPresent(response -> {
           		                 if (response == ButtonType.OK) {
           		                     primaryStage.close();
           		                 }
           		             });
           		             win.setOnCloseRequest(close -> {
           		                 // Change the scene when the alert is closed
           		                 

           		                 primaryStage.close();
           		             });
                  
                           }
                           if(Game.checkGameOver()){
                           	Alert lose = new Alert(Alert.AlertType.INFORMATION);
           		             lose.setTitle("You lost");
           		             lose.setHeaderText("Close game");
           		             lose.setContentText("This is an alert.");
           		             lose.showAndWait().ifPresent(response -> {
           		                 if (response == ButtonType.OK) {
           		                     primaryStage.close();
           		                 }
           		             });
           		             lose.setOnCloseRequest(close -> {
           		                 // Change the scene when the alert is closed
           		                 

           		                 primaryStage.close();
           		             });
                           }
                          
                      
               } catch (NotEnoughActionsException e) {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Insufficient Actions");
             alert.setContentText(e.getMessage());
             alert.showAndWait();
             }

             catch (MovementException e) {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Invalid Movement");
             alert.setContentText(e.getMessage());
             alert.showAndWait();
            
             }
             }
                        });
                    right.setOnMouseClicked(new EventHandler<Event>() {
                    
               @Override
               public void handle(Event event) {
               try {
               col = (int) currentHero.getLocation().getY();
                       xloc = (int) (15 -1 - currentHero.getLocation().getX());
                         if(Game.map[((int)currentHero.getLocation().getX())][(int) currentHero.getLocation().getY() + 1]instanceof TrapCell) {
                         Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Warning");
             alert.setContentText("You have entered a trap cell");
             alert.showAndWait();
                         }

               currentHero.move(Direction.RIGHT);
               for(int row=0;row<GRID_SIZE;row++){
                   int rowMap=14-row;
                   	for(int col1 =0;col1<GRID_SIZE;col1++){
                  
                 
                  
                                   if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                                   Rectangle square= createSquare();
                       gridPane.add(square,col1,row);
                                   ImageView jImageView = new ImageView(joel);
               jImageView.setFitWidth(50);  
               jImageView.setFitHeight(50);
                   gridPane.add(jImageView, col1, row);

                   }
                                   else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
                   Rectangle square= createSquare();
                       gridPane.add(square,col1,row);
                   ImageView vaccineIV = new ImageView(vaccine);
                   vaccineIV.setFitWidth(50);  
                               vaccineIV.setFitHeight(50);
                   gridPane.add(vaccineIV, col1, row);
                   }
                                   else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
                   Rectangle square= createSquare();
                       gridPane.add(square,col1,row);
                   ImageView supplyIV = new ImageView(supply);
                   supplyIV.setFitWidth(50);  
                               supplyIV.setFitHeight(50);
                   gridPane.add(supplyIV, col1, row);
                   }
                                   else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
                  
                                   Rectangle square= createSquare();
                   Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                          text.setFont(new Font(10));
                          l1.setTextFill(Color.BLACK);
                                    
                   gridPane.add(square, col1, row);
                              gridPane.add(text, col1, row);
                              
                  
                   }
                                   else {
                       Rectangle square= createSquare();
                       gridPane.add(square,col1,row);
                       }
                   }
                  
                   }
              
               Rectangle rectangle = new Rectangle(160, 150, Color.DARKGRAY);
               Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                     //  Text text = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                      text.setFont(Font.font("Arial", 14));
                      text.setFill(Color.BLACK);
                   gameLayout.setAlignment(Pos.TOP_RIGHT);
                      rectangle.setTranslateY(-10);
                   double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                      double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                      text.relocate(textX, textY);
                  gameLayout.getChildren().add(rectangle);
                   gameLayout.getChildren().add(text);
                   
                              
                  
                   menuBar= new MenuBar();
                   fileMenu= new Menu("Select Zombie");
                   fileMenu2 = new Menu ("Select HeroTarget");
               fileMenu3 = new Menu ("Pick a Hero");
              fileMenu4 = new Menu ("View Heroes Details");
               fileMenu.setStyle("-fx-text-fill: white;");
               fileMenu2.setStyle("-fx-text-fill: white;");
               fileMenu3.setStyle("-fx-text-fill: white;");
               fileMenu4.setStyle("-fx-text-fill: white;");
                   menuBar.setPrefWidth(50);
                   menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                   for(int i=0; i<Game.zombies.size();i++){
                    MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                    fileMenu.getItems().add(openMenuItem);
                    int x=i;
                    openMenuItem.setOnAction(event2->{
                    currentHero.setTarget(Game.zombies.get(x));
                    System.out.println(currentHero.getTarget());
                    });
                   }
                   for(int i=0; i<Game.heroes.size();i++){
                    MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                    fileMenu3.getItems().add(openMenuItem);
                    int x=i;
                    openMenuItem.setOnAction(event2->{
                    currentHero = Game.heroes.get(x);
                    
                    });
                   }
                   for(int i=0; i<Game.heroes.size();i++){
                    MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                    fileMenu2.getItems().add(openMenuItem);
                    int x=i;
                    openMenuItem.setOnAction(event2->{
                    currentHero.setTarget(Game.heroes.get(x));
                    System.out.println(currentHero.getTarget());
                    });
                   }
                   for(int i=0; i<Game.heroes.size();i++){
           			 if(Game.heroes.get(i) instanceof Fighter) {
        				  type = "Fighter";

        			 }
        			 else if(Game.heroes.get(i) instanceof Medic) {
        				 type = "Medic";

        			 }
        			 else {
        				type = "Explorer";
        			 }
           			 
           			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
           			 fileMenu4.getItems().add(openMenuItem);
        	            

        			 	
        		 }	
                   
                  
                
                   menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                   gameLayout.getChildren().add(menuBar);
                  
                       if(Game.checkWin()){
                       	Alert win = new Alert(Alert.AlertType.INFORMATION);
       		             win.setTitle("All done!");
       		             win.setHeaderText("Close game");
       		             win.setContentText("This is an alert.");
       		             win.showAndWait().ifPresent(response -> {
       		                 if (response == ButtonType.OK) {
       		                     primaryStage.close();
       		                 }
       		             });
       		             win.setOnCloseRequest(close -> {
       		                 // Change the scene when the alert is closed
       		                 

       		                 primaryStage.close();
       		             });
              
                       }
                       if(Game.checkGameOver()){
                       	Alert lose = new Alert(Alert.AlertType.INFORMATION);
       		             lose.setTitle("You lost");
       		             lose.setHeaderText("Close game");
       		             lose.setContentText("This is an alert.");
       		             lose.showAndWait().ifPresent(response -> {
       		                 if (response == ButtonType.OK) {
       		                     primaryStage.close();
       		                 }
       		             });
       		             lose.setOnCloseRequest(close -> {
       		                 // Change the scene when the alert is closed
       		                 

       		                 primaryStage.close();
       		             });
                       }
                      
                      
               } catch (NotEnoughActionsException e) {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Insufficient Actions");
             alert.setContentText(e.getMessage());
             alert.showAndWait();
             }

               catch (MovementException e) {
             	    Alert alert = new Alert(Alert.AlertType.INFORMATION);
             	    alert.setTitle("Invalid Movement");
             	    
             	    alert.setContentText(e.getMessage());
             	    alert.showAndWait();
             	    }
             	    }
             
                        });
                   
                    
                    
                   
                    
                    
                    attack.setOnAction(event2 -> {
                 	   
                     try {

                        

                         currentHero.attack();
                      

                         for(int row=0;row<GRID_SIZE;row++){
                             int rowMap=14-row;
                             	for(int col1 =0;col1<GRID_SIZE;col1++){
                            
                           
                            
                                             if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                                             Rectangle square= createSquare();
                                 gridPane.add(square,col1,row);
                                             ImageView jImageView = new ImageView(joel);
                         jImageView.setFitWidth(50);  
                         jImageView.setFitHeight(50);
                             gridPane.add(jImageView, col1, row);

                             }
                                             else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
                             Rectangle square= createSquare();
                                 gridPane.add(square,col1,row);
                             ImageView vaccineIV = new ImageView(vaccine);
                             vaccineIV.setFitWidth(50);  
                                         vaccineIV.setFitHeight(50);
                             gridPane.add(vaccineIV, col1, row);
                             }
                                             else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
                             Rectangle square= createSquare();
                                 gridPane.add(square,col1,row);
                             ImageView supplyIV = new ImageView(supply);
                             supplyIV.setFitWidth(50);  
                                         supplyIV.setFitHeight(50);
                             gridPane.add(supplyIV, col1, row);
                             }
                                             else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
                            
                                             Rectangle square= createSquare();
                             Label text2 = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                                    text2.setFont(new Font(10));
                                    l1.setTextFill(Color.BLACK);
                                              
                             gridPane.add(square, col1, row);
                                        gridPane.add(text2, col1, row);
                                        
                            
                             }
                                             else {
                                 Rectangle square= createSquare();
                                 gridPane.add(square,col1,row);
                                 }
                             }
                            
                             }

                   
                     
                    Rectangle rectangle2 = new Rectangle(160, 150, Color.DARKGRAY);
                    Text text2 = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                    // Text text2 = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                         text2.setFont(Font.font("Arial", 14));
                         text2.setFill(Color.BLACK);
                         gameLayout.setAlignment(Pos.TOP_RIGHT);

                         rectangle2.setTranslateY(-10);
                        
                    
                     double textX2 = rectangle2.getX() + (rectangle2.getWidth() - text2.getLayoutBounds().getWidth()) / 2;
                         double textY2= rectangle2.getY() + (rectangle2.getHeight() + text2.getLayoutBounds().getHeight()) / 2;
                         text2.relocate(textX2, textY2);
                     gameLayout.getChildren().add(rectangle2);
                     gameLayout.getChildren().add(text2);
                     
                     
                     
                     menuBar= new MenuBar();
                     fileMenu= new Menu("Select Zombie");
                     fileMenu2 = new Menu ("Select HeroTarget");
                 fileMenu3 = new Menu ("Pick a Hero");
                fileMenu4 = new Menu ("View Heroes Details");
                 fileMenu.setStyle("-fx-text-fill: white;");
                 fileMenu2.setStyle("-fx-text-fill: white;");
                 fileMenu3.setStyle("-fx-text-fill: white;");
                 fileMenu4.setStyle("-fx-text-fill: white;");
                     menuBar.setPrefWidth(50);
                     menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                     for(int i=0; i<Game.zombies.size();i++){
                      MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                      fileMenu.getItems().add(openMenuItem);
                      int x=i;
                      openMenuItem.setOnAction(event3->{
                      currentHero.setTarget(Game.zombies.get(x));
                      System.out.println(currentHero.getTarget());
                      });
                     }
                     for(int i=0; i<Game.heroes.size();i++){
                      MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                      fileMenu3.getItems().add(openMenuItem);
                      int x=i;
                      openMenuItem.setOnAction(event3->{
                      currentHero = Game.heroes.get(x);
                      
                      });
                     }
                     for(int i=0; i<Game.heroes.size();i++){
                      MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                      fileMenu2.getItems().add(openMenuItem);
                      int x=i;
                      openMenuItem.setOnAction(event3->{
                      currentHero.setTarget(Game.heroes.get(x));
                      System.out.println(currentHero.getTarget());
                      });
                     }
                     for(int i=0; i<Game.heroes.size();i++){
             			 if(Game.heroes.get(i) instanceof Fighter) {
          				  type = "Fighter";

          			 }
          			 else if(Game.heroes.get(i) instanceof Medic) {
          				 type = "Medic";

          			 }
          			 else {
          				type = "Explorer";
          			 }
             			 
             			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
             			 fileMenu4.getItems().add(openMenuItem);
          	            

          			 	
          		 }	
                     
                    
                  
                     menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                     gameLayout.getChildren().add(menuBar);
                     
                    
                     if(Game.checkWin()){
                     	Alert win = new Alert(Alert.AlertType.INFORMATION);
     		             win.setTitle("All done!");
     		             win.setHeaderText("Close game");
     		             win.setContentText("This is an alert.");
     		             win.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             win.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
            
                     }
                     if(Game.checkGameOver()){
                     	Alert lose = new Alert(Alert.AlertType.INFORMATION);
     		             lose.setTitle("You lost");
     		             lose.setHeaderText("Close game");
     		             lose.setContentText("This is an alert.");
     		             lose.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             lose.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
                     }
                     
            
             } catch (NotEnoughActionsException e) {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Insufficient Actions");
             alert.setContentText(e.getMessage());
         alert.showAndWait();

             } catch (InvalidTargetException e) {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Invalid Target");
             alert.setContentText(e.getMessage());
         alert.showAndWait();

             }
                    });
                    
                    
                    
                    cure.setOnMouseClicked(new EventHandler< Event >(){

         @Override
         public void handle(Event arg0) {
         try {
         currentHero.cure();
         for(int row=0;row<GRID_SIZE;row++){
             int rowMap=14-row;
             	for(int col1 =0;col1<GRID_SIZE;col1++){
            
           
            
                             if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                             ImageView jImageView = new ImageView(joel);
         jImageView.setFitWidth(50);  
         jImageView.setFitHeight(50);
             gridPane.add(jImageView, col1, row);

             }
                             else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView vaccineIV = new ImageView(vaccine);
             vaccineIV.setFitWidth(50);  
                         vaccineIV.setFitHeight(50);
             gridPane.add(vaccineIV, col1, row);
             }
                             else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView supplyIV = new ImageView(supply);
             supplyIV.setFitWidth(50);  
                         supplyIV.setFitHeight(50);
             gridPane.add(supplyIV, col1, row);
             }
                             else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
            
                             Rectangle square= createSquare();
             Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                    text.setFont(new Font(10));
                    l1.setTextFill(Color.BLACK);
                              
             gridPane.add(square, col1, row);
                        gridPane.add(text, col1, row);
                        
            
             }
                             else {
                 Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                 }
             }
            
             }
         
         
         Rectangle rectangle = new Rectangle(160, 120, Color.DARKGRAY);
         Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                  // Text text = new Text("\n" + Game.heroes.get(Game.heroes.size()-1).getName() + "\nCurrent Hp: " + Game.heroes.get(Game.heroes.size()-1).getCurrentHp() + "\nActions available: " +  Game.heroes.get(Game.heroes.size()-1).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(Game.heroes.size()-1).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                    text.setFont(Font.font("Arial", 14));
                    text.setFill(Color.BLACK);
                 gameLayout.setAlignment(Pos.TOP_RIGHT);
                    rectangle.setTranslateY(-10);
                 double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                    double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                    text.relocate(textX, textY);
                gameLayout.getChildren().add(rectangle);
                 gameLayout.getChildren().add(text);
                 
                 
                 
                 menuBar= new MenuBar();
                 fileMenu= new Menu("Select Zombie");
                 fileMenu2 = new Menu ("Select HeroTarget");
             fileMenu3 = new Menu ("Pick a Hero");
            fileMenu4 = new Menu ("View Heroes Details");
             fileMenu.setStyle("-fx-text-fill: white;");
             fileMenu2.setStyle("-fx-text-fill: white;");
             fileMenu3.setStyle("-fx-text-fill: white;");
             fileMenu4.setStyle("-fx-text-fill: white;");
                 menuBar.setPrefWidth(50);
                 menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                 for(int i=0; i<Game.zombies.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                  fileMenu.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero.setTarget(Game.zombies.get(x));
                  System.out.println(currentHero.getTarget());
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                  fileMenu3.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero = Game.heroes.get(x);
                  
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                  fileMenu2.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero.setTarget(Game.heroes.get(x));
                  System.out.println(currentHero.getTarget());
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
         			 if(Game.heroes.get(i) instanceof Fighter) {
      				  type = "Fighter";

      			 }
      			 else if(Game.heroes.get(i) instanceof Medic) {
      				 type = "Medic";

      			 }
      			 else {
      				type = "Explorer";
      			 }
         			 
         			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
         			 fileMenu4.getItems().add(openMenuItem);
      	            

      			 	
      		 }	
                 
                
              
                 menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                 gameLayout.getChildren().add(menuBar);
                    
                    
                
                     if(Game.checkWin()){
                     	Alert win = new Alert(Alert.AlertType.INFORMATION);
     		             win.setTitle("All done!");
     		             win.setHeaderText("Close game");
     		             win.setContentText("This is an alert.");
     		             win.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             win.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
            
                     }
                     if(Game.checkGameOver()){
                     	Alert lose = new Alert(Alert.AlertType.INFORMATION);
     		             lose.setTitle("You lost");
     		             lose.setHeaderText("Close game");
     		             lose.setContentText("This is an alert.");
     		             lose.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             lose.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
                     }
                     
                               
         } catch (NoAvailableResourcesException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Insufficient resources");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         } catch (InvalidTargetException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Invalid Target");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         } catch (NotEnoughActionsException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Insufficient Actions");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         }
         }
                  
                    });
                    
                    
                    
                    endTurn.setOnMouseClicked(new EventHandler<Event>(){

         @Override
         public void handle(Event event3) {
         try {
         Game.endTurn();

         if(Game.checkWin()){
         	Alert win = new Alert(Alert.AlertType.INFORMATION);
              win.setTitle("All done!");
              win.setHeaderText("Close game");
              win.setContentText("This is an alert.");
              win.showAndWait().ifPresent(response -> {
                  if (response == ButtonType.OK) {
                      primaryStage.close();
                  }
              });
              win.setOnCloseRequest(close -> {
                  // Change the scene when the alert is closed
                  

                  primaryStage.close();
              });

         }
         if(Game.checkGameOver()){
         	Alert lose = new Alert(Alert.AlertType.INFORMATION);
              lose.setTitle("You lost");
              lose.setHeaderText("Close game");
              lose.setContentText("This is an alert.");
              lose.showAndWait().ifPresent(response -> {
                  if (response == ButtonType.OK) {
                      primaryStage.close();
                  }
              });
              lose.setOnCloseRequest(close -> {
                  // Change the scene when the alert is closed
                  

                  primaryStage.close();
              });
         }

         for(int row=0;row<GRID_SIZE;row++){
             int rowMap=14-row;
             	for(int col1 =0;col1<GRID_SIZE;col1++){
            
           
            
                             if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                             ImageView jImageView = new ImageView(joel);
         jImageView.setFitWidth(50);  
         jImageView.setFitHeight(50);
             gridPane.add(jImageView, col1, row);

             }
                             else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView vaccineIV = new ImageView(vaccine);
             vaccineIV.setFitWidth(50);  
                         vaccineIV.setFitHeight(50);
             gridPane.add(vaccineIV, col1, row);
             }
                             else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView supplyIV = new ImageView(supply);
             supplyIV.setFitWidth(50);  
                         supplyIV.setFitHeight(50);
             gridPane.add(supplyIV, col1, row);
             }
                             else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
            
                             Rectangle square= createSquare();
             Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                    text.setFont(new Font(10));
                    l1.setTextFill(Color.BLACK);
                              
             gridPane.add(square, col1, row);
                        gridPane.add(text, col1, row);
                        
            
             }
                             else {
                 Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                 }
             }
            
             }
         Rectangle rectangle = new Rectangle(160, 120, Color.DARKGRAY);
         Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                   //Text text = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                    text.setFont(Font.font("Arial", 14));
                    text.setFill(Color.BLACK);
                 gameLayout.setAlignment(Pos.TOP_RIGHT);
                    rectangle.setTranslateY(-10);
                 double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                    double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                    text.relocate(textX, textY);
                gameLayout.getChildren().add(rectangle);
                 gameLayout.getChildren().add(text);
                 
                 
                 
                 menuBar= new MenuBar();
                 fileMenu= new Menu("Select Zombie");
                 fileMenu2 = new Menu ("Select HeroTarget");
             fileMenu3 = new Menu ("Pick a Hero");
            fileMenu4 = new Menu ("View Heroes Details");
             fileMenu.setStyle("-fx-text-fill: white;");
             fileMenu2.setStyle("-fx-text-fill: white;");
             fileMenu3.setStyle("-fx-text-fill: white;");
             fileMenu4.setStyle("-fx-text-fill: white;");
                 menuBar.setPrefWidth(50);
                 menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                 for(int i=0; i<Game.zombies.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                  fileMenu.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero.setTarget(Game.zombies.get(x));
                  System.out.println(currentHero.getTarget());
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                  fileMenu3.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero = Game.heroes.get(x);
                  
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                  fileMenu2.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero.setTarget(Game.heroes.get(x));
                  System.out.println(currentHero.getTarget());
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
         			 if(Game.heroes.get(i) instanceof Fighter) {
      				  type = "Fighter";

      			 }
      			 else if(Game.heroes.get(i) instanceof Medic) {
      				 type = "Medic";

      			 }
      			 else {
      				type = "Explorer";
      			 }
         			 
         			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
         			 fileMenu4.getItems().add(openMenuItem);
      	            

      			 	
      		 }	
                 
                
              
                 menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                 gameLayout.getChildren().add(menuBar);
                     
                    
         } catch (NotEnoughActionsException e) {

         } catch (InvalidTargetException e) {

         }
         }
                  
                    });
                    
                    useSpecial.setOnMouseClicked(new EventHandler< Event >(){

         @Override
         public void handle(Event event) {
         try {
         currentHero.useSpecial();
         for(int row=0;row<GRID_SIZE;row++){
             int rowMap=14-row;
             	for(int col1 =0;col1<GRID_SIZE;col1++){
            
           
            
                             if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                             ImageView jImageView = new ImageView(joel);
         jImageView.setFitWidth(50);  
         jImageView.setFitHeight(50);
             gridPane.add(jImageView, col1, row);

             }
                             else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView vaccineIV = new ImageView(vaccine);
             vaccineIV.setFitWidth(50);  
                         vaccineIV.setFitHeight(50);
             gridPane.add(vaccineIV, col1, row);
             }
                             else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView supplyIV = new ImageView(supply);
             supplyIV.setFitWidth(50);  
                         supplyIV.setFitHeight(50);
             gridPane.add(supplyIV, col1, row);
             }
                             else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
            
                             Rectangle square= createSquare();
             Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                    text.setFont(new Font(10));
                    l1.setTextFill(Color.BLACK);
                              
             gridPane.add(square, col1, row);
                        gridPane.add(text, col1, row);
                        
            
             }
                             else {
                 Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                 }
             }
            
             }
         Rectangle rectangle = new Rectangle(160, 120, Color.DARKGRAY);
         Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                  // Text text = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                    text.setFont(Font.font("Arial", 14));
                    text.setFill(Color.BLACK);
                 gameLayout.setAlignment(Pos.TOP_RIGHT);
                    rectangle.setTranslateY(-10);
                 double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                    double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                    text.relocate(textX, textY);
                gameLayout.getChildren().add(rectangle);
                gameLayout.getChildren().add(text);

                menuBar= new MenuBar();
                fileMenu= new Menu("Select Zombie");
                fileMenu2 = new Menu ("Select HeroTarget");
            fileMenu3 = new Menu ("Pick a Hero");
           fileMenu4 = new Menu ("View Heroes Details");
            fileMenu.setStyle("-fx-text-fill: white;");
            fileMenu2.setStyle("-fx-text-fill: white;");
            fileMenu3.setStyle("-fx-text-fill: white;");
            fileMenu4.setStyle("-fx-text-fill: white;");
                menuBar.setPrefWidth(50);
                menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                for(int i=0; i<Game.zombies.size();i++){
                 MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                 fileMenu.getItems().add(openMenuItem);
                 int x=i;
                 openMenuItem.setOnAction(event2->{
                 currentHero.setTarget(Game.zombies.get(x));
                 System.out.println(currentHero.getTarget());
                 });
                }
                for(int i=0; i<Game.heroes.size();i++){
                 MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                 fileMenu3.getItems().add(openMenuItem);
                 int x=i;
                 openMenuItem.setOnAction(event2->{
                 currentHero = Game.heroes.get(x);
                 
                 });
                }
                for(int i=0; i<Game.heroes.size();i++){
                 MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                 fileMenu2.getItems().add(openMenuItem);
                 int x=i;
                 openMenuItem.setOnAction(event2->{
                 currentHero.setTarget(Game.heroes.get(x));
                 System.out.println(currentHero.getTarget());
                 });
                }
                for(int i=0; i<Game.heroes.size();i++){
        			 if(Game.heroes.get(i) instanceof Fighter) {
     				  type = "Fighter";

     			 }
     			 else if(Game.heroes.get(i) instanceof Medic) {
     				 type = "Medic";

     			 }
     			 else {
     				type = "Explorer";
     			 }
        			 
        			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
        			 fileMenu4.getItems().add(openMenuItem);
     	            

     			 	
     		 }	
                
               
             
                menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                gameLayout.getChildren().add(menuBar);
                    
                     if(Game.checkWin()){
                     	Alert win = new Alert(Alert.AlertType.INFORMATION);
     		             win.setTitle("All done!");
     		             win.setHeaderText("Close game");
     		             win.setContentText("This is an alert.");
     		             win.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             win.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
            
                     }
                     if(Game.checkGameOver()){
                     	Alert lose = new Alert(Alert.AlertType.INFORMATION);
     		             lose.setTitle("You lost");
     		             lose.setHeaderText("Close game");
     		             lose.setContentText("This is an alert.");
     		             lose.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             lose.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
                     }
                    
          
         } catch (NoAvailableResourcesException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Insufficient Supply");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         } catch (InvalidTargetException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Invalid Target");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         }

         }});
            

                 game = new Scene(gameLayout, 1470, 800);
               primaryStage.setScene(game);

                

                 });
         	
        b8.setOnAction(event -> {
        	 currentHero = Game.availableHeroes.get(7);
             Game.startGame(currentHero);
            
            
             gridPane.setAlignment(Pos.CENTER);
             
             for(int row=0;row<GRID_SIZE;row++){
             int rowMap=14-row;
             	for(int col1 =0;col1<GRID_SIZE;col1++){
            
           
            
                             if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                             ImageView jImageView = new ImageView(joel);
         jImageView.setFitWidth(50);  
         jImageView.setFitHeight(50);
             gridPane.add(jImageView, col1, row);

             }
                             else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView vaccineIV = new ImageView(vaccine);
             vaccineIV.setFitWidth(50);  
                         vaccineIV.setFitHeight(50);
             gridPane.add(vaccineIV, col1, row);
             }
                             else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView supplyIV = new ImageView(supply);
             supplyIV.setFitWidth(50);  
                         supplyIV.setFitHeight(50);
             gridPane.add(supplyIV, col1, row);
             }
                             else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
            
                             Rectangle square= createSquare();
             Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                    text.setFont(new Font(10));
                    l1.setTextFill(Color.BLACK);
                              
             gridPane.add(square, col1, row);
                        gridPane.add(text, col1, row);
                        
            
             }
                             else {
                 Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                 }
             }
            
             }

                  
             gameLayout.getChildren().add(gridPane);
                
                    
                      
                      gameLayout.setStyle("-fx-background-color: #000000;");
              
                    
              
                 Rectangle rectangle = new Rectangle(160, 150, Color.DARKGRAY);
                 Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Medic" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                      text.setFont(Font.font("Arial", 14));
                      text.setFill(Color.BLACK);
                      
                    


                   gameLayout.setAlignment(Pos.TOP_RIGHT);


                     rectangle.setTranslateY(-10);

                
                 double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                     double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                    
                     text.relocate(textX, textY);
                     
                     
                 

                 
                 gameLayout.getChildren().addAll(rectangle,text);
                 

                
                     Button up = new Button("↑");
                     Button down = new Button("↓");
                 Button left = new Button("←");
                 Button right = new Button("→");
                    
                    
                     Button attack = new Button("ATTACK");
                     Button cure = new Button("CURE");
                     Button useSpecial = new Button("USE SPECIAL");
                     Button endTurn = new Button("END TURN");
                     

                    
                    
                     menuBar= new MenuBar();
                     fileMenu= new Menu("Select Zombie");
                     fileMenu2 = new Menu ("Select HeroTarget");
                 fileMenu3 = new Menu ("Pick a Hero");
                fileMenu4 = new Menu ("View Heroes Details");
                 fileMenu.setStyle("-fx-text-fill: white;");
                 fileMenu2.setStyle("-fx-text-fill: white;");
                 fileMenu3.setStyle("-fx-text-fill: white;");
                 fileMenu4.setStyle("-fx-text-fill: white;");
                     menuBar.setPrefWidth(50);
                     menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                     for(int i=0; i<Game.zombies.size();i++){
                      MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                      fileMenu.getItems().add(openMenuItem);
                      int x=i;
                      openMenuItem.setOnAction(event2->{
                      currentHero.setTarget(Game.zombies.get(x));
                      System.out.println(currentHero.getTarget());
                      });
                     }
                     for(int i=0; i<Game.heroes.size();i++){
                      MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                      fileMenu3.getItems().add(openMenuItem);
                      int x=i;
                      openMenuItem.setOnAction(event2->{
                      currentHero = Game.heroes.get(x);
                      
                      });
                     }
                     for(int i=0; i<Game.heroes.size();i++){
                      MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                      fileMenu2.getItems().add(openMenuItem);
                      int x=i;
                      openMenuItem.setOnAction(event2->{
                      currentHero.setTarget(Game.heroes.get(x));
                      System.out.println(currentHero.getTarget());
                      });
                     }
                     for(int i=0; i<Game.heroes.size();i++){
             			 if(Game.heroes.get(i) instanceof Fighter) {
          				  type = "Fighter";

          			 }
          			 else if(Game.heroes.get(i) instanceof Medic) {
          				 type = "Medic";

          			 }
          			 else {
          				type = "Explorer";
          			 }
             			 
             			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
             			 fileMenu4.getItems().add(openMenuItem);
          	            

          			 	
          		 }	
                     
                    
                  
                     menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                     gameLayout.getChildren().add(menuBar);
                    
                    
                    
                    
                     if(Game.checkWin()){
                     	Alert win = new Alert(Alert.AlertType.INFORMATION);
     		             win.setTitle("All done!");
     		             win.setHeaderText("Close game");
     		             win.setContentText("This is an alert.");
     		             win.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             win.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
            
                     }
                     if(Game.checkGameOver()){
                     	Alert lose = new Alert(Alert.AlertType.INFORMATION);
     		             lose.setTitle("You lost");
     		             lose.setHeaderText("Close game");
     		             lose.setContentText("This is an alert.");
     		             lose.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             lose.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
                     }
                    

                    
                     VBox buttonsBox = new VBox();              
                     buttonsBox.getChildren().addAll(menuBar,up,down,left,right,attack,cure,useSpecial, endTurn);
                     
                     
                     
                     
                     gameLayout.getChildren().add(buttonsBox);
                     buttonsBox.setAlignment(Pos.TOP_LEFT);
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    


                    up.setOnMouseClicked(new EventHandler<Event>() {  
         public void handle(Event event) {
         try {
         col = (int) currentHero.getLocation().getY();
                 xloc = (int) (15 -1 - currentHero.getLocation().getX());
                 if(Game.map[((int)currentHero.getLocation().getX()) + 1][(int) currentHero.getLocation().getY()]instanceof TrapCell) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Warning");
         alert.setContentText("You have entered a trap cell!");
         alert.showAndWait();
                 }
         currentHero.move(Direction.UP);
         for(int row=0;row<GRID_SIZE;row++){
             int rowMap=14-row;
             	for(int col1 =0;col1<GRID_SIZE;col1++){
            
           
            
                             if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                             ImageView jImageView = new ImageView(joel);
         jImageView.setFitWidth(50);  
         jImageView.setFitHeight(50);
             gridPane.add(jImageView, col1, row);

             }
                             else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView vaccineIV = new ImageView(vaccine);
             vaccineIV.setFitWidth(50);  
                         vaccineIV.setFitHeight(50);
             gridPane.add(vaccineIV, col1, row);
             }
                             else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView supplyIV = new ImageView(supply);
             supplyIV.setFitWidth(50);  
                         supplyIV.setFitHeight(50);
             gridPane.add(supplyIV, col1, row);
             }
                             else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
            
                             Rectangle square= createSquare();
             Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                    text.setFont(new Font(10));
                    l1.setTextFill(Color.BLACK);
                              
             gridPane.add(square, col1, row);
                        gridPane.add(text, col1, row);
                        
            
             }
                             else {
                 Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                 }
             }
            
             }
         Rectangle rectangle = new Rectangle(160, 150, Color.DARKGRAY);
         Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Medic" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                     text.setFont(Font.font("Arial", 14));
                     text.setFill(Color.BLACK);
                 gameLayout.setAlignment(Pos.TOP_RIGHT);
                    rectangle.setTranslateY(-10);
                 double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                    double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                    text.relocate(textX, textY);
                gameLayout.getChildren().add(rectangle);
                 gameLayout.getChildren().add(text);
                 
                 
                 

          	
     		 	

                 
                 menuBar= new MenuBar();
                 fileMenu= new Menu("Select Zombie");
                 fileMenu2 = new Menu ("Select HeroTarget");
             fileMenu3 = new Menu ("Pick a Hero");
            fileMenu4 = new Menu ("View Heroes Details");
             fileMenu.setStyle("-fx-text-fill: white;");
             fileMenu2.setStyle("-fx-text-fill: white;");
             fileMenu3.setStyle("-fx-text-fill: white;");
             fileMenu4.setStyle("-fx-text-fill: white;");
                 menuBar.setPrefWidth(50);
                 menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                 for(int i=0; i<Game.zombies.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                  fileMenu.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero.setTarget(Game.zombies.get(x));
                  System.out.println(currentHero.getTarget());
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                  fileMenu3.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero = Game.heroes.get(x);
                  
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                  fileMenu2.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero.setTarget(Game.heroes.get(x));
                  System.out.println(currentHero.getTarget());
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
         			 if(Game.heroes.get(i) instanceof Fighter) {
      				  type = "Fighter";

      			 }
      			 else if(Game.heroes.get(i) instanceof Medic) {
      				 type = "Medic";

      			 }
      			 else {
      				type = "Explorer";
      			 }
         			 
         			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
         			 fileMenu4.getItems().add(openMenuItem);
      	            

      			 	
      		 }	
                 
                
              
                 menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                 gameLayout.getChildren().add(menuBar);

                    
                    


                     if(Game.checkWin()){
                     	Alert win = new Alert(Alert.AlertType.INFORMATION);
     		             win.setTitle("All done!");
     		             win.setHeaderText("Close game");
     		             win.setContentText("This is an alert.");
     		             win.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             win.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
            
                     }
                     if(Game.checkGameOver()){
                     	Alert lose = new Alert(Alert.AlertType.INFORMATION);
     		             lose.setTitle("You lost");
     		             lose.setHeaderText("Close game");
     		             lose.setContentText("This is an alert.");
     		             lose.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             lose.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
                     }
                     
                    
                               

         }
         catch (NotEnoughActionsException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Insufficient Actions");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         }

         catch (MovementException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Invalid Movement");
         
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         }
         }
         
                    });
                    down.setOnMouseClicked(new EventHandler<Event>() {
                  
             @Override
             public void handle(Event event) {
             try {
             col = (int) currentHero.getLocation().getY();
                     xloc = (int) (15 -1 - currentHero.getLocation().getX());
                     if(Game.map[((int)currentHero.getLocation().getX()) - 1][(int) currentHero.getLocation().getY()]instanceof TrapCell) {
                     Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Warning");
         alert.setContentText("You have entered a trap cell!");
         alert.showAndWait();
                     }
                    
                    
                     currentHero.move(Direction.DOWN);
                     for(int row=0;row<GRID_SIZE;row++){
                         int rowMap=14-row;
                         	for(int col1 =0;col1<GRID_SIZE;col1++){
                        
                       
                        
                                         if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                                         Rectangle square= createSquare();
                             gridPane.add(square,col1,row);
                                         ImageView jImageView = new ImageView(joel);
                     jImageView.setFitWidth(50);  
                     jImageView.setFitHeight(50);
                         gridPane.add(jImageView, col1, row);

                         }
                                         else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
                         Rectangle square= createSquare();
                             gridPane.add(square,col1,row);
                         ImageView vaccineIV = new ImageView(vaccine);
                         vaccineIV.setFitWidth(50);  
                                     vaccineIV.setFitHeight(50);
                         gridPane.add(vaccineIV, col1, row);
                         }
                                         else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
                         Rectangle square= createSquare();
                             gridPane.add(square,col1,row);
                         ImageView supplyIV = new ImageView(supply);
                         supplyIV.setFitWidth(50);  
                                     supplyIV.setFitHeight(50);
                         gridPane.add(supplyIV, col1, row);
                         }
                                         else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
                        
                                         Rectangle square= createSquare();
                         Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                                text.setFont(new Font(10));
                                l1.setTextFill(Color.BLACK);
                                          
                         gridPane.add(square, col1, row);
                                    gridPane.add(text, col1, row);
                                    
                        
                         }
                                         else {
                             Rectangle square= createSquare();
                             gridPane.add(square,col1,row);
                             }
                         }
                        
                         }
             Rectangle rectangle = new Rectangle(160, 150, Color.DARKGRAY);
             Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Medic" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
             //Text text = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                          text.setFont(Font.font("Arial", 14));
                          text.setFill(Color.BLACK);
                       gameLayout.setAlignment(Pos.TOP_RIGHT);
                          rectangle.setTranslateY(-10);
                       double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                          double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                          text.relocate(textX, textY);
                      gameLayout.getChildren().add(rectangle);
                       gameLayout.getChildren().add(text);
                       
                                         
                       
                       menuBar= new MenuBar();
                       fileMenu= new Menu("Select Zombie");
                       fileMenu2 = new Menu ("Select HeroTarget");
                   fileMenu3 = new Menu ("Pick a Hero");
                  fileMenu4 = new Menu ("View Heroes Details");
                   fileMenu.setStyle("-fx-text-fill: white;");
                   fileMenu2.setStyle("-fx-text-fill: white;");
                   fileMenu3.setStyle("-fx-text-fill: white;");
                   fileMenu4.setStyle("-fx-text-fill: white;");
                       menuBar.setPrefWidth(50);
                       menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                       for(int i=0; i<Game.zombies.size();i++){
                        MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                        fileMenu.getItems().add(openMenuItem);
                        int x=i;
                        openMenuItem.setOnAction(event2->{
                        currentHero.setTarget(Game.zombies.get(x));
                        System.out.println(currentHero.getTarget());
                        });
                       }
                       for(int i=0; i<Game.heroes.size();i++){
                        MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                        fileMenu3.getItems().add(openMenuItem);
                        int x=i;
                        openMenuItem.setOnAction(event2->{
                        currentHero = Game.heroes.get(x);
                        
                        });
                       }
                       for(int i=0; i<Game.heroes.size();i++){
                        MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                        fileMenu2.getItems().add(openMenuItem);
                        int x=i;
                        openMenuItem.setOnAction(event2->{
                        currentHero.setTarget(Game.heroes.get(x));
                        System.out.println(currentHero.getTarget());
                        });
                       }
                       for(int i=0; i<Game.heroes.size();i++){
               			 if(Game.heroes.get(i) instanceof Fighter) {
            				  type = "Fighter";

            			 }
            			 else if(Game.heroes.get(i) instanceof Medic) {
            				 type = "Medic";

            			 }
            			 else {
            				type = "Explorer";
            			 }
               			 
               			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
               			 fileMenu4.getItems().add(openMenuItem);
            	            

            			 	
            		 }	
                       
                      
                    
                       menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                       gameLayout.getChildren().add(menuBar);
                        
                       if(Game.checkWin()){
                         	Alert win = new Alert(Alert.AlertType.INFORMATION);
         		             win.setTitle("All done!");
         		             win.setHeaderText("Close game");
         		             win.setContentText("This is an alert.");
         		             win.showAndWait().ifPresent(response -> {
         		                 if (response == ButtonType.OK) {
         		                     primaryStage.close();
         		                 }
         		             });
         		             win.setOnCloseRequest(close -> {
         		                 // Change the scene when the alert is closed
         		                 

         		                 primaryStage.close();
         		             });
                
                         }
                         if(Game.checkGameOver()){
                         	Alert lose = new Alert(Alert.AlertType.INFORMATION);
         		             lose.setTitle("You lost");
         		             lose.setHeaderText("Close game");
         		             lose.setContentText("This is an alert.");
         		             lose.showAndWait().ifPresent(response -> {
         		                 if (response == ButtonType.OK) {
         		                     primaryStage.close();
         		                 }
         		             });
         		             lose.setOnCloseRequest(close -> {
         		                 // Change the scene when the alert is closed
         		                 

         		                 primaryStage.close();
         		             });
                         }
                         
                        
                          
                    
             } catch (NotEnoughActionsException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Insufficient Actions");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         }

         catch (MovementException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Invalid Movement");
         alert.setContentText(e.getMessage());
         alert.showAndWait();

         }
         }
                      
                      
                 });

                    left.setOnMouseClicked(new EventHandler<Event>() {
                    
               @Override
               public void handle(Event event) {
               try {
               col = (int) currentHero.getLocation().getY();
                       xloc = (int) (15 -1 - currentHero.getLocation().getX());
                      
                       if(Game.map[((int)currentHero.getLocation().getX())][(int) currentHero.getLocation().getY() - 1]instanceof TrapCell) {
                       Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Warning");
             alert.setContentText("You have entered a trap cell!");
             alert.showAndWait();
                       }
                      
                      
                       currentHero.move(Direction.LEFT);
                       for(int row=0;row<GRID_SIZE;row++){
                           int rowMap=14-row;
                           	for(int col1 =0;col1<GRID_SIZE;col1++){
                          
                         
                          
                                           if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                                           Rectangle square= createSquare();
                               gridPane.add(square,col1,row);
                                           ImageView jImageView = new ImageView(joel);
                       jImageView.setFitWidth(50);  
                       jImageView.setFitHeight(50);
                           gridPane.add(jImageView, col1, row);

                           }
                                           else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
                           Rectangle square= createSquare();
                               gridPane.add(square,col1,row);
                           ImageView vaccineIV = new ImageView(vaccine);
                           vaccineIV.setFitWidth(50);  
                                       vaccineIV.setFitHeight(50);
                           gridPane.add(vaccineIV, col1, row);
                           }
                                           else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
                           Rectangle square= createSquare();
                               gridPane.add(square,col1,row);
                           ImageView supplyIV = new ImageView(supply);
                           supplyIV.setFitWidth(50);  
                                       supplyIV.setFitHeight(50);
                           gridPane.add(supplyIV, col1, row);
                           }
                                           else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
                          
                                           Rectangle square= createSquare();
                           Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                                  text.setFont(new Font(10));
                                  l1.setTextFill(Color.BLACK);
                                            
                           gridPane.add(square, col1, row);
                                      gridPane.add(text, col1, row);
                                      
                          
                           }
                                           else {
                               Rectangle square= createSquare();
                               gridPane.add(square,col1,row);
                               }
                           }
                          
                           }
               Rectangle rectangle = new Rectangle(160, 150, Color.DARKGRAY);
               Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Medic" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                       //Text text = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                          text.setFont(Font.font("Arial", 14));
                          text.setFill(Color.BLACK);
                       gameLayout.setAlignment(Pos.TOP_RIGHT);
                          rectangle.setTranslateY(-10);
                       double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                          double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                          text.relocate(textX, textY);
                      gameLayout.getChildren().add(rectangle);
                       gameLayout.getChildren().add(text);
                       
                       
              
                       menuBar= new MenuBar();
                       fileMenu= new Menu("Select Zombie");
                       fileMenu2 = new Menu ("Select HeroTarget");
                   fileMenu3 = new Menu ("Pick a Hero");
                  fileMenu4 = new Menu ("View Heroes Details");
                   fileMenu.setStyle("-fx-text-fill: white;");
                   fileMenu2.setStyle("-fx-text-fill: white;");
                   fileMenu3.setStyle("-fx-text-fill: white;");
                   fileMenu4.setStyle("-fx-text-fill: white;");
                       menuBar.setPrefWidth(50);
                       menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                       for(int i=0; i<Game.zombies.size();i++){
                        MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                        fileMenu.getItems().add(openMenuItem);
                        int x=i;
                        openMenuItem.setOnAction(event2->{
                        currentHero.setTarget(Game.zombies.get(x));
                        System.out.println(currentHero.getTarget());
                        });
                       }
                       for(int i=0; i<Game.heroes.size();i++){
                        MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                        fileMenu3.getItems().add(openMenuItem);
                        int x=i;
                        openMenuItem.setOnAction(event2->{
                        currentHero = Game.heroes.get(x);
                        
                        });
                       }
                       for(int i=0; i<Game.heroes.size();i++){
                        MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                        fileMenu2.getItems().add(openMenuItem);
                        int x=i;
                        openMenuItem.setOnAction(event2->{
                        currentHero.setTarget(Game.heroes.get(x));
                        System.out.println(currentHero.getTarget());
                        });
                       }
                       for(int i=0; i<Game.heroes.size();i++){
               			 if(Game.heroes.get(i) instanceof Fighter) {
            				  type = "Fighter";

            			 }
            			 else if(Game.heroes.get(i) instanceof Medic) {
            				 type = "Medic";

            			 }
            			 else {
            				type = "Explorer";
            			 }
               			 
               			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
               			 fileMenu4.getItems().add(openMenuItem);
            	            

            			 	
            		 }	
                       
                      
                    
                       menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                       gameLayout.getChildren().add(menuBar);
                           
                           if(Game.checkWin()){
                           	Alert win = new Alert(Alert.AlertType.INFORMATION);
           		             win.setTitle("All done!");
           		             win.setHeaderText("Close game");
           		             win.setContentText("This is an alert.");
           		             win.showAndWait().ifPresent(response -> {
           		                 if (response == ButtonType.OK) {
           		                     primaryStage.close();
           		                 }
           		             });
           		             win.setOnCloseRequest(close -> {
           		                 // Change the scene when the alert is closed
           		                 

           		                 primaryStage.close();
           		             });
                  
                           }
                           if(Game.checkGameOver()){
                           	Alert lose = new Alert(Alert.AlertType.INFORMATION);
           		             lose.setTitle("You lost");
           		             lose.setHeaderText("Close game");
           		             lose.setContentText("This is an alert.");
           		             lose.showAndWait().ifPresent(response -> {
           		                 if (response == ButtonType.OK) {
           		                     primaryStage.close();
           		                 }
           		             });
           		             lose.setOnCloseRequest(close -> {
           		                 // Change the scene when the alert is closed
           		                 

           		                 primaryStage.close();
           		             });
                           }
                          
                      
               } catch (NotEnoughActionsException e) {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Insufficient Actions");
             alert.setContentText(e.getMessage());
             alert.showAndWait();
             }

             catch (MovementException e) {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Invalid Movement");
             alert.setContentText(e.getMessage());
             alert.showAndWait();
            
             }
             }
                        });
                    right.setOnMouseClicked(new EventHandler<Event>() {
                    
               @Override
               public void handle(Event event) {
               try {
               col = (int) currentHero.getLocation().getY();
                       xloc = (int) (15 -1 - currentHero.getLocation().getX());
                         if(Game.map[((int)currentHero.getLocation().getX())][(int) currentHero.getLocation().getY() + 1]instanceof TrapCell) {
                         Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Warning");
             alert.setContentText("You have entered a trap cell");
             alert.showAndWait();
                         }

               currentHero.move(Direction.RIGHT);
               for(int row=0;row<GRID_SIZE;row++){
                   int rowMap=14-row;
                   	for(int col1 =0;col1<GRID_SIZE;col1++){
                  
                 
                  
                                   if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                                   Rectangle square= createSquare();
                       gridPane.add(square,col1,row);
                                   ImageView jImageView = new ImageView(joel);
               jImageView.setFitWidth(50);  
               jImageView.setFitHeight(50);
                   gridPane.add(jImageView, col1, row);

                   }
                                   else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
                   Rectangle square= createSquare();
                       gridPane.add(square,col1,row);
                   ImageView vaccineIV = new ImageView(vaccine);
                   vaccineIV.setFitWidth(50);  
                               vaccineIV.setFitHeight(50);
                   gridPane.add(vaccineIV, col1, row);
                   }
                                   else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
                   Rectangle square= createSquare();
                       gridPane.add(square,col1,row);
                   ImageView supplyIV = new ImageView(supply);
                   supplyIV.setFitWidth(50);  
                               supplyIV.setFitHeight(50);
                   gridPane.add(supplyIV, col1, row);
                   }
                                   else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
                  
                                   Rectangle square= createSquare();
                   Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                          text.setFont(new Font(10));
                          l1.setTextFill(Color.BLACK);
                                    
                   gridPane.add(square, col1, row);
                              gridPane.add(text, col1, row);
                              
                  
                   }
                                   else {
                       Rectangle square= createSquare();
                       gridPane.add(square,col1,row);
                       }
                   }
                  
                   }
              
               Rectangle rectangle = new Rectangle(160, 150, Color.DARKGRAY);
               Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Medic" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                     //  Text text = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                      text.setFont(Font.font("Arial", 14));
                      text.setFill(Color.BLACK);
                   gameLayout.setAlignment(Pos.TOP_RIGHT);
                      rectangle.setTranslateY(-10);
                   double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                      double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                      text.relocate(textX, textY);
                  gameLayout.getChildren().add(rectangle);
                   gameLayout.getChildren().add(text);
                   
                              
                  
                   menuBar= new MenuBar();
                   fileMenu= new Menu("Select Zombie");
                   fileMenu2 = new Menu ("Select HeroTarget");
               fileMenu3 = new Menu ("Pick a Hero");
              fileMenu4 = new Menu ("View Heroes Details");
               fileMenu.setStyle("-fx-text-fill: white;");
               fileMenu2.setStyle("-fx-text-fill: white;");
               fileMenu3.setStyle("-fx-text-fill: white;");
               fileMenu4.setStyle("-fx-text-fill: white;");
                   menuBar.setPrefWidth(50);
                   menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                   for(int i=0; i<Game.zombies.size();i++){
                    MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                    fileMenu.getItems().add(openMenuItem);
                    int x=i;
                    openMenuItem.setOnAction(event2->{
                    currentHero.setTarget(Game.zombies.get(x));
                    System.out.println(currentHero.getTarget());
                    });
                   }
                   for(int i=0; i<Game.heroes.size();i++){
                    MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                    fileMenu3.getItems().add(openMenuItem);
                    int x=i;
                    openMenuItem.setOnAction(event2->{
                    currentHero = Game.heroes.get(x);
                    
                    });
                   }
                   for(int i=0; i<Game.heroes.size();i++){
                    MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                    fileMenu2.getItems().add(openMenuItem);
                    int x=i;
                    openMenuItem.setOnAction(event2->{
                    currentHero.setTarget(Game.heroes.get(x));
                    System.out.println(currentHero.getTarget());
                    });
                   }
                   for(int i=0; i<Game.heroes.size();i++){
           			 if(Game.heroes.get(i) instanceof Fighter) {
        				  type = "Fighter";

        			 }
        			 else if(Game.heroes.get(i) instanceof Medic) {
        				 type = "Medic";

        			 }
        			 else {
        				type = "Explorer";
        			 }
           			 
           			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
           			 fileMenu4.getItems().add(openMenuItem);
        	            

        			 	
        		 }	
                   
                  
                
                   menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                   gameLayout.getChildren().add(menuBar);
                  
                       if(Game.checkWin()){
                       	Alert win = new Alert(Alert.AlertType.INFORMATION);
       		             win.setTitle("All done!");
       		             win.setHeaderText("Close game");
       		             win.setContentText("This is an alert.");
       		             win.showAndWait().ifPresent(response -> {
       		                 if (response == ButtonType.OK) {
       		                     primaryStage.close();
       		                 }
       		             });
       		             win.setOnCloseRequest(close -> {
       		                 // Change the scene when the alert is closed
       		                 

       		                 primaryStage.close();
       		             });
              
                       }
                       if(Game.checkGameOver()){
                       	Alert lose = new Alert(Alert.AlertType.INFORMATION);
       		             lose.setTitle("You lost");
       		             lose.setHeaderText("Close game");
       		             lose.setContentText("This is an alert.");
       		             lose.showAndWait().ifPresent(response -> {
       		                 if (response == ButtonType.OK) {
       		                     primaryStage.close();
       		                 }
       		             });
       		             lose.setOnCloseRequest(close -> {
       		                 // Change the scene when the alert is closed
       		                 

       		                 primaryStage.close();
       		             });
                       }
                      
                      
               } catch (NotEnoughActionsException e) {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Insufficient Actions");
             alert.setContentText(e.getMessage());
             alert.showAndWait();
             }

               catch (MovementException e) {
             	    Alert alert = new Alert(Alert.AlertType.INFORMATION);
             	    alert.setTitle("Invalid Movement");
             	    
             	    alert.setContentText(e.getMessage());
             	    alert.showAndWait();
             	    }
             	    }
             
                        });
                   
                    
                    
                   
                    
                    
                    attack.setOnAction(event2 -> {
                 	   
                     try {

                        

                         currentHero.attack();
                      

                         for(int row=0;row<GRID_SIZE;row++){
                             int rowMap=14-row;
                             	for(int col1 =0;col1<GRID_SIZE;col1++){
                            
                           
                            
                                             if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                                             Rectangle square= createSquare();
                                 gridPane.add(square,col1,row);
                                             ImageView jImageView = new ImageView(joel);
                         jImageView.setFitWidth(50);  
                         jImageView.setFitHeight(50);
                             gridPane.add(jImageView, col1, row);

                             }
                                             else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
                             Rectangle square= createSquare();
                                 gridPane.add(square,col1,row);
                             ImageView vaccineIV = new ImageView(vaccine);
                             vaccineIV.setFitWidth(50);  
                                         vaccineIV.setFitHeight(50);
                             gridPane.add(vaccineIV, col1, row);
                             }
                                             else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
                             Rectangle square= createSquare();
                                 gridPane.add(square,col1,row);
                             ImageView supplyIV = new ImageView(supply);
                             supplyIV.setFitWidth(50);  
                                         supplyIV.setFitHeight(50);
                             gridPane.add(supplyIV, col1, row);
                             }
                                             else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
                            
                                             Rectangle square= createSquare();
                             Label text2 = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                                    text2.setFont(new Font(10));
                                    l1.setTextFill(Color.BLACK);
                                              
                             gridPane.add(square, col1, row);
                                        gridPane.add(text2, col1, row);
                                        
                            
                             }
                                             else {
                                 Rectangle square= createSquare();
                                 gridPane.add(square,col1,row);
                                 }
                             }
                            
                             }

                   
                     
                    Rectangle rectangle2 = new Rectangle(160, 150, Color.DARKGRAY);
                    Text text2 = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Medic" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                    // Text text2 = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                         text2.setFont(Font.font("Arial", 14));
                         text2.setFill(Color.BLACK);
                         gameLayout.setAlignment(Pos.TOP_RIGHT);

                         rectangle2.setTranslateY(-10);
                        
                    
                     double textX2 = rectangle2.getX() + (rectangle2.getWidth() - text2.getLayoutBounds().getWidth()) / 2;
                         double textY2= rectangle2.getY() + (rectangle2.getHeight() + text2.getLayoutBounds().getHeight()) / 2;
                         text2.relocate(textX2, textY2);
                     gameLayout.getChildren().add(rectangle2);
                     gameLayout.getChildren().add(text2);
                     
                     
                     
                     menuBar= new MenuBar();
                     fileMenu= new Menu("Select Zombie");
                     fileMenu2 = new Menu ("Select HeroTarget");
                 fileMenu3 = new Menu ("Pick a Hero");
                fileMenu4 = new Menu ("View Heroes Details");
                 fileMenu.setStyle("-fx-text-fill: white;");
                 fileMenu2.setStyle("-fx-text-fill: white;");
                 fileMenu3.setStyle("-fx-text-fill: white;");
                 fileMenu4.setStyle("-fx-text-fill: white;");
                     menuBar.setPrefWidth(50);
                     menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                     for(int i=0; i<Game.zombies.size();i++){
                      MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                      fileMenu.getItems().add(openMenuItem);
                      int x=i;
                      openMenuItem.setOnAction(event3->{
                      currentHero.setTarget(Game.zombies.get(x));
                      System.out.println(currentHero.getTarget());
                      });
                     }
                     for(int i=0; i<Game.heroes.size();i++){
                      MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                      fileMenu3.getItems().add(openMenuItem);
                      int x=i;
                      openMenuItem.setOnAction(event3->{
                      currentHero = Game.heroes.get(x);
                      
                      });
                     }
                     for(int i=0; i<Game.heroes.size();i++){
                      MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                      fileMenu2.getItems().add(openMenuItem);
                      int x=i;
                      openMenuItem.setOnAction(event3->{
                      currentHero.setTarget(Game.heroes.get(x));
                      System.out.println(currentHero.getTarget());
                      });
                     }
                     for(int i=0; i<Game.heroes.size();i++){
             			 if(Game.heroes.get(i) instanceof Fighter) {
          				  type = "Fighter";

          			 }
          			 else if(Game.heroes.get(i) instanceof Medic) {
          				 type = "Medic";

          			 }
          			 else {
          				type = "Explorer";
          			 }
             			 
             			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
             			 fileMenu4.getItems().add(openMenuItem);
          	            

          			 	
          		 }	
                     
                    
                  
                     menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                     gameLayout.getChildren().add(menuBar);
                     
                    
                     if(Game.checkWin()){
                     	Alert win = new Alert(Alert.AlertType.INFORMATION);
     		             win.setTitle("All done!");
     		             win.setHeaderText("Close game");
     		             win.setContentText("This is an alert.");
     		             win.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             win.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
            
                     }
                     if(Game.checkGameOver()){
                     	Alert lose = new Alert(Alert.AlertType.INFORMATION);
     		             lose.setTitle("You lost");
     		             lose.setHeaderText("Close game");
     		             lose.setContentText("This is an alert.");
     		             lose.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             lose.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
                     }
                     
            
             } catch (NotEnoughActionsException e) {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Insufficient Actions");
             alert.setContentText(e.getMessage());
         alert.showAndWait();

             } catch (InvalidTargetException e) {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Invalid Target");
             alert.setContentText(e.getMessage());
         alert.showAndWait();

             }
                    });
                    
                    
                    
                    cure.setOnMouseClicked(new EventHandler< Event >(){

         @Override
         public void handle(Event arg0) {
         try {
         currentHero.cure();
         for(int row=0;row<GRID_SIZE;row++){
             int rowMap=14-row;
             	for(int col1 =0;col1<GRID_SIZE;col1++){
            
           
            
                             if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                             ImageView jImageView = new ImageView(joel);
         jImageView.setFitWidth(50);  
         jImageView.setFitHeight(50);
             gridPane.add(jImageView, col1, row);

             }
                             else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView vaccineIV = new ImageView(vaccine);
             vaccineIV.setFitWidth(50);  
                         vaccineIV.setFitHeight(50);
             gridPane.add(vaccineIV, col1, row);
             }
                             else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView supplyIV = new ImageView(supply);
             supplyIV.setFitWidth(50);  
                         supplyIV.setFitHeight(50);
             gridPane.add(supplyIV, col1, row);
             }
                             else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
            
                             Rectangle square= createSquare();
             Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                    text.setFont(new Font(10));
                    l1.setTextFill(Color.BLACK);
                              
             gridPane.add(square, col1, row);
                        gridPane.add(text, col1, row);
                        
            
             }
                             else {
                 Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                 }
             }
            
             }
         
         
         Rectangle rectangle = new Rectangle(160, 120, Color.DARKGRAY);
         Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Medic" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                  // Text text = new Text("\n" + Game.heroes.get(Game.heroes.size()-1).getName() + "\nCurrent Hp: " + Game.heroes.get(Game.heroes.size()-1).getCurrentHp() + "\nActions available: " +  Game.heroes.get(Game.heroes.size()-1).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(Game.heroes.size()-1).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                    text.setFont(Font.font("Arial", 14));
                    text.setFill(Color.BLACK);
                 gameLayout.setAlignment(Pos.TOP_RIGHT);
                    rectangle.setTranslateY(-10);
                 double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                    double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                    text.relocate(textX, textY);
                gameLayout.getChildren().add(rectangle);
                 gameLayout.getChildren().add(text);
                 
                 
                 
                 menuBar= new MenuBar();
                 fileMenu= new Menu("Select Zombie");
                 fileMenu2 = new Menu ("Select HeroTarget");
             fileMenu3 = new Menu ("Pick a Hero");
            fileMenu4 = new Menu ("View Heroes Details");
             fileMenu.setStyle("-fx-text-fill: white;");
             fileMenu2.setStyle("-fx-text-fill: white;");
             fileMenu3.setStyle("-fx-text-fill: white;");
             fileMenu4.setStyle("-fx-text-fill: white;");
                 menuBar.setPrefWidth(50);
                 menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                 for(int i=0; i<Game.zombies.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                  fileMenu.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero.setTarget(Game.zombies.get(x));
                  System.out.println(currentHero.getTarget());
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                  fileMenu3.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero = Game.heroes.get(x);
                  
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                  fileMenu2.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero.setTarget(Game.heroes.get(x));
                  System.out.println(currentHero.getTarget());
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
         			 if(Game.heroes.get(i) instanceof Fighter) {
      				  type = "Fighter";

      			 }
      			 else if(Game.heroes.get(i) instanceof Medic) {
      				 type = "Medic";

      			 }
      			 else {
      				type = "Explorer";
      			 }
         			 
         			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
         			 fileMenu4.getItems().add(openMenuItem);
      	            

      			 	
      		 }	
                 
                
              
                 menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                 gameLayout.getChildren().add(menuBar);
                    
                    
                
                     if(Game.checkWin()){
                     	Alert win = new Alert(Alert.AlertType.INFORMATION);
     		             win.setTitle("All done!");
     		             win.setHeaderText("Close game");
     		             win.setContentText("This is an alert.");
     		             win.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             win.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
            
                     }
                     if(Game.checkGameOver()){
                     	Alert lose = new Alert(Alert.AlertType.INFORMATION);
     		             lose.setTitle("You lost");
     		             lose.setHeaderText("Close game");
     		             lose.setContentText("This is an alert.");
     		             lose.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             lose.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
                     }
                     
                               
         } catch (NoAvailableResourcesException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Insufficient resources");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         } catch (InvalidTargetException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Invalid Target");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         } catch (NotEnoughActionsException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Insufficient Actions");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         }
         }
                  
                    });
                    
                    
                    
                    endTurn.setOnMouseClicked(new EventHandler<Event>(){

         @Override
         public void handle(Event event3) {
         try {
         Game.endTurn();

         if(Game.checkWin()){
         	Alert win = new Alert(Alert.AlertType.INFORMATION);
              win.setTitle("All done!");
              win.setHeaderText("Close game");
              win.setContentText("This is an alert.");
              win.showAndWait().ifPresent(response -> {
                  if (response == ButtonType.OK) {
                      primaryStage.close();
                  }
              });
              win.setOnCloseRequest(close -> {
                  // Change the scene when the alert is closed
                  

                  primaryStage.close();
              });

         }
         if(Game.checkGameOver()){
         	Alert lose = new Alert(Alert.AlertType.INFORMATION);
              lose.setTitle("You lost");
              lose.setHeaderText("Close game");
              lose.setContentText("This is an alert.");
              lose.showAndWait().ifPresent(response -> {
                  if (response == ButtonType.OK) {
                      primaryStage.close();
                  }
              });
              lose.setOnCloseRequest(close -> {
                  // Change the scene when the alert is closed
                  

                  primaryStage.close();
              });
         }

         for(int row=0;row<GRID_SIZE;row++){
             int rowMap=14-row;
             	for(int col1 =0;col1<GRID_SIZE;col1++){
            
           
            
                             if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                             ImageView jImageView = new ImageView(joel);
         jImageView.setFitWidth(50);  
         jImageView.setFitHeight(50);
             gridPane.add(jImageView, col1, row);

             }
                             else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView vaccineIV = new ImageView(vaccine);
             vaccineIV.setFitWidth(50);  
                         vaccineIV.setFitHeight(50);
             gridPane.add(vaccineIV, col1, row);
             }
                             else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView supplyIV = new ImageView(supply);
             supplyIV.setFitWidth(50);  
                         supplyIV.setFitHeight(50);
             gridPane.add(supplyIV, col1, row);
             }
                             else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
            
                             Rectangle square= createSquare();
             Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                    text.setFont(new Font(10));
                    l1.setTextFill(Color.BLACK);
                              
             gridPane.add(square, col1, row);
                        gridPane.add(text, col1, row);
                        
            
             }
                             else {
                 Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                 }
             }
            
             }
         Rectangle rectangle = new Rectangle(160, 120, Color.DARKGRAY);
         Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Medic" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                   //Text text = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                    text.setFont(Font.font("Arial", 14));
                    text.setFill(Color.BLACK);
                 gameLayout.setAlignment(Pos.TOP_RIGHT);
                    rectangle.setTranslateY(-10);
                 double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                    double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                    text.relocate(textX, textY);
                gameLayout.getChildren().add(rectangle);
                 gameLayout.getChildren().add(text);
                 
                 
                 
                 menuBar= new MenuBar();
                 fileMenu= new Menu("Select Zombie");
                 fileMenu2 = new Menu ("Select HeroTarget");
             fileMenu3 = new Menu ("Pick a Hero");
            fileMenu4 = new Menu ("View Heroes Details");
             fileMenu.setStyle("-fx-text-fill: white;");
             fileMenu2.setStyle("-fx-text-fill: white;");
             fileMenu3.setStyle("-fx-text-fill: white;");
             fileMenu4.setStyle("-fx-text-fill: white;");
                 menuBar.setPrefWidth(50);
                 menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                 for(int i=0; i<Game.zombies.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                  fileMenu.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero.setTarget(Game.zombies.get(x));
                  System.out.println(currentHero.getTarget());
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                  fileMenu3.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero = Game.heroes.get(x);
                  
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
                  MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                  fileMenu2.getItems().add(openMenuItem);
                  int x=i;
                  openMenuItem.setOnAction(event2->{
                  currentHero.setTarget(Game.heroes.get(x));
                  System.out.println(currentHero.getTarget());
                  });
                 }
                 for(int i=0; i<Game.heroes.size();i++){
         			 if(Game.heroes.get(i) instanceof Fighter) {
      				  type = "Fighter";

      			 }
      			 else if(Game.heroes.get(i) instanceof Medic) {
      				 type = "Medic";

      			 }
      			 else {
      				type = "Explorer";
      			 }
         			 
         			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
         			 fileMenu4.getItems().add(openMenuItem);
      	            

      			 	
      		 }	
                 
                
              
                 menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                 gameLayout.getChildren().add(menuBar);
                     
                    
         } catch (NotEnoughActionsException e) {

         } catch (InvalidTargetException e) {

         }
         }
                  
                    });
                    
                    useSpecial.setOnMouseClicked(new EventHandler< Event >(){

         @Override
         public void handle(Event event) {
         try {
         currentHero.useSpecial();
         for(int row=0;row<GRID_SIZE;row++){
             int rowMap=14-row;
             	for(int col1 =0;col1<GRID_SIZE;col1++){
            
           
            
                             if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Hero) {
                             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                             ImageView jImageView = new ImageView(joel);
         jImageView.setFitWidth(50);  
         jImageView.setFitHeight(50);
             gridPane.add(jImageView, col1, row);

             }
                             else if(Game.map[rowMap][col1] instanceof CollectibleCell && ((CollectibleCell) Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Vaccine && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView vaccineIV = new ImageView(vaccine);
             vaccineIV.setFitWidth(50);  
                         vaccineIV.setFitHeight(50);
             gridPane.add(vaccineIV, col1, row);
             }
                             else if(Game.map[rowMap][col1]  instanceof CollectibleCell && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() != null && ((CollectibleCell)Game.map[rowMap][col1] ).getCollectible() instanceof Supply && Game.map[rowMap][col1].isVisible()) {
             Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
             ImageView supplyIV = new ImageView(supply);
             supplyIV.setFitWidth(50);  
                         supplyIV.setFitHeight(50);
             gridPane.add(supplyIV, col1, row);
             }
                             else if(Game.map[rowMap][col1] instanceof CharacterCell && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() != null && ((CharacterCell)Game.map[rowMap][col1] ).getCharacter() instanceof Zombie && Game.map[rowMap][col1].isVisible()) {
            
                             Rectangle square= createSquare();
             Label text = new Label(((CharacterCell) Game.map[rowMap][col1]).getCharacter().getName());
                    text.setFont(new Font(10));
                    l1.setTextFill(Color.BLACK);
                              
             gridPane.add(square, col1, row);
                        gridPane.add(text, col1, row);
                        
            
             }
                             else {
                 Rectangle square= createSquare();
                 gridPane.add(square,col1,row);
                 }
             }
            
             }
         Rectangle rectangle = new Rectangle(160, 120, Color.DARKGRAY);
         Text text = new Text("\n" + currentHero.getName() + "\nCurrent Hp: " + currentHero.getCurrentHp() + "\nActions available: " +  currentHero.getActionsAvailable() + "\nAttack D: " + currentHero.getAttackDmg() + "\nType: Medic" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                  // Text text = new Text("\n" + Game.heroes.get(0).getName() + "\nCurrent Hp: " + Game.heroes.get(0).getCurrentHp() + "\nActions available: " +  Game.heroes.get(0).getActionsAvailable() + "\nAttack D: " + Game.heroes.get(0).getAttackDmg() + "\nType: Fighter" + "\nVaccines: " + currentHero.getVaccineInventory().size() + "\nSupplies: " + currentHero.getSupplyInventory().size());                  
                    text.setFont(Font.font("Arial", 14));
                    text.setFill(Color.BLACK);
                 gameLayout.setAlignment(Pos.TOP_RIGHT);
                    rectangle.setTranslateY(-10);
                 double textX = rectangle.getX() + (rectangle.getWidth() - text.getLayoutBounds().getWidth()) / 2;
                    double textY = rectangle.getY() + (rectangle.getHeight() + text.getLayoutBounds().getHeight()) / 2;
                    text.relocate(textX, textY);
                gameLayout.getChildren().add(rectangle);
                gameLayout.getChildren().add(text);

                menuBar= new MenuBar();
                fileMenu= new Menu("Select Zombie");
                fileMenu2 = new Menu ("Select HeroTarget");
            fileMenu3 = new Menu ("Pick a Hero");
           fileMenu4 = new Menu ("View Heroes Details");
            fileMenu.setStyle("-fx-text-fill: white;");
            fileMenu2.setStyle("-fx-text-fill: white;");
            fileMenu3.setStyle("-fx-text-fill: white;");
            fileMenu4.setStyle("-fx-text-fill: white;");
                menuBar.setPrefWidth(50);
                menuBar.setStyle("-fx-padding: 5px; -fx-min-width: 60px; -fx-min-height: 20px; -fx-background-color: transparent;");
                for(int i=0; i<Game.zombies.size();i++){
                 MenuItem openMenuItem=new MenuItem(Game.zombies.get(i).getName());
                 fileMenu.getItems().add(openMenuItem);
                 int x=i;
                 openMenuItem.setOnAction(event2->{
                 currentHero.setTarget(Game.zombies.get(x));
                 System.out.println(currentHero.getTarget());
                 });
                }
                for(int i=0; i<Game.heroes.size();i++){
                 MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                 fileMenu3.getItems().add(openMenuItem);
                 int x=i;
                 openMenuItem.setOnAction(event2->{
                 currentHero = Game.heroes.get(x);
                 
                 });
                }
                for(int i=0; i<Game.heroes.size();i++){
                 MenuItem openMenuItem=new MenuItem(Game.heroes.get(i).getName());
                 fileMenu2.getItems().add(openMenuItem);
                 int x=i;
                 openMenuItem.setOnAction(event2->{
                 currentHero.setTarget(Game.heroes.get(x));
                 System.out.println(currentHero.getTarget());
                 });
                }
                for(int i=0; i<Game.heroes.size();i++){
        			 if(Game.heroes.get(i) instanceof Fighter) {
     				  type = "Fighter";

     			 }
     			 else if(Game.heroes.get(i) instanceof Medic) {
     				 type = "Medic";

     			 }
     			 else {
     				type = "Explorer";
     			 }
        			 
        			 MenuItem openMenuItem=new MenuItem("\n"+Game.heroes.get(i).getName()  + "\ncurrent HP: " + Game.heroes.get(i).getCurrentHp() + "\nAttack D: " + Game.heroes.get(i).getAttackDmg() + "\nType:"+ type + "\nMaxHp: "+Game.heroes.get(i).getMaxHp() + "\n");
        			 fileMenu4.getItems().add(openMenuItem);
     	            

     			 	
     		 }	
                
               
             
                menuBar.getMenus().addAll(fileMenu,fileMenu2,fileMenu3,fileMenu4);
                gameLayout.getChildren().add(menuBar);
                    
                     if(Game.checkWin()){
                     	Alert win = new Alert(Alert.AlertType.INFORMATION);
     		             win.setTitle("All done!");
     		             win.setHeaderText("Close game");
     		             win.setContentText("This is an alert.");
     		             win.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             win.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
            
                     }
                     if(Game.checkGameOver()){
                     	Alert lose = new Alert(Alert.AlertType.INFORMATION);
     		             lose.setTitle("You lost");
     		             lose.setHeaderText("Close game");
     		             lose.setContentText("This is an alert.");
     		             lose.showAndWait().ifPresent(response -> {
     		                 if (response == ButtonType.OK) {
     		                     primaryStage.close();
     		                 }
     		             });
     		             lose.setOnCloseRequest(close -> {
     		                 // Change the scene when the alert is closed
     		                 

     		                 primaryStage.close();
     		             });
                     }
                    
          
         } catch (NoAvailableResourcesException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Insufficient Supply");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         } catch (InvalidTargetException e) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Invalid Target");
         alert.setContentText(e.getMessage());
         alert.showAndWait();
         }

         }});
            

                 game = new Scene(gameLayout, 1470, 800);
               primaryStage.setScene(game);

                

                 });
         	
 
        StackPane.setAlignment(switchBackButton, javafx.geometry.Pos.BOTTOM_RIGHT);
        otherLayout.getChildren().add(switchBackButton);
        otherScene = new Scene(otherLayout, 1000, 800);
        
        
        
        
 
        
        

        // Set the main scene
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("The last of us legacy");
        primaryStage.show();
    }
    private Rectangle createSquare(){
		Rectangle square = new Rectangle(SQUARE_SIZE,SQUARE_SIZE);
		square.setFill(Color.WHITE);
		square.setStroke(Color.BLACK);
		return square;
    }
    


    private void playGame() {
        primaryStage.setScene(otherScene);
    }

    private void switchToMainScene() {
        primaryStage.setScene(mainScene);
    }
    

    public static void main(String[] args) {
        launch(args);
    }
}
