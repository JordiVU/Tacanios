package Dam.Classes;

import java.util.Scanner;

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
        return "Administrador{" +
                ", emailContacto='" + emailContacto + '\'' +
                '}';
    }
}
