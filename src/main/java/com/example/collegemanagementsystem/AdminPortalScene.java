package com.example.collegemanagementsystem;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AdminPortalScene extends Application {

    private final String profileName = "Kevin";  // Replace with dynamic name if needed

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Image icon = new Image(getClass().getResourceAsStream("/icon/icon.png"));
        primaryStage.getIcons().add(icon);

        // Top Navbar
        HBox navbar = new HBox();
        navbar.setPadding(new Insets(0));
//        navbar.setStyle("-fx-background-color: #2C3E50;");
        navbar.setAlignment(Pos.CENTER);
        navbar.setPrefHeight(70);
        navbar.setBackground(new Background(new BackgroundFill(
                new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE,
                        new Stop(0, Color.web("#0F2027")),
                        new Stop(0.5, Color.web("#203A43")),
                        new Stop(1, Color.web("#2C5364"))
                ),
                CornerRadii.EMPTY, null
        )));

        Button homeBtn = createNavButton("Home");
        Button recordsBtn = createNavButton("Records");
        Button profileBtn = createNavButton("Profile");

        HBox.setHgrow(homeBtn, Priority.ALWAYS);
        HBox.setHgrow(recordsBtn, Priority.ALWAYS);
        HBox.setHgrow(profileBtn, Priority.ALWAYS);

        homeBtn.setMaxWidth(Double.MAX_VALUE);
        recordsBtn.setMaxWidth(Double.MAX_VALUE);
        profileBtn.setMaxWidth(Double.MAX_VALUE);

        homeBtn.setMaxHeight(Double.MAX_VALUE);
        recordsBtn.setMaxHeight(Double.MAX_VALUE);
        profileBtn.setMaxHeight(Double.MAX_VALUE);

        Region divider1 = createVerticalDivider();
        Region divider2 = createVerticalDivider();

        navbar.getChildren().addAll(homeBtn, divider1, recordsBtn, divider2, profileBtn);

        // Center Content Area
        StackPane contentPane = new StackPane();
        contentPane.setPadding(new Insets(20));

        // Home View (default)
        VBox homeView = new VBox(10);
        homeView.setAlignment(Pos.CENTER);
        Label welcomeLabel = new Label("Hello " + profileName + ", welcome to the Admin Portal");
        welcomeLabel.setFont(Font.font("Arial", 22));
        homeView.getChildren().add(welcomeLabel);

        // Records View
        VBox recordsView = new VBox(15);
        recordsView.setAlignment(Pos.CENTER);
//
//        Button checkRecord = new Button("Check Record");
//        Button addRecord = new Button("Add Record");
//        Button deleteRecord = new Button("Delete Record");
//        Button updateRecord = new Button("Update Record");
//
//        for (Button btn : new Button[]{checkRecord, addRecord, deleteRecord, updateRecord}) {
//            btn.setMinWidth(200);
//            btn.setFont(Font.font("Arial", 14));
//        }
//
//        recordsView.getChildren().addAll(checkRecord, addRecord, deleteRecord, updateRecord);

        Button checkRecord = createStyledRecordButton("Check Record");
        Button addRecord = createStyledRecordButton("Add Record");
        Button deleteRecord = createStyledRecordButton("Delete Record");
        Button updateRecord = createStyledRecordButton("Update Record");

        checkRecord.setOnAction(e -> switchView(contentPane, createCheckRecordForm()));
        addRecord.setOnAction(e -> switchView(contentPane, createAddRecordForm()));
        deleteRecord.setOnAction(e -> switchView(contentPane, createDeleteRecordForm()));
        updateRecord.setOnAction(e -> switchView(contentPane, createUpdateRecordForm()));

        recordsView.getChildren().addAll(checkRecord, addRecord, deleteRecord, updateRecord);


        // Profile View
        VBox profileView = new VBox(10);
        profileView.setAlignment(Pos.CENTER);
        profileView.getChildren().add(new Label("Profile Section Coming Soon..."));

        // Set default view
        contentPane.getChildren().add(homeView);

        // Navigation Logic
        homeBtn.setOnAction(e -> switchView(contentPane, homeView));
        recordsBtn.setOnAction(e -> switchView(contentPane, recordsView));
        profileBtn.setOnAction(e -> switchView(contentPane, profileView));

        // Layout
        BorderPane layout = new BorderPane();
        layout.setTop(navbar);
        layout.setCenter(contentPane);

        Scene scene = new Scene(layout, 1120, 700);  // 16:10 resolution
        primaryStage.setTitle("College Management System - Admin Portal");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button createStyledRecordButton(String text) {
        Button button = new Button(text);
        button.setFont(Font.font("Arial", 14));
        button.setMinWidth(220);
        button.setTextFill(Color.WHITE);
        button.setStyle(
                "-fx-background-radius: 8;" +
                        "-fx-background-color: linear-gradient(to bottom right, #203A43, #2C5364);" +
                        "-fx-border-color: transparent;" +
                        "-fx-padding: 10 20;" +
                        "-fx-cursor: hand;"
        );

        button.setOnMouseEntered(e -> button.setStyle(
                "-fx-background-radius: 8;" +
                        "-fx-background-color: linear-gradient(to bottom right, #2C5364, #203A43);" +
                        "-fx-border-color: transparent;" +
                        "-fx-padding: 10 20;" +
                        "-fx-cursor: hand;"
        ));

        button.setOnMouseExited(e -> button.setStyle(
                "-fx-background-radius: 8;" +
                        "-fx-background-color: linear-gradient(to bottom right, #203A43, #2C5364);" +
                        "-fx-border-color: transparent;" +
                        "-fx-padding: 10 20;" +
                        "-fx-cursor: hand;"
        ));

        return button;
    }


    private Button createNavButton(String text) {
        Button button = new Button(text);
        button.setFont(Font.font("Arial", 16));
        button.setTextFill(Color.WHITE);
        button.setStyle("-fx-background-color: transparent; -fx-border-width: 0;");
//        button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: #34495E; -fx-text-fill: white;"));
        button.setOnMouseExited(e -> button.setStyle("-fx-background-color: transparent; -fx-text-fill: white;"));
        return button;
    }

    private Region createVerticalDivider() {
        Region divider = new Region();
        divider.setPrefWidth(1);
//        divider.setMaxHeight(Double.MAX_VALUE);
        divider.setMaxHeight(35);
        divider.setStyle("-fx-background-color: rgba(255, 255, 255, 0.3);");
        VBox.setVgrow(divider, Priority.ALWAYS);
        return divider;
    }

    private void switchView(StackPane contentPane, VBox newView) {
        contentPane.getChildren().clear();
        contentPane.getChildren().add(newView);
    }

    private VBox createCheckRecordForm() {
        VBox form = new VBox(10);
        form.setAlignment(Pos.CENTER);
        form.setPadding(new Insets(20));

        Label label = new Label("Enter Student ID to Check Record:");
        TextField idField = new TextField();
        idField.setPromptText("Student ID");

        Button submit = new Button("Check");
        submit.setOnAction(e -> {
            // Add logic to fetch and display record
            System.out.println("Checking record for ID: " + idField.getText());
        });

        form.getChildren().addAll(label, idField, submit);
        return form;
    }

    private VBox createAddRecordForm() {
        VBox form = new VBox(10);
        form.setAlignment(Pos.CENTER);
        form.setPadding(new Insets(20));

        TextField nameField = new TextField();
        nameField.setPromptText("Name");

        TextField rollField = new TextField();
        rollField.setPromptText("Roll Number");

        TextField deptField = new TextField();
        deptField.setPromptText("Department");

        Button submit = new Button("Add Record");
        submit.setOnAction(e -> {
            // Add logic to insert record
            System.out.println("Adding Record: " + nameField.getText());
        });

        form.getChildren().addAll(new Label("Add New Student Record"), nameField, rollField, deptField, submit);
        return form;
    }

    private VBox createDeleteRecordForm() {
        VBox form = new VBox(10);
        form.setAlignment(Pos.CENTER);
        form.setPadding(new Insets(20));

        Label label = new Label("Enter Student ID to Delete:");
        TextField idField = new TextField();
        idField.setPromptText("Student ID");

        Button submit = new Button("Delete");
        submit.setOnAction(e -> {
            // Add logic to delete record
            System.out.println("Deleting record for ID: " + idField.getText());
        });

        form.getChildren().addAll(label, idField, submit);
        return form;
    }

    private VBox createUpdateRecordForm() {
        VBox form = new VBox(10);
        form.setAlignment(Pos.CENTER);
        form.setPadding(new Insets(20));

        TextField idField = new TextField();
        idField.setPromptText("Student ID");

        TextField nameField = new TextField();
        nameField.setPromptText("New Name");

        TextField deptField = new TextField();
        deptField.setPromptText("New Department");

        Button submit = new Button("Update");
        submit.setOnAction(e -> {
            // Add logic to update record
            System.out.println("Updating record ID: " + idField.getText());
        });

        form.getChildren().addAll(new Label("Update Student Record"), idField, nameField, deptField, submit);
        return form;
    }

}