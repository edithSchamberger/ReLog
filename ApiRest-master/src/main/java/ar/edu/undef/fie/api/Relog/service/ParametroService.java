package ar.edu.undef.fie.api.Relog.service;

import ar.edu.undef.fie.api.Relog.model.entity.inicio.Parametro;
import ar.edu.undef.fie.api.Relog.model.entity.inicio.Usuario;

public interface ParametroService {
    Parametro getParametros(Long idUser);
    Parametro modificarParametros(Parametro parametroRequest);
    void crearParametros(Usuario usuario);

}
