package co.edu.uniandes.dse.parcial1.services;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.edu.uniandes.dse.parcial1.entities.EstadioEntity;

@SpringBootTest
public class EstadioServiceTest {

    @Autowired
    private EstadioService estadioService;

    @Test
    public void testCrearEstadioExitoso() throws Exception {
        EstadioEntity estadio = new EstadioEntity();
        estadio.setNombre("Estadio de Prueba");
        estadio.setPrecioAlquiler(200000L);
        estadio.setNombre_de_la_ciudad("Ciudad");
        estadio.setCapacidad_maxima_estadio(5000);

        EstadioEntity result = estadioService.crearEstadio(estadio);
        assertNotNull(result);
    }

    @Test
    public void testCrearEstadioNombreCiudadInvalido() {
        EstadioEntity estadio = new EstadioEntity();
        estadio.setNombre("Estadio de Prueba");
        estadio.setPrecioAlquiler(200000L);
        estadio.setNombre_de_la_ciudad("Ci");
        estadio.setCapacidad_maxima_estadio(5000);

        assertThrows(Exception.class, () -> {
            estadioService.crearEstadio(estadio);
        });
    }
}
