package main;

import java.util.Scanner;

public class Clientemenu {
    Scanner scanner = new Scanner(System.in);
    int opcion;
    public void menuCliente() {
        do {
            System.out.println("\n--- Menú Cliente ---");
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                System.out.println("Saliendo del menú del administrador...");
                main.Menuprincipal.main(null);
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 3);
        scanner.close();
    }
}