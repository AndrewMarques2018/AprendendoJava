package com.combobox;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ControlerComboBoxView implements Initializable {

    @FXML
    private ComboBox<Pessoa> pessoaComboBox;

    private ObservableList<Pessoa> observableList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List<Pessoa> pessoaList = new ArrayList<>();
        pessoaList.add(new Pessoa(1, "Jose", 12));
        pessoaList.add(new Pessoa(2, "Joao", 22));
        pessoaList.add(new Pessoa(3, "Josias", 37));

        observableList = FXCollections.observableArrayList(pessoaList);
        pessoaComboBox.setItems(observableList);

        // modificacao para pegar apenas o nome da pessoa
        Callback<ListView<Pessoa> ,ListCell<Pessoa>> factory = lv -> new ListCell<Pessoa>() {
            @Override
            protected void updateItem (Pessoa item, boolean empty){
                super.updateItem(item, empty);
                setText(empty ? "" : item.getNome());
            }
        };

        pessoaComboBox.setCellFactory(factory);
        pessoaComboBox.setButtonCell(factory.call(null));


    }

    @FXML
    public void onComboBoxAction(){
        Pessoa pessoa = pessoaComboBox.getSelectionModel().getSelectedItem();
        System.out.println(pessoa);
    }
}
