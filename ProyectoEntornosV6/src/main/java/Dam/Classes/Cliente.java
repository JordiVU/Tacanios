package Dam.Classes;

import Dam.Main.App;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*Clase Cliente en esta clase tendremos la lectura de ficheros para recoger
 los clientes creados con anterioridad aparte de declarar todas sus variables*/
public class Cliente
{
    protected String nombre;
    protected String apellidos;
    protected String telefono;
    protected Direccion direccion;
    protected String user;
    protected String password;

    public Cliente(String nombre, String apellidos, String telefono,
                    Direccion direccion, String user,
                   String password)
    {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
        this.user = user;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Metodo el cual servira para devolver un cliente seleccionado primero
     * se le mostraran los clientes actuales y luego se le solicitara que elija
     * uno de estos para luego devolver el que elija.
     * @param clientes
     * @return
     */
    public static Cliente SelecionarCliente(List<Cliente> clientes)
    {
        Scanner sc = new Scanner(System.in);
        Cliente cliente = null;

        App.MostrarClientes(clientes);

        System.out.print("Ingrese el cliente: ");
        cliente = clientes.get(sc.nextInt());

        return cliente;
    }

    /**
     * Metodo directamente relacionado con la gestion de archivos el cual
     * sirve para leer los clientes previos desde un archivo txt, este metodo
     * devolvera una lista de clientes la cual se usara en el main para
     * cualquier cambio.
     * @return
     */
    public static List<Cliente> cargarClientes() {
        InputStream leer = App.class.getClassLoader().getResourceAsStream("clientes.txt");
        List<Cliente> lista = new ArrayList<>();
        Cliente cliente = null;
        BufferedReader reader = null;
        String linea;
        String[] campos;

        try {
            if (leer == null) {
                throw new IOException("Archivo no encontrado");
            }

            reader = new BufferedReader(new InputStreamReader(leer, StandardCharsets.UTF_8));

            while ((linea = reader.readLine()) != null) {
                if (!linea.isBlank()) {
                    campos = linea.split(";");
                    String user = campos[0].trim();
                    String password = campos[1].trim();
                    String nombre = campos[2].trim();
                    String apellidos = campos[3].trim();
                    String telefono = campos[4].trim();

                    String calle = campos[6].trim();
                    String numero = campos[7].trim();
                    String codPostal = campos[8].trim();
                    String ciudad = campos[9].trim();
                    Direccion direccion = new Direccion(calle, numero, codPostal, ciudad);

                    cliente = new Cliente(nombre, apellidos, telefono, direccion, user, password);
                    lista.add(cliente);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo");
        }

        return lista;
    }

    @Override
    public String toString() {
        return user + " | " + nombre + " " + apellidos + " | " + telefono + " tlf | " + direccion;
    }
}
