package Dam.Classes;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

/*Clase Cliente en esta clase tendremos la lectura de ficheros para recoger
 los clientes creados con anterioridad aparte de declarar todas sus variables*/
public class Cliente
{
    protected String nombre;
    protected String apellidos;
    protected String telefono;
    protected Date fechaNacimiento;
    protected Direccion direccion;
    protected String user;
    protected String password;

    public Cliente(String nombre, String apellidos, String telefono,
                   Date fechaNacimiento, Direccion direccion, String user,
                   String password)
    {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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

    public static Cliente SelecionarCliente(List<Cliente> clientes)
    {
        Scanner sc = new Scanner(System.in);
        Cliente cliente = null;

        for(int i = 0; i < clientes.size(); i++)
        {
            System.out.println((i + 1) + "." + clientes.toString());
        }

        System.out.print("Ingrese el cliente: ");
        cliente = clientes.get(sc.nextInt());

        return cliente;
    }

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", user='" + user + '\'';
    }
}
