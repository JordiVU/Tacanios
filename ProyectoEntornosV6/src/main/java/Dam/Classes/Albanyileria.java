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
                        Presupuesto presupuestoAsignado,
                        Direccion direccionAsociada, Cliente clienteAsociado,List<Albanyil> albanyiles,
                        int tiempoEstimado)
    {
        super(codTrabajo,metros2,presupuestoAsignado
                ,direccionAsociada,clienteAsociado);
        this.albanyiles = albanyiles;
        this.tiempoEstimado = tiempoEstimado;
    }

    public int getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(int tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    public List<Albanyil> getAlbanyiles() {
        return albanyiles;
    }

    public void setAlbanyiles(List<Albanyil> albanyiles) {
        this.albanyiles = albanyiles;
    }

    @Override
    public String toString() {
        return super.toString() + " | " + tiempoEstimado + " tiempo estimado.";
    }
}
