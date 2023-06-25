package org.example.Interfaces;

import org.example.Usuario;

public interface IMetodosUser {
    Usuario buscarUser(String usuario);
    boolean buscarPass(String pass);
    void actualizarArchUsuarios(Usuario usuario);
    Usuario setearDatos(Usuario usuario, boolean flag);
}
