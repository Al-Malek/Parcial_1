package co.edu.uniandes.dse.parcial1.services;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Calendar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.edu.uniandes.dse.parcial1.entities.ConciertoEntity;
import co.edu.uniandes.dse.parcial1.entities.EstadioEntity;

@SpringBootTest
public class ConciertoEstadioServiceTest {

    @Autowired
    private ConciertoEstadioService conciertoEstadioService;

    @Test
    public void testAsociarConciertoAEstadioExitoso() throws Exception {
        EstadioEntity estadio = new EstadioEntity();
        estadio.setNombre("Estadio de Prueba");
        estadio.setPrecioAlquiler(200000L);
        estadio.setNombre_de_la_ciudad("Ciudad");
        estadio.setCapacidad_maxima_estadio(5000);

        ConciertoEntity concierto = new ConciertoEntity();
        concierto.setNombre("Concierto de Prueba");
        concierto.setPresupuesto(200000L);
        concierto.setNombre_del_artista("Artista de Prueba");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 5);
        concierto.setFecha_para_el_concierto(calendar.getTime());
        concierto.setCapacidad_maxima_de_aforo(3000);

        conciertoEstadioService.asociarConciertoAEstadio(concierto, estadio);
        assertNotNull(concierto.getEstadio());
    }

    @Test
    public void testAsociarConciertoAEstadioNoExiste() {
        ConciertoEntity concierto = new ConciertoEntity();
        concierto.setNombre("Concierto de Prueba");
        concierto.setPresupuesto(200000L);
        concierto.setNombre_del_artista("Artista de Prueba");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 5);
        concierto.setFecha_para_el_concierto(calendar.getTime());
        concierto.setCapacidad_maxima_de_aforo(3000);

        assertThrows(Exception.class, () -> {
            conciertoEstadioService.asociarConciertoAEstadio(concierto, null);
        });
    }

    @Test
    public void testAsociarConciertoNoExisteAEstadio() {
        EstadioEntity estadio = new EstadioEntity();
        estadio.setNombre("Estadio de Prueba");
        estadio.setPrecioAlquiler(200000L);
        estadio.setNombre_de_la_ciudad("Ciudad");
        estadio.setCapacidad_maxima_estadio(5000);

        assertThrows(Exception.class, () -> {
            conciertoEstadioService.asociarConciertoAEstadio(null, estadio);
        });
    }

    @Test
    public void testAsociarConciertoAEstadioViolacionReglaFechas() throws Exception {
        EstadioEntity estadio = new EstadioEntity();
        estadio.setNombre("Estadio de Prueba");
        estadio.setPrecioAlquiler(200000L);
        estadio.setNombre_de_la_ciudad("Ciudad");
        estadio.setCapacidad_maxima_estadio(5000);

        ConciertoEntity concierto1 = new ConciertoEntity();
        concierto1.setNombre("Concierto de Prueba 1");
        concierto1.setPresupuesto(200000L);
        concierto1.setNombre_del_artista("Artista de Prueba 1");
        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.DAY_OF_YEAR, 5);
        concierto1.setFecha_para_el_concierto(calendar1.getTime());
        concierto1.setCapacidad_maxima_de_aforo(3000);

        ConciertoEntity concierto2 = new ConciertoEntity();
        concierto2.setNombre("Concierto de Prueba 2");
        concierto2.setPresupuesto(200000L);
        concierto2.setNombre_del_artista("Artista de Prueba 2");
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(Calendar.DAY_OF_YEAR, 6);
        concierto2.setFecha_para_el_concierto(calendar2.getTime());
        concierto2.setCapacidad_maxima_de_aforo(3000);

        conciertoEstadioService.asociarConciertoAEstadio(concierto1, estadio);

        assertThrows(Exception.class, () -> {
            conciertoEstadioService.asociarConciertoAEstadio(concierto2, estadio);
        });
    }
}
