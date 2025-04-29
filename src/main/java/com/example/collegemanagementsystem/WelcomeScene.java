package com.example.collegemanagementsystem;

        import javafx.application.Application;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.image.Image;
        import javafx.scene.image.ImageView;
        import javafx.scene.layout.*;
        import javafx.stage.Stage;
        import javafx.geometry.Pos;
        import javafx.geometry.Insets;
        import javafx.scene.text.Font;
        import javafx.scene.text.FontWeight;
        import javafx.scene.paint.Color;
        import javafx.scene.paint.LinearGradient;
        import javafx.scene.paint.CycleMethod;
        import javafx.scene.paint.Stop;

        public class WelcomeScene extends Application {

            @Override
            public void start(Stage primaryStage) {
                // Set the icon for the stage
                Image icon = new Image(getClass().getResourceAsStream("/icon/icon.png"));
                Image bvp = new Image(getClass().getResourceAsStream("/icon/bvp.png"));
                Image bvimr = new Image(getClass().getResourceAsStream("/icon/BVIMR.png"));
                Image fiftyYears = new Image(getClass().getResourceAsStream("/icon/50.png"));
                primaryStage.getIcons().add(icon);

                // Add an image view at the top
                ImageView imageView = new ImageView(bvp);
                imageView.setFitHeight(300);
                imageView.setFitWidth(300);

                // Title
                Label title = new Label("Bharati Vidyapeeth (BVIMR) Deemed to be University, New Delhi");
                title.setFont(Font.font("Arial", FontWeight.BOLD, 28));
                title.setTextFill(Color.WHITE);
                title.setWrapText(true);
                title.setMaxWidth(1000);
                title.setAlignment(Pos.CENTER);

                // Subtitle
                Label subtitle = new Label("Select Your Portal");
                subtitle.setFont(Font.font("Arial", 18));
                subtitle.setTextFill(Color.web("#E0E0E0"));

                // Admin Button
                Button adminBtn = new Button("Admin Portal");
                adminBtn.setFont(Font.font("Arial", FontWeight.BOLD, 16));
                adminBtn.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-padding: 10 30 10 30;");
                adminBtn.setOnAction(e -> {
                    try {
                        new AdminPortalScene().start(primaryStage);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                });

                // Faculty Button
                Button facultyBtn = new Button("Faculty Portal");
                facultyBtn.setFont(Font.font("Arial", FontWeight.BOLD, 16));
                facultyBtn.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white; -fx-padding: 10 30 10 30;");
                facultyBtn.setOnAction(e -> {
                    try {
                        new FacultyPortalScene().start(primaryStage);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                });


                // Button HBox Layout
                HBox buttonBox = new HBox(40, adminBtn, facultyBtn);
                buttonBox.setAlignment(Pos.CENTER);

                // VBox Layout
                VBox vbox = new VBox(40, imageView, title, subtitle, buttonBox);
                vbox.setPadding(new Insets(50));
                vbox.setAlignment(Pos.CENTER);
                vbox.setBackground(new Background(new BackgroundFill(
                        new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE,
                                new Stop(0, Color.web("#0F2027")),
                                new Stop(0.5, Color.web("#203A43")),
                                new Stop(1, Color.web("#2C5364"))
                        ),
                        CornerRadii.EMPTY, null
                )));

                // Scene Setup
                Scene scene = new Scene(vbox, 1120, 700);
                primaryStage.setTitle("College Management System");
                primaryStage.setScene(scene);
                primaryStage.show();
            }

            public static void main(String[] args) {
                launch(args);
            }
        }