package Dam.Classes;

import java.util.List;
import java.util.Scanner;

/*Clase hija de Trabajador la cual especifica los atributos de el pintor como
 son su especializacion o su tarifa*/
public class Pintor extends Trabajador
{
    protected String especializacion;
    protected int tarifa;

    public Pintor(int codTrabajador, String user, String password,
                  String nombre, String apellidos, String especializacion, int tarifa)
    {
        super(codTrabajador, user, password, nombre, apellidos);
        this.especializacion = especializacion;
        this.tarifa = tarifa;
    }

    public String getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }

    public int getTarifa() {
        return tarifa;
    }

    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
    }

    public static Pintor SeleccionarPintor(List<Trabajador> trabajadores)
    {
        Scanner sc = new Scanner(System.in);
        Trabajador seleccionado = null;

        for(Trabajador t : trabajadores) {
            if(t instanceof Pintor ) {
                System.out.println(t.toString());
            }
        }

        System.out.print("Código del trabajador a seleccionar: ");
        int codigo = sc.nextInt();

        for (Trabajador t : trabajadores) {
            if (t.getCodTrabajador() == codigo && (t instanceof Pintor )) {
                seleccionado = t;
            }
        }

        return (Pintor) seleccionado;
    }

    @Override
    public String toString() {
        return super.codTrabajador + ". " + super.user + " " + especializacion + " | Tarifa: " + tarifa;
    }
}
