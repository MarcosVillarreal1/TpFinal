package org.example;

import org.example.Persona.Persona;

import java.util.UUID;

public class Usuario extends Persona {
    private String username;
    private String password;
    private boolean estado;

    private UUID idUsuario;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, Integer celular, String username, String password, boolean estado) {
        super(nombre, apellido, celular);
        this.username = username;
        this.password = password;
        this.estado = estado;
        this.idUsuario = UUID.randomUUID();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public UUID getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UUID idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
