package ar.edu.undef.fie.api.Relog.model.response;

import ar.edu.undef.fie.api.Relog.model.entity.Solicitud;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;


@Data @Builder
public class RequerimientoResponse {

    private Long id;

    private Long organizacion;

    private LocalDateTime fechaDeEntregaRequerida;

    private List<Solicitud> solicitudes;

    private Boolean confirmado;

}
