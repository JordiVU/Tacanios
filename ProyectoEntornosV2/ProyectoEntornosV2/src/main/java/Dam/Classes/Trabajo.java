package Dam.Classes;
/*Clase padre Trabajo en la cual se declararan los atributos principales a los
 tipos de trabajos como son pintura, albañileria y alisado*/
abstract class Trabajo
{
    protected int codTrabajo;
    protected int metros2;
    protected Presupuesto presupuestoAsignado;
    protected Administrador administrador;
    protected Direccion direccionAsociada;
    protected Cliente clienteAsociado;

    public Trabajo(int codTrabajo, int metros2,
                   Presupuesto presupuestoAsignado, Administrador administrador,
                   Direccion direccionAsociada, Cliente clienteAsociado)
    {
        this.codTrabajo = codTrabajo;
        this.metros2 = metros2;
        this.presupuestoAsignado = presupuestoAsignado;
        this.administrador = administrador;
        this.direccionAsociada = direccionAsociada;
        this.clienteAsociado = clienteAsociado;
    }
    public int getCodTrabajo() {
        return codTrabajo;
    }

    public void setCodTrabajo(int codTrabajo) {
        this.codTrabajo = codTrabajo;
    }

    public int getMetros2() {
        return metros2;
    }

    public void setMetros2(int metros2) {
        this.metros2 = metros2;
    }

    public Presupuesto getPresupuestoAsignado() {
        return presupuestoAsignado;
    }

    public void setPresupuestoAsignado(Presupuesto presupuestoAsignado) {
        this.presupuestoAsignado = presupuestoAsignado;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public Direccion getDireccionAsociada() {
        return direccionAsociada;
    }

    public void setDireccionAsociada(Direccion direccionAsociada) {
        this.direccionAsociada = direccionAsociada;
    }

    public Cliente getClienteAsociado() {
        return clienteAsociado;
    }

    public void setClienteAsociado(Cliente clienteAsociado) {
        this.clienteAsociado = clienteAsociado;
    }

    @Override
    public String toString() {
        return "Trabajo{" +
                "codTrabajo=" + codTrabajo +
                ", metros2=" + metros2 +
                ", presupuestoAsignado=" + presupuestoAsignado +
                ", administrador=" + administrador +
                ", direccionAsociada=" + direccionAsociada +
                ", clienteAsociado=" + clienteAsociado +
                '}';
    }
}
