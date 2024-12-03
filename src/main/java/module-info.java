module com.mycompany.proyectodeaulaenergy {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.proyectodeaulaenergy to javafx.fxml;
    exports com.mycompany.proyectodeaulaenergy;
}
