package Monitor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author murali,vikram,vikas
 */
import Monitor.DiskInfo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
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
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
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

        //Creating Objects for each Tab Data
        ProcessInfo gpl = new ProcessInfo();
        gpl.showProcessData();

        MemoryInfo gml = new MemoryInfo();
        gml.showMemoryData();

        NetworkInfo gnl = new NetworkInfo();
        gnl.showNetworkData();

        DiskInfo gdl = new DiskInfo();
        gdl.showDiskData();

        primaryStage.setTitle("Resource Monitor");
        Group root = new Group();
        Scene scene = new Scene(root, 600, 400, Color.WHITE);
        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        BorderPane borderPane = new BorderPane();

        //Making the CPU Tab
        Tab CPUtab = new Tab();
        //Setting text to the tab
        CPUtab.setText("CPU");
        CPUtab.setStyle("-fx-border-color:black; -fx-background-color: yellow;");
        TextArea text = new TextArea();
        try {
            Scanner s = new Scanner(new File("ProcessList.txt"));
            while (s.hasNext()) {
                text.appendText(s.nextLine() + "\n");
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        }
        CPUtab.setContent(text);
        tabPane.getTabs().add(CPUtab);
        //Creating button 
        Button button1 = new Button("CPU history");
        //creating a action for button1 whenever hit the button it invokes the scene2
        button1.setOnAction(e -> primaryStage.setScene(scene));

        //Making the Memory Tab
        Tab memorytab = new Tab();
        memorytab.setText("Memory");
        memorytab.setStyle("-fx-border-color:black; -fx-background-color: yellow;");
        TextArea memText = new TextArea();

        try {
            Scanner s = new Scanner(new File("MemoryList.txt"));//.useDelimiter("\\s+");
            while (s.hasNext()) {
                memText.appendText(s.nextLine() + "\n");
            }

        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        }
        memorytab.setContent(memText);
        tabPane.getTabs().add(memorytab);
        //Creating button 
        Button button2 = new Button("Memory History");
        //creating a action for button1 whenever hit the button it invokes the scene2
        button2.setOnAction(e -> primaryStage.setScene(scene));

        //Making the Disk Tab
        Tab disktab = new Tab();
        disktab.setText("Disk");
        disktab.setStyle("-fx-border-color:black; -fx-background-color: yellow;");
        TextArea diskText = new TextArea();

        try {
            Scanner s = new Scanner(new File("DiskList.txt"));//.useDelimiter("\\s+");
            while (s.hasNext()) {
                diskText.appendText(s.nextLine() + "\n");
            }

        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        }
        disktab.setContent(diskText);
        tabPane.getTabs().add(disktab);

        //Making the Disk Tab
        Tab networkTab = new Tab();
        networkTab.setText("Network");
        networkTab.setStyle("-fx-border-color:black; -fx-background-color: yellow;");
        TextArea networkText = new TextArea();

        try {
            Scanner s = new Scanner(new File("NetworkList.txt"));//.useDelimiter("\\s+");
            while (s.hasNext()) {
                networkText.appendText(s.nextLine() + "\n");
            }

        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        }
        networkTab.setContent(networkText);
        tabPane.getTabs().add(networkTab);

        // bind to take available space
        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());

        borderPane.setCenter(tabPane);
        root.getChildren().add(borderPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
