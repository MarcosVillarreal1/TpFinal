package org.example.Hoteleria;

import org.example.Interfaces.IEstado;

public class Hoteleria implements IEstado {
    private boolean estado;
    private String descripcion;


    public Hoteleria() {
    }

    public Hoteleria(boolean estado, String descripcion) {
        this.estado = estado;
        this.descripcion = descripcion;
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
