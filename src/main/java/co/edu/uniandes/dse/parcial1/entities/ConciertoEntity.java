package co.edu.uniandes.dse.parcial1.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.util.Date;

@Data
@Entity
public class ConciertoEntity extends BaseEntity {

    private String nombre;
    private Long presupuesto;
    private String nombre_del_artista;
    private Date fecha_para_el_concierto; /* No se usar bien LocalDateTime.now() entonces uso date*/
    private int capacidad_maxima_de_aforo;

    @ManyToOne
    @JoinColumn(name = "id_estadio")
    private EstadioEntity estadio;
}
