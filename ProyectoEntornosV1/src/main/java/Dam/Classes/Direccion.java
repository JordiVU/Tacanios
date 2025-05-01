package Dam.Classes;
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

    @Override
    public String toString() {
        return "Direccion{" +
                "calle='" + calle + '\'' +
                ", numero='" + numero + '\'' +
                ", codPostal='" + codPostal + '\'' +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}
