package Dam.Classes;
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import java.util.*;
/*Clase padre Trabajador la cual tendra varios hijos y tendra los atributos
 * que compartan todos los hijos.*/
public abstract class Trabajador
{
    protected int codTrabajador;
    protected String user;
    protected String password;
    protected String nombre;
    protected String apellidos;

    public Trabajador(int codTrabajador, String user, String password,
                      String nombre, String apellidos)
    {
        this.codTrabajador = codTrabajador;
        this.user = user;
        this.password = password;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public int getCodTrabajador() {
        return codTrabajador;
    }

    public void setCodTrabajador(int codTrabajador) {
        this.codTrabajador = codTrabajador;
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

    public static Trabajador CrearTrabajador()
    {
        Scanner sc = new Scanner(System.in);

        Trabajador nuevo = null;
        String user, password, nombre, apellidos, specializacion, rango, email;
        int codTrabajador, tipo, tarifa, anyosExp;

        System.out.println("1. Pintor/ 2.Albanyil/ 3.Administrador");
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

        switch(tipo) {
            case 1:
                System.out.print("Tarifa: ");
                tarifa = sc.nextInt();
                System.out.print("Especializacion: ");
                specializacion = sc.nextLine();

                nuevo = new Pintor(codTrabajador, user, password, nombre, apellidos, specializacion, tarifa);
                break;
            case 2:
                System.out.print("Especializacion: ");
                specializacion = sc.nextLine();
                System.out.print("Rango: ");
                rango = sc.nextLine();
                System.out.print("Años experiencia: ");
                anyosExp = sc.nextInt();

                nuevo = new Albanyil(codTrabajador, user, password, nombre, apellidos, specializacion, rango, anyosExp);
                break;
            case 3:
                System.out.print("Email de contacto: ");
                email = sc.nextLine();

                nuevo = new Administrador(codTrabajador, user, password, nombre, apellidos, email);
                break;
        }

        return nuevo;
    }

    @Override
    public String toString() {
        return "codTrabajador: " + codTrabajador +
                ", nombre : " + nombre + " " + apellidos;
    }
}
