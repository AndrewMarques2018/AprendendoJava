package com.calculadora;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AppCalculadora extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        Pane root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CalcView.fxml")));

        Scene scene = new Scene(root);
        stage.setTitle("Calc");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}