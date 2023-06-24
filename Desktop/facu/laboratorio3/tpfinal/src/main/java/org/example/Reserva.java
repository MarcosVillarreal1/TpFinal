package org.example;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.UUID;

public class Reserva {

    private UUID idReserva;
    //private LocalDate fechaInicial;
    //private LocalDate fechaFinal;
    private int cantDias;
    private Usuario cliente;
    private double importeReserva;
    //private FormaPago formaPago;
    //private double saldoAPagar;
    private String producto;

    public Reserva() {
    }

    public Reserva(Usuario cliente, double importeReserva, String producto) {
        this.idReserva = UUID.randomUUID();
        this.cliente = cliente;
        this.importeReserva = importeReserva;
        this.producto = producto;
    }

    public Reserva(int cantDias, Usuario cliente, double importeReserva, String producto) {
        this.idReserva = UUID.randomUUID();
        this.cantDias = cantDias;
        this.cliente = cliente;
        this.importeReserva = importeReserva;
        this.producto = producto;
    }

    public UUID getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(UUID idReserva) {
        this.idReserva = idReserva;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public double getImporteReserva() {
        return importeReserva;
    }

    public void setImporteReserva(double importeReserva) {
        this.importeReserva = importeReserva;
    }



    public enum FormaPago
    {
        CREDITO,
        DEBITO,
        EFECTIVO;
    }
}
