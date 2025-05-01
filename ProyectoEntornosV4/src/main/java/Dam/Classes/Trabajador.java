package Dam.Classes;
/*Clase padre Trabajador la cual tendra varios hijos y tendra los atributos
 * que compartan todos los hijos.*/
public abstract class Trabajador
{
    protected int codTrabajador;
    protected String user;
    protected String password;
    protected String nombre;
    protected String apellidos;
    public Trabajador(int codTrabajador, String user, String password,
                      String nombre, String apellidos)
    {
        this.codTrabajador = codTrabajador;
        this.user = user;
        this.password = password;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public int getCodTrabajador() {
        return codTrabajador;
    }

    public void setCodTrabajador(int codTrabajador) {
        this.codTrabajador = codTrabajador;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "Trabajador{" +
                "codTrabajador=" + codTrabajador +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                '}';
    }
}
