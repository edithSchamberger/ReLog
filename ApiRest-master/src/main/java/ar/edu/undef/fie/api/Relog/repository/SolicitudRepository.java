package ar.edu.undef.fie.api.Relog.repository;

import ar.edu.undef.fie.api.Relog.model.entity.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
}
