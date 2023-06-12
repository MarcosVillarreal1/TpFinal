package org.example.Menus;

import java.util.Scanner;

public class MenuComplejo {
        public static void menuComplejo()
        {
            Scanner scanner = new Scanner(System.in);
            int opcion;

            do {
                mostrarMenuComplejo();
                System.out.print("Ingrese una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch(opcion)
                {
                    case 1:
                        mostrarInformacion(opcion);
                        break;
                    case 2 :
                        //menu reserva
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
            }while(opcion != 0);
        }



        public static void mostrarMenuComplejo()
        {
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

        public static void mostrarInformacion(int opc)
        {
            Scanner scanner = new Scanner(System.in);

            while(opc != 0)
            {
                switch(opc)
                {
                    case 1:
                        System.out.println("Ingrese informacion sobre el complejo aquie"); //poner la informacion;
                        break;
                    case 3:
                        System.out.println("Ingrese informacion de como llegar aqui"); //poner la informacion;
                        break;
                    case 0:
                        break;
                }
                System.out.println("Precione 0 para ir para volver al menu");
                opc = scanner.nextInt();
            }
        }
}
