package Dam.Classes;
/*Clase hija de Trabajador en esta se especifican los datos de cada administrador
 como su rango o su email de contacto*/
public class Administrador extends Trabajador
{
    protected String rangoAdministrativo;
    protected int trabajosAsociados;
    protected String emailContacto;
    protected int trabajosSupervisados;
    public Administrador(int codTrabajador, String user, String password,
                         String nombre, String apellidos, String rangoAdministrativo,
                         int trabajosAsociados, String emailContacto,
                         int trabajosSupervisados)
    {
        super(codTrabajador,user,password,
                nombre,apellidos);
        this.rangoAdministrativo = rangoAdministrativo;
        this.trabajosAsociados = trabajosAsociados;
        this.emailContacto = emailContacto;
        this.trabajosSupervisados = trabajosSupervisados;
    }

    public String getRangoAdministrativo() {
        return rangoAdministrativo;
    }

    public void setRangoAdministrativo(String rangoAdministrativo) {
        this.rangoAdministrativo = rangoAdministrativo;
    }

    public int getTrabajosAsociados() {
        return trabajosAsociados;
    }

    public void setTrabajosAsociados(int trabajosAsociados) {
        this.trabajosAsociados = trabajosAsociados;
    }

    public String getEmailContacto() {
        return emailContacto;
    }

    public void setEmailContacto(String emailContacto) {
        this.emailContacto = emailContacto;
    }

    public int getTrabajosSupervisados() {
        return trabajosSupervisados;
    }

    public void setTrabajosSupervisados(int trabajosSupervisados) {
        this.trabajosSupervisados = trabajosSupervisados;
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "rangoAdministrativo='" + rangoAdministrativo + '\'' +
                ", trabajosAsociados=" + trabajosAsociados +
                ", emailContacto='" + emailContacto + '\'' +
                ", trabajosSupervisados=" + trabajosSupervisados +
                '}';
    }
}
