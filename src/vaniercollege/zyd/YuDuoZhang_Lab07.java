package vaniercollege.zyd;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.*;

/**
 * @author Yu Duo Zhang (2480549)
 * 
 */
public class YuDuoZhang_Lab07 extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        //Part A
        // ObjectA
        Circle objectA = new Circle();
        objectA.setRadius(50);
        objectA.setFill(Color.valueOf("F88F58"));
        
        // Path for A
        Rectangle pathA = new Rectangle(150, 100, 200 ,100);
        pathA.setArcHeight(30);
        pathA.setArcWidth(30);
        pathA.setFill(null);
        pathA.setStroke(Color.BLACK);
        
        // Transition for A
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(1500));
        pt.setPath(pathA);
        pt.setNode(objectA);
        pt.setCycleCount(Animation.INDEFINITE);
        pt.setAutoReverse(false);
        pt.play();
                
        // Scene
        Pane root = new Pane();
        root.getChildren().addAll(objectA, pathA);
        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);
        stage.show();
    }
}
