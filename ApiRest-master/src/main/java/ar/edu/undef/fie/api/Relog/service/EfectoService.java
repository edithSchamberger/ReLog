package ar.edu.undef.fie.api.Relog.service;

import ar.edu.undef.fie.api.Relog.model.entity.clase.Clase;
import ar.edu.undef.fie.api.Relog.model.request.EfectoRequest;
import ar.edu.undef.fie.api.Relog.model.response.EfectoResponse;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface EfectoService {
    EfectoResponse create(EfectoRequest request);

    Clase seleccionarClase(Optional<Clase> claseFromRepo);
}
