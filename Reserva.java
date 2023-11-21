/** Juan Francisco Martínez 23617

  * Reserva
 
  * @param Usuario usuario,String fechaViaje, String tipoViaje, int cantidadBoletos, String aerolinea
* @throws Se encarga de gestionar las reservas

  */
public class Reserva {
    private String fechaViaje;
    private String tipoViaje;
    private int cantidadBoletos;
    private String aerolinea;
    private Usuario usuario;  

    public Reserva( Usuario usuario,String fechaViaje, String tipoViaje, int cantidadBoletos, String aerolinea) {//constructor
        this.fechaViaje = fechaViaje;
        this.tipoViaje = tipoViaje;
        this.cantidadBoletos = cantidadBoletos;
        this.aerolinea = aerolinea;
        this.usuario = usuario;  
    }

    
//getters y setters
    public String getFechaViaje() {
        return fechaViaje;
    }

    public String getTipoViaje() {
        return tipoViaje;
    }

    public int getCantidadBoletos() {
        return cantidadBoletos;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
