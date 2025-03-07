package co.edu.uniandes.dse.parcial1.services;

import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import java.util.Date;
import co.edu.uniandes.dse.parcial1.entities.ConciertoEntity;

@Slf4j
@Service
public class ConciertoService {

    public ConciertoEntity crearConcierto(ConciertoEntity concierto) throws Exception {
        if (concierto.getFecha_para_el_concierto().before(new Date())) {
            throw new Exception("La fecha del concierto no es Valida.");
        }

        if (concierto.getPresupuesto() <= 1000) {
            throw new Exception("El presupuesto del concierto debe ser superior a 1000 dólares.");
        }

        if (concierto.getCapacidad_maxima_de_aforo() <= 10) {
            throw new Exception("La capacidad del concierto debe ser superior a 10 personas.");
        }

        return concierto;
        
    }
}
