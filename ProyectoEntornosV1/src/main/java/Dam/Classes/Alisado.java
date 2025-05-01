package Dam.Classes;

import java.util.ArrayList;
import java.util.List;
/*Clase hija Alisado en la cual se declaran los atributos del pintor asignado,
 los materiales usados y un */
public class Alisado extends Trabajo
{
    protected Pintor pintor;
    protected List<Albanyil> albanyiles;
    protected String materialesUsados;
    public Alisado(int codTrabajo, int metros2,
                   Presupuesto presupuestoAsignado, Administrador administrador,
                   Direccion direccionAsociada, Cliente clienteAsociado,
                   Pintor pintor, String materialesUsados)

    {
        super(codTrabajo,metros2,presupuestoAsignado,administrador,
            direccionAsociada,clienteAsociado);
        this.pintor = pintor;
        albanyiles= new ArrayList<>();
        this.materialesUsados=materialesUsados;
    }

    public Pintor getPintor() {
        return pintor;
    }

    public void setPintor(Pintor pintor) {
        this.pintor = pintor;
    }

    public String getMaterialesUsados() {
        return materialesUsados;
    }

    public void setMaterialesUsados(String materialesUsados) {
        this.materialesUsados = materialesUsados;
    }
}
