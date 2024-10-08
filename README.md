Sistema de Gestión de Reservas de Vehículos POO

1. Enunciado
Estás a cargo de desarrollar un sistema de gestión de reservas para una compañía de
alquiler de vehículos que tiene una flota diversa. El sistema debe permitir a los clientes
consultar y reservar vehículos, gestionar las reservas y calcular el costo total basado en
varios factores. Además, debe permitir al administrador de la flota añadir nuevos vehículos
y verificar su disponibilidad. Mucha suerte muchachos, demuestren lo que han aprendido :)

2. Requerimientos Funcionales

2.1. Clases Principales
Debes crear las siguientes clases base:
Vehiculo: Esta clase será la base para todos los vehículos en la flota.
Reserva: Representa una reserva de un vehículo por un cliente.
Cliente: Contendrá la información del cliente.
Administrador: Gestionará la flota y las reservas.

2.2. Características de la Clase Vehículo
Cada vehículo debe tener los siguientes atributos:
idVehiculo: Identificador único del vehículo.
marca: Marca del vehículo
modelo: Modelo del vehículo
año: Año del vehículo.
costoDiario: Costo de alquiler por día.
disponibilidad: Indica si el vehículo está disponible para alquilar o no.

2.3. Subclases de Vehículo
Debes crear subclases para diferentes tipos de vehículos con características adicionales:
Auto:
• tipoCombustible: Gasolina, Diésel o Eléctrico.
Moto:
• cilindrada: La cilindrada de la moto en cc.
Camioneta:
• capacidadCarga: Capacidad de carga en kilogramos.
Autobús:
• capacidadPasajeros: Número de pasajeros que puede transportar.

2.4. Clase Reserva
La clase Reserva debe tener los siguientes atributos:
idReserva: Identificador único de la reserva.
cliente: Instancia de la clase Cliente.
vehiculo: Instancia de la clase Vehiculo.
fechaInicio: Fecha de inicio del alquiler (utiliza la clase LocalDate de Java).
fechaFin: Fecha de finalización del alquiler.
costoTotal: Costo total de la reserva (calculado con el método calcularPrecio de la
clase Vehiculo).

2.5. Clase Cliente
Atributos:
idCliente: Identificador único del cliente.
nombre: Nombre del cliente.
reservas: Lista de instancias de la clase Reserva asociadas al cliente.
Método:
public void reservarVehiculo(Vehiculo vehiculo, LocalDate fechaInicio, LocalDate
fechaFin, boolean seguro, boolean gps): Crea una reserva para el cliente si el
vehículo está disponible y lo añade a la lista de reservas.

3.6. Clase Administrador
Métodos:
public void añadirVehiculo(Vehiculo vehiculo): Para agregar un nuevo vehícu-
lo a la flota.

public boolean verificarDisponibilidad(Vehiculo vehiculo, LocalDate fechaInicio,

LocalDate fechaFin): Para verificar si un vehículo está disponible en un rango de fe-
chas.
