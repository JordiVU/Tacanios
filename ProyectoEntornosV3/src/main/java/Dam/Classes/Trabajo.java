package Dam.Classes;

import java.util.List;
import java.util.Scanner;

/*Clase padre Trabajo en la cual se declararan los atributos principales a los
 tipos de trabajos como son pintura, albañileria y alisado*/
abstract class Trabajo
{
    protected int codTrabajo;
    protected int metros2;
    protected Presupuesto presupuestoAsignado;
    protected Direccion direccionAsociada;
    protected Cliente clienteAsociado;

    public Trabajo(int codTrabajo, int metros2,
                   Presupuesto presupuestoAsignado,
                   Direccion direccionAsociada, Cliente clienteAsociado)
    {
        this.codTrabajo = codTrabajo;
        this.metros2 = metros2;
        this.presupuestoAsignado = presupuestoAsignado;
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

    public static void CrearTrabajo(List<Cliente> clientes, List<Trabajador> trabajadores, List<Trabajo> trabajos)
    {
        Scanner sc = new Scanner(System.in);

        int codTrabajo, m2, tipo, tiempoEstimado;
        String tipoPintura, color, estanciasPintar, materialesUsados;
        Presupuesto presupuestoAsignado;
        Direccion direccionAsociada;
        Cliente clienteAsociado;
        Pintor pintor = null;
        Albanyil albanyil = null;
        List<Albanyil> albanyiles;
        Trabajo trabajo = null;

        System.out.print("1. Pintura/ 2. Albañileria/ 3. Alisado");
        tipo = sc.nextInt();
        System.out.print("Ingrese el codigo del trabajo: ");
        codTrabajo = sc.nextInt();
        System.out.print("Ingrese los m2: ");
        m2 = sc.nextInt();
        direccionAsociada = Direccion.CrearDireccion();
        clienteAsociado = Cliente.SelecionarCliente(clientes);
        presupuestoAsignado = Presupuesto.CrearPresupuesto(clienteAsociado);

        switch(tipo){
            case 1:
                pintor = Pintor.SeleccionarPintor(trabajadores);
                System.out.print("Tipo de pintura: ");
                tipoPintura = sc.nextLine();
                System.out.print("Color: ");
                color = sc.nextLine();
                System.out.print("Estancias: ");
                estanciasPintar = sc.nextLine();

                trabajo = new Pintura(codTrabajo, m2, presupuestoAsignado, direccionAsociada, clienteAsociado,
                        pintor, tipoPintura, color, estanciasPintar);
                break;
            case 2:
                albanyiles = Albanyil.SeleccionarAlbanyiles(trabajadores);
                System.out.print("Tiempo estimado: ");
                tiempoEstimado = sc.nextInt();

                trabajo = new Albanyileria(codTrabajo, m2, presupuestoAsignado, direccionAsociada, clienteAsociado,
                        albanyiles, tiempoEstimado);
                break;
            case 3:
                pintor = Pintor.SeleccionarPintor(trabajadores);
                albanyiles = Albanyil.SeleccionarAlbanyiles(trabajadores);
                System.out.print("Materiales usados: ");
                materialesUsados = sc.nextLine();

                trabajo = new Alisado(codTrabajo, m2, presupuestoAsignado, direccionAsociada, clienteAsociado,
                        pintor, albanyiles, materialesUsados);
                break;
        }

        trabajos.add(trabajo);
    }
    @Override
    public String toString() {
        return "codTrabajo=" + codTrabajo +
                ", metros2=" + metros2 +
                ", presupuestoAsignado=" + presupuestoAsignado +
                ", direccionAsociada=" + direccionAsociada +
                ", clienteAsociado=" + clienteAsociado;
    }
}
