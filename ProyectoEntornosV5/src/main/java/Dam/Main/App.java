package Dam.Main;

import Dam.Classes.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.*;
import java.io.IOException;
public class App
{
    public enum MenuOpcion { SALIR, CREAR, MODIFICAR, ELIMINAR, CONSULTAR}
    public enum MenuCliente { SALIR, PERFIL, TRABAJO}
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    static Scanner sc= new Scanner(System.in);
    public static Cliente Login(List<Cliente> clientes)
    {
        String user, password;
        Cliente cliente = null;

        sc.nextLine();
        System.out.println("Bienvenido de nuevo, porfavor introduce" +
                "tus credenciales.");
        System.out.print("User: ");
        user = sc.nextLine();
        System.out.print("Password: ");
        password = sc.nextLine();

        for(int i=0;i<clientes.size();i++)
        {
            if(Objects.equals(clientes.get(i).getUser(), user) &&
                    Objects.equals(clientes.get(i).getPassword(), password))
            {
                cliente = clientes.get(i);
            }
        }
        return cliente;
    }
    public static Cliente SignUp(List<Cliente> clientes)
    {
        Cliente clienteActual = null;
        String nombre,apellidos,telefono,user,password;
        Date fechaNacimiento;
        Direccion direccion= null;

        System.out.println("Bienvenido, a continuacion te pediremos" +
                "tus datos para crear tu cuenta.");
        sc.nextLine();
        System.out.print("Introduce tu nombre: ");
        nombre=sc.nextLine();
        System.out.print("Introduce tu apellidos: ");
        apellidos=sc.nextLine();
        System.out.print("Introduce tu telefono: ");
        telefono=sc.nextLine();
        System.out.print("Introduce tu user: ");
        user=sc.nextLine();
        System.out.print("Introduce tu contraseña: ");
        password=sc.nextLine();
        System.out.print("Introduce tu calle: ");
        direccion = Direccion.CrearDireccion();
        fechaNacimiento=new Date(2000,4,5);

        clienteActual = new Cliente(nombre,apellidos,telefono,fechaNacimiento,direccion,user,password);
        clientes.add(clienteActual);

        return clienteActual;

    }
    public static Trabajador LoginTrabajadores(List<Trabajador> trabajadores)
    {
        boolean encontrado=false;
        String user, password;
        Trabajador trabajadorActual = null;

        sc.nextLine();
        System.out.println("Bienvenido de nuevo, dinos tus credenciales por favor.");
        System.out.print("User: ");
        user = sc.nextLine();
        System.out.print("Password: ");
        password = sc.nextLine();

        for(int i=0;i<trabajadores.size();i++)
        {
            if(Objects.equals(trabajadores.get(i).getUser(), user) &&
                    Objects.equals(trabajadores.get(i).getPassword(), password))
            {
                trabajadorActual = trabajadores.get(i);
            }
        }
        return trabajadorActual;
    }
    public static int MenuInicial()
    {
        int opcionSeleccionada;

        System.out.println("--INICIO--");
        System.out.println("1- Trabajador");
        System.out.println("2- Cliente");
        System.out.println("0- Salir ");
        System.out.print("¿Que eres?: ");

        opcionSeleccionada = sc.nextInt();

        if(opcionSeleccionada > 3 || opcionSeleccionada < 0)
            throw new Error("Opcion no valida");

        return opcionSeleccionada;
    }
    public static MenuOpcion MenuOpcionesTrabajador()
    {
        MenuOpcion opcionSeleccionada = null;
        boolean correcto = false;
        do {
            int numSeleccionado;

            System.out.println("--MENU TRABAJADOR--");
            System.out.println("1- Crear");
            System.out.println("2- Consultar");
            System.out.println("3- Modificar");
            System.out.println("4- Eliminar");
            System.out.println("0- SALIR.");
            System.out.print("Opcion: ");
            numSeleccionado = sc.nextInt();

            switch (numSeleccionado) {
                case 1:
                    opcionSeleccionada = MenuOpcion.CREAR;
                    correcto = true;
                    break;
                case 2:
                    opcionSeleccionada = MenuOpcion.CONSULTAR;
                    correcto = true;
                    break;
                case 3:
                    opcionSeleccionada = MenuOpcion.MODIFICAR;
                    correcto = true;
                    break;
                case 4:
                    opcionSeleccionada = MenuOpcion.ELIMINAR;
                    correcto = true;
                    break;
                case 0:
                    opcionSeleccionada = MenuOpcion.SALIR;
                    correcto = true;
                    break;
            }
        }
        while (!correcto);

        return opcionSeleccionada;
    }
    public static MenuOpcion MenuOpcionesAdministrador()
    {
        MenuOpcion opcionSeleccionada = null;
        boolean correcto = false;
        do {
            int numSeleccionado;

            System.out.println("--MENU ADMINISTRADOR--");
            System.out.println("1- Crear");
            System.out.println("2- Modificar");
            System.out.println("3- Eliminar");
            System.out.println("0- SALIR.");
            System.out.print("Opcion: ");
            numSeleccionado = sc.nextInt();

            switch (numSeleccionado) {
                case 1:
                    opcionSeleccionada = MenuOpcion.CREAR;
                    correcto = true;
                    break;
                case 2:
                    opcionSeleccionada = MenuOpcion.MODIFICAR;
                    correcto = true;
                    break;
                case 3:
                    opcionSeleccionada = MenuOpcion.ELIMINAR;
                    correcto = true;
                    break;
                case 0:
                    opcionSeleccionada = MenuOpcion.SALIR;
                    correcto = true;
                    break;
            }
        }
        while (!correcto);

        return opcionSeleccionada;
    }

    public static MenuCliente MenuOpcionesCliente()
    {
        MenuCliente opcionSeleccionada = null;
        boolean correcto = false;
        do {
            int numSeleccionado;

            System.out.println("--MENU--");
            System.out.println("1- Perfil");
            System.out.println("2- Trabajo");
            System.out.println("0- SALIR.");
            System.out.print("Opcion: ");
            numSeleccionado = sc.nextInt();

            switch (numSeleccionado) {
                case 1:
                    opcionSeleccionada = MenuCliente.PERFIL;
                    correcto = true;
                    break;
                case 2:
                    opcionSeleccionada = MenuCliente.TRABAJO;
                    correcto = true;
                    break;
                case 0:
                    opcionSeleccionada = MenuCliente.SALIR;
                    correcto = true;
                    break;
            }
        }
        while (!correcto);

        return opcionSeleccionada;
    }
    public static void MostrarClientes(List<Cliente> clientes)
    {
        for(int i = 0; i < clientes.size(); i++)
        {
            System.out.println(i + 1 + "- " + clientes.get(i));
        }
    }
    public static void MostrarPresupuestos(List<Trabajo> trabajos)
    {
        for(int i = 0; i < trabajos.size(); i++)
        {
            System.out.println(trabajos.get(i).getPresupuestoAsignado());
        }
    }
    public static void MostrarTrabajos(List<Trabajo> trabajos, Cliente cliente)
    {
        boolean hayTrabajo = false;
        for(int i = 0; i < trabajos.size(); i++)
        {
            if(trabajos.get(i) instanceof Albanyileria || trabajos.get(i) instanceof Alisado)
            {
                hayTrabajo = true;
                if(cliente == null) {
                    System.out.println(i + 1 + " " +trabajos.get(i));
                }
                else if(cliente.equals(trabajos.get(i).getClienteAsociado()))
                {
                    System.out.println(trabajos.get(i));
                }
                System.out.println("Albañiles:");
                for(int j = 0; j < ((Albanyileria)trabajos.get(i)).getAlbanyiles().size(); j++)
                {
                    if(cliente == null) {
                        System.out.println("- " + ((Albanyileria) trabajos.get(i)).getAlbanyiles().get(j).getNombre());
                    }
                    else if (cliente.equals(trabajos.get(i).getClienteAsociado())) {
                        System.out.println("- " + ((Albanyileria) trabajos.get(i)).getAlbanyiles().get(j).getNombre());
                    }
                }
            }
            else
            {
                if(cliente == null) {
                    hayTrabajo = true;
                    System.out.println(i + 1 + "- " + trabajos.get(i));
                }
                else if (cliente.equals(trabajos.get(i).getClienteAsociado()))
                {
                    hayTrabajo = true;
                    System.out.println(trabajos.get(i));
                }
            }
            System.out.println();
        }
        if(!hayTrabajo)
        {
            System.out.println("No existe ningun trabajo asociado.");
        }
    }
    public static void MostrarTrabajadores(List<Trabajador> trabajadores)
    {
        for(int i = 0; i < trabajadores.size(); i++)
        {
            if(trabajadores.get(i) instanceof Pintor)
            {
                System.out.print(ANSI_GREEN);
            }
            else if(trabajadores.get(i) instanceof Albanyil)
            {
                System.out.print(ANSI_YELLOW);
            }
            System.out.println(i + 1 + " -" + trabajadores.get(i) + ANSI_RESET);
        }
    }
    public static void opcionesConsultar(List<Trabajo> trabajos, List<Cliente> clientes,
                                         List<Trabajador> trabajadores)
    {
        int opcionConsulta;
        System.out.println("1- Clientes");
        System.out.println("2- Presupuestos");
        System.out.println("3- Trabajos");
        System.out.println("4- Trabajadores");
        System.out.println("5- ATRAS");
        System.out.print("Elegir: ");
        opcionConsulta = sc.nextInt();

        if(opcionConsulta == 1)
        {
            MostrarClientes(clientes);
        }
        else if(opcionConsulta == 2)
        {
            MostrarPresupuestos(trabajos);
        }
        else if (opcionConsulta == 3)
        {
            MostrarTrabajos(trabajos, null);
        }
        else if(opcionConsulta == 4)
        {
            MostrarTrabajadores(trabajadores);
        }
        else if(opcionConsulta == 5)
        {
            SeleccionarOpcionTrabajador(trabajos, clientes, trabajadores);
        }
    }
    public static void SeleccionarOpcionTrabajador(List<Trabajo> trabajos, List<Cliente> clientes,
                                                   List<Trabajador> trabajadores)
    {
        MenuOpcion opcionSeleccionada;

        do
        {
            opcionSeleccionada = MenuOpcionesTrabajador();
            switch (opcionSeleccionada)
            {
                case CREAR:
                    Trabajo.CrearTrabajo(clientes, trabajadores, trabajos);
                    break;
                case CONSULTAR:
                    opcionesConsultar(trabajos, clientes, trabajadores);
                    break;
                case MODIFICAR:
                    Trabajo.ModificarTrabajo(clientes, trabajadores, trabajos);
                    break;
                case ELIMINAR:
                    Trabajo.EliminarTrabajo(trabajos);
                    break;
            }
        }while(opcionSeleccionada != MenuOpcion.SALIR);
    }
    public static void SeleccionarOpcionAdmin(List<Cliente> clientes, List<Trabajador> trabajadores)
    {
        MenuOpcion opcionSeleccionada;
        do
        {
            opcionSeleccionada = MenuOpcionesAdministrador();
            switch (opcionSeleccionada)
            {
                case CREAR:
                    Administrador.Crear(trabajadores);
                    break;
                case MODIFICAR:
                    Administrador.Modificar(clientes, trabajadores);
                    break;
                case ELIMINAR:
                    Administrador.Eliminar(clientes, trabajadores);
                    break;
            }
        }while(opcionSeleccionada != MenuOpcion.SALIR);
    }
    public  static void SeleccionarOpcionCliente(List<Trabajo> trabajos, Cliente cliente)
    {
        MenuCliente opcionSeleccionada;
        do
        {
            opcionSeleccionada = MenuOpcionesCliente();
            switch (opcionSeleccionada)
            {
                case PERFIL:
                    System.out.println(cliente.toString());
                    break;

                case TRABAJO:
                    MostrarTrabajos(trabajos, cliente);
                    break;
            }
        }
        while(opcionSeleccionada != MenuCliente.SALIR);
    }
    public static void main( String[] args )
    {
        boolean correcto = true;
        List<Cliente> clientes= Cliente.cargarClientes();
        List<Trabajador>  trabajadores= Trabajador.cargarTrabajadores();
        List<Trabajo>  trabajos = new ArrayList<>();
        int opcionInicial,  opcionCuenta;
        Trabajador trabajadorActual;
        Cliente clienteActual;

        opcionInicial = MenuInicial();
        if (opcionInicial == 1) {
            do {
                correcto = true;
                try {
                    trabajadorActual = LoginTrabajadores(trabajadores);

                    if (trabajadorActual != null) {
                        if (trabajadorActual instanceof Administrador) {
                            SeleccionarOpcionAdmin(clientes, trabajadores);
                        } else {
                            SeleccionarOpcionTrabajador(trabajos, clientes, trabajadores);
                        }
                    } else {
                        throw new Exception("ERROR: Trabajador no encontrado");
                    }
                }
                catch (Exception e)
                {
                    System.out.println(e);
                    correcto = false;
                }
            }while (!correcto);
        } else if (opcionInicial == 2) {
            do {
                correcto = true;
                try {
                    System.out.println("1- Login ");
                    System.out.println("2- Sign Up");
                    System.out.print("Selecciona login o sign up: ");

                    opcionCuenta = sc.nextInt();

                    if (opcionCuenta == 1) {
                        clienteActual = Login(clientes);

                        if (clienteActual != null) {
                            SeleccionarOpcionCliente(trabajos, clienteActual);
                        } else {
                            throw new Exception("ERROR: Usuario no encontrado.");
                        }
                    } else {
                        clienteActual = SignUp(clientes);
                        SeleccionarOpcionCliente(trabajos, clienteActual);
                    }
                }
                catch (Exception e)
                {
                    System.out.println(e);
                    correcto = false;
                }
            }while (!correcto);
        }
    }
}
