package Dam;

import Dam.Classes.Cliente;
import Dam.Classes.Direccion;
import Dam.Classes.Pintor;
import Dam.Classes.Trabajador;
import Dam.Main.App;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    public void testCrearPintor() {
        Pintor p = new Pintor(1, "user", "pass", "Juan", "Pérez", "In", 50);
        assertEquals("Juan", p.getNombre());
        assertEquals("In", p.getEspecializacion());
        assertEquals(50, p.getTarifa());
    }

    @Test
    public void testComparacionUsuarioYPassword() {
        Trabajador t = new Pintor(1, "usuario", "pass", "Ana", "L", "Ex", 40);
        assertEquals("usuario", t.getUser());
        assertEquals("pass", t.getPassword());
    }

    @Test
    void testCargarClientes() {
        try {
            Cliente.cargarClientes();
        } catch (Exception e) {
            fail("Se lanzó una excepción al cargar los clientes:");
        }

        List<Cliente> clientes = Cliente.cargarClientes();

        assertNotNull(clientes);

        Cliente cl = clientes.get(0);
        assertNotNull(cl.getUser());
        assertNotNull(cl.getDireccion());
        assertFalse(cl.getNombre().isBlank());
        assertNotNull(cl.getTelefono());

        for (Cliente c : clientes) {
            assertNotNull(c.getDireccion().getCiudad());
        }
    }

    @Test
    void testSeleccionarCliente() {
        List<Cliente> lista = new ArrayList<>();
        lista.add(new Cliente("Ana", "Lopez", "123456789",
                new Direccion("Ca", "123", "2", "Madrid"),
                "ana", "123"));

        lista.add(new Cliente("Luis", "Marti", "987654321",
                new Direccion("A", "45", "28", "Barcelona"),
                "luis", "456"));

        Cliente seleccionado = lista.get(1);

        assertNotNull(seleccionado);

        assertEquals("Luis", seleccionado.getNombre());

        assertEquals("Barcelona", seleccionado.getDireccion().getCiudad());
    }
}