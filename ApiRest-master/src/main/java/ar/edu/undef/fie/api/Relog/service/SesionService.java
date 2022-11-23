package ar.edu.undef.fie.api.Relog.service;

import ar.edu.undef.fie.api.Relog.model.entity.inicio.Usuario;
import ar.edu.undef.fie.api.Relog.model.entity.inicio.Sesion;

public interface SesionService {

    Sesion getSesionActiva();
    void nuevaSesion(Usuario usuario);
    void cerrarSesion();

}

