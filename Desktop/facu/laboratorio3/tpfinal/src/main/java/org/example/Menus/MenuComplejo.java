package org.example.Menus;

import org.example.Reserva;
import org.example.Usuario;

import java.util.Scanner;

public class MenuComplejo {

    private MenuReserva menuReserva;

    public MenuComplejo() {
        this.menuReserva = new MenuReserva();
    }

    public static void menuComplejo(Usuario usuario) {

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenuComplejo();
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    mostrarInformacion(opcion);
                    break;
                case 2:
                    MenuReserva.menuReserva(usuario);
                    break;
                case 3:
                    mostrarInformacion(opcion);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("La opcion introducida es invalida.");
                    break;
            }
        } while (opcion != 0);
    }


    public static void mostrarMenuComplejo() {
        System.out.println("***************************");
        System.out.println("       BIENVENIDO A PARQUE HARAS DEL SUR       ");
        System.out.println("***************************");
        System.out.println("1. Informacion del complejo ");
        System.out.println("2. Reservas ");
        System.out.println("3. Como llegar ");
        System.out.println();
        System.out.println("0. Volver al menu de inicio");
        System.out.println("***************************");
    }

    public static void mostrarInformacion(int opc) {
        Scanner scanner = new Scanner(System.in);

        while (opc != 0) {
            switch (opc) {
                case 1:
                    System.out.println("*** Bienvenidos *** \nEn 2023 abrió sus puertas Complejo Haras del Sur, un espacio único de descanso y esparcimiento para toda la comunidad."); //poner la informacion;
                    System.out.println("\n");
                    break;
                case 3:
                    System.out.println("Dirección: Autovía 2 Km 69 - La Plata Mano a Mar del Plata \nTelefono: (0221) 492 3900 |  (0221) 15 306 5521 \nEmail: info@harasdelsur.com  \nHorario de Atención: Lunes a Domingos de 8 a 24 hs"); //poner la informacion;
                    System.out.println("\n");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Elija una opcion valida");
            }
            System.out.println("Precione 0 para ir para volver al menu");
            opc = scanner.nextInt();
        }
    }
}
