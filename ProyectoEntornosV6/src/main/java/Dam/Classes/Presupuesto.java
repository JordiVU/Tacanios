package Dam.Classes;

import java.util.Scanner;

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

    /**
     * Metodo el cual sirve para dos opciones diferentes las cuales son
     * el crear un presupuesto nuevo y o para modificar el presupuesto
     * del cliente asociado.
     * @param clienteAsoc
     * @return
     */
    public static Presupuesto CrearModificarPresupuesto(Cliente clienteAsoc)
    {
        Scanner sc = new Scanner(System.in);
        int precioObra, horasEstimadas;

        System.out.print("Ingrese el precio obra: ");
        precioObra = sc.nextInt();
        System.out.print("Ingrese el horas estimadas: ");
        horasEstimadas = sc.nextInt();

        return new Presupuesto(precioObra,horasEstimadas, clienteAsoc);
    }

    @Override
    public String toString() {
        return clienteAsoc.getUser() + " | " + precioObra + "€ | " + horasEstimadas + "h | ";
    }
}
