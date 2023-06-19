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

public class MenuOpcionUser {
    public static void menuOpcionUser()
    {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        String user;
        String pass;
        boolean flag = false;
        boolean salida = false;
        int intentos = 0;
        Usuario usuario = new Usuario();

        do {
            try {
                mostrarMenuUser();
                System.out.print("Ingrese una opción: ");
                opcion = Integer.parseInt(scanner.nextLine());
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        do {
                            System.out.println("Username: ");
                            user = scanner.nextLine();
                            usuario = buscarUser(user);
                            //consulta si hay datos en usuario. si no hay datos es por que el username no existe
                            if (usuario.getUsername() != null) {
                                if (usuario.isEstado()) {
                                    do {
                                        //uso usuario para que verifique el password de ese usuario y no que compare con todos los del archivo
                                        System.out.println("Password: ");
                                        pass = scanner.nextLine();
                                        //estaOno = buscarPass(pass);
                                        if (usuario.getPassword().equals(pass)) {
                                            usuario.setEstado(false);
                                            flag = true;
                                            actualizarArchUsuarios(usuario);
                                        } else {
                                            //cuenta los intentos disponibles
                                            intentos++;
                                            System.out.println("Contraseña incorrecta. Tiene " + (4 - intentos) + " intentos mas");
                                        }
                                    } while (!flag && intentos != 4);
                                } else {
                                    System.out.println("El usuario ya se ha dado de baja");
                                }
                            } else {
                                System.out.println("El nombre de usuario no existe");
                            }
                        } while (!flag && intentos != 4);
                        break;
                    case 2:
                        do {
                            System.out.println("Username: ");
                            user = scanner.nextLine();
                            usuario = buscarUser(user);
                            if (usuario.getUsername() != null) {
                                if (usuario.isEstado()) {
                                    System.out.println("El usuario ya esta activo");
                                } else {
                                    do {
                                        //uso usuario para que verifique el password de ese usuario y no que compare con todos los del archivo
                                        System.out.println("Password: ");
                                        pass = scanner.nextLine();
                                        //estaOno = buscarPass(pass);
                                        if (usuario.getPassword().equals(pass)) {
                                            usuario.setEstado(true);
                                            flag = true;
                                            actualizarArchUsuarios(usuario);
                                        } else {
                                            //cuenta los intentos disponibles
                                            intentos++;
                                            System.out.println("Contraseña incorrecta. Tiene " + (4 - intentos) + " intentos mas");
                                        }
                                    } while (!flag && intentos != 4);
                                }
                            }
                        } while (!flag && intentos != 4);
                        break;
                    case 3:
                        do {
                            System.out.println("Ingrese su nombre de usuario: ");
                            user = scanner.nextLine();
                            usuario = buscarUser(user);
                            if (usuario.getUsername() != null) {
                                do {
                                    //uso usuario para que verifique el password de ese usuario y no que compare con todos los del archivo
                                    System.out.println("Password: ");
                                    pass = scanner.nextLine();
                                    //estaOno = buscarPass(pass);
                                    if (usuario.getPassword().equals(pass)) {
                                        setearDatos(usuario, flag);
                                        actualizarArchUsuarios(usuario);
                                        flag = true;
                                    } else {
                                        //cuenta los intentos disponibles
                                        intentos++;
                                        System.out.println("Contraseña incorrecta. Tiene " + (4 - intentos) + " intentos mas");
                                    }
                                } while (!flag && intentos != 4);
                            } else {
                                System.out.println("El nombre de usuario no existe");
                            }
                        } while (!flag);
                        break;
                    case 0:
                        salida = true;
                        break;
                    default:
                        System.out.println("La opcion introducida es invalida.");
                        break;
                }
            }catch(NumberFormatException e)
            {
                System.out.println("Dato ingresado incorrecto, por favor ingrese un numero.");
            }
        }while(!salida);
    }

    public static void mostrarMenuUser()
    {
        System.out.println("***************************");
        System.out.println("       OPCIONES DE USUARIO       ");
        System.out.println("***************************");
        System.out.println("1. Dar de baja mi cuenta ");
        System.out.println("2. Recuperar cuenta ");
        System.out.println("3. Modificar mis datos ");
        System.out.println();
        System.out.println("0. Volver al menu de inicio");
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
        int i = 0;

        try {
            // Lee el JSON desde un archivo y conviértelo a un arreglo de objetos Usuario
            Usuario[] usuariosArray = objectMapper.readValue(new File("src/main/resources/Usuarios.json"), Usuario[].class);
            usuarios.addAll(Arrays.asList(usuariosArray));

            for (Usuario user : usuarios) {
                if (user.getIdUsuario().equals(usuario.getIdUsuario())){
                    usuarios.get(i).setNombre(usuario.getNombre());
                    usuarios.get(i).setApellido(usuario.getApellido());
                    usuarios.get(i).setCelular(usuario.getCelular());
                    usuarios.get(i).setUsername(usuario.getUsername());
                    usuarios.get(i).setPassword(usuario.getPassword());
                    usuarios.get(i).setEstado(usuario.isEstado());
                }
                i++;
            }

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
        boolean salir = false;
        String dato;
        int opcion;
        Usuario usuario2 = new Usuario();
        Scanner scanner = new Scanner(System.in);

        do
        {
            try {
                flag = false;
                opcionesDeSeteo();
                System.out.print("Ingrese una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.println("Name: ");
                        usuario.setNombre(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Surname: ");
                        usuario.setApellido(scanner.nextLine());
                        break;
                    case 3:
                        System.out.println("Phone number: ");
                        usuario.setCelular(scanner.nextLong());
                        break;
                    case 4:
                        do {
                            System.out.println("Username: ");
                            dato = scanner.nextLine();
                            usuario2 = buscarUser(dato);
                            if (usuario2.getUsername() == null) {
                                flag = true;
                                usuario.setUsername(dato);
                            } else {
                                System.out.println("El usuario ya esta tomado, por favor ingrese otro nombre de usuario");
                            }
                        } while (!flag);
                        break;
                    case 5:
                        do {
                            System.out.println("Password: ");
                            dato = scanner.nextLine();
                            estaOno = buscarPass(dato);
                            if (!estaOno) {
                                flag = true;
                                usuario.setPassword(dato);
                            } else {
                                System.out.println("La password ya esta utilizada, por favor ingrese otra.");
                            }
                        } while (!flag);
                        break;
                    case 0:
                        salir = true;
                        break;
                    default:
                        System.out.println("La opcion introducida es invalida.");
                        break;
                }
            }catch(NumberFormatException e)
            {
                System.out.println("Dato ingresado incorrecto, por favor ingrese un numero.");
            }
        }while(!salir);
        return usuario;
    }

    public static void opcionesDeSeteo()
    {
        System.out.println("***************************");
        System.out.println("       OPCIONES DE MDIFICACION DE DATOS       ");
        System.out.println("***************************");
        System.out.println("1. Modificar nombre ");
        System.out.println("2. Modificar apellido ");
        System.out.println("3. Modificar celular ");
        System.out.println("4. Modificar username ");
        System.out.println("5. Modificar contraseña ");
        System.out.println();
        System.out.println("0. Volver al menu de opciones de usuario");
        System.out.println("***************************");
    }

}
