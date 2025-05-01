package Dam.Classes;
import java.util.*;

/*Clase Direccion nos servira para la clase cliente, la clase trabajo y sus
 subtipos aparte de en prespuesto especificar en que parte estara la obra
 se declara en este apartado para que este dentro del mismo namespace y
 se pueda llamar en todas las clases.*/
public class Direccion
{
    protected String calle;
    protected String numero;
    protected String codPostal;
    protected String ciudad;

    public Direccion(String calle, String numero, String codPostal,
                     String ciudad)
    {
        this.calle = calle;
        this.numero = numero;
        this.codPostal = codPostal;
        this.ciudad = ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Metodo el cual estara relacionado con la creacion de clientes ya que
     * cada cliente tiene una dirección asociada.
     * @return
     */
    public static Direccion CrearDireccion()
    {
        Scanner sc = new Scanner(System.in);
        String calle="", numero="", codPostal="", ciudad="";
        boolean correcto;

        do {
            try {
                correcto = true;
                System.out.print("Introduce tu calle:");
                calle = sc.nextLine();
                if (calle.isEmpty()) {
                    throw new Exception("ERROR: La calle no puede estar vacia.");
                }
                System.out.print("Introduce tu numero: ");
                numero = sc.nextLine();
                if (calle.isEmpty()) {
                    throw new Exception("ERROR: El numero no puede estar vacio.");
                }
                System.out.print("Introduce tu código postal: ");
                codPostal = sc.nextLine();
                if (calle.isEmpty()) {
                    throw new Exception("ERROR: El codigo postal no puede estar vacio.");
                }
                System.out.print("Introduce tu ciudad: ");
                ciudad = sc.nextLine();
                if (calle.isEmpty()) {
                    throw new Exception("ERROR: La ciudad no puede estar vacia.");
                }
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                correcto = false;
            }
        }
        while (!correcto);

        return new Direccion(calle, numero, codPostal, ciudad);
    }

    @Override
    public String toString() {
        return "Direccion[" + calle + " " + numero + "º , " + ciudad + " - " + codPostal + "] ";
    }
}
