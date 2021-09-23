package com.combobox;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Objects;

public class AppComboBox extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Pane root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ComboBoxView.fxml")));

        Scene scene = new Scene(root);
        stage.setTitle("ComboBoxView");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
