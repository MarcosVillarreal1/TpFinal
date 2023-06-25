package org.example.Menus;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Camping.Cabaña;
import org.example.Interfaces.IArchivoReserva;
import org.example.Reserva;
import org.example.Usuario;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class MenuCamping implements IArchivoReserva {

    public void menuCamping(Reserva reserva, Usuario user) {

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        String tipoCamp;
        int cantDias;
        Double importe;
        //boolean habilitada;
        //LocalDate fechaInic;


        do {
            mostrarMenuCamping();
            try {
                String SN = "a";
                int cont;
                System.out.print("Ingrese una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("-Incluye: \n-Amplias parcelas. \n-Toma corriente 220 volts. \n-Área de sombra. \n-Fogón individual. \n-Alambrado olímpico perimetral. \n-Vigilancia permanente. \n-Sanitarios completos. \n-Agua caliente de 7 a 22 hs.");
                        System.out.println("Precio: $900 /noche");


                        tipoCamp = "Carpa";
                        System.out.println("Cuantas noches desea reservar?: ");
                        cantDias = scanner.nextInt();
                        importe = (double) (cantDias * 900);
                        System.out.println("El valor total es de $" + importe);

                        System.out.println("Esta seguro de reservar este tipo de habitacion? Presione 's' para si, cualquier letra para no ");
                        try {
                            SN = scanner.nextLine();
                            if(SN.equalsIgnoreCase("s")) {
                                reserva.setearDatos(user, cantDias, importe, tipoCamp);
                                actualizarArchReservas(reserva);
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Opcion invalida, use letras por favor");
                        }
                        break;
                    case 2:
                        System.out.println("Incluye: \n-1 cama matrimonial. \n-3 camas de 1 plaza. \n-Estacionamiento para un auto. \n-Heladera. \n-Mesa y sillas. \n-Parrilla individual. \n-Baño privado completo. \n-Anafe dos hornallas.");
                        System.out.println("Precio: $2000 /noche");

                        tipoCamp = "Cabaña";
                        cont = verificarDispoCab();
                        if (cont == 0) {
                            System.out.println("No hay cabañas disponibles.");
                        } else {
                            System.out.println("Cuantas noches desea reservar?: ");
                            cantDias = scanner.nextInt();
                            importe = (double) (cantDias * 2000);
                            System.out.println("El valor total es de $" + importe);

                            System.out.println("Esta seguro de reservar este tipo de habitacion? Presione 's' para si, cualquier letra para no ");
                            try {
                                SN = scanner.nextLine();
                                if(SN.equalsIgnoreCase("s")) {
                                    reserva.setearDatos(user, cantDias, importe, tipoCamp);
                                    recorrerArchCab();
                                    actualizarArchReservas(reserva);
                                }
                            } catch (InputMismatchException e) {
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
                }catch(NumberFormatException e)
                {
                    System.out.println("Dato ingresado incorrecto, por favor ingrese un numero.");
                }
        } while (!salir) ;
    }


    public void mostrarMenuCamping()
    {
        System.out.println("***************************");
        System.out.println("1. Carpa");
        System.out.println("2. Cabaña");
        System.out.println();
        System.out.println("0. Salir del menu Camping");
        System.out.println("***************************");
    }

    public static int verificarDispoCab()
    {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Lee el JSON desde un archivo
            Cabaña[] arrayCab = objectMapper.readValue(new File("src/main/resources/Cabañas.json"), Cabaña[].class);
            // Accede a los objetos Cabaña
            for (Cabaña cabaña : arrayCab) {
                if (cabaña.isEstado()) {
                    return 1;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

        public static void recorrerArchCab()
        {
            ObjectMapper objectMapper = new ObjectMapper();
            int i = 0;
            List<Cabaña> cabañas = new ArrayList<>();

            try {
                // Lee el JSON desde un archivo
                Cabaña[] arrayCab = objectMapper.readValue(new File("src/main/resources/Cabañas.json"), Cabaña[].class);
                cabañas.addAll(Arrays.asList(arrayCab));

                // Accede a los objetos Cabaña

                for (Cabaña cabaña : cabañas) {
                    if (cabaña.isEstado()) {
                        cabañas.get(i).cambioEstado();
                        break;
                    }
                    i++;
                }

                String jsonActualizado = objectMapper.writeValueAsString(cabañas);
                FileWriter fileWriter = new FileWriter("src/main/resources/Cabañas.json");
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
