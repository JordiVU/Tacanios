package Dam.Main;

import Dam.Classes.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.*;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App
{
    public enum MenuOpcion { SALIR, CREAR, MODIFICAR, ELIMINAR, CONSULTAR}
    public enum MenuCliente { SALIR, PERFIL, TRABAJO}
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    static Scanner sc= new Scanner(System.in);

    /**
     * Metodo el cual servira para que el cliente inicie sesion,
     * para ello se le solicitaran su user y su contraseña para luego
     * comprobar que existe dentro de la lista de clientes la cual se
     * pasara como parametro.
     * @param clientes
     * @return
     * @throws Exception
     */
    public static Cliente Login(List<Cliente> clientes) {
        String user, password;
        Cliente cliente = null;
        boolean correcto;

        try {
            correcto = true;
            sc.nextLine();
            System.out.println("Bienvenido de nuevo, porfavor introduce" +
                    "tus credenciales.");
            System.out.print("User: ");
            user = sc.nextLine();
            if (user.equals(" ")) {
                throw new Exception("ERROR: user vacio");
            }
            System.out.print("Password: ");
            password = sc.nextLine();
            if (password.equals(" ")) {
                throw new Exception("ERROR: Password vacia");
            }

            for (int i = 0; i < clientes.size(); i++) {
                if (Objects.equals(clientes.get(i).getUser(), user) &&
                        Objects.equals(clientes.get(i).getPassword(), password)) {
                    cliente = clientes.get(i);
                }
            }
            if (cliente != null) {
                return cliente;
            } else {
                throw new Exception("ERROR: Usuario no encontrado.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return cliente;
    }

    /**
     *  Metodo que nos sirve para crear un nuevo cliente el cual tendra que
     *  añadir sus datos para que se puedan añadir a la lista de clientes
     *  la cual se pasara como parametro para si todo funciona añadir el nuevo
     *  cliente.
     * @param clientes
     * @return
     */
    public static Cliente SignUp(List<Cliente> clientes)
    {
        Cliente clienteActual = null;
        String nombre="",apellidos="",telefono="",user="",password;
        Direccion direccion= null;
        Pattern valPasCaracter = Pattern.compile("\\D{6,}");
        Pattern valPasNum = Pattern.compile("\\d{2,}");
        Pattern valPasEspecial = Pattern.compile("\\W+");
        boolean correcto;

        System.out.println("Bienvenido, a continuacion te pediremos" +
                "tus datos para crear tu cuenta.");
        sc.nextLine();
        do {
            try {
                correcto = true;
                System.out.print("Introduce tu nombre: ");
                nombre = sc.nextLine();
                if (nombre.isEmpty()) {
                    throw new Exception("ERROR: El nombre no puede estar vacio.");
                }
                System.out.print("Introduce tu apellidos: ");
                apellidos = sc.nextLine();
                if (apellidos.isEmpty()) {
                    throw new Exception("ERROR: El apellido no puede estar vacio.");
                }
                System.out.print("Introduce tu telefono: ");
                telefono = sc.nextLine();
                if (telefono.isEmpty()) {
                    throw new Exception("ERROR: El telefono no puede estar vacio.");
                }
                System.out.print("Introduce tu user: ");
                user = sc.nextLine();
                if (user.isEmpty()) {
                    throw new Exception("ERROR: El user no puede estar vacio.");
                }
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                correcto = false;
            }
        }
        while (!correcto);
        do {
            correcto = true;
            System.out.print("Introduce tu contraseña: ");
            password = sc.nextLine();
            Matcher m = valPasCaracter.matcher(password);
            Matcher m2 = valPasNum.matcher(password);
            Matcher m3 = valPasEspecial.matcher(password);
            if (!m.find() || !m2.find() || !m3.find())
            {
                System.out.println("ERROR: La contraseña tiene que tener al menos 6 caracteres, 2 digitos " +
                        "y un caracter especial.");
                correcto = false;
            }
            else
            {
                direccion = Direccion.CrearDireccion();
                clienteActual = new Cliente(nombre, apellidos, telefono, direccion, user, password);
                clientes.add(clienteActual);
            }
        }
        while (!correcto);

        return clienteActual;
    }

    /**
     * Metodo para que el trabajador inicie sesión para eso se le solicitara
     * su user y su contraseña a diferencia del anterior en este se compara con
     * la lista de trabajadores por eso no se puede unificar
     * @param trabajadores
     * @return
     * @throws Exception
     */
    public static Trabajador LoginTrabajadores(List<Trabajador> trabajadores) {
        boolean correcto;
        String user, password;
        Trabajador trabajadorActual = null;

        do {
            correcto = true;
            try {
                sc.nextLine();
                System.out.println("Bienvenido de nuevo, dinos tus credenciales por favor.");
                System.out.print("User: ");
                user = sc.nextLine();
                System.out.print("Password: ");
                password = sc.nextLine();

                for (int i = 0; i < trabajadores.size(); i++) {
                    if (Objects.equals(trabajadores.get(i).getUser(), user) &&
                            Objects.equals(trabajadores.get(i).getPassword(), password)) {
                        trabajadorActual = trabajadores.get(i);
                    }
                }
                if (trabajadorActual != null) {
                    return trabajadorActual;
                } else {
                    throw new Exception("ERROR: Trabajador no encontrado");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                correcto = false;
            }
        }
        while (!correcto);

        return trabajadorActual;
    }

    /**
     * Metodo que muestra el menu inicial el cual devolvera un int que
     * usaremos en el main para seleccionar que quiere hacer la persona.
     * @return
     */
    public static int MenuInicial()
    {
        int opcionSeleccionada;

        System.out.println("--INICIO--");
        System.out.println("1- Trabajador");
        System.out.println("2- Cliente");
        System.out.println("0- Salir ");
        System.out.print("Opcion: ");

        opcionSeleccionada = sc.nextInt();

        if(opcionSeleccionada > 3 || opcionSeleccionada < 0)
            throw new IllegalArgumentException("Opcion no valida");

        return opcionSeleccionada;
    }

    /**
     * Metodo el cual sirve para tras el inicio de sesion del trabajador
     * se le pregunte que quiere hacer dentro de las opciones que tiene.
     * @return
     */
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

    /**
     * Metodo que como el anterior sirve para mostrar el menu del administrador
     * el cual tendra unas funciones diferentes que la de los trabajadores como
     * son crear, modificar, eliminar, salir.
     * @return
     */
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

    /**
     * Metodo el cual mostrara el menu principal de los clientes en el cual se
     * devolvera un atributo MenuCliente el cual se enviara a la siguiente
     * funcion para que se ejecute la opcion del cliente.
     * @return
     */
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

    /**
     * Metodo el cual mostrara por pantalla la lista de clientes
     * actuales para ello se usara un bucle el for que usara como
     * finalizador la lista clientes la cual se pasara como parametro.
     * @param clientes
     */
    public static void MostrarClientes(List<Cliente> clientes)
    {
        for(int i = 0; i < clientes.size(); i++)
        {
            System.out.println(i + 1 + "- " + clientes.get(i));
        }
    }

    /**
     * Metodo el cual mostrara los presupuestos actuales asociados a un
     * trabajo para ellos necesitaremos pasar como parametro la lista de
     * trabajos en este caso se usara un bucle for.
     * @param trabajos
     */
    public static void MostrarPresupuestos(List<Trabajo> trabajos)
    {
        for(int i = 0; i < trabajos.size(); i++)
        {
            System.out.println(trabajos.get(i).getPresupuestoAsignado());
        }
    }

    /**
     * Metodo el cual muestra los trabajos actuales los cuales estan
     * asociados a un cliente el cual se pasara como paramateros asi como
     * la lista de trabajos actuales.
     *
     * @param trabajos
     * @param cliente
     */
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

    /**
     * Metodo que sirve para mostrar los trabajdores actuales, en este
     * metodo tenemos como parametros la lista de trabajadores y como resultado
     * los trabajadores se mostraran con diferentes colores dependiendo de que
     * tipo de trabajador sea.
     * @param trabajadores
     */
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

    /**
     * Metodo que usa el trabajador para elegir sus diferentes acciones
     * con diferentes opciones.
     * @param trabajos
     * @param clientes
     * @param trabajadores
     */
    public static void opcionesConsultar(List<Trabajo> trabajos, List<Cliente> clientes,
                                         List<Trabajador> trabajadores)
    {
        int opcionConsulta;
        System.out.println("1- Clientes");
        System.out.println("2- Presupuestos");
        System.out.println("3- Trabajos");
        System.out.println("4- Trabajadores");
        System.out.println("5- ATRAS");
        System.out.print("Opcion: ");
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
        else
        {
            throw new IllegalArgumentException("ERROR: Opcion fuera de los " +
                    "indices admitidos.");
        }
    }

    /**
     * Metodo el cual sera usado por los trabajadores para seleccionar una de
     * las opciones de su menu entre estas están: crear un trabajo, consultar
     * sus trabajos, modificar uno de sus trabajos actuales y o eliminar uno
     * de estos, para ello se pasaran como parametros la lista de trabajos,
     * clientes y trabajadores.
     * @param trabajos
     * @param clientes
     * @param trabajadores
     */
    public static void SeleccionarOpcionTrabajador(List<Trabajo> trabajos, List<Cliente> clientes,
                                                   List<Trabajador> trabajadores)
    {
        MenuOpcion opcionSeleccionada;

        do
        {
            opcionSeleccionada = MenuOpcionesTrabajador();
            try {
                switch (opcionSeleccionada) {
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
                    default:
                        throw new IllegalArgumentException("ERROR: Opción del menu fuera del indice");
                }
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }while(opcionSeleccionada != MenuOpcion.SALIR);
    }

    /**
     * Metodo el cual sirve para que el administrador elija una de sus opciones
     * del menu entre estas esta el crear un nuevo trabajador, modificar un
     * o trabajador, eliminar un cliente o trabajador para ello se pasaran como
     * parametro la lista de clientes y la de trabajadores.
     * @param clientes
     * @param trabajadores
     */
    public static void SeleccionarOpcionAdmin(List<Cliente> clientes, List<Trabajador> trabajadores)
    {
        MenuOpcion opcionSeleccionada;
        do
        {
            opcionSeleccionada = MenuOpcionesAdministrador();
            try {
                switch (opcionSeleccionada) {
                    case CREAR:
                        Administrador.Crear(trabajadores);
                        break;
                    case MODIFICAR:
                        Administrador.Modificar(clientes, trabajadores);
                        break;
                    case ELIMINAR:
                        Administrador.Eliminar(clientes, trabajadores);
                        break;
                    default:
                        throw new IllegalArgumentException("ERROR: Opción de menu " +
                                "administradores fuera del indice");
                }
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }while(opcionSeleccionada != MenuOpcion.SALIR);
    }

    /**
     * Metodo que mediante un switch permite al usuari seleccionar una
     * de las opciones que tiene disponilbles entre estas se encuentra
     * mirar los datos de su perfil o mirar los trabajos que tiene actualmente
     * para ello se pasa como parametro la lista de trabajos y el cliente al
     * que se le asocia la busqueda.
     * @param trabajos
     * @param cliente
     */
    public  static void SeleccionarOpcionCliente(List<Trabajo> trabajos, Cliente cliente)
    {
        MenuCliente opcionSeleccionada;
        do
        {
            opcionSeleccionada = MenuOpcionesCliente();
            try {
                switch (opcionSeleccionada) {
                    case PERFIL:
                        System.out.println(cliente.toString());
                        break;

                    case TRABAJO:
                        MostrarTrabajos(trabajos, cliente);
                        break;
                    default:
                        throw new IllegalArgumentException("ERROR: Opción del menu " +
                                "de clientes del indice");
                }
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
        while(opcionSeleccionada != MenuCliente.SALIR);
    }
    public static void main( String[] args )
    {
        boolean correcto;
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
                trabajadorActual = LoginTrabajadores(trabajadores);

                if (trabajadorActual != null) {
                    if (trabajadorActual instanceof Administrador) {
                        SeleccionarOpcionAdmin(clientes, trabajadores);
                    } else {
                        SeleccionarOpcionTrabajador(trabajos, clientes, trabajadores);
                    }
                } else {
                    System.out.println("ERROR: Trabajador no encontrado");
                    correcto = false;
                }
            }while (!correcto);
        } else if (opcionInicial == 2) {
            do {
                correcto = true;
                System.out.println("1- Login ");
                System.out.println("2- Sign Up");
                System.out.print("Selecciona login o sign up: ");

                opcionCuenta = sc.nextInt();

                if (opcionCuenta == 1) {
                    clienteActual = Login(clientes);

                    if (clienteActual != null) {
                        SeleccionarOpcionCliente(trabajos, clienteActual);
                    } else {
                        System.out.println("ERROR: Usuario no encontrado.");
                        correcto = false;
                    }
                } else if(opcionCuenta==2) {
                    clienteActual = SignUp(clientes);
                    SeleccionarOpcionCliente(trabajos, clienteActual);
                }
                else
                {
                    System.out.println("ERROR: Opcion seleccionada" +
                            "fuera de los indices");
                    correcto = false;
                }
            }while (!correcto);
        }
    }
}
