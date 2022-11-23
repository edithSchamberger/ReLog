package ar.edu.undef.fie.api.Relog.repository;

import ar.edu.undef.fie.api.Relog.model.entity.inicio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    Usuario findByEmail(String email);

}

// ver si es Integer o Long