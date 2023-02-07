module edu.neumont.casinoapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.neumont.casinoapp to javafx.fxml;
    exports edu.neumont.casinoapp;
}