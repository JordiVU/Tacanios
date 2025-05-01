package Dam.Classes;

import Dam.Main.App;
import Dam.Classes.*;

import java.sql.Date;
import java.sql.Time;
import java.util.*;

/*Clase hija de Trabajador en esta se especifican los datos de cada administrador
 como su rango o su email de contacto*/
public class Administrador extends Trabajador
{
    protected String emailContacto;

    public Administrador(int codTrabajador, String user, String password,
                         String nombre, String apellidos, String emailContacto)
    {
        super(codTrabajador,user,password,
                nombre,apellidos);
        this.emailContacto = emailContacto;
    }

    public String getEmailContacto() {
        return emailContacto;
    }

    public void setEmailContacto(String emailContacto) {
        this.emailContacto = emailContacto;
    }

    /**
     * Metodo el cual servira para crear un nuevo trabajador en primer lugar
     * se le pedira que elija que tipo de trabajador quiere crear, tras esto
     * se le solicitaran los datos necesarios para crear al dicho trabajador y
     * por último mediante la lista de trabajadores que se pasara por parametro
     * se guardara el nuevo trabajador en dicha lista.
     * @param trabajadores
     */
    public static void Crear(List<Trabajador> trabajadores)
    {
        Scanner sc = new Scanner(System.in);

        Trabajador nuevo = null;
        String user, password, nombre, apellidos, especializacion, rango, email;
        int codTrabajador, tipo, tarifa, anyosExp;

        System.out.println("1. Pintor");
        System.out.println("2.Albanyil");
        System.out.println("3.Administrador");
        System.out.print("Opcion: ");
        tipo = sc.nextInt();

        System.out.print("Codigo de trabajador: ");
        codTrabajador = sc.nextInt();
        System.out.print("Nombre: ");
        nombre = sc.next();
        System.out.print("Apellidos: ");
        apellidos = sc.next();
        System.out.print("Password: ");
        password = sc.next();
        System.out.print("Username: ");
        user = sc.next();

        if(tipo == 1 || tipo == 2)
        {
            sc.nextLine();
            System.out.print("Especializacion: ");
            especializacion = sc.nextLine();
            if(tipo == 1)
            {
                System.out.print("Tarifa: ");
                tarifa = sc.nextInt();

                nuevo = new Pintor(codTrabajador, user, password, nombre, apellidos, especializacion, tarifa);
            }
            else
            {
                System.out.print("Rango: ");
                rango = sc.nextLine();
                System.out.print("Años experiencia: ");
                anyosExp = sc.nextInt();

                nuevo = new Albanyil(codTrabajador, user, password, nombre, apellidos, especializacion, rango, anyosExp);
            }
        }
        else if(tipo == 3)
        {
            System.out.print("Email de contacto: ");
            email = sc.nextLine();

            nuevo = new Administrador(codTrabajador, user, password, nombre, apellidos, email);
        }

        trabajadores.add(nuevo);
    }

    /**
     * Metodo el cual servira para modifcar un cliente o un trabajador, lo
     * primero sera preguntarle al administrador que quiere modificar y luego
     * se le mostraran las opciones que puede modificar, para la modificacion
     * se pasaran como parametro la lista de clientes y la de trabajadores.
     * @param clientes
     * @param trabajadores
     */
    public static void Modificar(List<Cliente> clientes,List<Trabajador> trabajadores)
    {
        Scanner sc= new Scanner(System.in);
        int modificar;
        System.out.println("Que quieres modificar:");
        System.out.println("1.- Cliente");
        System.out.println("2.- Trabajador");
        modificar=sc.nextInt();
        if(modificar==1) {
            int clienteElegido, opcionSeleccionada;
            System.out.println("Que quieres cambiar del usuario:");
            App.MostrarClientes(clientes);
            clienteElegido = sc.nextInt();
            clientes.get(clienteElegido - 1);
            System.out.println("Que quieres cambiar de " + clientes.get(clienteElegido - 1).getNombre());
            System.out.println("1.- Nombre");
            System.out.println("2.- Telefono");
            System.out.println("3.- User");
            System.out.println("4.- Password");
            opcionSeleccionada = sc.nextInt();
            switch (opcionSeleccionada) {
                case 1:
                    String cambioNombre;
                    System.out.println("Introduce el nombre nuevo: ");
                    cambioNombre = sc.nextLine();
                    clientes.get(clienteElegido - 1).setNombre(cambioNombre);
                    break;
                case 2:
                    String cambioTelefono;
                    System.out.println("Introduce el telefono nuevo: ");
                    cambioTelefono = sc.nextLine();
                    clientes.get(clienteElegido - 1).setTelefono(cambioTelefono);
                    break;
                case 3:
                    String cambioUser;
                    System.out.println("Introduce el user nuevo: ");
                    cambioUser = sc.nextLine();
                    clientes.get(clienteElegido - 1).setUser(cambioUser);
                    break;
                default:
                    String cambioPassword;
                    System.out.println("Introduce la password nuevo: ");
                    cambioPassword = sc.nextLine();
                    clientes.get(clienteElegido - 1).setPassword(cambioPassword);
                    break;
            }
        }
        else {
            int trabajadorElegido, opcionSeleccionada;
            System.out.println("Que quieres cambiar del usuario:");
            App.MostrarTrabajadores(trabajadores);
            trabajadorElegido = sc.nextInt();
            trabajadores.get(trabajadorElegido - 1);
            System.out.println("Que quieres cambiar de " + trabajadores.get(trabajadorElegido).getNombre());
            System.out.println("1.- Nombre");
            System.out.println("2.- Apellidos");
            System.out.println("3.- User");
            System.out.println("4.- Password");
            opcionSeleccionada = sc.nextInt();
            sc.nextLine();
            switch (opcionSeleccionada) {
                case 1:
                    String cambioNombre;
                    System.out.println("Introduce el nombre nuevo: ");
                    cambioNombre = sc.nextLine();
                    trabajadores.get(trabajadorElegido - 1).setNombre(cambioNombre);
                    break;
                case 2:
                    String cambioApellido;
                    System.out.println("Introduce el apellido nuevo: ");
                    cambioApellido = sc.nextLine();
                    trabajadores.get(trabajadorElegido - 1).setApellidos(cambioApellido);
                    break;
                case 3:
                    String cambioUser;
                    System.out.println("Introduce el user nuevo: ");
                    cambioUser = sc.nextLine();
                    trabajadores.get(trabajadorElegido - 1).setUser(cambioUser);
                    break;
                default:
                    String cambioPassword;
                    System.out.println("Introduce la password nuevo: ");
                    cambioPassword = sc.nextLine();
                    trabajadores.get(trabajadorElegido - 1).setPassword(cambioPassword);
                    break;
            }
        }
    }

    /**
     * Metodo eliminar el cual le permitira al administrador eliminar un cliente
     * o un trabajador para ello primero se le solicitara que elija si quiere
     * eliminar un cliente o un trabajador para luego elegir de cual eliminar.
     * para esto se pasaran como parametro la lista de clientes y la de
     * trabajadores.
     * @param clientes
     * @param trabajadores
     */
    public static void Eliminar(List<Cliente> clientes,List<Trabajador> trabajadores)
    {
        Scanner sc= new Scanner(System.in);
        int eliminar;
        System.out.println("Que quieres eliminar:");
        System.out.println("1.- Cliente");
        System.out.println("2.- Trabajador");
        eliminar=sc.nextInt();
        if(eliminar==1)
        {
            int clienteAEliminar;
            System.out.println("Que cliente quieres eliminar:");
            App.MostrarClientes(clientes);
            clienteAEliminar = sc.nextInt();
            clientes.remove(clienteAEliminar - 1);
            System.out.println("Se ha eliminado correctamente al cliente");
        }
        else
        {
            int trabajadorAEliminar;
            System.out.println("Que cliente quieres eliminar:");
            App.MostrarTrabajadores(trabajadores);
            trabajadorAEliminar = sc.nextInt();
            trabajadores.remove(trabajadorAEliminar - 1);
            System.out.println("Se ha eliminado correctamente al cliente");
        }
    }

    @Override
    public String toString() {
        return "Administrador{" + emailContacto;
    }
}
