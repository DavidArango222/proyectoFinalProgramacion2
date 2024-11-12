package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.services;

public interface IObservable {
    void agregarObservador(IObservador observador);
    void eliminarObservador(IObservador observador);
    void notificarObservadores();
}