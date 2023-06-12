package org.example.Menus;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Usuario;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MenuInicSecion {
    public static void menuUsuario(){
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenuInicial();
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            boolean estaOno;
            String user;
            String pass;
            boolean flag = false;
            int intentos = 0;
            Usuario usuario = new Usuario();

            switch (opcion) {
                case 1:
                    do {
                        System.out.println("Username: ");
                        user = scanner.nextLine();
                        usuario = buscarUser(user);
                        //consulta si hay datos en usuario. si no hay datos es por que el username no existe
                        if (usuario.getUsername() != null){
                            if(usuario.isEstado())
                            {
                                do {
                                    //uso usuario para que verifique el password del ese usuario y no que compare con todos los del archivo
                                    System.out.println("Password: ");
                                    pass = scanner.nextLine();
                                    //estaOno = buscarPass(pass);
                                    if (usuario.getPassword().equals(pass)){
                                        MenuComplejo.menuComplejo();
                                        //llamar al menu complejo
                                        flag = true;
                                    }
                                    else
                                    {
                                        //cuenta los intentos disponibles
                                        intentos++;
                                        System.out.println("Contraseña incorrecta. Tiene " + (4 - intentos) + " intentos mas");
                                    }
                                }while(!flag && intentos != 4);
                            }else
                            {
                                System.out.println("El usuario no esta disponible, para activarlo seleccione la opcion 'Opciones de Usuario' " +
                                        "y luego seleccione 'Recuperar cuenta'");
                                flag = false;
                            }
                        }else
                        {
                            System.out.println("El nombre de usuario no existe");
                        }
                    }while(!flag && intentos != 4);

                    break;
                case 2:
                    setearDatos(usuario, flag);
                    MenuComplejo.menuComplejo();
                    break;
                case 3:
                    MenuOpcionUser.menuOpcionUser();
                    //llamada al menu de opciones de usuario ---> contiene 3 opciones 1)dar de baja el usuario 2)recuperar la cuenta
                    //                                            3) modificar datos del usuario -> idea para las altas, bajas y modificaciones
                    break;
                case 0:
                    break;
                default:
                    System.out.println("La opcion introducida es invalida.");
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
        System.out.println("1. Iniciar sesion ");
        System.out.println("2. Registrarse ");
        System.out.println("3. Opciones de Usuario");
        System.out.println();
        System.out.println("0. Salir del programa");
        System.out.println("***************************");
    }

    public static Usuario buscarUser(String usuario){
        ObjectMapper objectMapper = new ObjectMapper();
        Usuario usuario1 = new Usuario();

        try {
            // Lee el JSON desde un archivo
            Usuario[] usuarios = objectMapper.readValue(new File("src/main/resources/Usuarios.json"), Usuario[].class);

            // Accede a los objetos Usuario
            for (Usuario user : usuarios) {
                if (user.getUsername().equals(usuario)){
                    usuario1 = user;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuario1;
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
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void actualizarArchUsuarios(Usuario usuario) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Usuario> usuarios = new ArrayList<>();

        try {
            // Lee el JSON desde un archivo y conviértelo a un arreglo de objetos Usuario
            Usuario[] usuariosArray = objectMapper.readValue(new File("src/main/resources/Usuarios.json"), Usuario[].class);
            usuarios.addAll(Arrays.asList(usuariosArray));

            // Crea un nuevo objeto Persona
            //Usuario nuevoUsuario = new Usuario(nombre, apellido, cel, username, pass);

            // Agrega el nuevo objeto Persona al arreglo existente
            usuarios.add(usuario);

            // Convierte el arreglo actualizado de objetos Persona a JSON
            String jsonActualizado = objectMapper.writeValueAsString(usuarios);

            // Escribe el JSON resultante en el archivo para reemplazar su contenido existente
            FileWriter fileWriter = new FileWriter("src/main/resources/Usuarios.json");
            fileWriter.write(jsonActualizado);
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Usuario setearDatos(Usuario usuario, boolean flag)
    {
        boolean estaOno;
        Usuario usuario2 = new Usuario();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Name: ");
        usuario.setNombre(scanner.nextLine());
        System.out.println("Surname: ");
        usuario.setApellido(scanner.nextLine());
        System.out.println("Phone number: ");
        usuario.setCelular(scanner.nextLong());
        scanner.nextLine();
        usuario.setEstado(true);
        do {
            System.out.println("Username: ");
            usuario.setUsername(scanner.nextLine());
            usuario2 = buscarUser(usuario.getUsername());
            if (usuario2.getUsername() == null){
                do {
                    System.out.println("Password: ");
                    usuario.setPassword(scanner.nextLine());
                    estaOno = buscarPass(usuario.getPassword());
                    if (!estaOno) {
                        actualizarArchUsuarios(usuario);
                        flag = true;
                    } else {
                        System.out.println("La password ya esta utilizada, por favor ingrese otra.");
                    }
                }while(!flag);
            }else
            {
                System.out.println("El usuario ya esta tomado, por favor ingrese otro nombre de usuario");
            }
        }while(!flag);
        return usuario;
    }
}
