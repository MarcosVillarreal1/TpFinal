package org.example;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.UUID;

public class Reserva {

    private UUID idReserva;
    //private LocalDate fechaInicial;
    //private LocalDate fechaFinal;
    private Usuario cliente;
    private double importeReserva;
    //private FormaPago formaPago;
    //private double saldoAPagar;
    private String producto;

    public Reserva() {
    }

    public Reserva(UUID idReserva, Usuario cliente, double importeReserva, String producto) {
        this.idReserva = UUID.randomUUID();
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

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public double getSaldoAPagar() {
        return saldoAPagar;
    }

    public void setSaldoAPagar(double saldoAPagar) {
        this.saldoAPagar = saldoAPagar;
    }


    public enum FormaPago
    {
        CREDITO,
        DEBITO,
        EFECTIVO;
    }
}
