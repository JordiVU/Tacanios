package Dam.Classes;

import Dam.Main.App;

import java.util.List;
import java.util.Scanner;

/*Clase padre Trabajo en la cual se declararan los atributos principales a los
 tipos de trabajos como son pintura, albañileria y alisado*/
public abstract class Trabajo
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
        if(clientes.size() > 0) {
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

            System.out.println("1. Pintura");
            System.out.println("2. Albañileria");
            System.out.println("3. Alisado");
            System.out.println("4. ATRAS");
            tipo = sc.nextInt();
            System.out.print("Ingrese el codigo del trabajo: ");
            codTrabajo = sc.nextInt();
            System.out.print("Ingrese los m2: ");
            m2 = sc.nextInt();
            direccionAsociada = Direccion.CrearDireccion();
            clienteAsociado = Cliente.SelecionarCliente(clientes);
            presupuestoAsignado = Presupuesto.CrearModificarPresupuesto(clienteAsociado);

            switch (tipo) {
                case 1:
                    pintor = Pintor.SeleccionarPintor(trabajadores);
                    sc.nextLine();
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
        else
        {
            System.err.println("ERROR: No hay clientes.");
        }
    }

    public static void ModificarTrabajo(List<Cliente> clientes, List<Trabajador> trabajadores, List<Trabajo> trabajos)
    {
        if(trabajos.size() > 0) {
            Scanner sc = new Scanner(System.in);

            int m2, trabajoSeleccionado, opcionModificar;
            Presupuesto presupuestoAsignado;
            String confirmacion;

            App.MostrarTrabajos(trabajos, null);
            System.out.println("¿Que trabajo quieres modificar?:");
            trabajoSeleccionado = sc.nextInt() - 1;

            System.out.println("1- Cambiar los m2");
            System.out.println("2- Cambiar el presupuesto");
            System.out.println("3- ATRAS");
            opcionModificar = sc.nextInt();

            switch (opcionModificar) {
                case 1:
                    System.out.println("Nuevos m2:");
                    m2 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("¿Estas seguro que quieres cambiar los m2? (S/N):");
                    confirmacion = sc.nextLine();
                    if (confirmacion.equals("S")) {
                        trabajos.get(trabajoSeleccionado).setMetros2(m2);
                    }
                    break;

                case 2:
                    presupuestoAsignado = Presupuesto.CrearModificarPresupuesto(trabajos.get(trabajoSeleccionado).
                            getClienteAsociado());
                    sc.nextLine();
                    System.out.print("¿Estas seguro que quieres cambiar el presupuesto? (S/N):");
                    confirmacion = sc.nextLine();
                    if (confirmacion.equals("S")) {
                        trabajos.get(trabajoSeleccionado).setPresupuestoAsignado(presupuestoAsignado);
                    }
                    break;

                case 3:
                    break;
            }
        }
        else
        {
            System.err.println("ERROR: No hay trabajos.");
        }
    }

    public static void EliminarTrabajo(List<Trabajo> trabajo)
    {
        if(trabajo.size() > 0) {
            Scanner sc = new Scanner(System.in);
            int seleccionado;
            String confirmacion;

            App.MostrarTrabajos(trabajo, null);

            System.out.print("Trabajo a eliminar:");
            seleccionado = sc.nextInt();
            sc.nextLine();

            if (seleccionado < 1 || seleccionado > trabajo.size()) {
                throw new Error("ERROR: Seleccion fuera de rango");
            }

            System.out.print("¿Estas seguro que quieres eliminar el trabajo? (S/N):");
            confirmacion = sc.nextLine();
            if (confirmacion.equals("S")) {
                trabajo.remove(seleccionado - 1);
            }
        }
        else {
            System.err.println("ERROR: No hay trabajos.");
        }
    }

    @Override
    public String toString() {
        return codTrabajo + ". " + presupuestoAsignado.toString() + " - " + direccionAsociada + " - " + metros2 + "m2";
    }
}
