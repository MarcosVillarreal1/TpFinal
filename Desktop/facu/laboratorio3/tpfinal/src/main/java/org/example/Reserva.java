package org.example;

import java.util.UUID;
    public class Reserva {

        private UUID idReserva;
        //private LocalDate fechaInicial;
        //private LocalDate fechaFinal;
        private Usuario cliente;
        private int cantDias;
        private double importeReserva;
        //private FormaPago formaPago;
        //private double saldoAPagar;
        private String producto;

    public Reserva() {
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

        public void setearDatos(Usuario cli, int cantDias, Double importe, String desc){
            setIdReserva(UUID.randomUUID());
            setCliente(cli);
             setCantDias(cantDias);
             setImporteReserva(importe);
             setProducto(desc);
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

        /*public FormaPago getFormaPago() {
    //        return formaPago;
            return null;
        }

        public void setFormaPago(FormaPago formaPago) {
    //        this.formaPago = formaPago;
        }

        public double getSaldoAPagar() {
            return saldoAPagar;
            //return 0.00;
        }

        public void setSaldoAPagar(double saldoAPagar) {
            this.saldoAPagar = saldoAPagar;
        }*/


        public String getProducto() {
            return producto;
        }

        public void setProducto(String producto) {
            this.producto = producto;
        }

        public int getCantDias() {
            return cantDias;
        }

        public void setCantDias(int cantDias) {
            this.cantDias = cantDias;
        }

        /*public enum FormaPago
        {
            CREDITO,
            DEBITO,
            EFECTIVO;
        }*/
    }
