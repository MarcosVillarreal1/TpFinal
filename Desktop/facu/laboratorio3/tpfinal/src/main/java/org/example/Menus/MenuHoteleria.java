package org.example.Menus;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Hoteleria.Hoteleria;
import org.example.Reserva;
import org.example.Usuario;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MenuHoteleria {

    public static void menuHoteleria(Reserva reserva, Usuario usuario)
    {
        reserva = reserva;
        Scanner scanner = new Scanner(System.in);

        boolean salir = false;
        int opcion;


        String tipoHab;
        //boolean habilitada;
        LocalDate fechaInic;

        System.out.println("1. Habitacion Estandar");
        System.out.println("2. Habitacion Familiar");
        System.out.println("3. Habitacion Premium");


        do {
            try {
                char SN = 'a';
                System.out.print("Ingrese una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();
                int cont;





                switch (opcion) {
                    case 1:
                        System.out.println("Incluye: \n-Cama matrimonial. \n-Room service. \n-Desayuno buffet. \n-Valet parking. \n-Frigobar.");

                        tipoHab = "Habitacion Estandar";
                        cont = verificarDispo(tipoHab);
                        if (cont == 0){
                            System.out.println("No hay habitaciones disponibles de este tipo.");
                        }else {
                            System.out.println("Cuantos dias desea reservar?: ");
                            int cantDias = scanner.nextInt();
                            Double importe = (double) (cantDias * 3000);
                            System.out.println("Esta seguro de reservar este tipo de habitacion? Presione 's' para si, cualquier letra para no ");
                            SN = (char) scanner.nextInt();
                            if(SN == 's')
                            {
                                reserva.setearDatos(usuario, importe, tipoHab);
                                recorrerArchHab(tipoHab);
                                actualizarArchReservas(reserva);
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Incluye: \n-Cama matrimonial y 2 camas individuales. \n-Room service. \n-Desayuno buffet. \n-Valet parking \n-Frigobar. \n-Wi-Fi . \n-TV-LED y video cable.");

                        tipoHab = "Habitacion Familiar";
                        cont = verificarDispo(tipoHab);
                        if (cont == 0){
                            System.out.println("No hay habitaciones disponibles de este tipo.");
                        }else {
                            System.out.println("Cuantos dias desea reservar?: ");
                            int cantDias = scanner.nextInt();
                            Double importe = (double) (cantDias * 5000);
                            System.out.println("Esta seguro de reservar este tipo de habitacion? Presione 's' para si, cualquier letra para no ");
                            SN = (char) scanner.nextInt();
                            if(SN == 's')
                            {
                                reserva.setearDatos(usuario, importe, tipoHab);
                                recorrerArchHab(tipoHab);
                                actualizarArchReservas(reserva);
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Incluye: \n-Cama matrimonial y 2 camas individuales. \n-Room service. \n-Desayuno buffet. \n-Valet parking \n-Frigobar. \n-Wi-Fi . \n-TV-LED y video cable. \n-Jacuzzi. \n-Aire acondicionado. \n-Caja de Seguridad digital ");

                        tipoHab = "Habitacion Premium";
                        cont = verificarDispo(tipoHab);
                        if (cont == 0){
                            System.out.println("No hay habitaciones disponibles de este tipo.");
                        }else {
                            System.out.println("Cuantos dias desea reservar?: ");
                            int cantDias = scanner.nextInt();
                            Double importe = (double) (cantDias * 10000);
                            System.out.println("Esta seguro de reservar este tipo de habitacion? Presione 's' para si, cualquier letra para no ");
                            SN = (char) scanner.nextInt();
                            if(SN == 's')
                            {
                                reserva.setearDatos(usuario, importe, tipoHab);
                                recorrerArchHab(tipoHab);
                                actualizarArchReservas(reserva);
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

                System.out.println();
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
                    }
                }
                i++;
                System.out.println();
            }
            String jsonActualizado = objectMapper.writeValueAsString(habitaciones);
            FileWriter fileWriter = new FileWriter("src/main/resources/Habitaciones.json");
            fileWriter.write(jsonActualizado);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void actualizarArchReservas(Reserva reserva) {
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
