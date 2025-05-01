package Dam.Classes;

import java.util.ArrayList;
import java.util.List;

/*Clase hija de trabajo la cual se declaran la cantidad trabajadores y el tiempo
 estimado de la obra.*/
public class Albanyileria extends Trabajo
{
    protected List<Albanyil> albanyiles;
    protected int tiempoEstimado;

    public Albanyileria(int codTrabajo, int metros2,
                        Presupuesto presupuestoAsignado, Administrador administrador,
                        Direccion direccionAsociada, Cliente clienteAsociado,
                        int tiempoEstimado)
    {
        super(codTrabajo,metros2,presupuestoAsignado,administrador
                ,direccionAsociada,clienteAsociado);
        List<Albanyil> albanyiles = new ArrayList<Albanyil>();
        this.tiempoEstimado = tiempoEstimado;
    }

    public int getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(int tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    @Override
    public String toString() {
        return "Albanyileria{" +
                ", tiempoEstimado=" + tiempoEstimado +
                '}';
    }
}
