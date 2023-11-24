package org.example.Camping;

import org.example.Interfaces.IEstado;

public class Cabaña extends Camping implements IEstado {

    private boolean estado;

    public Cabaña() {
    }

    public Cabaña(String tipo, boolean estado) {
        super(tipo);
        this.estado = estado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
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
}
