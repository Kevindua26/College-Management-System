package com.example.collegemanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.shape.Line;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.awt.*;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        Group root = new Group();
        Scene scene = new Scene(root, 1280, 720);
        Stage stage = new Stage();

        Image icon = new Image(getClass().getResourceAsStream("/icon/icon.png"));

        stage.getIcons().add(icon);
        stage.setTitle("College Management System");
//        stage.setResizable(false);
//        stage.setWidth(500);
//        stage.setHeight(500);
//        stage.setFullScreen(true);
//        stage.setFullScreenExitHint("You Can't Escape, Until You Press q");
//        stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q"));

        Text text = new Text("Welcome to the College Management System");
        text.setX(425);
        text.setY(100);
        text.setFont(javafx.scene.text.Font.font("Arial", FontWeight.BOLD, 20));
//        text.setFill(javafx.scene.paint.Color.BLUE);

        Line line = new Line();
        line.setStartX(0);
        line.setStartY(150);
        line.setEndX(1280);
        line.setEndY(150);
//        line.setStrokeWidth(5);
//        line.setStroke(javafx.scene.paint.Color.BLUE);
//        line.setOpacity(0.5);
//        line.setRotate(45);

//        root.getChildren().add(line);
        root.getChildren().add(text);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}