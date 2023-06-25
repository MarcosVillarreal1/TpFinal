package org.example.Menus;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Hoteleria.Hoteleria;
import org.example.Interfaces.IArchivoReserva;
import org.example.Reserva;
import org.example.Usuario;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class MenuHoteleria implements IArchivoReserva {

    public void menuHoteleria(Reserva reserva, Usuario usuario)
    {
        reserva = reserva;
        Scanner scanner = new Scanner(System.in);

        int cantDias;
        Double importe;
        boolean salir = false;
        int opcion;


        String tipoHab;
        //boolean habilitada;
        //LocalDate fechaInic;


        do {
            mostrarMenuHoteleria();
            try {
                String SN;
                System.out.print("Ingrese una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();
                int cont;





                switch (opcion) {
                    case 1:
                        System.out.println("Incluye: \n-Cama matrimonial. \n-Room service. \n-Desayuno buffet. \n-Valet parking. \n-Frigobar.");
                        System.out.println("Precio: $3000 /noche");

                        tipoHab = "Habitacion Estandar";
                        cont = verificarDispo(tipoHab);
                        if (cont == 0){
                            System.out.println("No hay habitaciones disponibles de este tipo.");
                        }else {
                            System.out.println("Cuantos dias desea reservar?: ");
                            cantDias = scanner.nextInt();
                            importe = (double) (cantDias * 3000);
                            System.out.println("El valor total es de $" + importe);

                            System.out.println("Esta seguro de reservar este tipo de habitacion? Presione 's' para si, cualquier letra para no ");
                            try {
                                scanner.nextLine();
                                SN = scanner.nextLine();
                                if(SN.matches("[A-Z]*") || SN.matches("[a-z]*"))
                                {
                                    if(SN.equalsIgnoreCase("s")) {
                                        reserva.setearDatos(usuario, cantDias, importe, tipoHab);
                                        recorrerArchHab(tipoHab);
                                        actualizarArchReservas(reserva);
                                    }

                                }else
                                {
                                    throw new InputMismatchException();
                                }
                            }catch(InputMismatchException e)
                            {
                                System.out.println("Opcion invalida, use letras por favor");
                            }

                        }
                        break;
                    case 2:
                        System.out.println("Incluye: \n-Cama matrimonial y 2 camas individuales. \n-Room service. \n-Desayuno buffet. \n-Valet parking \n-Frigobar. \n-Wi-Fi . \n-TV-LED y video cable.");
                        System.out.println("Precio: $5000 /noche");

                        tipoHab = "Habitacion Familiar";
                        cont = verificarDispo(tipoHab);
                        if (cont == 0){
                            System.out.println("No hay habitaciones disponibles de este tipo.");
                        }else {
                            System.out.println("Cuantos dias desea reservar?: ");
                            cantDias = scanner.nextInt();
                            importe = (double) (cantDias * 5000);
                            System.out.println("El valor total es de $" + importe);

                            System.out.println("Esta seguro de reservar este tipo de habitacion? Presione 's' para si, cualquier letra para no ");
                            try {
                                scanner.nextLine();
                                SN = scanner.nextLine();
                                if(SN.matches("[A-Z]*") || SN.matches("[a-z]*"))
                                {
                                    if(SN.equalsIgnoreCase("s")) {
                                        reserva.setearDatos(usuario, cantDias, importe, tipoHab);
                                        recorrerArchHab(tipoHab);
                                        actualizarArchReservas(reserva);
                                    }

                                }else
                                {
                                    throw new InputMismatchException();
                                }
                            }catch(InputMismatchException e)
                            {
                                System.out.println("Opcion invalida, use letras por favor");
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Incluye: \n-Cama matrimonial y 2 camas individuales. \n-Room service. \n-Desayuno buffet. \n-Valet parking \n-Frigobar. \n-Wi-Fi . \n-TV-LED y video cable. \n-Jacuzzi. \n-Aire acondicionado. \n-Caja de Seguridad digital ");
                        System.out.println("Precio: $10000 /noche");

                        tipoHab = "Habitacion Premium";
                        cont = verificarDispo(tipoHab);
                        if (cont == 0){
                            System.out.println("No hay habitaciones disponibles de este tipo.");
                        }else {
                            System.out.println("Cuantos dias desea reservar?: ");
                            cantDias = scanner.nextInt();
                            importe = (double) (cantDias * 10000);
                            System.out.println("El valor total es de $" + importe);

                            System.out.println("Esta seguro de reservar este tipo de habitacion? Presione 's' para si, cualquier letra para no ");
                            try {
                                scanner.nextLine();
                                SN = scanner.nextLine();
                                if(SN.matches("[A-Z]*") || SN.matches("[a-z]*"))
                                {
                                    if(SN.equalsIgnoreCase("s")) {
                                        reserva.setearDatos(usuario, cantDias, importe, tipoHab);
                                        recorrerArchHab(tipoHab);
                                        actualizarArchReservas(reserva);
                                    }

                                }else
                                {
                                    throw new InputMismatchException();
                                }
                            }catch(InputMismatchException e)
                            {
                                System.out.println("Opcion invalida, use letras por favor");
                            }
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

    public void mostrarMenuHoteleria()
    {
        System.out.println("***************************");
        System.out.println("1. Habitacion Estandar");
        System.out.println("2. Habitacion Familiar");
        System.out.println("3. Habitacion Premium");
        System.out.println();
        System.out.println("0. Salir del menu de hoteleria");
        System.out.println("***************************");
    }

    public static int verificarDispo(String tipoHab)
    {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Lee el JSON desde un archivo
            Hoteleria[] arrayHab = objectMapper.readValue(new File("src/main/resources/Habitaciones.json"), Hoteleria[].class);
            // Accede a los objetos Persona
            for (Hoteleria habitacion : arrayHab) {

                if (habitacion.getTipo().equals(tipoHab)){
                    if (habitacion.getEstado()){
                        return 1;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void recorrerArchHab(String tipoHab)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        int i = 0;
        List<Hoteleria> habitaciones = new ArrayList<>();

        try {
            // Lee el JSON desde un archivo
            Hoteleria[] arrayHab = objectMapper.readValue(new File("src/main/resources/Habitaciones.json"), Hoteleria[].class);
            habitaciones.addAll(Arrays.asList(arrayHab));
            // Accede a los objetos Persona
            for (Hoteleria habitacion : habitaciones) {

                if (habitacion.getTipo().equals(tipoHab)){
                    if (habitacion.getEstado()){
                        habitaciones.get(i).cambioEstado();
                        break;
                    }
                }
                i++;
            }
            String jsonActualizado = objectMapper.writeValueAsString(habitaciones);
            FileWriter fileWriter = new FileWriter("src/main/resources/Habitaciones.json");
            fileWriter.write(jsonActualizado);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

