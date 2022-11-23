package ar.edu.undef.fie.api.Relog.repository;

import ar.edu.undef.fie.api.Relog.model.entity.inicio.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SesionRepository extends JpaRepository<Sesion, Integer> {
    Sesion findSesionByActiva(Boolean activa);
}
