package Dam;

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
}