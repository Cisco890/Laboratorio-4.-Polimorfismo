/** Juan Francisco Martínez 23617

  * Conrifmacion
 
  * @param String numeroTarjeta, int cuotas, String claseVuelo, String itinerario, String asiento, int cantidadMaletas
* @throws Se encarga de gestionar las confirmaciones

  */
public class Confirmacion {
    String numeroTarjeta;
    int cuotas;
    String claseVuelo;
    String itinerario;
    String asiento;
    int cantidadMaletas;
    
    // Constructor
    public Confirmacion(String numeroTarjeta, int cuotas, String claseVuelo, String itinerario, String asiento, int cantidadMaletas) {
        this.numeroTarjeta = numeroTarjeta;//cosntructor
        this.cuotas = cuotas;
        this.claseVuelo = claseVuelo;
        this.itinerario = itinerario;
        this.asiento = asiento;
        this.cantidadMaletas = cantidadMaletas;
    }
    //getters y setters
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public int getCuotas() {
        return cuotas;
    }

    public String getClaseVuelo() {
        return claseVuelo;
    }
    public String getAsiento() {
        return asiento;
    }
    
    public int getCantidadMaletas() {
        return cantidadMaletas;
    }
}
