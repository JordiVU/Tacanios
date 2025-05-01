package Dam.Classes;
/*Clase hija de trabajador la cual aunque comparta un atributo con pintor no
 es hija de esta por los atributos que no se comparten entre estos atributos
estan su rango y los años de experiencia*/
public class Albanyil extends Trabajador
{
    protected String especializacion;
    protected String rango;
    protected int anyosExp;

    public Albanyil(int codTrabajador, String user, String password,
                    String nombre, String apellidos, String especializacion,
                    String rango, int anyosExp)

    {
        super(codTrabajador,user,password,nombre,apellidos);
        this.especializacion = especializacion;
        this.rango = rango;
        this.anyosExp = anyosExp;
    }

    public String getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public int getAnyosExp() {
        return anyosExp;
    }

    public void setAnyosExp(int anyosExp) {
        this.anyosExp = anyosExp;
    }

    @Override
    public String toString() {
        return "Albanyil{" +
                "especializacion='" + especializacion + '\'' +
                ", rango='" + rango + '\'' +
                ", anyosExp=" + anyosExp +
                '}';
    }
}
