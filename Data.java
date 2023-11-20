/** Juan Francisco Martínez 23617

  * Data
 
  * @param 
  * @throws Es la clase que se encarga de toda la logica del programa. 

  */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Data {
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static ArrayList<Reserva> reservas = new ArrayList<>();

    // Otros métodos de la clase Data, si es necesario

    static {
        // Llamada al método para cargar usuarios y reservas al inicio del programa
        cargarDatosDesdeCSV("usuarios.csv");
        cargarReservasDesdeCSV("reservas.csv");
    }

    // Método para registrar un nuevo usuario
    public static void registrarUsuario(String username, String password, String plan) {
        Usuario nuevoUsuario = new Usuario(username, password, plan);
        usuarios.add(nuevoUsuario);
        System.out.println("Usuario registrado con éxito");
        guardarDatosCSV("usuarios.csv");
    }

    // Método para verificar usuario y contraseña
    public static Usuario verificarCredenciales(String username, String password) {
        for (Usuario u : usuarios) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null; // Retorna null si las credenciales son incorrectas
    }

    // Método para obtener la lista de usuarios
    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    // Método para guardar los datos en un archivo CSV
    public static void guardarDatosCSV(String nombreArchivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo, false))) {
            // Escribir el encabezado
            writer.println("Tipo,Usuario,Contraseña");
    
            // Iterar sobre todos los usuarios
            for (Usuario usuario : usuarios) {
                String tipoPlan = usuario.getPlan();
                String username = usuario.getUsername();
                String password = usuario.getPassword();
                writer.println(tipoPlan + "," + username + "," + password);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Método para cargar usuarios y reservas desde archivos CSV
    private static void cargarDatosDesdeCSV(String nombreArchivo) {
        try (Scanner scanner = new Scanner(new File(nombreArchivo))) {
            // Saltar la primera línea (encabezado)
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
    
            // Leer las líneas del archivo y crear usuarios
            while (scanner.hasNextLine()) {
                String[] datos = scanner.nextLine().split(",");
                if (datos.length == 3) {
                    String tipoPlan = datos[0].trim(); // Eliminar espacios en blanco
                    String username = datos[1];
                    String password = datos[2];
                    Usuario usuario = new Usuario(username, password, tipoPlan);
                    usuarios.add(usuario);
                }
            }
        } catch (FileNotFoundException e) {
            
        }
    }

    // Método para cargar reservas desde un archivo CSV
    private static void cargarReservasDesdeCSV(String nombreArchivo) {
        try (Scanner scanner = new Scanner(new File(nombreArchivo))) {
            // Saltar la primera línea (encabezado)
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            // Leer las líneas del archivo y crear reservas
            while (scanner.hasNextLine()) {
                String[] datos = scanner.nextLine().split(",");
                if (datos.length == 5) {
                    String nombreUsuario = datos[0];
                    String fechaViaje = datos[1];
                    String tipoViaje = datos[2];
                    int cantidadBoletos = Integer.parseInt(datos[3]);
                    String aerolinea = datos[4];
                   
                    Usuario usuarioAsociado = buscarUsuarioPorNombre(nombreUsuario);

                    if (usuarioAsociado != null) {
                        Reserva reserva = new Reserva(usuarioAsociado, fechaViaje, tipoViaje, cantidadBoletos, aerolinea);
                        reservas.add(reserva);
                    }
                }
            }
        } catch (FileNotFoundException e) {
           
        }
    }

    // Método auxiliar para buscar un usuario por su nombre
    private static Usuario buscarUsuarioPorNombre(String nombreUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(nombreUsuario)) {
                return usuario;
            }
        }
        return null;
    }

    // Método para agregar reserva
    public static void agregarReserva(String fechaViaje, String tipoViaje, int cantidadBoletos, String aerolinea, Usuario usuario) {
        Reserva nuevaReserva = new Reserva(usuario, fechaViaje, tipoViaje, cantidadBoletos, aerolinea);
        reservas.add(nuevaReserva);
        guardarReservasCSV("reservas.csv");
    
        System.out.println("Reserva realizada con éxito");
        
    }

   
// Método para guardar las reservas en un archivo CSV
public static void guardarReservasCSV(String nombreArchivo) {
    try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
        // Escribir el encabezado
        writer.println("FechaViaje,TipoViaje,CantidadBoletos,Aerolinea,Usuario");

        // Iterar sobre todas las reservas
        for (Reserva reserva : reservas) {
            // Obtener los datos de la reserva
            String nombreUsuario = reserva.getUsuario().getUsername();  // Obtener el nombre del usuario
            String fechaViaje = reserva.getFechaViaje();
            String tipoViaje = reserva.getTipoViaje();
            int cantidadBoletos = reserva.getCantidadBoletos();
            String aerolinea = reserva.getAerolinea();

            // Escribir los datos en el archivo CSV
            writer.println(
                            nombreUsuario + "," +
                            fechaViaje + "," +
                            tipoViaje + "," +
                            cantidadBoletos + "," +
                            aerolinea
            );
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public static Confirmacion realizarConfirmacion(Scanner scanner) {
    System.out.print("Ingrese número de tarjeta: ");
    String numeroTarjeta = scanner.next();

    System.out.print("Ingrese cantidad de cuotas: ");
    int cuotas = scanner.nextInt();


   

    System.out.print("Seleccione asiento: ");
    String asiento = scanner.next();

    System.out.print("Cantidad de maletas: ");
    int cantidadMaletas = scanner.nextInt();

    System.out.print("Como es usuario premium viajará en primera clase " + "\n");
    String claseVuelo = ("Primera clase");
    scanner.nextLine(); // Consumir el carácter de nueva línea

    // Imprimir los valores ingresados
    System.out.println("Valores ingresados para la confirmación:");
    System.out.println("Número de tarjeta: " + numeroTarjeta+" Cantidad de cuotas: " + cuotas+" Clase de vuelo: Primera clase " +" Asiento seleccionado: " + asiento+" Cantidad de maletas: " + cantidadMaletas);


    // Crear y retornar un objeto Confirmacion
    return new Confirmacion(numeroTarjeta, cuotas, claseVuelo, null, asiento, cantidadMaletas);
}
public static void actualizarContraseña(String username, String nuevaContraseña) {
    for (Usuario usuario : usuarios) {
        if (usuario.getUsername().equals(username)) {
            // Actualizar la contraseña del usuario
            usuario.setPassword(nuevaContraseña);
            break; // Romper el bucle después de encontrar al usuario
        }
    }
    guardarDatosCSV("usuarios.csv");
}
}
