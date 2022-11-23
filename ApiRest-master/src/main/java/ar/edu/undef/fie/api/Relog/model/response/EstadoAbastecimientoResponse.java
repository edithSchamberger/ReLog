package ar.edu.undef.fie.api.Relog.model.response;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class EstadoAbastecimientoResponse {

    private Long estadoId;

    private Integer cantidadNecesaria;

    private EfectoResponse efecto;

}
