package main;

import java.util.Scanner;

public class Admin {
    private final String username = "admin";
    private final String password = "admin";

    public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Iniciar sesión como Administrador");
        
        System.out.print("Usuario: ");
        String userInput = scanner.nextLine();
        System.out.print("Contraseña: ");
        String passwordInput = scanner.nextLine();

        if (userInput.equals(username) && passwordInput.equals(password)) {
            menuAdmin();
        } else {
            System.out.println("Credenciales incorrectas. Acceso denegado.");
        }
    }
    private void menuAdmin() {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Menú Administrador:");
            System.out.println("1. Ver reservas");
            System.out.println("2. Añadir vehículo");
            System.out.println("3. Ver vehículos disponibles");
            System.out.println("4. Volver Menu Principal");

            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Saliendo del menú del administrador...");
                    main.Menuprincipal.main(null);
                    return;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }
    }
}