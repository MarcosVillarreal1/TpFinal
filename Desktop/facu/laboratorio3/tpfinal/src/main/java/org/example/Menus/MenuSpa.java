package org.example.Menus;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Interfaces.IArchivoReserva;
import org.example.Reserva;
import org.example.Usuario;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MenuSpa implements IArchivoReserva {

    public void menuSpa(Reserva reserva, Usuario user)
    {

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        String tipoSpa;
        int cantDias;
        Double importe;

        //boolean habilitada;

        do {
            mostrarMenuSpa();
            try {
                String SN = "a";
                System.out.print("Ingrese una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("Incluye servicio de Spa: \n-baños de vapor sauna, turco y finlandes. \n-Hidromasaje jacuzzi. \n-Piscina cubierta y climatizada.");


                        tipoSpa = "Spa Dia";
                        System.out.println("Cuantas dias desea reservar?: ");
                        cantDias = scanner.nextInt();
                        importe = (double) (cantDias * 2000);
                        System.out.println("El valor total es de $" + importe);

                        System.out.println("Esta seguro de reservar este tipo de habitacion? Presione 's' para si, cualquier letra para no ");
                        try {
                            SN = scanner.nextLine();
                            if(SN.equalsIgnoreCase("s")) {
                                reserva.setearDatos(user, cantDias, importe, tipoSpa);
                                actualizarArchReservas(reserva);
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Opcion invalida, use letras por favor");
                        }

                        break;
                    case 2:
                        System.out.println("Incluye servicio de Spa: \n-baños de vapor sauna, turco y finlandes. \n-Hidromasaje jacuzzi. \n-Piscina cubierta y climatizada. \n-Gabinete de estetica facial y corporal");

                        tipoSpa = "Spa Estadia";
                        System.out.println("Cuantas dias desea reservar?: ");
                        cantDias = scanner.nextInt();
                        importe = (double) (cantDias * 5000);
                        System.out.println("El valor total es de $" + importe);

                        System.out.println("Esta seguro de reservar este tipo de habitacion? Presione 's' para si, cualquier letra para no ");
                        try {
                            SN = scanner.nextLine();
                            if(SN.equalsIgnoreCase("s")) {
                                reserva.setearDatos(user, cantDias, importe, tipoSpa);
                                actualizarArchReservas(reserva);
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Opcion invalida, use letras por favor");
                        }
                        break;
                    case 3:
                        System.out.println("Incluye servicio de Spa: \n-baños de vapor sauna, turco y finlandes. \n-Hidromasaje jacuzzi. \n-Piscina cubierta y climatizada. \n-Gabinete de estetica facial y corporal. \n-Gimnasio con aparatos y personal trainer. \n-Salas de relax");

                        tipoSpa = "Spa Premium";
                        System.out.println("Cuantas dias desea reservar?: ");
                        cantDias = scanner.nextInt();
                        importe = (double) (cantDias * 7000);
                        System.out.println("El valor total es de $" + importe);

                        System.out.println("Esta seguro de reservar este tipo de habitacion? Presione 's' para si, cualquier letra para no ");
                        try {
                            SN = scanner.nextLine();
                            if(SN.equalsIgnoreCase("s")) {
                                reserva.setearDatos(user, cantDias, importe, tipoSpa);
                                actualizarArchReservas(reserva);
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Opcion invalida, use letras por favor");
                        }
                        break;
                    case 0:
                        salir = true;
                        break;
                    default:
                        System.out.println("La opcion introducida es invalida.");
                        break;
                }
            }catch (NumberFormatException e)
            {
                System.out.println("Dato ingresado incorrecto, por favor ingrese un numero.");
            }
        }while(!salir);
    }

    public void mostrarMenuSpa()
    {
        System.out.println("***************************");
        System.out.println("1. Dia");
        System.out.println("2. Estadia");
        System.out.println("3. Premium");
        System.out.println();
        System.out.println("0. Salir del menu spa");
        System.out.println("***************************");
    }

    public void actualizarArchReservas(Reserva reserva) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Reserva> reservas = new ArrayList<>();

        try {
            // Lee el JSON desde un archivo y conviértelo a un arreglo de objetos Usuario
            Reserva[] reservasArray = objectMapper.readValue(new File("src/main/resources/Reservas.json"), Reserva[].class);
            reservas.addAll(Arrays.asList(reservasArray));

            // Crea un nuevo objeto Persona
            //Usuario nuevoUsuario = new Usuario(nombre, apellido, cel, username, pass);

            // Agrega el nuevo objeto Persona al arreglo existente
            reservas.add(reserva);

            // Convierte el arreglo actualizado de objetos Persona a JSON
            String jsonActualizado = objectMapper.writeValueAsString(reservas);

            // Escribe el JSON resultante en el archivo para reemplazar su contenido existente
            FileWriter fileWriter = new FileWriter("src/main/resources/Reservas.json");
            fileWriter.write(jsonActualizado);
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
