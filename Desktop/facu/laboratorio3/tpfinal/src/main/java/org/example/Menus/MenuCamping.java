package org.example.Menus;

import com.fasterxml.jackson.databind.ObjectMapper;
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

public class MenuCamping {

    private Reserva reserva;

    public MenuCamping() {
    }

<<<<<<< HEAD
    public static void menuCamping(Reserva reserva, Usuario usuario)
=======
    public static void menuCamping(Reserva reserva, Usuario user)
>>>>>>> 6fa3c5a60e2b575828126fd2d1cc4a7abc3ca0c8
    {

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        String tipoCamp;
        //boolean habilitada;
        LocalDate fechaInic;

        System.out.println("1. Carpa");
        System.out.println("2. Cabaña");

        do {
            try {
                char SN = 'a';
                System.out.print("Ingrese una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("-Incluye: \n-Amplias parcelas. \n-Toma corriente 220 volts. \n-Área de sombra. \n-Fogón individual. \n-Alambrado olímpico perimetral. \n-Vigilancia permanente. \n-Sanitarios completos. \n-Agua caliente de 7 a 22 hs.");

                        tipoCamp = "Carpa";
                        System.out.println("Esta seguro de reservar un espacio de camping? Presione 's' para si, cualquier letra para no ");
                        SN = (char) scanner.nextInt();
                        if(SN == 's')
                        {

                        }
                        break;
                    case 2:
                        System.out.println("Incluye: \n-1 cama matrimonial. \n-3 camas de 1 plaza. \n-Estacionamiento para un auto. \n-Heladera. \n-Mesa y sillas. \n-Parrilla individual. \n-Baño privado completo. \n-Anafe dos hornallas.");

                        tipoCamp = "Cabaña";
                        System.out.println("Esta seguro de reservar una cabaña? Presione 's' para si, cualquier letra para no ");
                        SN = (char) scanner.nextInt();
                        if(SN == 's')
                        {

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
