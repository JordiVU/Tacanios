package Dam.Classes;
/*Clase hija de Trabajador la cual especifica los atributos de el pintor como
 son su especializacion o su tarifa*/
public class Pintor extends Trabajador
{
    protected String especializacion;
    protected int trabajosActuales;
    protected int tarifa;
    public Pintor(int codTrabajador, String user, String password,
                  String nombre, String apellidos, String especializacion,
                  int trabajosActuales, int tarifa)
    {
        super(codTrabajador, user, password, nombre, apellidos);
        this.especializacion = especializacion;
        this.trabajosActuales = trabajosActuales;
        this.tarifa = tarifa;
    }

    public String getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }

    public int getTrabajosActuales() {
        return trabajosActuales;
    }

    public void setTrabajosActuales(int trabajosActuales) {
        this.trabajosActuales = trabajosActuales;
    }

    public int getTarifa() {
        return tarifa;
    }

    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
    }

    @Override
    public String toString() {
        return "Pintor{" +
                "especializacion='" + especializacion + '\'' +
                ", trabajosActuales=" + trabajosActuales +
                ", tarifa=" + tarifa +
                '}';
    }
}
