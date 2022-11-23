package ar.edu.undef.fie.api.Relog.service;

import ar.edu.undef.fie.api.Relog.model.response.SolicitudResponse;
import ar.edu.undef.fie.api.Relog.model.request.SolicitudRequest;
import ar.edu.undef.fie.api.Relog.model.response.SolicitudDeRequerimientoResponse;

public interface SolicitudService {
    SolicitudResponse create(SolicitudRequest request);

    SolicitudDeRequerimientoResponse getSolicitud(Long id);
}
