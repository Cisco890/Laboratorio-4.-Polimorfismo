/** Juan Francisco Martínez 23617

  * Usuario
 
  * @param String username, String password, String plan
  * @throws Es la clase que se encarga de los Usuarios, extiende Premium y base

  */
public class Usuario implements Premium, Base {//extender a premium y base
    private String username;
    private String password;
    private String plan;
    private int asientos;
    private int maletas;

    // Constructor
    public Usuario(String username, String password, String plan) {
        this.username = username;
        this.password = password;
        this.plan = plan;
        
    }

    // Getters y setters 
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPlan() {
        return plan;
    }

    public int getAsientos() {
        return asientos;
    }

    public void setAsientos(int asientos) {
        this.asientos = asientos;
    }

    public int getMaletas() {
        return maletas;
    }

    public void setMaletas(int maletas) {
        this.maletas = maletas;
    }
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
}
