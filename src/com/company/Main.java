package com.company;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application {
    public static Timer timer = new Timer();
    private static int countx = 0;
    private static int county = 0;

    private static final int BOARD_WIDTH = 500;
    private static final int BOARD_HEIGHT = 500;

    private int x = 30;
    private int y = 100;
    private GraphicsContext gc;


    public static void main(String[] args) {
        System.out.println("kek");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Test");
        Canvas canvas = new Canvas();
        canvas.setWidth(BOARD_WIDTH);
        canvas.setHeight(BOARD_HEIGHT);
        BorderPane group = new BorderPane(canvas);
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.show();

        gc = canvas.getGraphicsContext2D();

        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                if(countx==0){
                    x=x+7;
                }else {
                    x=x-7;
                }
                if(county==0){
                    y=y+5;
                }else {
                    y=y-5;
                }
                if(x>gc.getCanvas().getWidth()-30){
                    countx=1;
                }
                if(y>gc.getCanvas().getHeight()-30){
                    county=1;
                }
                if (x<=0){
                    countx=0;
                }
                if(y<=0){
                    county=0;
                }
                clear();
                draw();
            }
        };
        timer.schedule(task,500,50);

    }

    private void clear() {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
    }

    private void draw() {
        gc.setLineWidth(2);
        gc.setStroke(Color.BLACK);
        gc.strokeOval(x, y, 30, 30);
        gc.setFill(Color.RED);
        gc.fillOval(x, y, 30, 30);
    }

}
