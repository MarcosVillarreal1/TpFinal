package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Persona.Persona;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menuUsuario();

    }

    public static void menuUsuario(){
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenuInicial();
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            boolean estaOno;
            String user;
            String pass;

            switch (opcion) {
                case 1:
                    System.out.println("Username: ");
                    user = scanner.nextLine();
                    estaOno = buscarUser(user);
                    if (estaOno){
                        System.out.println("Password: ");
                        pass = scanner.nextLine();
                        estaOno = buscarPass(pass);
                        if (estaOno){

                        }
                    }

                    break;
                case 2:
                    System.out.println("Name: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Surname: ");
                    String apellido = scanner.nextLine();
                    System.out.println("Phone number: ");
                    Integer celular = scanner.nextInt();
                    System.out.println("Username: ");
                    user = scanner.nextLine();
                    estaOno = buscarUser(user);
                    if (!estaOno){
                        System.out.println("Password: ");
                        pass = scanner.nextLine();
                        estaOno = buscarPass(pass);
                        if (!estaOno){
                            actualizarArchUsuarios(nombre, apellido, celular, user, pass);
                        }else {
                            System.out.println("La password esta utilizadad.");
                        }
                    }

                    break;
            }

            System.out.println();
        } while (opcion != 0);

        scanner.close();
    }

    public static void mostrarMenuInicial() {
        System.out.println("***************************");
        System.out.println("       INICIO       ");
        System.out.println("***************************");
        System.out.println("1. Iniciar sesion 1");
        System.out.println("2. Registrarse 2");
        System.out.println("***************************");
    }

    public static boolean buscarUser(String usuario){
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Lee el JSON desde un archivo
            Usuario[] usuarios = objectMapper.readValue(new File("src/main/resources/Usuarios.json"), Usuario[].class);

            // Accede a los objetos Usuario
            for (Usuario user : usuarios) {
                if (usuario.equals(user.getUsername())){
                    return true;
                }else {
                    return false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean buscarPass(String pass){
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Lee el JSON desde un archivo
            Usuario[] usuarios = objectMapper.readValue(new File("src/main/resources/Usuarios.json"), Usuario[].class);

            // Accede a los objetos Usuario
            for (Usuario user : usuarios) {
                if (pass.equals(user.getPassword())){
                    return true;
                }else {
                    return false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void actualizarArchUsuarios(String nombre, String apellido, Integer cel, String username, String pass) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Usuario> usuarios = new ArrayList<>();

        try {
            // Lee el JSON desde un archivo y conviértelo a un arreglo de objetos Usuario
            Usuario[] usuariosArray = objectMapper.readValue(new File("src/main/resources/Usuario.json"), Usuario[].class);
            usuarios.addAll(Arrays.asList(usuariosArray));

            // Crea un nuevo objeto Persona
            Usuario nuevoUsuario = new Usuario(nombre, apellido, cel, username, pass);

            // Agrega el nuevo objeto Persona al arreglo existente
            usuarios.add(nuevoUsuario);

            // Convierte el arreglo actualizado de objetos Persona a JSON
            String jsonActualizado = objectMapper.writeValueAsString(usuarios);

            // Escribe el JSON resultante en el archivo para reemplazar su contenido existente
            FileWriter fileWriter = new FileWriter("src/main/resources/Usuario.json");
            fileWriter.write(jsonActualizado);
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}