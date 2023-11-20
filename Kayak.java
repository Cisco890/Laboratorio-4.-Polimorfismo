/** Juan Francisco Martínez 23617

  * Kayak
 
  * @param Data, usuario, premium,base,reserva,configuracion
  * @throws Es el main driver del programa

  */
import java.util.Scanner;

public class Kayak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {// primer menu del programa
            System.out.println("Menú Principal");
            System.out.println("1. Crear nuevo usuario");
            System.out.println("2. Iniciar Sesión");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            
            if (scanner.hasNextInt()) {
                int opcion = scanner.nextInt();
                scanner.nextLine();  
                switch (opcion) {
                    case 1://opcion para crear nuevo usuario
                        System.out.println("Opción 1: Crear nuevo usuario");
                        System.out.println("Opción 1: Crear nuevo usuario");
                    System.out.print("Ingrese nombre de usuario: ");
                    String nuevoUsername = scanner.next();
                    System.out.print("Ingrese contraseña: ");
                    String nuevaPassword = scanner.next();

                    // Asignar el tipo de plan según la opción
                    String nuevoPlan;
                    System.out.print("Seleccione tipo de plan (1: Premium / 2: Base): ");
                    int opcionTipoPlan = scanner.nextInt();
                    scanner.nextLine();  
                    if (opcionTipoPlan == 1) {
                        nuevoPlan = "Premium";
                    } else if (opcionTipoPlan == 2) {
                        nuevoPlan = "Base";
                    } else {
                        System.out.println("Opción no válida para tipo de plan. Se asignará Base por defecto.");
                        nuevoPlan = "Base";
                    }

                    // Llamar al método para registrar el usuario
                    Data.registrarUsuario(nuevoUsername, nuevaPassword, nuevoPlan);
                    break;
                 

                    case 2:
                    System.out.println("Opción 2: Inicio de sesión");// opcion para ingresar a la sesion 

                    // Verificación de usuario y contraseña
                    System.out.print("Ingrese nombre de usuario: ");
                    String inputUsername = scanner.next();
                    System.out.print("Ingrese contraseña: ");
                    String inputPassword = scanner.next();

                    // Verificar credenciales en la clase Data
                    Usuario usuarioAutenticado = Data.verificarCredenciales(inputUsername, inputPassword);

                    if (usuarioAutenticado != null) {
                        // Verificar el tipo de usuario
                        if ("Base".equals(usuarioAutenticado.getPlan())) {
                            System.out.println("Programa para usuarios base en desarrollo. Acceso denegado.");
                        } else {
                            // Usuario y contraseña válidos
                            System.out.println("¡Bienvenido, " + inputUsername + "!");
                        }

                        while (true) {
                            System.out.println("Sesión");//submenu para los usuarios premium 
                            System.out.println("1. Crear reserva");
                            System.out.println("2. Confirmar reserva");
                            System.out.println("3. Cambio de contraseña");
                            System.out.println("4. Salir de la sesión");
                            System.out.print("Seleccione una opción: ");
                        
                            // Verificar si hay un entero disponible
                            if (scanner.hasNextInt()) {
                                int opcionSesion = scanner.nextInt();
                                scanner.nextLine();

                            switch (opcionSesion) {
                                case 1:
                                    // Crear reserva
                                    System.out.println("Opción 2.1: Crear reserva");

                                    // Preguntas para la reserva
                                    System.out.print("Ingrese fecha de viaje (DD/MM/YYYY): ");
                                    String fechaViaje = scanner.next();
                                    scanner.nextLine();  
                                    
                                    System.out.print("Seleccione tipo de viaje (1: Viaje de ida / 2: Viaje de ida y vuelta): ");
                                    int opcionTipoViaje = scanner.nextInt();
                                    scanner.nextLine();  

                                    // Verificar la opción del tipo de viaje
                                    String tipoViaje;
                                    if (opcionTipoViaje == 1) {
                                        tipoViaje = "ida";
                                    } else if (opcionTipoViaje == 2) {
                                        tipoViaje = "ida y vuelta";
                                    } else {
                                        System.out.println("Opción no válida para tipo de viaje. Se asignará Viaje de ida por defecto.");
                                        tipoViaje = "ida y vuelta";
                                    }

                                   
                                    System.out.print("Ingrese cantidad de boletos: ");
                                    int cantidadBoletos = scanner.nextInt();
                                    scanner.nextLine(); 

                                    System.out.print("Ingrese aerolínea: ");
                                    String aerolinea = scanner.next();
                                    scanner.nextLine();  

                                    // Llamar al método para agregar la reserva
                                    Data.agregarReserva(fechaViaje, tipoViaje, cantidadBoletos, aerolinea, usuarioAutenticado);
                                    System.out.println("Usted ha realizado una reserva de " + cantidadBoletos + " boletos para un vuelo de " + tipoViaje +
                                            " en la fecha " + fechaViaje + " y volará en la aerolínea " + aerolinea + "\n");
                                    break;

                                case 2:
                                    // Confirmar reserva
                                    System.out.println("Opción 2.2: Confirmar reserva");

                                    // Llamar al método para realizar la confirmación
                                    Confirmacion confirmacion = Data.realizarConfirmacion(scanner);
                                    
                                    break;

                                case 3:

                                    // Preguntar por la nueva contraseña
                                    System.out.print("Cambio de contraseña: ");
                                    String nuevaContraseña = scanner.next();

                                    // Cambiar la contraseña del usuario y guardar en CSV
                                    usuarioAutenticado.setPassword(nuevaContraseña);
                                    Data.actualizarContraseña(usuarioAutenticado.getUsername(), nuevaContraseña);

                                    System.out.println("Contraseña cambiada exitosamente.");
                                    break;

                                case 4:
                                    System.out.println("Saliendo de la sesión. ¡Hasta luego!");//salir del submenu
                                    break;

                                default:
                                    System.out.println("Opción no válida");
                                    break;
                            }

                            if (opcionSesion == 4) {
                                break;  // Salir del bucle de sesión si el usuario elige salir
                            }
                        } }
                    } else {
                        // Usuario o contraseña incorrectos
                        System.out.println("Usuario o contraseña incorrectos. Acceso denegado.");
                    }
                    break;


                    case 3:
                        System.out.println("Saliendo del programa. ¡Hasta luego!");
                        return;  // Salir del método main y finalizar el programa

                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            } else {
                System.out.println("Entrada no válida. Se esperaba un número.");
                scanner.nextLine();  // Consumir la entrada no válida
            }
        }
    }
}
