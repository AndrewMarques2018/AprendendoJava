package group.primeirojavafx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ApplicationFX extends javafx.application.Application {

    @Override
    public void start(Stage stage) throws IOException {

        Pane root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Tela.fxml")));

        Scene scene = new Scene(root);
        stage.setTitle("Tela");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
