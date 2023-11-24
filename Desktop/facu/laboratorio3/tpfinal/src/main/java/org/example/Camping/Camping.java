package org.example.Camping;

public abstract class Camping {
    private String tipo;

    public Camping() {
    }

    public Camping(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
