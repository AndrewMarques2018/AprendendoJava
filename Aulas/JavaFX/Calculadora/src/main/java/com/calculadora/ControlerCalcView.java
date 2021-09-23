package com.calculadora;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class ControlerCalcView implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Constraints.setTextFieldDouble(txtNumber1);
        Constraints.setTextFieldDouble(txtNumber2);
        Constraints.setTextFieldMaxLength(txtNumber1, 8);
        Constraints.setTextFieldMaxLength(txtNumber2, 8);
    }

    @FXML
    private TextField txtNumber1;

    @FXML
    private TextField txtNumber2;

    @FXML
    private Label labelResult;

    @FXML
    private Button btSoma;

    @FXML
    public void onBtSumAction(){
        //trocar ponto para virgula
        Locale.setDefault(Locale.US);

        double number1 = Double.parseDouble(txtNumber1.getText());
        double number2 = Double.parseDouble(txtNumber2.getText());
        double sum = number1 + number2;
        labelResult.setText(String.format("%.2f", sum));
    }
}
