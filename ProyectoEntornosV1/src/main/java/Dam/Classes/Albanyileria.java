package Dam.Classes;
/*Clase hija de trabajo la cual se declaran la cantidad trabajadores y el tiempo
 estimado de la obra.*/
public class Albanyileria extends Trabajo
{
    protected int cantTrabajadores;
    protected int tiempoEstimado;
    public Albanyileria(int codTrabajo, int metros2,
                        Presupuesto presupuestoAsignado, Administrador administrador,
                        Direccion direccionAsociada, Cliente clienteAsociado,
                        int cantTrabajadores, int tiempoEstimado)
    {
        super(codTrabajo,metros2,presupuestoAsignado,administrador
                ,direccionAsociada,clienteAsociado);
        this.cantTrabajadores = cantTrabajadores;
        this.tiempoEstimado = tiempoEstimado;
    }

    public int getCantTrabajadores() {
        return cantTrabajadores;
    }

    public void setCantTrabajadores(int cantTrabajadores) {
        this.cantTrabajadores = cantTrabajadores;
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
                "cantTrabajadores=" + cantTrabajadores +
                ", tiempoEstimado=" + tiempoEstimado +
                '}';
    }
}
