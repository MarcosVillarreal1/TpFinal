package org.example.Hoteleria;

import org.example.Interfaces.IEstado;

public abstract class Hoteleria implements IEstado {
    private String tipo;
    private boolean estado;
    private double precio;

    public Hoteleria() {
    }

    public Hoteleria(String tipo, boolean estado, double precio) {
        this.tipo = tipo;
        this.estado = estado;
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


}
