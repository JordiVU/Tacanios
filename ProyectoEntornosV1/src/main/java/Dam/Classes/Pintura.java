package Dam.Classes;
/*Clase hija de trabajo la cual especifica al tipo Pintura en esta hay
 atributos como son el tipo de pintura o el color de esta.*/
public class Pintura extends Trabajo
{
    protected Pintor pintor;
    protected String tipoPintura;
    protected String color;
    protected String estanciasAPintar;
    public Pintura(int codTrabajo, int metros2,
                   Presupuesto presupuestoAsignado, Administrador administrador,
                   Direccion direccionAsociada, Cliente clienteAsociado,
                   Pintor pintor,String tipoPintura, String color, String estanciasAPintar)

    {
        super(codTrabajo,metros2,presupuestoAsignado,administrador,
                direccionAsociada,clienteAsociado);
        this.pintor=pintor;
        this.tipoPintura = tipoPintura;
        this.color = color;
        this.estanciasAPintar = estanciasAPintar;
    }

    public Pintor getPintor() {
        return pintor;
    }

    public void setPintor(Pintor pintor) {
        this.pintor = pintor;
    }

    public String getTipoPintura() {
        return tipoPintura;
    }

    public void setTipoPintura(String tipoPintura) {
        this.tipoPintura = tipoPintura;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEstanciasAPintar() {
        return estanciasAPintar;
    }

    public void setEstanciasAPintar(String estanciasAPintar) {
        this.estanciasAPintar = estanciasAPintar;
    }

    @Override
    public String toString() {
        return "Pintura{" +
                "pintor=" + pintor +
                ", tipoPintura='" + tipoPintura + '\'' +
                ", color='" + color + '\'' +
                ", estanciasAPintar='" + estanciasAPintar + '\'' +
                '}';
    }
}
