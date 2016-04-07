
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author murali,vikram,vikas
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainWindow extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Resource Monitor");
        Group root = new Group();
        Scene scene = new Scene(root, 400, 250, Color.WHITE);

        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        BorderPane borderPane = new BorderPane();
        //Making the CPU Tab
        Tab CPUtab = new Tab();
        //Setting text to the tab
        CPUtab.setText("CPU");
        CPUtab.setStyle("-fx-border-color:black; -fx-background-color: grey;");
        //Creating a hbox
        HBox hbox = new HBox();
        hbox.getChildren().add(new Label(""));
        hbox.setAlignment(Pos.BOTTOM_LEFT);
        CPUtab.setContent(hbox);
        tabPane.getTabs().add(CPUtab);
        //Creating button 
        Button button1 = new Button("CPU history");
        //creating a action for button1 whenever hit the button it invokes the scene2
        button1.setOnAction(e -> primaryStage.setScene(scene));
        //Adding button to the hbox tab window
        hbox.getChildren().add(button1);
        //Setting button to the bottom
        borderPane.setBottom(hbox);

        //Making the Memory Tab
        Tab memorytab = new Tab();
        memorytab.setText("Memory");
        memorytab.setStyle("-fx-border-color:black; -fx-background-color: grey;");
        HBox hbox1 = new HBox();
        hbox1.getChildren().add(new Label(""));
        hbox1.setAlignment(Pos.BOTTOM_LEFT);
        memorytab.setContent(hbox1);
        tabPane.getTabs().add(memorytab);
        //Creating button 
        Button button2 = new Button("Disk Memory");
        //creating a action for button1 whenever hit the button it invokes the scene2
        button2.setOnAction(e -> primaryStage.setScene(scene));
        //Adding button to the hbox tab window
        hbox1.getChildren().add(button2);
        //Setting button to the bottom
        borderPane.setBottom(hbox1);

        //Making the Disk Tab
        Tab disktab = new Tab();
        disktab.setText("Disk");
        disktab.setStyle("-fx-border-color:black; -fx-background-color: grey;");
        HBox hbox2 = new HBox();
        hbox2.getChildren().add(new Label(""));
        hbox2.setAlignment(Pos.CENTER);
        disktab.setContent(hbox2);
        tabPane.getTabs().add(disktab);

        //Making the Network Tab
        Tab nwtab = new Tab();
        nwtab.setText("Network");
        nwtab.setStyle("-fx-border-color:black; -fx-background-color: grey;");
        HBox hbox3 = new HBox();
        hbox3.getChildren().add(new Label(""));
        hbox3.setAlignment(Pos.CENTER);
        nwtab.setContent(hbox3);
        tabPane.getTabs().add(nwtab);

        // bind to take available space
        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());

        borderPane.setCenter(tabPane);
        root.getChildren().add(borderPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
