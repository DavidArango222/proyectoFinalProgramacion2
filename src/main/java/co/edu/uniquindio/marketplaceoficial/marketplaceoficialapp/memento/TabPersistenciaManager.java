package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.memento;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TabPersistenciaManager {
    private static final String FILE_NAME = "tabsNuevos.txt";
    private static List<String> cedulasEnMemoria = new ArrayList<>();

    public static void guardarTabsNuevos(List<String> cedulas) {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            for (String cedula : cedulas) {
                writer.write(cedula + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al guardar los tabs nuevos.");
        }
    }

    public static List<String> cargarTabsNuevos() {
        List<String> cedulas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String cedula;
            while ((cedula = reader.readLine()) != null) {
                cedulas.add(cedula);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al cargar los tabs nuevos.");
        }
        return cedulas;
    }

    public static void agregarCedula(String cedula) {
        if (!cedulasEnMemoria.contains(cedula)) {
            cedulasEnMemoria.add(cedula);
        }
    }

    public static List<String> obtenerCedulas() {
        return new ArrayList<>(cedulasEnMemoria);
    }

    public static void limpiarDatos() {
        cedulasEnMemoria.clear();

    }

    public static void limpiarArchivo(){
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            writer.write("");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al vaciar el archivo de tabs.");
        }
    }
}



