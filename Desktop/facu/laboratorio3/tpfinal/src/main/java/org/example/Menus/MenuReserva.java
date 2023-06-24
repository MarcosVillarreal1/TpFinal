package org.example.Menus;

import org.example.Reserva;
import org.example.Usuario;

import java.util.Scanner;

public class MenuReserva {

    public MenuReserva() {
    }

    public static void menuReserva(Usuario usuario) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        Reserva reserva = new Reserva(); // Instancia clase Reserva

        do {
            mostrarMenuReserva();
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    // Menú de hotelería
                    MenuHoteleria.menuHoteleria(reserva, usuario);
                    break;
                case 2:
                    // Menú de camping
                    MenuCamping.menuCamping(reserva, usuario);
                    break;
                case 3:
                    // Menú de spa
                    MenuSpa.menuSpa(reserva, usuario);
                    break;
                case 0:
                    System.out.println("Saliendo del menú de reserva...");
                    break;
                default:
                    System.out.println("La opción introducida es inválida.");
                    break;
            }

            System.out.println();
        } while (opcion != 0);

        scanner.close();
    }

    public static void mostrarMenuReserva() {
        System.out.println("***************************");
        System.out.println("       MENÚ DE RESERVA       ");
        System.out.println("***************************");
        System.out.println("1. Reserva hotelería");
        System.out.println("2. Reserva camping");
        System.out.println("3. Reserva spa");
        System.out.println();
        System.out.println("0. Salir del menú de reserva");
        System.out.println("***************************");
    }
}
