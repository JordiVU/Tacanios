package Dam.Main;

import Dam.Classes.Cliente;
import Dam.Classes.Direccion;
import Dam.Classes.Presupuesto;
import Dam.Classes.Trabajador;

import java.sql.Date;
import java.sql.Time;
import java.util.*;
public class App
{

    static Scanner sc= new Scanner(System.in);
    public static Cliente Login(List<Cliente> clientes)
    {
        String user, password;
        Cliente cliente = null;

        System.out.println("Bienvenido de nuevo, porfavor introduce" +
                "tus credenciales:");
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

        System.out.println("Bienvenido a continuacion te pediremos" +
                "tus datos para crear tu cuenta:");
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
    public static int MenuOpcionesClientes()
    {
        int opcionSeleccionada;
        System.out.println("Que quieres hacer: ");
        System.out.println("1- Crear");
        System.out.println("2- Mostrar");
        System.out.println("4- Modificar");
        System.out.println("5- Eliminar");
        System.out.println("6- SALIR.");
        opcionSeleccionada=sc.nextInt();
        return opcionSeleccionada;
    }
    public static Trabajador LoginTrabajadores(List<Trabajador> trabajadores)
    {
        boolean encontrado=false;
        String user, password;
        Trabajador trabajadorActual = null;

        System.out.println("Bienvenido de nuevo, dinos tus credenciales por favor:");
        System.out.println("User: ");
        user = sc.nextLine();
        System.out.println("Password: ");
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
    public static int MenuOpcionesTrabajadoresNormal()
    {
        int opcionSeleccionada=0;
        System.out.println("Que quieres hacer: ");
        System.out.println("1- ");
        System.out.println("2- ");
        System.out.println("3- ");
        System.out.println("4- ");
        System.out.println("5- ");
        System.out.println("6- SALIR.");

        return opcionSeleccionada;
    }
    public static int MenuOpciones()
    {
        int opcionSeleccionada;

        System.out.println("Que eres?: ");
        System.out.println("1- Trabajador ");
        System.out.println("2- Cliente ");
        System.out.println("0- Salir ");

        opcionSeleccionada = sc.nextInt();

        if(opcionSeleccionada > 3 || opcionSeleccionada < 0)
            throw new Error("Opcion no valida");

        return opcionSeleccionada;
    }
    public static void SeleccionarOpcionTrabajador(Trabajador trabajadorActual)
    {
        boolean salir = false;
        int opcionSeleccionada;
        opcionSeleccionada = MenuOpcionesClientes();

        do {
            switch (opcionSeleccionada) {
                case 1:
                    System.out.println("Has seleccionado crear un " +
                            "presupuesto");
                    Presupuesto.CrearPresupuesto();
                    break;
                case 2:
                    System.out.println("Has seleccionado mostrar " +
                            "todos tus presupuestos actuales");
                    //Codigo
                    break;
                case 3:
                    System.out.println("Has seleccionado ver tus" +
                            "trabajos acualtes");
                    //Codigo
                    break;
                case 4:
                    System.out.println("Has seleccionado modificar" +
                            "algún presupuesto.");
                    //Codigo
                    break;
                default:
                    salir = true;
                    System.out.println("Adios!!!");
                    break;
            }
        }while(!salir);
    }

    public static void main( String[] args )
    {
        List<Cliente> clientes= new ArrayList<>();
        List<Trabajador>  trabajadores= new ArrayList<>();
        int opcionInicial, opcionCuenta;;
        Trabajador trabajadorActual;
        Cliente clienteActual;


        do
        {
                opcionInicial = MenuOpciones();
            if (opcionInicial == 1) {
                    trabajadorActual = LoginTrabajadores(trabajadores);

                    if(trabajadorActual == null)
                        System.out.println("ERROR: Trabajador no encontrado");

                    SeleccionarOpcionTrabajador(trabajadorActual);
            } else if (opcionInicial == 2) {
                    System.out.println("Selecciona login o sign up:");
                    System.out.println("1- Login ");
                    System.out.println("2- Sign Up");

                    opcionCuenta = sc.nextInt();

                    if (opcionCuenta == 1) {
                        clienteActual = Login(clientes);

                        if (clienteActual == null) {
                            throw new Error("ERROR: Usuario no encontrado.");
                        }
                    } else{
                            clienteActual = SignUp(clientes);
                    }
                }
        }while(opcionInicial != 3);
    }
}
