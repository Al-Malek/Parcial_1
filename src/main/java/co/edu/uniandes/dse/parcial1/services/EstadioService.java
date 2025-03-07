package co.edu.uniandes.dse.parcial1.services;

import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import co.edu.uniandes.dse.parcial1.entities.EstadioEntity;

@Slf4j
@Service
public class EstadioService {

    public EstadioEntity crearEstadio(EstadioEntity estadio) throws Exception {
        if (estadio.getNombre_de_la_ciudad().length() < 3) {
            throw new Exception("El nombre de la ciudad no es valido."); 
        }

        if (estadio.getPrecioAlquiler() <= 100000) {
            throw new Exception("El precio de alquiler debe ser superior a 100.000 dólares.");
        }

        if (estadio.getCapacidad_maxima_estadio() <= 1000) {
            throw new Exception("La capacidad del estadio debe ser superior a 1.000 personas.");
        }

        return estadio;
    }
}
