package co.edu.uniandes.dse.parcial1.services;

import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import co.edu.uniandes.dse.parcial1.entities.ConciertoEntity;
import co.edu.uniandes.dse.parcial1.entities.EstadioEntity;

@Slf4j
@Service
public class ConciertoEstadioService {

    public void asociarConciertoAEstadio(ConciertoEntity concierto, EstadioEntity estadio) throws Exception {
        if (concierto.getCapacidad_maxima_de_aforo() > estadio.getCapacidad_maxima_estadio()) {
            throw new Exception("La capacidad del concierto no puede superar la capacidad del estadio.");
        }

        if (estadio.getPrecioAlquiler() > concierto.getPresupuesto()) {
            throw new Exception("El precio de alquiler del estadio no puede superar el presupuesto del concierto.");
        }

        List<ConciertoEntity> conciertos = estadio.getConciertos();
        for (ConciertoEntity c : conciertos) {
            LocalDateTime fechaConciertoActual = c.getFecha_para_el_concierto().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            LocalDateTime fechaConciertoNuevo = concierto.getFecha_para_el_concierto().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            Duration duracion = Duration.between(fechaConciertoActual, fechaConciertoNuevo);
            if (Math.abs(duracion.toDays()) < 2) {
                throw new Exception("Debe existir un tiempo mínimo de 2 días entre los conciertos asociados a un estadio.");
            }
        }

        concierto.setEstadio(estadio);
        conciertos.add(concierto);
        estadio.setConciertos(conciertos);
    }
}
