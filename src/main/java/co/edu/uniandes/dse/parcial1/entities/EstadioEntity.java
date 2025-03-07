package co.edu.uniandes.dse.parcial1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class EstadioEntity extends BaseEntity {

    private String nombre; /*No se especifica si este nombre es el de la ciudad, por eso no lo use profesor.*/
    private Long precioAlquiler;
    private String nombre_de_la_ciudad;
    private int capacidad_maxima_estadio;

    @OneToMany(mappedBy = "estadio")
    private List<ConciertoEntity> conciertos;
}
