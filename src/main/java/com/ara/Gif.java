package com.ara;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Gif extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Load the GIF image
        Image image = new Image("C:\\Users\\intech\\IdeaProjects\\Barmen2\\src\\Nkarner\\Spinner-1s-200px.gif");

        // Create an ImageView to display the GIF
        ImageView imageView = new ImageView(image);

        // Create a StackPane to hold the ImageView
        StackPane root = new StackPane();
        root.getChildren().add(imageView);

        // Create the scene
        Scene scene = new Scene(root, 400, 400);

        // Set the scene and show the stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

