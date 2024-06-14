module org.example.myfinalproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.myfinalproject to javafx.fxml;
    exports org.example.myfinalproject;
}