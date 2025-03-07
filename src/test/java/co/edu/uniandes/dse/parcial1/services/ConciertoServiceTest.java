package co.edu.uniandes.dse.parcial1.services;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.Calendar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.edu.uniandes.dse.parcial1.entities.ConciertoEntity;

@SpringBootTest
public class ConciertoServiceTest {

    @Autowired
    private ConciertoService conciertoService;

    @Test
    public void testCrearConciertoExitoso() throws Exception {
        ConciertoEntity concierto = new ConciertoEntity();
        concierto.setNombre("Concierto de Prueba");
        concierto.setPresupuesto(2000L);
        concierto.setNombre_del_artista("Artista de Prueba");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 5);
        concierto.setFecha_para_el_concierto(calendar.getTime());
        concierto.setCapacidad_maxima_de_aforo(50);

        ConciertoEntity result = conciertoService.crearConcierto(concierto);
        assertNotNull(result);
    }

    @Test
    public void testCrearConciertoFechaPasada() {
        ConciertoEntity concierto = new ConciertoEntity();
        concierto.setNombre("Concierto de Prueba");
        concierto.setPresupuesto(2000L);
        concierto.setNombre_del_artista("Artista de Prueba");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -5);
        concierto.setFecha_para_el_concierto(calendar.getTime());
        concierto.setCapacidad_maxima_de_aforo(50);

        assertThrows(Exception.class, () -> {
            conciertoService.crearConcierto(concierto);
        });
    }

    @Test
    public void testCrearConciertoCapacidadInvalida() {
        ConciertoEntity concierto = new ConciertoEntity();
        concierto.setNombre("Concierto de Prueba");
        concierto.setPresupuesto(2000L);
        concierto.setNombre_del_artista("Artista de Prueba");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 5);
        concierto.setFecha_para_el_concierto(calendar.getTime());
        concierto.setCapacidad_maxima_de_aforo(5);

        assertThrows(Exception.class, () -> {
            conciertoService.crearConcierto(concierto);
        });
    }

    @Test
    public void testCrearConciertoPresupuestoInvalido() {
        ConciertoEntity concierto = new ConciertoEntity();
        concierto.setNombre("Concierto de Prueba");
        concierto.setPresupuesto(500L);
        concierto.setNombre_del_artista("Artista de Prueba");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 5);
        concierto.setFecha_para_el_concierto(calendar.getTime());
        concierto.setCapacidad_maxima_de_aforo(50);

        assertThrows(Exception.class, () -> {
            conciertoService.crearConcierto(concierto);
        });
    }
}
