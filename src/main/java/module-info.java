module co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires kernel;
    requires layout;

    opens co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp to javafx.fxml;
    exports co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp;
    opens co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.viewcontroller to javafx.fxml;
    exports co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.viewcontroller;
}