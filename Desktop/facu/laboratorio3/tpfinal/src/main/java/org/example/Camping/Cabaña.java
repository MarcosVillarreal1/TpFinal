package org.example.Camping;

import org.example.Interfaces.IEstado;

public class Cabaña extends Camping implements IEstado {

    private boolean estado;

    public Cabaña(boolean estado) {
        super.setTipo("cabaña");
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
