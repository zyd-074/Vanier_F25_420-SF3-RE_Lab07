package vaniercollege.zyd;

import javafx.animation.*;
import javafx.animation.Animation.Status;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
        objectA.setCenterX(50);
        objectA.setCenterY(50);
        
        // Path for A
        int x1 = 50;
        int y1 = 50;
        int x2 = 450;
        int y2 = 250;
        
        Polygon pathA = new Polygon(x1,y1,x2,y1, x2,y2, x1,y2);
        pathA.setFill(null);
        pathA.setStroke(Color.BLACK);
        
        // Transition for A
        PathTransition transA = new PathTransition();
        transA.setDuration(Duration.millis(3000));
        transA.setPath(pathA);
        transA.setNode(objectA);
        transA.setAutoReverse(false);
        transA.setInterpolator(Interpolator.LINEAR);
        transA.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        transA.setCycleCount(Animation.INDEFINITE);
        
        // Part B
        // ObjectB
        Polygon objectB = new Polygon(200,150,300,150,250,100);
        objectB.setFill(Color.valueOf("56728B"));
        
        // Translation for B
        FadeTransition ft = new FadeTransition();
        ft.setFromValue(1.0);
        ft.setToValue(0.5);
        ft.setDuration(Duration.millis(1000));
        
        ScaleTransition st = new ScaleTransition();
        st.setFromX(1);
        st.setFromY(1);
        st.setToX(2);
        st.setToY(2);
        st.setDuration(Duration.millis(500));
        
        RotateTransition rt = new RotateTransition();
        rt.setFromAngle(0);
        rt.setToAngle(180);
        rt.setDuration(Duration.millis(1000));
        
        TranslateTransition tt = new TranslateTransition();
        tt.setToY(-10);
        tt.setDuration(Duration.millis(500));
        
        SequentialTransition seqB = new SequentialTransition(ft,st,rt,tt);
        seqB.setNode(objectB);
        seqB.setCycleCount(Animation.INDEFINITE);
        
        // Start A and B together
        ParallelTransition ab = new ParallelTransition(transA, seqB);
        
        // Buttons
        Button start = new Button("Start");
        start.setOnAction(e -> {
            ab.play();
        });
        
        Button reset = new Button("Reset");
        reset.setOnAction(e -> {
            if (ab.getStatus().equals(Status.PAUSED)) {
                ab.play();
                ab.jumpTo(Duration.millis(1));
                ab.pause();
            } else {
                ab.play();
                ab.jumpTo(Duration.millis(1));
            }
        });
        
        Button exit = new Button("Pause");
        exit.setOnAction(e -> {
            ab.pause();
        });
        
        // Scene
        BorderPane root = new BorderPane();
        Pane display = new Pane();
        display.getChildren().addAll(objectA, pathA, objectB);
        HBox buttons = new HBox();
        buttons.getChildren().addAll(start,reset,exit);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(15);
        buttons.setPadding(new Insets(10,10,10,10));
        root.setCenter(display);
        root.setBottom(buttons);
        Scene scene = new Scene(root, 500, 400);
        stage.setScene(scene);
        stage.show();
    }
}
