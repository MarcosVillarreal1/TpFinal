package org.example.Hoteleria;

import org.example.Interfaces.IEstado;

public abstract class Hoteleria implements IEstado {
    private boolean estado;
    /*private double precio;*/

    public Hoteleria() {
    }

    public Hoteleria(boolean estado, double precio) {
        this.estado = estado;
        this.precio = precio;
    }

    public boolean isEstado() {
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

    @Override
    public String toString() {
        return  "Estado: " + estado + "\n" +
                "Precio: $" + precio;
    }


}
