package Dam.Main;

import Dam.Classes.Cliente;
import Dam.Classes.Direccion;
import Dam.Classes.Trabajador;

import java.sql.Date;
import java.sql.Time;
import java.util.*;
public class App 
{

    static Scanner sc= new Scanner(System.in);
    public static boolean Login(List<Cliente> clientes, String user, String password)
    {
        boolean encontrado=false;
        for(int i=0;i<clientes.size();i++)
        {
            if(Objects.equals(clientes.get(i).getUser(), user) &&
                    Objects.equals(clientes.get(i).getPassword(), password))
            {
                encontrado=true;
            }
        }
        return encontrado;
    }
    public static void SignUp(List<Cliente> clientes)
    {
        String nombre,apellidos,telefono,user,password;
        Date fechaNacimiento;
        Direccion direccion= null;
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
        direccion.setCalle(sc.nextLine());
        System.out.print("Introduce tu numero: ");
        direccion.setNumero(sc.nextLine());
        System.out.print("Introduce tu código postal: ");
        direccion.setCodPostal(sc.nextLine());
        System.out.print("Introduce tu ciudad: ");
        direccion.setCiudad(sc.nextLine());
        fechaNacimiento=new Date(2000,4,5);
        clientes.add(new Cliente(nombre,apellidos,telefono,fechaNacimiento,direccion,user,password));
    }
    public static int MenuOpcionesClientes()
    {
        int opcionSeleccionada;
        System.out.println("Que quieres hacer: ");
        System.out.println("1- Crear un nuevo presupuesto.");
        System.out.println("2- Mostrar tus presupuestos actuales.");
        System.out.println("3- Mostrar tus trabajos acutales.");
        System.out.println("4- Modificar algún presupuesto.");
        System.out.println("5- Eliminar algún presupuesto.");
        System.out.println("6- SALIR.");
        opcionSeleccionada=sc.nextInt();
        return opcionSeleccionada;
    }
    public static boolean LoginTrabajadores(List<Trabajador> trabajadors,
                                            String user, String password)
    {
        boolean encontrado=false;
        for(int i=0;i<trabajadors.size();i++)
        {
            if(Objects.equals(trabajadors.get(i).getUser(), user) &&
                    Objects.equals(trabajadors.get(i).getPassword(), password))
            {
                encontrado=true;
            }
        }
        return encontrado;
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
    public static void main( String[] args )
    {
        List<Cliente> clientes= new ArrayList<>();
        List<Trabajador>  trabajadors= new ArrayList<>();
        int opcionInicial;
        System.out.println("Que eres?: ");
        System.out.println("1- Trabajador ");
        System.out.println("2- Cliente ");
        do
        {
            opcionInicial = sc.nextInt();
            String user, password;
            if (opcionInicial == 2)
            {
                int opcionCuenta;
                System.out.println("Selecciona login o sign up:");
                System.out.println("1- Login ");
                System.out.println("2- Sign Up");
                opcionCuenta=sc.nextInt();
                if(opcionCuenta==1)
                {
                    boolean encontrado;
                    System.out.println("Bienvenido de nuevo porfavor introduce" +
                            "tus credenciales:");
                    System.out.println("User: ");
                    user= sc.nextLine();
                    System.out.println("Password: ");
                    password=sc.nextLine();
                    encontrado=Login(clientes,user,password);
                    if(encontrado)
                    {
                        int opcionSeleccionada;
                        opcionSeleccionada=MenuOpcionesClientes();
                        switch (opcionSeleccionada)
                        {
                            case 1:
                                System.out.println("Has seleccionado crear un " +
                                        "presupuesto");
                                //Codigo
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
                            case 5:
                                System.out.println("Has seleccionado eliminar un" +
                                        "presupuesto");
                                //Codigo
                                break;
                            default:
                                System.out.println("Adios!!!");
                                break;
                        }

                    }
                    else
                    {
                        System.out.println("ERROR: Usuario no encontrado.");
                    }
                }
                else
                {
                    if(opcionCuenta==2)
                    {
                      System.out.println("Bienvenido a continuacion te pediremos" +
                              "tus datos para crear tu cuenta:");
                      SignUp(clientes);
                    }
                    else
                    {
                        System.out.println("ERROR: Indice fuera de los paranmetros.");
                    }
                }

            }
            else
            {
                if(opcionInicial==2)
                {
                    boolean encontrado;
                    System.out.println("Bienvenido de nuevo, dinos tus credenciales por favor:");
                    System.out.println("User: ");
                    user= sc.nextLine();
                    System.out.println("Password: ");
                    password=sc.nextLine();
                    encontrado= LoginTrabajadores(trabajadors,user,password);
                    if(encontrado)
                    {
                        MenuOpcionesTrabajadoresNormal();
                    }
                    else
                    {
                        System.out.println("ERROR: Usuario no encontrado.");
                    }
                }
                else
                {
                    System.out.println("ERROR: Numero fuera de los parametros.");
                }
            }
        }while(opcionInicial!=1&&opcionInicial!=2);
    }
}
