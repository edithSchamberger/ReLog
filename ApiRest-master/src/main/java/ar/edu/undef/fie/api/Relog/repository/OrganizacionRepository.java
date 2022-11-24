package ar.edu.undef.fie.api.Relog.repository;

import ar.edu.undef.fie.api.Relog.model.entity.Organizacion;
import ar.edu.undef.fie.api.Relog.model.entity.inicio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

public interface OrganizacionRepository extends JpaRepository<Organizacion, Long> {
    Organizacion findByNombre(String nombre);
   // Organizacion findById (Long id);


}
