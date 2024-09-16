module org.example.lab5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310; // Добавляем зависимость от модуля jsr310

    exports org.example.lab5.data to com.fasterxml.jackson.databind;

    opens org.example.lab5.data to com.fasterxml.jackson.databind; // Открываем пакет для Jackson
    opens org.example.lab5 to javafx.fxml;
    exports org.example.lab5;
}
