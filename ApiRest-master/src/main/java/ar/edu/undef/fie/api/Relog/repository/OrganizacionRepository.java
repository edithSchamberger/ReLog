package ar.edu.undef.fie.api.Relog.repository;

import ar.edu.undef.fie.api.Relog.model.entity.Organizacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizacionRepository extends JpaRepository<Organizacion, Long> {
    Organizacion findByNombre(String nombre);
}
