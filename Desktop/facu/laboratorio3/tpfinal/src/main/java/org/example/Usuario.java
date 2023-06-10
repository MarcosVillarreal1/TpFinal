package org.example;

import org.example.Persona.Persona;

public class Usuario extends Persona {
    private String username;
    private String password;

    public Usuario(String nombre, String apellido, Integer celular, String username, String password) {
        super(nombre, apellido, celular);
        this.username = username;
        this.password = password;
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

    @Override
    public String toString() {
        return "Usuario{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
