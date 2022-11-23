package ar.edu.undef.fie.api.Relog.service;

import ar.edu.undef.fie.api.Relog.model.request.MovimientoRequest;
import ar.edu.undef.fie.api.Relog.model.response.MovimientoResponse;

public interface MovimientoService {

    MovimientoResponse generarMovimiento(MovimientoRequest request , Long tipo);
}
