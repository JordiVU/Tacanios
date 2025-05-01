package Dam.Classes;
/*Clase Presupuesto en la cual se declaran los atributos como el precio de la
 obra, las horas estimadas y el que lo ha hecho cliente que lo ha creado*/
public class Presupuesto
{
    protected int precioObra;
    protected int horasEstimadas;
    protected Cliente clienteAsoc;
    public Presupuesto(int precioObra, int horasEstimadas,
                       Cliente clienteAsoc)
    {
        this.precioObra = precioObra;
        this.horasEstimadas = horasEstimadas;
        this.clienteAsoc = clienteAsoc;
    }

    public int getPrecioObra() {
        return precioObra;
    }

    public void setPrecioObra(int precioObra) {
        this.precioObra = precioObra;
    }

    public int getHorasEstimadas() {
        return horasEstimadas;
    }

    public void setHorasEstimadas(int horasEstimadas) {
        this.horasEstimadas = horasEstimadas;
    }

    public Cliente getClienteAsoc() {
        return clienteAsoc;
    }

    public void setClienteAsoc(Cliente clienteAsoc) {
        this.clienteAsoc = clienteAsoc;
    }

    @Override
    public String toString() {
        return "Presupuesto{" +
                "precioObra=" + precioObra +
                ", horasEstimadas=" + horasEstimadas +
                ", clienteAsoc=" + clienteAsoc +
                '}';
    }
}
