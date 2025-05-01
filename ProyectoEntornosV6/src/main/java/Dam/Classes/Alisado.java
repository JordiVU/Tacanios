package Dam.Classes;

import java.util.ArrayList;
import java.util.List;
/*Clase hija de Trabajo en la cual se declaran los atributos del pintor asignado,
 los materiales usados y un */
public class Alisado extends Trabajo
{
    protected Pintor pintor;
    protected List<Albanyil> albanyiles;
    protected String materialesUsados;

    public Alisado(int codTrabajo, int metros2,
                   Presupuesto presupuestoAsignado,
                   Direccion direccionAsociada, Cliente clienteAsociado,
                   Pintor pintor, List<Albanyil> albanyiles, String materialesUsados)
    {
        super(codTrabajo,metros2,presupuestoAsignado,
                direccionAsociada,clienteAsociado);
        this.pintor = pintor;
        this.albanyiles = albanyiles;
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

    @Override
    public String toString() {
        return super.toString() + " | " + materialesUsados + " materiales usados | Pintor: " + pintor;
    }
}
