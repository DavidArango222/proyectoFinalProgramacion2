package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.viewcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.factory.ModelFactory;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Vendedor;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;

public class MarketplaceViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Tab administradorTab;

    @FXML
    private TabPane mainTab;

    @FXML
    void initialize() {
        try {
            URL adminViewUrl = getClass().getResource("/co/edu/uniquindio/marketplaceoficial/marketplaceoficialapp/adminview.fxml");
            System.out.println("URL encontrada: " + adminViewUrl);
            if (adminViewUrl == null) {
                throw new IOException("No se puede encontrar adminview.fxml en la ruta especificada.");
            }
            FXMLLoader loader = new FXMLLoader(adminViewUrl);
            AnchorPane adminContent = loader.load();
            AdminViewController adminController = loader.getController();
            adminController.setMarketplaceController(this);
            administradorTab.setContent(adminContent);
            
            vincularTabsVendedores();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void vincularTabsVendedores() {
        List<Vendedor> vendedores = ModelFactory.getInstance().getMarketplace().getVendedores();
        for (Tab tab : mainTab.getTabs()) {
            String cedula = tab.getText();
            Vendedor vendedor = vendedores.stream()
                    .filter(v -> v.getCedula().equals(cedula))
                    .findFirst()
                    .orElse(null);
            if (vendedor != null) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/marketplaceoficial/marketplaceoficialapp/vendedor.fxml"));
                    AnchorPane vendedorContent = loader.load();
                    VendedorViewController vendedorController = loader.getController();
                    vendedorController.updateView(cedula);
                    tab.setContent(vendedorContent);
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Error al cargar la vista de Vendedor para la cédula: " + cedula);
                }
            }
        }
    }

    public void agregarTabVendedor(String cedula) {
        if (cedula == null || cedula.isEmpty()) {
            System.out.println("Cédula no puede estar vacía.");
            return;
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/marketplaceoficial/marketplaceoficialapp/vendedor.fxml"));
            AnchorPane vendedorContent = loader.load();

            VendedorViewController vendedorController = loader.getController();
            vendedorController.updateView(cedula);
            Tab nuevoTab = new Tab();
            nuevoTab.setText(cedula); // Título del tab con la cédula
            nuevoTab.setContent(vendedorContent); // Establecer el contenido del tab
            mainTab.getTabs().add(nuevoTab);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al cargar la vista de Vendedor.");
        }
    }

    public void eliminarTabVendedor(String cedula) {
        if (cedula == null || cedula.isEmpty()) {
            System.out.println("Cédula no puede estar vacía.");
            return;
        }
        // Buscar el tab con el título que coincide con la cédula
        Tab tabToRemove = null;
        for (Tab tab : mainTab.getTabs()) {
            if (cedula.equals(tab.getText())) {
                tabToRemove = tab;
                break;
            }
        }
        // Si se encontró el tab, eliminarlo
        if (tabToRemove != null) {
            mainTab.getTabs().remove(tabToRemove);
            System.out.println("Tab con cédula " + cedula + " eliminado.");
        } else {
            System.out.println("No se encontró un tab con la cédula " + cedula);
        }
    }

}
