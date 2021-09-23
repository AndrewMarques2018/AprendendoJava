package group.primeirojavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class ControlerTela {

    @FXML
    private Button click;

    @FXML
    public void onClickAction (){
        System.out.println("vc clicou no botao");

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("titulo");
        alert.setHeaderText("header");
        alert.setContentText("content text");
        alert.show();
    }

}
