package com.ua.tpm.aplication.demoanimationandgraphics;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

import java.io.IOException;

public class AnimationAndGraphics extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
        root.setDepthTest(DepthTest.ENABLE);

        Scene scene = new Scene(root);

        Camera camera = new PerspectiveCamera();
        scene.setCamera(camera);

        stage.setScene(scene);
        stage.setMaximized(true);
        stage.setTitle("Демонстрація графіків і анімації");
        stage.show();
    }
}