package com.example.collegemanagementsystem;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FacultyPortalScene extends Application {

    private final String profileName = "Dr. Smith";  // customize or inject dynamically

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // -- background gradient (same as WelcomeScene & Admin) --
        Background gradient = new Background(new BackgroundFill(
            new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.web("#0F2027")),
                new Stop(0.5, Color.web("#203A43")),
                new Stop(1, Color.web("#2C5364"))
            ),
            CornerRadii.EMPTY, Insets.EMPTY
        ));

        // -- top navbar --
        HBox nav = new HBox(10);
        nav.setPadding(new Insets(10));
        nav.setBackground(gradient);
        nav.setAlignment(Pos.CENTER);

        Button homeBtn    = navButton("Home");
        Button classesBtn = navButton("My Classes");
        Button profileBtn = navButton("Profile");

        HBox.setHgrow(homeBtn, Priority.ALWAYS);
        HBox.setHgrow(classesBtn, Priority.ALWAYS);
        HBox.setHgrow(profileBtn, Priority.ALWAYS);
        homeBtn.setMaxWidth(Double.MAX_VALUE);
        classesBtn.setMaxWidth(Double.MAX_VALUE);
        profileBtn.setMaxWidth(Double.MAX_VALUE);

        nav.getChildren().addAll(homeBtn, classesBtn, profileBtn);

        // -- content area --
        StackPane content = new StackPane();
        content.setPadding(new Insets(20));

        // Home view
        VBox homeView = new VBox(10);
        homeView.setAlignment(Pos.CENTER);
        Label hello = new Label("Hello " + profileName + ", welcome to Faculty Portal");
        hello.setFont(Font.font("Arial", 20));
        hello.setTextFill(Color.WHITE);
        homeView.getChildren().add(hello);

        // Classes view
        VBox classesView = new VBox(15);
        classesView.setAlignment(Pos.CENTER);
        Button viewStudents    = styledBtn("View Students");
        Button takeAttendance  = styledBtn("Take Attendance");
        Button gradeAssignment = styledBtn("Grade Assignment");
        classesView.getChildren().addAll(viewStudents, takeAttendance, gradeAssignment);

        // Profile view
        VBox profileView = new VBox(10);
        profileView.setAlignment(Pos.CENTER);
        Label nameLabel = new Label("Name: " + profileName);
        Label deptLabel = new Label("Department: Computer Science");
        nameLabel.setTextFill(Color.WHITE); deptLabel.setTextFill(Color.WHITE);
        nameLabel.setFont(Font.font(18));   deptLabel.setFont(Font.font(16));
        profileView.getChildren().addAll(nameLabel, deptLabel);

        // default
        content.getChildren().add(homeView);

        // wire nav buttons
        homeBtn.setOnAction(e -> switchTo(content, homeView));
        classesBtn.setOnAction(e -> switchTo(content, classesView));
        profileBtn.setOnAction(e -> switchTo(content, profileView));

        // assemble
        BorderPane root = new BorderPane();
        root.setTop(nav);
        root.setCenter(content);
        root.setBackground(gradient);

        Scene scene = new Scene(root, 1120, 700);
        primaryStage.setTitle("College Management System – Faculty Portal");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button navButton(String txt) {
        Button b = new Button(txt);
        b.setFont(Font.font("Arial",16));
        b.setTextFill(Color.WHITE);
        b.setStyle("-fx-background-color: transparent;");
        b.setOnMouseEntered(e -> b.setStyle("-fx-background-color: rgba(255,255,255,0.1);"));
        b.setOnMouseExited(e  -> b.setStyle("-fx-background-color: transparent;"));
        return b;
    }

    private Button styledBtn(String txt) {
        Button b = new Button(txt);
        b.setMinWidth(200);
        b.setFont(Font.font("Arial",14));
        b.setTextFill(Color.WHITE);
        b.setStyle(
          "-fx-background-radius:8;"+
          "-fx-background-color: linear-gradient(to bottom right, #203A43, #2C5364);"+
          "-fx-cursor: hand;"
        );
        b.setOnMouseEntered(e -> b.setStyle(
          "-fx-background-radius:8;"+
          "-fx-background-color: linear-gradient(to bottom right, #2C5364, #203A43);"+
          "-fx-cursor: hand;"
        ));
        b.setOnMouseExited(e -> b.setStyle(
          "-fx-background-radius:8;"+
          "-fx-background-color: linear-gradient(to bottom right, #203A43, #2C5364);"+
          "-fx-cursor: hand;"
        ));
        return b;
    }

    private void switchTo(StackPane content, VBox view) {
        content.getChildren().setAll(view);
    }
}
