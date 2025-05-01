package Dam.Classes;

import Dam.Main.App;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

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

    public static List<Trabajador> cargarTrabajadores() {
        InputStream leer = App.class.getClassLoader().getResourceAsStream("trabajadores.txt");
        List<Trabajador> lista = new ArrayList<>();
        Trabajador t = null;
        BufferedReader reader = null;
        String linea;
        String[] campos;
        String tipo, user, password, nombre, apellidos;
        int codTrabajador, tarifa, anyosExp;
        String especializacion, rango, email;

        try {
            if (leer == null) {
                throw new IOException("Archivo no encontrado");
            }
            reader = new BufferedReader(new InputStreamReader(leer, StandardCharsets.UTF_8));

            while ((linea = reader.readLine()) != null) {
                if (!linea.isBlank()) {
                    campos = linea.split(";");
                    tipo = campos[0].trim();
                    codTrabajador = Integer.parseInt(campos[1].trim());
                    user = campos[2].trim();
                    password = campos[3].trim();
                    nombre = campos[4].trim();
                    apellidos = campos[5].trim();

                    switch (tipo) {
                        case "Pintor":
                            especializacion = campos[6].trim();
                            tarifa = Integer.parseInt(campos[7].trim());
                            t = new Pintor(codTrabajador, user, password, nombre, apellidos, especializacion, tarifa);
                            break;

                        case "Albanyil":
                            especializacion = campos[6].trim();
                            rango = campos[7].trim();
                            anyosExp = Integer.parseInt(campos[8].trim());
                            t = new Albanyil(codTrabajador, user, password, nombre, apellidos,
                                    especializacion, rango, anyosExp);
                            break;

                        case "Administrador":
                            email = campos[6].trim();
                            t = new Administrador(codTrabajador, user, password, nombre, apellidos, email);
                            break;
                    }

                    lista.add(t);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }

        return lista;
    }

    @Override
    public String toString() {
        return "Trabajador{" +
                "codTrabajador=" + codTrabajador +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                '}';
    }
}
