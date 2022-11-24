package ar.edu.undef.fie.api.Relog.service;

import ar.edu.undef.fie.api.Relog.model.entity.Organizacion;
import ar.edu.undef.fie.api.Relog.model.entity.inicio.Usuario;
import ar.edu.undef.fie.api.Relog.model.request.OrganizacionRequest;
import ar.edu.undef.fie.api.Relog.model.response.EfectoResponse;
import ar.edu.undef.fie.api.Relog.model.response.MovimientoSimpleResponse;
import ar.edu.undef.fie.api.Relog.model.response.OrganizacionResponse;

import java.util.List;
import java.util.Optional;

public interface OrganizacionService {
    OrganizacionResponse create(OrganizacionRequest request);

    List<MovimientoSimpleResponse> getMovimientos(Long organizacion_id);

    List<EfectoResponse> getEfectos(Long organizacion_id);

    OrganizacionResponse getOrganizacionById(Long organizacion_id);
/*
    void eliminar(Organizacion organizacion);

    Organizacion findById(Long idUser);
*/
}
