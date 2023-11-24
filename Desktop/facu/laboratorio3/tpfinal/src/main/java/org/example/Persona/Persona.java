package org.example.Persona;

public abstract class Persona {
    private String nombre;
    private String apellido;
    private long celular;

    public Persona() {
    }

    public Persona(String nombre, String apellido, long celular) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", celular=" + celular +
                '}';
    }
}
