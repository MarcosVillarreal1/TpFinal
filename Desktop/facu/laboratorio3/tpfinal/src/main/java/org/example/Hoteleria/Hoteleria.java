package org.example.Hoteleria;

import org.example.Interfaces.IEstado;

public class Hoteleria implements IEstado {
    private boolean estado;
    private String descripcion;

    private double precio;

    public Hoteleria() {
    }

    public Hoteleria(boolean estado, String descripcion, double precio) {
        this.estado = estado;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public void cambioEstado() {
        if(isEstado())
        {
            setEstado(false);
        }else
        {
            setEstado(true);
        }
    }

    @Override
    public String toString() {
        return  "Estado: " + estado + "\n";
    }


}
