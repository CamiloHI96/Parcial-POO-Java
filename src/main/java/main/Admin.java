package main;

import java.util.List;
import java.util.Scanner;

public class Admin {
    private Scanner scanner;
    private int opcion;
    private List<Vehiculo> flotaVehiculos;
    private List<Reserva> reservas; // Añadido lista de reservas
    private final String username = "admin";
    private final String password = "admin";

    // Constructor que recibe la lista de vehículos y reservas
    public Admin(List<Vehiculo> flotaVehiculos, List<Reserva> reservas) {
        this.scanner = new Scanner(System.in);
        this.flotaVehiculos = flotaVehiculos;
        this.reservas = reservas;
    }

    // Constructor que recibe la lista de vehículos
    public Admin(List<Vehiculo> flotaVehiculos) {
        this.scanner = new Scanner(System.in);
        this.flotaVehiculos = flotaVehiculos;
    }

    public void login() {
        System.out.println("\n--- Iniciar Sesión como Administrador ---");
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
        do {
            System.out.println("\n--- Menú Administrador ---");
            System.out.println("1. Ver reservas");
            System.out.println("2. Añadir vehículo");
            System.out.println("3. Ver vehículos disponibles");
            System.out.println("4. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, ingresa un número.");
                scanner.nextLine();
                continue;
            }

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    verReservas();
                    break;
                case 2:
                    añadirVehiculo();
                    break;
                case 3:
                    verVehiculosDisponibles();
                    break;
                case 4:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);
    }

    private void verReservas() {
        System.out.println("\n--- Reservas de Todos los Usuarios ---");
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas registradas.");
        } else {
            for (Reserva reserva : reservas) {
                System.out.println(reserva);
            }
        }
    }

    private void añadirVehiculo() {
        while (true) {
            System.out.println("\n--- Añadir Vehículo ---");
            System.out.println("Tipos de Vehículos:");
            System.out.println("1. Auto");
            System.out.println("2. Moto");
            System.out.println("3. Camión");
            System.out.println("4. Autobús");
            System.out.println("5. Volver al menú anterior");
            System.out.print("Seleccione el tipo de vehículo: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, ingresa un número.");
                scanner.nextLine();
                continue;
            }

            int tipo = scanner.nextInt();
            scanner.nextLine();

            if (tipo == 5) {
                System.out.println("\nVolviendo al Menú del Administrador...");
                break;
            }

            int idVehiculo;
            while (true) {
                System.out.print("Ingrese ID del Vehículo (numérico): ");
                String idInput = scanner.nextLine().trim();

                try {
                    idVehiculo = Integer.parseInt(idInput);
                    if (idVehiculo <= 0) {
                        System.out.println("El ID debe ser un número positivo.");
                        continue;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("ID inválido. Debe ser un número entero.");
                    continue;
                }

                boolean idEnUso = false;
                for (Vehiculo v : flotaVehiculos) {
                    if (v.getIdVehiculo() == idVehiculo) {
                        idEnUso = true;
                        break;
                    }
                }

                if (idEnUso) {
                    System.out.println("Este ID ya está en uso. Por favor, elige otro ID.");
                } else {
                    break;
                }
            }

            System.out.print("Ingrese Marca: ");
            String marca = scanner.nextLine().trim();

            System.out.print("Ingrese Modelo: ");
            String modelo = scanner.nextLine().trim();

            int año = 0;
            while (true) {
                System.out.print("Ingrese Año: ");
                String añoInput = scanner.nextLine().trim();
                try {
                    año = Integer.parseInt(añoInput);
                    if (año <= 0) {
                        System.out.println("El año debe ser un número positivo.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Año inválido. Debe ser un número entero.");
                }
            }

            double costoDiario = 0.0;
            while (true) {
                System.out.print("Ingrese Costo Diario: ");
                String costoInput = scanner.nextLine().trim();
                try {
                    costoDiario = Double.parseDouble(costoInput);
                    if (costoDiario < 0) {
                        System.out.println("El costo diario no puede ser negativo.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Costo diario inválido. Debe ser un número.");
                }
            }

            Vehiculo vehiculo = null;

            switch (tipo) {
                case 1:
                    System.out.print("Ingrese Tipo de Combustible (Gasolina/Diésel/Eléctrico): ");
                    String tipoCombustible = scanner.nextLine().trim();
                    vehiculo = new Auto(idVehiculo, marca, modelo, año, costoDiario, tipoCombustible);
                    break;
                case 2:
                    int cilindrada = 0;
                    while (true) {
                        System.out.print("Ingrese Cilindrada (cc): ");
                        String cilindradaInput = scanner.nextLine().trim();
                        try {
                            cilindrada = Integer.parseInt(cilindradaInput);
                            if (cilindrada <= 0) {
                                System.out.println("La cilindrada debe ser un número positivo.");
                                continue;
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Cilindrada inválida. Debe ser un número entero.");
                        }
                    }
                    vehiculo = new Moto(idVehiculo, marca, modelo, año, costoDiario, cilindrada);
                    break;
                case 3:
                    int capacidadCarga = 0;
                    while (true) {
                        System.out.print("Ingrese Capacidad de Carga (kg): ");
                        String cargaInput = scanner.nextLine().trim();
                        try {
                            capacidadCarga = Integer.parseInt(cargaInput);
                            if (capacidadCarga <= 0) {
                                System.out.println("La capacidad de carga debe ser un número positivo.");
                                continue;
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Capacidad de carga inválida. Debe ser un número entero.");
                        }
                    }
                    vehiculo = new Camion(idVehiculo, marca, modelo, año, costoDiario, capacidadCarga);
                    break;
                case 4:
                    int capacidadPasajeros = 0;
                    while (true) {
                        System.out.print("Ingrese Capacidad de Pasajeros: ");
                        String pasajerosInput = scanner.nextLine().trim();
                        try {
                            capacidadPasajeros = Integer.parseInt(pasajerosInput);
                            if (capacidadPasajeros <= 0) {
                                System.out.println("La capacidad de pasajeros debe ser un número positivo.");
                                continue;
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Capacidad de pasajeros inválida. Debe ser un número entero.");
                        }
                    }
                    vehiculo = new Autobus(idVehiculo, marca, modelo, año, costoDiario, capacidadPasajeros);
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    continue;
            }

            if (vehiculo != null) {
                flotaVehiculos.add(vehiculo);
                System.out.println("Vehículo añadido exitosamente: " + vehiculo);
            }
        }
    }

    private void verVehiculosDisponibles() {
        System.out.println("\n--- Vehículos Disponibles ---");
        boolean hayDisponibles = false;
        for (Vehiculo v : flotaVehiculos) {
            if (v.isDisponible()) {
                System.out.println(v);
                hayDisponibles = true;
            }
        }
        if (!hayDisponibles) {
            System.out.println("No hay vehículos disponibles en este momento.");
        }
    }
}