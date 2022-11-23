package ar.edu.undef.fie.api.Relog.service;

import ar.edu.undef.fie.api.Relog.model.request.RequerimientoRequest;
import ar.edu.undef.fie.api.Relog.model.response.RequerimientoResponse;
import ar.edu.undef.fie.api.Relog.model.response.SolicitudDeRequerimientoResponse;

import java.util.List;

public interface RequerimientoService {
    RequerimientoResponse create(RequerimientoRequest request);

    List<SolicitudDeRequerimientoResponse> getSolicitudes(Long requerimiento_id);

    String confirm(Long id);

    RequerimientoResponse getRequerimientoById(Long id);

    String agregarRequerimiento(Long requerimiento_id, Long organizacion_id);
}
