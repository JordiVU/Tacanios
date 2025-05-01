package Dam.Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public static List<Albanyil> SeleccionarAlbanyiles(List<Trabajador> trabajadores) {
        Scanner sc = new Scanner(System.in);
        List<Albanyil> albanyiles = new ArrayList<>();
        int seleccion;

        System.out.print("Cantidad de albañiles: ");
        int cantAlbanyiles = sc.nextInt();

        for(int i = 0; i < trabajadores.size(); i++) {
            System.out.println((i + 1) + ". " +trabajadores.get(i).toString());
        }

        for(int i = 0; i < cantAlbanyiles; i++){
            System.out.print((i + 1) + "º  albañil: ");
            seleccion = sc.nextInt();
            albanyiles.add(albanyiles.get((seleccion)));
        }
        for (int i = 0; i < albanyiles.size(); i++) {
            for (int j = i + 1; j < albanyiles.size(); j++) {
                if (albanyiles.get(i).getCodTrabajador() == (trabajadores.get(j).getCodTrabajador())) {
                    throw new Error("ERROR: Albañil repetido.");
                }
            }
        }

        return albanyiles;
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
