module group.primeirojavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens group.primeirojavafx to javafx.fxml;
    exports group.primeirojavafx;
}