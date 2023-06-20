package org.example.Menus;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Reserva;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MenuSpa {

    public MenuSpa() {
    }

    public static void menuSpa(Reserva reserva)
    {

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        String tipoHab;
        //boolean habilitada;
        LocalDate fechaInic;

        System.out.println("1. Dia");
        System.out.println("2. Estadia");
        System.out.println("3. Premium");



        do {
            try {
                char SN = 'a';
                System.out.print("Ingrese una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("informacion de la opcion dia");

                        tipoHab = "Dia";
                        System.out.println("Esta seguro de reservar esta opcion del spa? Presione 's' para si, cualquier letra para no ");
                        SN = (char) scanner.nextInt();
                        if(SN == 's')
                        {
                            System.out.println("introduzca la fecha inicial de su reserva"); //-> dentro del metodo busqueda
                            System.out.println("introduzca la fecha final de su reserva"); //-> dentro del metodo busqueda
                            // metodo de buscar la reservas con el mismo producto en una lista de reservas sacadas del archivo
                            // comparo fechas iniciales y finales y retorno un booleano viendo si esa fecha esta habil o no
                            //if(habilitada)
                            //reserva.metodo de setearDatosReserva
                            //actualizarArchReservas(reserva);
                            //else
                            //sout-> no hay habitaciones estandar habilitadas
                        }

                        break;
                    case 2:
                        System.out.println("informacion de la opcion estadia");

                        tipoHab = "Estadia";
                        System.out.println("Esta seguro de reservar esta opcion del spa? Presione 's' para si, cualquier letra para no ");
                        SN = (char) scanner.nextInt();
                        if(SN == 's')
                        {
                            System.out.println("introduzca la fecha inicial de su reserva"); //-> dentro del metodo busqueda
                            System.out.println("introduzca la fecha final de su reserva"); //-> dentro del metodo busqueda
                            // metodo de buscar la reservas con el mismo producto en una lista de reservas sacadas del archivo
                            // comparo fechas iniciales y finales y retorno un booleano viendo si esa fecha esta habil o no
                            //if(habilitada)
                            //reserva.metodo de setearDatosReserva
                            //actualizarArchReservas(reserva);
                            //else
                            //sout-> no hay habitaciones estandar habilitadas
                        }
                        break;
                    case 3:
                        System.out.println("informacion de la opcion premium");

                        tipoHab = "Premium";
                        System.out.println("Esta seguro de reservar esta opcion del spa? Presione 's' para si, cualquier letra para no ");
                        SN = (char) scanner.nextInt();
                        if(SN == 's')
                        {
                            System.out.println("introduzca la fecha inicial de su reserva"); //-> dentro del metodo busqueda
                            System.out.println("introduzca la fecha final de su reserva"); //-> dentro del metodo busqueda

                            //if(habilitada)
                            //reserva.metodo de setearDatosReserva
                            //actualizarArchReservas(reserva);
                            //else
                            //sout-> no hay habitaciones estandar habilitadas
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
